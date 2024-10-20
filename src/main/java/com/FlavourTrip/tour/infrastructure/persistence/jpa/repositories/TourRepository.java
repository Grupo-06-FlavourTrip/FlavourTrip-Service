package com.FlavourTrip.tour.infrastructure.persistence.jpa.repositories;

import com.FlavourTrip.tour.domain.model.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    boolean existsById(Long id);

}

