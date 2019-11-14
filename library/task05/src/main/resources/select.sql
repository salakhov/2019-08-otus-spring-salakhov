select a.id,a.first_name,a.second_name,a.last_name from AUTHORS a,catalog c,books b
    where c.book_id = (select b.id from b where b.title='Евгений Онегин');

select * from catalog;

select c.id, c.book_id,
       c.genre_id,c.author_id,
       c.library_id from catalog c
where c.book_id=(select id from books where title='Евгений Онегин');

select c.id, c.book_id,
       c.genre_id,c.author_id,
       c.library_id from catalog c
where c.book_id=(select id from books where title='Местер и маргарита');

select a.id,a.first_name,a.second_name,a.last_name from AUTHORS a
    where a.id=(select c.author_id from catalog c
    where c.book_id=(select id from books where title='Мастер и маргарита'));

select a.id,a.first_name,a.second_name,a.last_name from AUTHORS a
where a.id in (select c.author_id from catalog c
            where c.book_id=(select id from books where title='Постигая Agile'));


select * from catalog;
select * from books;
select id from books where title='Евгений Онегин';
select id from books where title='Местер и маргарита';