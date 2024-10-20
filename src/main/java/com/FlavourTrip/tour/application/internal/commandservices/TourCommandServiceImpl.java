package com.FlavourTrip.tour.application.internal.commandservices;

import com.FlavourTrip.restaurant.domain.model.entities.Restaurant;
import com.FlavourTrip.restaurant.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import com.FlavourTrip.tour.domain.model.commands.AddRestaurantToTourCommand;
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

    private final RestaurantRepository restaurantRepository;

    public TourCommandServiceImpl(TourRepository tourRepository, RestaurantRepository restaurantRepository) {
        this.tourRepository = tourRepository;
        this.restaurantRepository = restaurantRepository;
    }
    @Override
    public Long handle(AddTourCommand command){
        Restaurant restaurantId = restaurantRepository.findById(command.restaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

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
                command.hours(),
                restaurantId
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

        Restaurant restaurantId = restaurantRepository.findById(command.restaurantId())
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

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
                    command.hours(),
                    restaurantId));
            return Optional.of(updatedTour);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating tour: " + e.getMessage());
        }
    }
    @Override
    public Long handle(AddRestaurantToTourCommand command) {
        Tour tour = tourRepository.findById(command.tourId())
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        Restaurant restaurantId = restaurantRepository.findById(command.restaurantId().getId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        tour.setRestaurantId(restaurantId);
        tourRepository.save(tour);
        return tour.getId();
    }

    @Override
    public void handle(DeleteTourCommand command){
        tourRepository.deleteById(command.tourId());
        System.out.println("Tour Delete");
    }
}
