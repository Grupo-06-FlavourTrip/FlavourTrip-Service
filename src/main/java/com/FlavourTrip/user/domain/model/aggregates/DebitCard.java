package com.FlavourTrip.user.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//Para que funcione el agregar user, quitar la etiqueta NoArgsConstructor y para que funcione el debit card, poner NoArgsConstructor
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