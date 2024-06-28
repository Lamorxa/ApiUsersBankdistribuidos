package com.bank.USERS_API.Service;

import com.bank.USERS_API.DTO.LoginDTO;
import com.bank.USERS_API.Entities.UserEntity;
import com.bank.USERS_API.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public CompletableFuture<UserEntity> Login(LoginDTO loginDTO) {
        return CompletableFuture.supplyAsync(()->{
            try {
                return userRepository.Login( loginDTO.getUsername(), loginDTO.getPassword());
            }catch (Exception e){
                throw new RuntimeException("Error while login",e);
            }
        });
    }
    public CompletableFuture<UserEntity> getUserbyId(int userid ) {
        return CompletableFuture.supplyAsync(()->{
            try {
                return userRepository.getUserByID( userid);
            }catch (Exception e){
                throw new RuntimeException("Error while login",e);
            }
        });
    }

}
