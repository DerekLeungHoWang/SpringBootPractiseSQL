DROP TABLE IF EXISTS employees;
CREATE TABLE employees(
id int not null primary key auto_increment,
first_name varchar(255) not null,
last_name varchar(255) not null,
address varchar(255) not null,
joiningdate timestamp default(CURRENT_TIME)
)