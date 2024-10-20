package com.FlavourTrip.user.infrastructure.persistence.jpa.repositories;

import com.FlavourTrip.user.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsById(Long id);
}
