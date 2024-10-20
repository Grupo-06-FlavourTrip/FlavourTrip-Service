package com.FlavourTrip.tour.interfaces.rest.transform;

import com.FlavourTrip.tour.domain.model.commands.AddTourCommand;
import com.FlavourTrip.tour.domain.model.valueobjects.ImageTour;
import com.FlavourTrip.tour.interfaces.rest.resources.CreateTourResource;

public class CreateTourCommandFromResourceAssembler {

    public static AddTourCommand toCommandFromResource(CreateTourResource resource){
        ImageTour image = new ImageTour(resource.image());
        return new AddTourCommand(resource.titleTour(),
                image,
                resource.instructor(),
                resource.rating(),
                resource.nRatings(),
                resource.minPrice(),
                resource.currentPeople(),
                resource.maxPeople(),
                resource.language(),
                resource.duration(),
                resource.itemsIncluded(),
                resource.date(),
                resource.description(),
                resource.times(),
                resource.hours(),
                resource.restaurantId());
    }
}
