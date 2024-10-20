package com.FlavourTrip.user.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "DebitCard")
public class DebitCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numCard;

    private Long cvv;

    private String date;

    private String name;

    public DebitCard() {

    }
    public DebitCard(Long numCard, Long cvv, String date, String name) {
        this.numCard = numCard;
        this.cvv = cvv;
        this.date = date;
        this.name = name;
    }

    public DebitCard updatedInformation(Long numCard, Long cvv, String date, String name){
        this.numCard = numCard;
        this.cvv = cvv;
        this.date = date;
        this.name = name;
        return this;
    }

}