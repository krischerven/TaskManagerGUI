# Commands to create the database
CREATE DATABASE task_db;
use task_db;
CREATE TABLE tasks (id int unsigned auto_increment primary key, email varchar(50), description varchar(100), dueDate varchar(30), completed bool);
CREATE TABLE users(email varchar(100), password varchar(100));
