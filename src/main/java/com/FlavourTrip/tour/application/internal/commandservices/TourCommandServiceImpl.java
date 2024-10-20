package com.FlavourTrip.tour.application.internal.commandservices;

import com.FlavourTrip.tour.domain.model.commands.AddTourCommand;
import com.FlavourTrip.tour.domain.model.commands.DeleteTourCommand;
import com.FlavourTrip.tour.domain.model.commands.UpdateTourCommand;
import com.FlavourTrip.tour.domain.model.entities.Tour;
import com.FlavourTrip.tour.domain.services.TourCommandService;
import com.FlavourTrip.tour.infrastructure.persistence.jpa.repositories.TourRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TourCommandServiceImpl implements TourCommandService {
    private final TourRepository tourRepository;

    public TourCommandServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public Long handle(AddTourCommand command){
        Tour tour = new Tour(
                command.titleTour(),
                command.imageTour(),
                command.instructor(),
                command.rating(),
                command.nRatings(),
                command.minPrice(),
                command.currentPeople(),
                command.maxPeople(),
                command.language(),
                command.duration(),
                command.itemsIncluded(),
                command.date(),
                command.description(),
                command.times(),
                command.hours()
        );
        tourRepository.save(tour);
        return tour.getId();
    }

    @Override
    public Optional<Tour> handle(UpdateTourCommand command) {
        var result = tourRepository.findById(command.tourId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Tour does not exist");
        var tourToUpdate = result.get();

        try {
            var updatedTour = tourRepository.save(tourToUpdate.updatedInformation(command.titleTour(),
                    command.imageTour(),
                    command.instructor(),
                    command.rating(),
                    command.nRatings(),
                    command.minPrice(),
                    command.currentPeople(),
                    command.maxPeople(),
                    command.language(),
                    command.duration(),
                    command.itemsIncluded(),
                    command.date(),
                    command.description(),
                    command.times(),
                    command.hours()));
            return Optional.of(updatedTour);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating tour: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteTourCommand command){
        tourRepository.deleteById(command.tourId());
        System.out.println("Tour Delete");
    }
}
