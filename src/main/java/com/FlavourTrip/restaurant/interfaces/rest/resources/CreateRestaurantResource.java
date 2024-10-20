package com.FlavourTrip.restaurant.interfaces.rest.resources;

public record CreateRestaurantResource(String name,
                                       String description,
                                       String image,
                                       String bookingLink) {
}
