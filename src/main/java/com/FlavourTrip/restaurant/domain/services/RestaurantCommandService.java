package com.FlavourTrip.restaurant.domain.services;

import com.FlavourTrip.restaurant.domain.model.commands.CreateRestaurantCommand;
import com.FlavourTrip.restaurant.domain.model.commands.DeleteRestaurantCommand;

public interface RestaurantCommandService {
    Long handle(CreateRestaurantCommand command);

    void handle(DeleteRestaurantCommand command);
}