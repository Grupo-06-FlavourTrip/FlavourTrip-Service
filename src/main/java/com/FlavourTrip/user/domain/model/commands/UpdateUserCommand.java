package com.FlavourTrip.user.domain.model.commands;

import java.util.Date;

public record UpdateUserCommand(Long userId, String firstName, String lastName, Long password, String location, Date birthdate, String email, String phone) {
}

