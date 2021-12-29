package com.example.testtaskforsocialnetwork.model.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;


@Data
public final class PassportData {

    @Pattern(regexp = "^\\d{4}$", message = "Passport series must contain 4 numbers")
    private String passportSeries;

    @Pattern(regexp = "^\\d{6}$", message = "Passport number must contain 6 numbers")
    private String passportNumber;

}

