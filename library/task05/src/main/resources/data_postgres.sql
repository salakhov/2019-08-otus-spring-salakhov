-- insert into BOOKS (id, `TITLE`) values (1, 'AAAA');
INSERT INTO authors (ID,FIRST_NAME, SECOND_NAME,LAST_NAME) VALUES (1, 'Александр','Сергеевич','Пушкин');
INSERT INTO authors (ID,FIRST_NAME, SECOND_NAME,LAST_NAME) VALUES (2, 'Михаил','Афанасьевич','Булгаков');
INSERT INTO authors (ID,FIRST_NAME, SECOND_NAME,LAST_NAME) VALUES (3, 'Джениффер','','Грин');
INSERT INTO authors (ID,FIRST_NAME, SECOND_NAME,LAST_NAME) VALUES (4, 'Эндрю','','Стеллман');


INSERT INTO genres (ID,NAME) VALUES (1, 'классика');
INSERT INTO genres (ID,NAME) VALUES (2, 'драма');
INSERT INTO genres (ID,NAME) VALUES (3, 'программирование');

INSERT INTO books (ID,TITLE,author_id,genre_id) VALUES (1, 'Евгений Онегин',1,1);
INSERT INTO books (ID,TITLE,author_id,genre_id) VALUES (2, 'Мастер и маргарита',2,1);
INSERT INTO books (ID,TITLE,author_id,genre_id) VALUES (3, 'Постигая Agile',3,3);

INSERT INTO library (ID,title,adress) VALUES (1, 'Горьковская','Советская 1');

INSERT INTO catalog (ID,library_id,author_id,genre_id,book_id) VALUES (1,1,1,1,1);
INSERT INTO catalog (ID,library_id,author_id,genre_id,book_id) VALUES (2, 1,2,2,2);
INSERT INTO catalog (ID,library_id,author_id,genre_id,book_id) VALUES (3, 1,3,3,3);
INSERT INTO catalog (ID,library_id,author_id,genre_id,book_id) VALUES (4, 1,4,3,3);

select * from books;

