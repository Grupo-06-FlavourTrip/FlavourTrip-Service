package com.FlavourTrip.tour.interfaces.rest.resources;

import java.util.List;

public record UpdateTourResource(String titleTour,
                                 String imageTour,
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
                                 String hours,
                                 Long restaurantId) {
}
