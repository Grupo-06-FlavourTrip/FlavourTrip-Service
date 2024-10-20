package com.FlavourTrip.user.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "review_rating"))
    private Rating rating;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "review_comment"))
    private Comment comment;

    public Review updatedInformation(Rating rating, Comment comment){
        this.rating = rating;
        this.comment = comment;
        return this;
    }

    public Review(Rating rating, Comment comment){
        this.rating = rating;
        this.comment = comment;
    }

}
