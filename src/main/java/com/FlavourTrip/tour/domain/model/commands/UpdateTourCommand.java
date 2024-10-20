package com.FlavourTrip.tour.domain.model.commands;

import com.FlavourTrip.tour.domain.model.valueobjects.ImageTour;

import java.util.List;

public record UpdateTourCommand(Long tourId,
                                String titleTour,
                                ImageTour imageTour,
                                String instructor,
                                Long rating,
                                Long nRatings,
                                Long minPrice,
                                Long currentPeople,
                                Long maxPeople,
                                String language,
                                Long duration,
                                List<String> itemsIncluded,
                                String date,
                                String description,
                                List<String> times,
                                String hours) {
}
