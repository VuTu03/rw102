-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS sp_store1;
DELIMITER $$
CREATE PROCEDURE sp_store1(IN dep_name NVARCHAR(50))
BEGIN
 	SELECT acc.account_id, acc.full_namme, d.department_name 
    FROM `account` acc
 	INNER JOIN department d ON d.department_id = acc.department_id
 	WHERE d.department_name = dep_name;
END$$
DELIMITER ;
Call sp_store1('Sale');
 

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS sp_store2;
DELIMITER $$
CREATE PROCEDURE sp_store2(IN group_name NVARCHAR(50))
BEGIN
 	SELECT g.groupname, count(ga.account_id) AS SL FROM groupaccount ga
 	INNER JOIN `group` g ON ga.group_id = g.group_id
 	WHERE g.group_name = group_name;
END$$
DELIMITER ;
Call sp_store2('Testing System');

  
-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS sp_store3;
DELIMITER $$
CREATE PROCEDURE sp_store3()
BEGIN
	SELECT tq.type_name, count(q.type_id) FROM question q
	INNER JOIN typequestion tq ON q.type_id = tq.type_id
	WHERE month(q.create_date) = month(now()) AND year(q.create_date) = year(now())
	GROUP BY q.TypeID;
END$$
DELIMITER ;
Call sp_store3();
 

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS sp_store4;
DELIMITER $$
CREATE PROCEDURE sp_store4()
BEGIN
 	WITH CTE_Maxtype_id AS(
 	 	SELECT count(q.type_id) AS Soluong FROM question q
 	 	GROUP BY q.type_id 
 	 	)
 	SELECT tq.type_name, count(q.type_id) AS Soluong FROM question q
 	INNER JOIN typequestion tq ON tq.type_id = q.type_id
 	GROUP BY q.type_id
 	HAVING count(q.type_id) = (SELECT MAX(Soluong) FROM CTE_Maxtype_id);
END$$
DELIMITER ;
Call sp_store4();
 

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS sp_store5;
DELIMITER $$
CREATE PROCEDURE sp_store5()
BEGIN
 	WITH CTE_Maxtype_id AS(
 	 	SELECT count(q.type_id) AS Soluong FROM question q
 	 	GROUP BY q.type_id 
 	 	)
 	SELECT tq.type_name, count(q.type_id) AS Soluong FROM question q
 	INNER JOIN typequestion tq ON tq.type_id = q.type_id
 	GROUP BY q.type_id
 	HAVING count(q.type_id) = (SELECT MAX(Soluong) FROM CTE_Maxtype_id);
END$$
DELIMITER ;
Call sp_store5();
Call sp_store4(@ID);
SELECT * FROM typequestion WHERE type_id = @ID;


-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào 
DROP PROCEDURE IF EXISTS sp_store6;
DELIMITER $$
CREATE PROCEDURE sp_store6( IN var_String VARCHAR(50)) 
BEGIN
 	 	SELECT g.group_name FROM `group` g WHERE g.group_name LIKE 
CONCAT("%",var_String,"%")
 	 	UNION
 	 	SELECT a.user_name FROM `account` a WHERE a.user_name LIKE 
CONCAT("%",var_String,"%");
END$$ 
DELIMITER ;
Call sp_store6('s');
 

DELIMITER $$
CREATE PROCEDURE sp_store6( IN var_String VARCHAR(50), IN flag TINYINT) 
BEGIN
IF flag = 1 THEN
	 	SELECT g.group_name FROM `group` g WHERE g.group_name LIKE
CONCAT("%",var_String,"%"); 
ELSE
	 	SELECT a.user_name FROM `account` a WHERE a.user_name LIKE
CONCAT("%",var_String,"%");
END IF;
END$$
DELIMITER ;
Call sp_store6('s',1);
 
 
DROP PROCEDURE IF EXISTS sp_store6_Union; 
DELIMITER $$ 
CREATE PROCEDURE sp_store6_Union ( IN var_String VARCHAR(50)) 
BEGIN 
 	 	SELECT g.group_name AS name_group_user_name FROM `group` g WHERE g.group_name LIKE CONCAT("%",var_String,"%") 
        UNION 
 	 	SELECT a.user_name FROM `account` a WHERE a.user_name LIKE 
