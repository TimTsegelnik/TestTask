package com.example.testtaskforsocialnetwork.repository;

import com.example.testtaskforsocialnetwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstnameAndSurnameAndPatronymic(String firstname, String surname, String patronymic);

    User findByPassportSeriesAndPassportNumber(String passportSeries, String passportNumber);
}
