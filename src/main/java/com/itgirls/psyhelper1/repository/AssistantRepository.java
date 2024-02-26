package com.itgirls.psyhelper1.repository;

import com.itgirls.psyhelper1.model.Assistant;
import com.itgirls.psyhelper1.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssistantRepository extends JpaRepository<Assistant, UUID> {
    Optional<Assistant> findAssistantByUsers(Users users);
}
