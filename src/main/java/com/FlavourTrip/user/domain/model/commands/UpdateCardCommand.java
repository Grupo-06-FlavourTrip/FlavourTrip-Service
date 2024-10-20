package com.FlavourTrip.user.domain.model.commands;

public record UpdateCardCommand(Long cardId, Long numCard, Long cvv, String date, String name) {
}