package com.FlavourTrip.user.domain.services;

import com.FlavourTrip.user.domain.model.aggregates.Review;
import com.FlavourTrip.user.domain.model.queries.GetAllReviewsQuery;
import com.FlavourTrip.user.domain.model.queries.GetReviewByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {
    List<Review> handle(GetAllReviewsQuery query);
    Optional<Review> handle(GetReviewByIdQuery query);
}
