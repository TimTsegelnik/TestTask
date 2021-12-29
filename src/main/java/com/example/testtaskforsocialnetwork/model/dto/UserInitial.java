package com.example.testtaskforsocialnetwork.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public final class UserInitial {

    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 2, max = 100, message = "Name must contain at least 2 characters.")
    private String firstname;

    @NotBlank(message = "Surname cannot be empty.")
    @Size(min = 2, max = 100, message = "Surname must contain at least 2 characters.")
    private String surname;

    private String patronymic;

}
