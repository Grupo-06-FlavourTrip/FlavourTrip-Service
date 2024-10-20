package com.FlavourTrip.user.interfaces.rest;

import com.FlavourTrip.user.domain.model.commands.DeleteCardCommand;
import com.FlavourTrip.user.domain.model.queries.GetAllCardsQuery;
import com.FlavourTrip.user.domain.model.queries.GetCardByIdQuery;
import com.FlavourTrip.user.domain.services.CardCommandService;
import com.FlavourTrip.user.domain.services.CardQueryService;
import com.FlavourTrip.user.interfaces.rest.resources.AddCardResource;
import com.FlavourTrip.user.interfaces.rest.resources.CardResource;
import com.FlavourTrip.user.interfaces.rest.resources.UpdateCardResource;
import com.FlavourTrip.user.interfaces.rest.transform.AddCardCommandFromResourceAssembler;
import com.FlavourTrip.user.interfaces.rest.transform.CardResourceFromEntityAssembler;
import com.FlavourTrip.user.interfaces.rest.transform.UpdateCardCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/Api/v1/FlavourTrip/debitCard", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="DebitCard", description = "DebitCard Managment Endpoints")
public class CardController {
    private final CardCommandService cardCommandService;
    private final CardQueryService cardQueryService;

    public CardController(CardCommandService cardCommandService, CardQueryService cardQueryService){
        this.cardCommandService = cardCommandService;
        this.cardQueryService = cardQueryService;
    }

    @Operation(summary = "Crear una tarjeta de debito")
    @PostMapping("/create")
    public ResponseEntity<CardResource> addCard(@RequestBody AddCardResource addCardResource){
        var addCardCommand = AddCardCommandFromResourceAssembler.toCommandFromResource(addCardResource);
        var cardId = cardCommandService.handle(addCardCommand);

        if (cardId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getCardByIdQuery = new GetCardByIdQuery(cardId);
        var card = cardQueryService.handle(getCardByIdQuery);

        if (card.isEmpty())
            return ResponseEntity.badRequest().build();
        var cardResource = CardResourceFromEntityAssembler.toResourceFromEntity(card.get());
        return new ResponseEntity<>(cardResource, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener una tarjeta de debito")
    @GetMapping
    public ResponseEntity<List<CardResource>> getAllCards(){
        var getAllCardsQuery = new GetAllCardsQuery();
        var cards = cardQueryService.handle(getAllCardsQuery);
        var cardResources= cards.stream().map(CardResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(cardResources);
    }
    @Operation(summary = "Obtener una tarjeta de debito por id")
    @GetMapping("/{id}")
    public ResponseEntity<CardResource> getCardById(@PathVariable Long id){
        var getCardByIdQuery = new GetCardByIdQuery(id);
        var card = cardQueryService.handle(getCardByIdQuery);

        if (card.isEmpty())
            return ResponseEntity.badRequest().build();
        var cardResource = CardResourceFromEntityAssembler.toResourceFromEntity(card.get());
        return ResponseEntity.ok(cardResource);
    }

    @Operation(summary = "Modificar una tarjeta de debito")
    @PutMapping("/{id}")
    public ResponseEntity<CardResource> updateCard(@PathVariable Long id, @RequestBody UpdateCardResource updateCardResource){
        var updateCardCommand = UpdateCardCommandFromResourceAssembler.toCommandFromResource(id,updateCardResource);
        var updatedCard = cardCommandService.handle(updateCardCommand);

        if(updatedCard.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var cardResource = CardResourceFromEntityAssembler.toResourceFromEntity(updatedCard.get());
        return ResponseEntity.ok(cardResource);
    }
    @Operation(summary = "Eliminar una tarjeta de debito")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long id){
        var deleteCardCommand = new DeleteCardCommand(id);
        cardCommandService.handle(deleteCardCommand);
        return ResponseEntity.ok("Card with given id successfully deleted ");
    }
}