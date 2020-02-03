DROP TABLE IF EXISTS authors cascade;
DROP TABLE IF EXISTS books cascade;
DROP TABLE IF EXISTS genres cascade;
-- DROP TABLE IF EXISTS catalog cascade;
DROP TABLE IF EXISTS library cascade;

CREATE TABLE authors
(
    ID BIGINT PRIMARY KEY,
    FIRST_NAME VARCHAR(255),
    SECOND_NAME VARCHAR(255),
    LAST_NAME VARCHAR(255)
);
CREATE TABLE genres
(
    ID BIGINT PRIMARY KEY,
    NAME VARCHAR(255)
);
CREATE TABLE books
(
    ID BIGINT PRIMARY KEY,
    TITLE VARCHAR(255),
    AUTHOR_ID BIGINT,
    GENRE_ID BIGINT,
    FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS(ID),
    FOREIGN KEY (GENRE_ID) REFERENCES GENRES(ID)
);
CREATE TABLE library
(
    ID BIGINT PRIMARY KEY,
    TITLE VARCHAR(255),
    ADRESS VARCHAR(255)
);
-- CREATE TABLE catalog
-- (
--     ID BIGINT PRIMARY KEY,
--     LIBRARY_ID BIGINT,
--     AUTHOR_ID BIGINT,
--     GENRE_ID BIGINT,
--     BOOK_ID BIGINT,
--     FOREIGN KEY (LIBRARY_ID) REFERENCES LIBRARY(ID),
--     FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS(ID),
--     FOREIGN KEY (GENRE_ID) REFERENCES GENRES(ID),
--     FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(ID)
-- )

