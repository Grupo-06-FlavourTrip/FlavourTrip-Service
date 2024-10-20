package com.FlavourTrip.user.interfaces.rest.resources;

import com.FlavourTrip.user.domain.model.aggregates.DebitCard;

import java.util.Date;

public record CreateUserResource(String firstName,
                                 String lastName,
                                 Long password,
                                 String location,
                                 Date birthdate,
                                 String email,
                                 String phone,
                                 DebitCard debitCard) {
}