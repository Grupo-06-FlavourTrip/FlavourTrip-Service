package com.FlavourTrip.restaurant.domain.model.valueobjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Image(String imageUrl) {
    private static final Pattern IMAGE_URL_PATTERN = Pattern.compile("^https?://.*\\.(png|jpg)$");

    public Image {
        if (!isValidImageUrl(imageUrl)) {
            throw new IllegalArgumentException("URL de imagen no es PNG o JPG");
        }
    }
    private boolean isValidImageUrl(String imageUrl) {
        Matcher matcher = IMAGE_URL_PATTERN.matcher(imageUrl);
        return matcher.matches();
    }
}
