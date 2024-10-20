package com.FlavourTrip.user.interfaces.rest.resources;

import java.util.Date;

public record UpdateUserResource(String firstName,
                                 String lastName,
                                 Long password,
                                 String location,
                                 Date birthdate,
                                 String email,
                                 String phone) {
}

