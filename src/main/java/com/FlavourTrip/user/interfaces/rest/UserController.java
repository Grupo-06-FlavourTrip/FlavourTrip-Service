package com.FlavourTrip.user.interfaces.rest;

import com.FlavourTrip.user.domain.model.commands.DeleteUserCommand;
import com.FlavourTrip.user.domain.model.queries.GetAllUsersQuery;
import com.FlavourTrip.user.domain.model.queries.GetUserByIdQuery;
import com.FlavourTrip.user.domain.services.UserCommandService;
import com.FlavourTrip.user.domain.services.UserQueryService;
import com.FlavourTrip.user.interfaces.rest.resources.CreateUserResource;
import com.FlavourTrip.user.interfaces.rest.resources.UpdateUserResource;
import com.FlavourTrip.user.interfaces.rest.resources.UserResource;
import com.FlavourTrip.user.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.FlavourTrip.user.interfaces.rest.transform.UpdateUserCommandFromResourceAssembler;
import com.FlavourTrip.user.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/Api/v1/FlavourTrip/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="User", description = "User Managment Endpoints")
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserController(UserCommandService userCommandService, UserQueryService userQueryService){
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }
    @Operation(summary = "Registar un usuario")
    @PostMapping("/create")
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource createUserResource){
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(createUserResource);
        var userId = userCommandService.handle(createUserCommand);

        if (userId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserByIdQuery);

        if (user.isEmpty())
            return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }
    @Operation(summary = "Obtener lista de usuarios registrados")
    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUsers(){
        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);
        var userResources= users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(userResources);
    }
    @Operation(summary = "Obtener lista de usuarios registrados por Id")
    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id){
        var getUserByIdQuery = new GetUserByIdQuery(id);
        var user = userQueryService.handle(getUserByIdQuery);

        if (user.isEmpty())
            return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }
    @Operation(summary = "Modificar un perfil de usuario")
    @PutMapping("/{id}")
    public ResponseEntity<UserResource> updateUser(@PathVariable Long id, @RequestBody UpdateUserResource updateUserResource){
        var updateUserCommand = UpdateUserCommandFromResourceAssembler.toCommandFromResource(id,updateUserResource);
        var updatedUser = userCommandService.handle(updateUserCommand);

        if(updatedUser.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(updatedUser.get());
        return ResponseEntity.ok(userResource);
    }
    @Operation(summary = "Eliminar una cuenta de usuario")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        var deleteUserCommand = new DeleteUserCommand(id);
        userCommandService.handle(deleteUserCommand);
        return ResponseEntity.ok("User with given id successfully deleted ");
    }
}
