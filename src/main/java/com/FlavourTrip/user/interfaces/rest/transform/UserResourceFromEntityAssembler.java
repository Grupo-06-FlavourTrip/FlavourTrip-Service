package com.FlavourTrip.user.interfaces.rest.transform;

import com.FlavourTrip.user.domain.model.entities.User;
import com.FlavourTrip.user.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity){
        return new UserResource(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getPassword(),entity.getLocation(),entity.getBirthdate(),entity.getEmail(),entity.getPhone());
    }
}
