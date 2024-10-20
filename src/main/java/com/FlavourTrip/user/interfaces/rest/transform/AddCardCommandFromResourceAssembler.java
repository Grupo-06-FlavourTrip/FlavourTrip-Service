package com.FlavourTrip.user.interfaces.rest.transform;

import com.FlavourTrip.user.domain.model.commands.AddCardCommand;
import com.FlavourTrip.user.interfaces.rest.resources.AddCardResource;

public class AddCardCommandFromResourceAssembler {
    public static AddCardCommand toCommandFromResource(AddCardResource resource){
        return new AddCardCommand(resource.numCard(),resource.cvv(),resource.date(),resource.name());
    }
}
