package com.js.JourneySatisfaction.service;



import java.util.List;
import java.util.Optional;

import com.js.JourneySatisfaction.model.User1;

public interface UserService {
    List<User1> getAllUsers();
    Optional<User1> getUserById(Long id);
    User1 createUser(User1 user);
    Optional<User1> updateUser(Long id, User1 user);
    boolean deleteUser(Long id);
}