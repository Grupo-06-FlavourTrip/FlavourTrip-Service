package com.FlavourTrip.restaurant.interfaces.rest.resources;

public record RestaurantResource(Long id,
                                 String name,
                                 String description,
                                 String image,
                                 String bookingLink) {
}
