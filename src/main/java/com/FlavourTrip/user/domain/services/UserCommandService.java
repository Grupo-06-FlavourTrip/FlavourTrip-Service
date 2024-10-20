package com.FlavourTrip.user.domain.services;

import com.FlavourTrip.user.domain.model.commands.CreateUserCommand;
import com.FlavourTrip.user.domain.model.commands.DeleteUserCommand;
import com.FlavourTrip.user.domain.model.commands.UpdateUserCommand;
import com.FlavourTrip.user.domain.model.entities.User;

import java.util.Optional;

public interface UserCommandService {
    Long handle(CreateUserCommand command);
    Optional<User> handle (UpdateUserCommand command);
    void handle(DeleteUserCommand command);
}