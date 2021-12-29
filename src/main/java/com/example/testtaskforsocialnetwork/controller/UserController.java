package com.example.testtaskforsocialnetwork.controller;

import com.example.testtaskforsocialnetwork.model.User;
import com.example.testtaskforsocialnetwork.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    @GetMapping
    public String showUserForm() {
        return "userForm";
    }

    @PostMapping
    public String createNewUser(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "userForm";
        }

        userRepository.save(user);
        return "redirect:/";
    }

}
