-- Active: 1720589160551@@127.0.0.1@3306@hr
-- 문제1) 사원들의 이름, 부서번호, 부서명을 출력하라
SELECT e.first_name, e.department_id, d.department_id, department_name
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id;

-- 문제2) 30번 부서의 사원들의 이름, 직업, 부서명을 출력하라
SELECT employee_id, 
    first_name AS 이름, 
    j.job_id,
    j.job_title AS 직업,
    e.department_id,
    d.department_id, 
    d.department_name AS 부서명
FROM employees e, departments d, jobs j
WHERE  e.department_id = d.department_id
AND e.job_id = j.job_id
AND e.department_id=30;

-- 문제3) 커미션을 받는 사원의 이름, 직업, 부서번호, 부서명을 출력하라
SELECT 
    e.first_name AS 이름, 
    e.job_id AS 직업,
    e.department_id AS 부서번호, 
    d.department_name AS 부서명
FROM employees e, departments d
WHERE  e.department_id = d.department_id
AND e.commission_pct is not NULL;

-- 문제4) 지역번호 2500 에서 근무하는 사원의 이름, 직업, 부서번호, 부서명을 출력하라
SELECT 
    e.first_name AS 이름, 
    j.job_title AS 직업,
    e.department_id AS 부서번호, 
    d.department_name AS 부서명,
    l.city AS 도시
from employees e, departments d, jobs j, locations l
WHERE e.department_id = d.department_id
AND e.job_id = j.job_id
AND d.location_id = l.location_id
AND l.location_id = 2500;

SELECT 
    e.first_name AS 이름, 
    e.job_id AS 직업,
    e.department_id AS 부서번호, 
    d.department_name AS 부서명,
    d.location_id AS 도시
from employees e, departments d
WHERE e.department_id = d.department_id
AND d.location_id = 2500;


-- 문제5) 이름에 A가 들어가는 사원들의 이름과 부서이름을 출력하라
SELECT 
    CONCAT(e.first_name, e.last_name) AS 이름,  
    d.department_name AS 부서이름
FROM employees e 
INNER JOIN departments d
ON e.department_id = d.department_id
WHERE CONCAT(e.first_name, e.last_name) LIKE '%A%';


-- 문제6) 사원이름과 그 사원의 관리자 이름을 출력하라
SELECT 
    CONCAT(emp.first_name, emp.last_name) AS 사원이름,
    CONCAT(mgr.first_name, mgr.last_name) AS 관리자이름
FROM employees emp
INNER JOIN employees mgr -- emp 사원, mgr 매니저
    ON emp.manager_id = mgr.employee_id;


-- 문제7) 사원이름과 부서명과 월급을 출력하는데 월급이 6000 이상인 사원을 출력하라
SELECT
    CONCAT(e.first_name, e.last_name) AS 이름, 
    d.department_name as 부서명,
    e.salary as 월급
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
WHERE salary >= 6000;


-- 문제8) first_name 이 TJ 이란 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하라
SELECT 
    CONCAT(e.first_name, e.last_name) AS 이름,
    e.hire_date AS 입사일
FROM 
    employees e
JOIN 
    employees tj
ON 
    e.hire_date > tj.hire_date
WHERE 
    tj.first_name = 'TJ';


SELECT 
    CONCAT(e.first_name, e.last_name) AS 이름,
    e.hire_date AS 입사일
FROM 
    employees e, employees tj
WHERE
    e.hire_date > tj.hire_date
AND
    tj.first_name = 'TJ';

-- 문제9) 급여가 3000에서 5000사이인 사원의 이름과 소속부서명 출력하라
SELECT 
    CONCAT(e.first_name, e.last_name) AS 이름,
    department_name as 소속부서
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.salary BETWEEN 3000 and 5000;

-- 문제10) ACCOUNTING 부서 소속 사원의 이름과 입사일 출력하라
SELECT 
    CONCAT(e.first_name, e.last_name) AS 이름,
    e.hire_date AS 입사일
FROM 
    employees e INNER JOIN 
    departments d
ON 
    e.department_id = d.department_id
WHERE 
    d.department_name = 'ACCOUNTING';


-- 문제11) 급여가 3000이하인 사원의 이름과 급여, 근무지를 출력하라
SELECT 
    CONCAT(e.first_name, e.last_name) AS 이름,
    e.salary as 급여,
    l.city AS 근무지
from employees e, departments d, locations l
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id
AND e.salary <= 3000;


-- 문제12) 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과  함께 표시하고 레이블 명을 각각 emp name, emp hired, mgr name, mgr hired 로 지정하라.
SELECT 
    CONCAT(e.first_name, e.last_name) AS emp_name,
    e.hire_date AS emp_hired,
    CONCAT(mgr.first_name, mgr.last_name) AS mgr_name,
    mgr.hire_date AS mgr_hired
FROM 
    employees e
JOIN 
    employees mgr
ON 
    e.hire_date < mgr.hire_date
WHERE 
    e.manager_id = mgr.employee_id;

SELECT 
    CONCAT(e.first_name, e.last_name) AS emp_name,
    e.hire_date AS emp_hired,
    CONCAT(mgr.first_name, mgr.last_name) AS mgr_name,
    mgr.hire_date AS mgr_hired
FROM 
    employees e, employees mgr
WHERE 
    e.manager_id = mgr.employee_id
AND
    e.hire_date < mgr.hire_date;  

-- 문제13) 지역별로 근무하는 사원의 수가 5명 이하인 경우, 사원이 적은 도시순으로 정렬하고 사원수와 city를 출력하시오.

SELECT 
    l.city AS city,
    count(*) as 사원수
from employees e, departments d, locations l
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id
GROUP BY l.city
HAVING COUNT(*) <= 5
ORDER BY COUNT(*) ASC;

SELECT 
    d.location_id as 지역번호,
    l.city AS city,
    count(*) as 사원수
from employees e 
    INNER JOIN departments d
    ON e.department_id = d.department_id
        INNER JOIN locations l
        ON d.location_id = l.location_id
GROUP BY d.location_id
HAVING COUNT(*) <= 5
ORDER BY COUNT(*) ASC;

-- 문제14) 지정한 부서번호, 사원이름 및 지정한 사원과 동일한 부서에서 근무하는 모든 사원을 표시하도록 하고 부서번호는 deptno, 사원이름은 사원, 동일한 부서에서 근무하는 사원은 동료로 표시하시오.
-- (부서번호, 사원이름, 동료 순으로 오름차순 정렬)

-- self join 으로 동일한 부서에서 근무하는 사원 찾기 

SELECT 
    e1.department_id AS deptno,
    CONCAT(e1.first_name, e1.last_name) AS 사원,
    CONCAT(e2.first_name, e2.last_name) AS 동료
FROM 
    employees e1
JOIN 
    employees e2 ON e1.department_id = e2.department_id AND e1.employee_id != e2.employee_id
ORDER BY 
    e1.department_id ASC,
    e1.first_name ASC,
    e2.first_name ASC;

SELECT 
    e1.department_id AS deptno,
    CONCAT(e1.first_name, e1.last_name) AS 사원,
    CONCAT(e2.first_name, e2.last_name) AS 동료
FROM 
    employees e1, employees e2 
WHERE 
    e1.department_id = e2.department_id 
    AND 
    e1.employee_id != e2.employee_id
ORDER BY 
    e1.department_id ASC,
    사원 ASC,
    동료 ASC;