CONCAT("%",var_String,"%"); 
END$$ 
DELIMITER ; 
 
Call sp_store6_Union('te');
 

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:  
 	-- username sẽ giống email nhưng bỏ phần @..mail đi  	
-- positionID: sẽ có default là developer 
	 	-- departmentID: sẽ được cho vào 1 phòng chờ 
 -- Sau đó in ra kết quả tạo thành công 
DROP PROCEDURE IF EXISTS sp_store7; 
DELIMITER $$ 
CREATE PROCEDURE sp_store7 
( 	IN var_email VARCHAR(50), 
 	IN var_full_name VARCHAR(50)) 
BEGIN 
 	DECLARE v_user_name VARCHAR(50) DEFAULT SUBSTRING_INDEX(var_email, '@', 1); 
 	DECLARE v_department_id  TINYINT UNSIGNED DEFAULT 11; 
 	DECLARE v_position_id TINYINT UNSIGNED DEFAULT 1; 
                  DECLARE v_create_date DATETIME DEFAULT now(); 
 	INSERT INTO account(email, user_name, full_name, department_id, position_id, create_date)  
 VALUES       (var_email, v_user_name, var_full_name, v_department_id, v_position_id, v_create_date); 
END$$
DELIMITER ;
Call sp_store7('vutu@gmail.com','Vu Tu');
 


-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất 
DROP PROCEDURE IF EXISTS sp_getMaxNameQuesFormNameType;
DELIMITER $$
CREATE PROCEDURE sp_getMaxNameQuesFormNameType(IN var_Choice VARCHAR(50)) 
BEGIN 
DECLARE v_TypeID TINYINT UNSIGNED;
    SELECT tq.TypeID INTO v_TypeID FROM typequestion tq  
WHERE tq.TypeName = var_Choice; 
IF var_Choice = 'Essay' THEN     
	 	WITH CTE_LengContent AS(
	 	 	SELECT length(q.Content) AS leng FROM question q
	 	 	WHERE TypeID = v_TypeID) 
	 	 	 	SELECT * FROM question q
	 	 	 	WHERE TypeID = v_TypeID 
	 	 	 	AND length(q.Content) = (SELECT MAX(leng) FROM
CTE_LengContent); 
ELSEIF var_Choice = 'Multiple-Choice' THEN 
	 	WITH CTE_LengContent AS( 
	 	 	SELECT length(q.Content) AS leng FROM question q
	 	 	WHERE TypeID = v_TypeID) 
	 	 	 	SELECT * FROM question q
	 	 	 	WHERE TypeID = v_TypeID 
	 	 	 	AND length(q.Content) = (SELECT MAX(leng) FROM
CTE_LengContent); 
END IF;
END$$
DELIMITER ;
 


-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID 
DROP PROCEDURE IF EXISTS sp_store9;
DELIMITER $$
CREATE PROCEDURE sp_store9 (IN in_exam_id TINYINT UNSIGNED)
BEGIN
 	DELETE FROM examquestion WHERE 	exam_id = in_exam_id;
 	DELETE FROM exam WHERE 	exam_id = in_exam_id; 
END$$
DELIMITER ;
CALL sp_store9(7);
 

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa) 
          -- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing 
DROP PROCEDURE IF EXISTS sp_store10;
DELIMITER $$
CREATE PROCEDURE sp_store10 (IN var_choice VARCHAR(50)) 
BEGIN
DECLARE v_type_id TINYINT UNSIGNED;
    SELECT tq.type_id INTO type_id FROM typequestion tq  
WHERE tq.type_name = var_choice;
IF var_choice = 'Essay' THEN
	 	WITH CTE_LengContent AS(
	 	 	SELECT length(q.Content) AS leng FROM question q
	 	 	WHERE type_id = v_type_id)
	 	 	 	SELECT * FROM question q
	 	 	 	WHERE type_id = v_type_id 
	 	 	 	AND length(q.Content) = (SELECT MAX(leng) FROM CTE_LengContent)
