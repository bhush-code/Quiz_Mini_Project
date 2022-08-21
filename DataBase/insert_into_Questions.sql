use exam;
truncate  Question_answer;
insert into Question_answer values(1,"Question1", "opt1","opt2","opt3","opt4","A");
insert into Question_answer values(2,"Question2", "opt1","opt2","opt3","opt4","B");
insert into Question_answer values(3,"Question3", "opt1","opt2","opt3","opt4","C");
insert into Question_answer values(4,"Question4", "opt1","opt2","opt3","opt4","D");
insert into Question_answer values(5,"Question5", "opt1","opt2","opt3","opt4","A");

select *from Question_answer;


select *from Score_details;