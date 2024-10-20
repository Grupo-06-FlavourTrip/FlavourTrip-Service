package com.FlavourTrip.user.domain.model.valueobjects;

public record Password(String value) {
    public Password {
        if (value == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
    }
}