; 
ELSEIF var_choice = 'Multiple-Choice' THEN
	 	WITH CTE_LengContent AS(
	 	 	SELECT length(q.Content) AS leng FROM question q
	 	 	WHERE type_id = v_type_id)
	 	 	 	SELECT * FROM question q
	 	 	 	WHERE type_id = v_type_id 
	 	 	 	AND length(q.Content) = (SELECT MAX(leng) FROM CTE_LengContent); 
END IF;
END$$
DELIMITER ;
 

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS sp_store11; 
DELIMITER $$ 
CREATE PROCEDURE sp_store11(IN var_department_name VARCHAR(30)) BEGIN 
 	DECLARE v_department_id VARCHAR(30) ; 
    SELECT d1.department_id   INTO v_department_id FROM department d1 WHERE d1.department_name = var_department_name; 
 	UPDATE `account` acc SET acc.department_id  = '11' WHERE acc.department_id = v_department_id; 
 	DELETE FROM department d WHERE d.department_name = var_department_name; 
END$$ 
DELIMITER ; 
Call sp_store11('Marketing'); 
 
 
-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS sp_store12; 
DELIMITER $$ 
CREATE PROCEDURE sp_store12() 
BEGIN 
 	WITH CTE_12Months AS ( 
 	         SELECT 1 AS MONTH 
             UNION SELECT 2 AS MONTH 
             UNION SELECT 3 AS MONTH 
             UNION SELECT 4 AS MONTH 
             UNION SELECT 5 AS MONTH 
             UNION SELECT 6 AS MONTH 
             UNION SELECT 7 AS MONTH 
             UNION SELECT 8 AS MONTH 
             UNION SELECT 9 AS MONTH 
             UNION SELECT 10 AS MONTH 
             UNION SELECT 11 AS MONTH 
             UNION SELECT 12 AS MONTH 
) 	 
SELECT M.MONTH, count(month(q.create_date)) AS SL  FROM CTE_12Months M 
LEFT JOIN (SELECT * FROM question q1 WHERE year(q1.create_date) = year(now()) )  q  
ON M.MONTH = month(q.create_date)  
GROUP BY M.MONTH; 
END$$ 
DELIMITER ; 
Call sp_store12(); 
 
-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất  
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong  tháng") 
DROP PROCEDURE IF EXISTS sp_store13;
DELIMITER $$ 
CREATE PROCEDURE sp_store13()
BEGIN
 	WITH CTE_Talbe_store13 AS (
 	 	 	SELECT MONTH(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS MONTH,
YEAR(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS `YEAR`
 	 	 	UNION
 	 	 	SELECT MONTH(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS MONTH,
YEAR(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS `YEAR`
 	 	 	UNION 
 	 	 	SELECT MONTH(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS MONTH,
YEAR(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS `YEAR`
 	 	 	UNION 
 	 	 	SELECT MONTH(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS MONTH,
YEAR(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS `YEAR`
	 	 	UNION 
	 	 	SELECT MONTH(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS MONTH,
YEAR(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS `YEAR`
	 	 	UNION
	 	 	SELECT MONTH(NOW()) AS MONTH, YEAR(NOW()) AS `YEAR`) 
	 	SELECT M.MONTH,M.YEAR, CASE
	 	 	 	WHEN COUNT(question_id) = 0 THEN 'không có câu hỏi nào trong tháng' 
                ELSE COUNT(question_id) 
	 	 	 	END AS SL
	 	FROM CTE_Talbe_store13 M 
	 	LEFT JOIN (SELECT * FROM question where create_date >= DATE_SUB(NOW(),
INTERVAL 6 MONTH) AND create_date <= now()) AS Sub_question ON M.MONTH =
MONTH(create_date)
	 	GROUP BY M.MONTH
	 	ORDER BY M.MONTH ASC;
END$$
DELIMITER ;

CALL sp_store13;
 


