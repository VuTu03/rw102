-- Exercise 1: Join 
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
select*
from account acc
join department dep on acc.department_id = dep.department;
 
-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
select*
from account 
where create_date > '2010/12/20';
-- chữa:
select account_id, create_date
from account acc
left join position pos on pos.Account_id = acc.account_id
where ceater_date > '2010/12/20';
  
-- Question 3: Viết lệnh để lấy ra tất cả các developer  
select *
from account acc
join  `position` pos on pos.position_id = acc.position_id
where pos.position_name ='developer';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
-- dữ liệu nằm ở bảng nào? 		department + account
-- yêu cầu đề bài là gì? 		tìm các phòng ban > 3nv
-- các bước thực hiện yêu ntn?	join + group by + đếm
select department_id, department_name, count(account_id) as sonhanvien
from department dep
join account acc on dep.department_id = acc.department_id
group by dep.department_id, dep.department_name
having count(account_id) > 3;
-- chữa
select dep.*, count(1)
from department dep
join account acc on acc.department_id = dep.department_id
group by dep.department_id
having count(1) >2;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
select question_id, content, count(question_id)  as SoLanSuDung
from question q
join examquestion eq on  q.question_id = eq.question_id
group by q.question_id, q.content
order by SoLanSuDung desc
limit 1;
-- chữa:
select count(1)
from question q
join examquestion eq on  q.question_id = eq.question_id
group by eq.question_id
order by count(1) desc
limit 1;

-- Question 6: Thông kê mỗi CategoryQuestion được sử dụng trong bao nhiêu Question
-- (Đã chữa)
select cp.cq.category_id, count(cq.category_id)
from categoryquestion cq
left join question q on cq.category_id = q.category_id
group by cq.category_id;
-- các bài toán thống kê phải dùng left hoặc right join
-- khi dùng inner join thì group theo cột nào, đếm theo cột nào cũng đc
-- khi dùng left hoặc rigth join thì phải group theo bên cột đủ giá trị và đếm theo bên thiếu giá trị(count(null)=0)
 
-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
select q.*, count(eq.Exam_id)
from question q
left join examquestion eq on q.question_id = eq.question_id
group by eq.exam_id;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
select q.*, count(1)
from question q
join answer a on  q.question_id = a.question_id
group by q.question_id
order by count(1) desc
limit 1;
 
-- Question 9: Thống kê số lượng account trong mỗi group
select g.*, count(ga.group_id)
from `group`g
left join groupaccount ga on g.group_id = ga.group_id
group by ga.group_id;

-- Question 10: Tìm chức vụ có ít người nhất
select count(acc.position_id)
from position p
left join account acc on p.position_id = acc.position_id
group by p.position_id
order by count(acc.position_id) asc
limit 1;

select p.*, count (acc.position_id)
from position p
left join account acc on p.Position_id = acc.Position_id
group by p.potision_id
having count(acc.Position_id) = (select count(acc.position_id)
								from position p
								left join account acc on p.position_id = acc.position_id
								group by p.position_id
								order by count(acc.position_id) asc
								limit 1);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
select d.*, p.*, count(p.position_id)
from department d
left join account acc on d.department_id = acc.department_id
left join position p on acc.position_id = p.position_id
group by d.department_id, p.position_id;

  
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, … 
select q.*, a.*, ans.*, count(ans.answer_id)
from question q
left join typequestion tq on q.type_id = tq.type_id
left join account a on q.creator_id = a.account_id
left join Answer ans on q.question_id = ans.question_id
group by q.question_id, a.account_id, ans.answer_id ;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
select tq.*, count(q.question_id)
from typeQuestion tq
join question q on tq.type_id = q.type_id
group by tq.type_id
order by count(q.question_id);
 
-- Question 14:Lấy ra group không có account nào
select g.*
from `group` g
left join groupaccount ga on g.group_id = ga.group_id
where ga.account_id is null;
 
-- Question 16: Lấy ra question không có answer nào
select question_id, content 
from question q
left join answer ans on q.question_id = ans.question_id
where ans.content is null;

-- Exercise 2: Union 
-- Question 17:  
-- Lấy các account thuộc nhóm thứ 1 
select*
from account acc
join groupaccount ga on acc.account_id = ga.account_id
where ga.group = 1;

-- Lấy các account thuộc nhóm thứ 2 
select*
from account acc
join groupaccount ga on acc.account_id = ga.account_id
where ga.group = 2;

-- Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau 
select*
from account acc
join groupaccount ga on acc.account_id = ga.account_id
where ga.group = 1
union
select*
from account acc
join groupaccount ga on acc.account_id = ga.account_id
where ga.group = 2;

-- Question 18:  
-- Lấy các group có lớn hơn 5 thành viên
select group_id, count(account_id) as SoThanhVien
from groupaccount 
group by group_id
having count(account_id) > 5;

-- Lấy các group có nhỏ hơn 7 thành viên 
select group_id, count(account_id) as SoThanhVien
from groupaccount 
group by group_id
having count(account_id) < 7;

-- Ghép 2 kết quả từ câu a) và câu b) 
select group_id, count(account_id) as SoThanhVien
from groupaccount 
group by group_id
having count(account_id) > 5
union all
select group_id, count(account_id) as SoThanhVien
from groupaccount 
group by group_id
having count(account_id) < 7;