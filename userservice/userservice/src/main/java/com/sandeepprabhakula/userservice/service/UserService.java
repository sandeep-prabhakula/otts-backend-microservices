package com.sandeepprabhakula.userservice.service;

import com.sandeepprabhakula.userservice.entities.Users;

import java.util.List;

public interface UserService {
    Users save(Users user);

    Users getUserByUid(String uid);

//    List<Users> getAllUsers();

    Users findUserByEmail(String email);
}
