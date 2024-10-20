package com.FlavourTrip.user.interfaces.rest.resources;

public record UpdateCardResource(Long numCard,
                                 Long cvv,
                                 String date,
                                 String name) {
}
