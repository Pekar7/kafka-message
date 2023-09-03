package com.example.jwtauth.repository;

import com.example.jwtauth.model.CasinoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasinoUserRepository extends JpaRepository<CasinoUser, Long> {
    CasinoUser findCasinoUserBy(String userName);
}
