package com.FlavourTrip.restaurant.interfaces.rest;

import com.FlavourTrip.restaurant.domain.model.commands.DeleteRestaurantCommand;
import com.FlavourTrip.restaurant.domain.model.queries.GetAllRestaurantsQuery;
import com.FlavourTrip.restaurant.domain.model.queries.GetRestaurantByIdQuery;
import com.FlavourTrip.restaurant.domain.services.RestaurantCommandService;
import com.FlavourTrip.restaurant.domain.services.RestaurantQueryService;
import com.FlavourTrip.restaurant.interfaces.rest.resources.CreateRestaurantResource;
import com.FlavourTrip.restaurant.interfaces.rest.resources.RestaurantResource;
import com.FlavourTrip.restaurant.interfaces.rest.transform.CreateRestaurantCommandFromResourceAssembler;
import com.FlavourTrip.restaurant.interfaces.rest.transform.RestaurantResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/Api/v1/TasteTour/restaurant", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Restaurant", description = "Restaurant Managment Endpoints")
public class RestaurantController {
    private final RestaurantCommandService restaurantCommandService;

    private final RestaurantQueryService restaurantQueryService;


    public RestaurantController(RestaurantCommandService restaurantCommandService, RestaurantQueryService restaurantQueryService) {
        this.restaurantCommandService = restaurantCommandService;
        this.restaurantQueryService = restaurantQueryService;
    }

    @Operation(summary = "Obtener lista de Restaurantes")
    @GetMapping
    public ResponseEntity<List<RestaurantResource>> getAllRestaurant(){
        var getAllRestaurantsQuery = new GetAllRestaurantsQuery();
        var restaurants = restaurantQueryService.handle(getAllRestaurantsQuery);
        var restaurantResources= restaurants.stream().map(RestaurantResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(restaurantResources);
    }
    @Operation(summary = "Obtener lista de Restaurantes por Id")
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResource> getRestaurantById(@PathVariable Long id){
        var getRestaurantByIdQuery = new GetRestaurantByIdQuery(id);
        var restaurant = restaurantQueryService.handle(getRestaurantByIdQuery);

        if (restaurant.isEmpty())
            return ResponseEntity.badRequest().build();
        var restaurantResource = RestaurantResourceFromEntityAssembler.toResourceFromEntity(restaurant.get());
        return ResponseEntity.ok(restaurantResource);
    }

    @Operation(summary = "Crear un restaurante")
    @PostMapping("/create")
    public ResponseEntity<RestaurantResource> createRestaurant(@RequestBody CreateRestaurantResource resource){
        var createRestaurantCommand = CreateRestaurantCommandFromResourceAssembler.toCommandFromResource(resource);
        var restaurantId = restaurantCommandService.handle(createRestaurantCommand);

        if(restaurantId==0L){
            return ResponseEntity.badRequest().build();
        }

        var getRestaurantByIdQuery = new GetRestaurantByIdQuery(restaurantId);
        var restaurant = restaurantQueryService.handle(getRestaurantByIdQuery);

        if(restaurant.isEmpty())
            return ResponseEntity.badRequest().build();
        var restaurantResource = RestaurantResourceFromEntityAssembler.toResourceFromEntity(restaurant.get());
        return new ResponseEntity<>(restaurantResource, HttpStatus.CREATED);

    }
    @Operation(summary = "Eliminar un restaurante por Id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id){
        var deleteRestaurantCommand = new DeleteRestaurantCommand(id);
        restaurantCommandService.handle(deleteRestaurantCommand);
        return ResponseEntity.ok("Restaurant with given id successfully deleted ");
    }

}
