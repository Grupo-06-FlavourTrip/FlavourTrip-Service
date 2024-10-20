package com.FlavourTrip.tour.domain.services;

import com.FlavourTrip.tour.domain.model.entities.Tour;
import com.FlavourTrip.tour.domain.model.queries.GetAllToursQuery;
import com.FlavourTrip.tour.domain.model.queries.GetToursByIdQuery;

import java.util.List;
import java.util.Optional;

public interface TourQueryService {
    List<Tour> handle(GetAllToursQuery query);
    Optional<Tour> handle(GetToursByIdQuery query);

}
