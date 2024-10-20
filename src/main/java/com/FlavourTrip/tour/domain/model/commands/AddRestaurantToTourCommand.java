package com.FlavourTrip.tour.domain.model.commands;

import com.FlavourTrip.restaurant.domain.model.entities.Restaurant;

public record AddRestaurantToTourCommand (Long tourId, Restaurant restaurantId) {
}

