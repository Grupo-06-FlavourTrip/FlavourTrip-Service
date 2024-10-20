package com.FlavourTrip.user.interfaces.rest.transform;

import com.FlavourTrip.user.domain.model.aggregates.DebitCard;
import com.FlavourTrip.user.interfaces.rest.resources.CardResource;

public class CardResourceFromEntityAssembler {
    public static CardResource toResourceFromEntity(DebitCard entity){
        return new CardResource(entity.getId(), entity.getNumCard(), entity.getCvv(), entity.getDate(),entity.getName());
    }
}