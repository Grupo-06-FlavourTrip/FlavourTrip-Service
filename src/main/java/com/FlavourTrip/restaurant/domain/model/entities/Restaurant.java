package com.FlavourTrip.restaurant.domain.model.entities;

import com.FlavourTrip.restaurant.domain.model.commands.CreateRestaurantCommand;
import com.FlavourTrip.restaurant.domain.model.valueobjects.Image;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Embedded
    private Image image;

    private String bookingLink;

    public Restaurant(CreateRestaurantCommand command ) {
        this.name = command.name();
        this.description = command.description();
        this.image = command.image();
        this.bookingLink = command.bookingLink();
    }
    public Restaurant(String name, String description, Image image,String bookingLink){
        this.name = name;
        this.description = description;
        this.image= image;
        this.bookingLink = bookingLink;
    }

    public Restaurant() {

    }
}