package com.bank.USERS_API.Repository;

import com.bank.USERS_API.Entities.UserEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final ObjectMapper mapper =new ObjectMapper();
    private final String filePathBank1 ="C:\\Users\\user\\Documents\\SpringProyects\\USERS-API\\src\\main\\resources\\userdata.json";

    public UserEntity getUserByID(int userID) throws  IOException {
    List<UserEntity> Users=getAllUsers();
    return Users.stream()
            .filter(user -> user.getUserId()==userID)
            .findFirst()
            .orElse(null);

    }
    public UserEntity Login(String username, String password) throws  IOException {
        List<UserEntity> Users=getAllUsers();
        return Users.stream()
                .filter(user -> user.getUsername().equals(username)&& user.getPassword().equals(password))
                .findFirst()
                .orElse(null);

    }
    private List<UserEntity> getAllUsers() throws IOException {
        File file = new File(filePathBank1);
        if (!file.exists()) {
            System.out.println("no existe ");
            return new ArrayList<>();
        }
        return mapper.readValue(file, new TypeReference<List<UserEntity>>() {});    }

}
