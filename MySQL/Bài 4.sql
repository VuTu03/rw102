-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
create view v_in4_account as
select acc.*, dep.department_name
from account acc
join department dep on dep.department_id = acc.department_id
where dep.department_name = 'Sale';

select *
from v_in4_account where dep.department_name = 'Sale';

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
create view v_in4_groupaccount as
select count(acc.account_id) 
from account acc
left join groupaccount ga on acc.account_id = ga.account_id
group by acc.account_id
order by count(acc.account_id) desc
limit 1;

select acc.*, count(acc.account_id) 
from account acc
left join groupaccount ga on acc.Account_id = ga.Account_id
group by acc.account_id
having count(acc.account_id) = (select count(acc.account_id) 
					from account acc
					left join groupaccount ga on acc.account_id = ga.account_id
					group by acc.account_id
					order by count(acc.account_id) desc
					limit 1);

select *
from v_in4_groupaccount;

-- cách 2:
create view question2_2 as
with cte_q2 as(
select acc.*, count(acc.account_id) 
from account acc
left join groupaccount ga on acc.Account_id = ga.Account_id
group by acc.account_id
)
select *
from cte_q2
where so_luong = (select max(so_luong)
					from cte_q2);
 select * from question2_2;                   

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
create view v_question_long as
select *
from question q
where (Length(content) - length(replace(content,' ','')) +1) >300;

select *
from v_question_long;

drop view v_question_long;

-- chữa:
select*
from question
where length(content) > 30; -- length : đếm số kí tự có tính dấu (Tú = 3)

select*
from question
where char_length(content) > 30; -- char_length: đếm số kí tự, ko tính dấu (Tú = 2)

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
create view v_in4_department as
select count(d.department_id)
from department d
join account acc on acc.department_id = d.department_id
group by d.department_id
order by count(d.department_id)
limit 1;


select d.*, count(d.department_id)
from department d
left join account acc on acc.department_id = d.department_id
group by d.department_id
having count(d.department_id) = (select d.*, count(d.department_id)
					from department d
					left join account acc on acc.department_id = d.department_id
					group by d.department_id
                    order by count(d.department_id) desc
                    limit 1);

select*
from v_in4_department;

-- Question 5: Tạo view có chứa tất các câu hỏi do user họ Nguyễn tạo
create view v_in4_question as
select q.*, full_name
from question q
join account acc on acc.account_id = q.create_id
where Full_name like 'Nguyễn%';

select *
from v_in4_question;
