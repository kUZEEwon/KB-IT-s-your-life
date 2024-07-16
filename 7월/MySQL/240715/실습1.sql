-- Active: 1720589160551@@127.0.0.1@3306@school
-- 오전 수업용
SELECT UPPER(ENAME) from EMP;
select LENGTH(ENAME) from EMP;

select SUBSTR(ENAME, 2) from EMP; -- 2번째 글자부터 끝까지
select SUBSTR(ENAME, 1, 2) from EMP; -- 1번째 글자부터 2개
select SUBSTR(ENAME, -2) from EMP; -- -2번째 글자부터 끝까지

select REPLACE(ENAME, 'L', 'N') from EMP;
select LPAD(ENAME, 6, '#') from EMP;

select CONCAT(EMPNO, ENAME) from EMP;
select TRIM('W' from ENAME) from EMP;
select TRIM(' hong ') from EMP;

SELECT RIGHT('Hello', 2);
SELECT FIELD('B', 'A', 'B', 'C');

-- 집계/그룹 함수

-- SUM/COUNT/AVG
select COUNT(SAL) from EMP; 
select COUNT(distinct SAL) from EMP;

-- MIN/MAX
select MIN(SAL), MAX(SAL) from EMP;

-- GROUP BY
select AVG(SAL) 
from EMP
GROUP BY DEPTNO; -- DEPTNO별로 SAL의 평균
select AVG(SAL) from EMP
GROUP BY DEPTNO
ORDER BY DEPTNO desc; -- 그룹이 먼저, 정렬이 나중
select AVG(SAL) from EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000 -- 조건은 HAVING으로 써야함.!
ORDER BY DEPTNO desc;

SELECT count(SAL), sum(SAL), round(AVG(SAL)), MIN(SAL), MAX(SAL)
FROM emp
WHERE JOB='SALESMAN';

SELECT job, count(SAL), sum(SAL), round(AVG(SAL)), MIN(SAL), MAX(SAL)
FROM emp
GROUP BY JOB;

SELECT job, count(SAL), sum(SAL), round(AVG(SAL)), MIN(SAL), MAX(SAL)
FROM emp
GROUP BY JOB
HAVING COUNT(SAL) >=4 -- GROUP을 지어서 검색 후, 필터링 하고자 하는 경우
ORDER BY JOB DESC; -- 이미 모든 검색이 다 끝난 후, 그 결과를 정렬하고자 하는 경우, 맨끝
