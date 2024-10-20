package com.FlavourTrip.restaurant.domain.model.commands;

import com.FlavourTrip.restaurant.domain.model.valueobjects.Image;

public record CreateRestaurantCommand(String name, String description, Image image, String bookingLink) {

}
