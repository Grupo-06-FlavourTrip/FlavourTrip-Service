package com.FlavourTrip.user.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Rating(Integer value) {
    public Rating {
        if (value == null) {
            throw new IllegalArgumentException("Rating cannot be null");
        }
        if (value < 0 || value > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
    }
}
