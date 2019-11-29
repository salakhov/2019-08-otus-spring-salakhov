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

select b.id, b.title from books b
    where b.id in
          (select c.book_id from catalog c
          where c.author_id=
                (select id from authors where first_name='Александр' and last_name='Пушкин'));

select b.id, b.title from books b
where b.id in
      (select c.book_id from catalog c
       where c.author_id=
             (select id from authors where first_name='Михаил' and last_name='Булгаков'));

select b.id, b.title from books b where b.id in (select c.book_id from catalog c
                where c.author_id = (select id from authors where last_name='Пушкин'));

select id from authors where last_name='Пушкин';

select a.id,a.first_name,a.second_name,a.last_name from AUTHORS a
where a.id in (select c.author_id from catalog c
               where c.book_id=(select id from books where title='Постигая Agile'));

select * from catalog;
select * from books;
select id from books where title='Евгений Онегин';
select id from books where title='Местер и маргарита';


select b.id, b.title,b.author_id, b.genre_id,a.first_name,a.second_name,a.last_name,g.id,g.name
        from books b, authors a,genres g where b.genre_id=g.id and a.id = b.author_id;