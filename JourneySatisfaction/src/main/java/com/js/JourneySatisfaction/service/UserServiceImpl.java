package com.js.JourneySatisfaction.service;
import com.js.JourneySatisfaction.model.User1;
import com.js.JourneySatisfaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User1> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User1> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User1 createUser(User1 user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User1> updateUser(Long id, User1 user) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        });
    }

    @Override
    public boolean deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}