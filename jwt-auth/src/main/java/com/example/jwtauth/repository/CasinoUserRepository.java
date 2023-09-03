package com.example.jwtauth.repository;

import com.example.jwtauth.model.CasinoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CasinoUserRepository extends JpaRepository<CasinoUser, Long> {
    CasinoUser findCasinoUserByUsername(String username); // Убедитесь, что имя параметра правильное (username).
}

