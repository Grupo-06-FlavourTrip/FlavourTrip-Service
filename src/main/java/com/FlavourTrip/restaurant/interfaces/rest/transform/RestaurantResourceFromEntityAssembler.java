package com.FlavourTrip.restaurant.interfaces.rest.transform;

import com.FlavourTrip.restaurant.domain.model.entities.Restaurant;
import com.FlavourTrip.restaurant.interfaces.rest.resources.RestaurantResource;
import org.apache.commons.text.StringEscapeUtils;

public class RestaurantResourceFromEntityAssembler {
    public static RestaurantResource toResourceFromEntity(Restaurant entity){
        String imageUrl = entity.getImage().imageUrl();
        String sanitizedImageUrl = StringEscapeUtils.escapeHtml4(imageUrl);
        return new RestaurantResource(entity.getId(), entity.getName(), entity.getDescription(), sanitizedImageUrl, entity.getBookingLink());
    }
}
