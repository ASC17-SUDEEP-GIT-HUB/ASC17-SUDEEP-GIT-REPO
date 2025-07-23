Create database myFriendDB;

use myFriendDB;

--show databases;

create table friends(
	id int primary key,
	name varchar(30),
	hobbies varchar(50)
);

insert into friends values(1, 'sudeep', 'playing cricket'),(2, 'Hello', 'Going to gym'), (3, 'john', 'playing chess');

SELECT * FROM friends;

insert into friends values(4, 'don', 'watching movies'), (5, 'jack', 'eating');

update friends
set hobbies = 'dancing'
where id = 3;

delete from friends
where id = 2;

alter table friends
add email varchar(30);

update friends
set email = 'sudeep@gmail.com'
where id = 1;

update friends 
set email = 'john@gmail.com'
where id = 3;

update friends
set email = 'don@gmail.com'
where id = 4;
 
select * from friends;

update friends
set email = 'jack@gmail.com'
where id = 5;

select name
from sys.tables;

SELECT * from friends;


delete friends
where id = 321;
