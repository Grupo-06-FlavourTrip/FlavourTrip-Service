package com.FlavourTrip.user.infrastructure.persistence.jpa.repositories;

import com.FlavourTrip.user.domain.model.aggregates.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<DebitCard, Long> {
    boolean existsById(Long id);
}