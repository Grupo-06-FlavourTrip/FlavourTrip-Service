package com.FlavourTrip.tour.application.internal.queryservices;

import com.FlavourTrip.tour.domain.model.entities.Tour;
import com.FlavourTrip.tour.domain.model.queries.GetAllToursQuery;
import com.FlavourTrip.tour.domain.model.queries.GetToursByIdQuery;
import com.FlavourTrip.tour.domain.services.TourQueryService;
import com.FlavourTrip.tour.infrastructure.persistence.jpa.repositories.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourQueryServiceImpl implements TourQueryService {
    private final TourRepository tourRepository;

    public TourQueryServiceImpl(TourRepository tourRepository){
        this.tourRepository = tourRepository;
    }

    @Override
    public List<Tour> handle(GetAllToursQuery query){
        return tourRepository.findAll();
    }

    @Override
    public Optional<Tour> handle(GetToursByIdQuery query){
        return tourRepository.findById(query.tourId());
    }
}