CREATE DATABASE Testing_System_Assignment_2;
USE Testing_System_Assignment_2;




-- Table 1: department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
	department_id 		INT PRIMARY KEY AUTO_INCREMENT, -- khoá chính tự tăng
    department_name 	VARCHAR(100)
);
SELECT * FROM Department;
INSERT INTO Department(department_name)
	VALUES 	('Marketing'),
			('Kĩ Thuật'),
            ('Bảo Vệ'),
            ('Kế Toán'),
            ('Trưởng phòng');



-- Table 2: Potision
DROP TABLE IF EXISTS Position;
CREATE TABLE `Position`(
Position_id 	INT PRIMARY KEY AUTO_INCREMENT,
Position_name 	ENUM('DEV','Test','Scrum Master','PM','BA')
);
SELECT * FROM Position;
INSERT INTO `Position`(Position_name)
	VALUES 	('DEV'),
			('Test'),
            ('Scrum Master'),
            ('PM'),
            ('BA');


-- Table 3: Account
DROP TABLE IF EXISTS Account;
CREATE TABLE Account(
Account_id 		INT PRIMARY KEY AUTO_INCREMENT,
Email 			VARCHAR(50) UNIQUE,
User_name 		VARCHAR(50) UNIQUE,
Full_name 		VARCHAR(50),
Department_id 	INT,
Position_id 	INT,
Create_date 	DATETIME DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT fk_acc_Dep FOREIGN KEY (Department_id) REFERENCES Department(Department_id),
CONSTRAINT fk_acc_Pos FOREIGN KEY (Position_id) REFERENCES `Position`(Position_id)
);
SELECT * FROM Account;
INSERT INTO Account (Email, User_name, Full_name, Department_id, Position_id)
	VALUES 	('nguyenvanan@gmail.com', 'vanan', 'nguyenvanan', 1, 2),
			('tranminhduc@gmail.com', 'minhduc', 'tranminhduc', 2, 4),
            ('lehoangnam@gmail.com', 'hoangnam', 'lehoangnam', 3, 1),
            ('phamthuytien@gmail.com', 'thuytien', 'phamthuytien', 4, 5),
            ('vuminhquan@gmail.com', 'minhquan', 'vuminhquan', 5, 3); 


-- Table 4: Groups
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
Group_id 		INT PRIMARY KEY AUTO_INCREMENT,
Group_name 		VARCHAR(50),
Create_id 		INT,
Create_date 	DATETIME DEFAULT CURRENT_TIMESTAMP
);
SELECT * FROM `Group`; 
INSERT INTO `Group` (Group_name, Create_id) 
 VALUES ('Lập trình Web', 20),
		('Lập trình Java',15),
        ('Hội người Dev',10),
        ('Mảng IT',17),
        ('IT Helpdesk',30);


-- Table 5: GroupAccount 
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
Group_id 	INT,
Account_id	INT,
Join_date 	DATETIME DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT fk_Group_Gro FOREIGN KEY (Group_id) REFERENCES `Group`(Group_id)
);
SELECT * FROM GroupAccount;
INSERT INTO GroupAccount (Group_id, Account_id)
VALUES (1, 45),
		(2, 53),
        (3, 27),
        (4, 56),
        (5, 18);



-- Table 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion(
Type_id 	INT PRIMARY KEY AUTO_INCREMENT,
Type_name 	ENUM('Essay','Multiple-Choice', 'True-False','Fill-in-the-Blank','Short-Answer')
);
SELECT * FROM TypeQuestion;
INSERT INTO TypeQuestion(Type_name)
	VALUES 	('Essay'),
			('Multiple-Choice'),
            ('True-False'),
            ('Fill-in-the-Blank'),
            ('Short-Answer');



-- Table 7: CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
Category_id 	INT PRIMARY KEY AUTO_INCREMENT,
Category_name 	VARCHAR(50)
);
SELECT * FROM CategoryQuestion;
INSERT INTO CategoryQuestion( Category_name)
	VALUES ('Java'),('NET'),('SQL'),('Postman'),('Ruby');



-- Table 8: Question  
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
Question_id 	INT PRIMARY KEY AUTO_INCREMENT,
Content 		VARCHAR(100),
Category_id 	INT,
Type_id 		INT,
Creator_id 		INT,
Create_date 	DATETIME DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT fk_ques_Cat FOREIGN KEY (Category_id) REFERENCES CategoryQuestion(Category_id),
CONSTRAINT fk_ques_Typ FOREIGN KEY (Type_id) REFERENCES TypeQuestion(Type_id)
);
SELECT * FROM Question;
INSERT INTO Question(Content, Category_id, Type_id, Creator_id)
	VALUES ('Lập trình là gì?', 1, 2, 33),
			('Biến trong lập trình dùng để làm gì?', 2, 5, 14),
            ('Vòng lặp có tác dụng gì?',3, 4, 21),
            ('Hàm (Function) là gì?', 4, 3, 15),
            ('SQL dùng để làm gì?', 5, 1, 32);
    
    



-- Table 9: Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
Answer_id 	INT PRIMARY KEY AUTO_INCREMENT,
Content 	VARCHAR(100),
Question_id INT,
isCorrect 	ENUM('Đúng','Sai'),
CONSTRAINT fk_ans_ques FOREIGN KEY (Question_id) REFERENCES Question(Question_id)
);
SELECT * FROM Answer;
INSERT INTO Answer( Content, Question_id, isCorrect)
	VALUES ('Viết mã để máy tính thực hiện nhiệm vụ.', 1, 'Đúng'),
			('Dùng để lưu trữ dữ liệu.', 2, 'Đúng'),
            ('Lặp lại một đoạn code nhiều lần.', 3, 'Đúng'),
            ('Một khối code thực hiện một nhiệm vụ cụ thể.', 4, 'Đúng'),
            ('Xuất dữ liệu.', 5, 'Sai');



-- Table 10: Exam 
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
Exam_id 	INT PRIMARY KEY AUTO_INCREMENT,
Code 		INT,
Title 		VARCHAR(50),
Category_id INT,
Duration 	TIME,
Creator_id 	INT,
Create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT fk_Ex_Cat FOREIGN KEY (Category_id) REFERENCES CategoryQuestion(Category_id)
);
SELECT * FROM Exam;
INSERT INTO Exam (Code, Title, Duration, Category_id, Creator_id)
	VALUES (1556, 'Ngôn ngữ lập trình', '15:36', 1, 33),
			(2003, 'Cơ sở dữ liệu', '8:41', 2, 14),
            (2006, 'Lập trình Web', '16:55', 3, 21),
            (1032,'Lập trình hướng đối tượng', '21:45', 4, 15),
            (2647, 'Thuật toán & cấu trúc dữ liệu', '10:20', 5, 32);


-- Table 11: ExamQuestion  
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
Exam_id 	INT,
Question_id INT,
CONSTRAINT fk_eq_ex FOREIGN KEY (Exam_id) REFERENCES Exam(Exam_id),
CONSTRAINT fk_eq_ques FOREIGN KEY (Question_id) REFERENCES Question(Question_id)
);
SELECT * FROM ExamQuestion; 
INSERT INTO ExamQuestion (Exam_id, Question_id)
	VALUES ( 1, 2),
			(2, 5),
            (3, 1),
            (4, 5),
            (5, 4);
