package com.FlavourTrip.restaurant.interfaces.rest.transform;

import com.FlavourTrip.restaurant.domain.model.commands.CreateRestaurantCommand;
import com.FlavourTrip.restaurant.domain.model.valueobjects.Image;
import com.FlavourTrip.restaurant.interfaces.rest.resources.CreateRestaurantResource;

public class CreateRestaurantCommandFromResourceAssembler {

    public static CreateRestaurantCommand toCommandFromResource(CreateRestaurantResource resource){
        Image image = new Image(resource.image());
        return new CreateRestaurantCommand(resource.name(), resource.description(),image, resource.bookingLink());
    }
}
