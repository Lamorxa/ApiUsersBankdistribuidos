package com.bank.USERS_API.Controllers;

import com.bank.USERS_API.DTO.LoginDTO;
import com.bank.USERS_API.Entities.UserEntity;
import com.bank.USERS_API.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/users")
public class UsersController {
private final UserService userService;
    @Autowired
    public UsersController(UserService userService) { this.userService= userService; }
    @GetMapping("/{userId}")
    public CompletableFuture<UserEntity> getUserbyId(@PathVariable int userId) {

        return userService.getUserbyId(userId);
    }
    @PostMapping("/auth")
    public CompletableFuture<UserEntity> Login(@RequestBody LoginDTO loginDTO) {
        if(loginDTO.getPassword().toString().trim()=="" || loginDTO.getUsername().toString().trim()==""){
            throw new Error();
        }
        return userService.Login(loginDTO);
    }
}
