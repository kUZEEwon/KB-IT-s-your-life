-- Active: 1720589160551@@127.0.0.1@3306@shop
-- student table
CREATE TABLE student (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(50),
    PhoneNumber VARCHAR(15),
    Address VARCHAR(100)
);
-- professor table
CREATE TABLE professor (
    ProfessorName VARCHAR(50) PRIMARY KEY,
    Office VARCHAR(50),
    PhoneNumber VARCHAR(15)
);
-- clubapplication table
CREATE TABLE clubapplication (
    StudentID INT PRIMARY KEY,
    ClubName VARCHAR(50),
    ProfessorName VARCHAR(50),
    FOREIGN KEY (StudentID) REFERENCES student(StudentID),
    FOREIGN KEY (ProfessorName) REFERENCES professor(ProfessorName)
);

INSERT INTO student (StudentID, StudentName, PhoneNumber, Address)
VALUES 
(101, '이영희', '02-234-5678', '서울시 강남구'),
(102, '박철수', '02-345-6789', '서울시 서초구'),
(103, '최수민', '02-456-7890', '서울시 송파구');

INSERT INTO professor (ProfessorName, Office, PhoneNumber)
VALUES 
('김명수', '공학관101호', '02-111-2222'),
('이정민', '공학관202호', '02-333-4444'),
('박지훈', '공학관303호', '02-555-6666');

INSERT INTO clubapplication (StudentID, ClubName, ProfessorName)
VALUES 
(101, '음악', '김명수'),
(102, '미술', '이정민'),
(103, '체육', '박지훈');

-- DML을이용해다음작업을수행하시오.(delete, update, select문이용)
-- 1. ClubName이'음악'인 신청 삭제
delete from clubapplication
WHERE `ClubName`='음악';

-- 2. StudentID가103인학생의주소를'서울시강북구'로수정
UPDATE student
SET Address = '서울시 강북구'
WHERE StudentID = 103;

-- 3. ProfessorName이'박지훈'인교수의연락처를'02-777-8888'로수정
UPDATE professor
SET `PhoneNumber`  = '02-777-8888'
WHERE `ProfessorName` = '박지훈';

-- 4. 모든학생의이름과그들이신청한클럽이름을출력(조인)
SELECT s.`StudentName`, c.`ClubName`
FROM student s INNER JOIN clubapplication c
on s.`StudentID` = c.`StudentID`;

-- 5. 특정동아리(예: '체육')를신청한학생들의이름, 전화번호, 그리고동아리이름을출력(조인)
SELECT s.`StudentName`, s.`PhoneNumber`, c.`ClubName`
FROM student s INNER JOIN clubapplication c
on s.`StudentID` = c.`StudentID`
WHERE `ClubName` = "체육";