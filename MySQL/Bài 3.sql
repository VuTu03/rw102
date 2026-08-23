-- Exercise 1: Join 
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
select*
from account acc
join department dep on acc.department_id = dep.department;
 
-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
select*
from account 
where create_date > '2010/12/20';
  
-- Question 3: Viết lệnh để lấy ra tất cả các developer  
select *
from account acc
join  `position` pos on acc.position_id = pos.position_id
where pos.position_name ='developer';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
select department_id, department_name, count(account_id) as sonhanvien
from department dep
join account acc on dep.department_id = acc.department_id
group by dep.department_id, dep.department_name
having count(account_id) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
select question_id, content, count(question_id)  as SoLanSuDung
from question q
join examquestion eq on  q.question_id = eq.question_id
group by q.question_id, q.content
order by SoLanSuDung desc
limit 1;

-- Question 6: Thông kê mỗi CategoryQuestion được sử dụng trong bao nhiêu Question
select category_id, category_name, count(question_id) as SolanSuDung
from categoryquestion cq
join question q on cq.category_id = cq.category_id
group by cq.category_id, q.category_name
order by SoLanSuDung desc;
 
-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
select question_id, content, count(exam_id) as SolanSuDung
from question q
join examquestion eq on q.question_id = eq.question_id
group by q.question_id, q.content
order by SolanSuDung desc;
 
-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
select question_id, content, count(answer_id)  as SoLanSuDung
from question q
join answer a on  q.question_id = a.question_id
group by q.question_id, q.content
order by SoLanSuDung desc
limit 1;
 
-- Question 9: Thống kê số lượng account trong mỗi group
select group_id, group_name, count(account_id) as SoLuong 
from `group`g
join groupaccount ga on g.group_id = ga.group_id
group by g.group_id, g.group_name
order by SoLuong desc;

-- Question 10: Tìm chức vụ có ít người nhất
select position_id, position_name, count(account_id) as SoNhanVien
from position p
join account acc on p.position_id = acc.position_id
group by p.position_id, p.position_name
order by SoNhanVien asc
limit 1;

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
select department_id, department_name, position_name, count(account_id) as SoNhanVien
from department d
join account acc on d.department_id = acc.department_id
join position p on acc.position_id = p.position_id
group by d.department_id, d.department_name, p.position_id, p.position_name
order by d.department_id;

  
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, … 
select question_id, content, type_name, full_name as NguoiTao, content as CauTraLoi
from question q
join typequestion tq on q.type_id = tq.type_id
join account a on q.creator_id = a.account_id
join Answer ans on q.question_id = ans.question_id;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
select type_id, type_name, count(question_id) as SoLuong
from typeQuestion tq
join question q on tq.type_id = q.type_id
group by tq.type_id, tq.type_name;
 
-- Question 14:Lấy ra group không có account nào
select group_id, group_name 
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