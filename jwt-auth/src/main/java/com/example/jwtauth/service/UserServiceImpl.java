package com.example.jwtauth.service;

import com.example.jwtauth.model.CasinoUser;
import com.example.jwtauth.model.UserRole;
import com.example.jwtauth.repository.CasinoUserRepository;
import com.example.jwtauth.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final CasinoUserRepository casinoUserRepository;
    private final UserRoleRepository casinoUserRoleRepository;

    @Autowired
    public UserServiceImpl(CasinoUserRepository casinoUserRepository, UserRoleRepository casinoUserRoleRepository) {
        this.casinoUserRepository = casinoUserRepository;
        this.casinoUserRoleRepository = casinoUserRoleRepository;
    }

    @Override
    public CasinoUser saveUser(CasinoUser casinoUser) {
        log.info("Saving new user " + casinoUser.getUsername());
        return casinoUserRepository.save(casinoUser);
    }

    @Override
    public UserRole saveRole(UserRole userRole) {
        log.info("Saving new role " + userRole.getName());
        return casinoUserRoleRepository.save(userRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        CasinoUser casinoUser = casinoUserRepository.findCasinoUserByUsername(username);
        UserRole userRole = casinoUserRoleRepository.findByName(roleName);
        log.info("Adding role {} to user {}", userRole.getName(), casinoUser.getUsername());
        casinoUser.getRoles().add(userRole);
    }

    @Override
    public CasinoUser getUser(String username) {
        log.info("Find user from DB with username {}", username);
        return casinoUserRepository.findCasinoUserByUsername(username);
    }

    @Override
    public List<CasinoUser> getUsers() {
        log.info("Get all user from DB");
        return casinoUserRepository.findAll();
    }
}
