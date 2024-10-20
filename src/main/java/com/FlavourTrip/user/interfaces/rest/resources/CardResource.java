package com.FlavourTrip.user.interfaces.rest.resources;

public record CardResource(Long id,
                           Long numCard,
                           Long cvv,
                           String date,
                           String name) {
}
