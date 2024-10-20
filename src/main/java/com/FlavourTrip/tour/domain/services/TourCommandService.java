package com.FlavourTrip.tour.domain.services;

import com.FlavourTrip.tour.domain.model.commands.AddTourCommand;
import com.FlavourTrip.tour.domain.model.commands.DeleteTourCommand;
import com.FlavourTrip.tour.domain.model.commands.UpdateTourCommand;
import com.FlavourTrip.tour.domain.model.entities.Tour;

import java.util.Optional;

public interface TourCommandService {
    Long handle(AddTourCommand command);
    Optional<Tour> handle (UpdateTourCommand command);
    void handle(DeleteTourCommand command);
}