package com.FlavourTrip.user.application.internal.commandservices;

import com.FlavourTrip.user.domain.model.commands.CreateUserCommand;
import com.FlavourTrip.user.domain.model.commands.DeleteUserCommand;
import com.FlavourTrip.user.domain.model.commands.UpdateUserCommand;
import com.FlavourTrip.user.domain.model.entities.User;
import com.FlavourTrip.user.domain.services.UserCommandService;
import com.FlavourTrip.user.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long handle(CreateUserCommand command){
        User user = new User(command.firstName(), command.lastName(), command.password(), command.location(), command.birthdate(), command.email(), command.phone(),command.debitCard());

        userRepository.save(user);
        return user.getId();
    }

    @Override
    public Optional<User> handle(UpdateUserCommand command) {
        var result = userRepository.findById(command.userId());
        if (result.isEmpty())
            throw new IllegalArgumentException("User does not exist");
        var userToUpdated = result.get();
        try{
            var updatedUser = userRepository.save(userToUpdated.updatedInformation(command.firstName(),command.lastName(), command.password(),command.location(),command.birthdate(),command.email(),command.phone()));
            return Optional.of(updatedUser);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while updating user: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteUserCommand command){
        userRepository.deleteById(command.userId());
        System.out.println("User Delete");
    }
}
