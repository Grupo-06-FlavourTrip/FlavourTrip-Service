package com.FlavourTrip.user.application.internal.queryservices;

import com.FlavourTrip.user.domain.model.entities.User;
import com.FlavourTrip.user.domain.model.queries.GetAllUsersQuery;
import com.FlavourTrip.user.domain.model.queries.GetUserByIdQuery;
import com.FlavourTrip.user.domain.services.UserQueryService;
import com.FlavourTrip.user.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query){
        return userRepository.findById(query.userId());
    }
}
