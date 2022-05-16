USE spring_blog_db;

-- REMEMBER: Placing the cursor with a SQL statement block and entering in
-- "Command + Enter", then "Enter" again will allow you to run that SQL statement

-- 1. The following two statements will allow us to drop and "zero" out our tables if they exist:
TRUNCATE posts;

DROP TABLE IF EXISTS posts;

-- 2. Build table:
CREATE TABLE posts (
       id              int(10) NOT NULL AUTO_INCREMENT,
       title           varchar(255) NOT NULL UNIQUE,
       body            MEDIUMTEXT NOT NULL,
       PRIMARY KEY (id));

-- 3. Seed Table:
INSERT INTO posts (title, body)
VALUES ('BobaFett', 'bobaFett@war.com'),
       ('Anakin', 'ASky@Darkside.com'),
       ('CadBane', 'Cad@grey.com'),
       ('Yoda', 'Yoda@yogurt.com')
;

-- 4. Checks
DESC posts;

SHOW CREATE TABLE posts;

SELECT * FROM posts;