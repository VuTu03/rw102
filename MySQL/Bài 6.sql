-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước 
drop trigger if exists Q1_BT1;
delimiter $$
create trigger  Q1_BT1 
before insert on `group`
for each row
    begin
    declare v_create_date datetime;
    set v_create_date = date_sub(now(), interval 1 year);
 	 	if (new.create_date <= v_create_date) then
 	 	 	 	signal sqlstate '12345'
 	 	 	 	set message_text = 'Ko thể tạo nữa';
 	 	 	end if;
    end$$
delimiter ;
insert into `testingsystem`.`group` (`group_name`, `creator_id`, `create_date`)
values ('2', '1', '2025-12-15 00:00:00');


-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user" 
drop trigger if exists Q2_BT2;
delimiter $$
 	create trigger Q2_BT2 
    before insert on `Account`
    for each row
    begin
 	 	 	declare v_depid tinyint;
 	 	 	select d.department_id into v_depid 
            from department d 
            where d.department_name = 'sale';
 	 	 	if (new.department_id = v_depid) then
 	 	 	 	signal sqlstate '12345'
 	 	 	 	set message_text = 'Ko thể thêm sale';
 	 	 	end if;
    end$$
delimiter ;
insert into `testingsystem`.`account` (`email`, `user_name`, `full_name`, `department_id`,`position_id`, `create_date`) 
values ('1',  '1', '1', '2', '1', '2024-11-13 00:00:00');
 

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user 
drop trigger if exists Q3_BT3;
delimiter $$
 	create trigger Q3_BT3 
    before insert on `groupaccount`
    for each row
    begin
 	 	 	declare var_countgroup_id tinyint; 	 
 	 	 	select count(ga.group_id) into var_countgroup_id 
            from groupaccount ga
 	 	 	where ga.group_id = new.group_id;
 	 	 	if (var_countgroup_id >5) then
 	 	 	 	signal sqlstate '12345'
 	 	 	 	set message_text = 'Ko thể thêm người dùng';
 	 	 	end if;
    end$$
delimiter ;
insert into `group_account` (`group_id`, `account_id`, `join_date`)
values (1, 1,'2025-08-25 00:00:00');
    

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question 
drop trigger if exists Q4_BT4; 
delimiter $$ 
create trigger Q4_BT4 
before insert on `examquestion` 
for each row 
    begin 
		declare var_countquesinexam tinyint; 	 	 
		select count(eq.examid) into var_countquesinexam from examquestion eq 
		where eq.exam_id = new.exam_id; 
		if (var_countquesinexam >10) then 
		signal sqlstate '12345' 
		set message_text = 'Giới hạn câu hỏi là 10'; 
		end if;             
end$$ 
delimiter ; 
insert into `examquestion`(`exam_id`, `question_id`) values (6, 2);


-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó 
drop trigger if exists Q5_BT5;
delimiter $$
create trigger Q5_BT5
before delete on `account`
for each row
begin
 	declare v_email varchar(50);
    set v_email = 'admin@gmail.com';
    if (old.email = v_email) then 
 	 	 	signal sqlstate '12345' 
 	 	 	set message_text = 'Đang sử dụng admin, bạn ko thể xoá nó!';
        end if;
end $$
delimiter ;  
delete from account a where a.email = 'admin@gmail.com'; 


-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"   
drop trigger if exists Q6_BT6; 
delimiter $$
create trigger Q6_BT6
before insert on `account`
for each row
begin
		declare v_waitingroom varchar(50);
        select d.department_id into v_waittingroom 
        from departmemt d 
        where d.department_name = 'waittingroom';
        if (new.department_id is null)
        then set new.department_id = v_waittingroom;
	end if;
end $$
delimiter ;
insert into `testingsystem`.`account` (`email`,`user_name`,`position_id`,`create_date`)
values ('1','1','1','1', '2024-07-15 00:00:00');
 


-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng. 
drop trigger if exists Q7_BT7;
delimiter $$
create trigger Q7_BT7
before insert on `answer`
for each row 
begin 
 	 	declare v_countansinques tinyint;
        declare v_countansiscorrects tinyint; 
        select count(a.question_id) into v_countansinques from answer a where a.question_id = new.question_id; 
        select count(1) into v_countansiscorrects from answer a where a.question_id = new.question_id and a.is_correct = new.is_correct; 
        	if (v_countansinques > 4 ) or (v_countansiscorrects >2) then 	 	 
 	 	 	signal sqlstate '12345'
 	 	 	set message_text = ' Ko thể insert thêm data làm ơn ktra lại!';
        end if;
end $$ 
delimiter ;
insert into `testingsystem`.`answer` (`content`, `question_id`, `is_correct`) 
values ('1', '253', 1);
 

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database 
drop trigger if exists Q8_BT8;
delimiter $$
create trigger Q8_BT8 
before insert on `account` 
for each row 
begin 
      if new.gender = 'nam' then
         set new.gender = 'm'; 
 	  elseif new.gender = 'nu' then
         set new.gender = 'f'; 
 	  elseif new.gender = 'chưa xác định' then
         set new.gender = 'u'; 
 	  end if ; 
end $$
delimiter ;
 

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày 
drop trigger if exists Q9_BT9; 
delimiter $$
create trigger Q9_BT9
drop trigger if exists Q9_BT91;
delimiter $$
create trigger Q9_BT91
before delete on `exam` 
for each row 
begin
     declare v_create_date datetime;
     set v_create_date =  date_sub(now(),interval 2 day);
     if (old.create_date > v_create_date) then
 	 	signal sqlstate '12345'
         set message_text = 'Ko thể delete trong exam!';
 	  end if ;      
end $$ 
delimiter ;
delete from exam e where e.exam_id =1;
 

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào 
drop trigger if exists Q10_BT10;
delimiter $$
create trigger Q10_BT10
before update on `question`
for each row
begin
     declare v_countquesbyid tinyint;
     set v_countquesbyid =  -1;
     select count(1) into v_countquesbyid from examquestion ex  where ex.question_id = new.question_id;
     if (v_countquesbyid != -1) then
 	 	 signal sqlstate '12345'
         set message_text = 'Ko thể update trong question';
 	  end if ;      
end $$ 
delimiter ;
update `testingsystem`.`question` set `content` = 'question vti 2599 ll6 1' 
where (`question_id` = '253');







