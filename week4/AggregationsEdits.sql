SELECT *
FROM books
WHERE lower(author) like '%roo%';

SELECT CONCAT(title, '(', year, ')'), title, year
FROM books
LIMIT 10;

SELECT avg(rating)
FROM ratings;

SELECT books.id, min(ratings.rating), max(ratings.rating), avg(ratings.rating), count(ratings.rating)
FROM books
LEFT JOIN ratings ON ratings.isbn = books.isbn
WHERE books.id = 529896
GROUP BY books.id;

SELECT books.id, count(ratings.rating)
FROM books
LEFT JOIN ratings ON ratings.isbn = books.isbn
GROUP BY books.id
ORDER BY count(ratings.id) DESC;

SELECT books.id, avg(ratings.rating)
FROM books
JOIN ratings ON ratings.isbn = books.isbn
GROUP BY books.id
ORDER BY avg(ratings.rating) DESC;

SELECT *
FROM books
JOIN ratings ON ratings.isbn = books.isbn
WHERE books.id = 360265;

SELECT books.id, books.title, avg(ratings.rating), count(ratings.rating)
FROM books
JOIN ratings ON ratings.isbn = books.isbn
WHERE year > 2000
GROUP BY books.id, books.title
HAVING count(ratings.rating) > 3
ORDER BY avg(ratings.rating) DESC;

select * from ratings;

SELECT year, books.id, count(ratings.rating), avg(ratings.rating)
FROM books
JOIN ratings ON ratings.isbn = books.isbn
WHERE ratings.rating > 0
GROUP BY year, books.id
ORDER BY count(ratings.rating) DESC;

CREATE TABLE public.books_users (
  id SERIAL PRIMARY KEY NOT NULL,
  books_id INTEGER NOT NULL,
  users_id INTEGER NOT NULL
);

ALTER TABLE public.books_users ADD timestamp TIMESTAMP DEFAULT now() NULL;

INSERT INTO books_users (books_id, users_id) VALUES(529896, 1), (529896, 2), (529896, 3), (529896, 4);

SELECT *
FROM books_users;

DELETE
FROM books_users
WHERE id = 4;

TRUNCATE books_users;

UPDATE books_users
SET users_id = 4
WHERE id = 3;