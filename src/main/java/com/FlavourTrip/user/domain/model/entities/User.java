package com.FlavourTrip.user.domain.model.entities;

import com.FlavourTrip.user.domain.model.aggregates.DebitCard;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="User")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Long password;

    private String location;

    private Date birthdate;

    private String email;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debit_card_id", referencedColumnName = "id")
    private DebitCard debitCard;


    public User() {
    }

    public User updatedInformation(String firstName, String lastName, Long password, String location, Date birthdate, String email, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.location = location;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        return this;
    }

    public User(String firstName, String lastName, Long password, String location, Date birthdate, String email, String phone,  DebitCard debitCard){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.location = location;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.debitCard = debitCard;
    }

}