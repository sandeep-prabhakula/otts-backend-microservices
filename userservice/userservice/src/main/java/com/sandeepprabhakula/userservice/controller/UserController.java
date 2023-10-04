package com.sandeepprabhakula.userservice.controller;

import com.sandeepprabhakula.userservice.entities.Users;
import com.sandeepprabhakula.userservice.service.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<Users> addUser(@RequestBody Users user){
        Users registeredUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

//    @GetMapping
//    @PreAuthorize("hasRole('SCOPE_Admin')")
//    public ResponseEntity<List<Users>> getAllUsers(){
//        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
//    }

    @CircuitBreaker(name = "SUBSCRIPTION_PURCHASES_BREAKER", fallbackMethod = "subscriptionPurchasesFallback")
    @GetMapping("/{uid}")
    public ResponseEntity<Users> getUserByUid(@PathVariable("uid")String uid){
        return new ResponseEntity<>(userService.getUserByUid(uid),HttpStatus.OK);
    }

    public ResponseEntity<Users> subscriptionPurchasesFallback(String uid,Exception ex){
        System.out.println("Fallback executed service down : " + ex.getMessage());
        Users user = Users
                .builder()
                .email("dummy@gmail.com")
                .name("name")
                .build();
        return new ResponseEntity<>(user,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/find-by-email")
    public Users findUserByEmail(@RequestParam("email") String email){
        return userService.findUserByEmail(email);
    }
}
