
create database exam;
use exam;
create table Login_data(student_id int primary key, Name varchar(50),Password varchar(10));
-- drop table Score_details;*/
create table Score_details(student_id int, score_id int primary key auto_increment, score int ,attempts int ,  grade varchar(10) ,foreign key(student_id) references Login_data(student_id) );
create table Question_answer(Question_id int primary key ,Question varchar(100) , Option1 varchar(20),Option2 varchar(20),Option3 varchar(20),Option4 varchar(20), Answer varchar(20));

-- select *from Login_data;*

-- select *from  Score_details;