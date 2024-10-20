package com.FlavourTrip.user.domain.model.commands;

import com.FlavourTrip.user.domain.model.valueobjects.Comment;
import com.FlavourTrip.user.domain.model.valueobjects.Rating;

public record CreateReviewCommand(Rating rating, Comment comment) {
}
