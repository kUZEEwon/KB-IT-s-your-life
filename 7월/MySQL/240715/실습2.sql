-- Active: 1720589160551@@127.0.0.1@3306@hr
USE hr;

/* 
    JOIN 
    2개 이상의 테이블을 연결(외래키, 기본키)해서 데이터를 검색하는 방법
    보통 2개 이상의 행(ROW)들의 공통된 값 기본키, 외래키를 사용해서 JOIN한다.

    목적: 현재 테이블에서 상대 테이블의 컬럼(정보) 값을 산출하기 위한 처리

    기본키: 테이블에서 중복되지 않고 NULL이 아닌 컬럼
    외래키: 다른 테이블에서 PK, UK인 경우가 많고 조인을 하기 위한 컬럼

    JOIN 종류
    INNER JOIN          = 교집합 (제일 중요!!!!!)
    FULL  OUTER JOIN    = 합집합
    CROSS JOIN          =       (쪼금 중요!!)
    OUTER JOIN          
        LEFT OUTER JOIN
        RIGHT OUTER JOIN
    SELF JOIN           (제일 중요!!!!!)
 */

-- INNER JOIN
-- ANSI SQL 
SELECT e.employee_id, 
        e.first_name, 
        e.department_id, 
        d.department_id,
        d.department_name
FROM employees e 
INNER JOIN departments d
ON e.department_id = d.department_id;

-- mySQL
SELECT e.employee_id, 
        e.first_name, 
        e.department_id, 
        d.department_id,
        d.department_name
FROM employees e ,departments d
WHERE e.department_id = d.department_id;

-- JOB_ID가 'IT_PROG'의 업무명을 산출
SELECT 
    employee_id, 
    first_name, 
    e.job_id,
    j.job_id, 
    j.job_title, 
    j.max_salary
FROM employees e ,jobs j
WHERE e.job_id = j.job_id 
AND e.job_id = 'it_prog';

SELECT 
    employee_id, 
    first_name, 
    e.department_id,
    d.department_id, 
    d.department_name, 
    j.job_id,
    j.job_title
FROM employees e, departments d, jobs j
WHERE e.department_id = d.department_id
AND e.job_id = j.job_id;

-- cross join
SELECT 
    employee_id,
    first_name,
    e.department_id,
    d.department_id,
    d.department_name
FROM employees e CROSS join departments d
WHERE first_name = "Steven"
ORDER BY employee_id;

-- outer join
-- full outer
SELECT  
    employee_id,
    first_name,
    e.department_id,
    d.department_id,
    d.department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
UNION
SELECT 
    employee_id,
    first_name,
    e.department_id,
    d.department_id,
    d.department_name
FROM employees e RIGHT OUTER JOIN departments d
ON e.department_id = d.department_id;

-- left
SELECT  
    employee_id,
    first_name,
    e.department_id,
    d.department_id,
    d.department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;

SELECT  
    employee_id,
    first_name,
    e.department_id,
    d.department_id,
    d.department_name
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL;

-- right
SELECT 
    employee_id,
    first_name,
    e.department_id,
    d.department_id,
    d.department_name
FROM employees e RIGHT OUTER JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL;

-- self join : 동일한 테이블을 join하는 것이다.
SELECT 
    emp.employee_id,
    emp.first_name,
    emp.manager_id,
    mgr.employee_id,
    mgr.first_name
from employees emp inner join employees mgr -- emp 사원, mgr 매니저
    on emp.manager_id = mgr.employee_id;