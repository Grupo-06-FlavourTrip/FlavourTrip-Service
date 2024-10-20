package com.FlavourTrip.user.interfaces.rest.transform;

import com.FlavourTrip.user.domain.model.commands.UpdateCardCommand;
import com.FlavourTrip.user.interfaces.rest.resources.UpdateCardResource;

public class UpdateCardCommandFromResourceAssembler {
    public static UpdateCardCommand toCommandFromResource(Long id, UpdateCardResource resource){
        return new UpdateCardCommand(id,resource.numCard(),resource.cvv(),resource.date(),resource.name());
    }
}
