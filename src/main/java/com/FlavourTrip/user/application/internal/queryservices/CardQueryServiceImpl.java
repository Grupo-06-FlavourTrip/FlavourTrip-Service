package com.FlavourTrip.user.application.internal.queryservices;

import com.FlavourTrip.user.domain.model.aggregates.DebitCard;
import com.FlavourTrip.user.domain.model.queries.GetAllCardsQuery;
import com.FlavourTrip.user.domain.model.queries.GetCardByIdQuery;
import com.FlavourTrip.user.domain.services.CardQueryService;
import com.FlavourTrip.user.infrastructure.persistence.jpa.repositories.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardQueryServiceImpl implements CardQueryService {
    private final CardRepository cardRepository;

    public CardQueryServiceImpl(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    @Override
    public List<DebitCard> handle(GetAllCardsQuery query){
        return cardRepository.findAll();
    }

    @Override
    public Optional<DebitCard> handle(GetCardByIdQuery query){
        return cardRepository.findById(query.cardId());
    }
}
