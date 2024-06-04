package com.js.JourneySatisfaction.thymeleaf.controller1;

import com.js.JourneySatisfaction.model.User1;
import com.js.JourneySatisfaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserThymeleafController2 {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User1> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/user-list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Optional<User1> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user-details";
        } else {
            return "redirect:/users";
        }
    }

    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User1());
        return "users/create-user";
    }

    @PostMapping
    public String createUser(@ModelAttribute User1 user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        Optional<User1> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "users/edit-user";
        } else {
            return "redirect:/users";
        }
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User1 user) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}