CREATE USER 'codeup_test_user'@'localhost' IDENTIFIED BY 'codeup-1';
GRANT ALL ON code_test_db.* TO 'codeup_test_user'@'localhost';

SHOW DATABASES;

USE mysql;
SHOW TABLES;

SELECT * FROM user;

CREATE DATABASE IF NOT EXISTS spring_blog_db;

TRUNCATE tags;

DROP TABLE IF EXISTS tags;
DROP TABLE IF EXISTS post_tag;
DROP TABLE IF EXISTS users;


DELETE FROM post_details WHERE id = 15;


UPDATE posts SET user_id = 3 WHERE id = 6;


