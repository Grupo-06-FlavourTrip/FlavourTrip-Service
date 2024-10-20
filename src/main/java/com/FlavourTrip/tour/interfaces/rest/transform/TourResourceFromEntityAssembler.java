package com.FlavourTrip.tour.interfaces.rest.transform;

import com.FlavourTrip.tour.domain.model.entities.Tour;
import com.FlavourTrip.tour.interfaces.rest.resources.TourResource;
import org.apache.commons.text.StringEscapeUtils;

public class TourResourceFromEntityAssembler {

    public static TourResource toResourceFromEntity(Tour entity) {
        String imageUrl = entity.getImageTour().imageUrl();
        String sanitizedImageUrl = StringEscapeUtils.escapeHtml4(imageUrl);
        return new TourResource(entity.getId(),
                entity.getTitleTour(),
                sanitizedImageUrl,
                entity.getInstructor(),
                entity.getRating(),
                entity.getNRatings(),
                entity.getMinPrice(),
                entity.getCurrentPeople(),
                entity.getMaxPeople(),
                entity.getLanguage(),
                entity.getDuration(),
                entity.getItemsIncluded(),
                entity.getDate(),
                entity.getDescription(),
                entity.getTimes(),
                entity.getHours());
    }
}
