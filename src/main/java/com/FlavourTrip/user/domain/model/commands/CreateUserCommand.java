package com.FlavourTrip.user.domain.model.commands;

import com.FlavourTrip.user.domain.model.aggregates.DebitCard;

import java.util.Date;

public record CreateUserCommand(String firstName, String lastName, Long password, String location, Date birthdate, String email, String phone, DebitCard debitCard) {
}
