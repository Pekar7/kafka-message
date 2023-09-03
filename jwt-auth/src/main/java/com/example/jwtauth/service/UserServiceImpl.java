package com.example.jwtauth.service;

import com.example.jwtauth.model.CasinoUser;
import com.example.jwtauth.model.UserRole;
import com.example.jwtauth.repository.CasinoUserRepository;
import com.example.jwtauth.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return casinoUserRepository.save(casinoUser);
    }

    @Override
    public UserRole saveRole(UserRole userRole) {
        return casinoUserRoleRepository.save(userRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        CasinoUser casinoUser = casinoUserRepository.findCasinoUserBy(username);
        UserRole userRole = casinoUserRoleRepository.findByName(roleName);
        casinoUser.getRoles().add(userRole);
    }

    @Override
    public CasinoUser getUser(String username) {
        return casinoUserRepository.findCasinoUserBy(username);
    }

    @Override
    public List<CasinoUser> getUsers() {
        return casinoUserRepository.findAll();
    }
}
