USE spring_blog_db;

-- REMEMBER: Placing the cursor with a SQL statement block and entering in
-- "Command + Enter", then "Enter" again will allow you to run that SQL statement

-- 1. The following two statements will allow us to drop and "zero" out our tables if they exist:
TRUNCATE coffees;

DROP TABLE IF EXISTS coffees;

-- 2. Build table:
CREATE TABLE coffees (
                       id              int(10) NOT NULL AUTO_INCREMENT,
                       brand           varchar(255) NOT NULL,
                       origin          varchar(255) NOT NULL,
                       roast           varchar(255) NOT NULL,
                       PRIMARY KEY (id));

-- 3. Seed Table:
INSERT INTO coffees (brand, origin, roast)
VALUES ('BobaFett', 'Naboo', 'dark'),
       ('Anakin', 'Tatooine', 'dark'),
       ('CadBane', 'Alderaan', 'light'),
       ('Yoda', 'Kamino', 'med')
;

-- 4. Checks
DESC coffees;

SHOW CREATE TABLE coffees;

SELECT * FROM coffees;