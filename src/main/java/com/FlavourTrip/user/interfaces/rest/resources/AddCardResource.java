package com.FlavourTrip.user.interfaces.rest.resources;

public record AddCardResource(Long numCard,
                              Long cvv,
                              String date,
                              String name) {
}
