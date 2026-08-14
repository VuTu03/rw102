CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;



-- Table 2: Potision
Drop table if exists Potision;
CREATE TABLE Potision(
Potision_id 	INT,
Potision_name 	VARCHAR(50)
);



-- Table 3: Account
Drop table if exists Account;
CREATE TABLE Account(
Account_id 		INT,
Email 			VARCHAR(20),
User_name 		VARCHAR(50),
Full_name 		VARCHAR(50),
Department_id 	INT,
Position_id 	VARCHAR(20),
Create_date 	DATE
);



-- Table 4: Groups
CREATE TABLE Group_1(
Group_id 		INT,
Group_name 		VARCHAR(50),
Create_id 		INT,
Create_date 	DATE
);



-- Table 5: GroupAccount 
create table GroupAccount(
Group_id 	INT,
Account_id	INT,
Join_date 	DATE
);



-- Table 6: TypeQuestion
create table TypeQuestion(
Type_id 	INT,
Type_name 	ENUM('Essay','Multiple-Choice')
);



-- Table 7: CategoryQuestion 
CREATE TABLE CategoryQuestion(
Category_id 	INT,
Category_name 	VARCHAR(50)
);



-- Table 8: Question  
CREATE TABLE Question(
Question_id 	INT,
Content 		VARCHAR(100),
Category_id 	INT,
Type_id 		INT,
Creator_id 		INT,
Create_date 	DATE
);



-- Table 9: Answer
CREATE TABLE Answer(
Answer_id 	INT,
Content 	VARCHAR(100),
Question_id INT,
isCorrect 	ENUM('Đúng','Sai')
);



-- Table 10: Exam 
CREATE TABLE Exam(
Exam_id 	INT,
Code 		INT,
Title 		VARCHAR(50),
Category_id INT,
Duration 	TIME,
Creator_id 	INT,
Create_date DATE
);



-- Table 11: ExamQuestion  
CREATE TABLE ExamQuestion(
Exam_id 	INT,
Question_id INT
);
