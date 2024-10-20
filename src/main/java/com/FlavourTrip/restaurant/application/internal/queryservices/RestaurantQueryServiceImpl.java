package com.FlavourTrip.restaurant.application.internal.queryservices;

import com.FlavourTrip.restaurant.domain.model.entities.Restaurant;
import com.FlavourTrip.restaurant.domain.model.queries.GetAllRestaurantsQuery;
import com.FlavourTrip.restaurant.domain.model.queries.GetRestaurantByIdQuery;
import com.FlavourTrip.restaurant.domain.model.queries.GetRestaurantByNameQuery;
import com.FlavourTrip.restaurant.domain.services.RestaurantQueryService;
import com.FlavourTrip.restaurant.infrastructure.persistence.jpa.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantQueryServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> handle(GetAllRestaurantsQuery query) {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> handle(GetRestaurantByIdQuery query) {
        return restaurantRepository.findById(query.restaurantId());
    }

    @Override
    public Optional<Restaurant> handle(GetRestaurantByNameQuery query) {
        return restaurantRepository.findByName(query.name());
    }
}

