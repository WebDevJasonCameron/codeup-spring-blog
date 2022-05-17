USE spring_blog_db;

-- REMEMBER: Placing the cursor with a SQL statement block and entering in
-- "Command + Enter", then "Enter" again will allow you to run that SQL statement

-- 1. The following two statements will allow us to drop and "zero" out our tables if they exist:
TRUNCATE ads;

DROP TABLE IF EXISTS ads;

-- 2. Build table:
CREATE TABLE ads (
                         id              int(10) NOT NULL AUTO_INCREMENT,
                         description           varchar(255) NOT NULL,
                         title          varchar(255) NOT NULL,
                         user_id           varchar(255),
                         PRIMARY KEY (id));

-- 3. Seed Table:
INSERT INTO ads (description, title)
VALUES ('Playstation', 'New'),
       ('Xbox', 'Slightly used'),
       ('Socks', 'Very worn'),
       ('A Moon', 'Changes with time' )
;

-- 4. Checks
DESC ads;

SHOW CREATE TABLE ads;

SELECT * FROM ads;