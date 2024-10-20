package com.FlavourTrip.user.interfaces.rest.transform;

import com.FlavourTrip.user.domain.model.commands.CreateUserCommand;
import com.FlavourTrip.user.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource){
        return new CreateUserCommand(resource.firstName(),resource.lastName(),resource.password(),resource.location(),resource.birthdate(),resource.email(),resource.phone(),resource.debitCard());
    }
}