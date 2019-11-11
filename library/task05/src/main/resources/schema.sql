DROP TABLE IF EXISTS AUTHORS;
DROP TABLE IF EXISTS BOOKS;
DROP TABLE IF EXISTS GENRE;

CREATE TABLE AUTHORS
(
    ID LONG PRIMARY KEY,
    FIRST_NAME VARCHAR(255),
    SECOND_NAME VARCHAR(255),
    LAST_NAME VARCHAR(255)
);
CREATE TABLE GENRES
(
    ID LONG PRIMARY KEY,
    NAME VARCHAR(255)
);
CREATE TABLE BOOKS
(
    ID LONG PRIMARY KEY,
    TITLE VARCHAR(255)
);
CREATE TABLE LIBRARY
(
    ID LONG PRIMARY KEY,
    TITLE VARCHAR(255),
    ADRESS VARCHAR(255)
);
CREATE TABLE KARTOTEKA
(
    ID LONG PRIMARY KEY,
    LIBRARY_ID LONG,
    AUTHOR_ID LONG,
    GENRE_ID LONG,
    BOOK_ID LONG,
    FOREIGN KEY (LIBRARY_ID) REFERENCES LIBRARY(ID),
    FOREIGN KEY (AUTHOR_ID) REFERENCES LIBRARY(ID),
    FOREIGN KEY (GENRE_ID) REFERENCES LIBRARY(ID),
    FOREIGN KEY (BOOK_ID) REFERENCES LIBRARY(ID)
)

