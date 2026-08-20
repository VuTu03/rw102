use Testing_System_Assignment_2;


-- Question 2: Lấy ra tất cả các phòng ban
 select *
 from Department;
 
 
-- Question 3: Lấy ra id của phòng ban "Sale" 
select *
from Department
where Department_name ='Sale';


-- Question 4: Lấy ra thông tin account có full name dài nhất
select*
from Account
order by length(Full_name) desc
limit 1;


-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id  = 3 
select*
from Account
where Department_id = 3
order by length(Full_name) desc
limit 1; 


-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
 select Group_name
 from `Group`
 where Create_date < '2019/12/20';
 
 
-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
select Question_id, count(*)
from Answer
group by Question_id
having count(*) >= 4;


-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
select code
from Exam
where Duration >= 60 and Create_date < '2019/12/20'; 


-- Question 9: Lấy ra 5 group được tạo gần đây nhất 
select*
from `Group`
order by Create_date desc
limit 5;


-- Question 10: Đếm số nhân viên thuộc department có id = 2 
select Department_id, count(Account_id)
from Account
where Department_id = 2;


-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
select*
from Account
where Full_name like 'D%o';


-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019  
delete from Exam where Create_date < '2019/12/20';


-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi" 
delete from Question where Content = 'Câu hỏi';


-- Question14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
update account set Full_name = 'Nguyễn Bá Lộc' and Email = 'loc.nguyenba@vti.com.vn' where Account_id = 5;


-- Question 15: update account có id = 5 sẽ thuộc group có id = 4 
update GroupAccount set Account_id = 5  where Group_id = 4;