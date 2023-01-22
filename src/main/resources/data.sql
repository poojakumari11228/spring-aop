-- USERS

INSERT INTO users (id, name)
VALUES (111, 'Pooja Kumari');

INSERT INTO post (id, author, content, title, user_id)
VALUES  (100, 'Pooja', 'Java is an Object Oriented Language', 'OOP', 111 );

INSERT INTO post (id, author, content, title, user_id)
VALUES  (101, 'Pooja', '2nd post', '2', 111 );

INSERT INTO post (id, title, content, author, user_id)
VALUES (103, 'Hello World', 'This is my 3rd post', 'Pooja', 111);


INSERT INTO comment(id, name, text, post_id)
VALUES (101, 'Pooja', 'Nice Work!', 100 )

