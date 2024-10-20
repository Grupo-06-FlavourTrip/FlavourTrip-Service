package com.FlavourTrip.user.domain.services;

import com.FlavourTrip.user.domain.model.entities.User;
import com.FlavourTrip.user.domain.model.queries.GetAllUsersQuery;
import com.FlavourTrip.user.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
}
