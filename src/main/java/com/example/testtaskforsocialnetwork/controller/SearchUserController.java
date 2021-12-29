package com.example.testtaskforsocialnetwork.controller;

import com.example.testtaskforsocialnetwork.model.User;
import com.example.testtaskforsocialnetwork.model.dto.PassportData;
import com.example.testtaskforsocialnetwork.model.dto.UserInitial;
import com.example.testtaskforsocialnetwork.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/find")
public class SearchUserController {

    private final UserRepository userRepository;

    public SearchUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute
    public PassportData passportData() {
        return new PassportData();
    }

    @ModelAttribute
    public UserInitial userInitial() {
        return new UserInitial();
    }

    @GetMapping
    public String showSearchUI() {
        return "searchForm";
    }

    @PostMapping("/initials")
    public String getUsersByInitials(@Valid UserInitial userInitial,
                                     BindingResult bindingResult,
                                     Model model) {

        if (bindingResult.hasErrors()) {
            return "searchForm";
        }

        List<User> usersList = userRepository.findByFirstnameAndSurnameAndPatronymic(
                userInitial.getFirstname(), userInitial.getSurname(), userInitial.getPatronymic());

        model.addAttribute("usersList", usersList);
        return "usersTable";
    }

    @PostMapping("/passport")
    public String getUserByPassport(@Valid PassportData passportData,
                                    BindingResult bindingResult,
                                    Model model) {

        if (bindingResult.hasErrors()) {
            return "searchForm";
        }

        User user = userRepository.findByPassportSeriesAndPassportNumber(
                passportData.getPassportSeries(), passportData.getPassportNumber());

        if (user == null) {
            model.addAttribute("usersList", List.of());
        } else {
            model.addAttribute("usersList", List.of(user));
        }
        return "usersTable";
    }
}
