-- Active: 1720589160551@@127.0.0.1@3306@company
-- UNION
/*
    UNION 사용 조건
    - 각 select문의 결과에 포함되는 열의 개수가 동일해야 한다.
    - 각 select문의 결과에 포함되는 열의 데이터 타입이 서로 호환되어야 함
    - 각 SELECT 문의 결과에 포함되는 열의 순서가 동일해야 함
    - 정렬은 전체 UNION 결과에 대해서만 가능하다.
*/
-- 중복된 department_id 제거
SELECT department_id FROM employees
UNION
SELECT department_id FROM departments;

-- 중복된 department_id 포함
SELECT department_id FROM employees
UNION ALL
SELECT department_id FROM departments;

-- department_id를 기준으로 두 테이블의 데이터를 결합하고 중복된 행 제거
-- union 연산 사용할 때 첫번째 SELECT문에서 열 이름이 결정된다. 따라서 두번째 SELECT문의 name 별칭은 무시됨
SELECT department_id, department_name  FROM departments
UNION 
SELECT department_id, CONCAT(first_name, ' ', last_name) AS name FROM employees;

use school;
SELECT *
FROM emp, DEPT
WHERE EMP.DEPTNO =  `DEPT`.DEPTNO
ORDER BY EMPNO;

SELECT E.EMPNO, E.ENAME, E.JOB, E.DEPTNO, D.LOC
FROM DEPT d, EMP e
WHERE d.DEPTNO = e.DEPTNO;

SELECT *
FROM EMP e JOIN dept d
on e.deptno = d.deptno; 

SELECT e1.empno, E1.ENAME, E1.MGR, E2.EMPNO AS MGR_EMPNO, E2.ENAME AS MGR_ENAME
FROM EMP E1 LEFT OUTER JOIN EMP E2
ON E1.MGR = E2.EMPNO
ORDER BY E1.EMPNO, MGR_EMPNO;

USE COMPANY;
CREATE TABLE COMPANY (
ID VARCHAR(50) PRIMARY KEY,
NAME VARCHAR(100),
ADDR VARCHAR(200),
TEL VARCHAR(20)
);
CREATE TABLE PRODUCT (
ID INT PRIMARY KEY,
NAME VARCHAR(50),
CONTENT VARCHAR(100),
PRICE INT,
COMPANY VARCHAR(50),
IMG VARCHAR(50),
FOREIGN KEY (COMPANY) REFERENCES COMPANY(ID)
);
INSERT INTO company (ID, NAME, ADDR, TEL) VALUES
('c100', 'good', 'seoul', '011'),
('c200', 'joa', 'busan', '012'),
('c300', 'maria', 'ulsan', '013'),
('c400', 'my', 'kwangju', '014');
INSERT INTO PRODUCT (ID, NAME, CONTENT, PRICE, COMPANY, IMG)
VALUES
(110, 'food11', 'fun food11', 11000, NULL, '11.png'),
(111, 'food12', 'fun food12', 12000, NULL, '12.png'),
(100, 'food1', 'fun food1', 1000, 'c100', '1.png'),
(101, 'food2', 'fun food2', 2000, 'c200', '2.png'),
(102, 'food3', 'fun food3', 3000, 'c300', '3.png'),
(103, 'food4', 'fun food4', 4000, 'c300', '4.png'),
(104, 'food5', 'fun food5', 5000, 'c100', '5.png'),
(105, 'food6', 'fun food6', 6000, 'c100', '6.png'),
(106, 'food7', 'fun food7', 7000, 'c200', '7.png'),
(107, 'food8', 'fun food8', 8000, 'c300', '8.png'),
(108, 'food9', 'fun food9', 9000, 'c100', '9.png'),
(109, 'food10', 'fun food10', 10000, 'c100', '10.png');

-- INNER JOIN
-- 제품과 그 제품을 만든 회사의 이름을 조회하세요. 회사 정보가 없는 제품은 제외합니다.
SELECT P.ID AS Product_ID, P.NAME AS
Product_Name, C.NAME AS Company_Name
FROM PRODUCT P
INNER JOIN COMPANY C ON P.COMPANY = C.ID;

-- 모든 제품과 그 제품을 만든 회사의 이름을 조회하세요. 회사 정보가 없는 제품도 포함합니다.
SELECT
P.ID AS Product_ID,
P.NAME AS Product_Name, 
C.NAME AS Company_Name
FROM PRODUCT P
LEFT OUTER JOIN COMPANY C
ON P.COMPANY = C.ID;

SELECT
P.ID AS Product_ID,
P.NAME AS Product_Name, C.NAME AS
Company_Name
FROM PRODUCT P
RIGHT OUTER JOIN COMPANY C
ON P.COMPANY = C.ID;

