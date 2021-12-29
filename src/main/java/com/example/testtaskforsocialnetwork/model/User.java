package com.example.testtaskforsocialnetwork.model;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "name", "surname"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 2, max = 100, message = "Name must contain at least 2 characters.")
    private String firstname;

    @Column(name = "surname", nullable = false)
    @NotBlank(message = "Surname cannot be empty.")
    @Size(min = 2, max = 100, message = "Surname must contain at least 2 characters.")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "passport_series", nullable = false)
    @Pattern(regexp = "^\\d{4}$", message = "Passport series must contain 4 numbers")
    private String passportSeries;

    @Column(name = "passport_number", nullable = false)
    @Pattern(regexp = "^\\d{6}$", message = "Passport number must contain 6 numbers")
    private String passportNumber;

    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
