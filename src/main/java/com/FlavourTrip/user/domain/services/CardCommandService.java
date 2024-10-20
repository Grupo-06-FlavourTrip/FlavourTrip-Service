package com.FlavourTrip.user.domain.services;

import com.FlavourTrip.user.domain.model.aggregates.DebitCard;
import com.FlavourTrip.user.domain.model.commands.AddCardCommand;
import com.FlavourTrip.user.domain.model.commands.DeleteCardCommand;
import com.FlavourTrip.user.domain.model.commands.UpdateCardCommand;

import java.util.Optional;

public interface CardCommandService {
    Long handle(AddCardCommand command);
    Optional<DebitCard> handle (UpdateCardCommand command);
    void handle(DeleteCardCommand command);
}
