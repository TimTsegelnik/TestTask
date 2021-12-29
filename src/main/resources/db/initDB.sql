DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id              INT          NOT NULL AUTO_INCREMENT,
    name            VARCHAR(255) NOT NULL,
    surname         VARCHAR(255) NOT NULL,
    patronymic      VARCHAR(255),
    passport_series VARCHAR(4)   NOT NULL,
    passport_number VARCHAR(6)   NOT NULL,
    date_of_birth   TIMESTAMP    NOT NULL,
    gender          VARCHAR(20)  NOT NULL,
    PRIMARY KEY (id)
);

CREATE UNIQUE INDEX users_initials
    ON users (name, surname, patronymic);

CREATE UNIQUE INDEX users_passportData
    ON users (passport_number, passport_number);
