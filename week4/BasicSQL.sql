SELECT * FROM books;

SELECT id, title, isbn FROM books;

SELECT * FROM books LIMIT 10;

SELECT *
FROM books
WHERE year = 1999;

SELECT *
FROM books
WHERE year = 1999 AND author = 'Max Lucado';

SELECT *
FROM books
WHERE (year = 1999 AND author = 'Max Lucado') OR (year = 1998);

SELECT *
FROM books
WHERE author LIKE '%Max%';

SELECT *
FROM books
WHERE author = 'Max Lucado'
ORDER BY year DESC, title ASC;

SELECT *
FROM books
WHERE title like '%Rings%';

SELECT *
FROM books
WHERE id = 529896;

SELECT *
FROM ratings
WHERE isbn = '0618346279';

SELECT *
FROM books
  JOIN ratings ON books.isbn = ratings.isbn
WHERE books.id = 529896;

SELECT *
FROM books
  LEFT JOIN ratings ON books.isbn = ratings.isbn
WHERE ratings.rating IS NULL;

SELECT *
FROM books
  JOIN ratings ON books.isbn = ratings.isbn
WHERE books.id = 448665;

SELECT b.id as book_id, b.isbn, b.author, r.rating, r.id as rating_id
FROM books b
  JOIN ratings r ON b.isbn = r.isbn
WHERE b.id = 529896;

INSERT INTO books_users (book_id, user_id) VALUES(529896, 1),(529896, 2), (529896, 3);

SELECT * FROM books_users;

SELECT books.*, users.*
FROM books
  LEFT JOIN books_users ON books.id = books_users.book_id
  LEFT JOIN users ON books_users.user_id = users.id
WHERE users.id IS NOT NULL;