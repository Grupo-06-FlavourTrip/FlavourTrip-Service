package com.FlavourTrip.user.domain.services;

import com.FlavourTrip.user.domain.model.commands.CreateReviewCommand;
import com.FlavourTrip.user.domain.model.commands.DeleteReviewCommand;

public interface ReviewCommandService {
    Long handle(CreateReviewCommand command);
    void handle(DeleteReviewCommand command);
}

