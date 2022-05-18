CREATE USER 'codeup_test_user'@'localhost' IDENTIFIED BY 'codeup-1';
GRANT ALL ON code_test_db.* TO 'codeup_test_user'@'localhost';

SHOW DATABASES;

USE mysql;
SHOW TABLES;

SELECT * FROM user;

CREATE DATABASE IF NOT EXISTS spring_blog_db;

DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS pet_details;

