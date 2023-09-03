package com.example.jwtauth.service;


import com.example.jwtauth.model.CasinoUser;
import com.example.jwtauth.model.UserRole;

import java.util.List;

public interface UserService {
    CasinoUser saveUser(CasinoUser casinoUser);
    UserRole saveRole(UserRole userRole);
    void addRoleToUser(String username, String roleName);
    CasinoUser getUser(String username);
    List<CasinoUser> getUsers();
}
