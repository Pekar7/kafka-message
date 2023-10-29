package com.example.jwtauth.controller;

import com.example.jwtauth.model.CasinoUser;
import com.example.jwtauth.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "Hello")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("Get Stock Information by TICKER")
    @GetMapping("/users")
    public ResponseEntity<List<CasinoUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
