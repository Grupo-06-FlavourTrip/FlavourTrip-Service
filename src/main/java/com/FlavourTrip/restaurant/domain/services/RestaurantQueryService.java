package com.FlavourTrip.restaurant.domain.services;

import com.FlavourTrip.restaurant.domain.model.entities.Restaurant;
import com.FlavourTrip.restaurant.domain.model.queries.GetAllRestaurantsQuery;
import com.FlavourTrip.restaurant.domain.model.queries.GetRestaurantByIdQuery;
import com.FlavourTrip.restaurant.domain.model.queries.GetRestaurantByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    List<Restaurant> handle(GetAllRestaurantsQuery query);
    Optional<Restaurant> handle(GetRestaurantByIdQuery query);
    Optional<Restaurant> handle(GetRestaurantByNameQuery query);

}
