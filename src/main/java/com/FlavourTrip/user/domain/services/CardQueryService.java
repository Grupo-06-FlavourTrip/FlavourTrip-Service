package com.FlavourTrip.user.domain.services;

import com.FlavourTrip.user.domain.model.aggregates.DebitCard;
import com.FlavourTrip.user.domain.model.queries.GetAllCardsQuery;
import com.FlavourTrip.user.domain.model.queries.GetCardByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CardQueryService {
    List<DebitCard> handle(GetAllCardsQuery query);
    Optional<DebitCard> handle(GetCardByIdQuery query);
}
