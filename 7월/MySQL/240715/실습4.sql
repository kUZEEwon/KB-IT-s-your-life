-- Active: 1720589160551@@127.0.0.1@3306@school
use school;
CREATE TABLE EMP (
    EMPNO INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  -- 직원 번호, 기본 키로 자동 증가
    ENAME VARCHAR(50),                             -- 직원 이름
    JOB VARCHAR(50),                               -- 직무
    MGR INT,                                       -- 관리자 번호
    HIREDATE DATE,                                 -- 입사 날짜
    SAL DECIMAL(10, 2),                            -- 급여
    COMM DECIMAL(10, 2),                           -- 커미션
    DEPTNO INT                                     -- 부서 번호
);
CREATE TABLE DEPT (
    DEPTNO INT PRIMARY KEY,  -- 부서 번호, 주 키로 설정
    DNAME VARCHAR(50),       -- 부서 이름, 문자열 데이터 타입
    LOC VARCHAR(100)         -- 부서 위치, 문자열 데이터 타입
);
CREATE TABLE SALGRADE (
    GRADE INT PRIMARY KEY,    -- 직급, 주 키로 설정
    LOSAL DECIMAL(10, 2),     -- 최소 급여, 소수점 2자리까지 포함된 숫자
    HISAL DECIMAL(10, 2)      -- 최대 급여, 소수점 2자리까지 포함된 숫자
);



-- 외래키 연결 
ALTER TABLE EMP ADD (
CONSTRAINT FK_DEPTNO
FOREIGN KEY (DEPTNO)
REFERENCES DEPT (DEPTNO)
);

-- 1.ENAME 의 글자수 검색
SELECT ENAME, LENGTH(ENAME) AS 글자수
FROM EMP;
-- 2.JOB 이 MANAGER 인 사람의 ENAME 글자수 검색
SELECT ENAME, LENGTH(ENAME) AS 글자수, JOB AS 직업
FROM emp
WHERE job = "MANAGER";
-- 3.COMM 이 null 인 사람의 ENAME, JOB 검색
SELECT ENAME, JOB AS 직업
FROM emp
WHERE COMM IS NULL;
-- 4.COMM 이 null 이 아닌 사람의 HIREDATE 검색
SELECT HIREDATE
FROM emp
WHERE COMM IS NOT NULL;
-- 5.ENAME 의 2 번째글자부터 끝까지 검색
SELECT SUBSTR(ENAME, 2)
FROM EMP;
-- 6.JOB 의 1 번째 글자부터 3 번째 글자까지 검색
SELECT SUBSTR(ENAME, 1, 3)
FROM EMP;

-- 7.ENAME 의 글자 중 K 를 P 으로 변경하여 검색
-- REPLACE: 문자열 치환 / REPLACE(문자열, 찾을 문자열, 치환 문자열)
SELECT ENAME, REPLACE(ENAME, 'K', 'P') AS 변경된이름
FROM EMP;

-- 8.ENAME 과 EMPNO 을 이용하여 7369 번은 SMITH 입니다 ' 형식으로 모든 row 출력
SELECT CONCAT(EMPNO, '번은 ', ENAME, '입니다') AS 설명
FROM emp;

-- 9.HIREDATE 이용하여 입사한 월과 연도를 출력
-- HIREDATE를 이용하여 입사한 월과 연도를 출력합니다.
SELECT 
    HIREDATE, 
    MONTH(HIREDATE) AS 입사월, 
    YEAR(HIREDATE) AS 입사연도
FROM emp;

-- 10.JOB 이 MANAGER 이면 level1, SALESMAN 이면 level2, 기타이면 level3 라고 LEVEL_RESULT 컬럼에 출력
SELECT ENAME, JOB,
    CASE 
        WHEN JOB= 'MANAGER' THEN  'level1'
        WHEN JOB= 'SALESMAN' THEN  'level2'
        ELSE  'level3'
    END AS LEVEL_RESULT
FROM EMP;

-- DML 조인
-- 1.DEPTNO 컬럼을 기준으로 두 개의 테이블을 조인 후 , EMPNO, JOB, SAL, COMM, DNAME, LOC 를검색하여 출력하시오 .(INNER JOIN)
SELECT EMPNO, JOB, SAL, COMM, DNAME, LOC
FROM EMP e INNER JOIN dept d
ON e.DEPTNO = d.DEPTNO;
-- 2. EMP 테이블 내에는 일반 직원과 매니저가 함께 저장되어있다 . 일반 직원의 EMPNO, JOB, SAL 과 일반직원을 관리하는 MGR 의 EMPNO, JOB 을 함께 검색하여 출력하시오 .(SELF JOIN)
SELECT e.`EMPNO`, e.`JOB`, e.`SAL`, mgr.`EMPNO`, mgr.`JOB`
FROM emp e, emp mgr
WHERE e.`MGR` = mgr.`EMPNO`;

-- 3. 모든 DEPT_DATA 테이블의 항목이 출력되고 , 두 테이블 간 DEPTNO 가 일치하는 것을 찾아 EMP_DATA 테이블의 DEPTNO, EMPNO, ENAME 항목을 추가 출력되도록 조인하시오 .(OUTER JOIN)
SELECT 
    d.*, 
    e.DEPTNO AS emp_deptno,
    e.EMPNO,
    e.ENAME
FROM 
    DEPT d
LEFT OUTER JOIN 
    EMP e ON d.DEPTNO = e.DEPTNO;
