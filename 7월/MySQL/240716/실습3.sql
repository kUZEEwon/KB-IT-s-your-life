-- Active: 1720589160551@@127.0.0.1@3306@hr
-- 문제1) EMPLOYEES 테이블에서 Kochhar(last_name)의 급여보다 많은 사원의 사원번호, 이름, 담당업무, 급여를 출력하라.
SELECT 
    employee_id,
    CONCAT(first_name," ",last_name) as name,
    job_id,
    salary
FROM employees
WHERE salary  >  (
                SELECT salary
                from employees
                where last_name = "Kochhar"
                );

-- 문제2) EMPLOYEES 테이블에서 급여의 평균보다 적은 사원의 사원번호, 이름, 담당업무, 급여, 부서번호를 출력하여라.  
SELECT 
    employee_id,
    CONCAT(first_name," ",last_name) as name,
    job_id,
    salary
FROM employees
WHERE salary  <  (
                SELECT avg(salary)
                from employees
                );


-- 문제3) EMPLOYEES 테이블에서 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서를 출력하라
SELECT 
    department_id ,
    MIN(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING MIN(salary) > (
    SELECT MIN(salary)
    FROM employees
    WHERE department_id = 100
);


-- 문제4) 업무별로 최소 급여를 받는 사원의 정보를 사원번호,이름,업무,부서번호를 출력하여라. 
-- 단 업무별로 정렬하여라.
SELECT 
    employee_id,
    CONCAT(first_name, ' ', last_name) AS name,
    job_id
FROM employees
WHERE (job_id, salary) IN (
    SELECT job_id, MIN(salary)
    FROM employees
    GROUP BY job_id
)
AND department_id IS NOT NULL
ORDER BY job_id;


-- 문제5) EMPLOYEES 테이블에서 업무(JOB_ID)가 SA_MAN 사원들의 이름, 업무, 부서명, 근무지(city)를 출력하라.
SELECT
    employee_id,
    CONCAT(first_name, ' ', last_name) AS name,
    job_id,
    l.city
FROM employees e, locations l, departments d
WHERE 
e.department_id = d.department_id
AND
d.location_id = l.location_id
AND
e.job_id = "SA_MAN";

SELECT first_name, job_id, e.department_id, department_name, l.city
FROM
(SELECT first_name, job_id, department_id
from employees
WHERE job_id = "SA_MAN") e , locations l, departments d
WHERE
e.department_id = d.department_id
AND
d.location_id = l.location_id;


-- 문제6) EMPLOYEES 테이블에서 가장 많은 사원을 갖는 MANAGER의 사원번호를 출력하라.

-- manager별로 사원 수 구하기
SELECT
    manager_id,
    COUNT(*) AS employee_count
FROM employees
GROUP BY manager_id
ORDER BY employee_count desc;

SELECT
    manager_id,
    COUNT(*) AS employee_count
FROM employees
GROUP BY manager_id
ORDER BY COUNT(*) DESC
LIMIT 1;


-- 문제7) EMPLOYEES 테이블에서 가장 많은 사원이 속해 있는 부서 번호와 사원수를  출력하라.
SELECT 
    department_id,
    COUNT(*) AS 사원수
FROM employees
GROUP BY department_id
ORDER BY 사원수 desc
LIMIT 1;


-- 문제8) EMPLOYEES 테이블에서 사원번호가 123인 사원의 직업과 같고 사원번호가 192인 사원의 급여(SAL)보다 많은 사원의 사원번호,이름,직업,급여를 출력하라.
-- 1) EMPLOYEES 테이블에서 사원번호가 123인 사원의 직업
SELECT job_id
FROM employees
WHERE employee_id = 123;

-- 2) 사원번호가 192인 사원의 급여(SAL)
SELECT salary
FROM employees
WHERE employee_id = 192;

-- 전체 쿼리
SELECT 
    employee_id,
    CONCAT(first_name, ' ', last_name) AS 'name',
    job_id,
    salary
FROM employees
WHERE job_id =  (
                    SELECT job_id
                    FROM employees
                    WHERE employee_id = 123
                )
AND
salary > (
            SELECT salary
            FROM employees
            WHERE employee_id = 192
        );


-- 문제9)직업(JOB)별로 최소급여를 받는 사원의 정보를 사원번호,이름,업무,부서명을 출력하라.
-- 직업별로 내림차순정렬
SELECT 
    employee_id,
    CONCAT(first_name, ' ', last_name) AS name,
    job_id,
    salary,
    e.department_id,
    department_name
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id
WHERE 
    (job_id, salary) in (
                                    SELECT job_id, min(salary)
                                    FROM employees
                                    WHERE job_id is not null
                                    GROUP BY job_id
                                )
ORDER BY job_id, name DESC;

-- 문제10) EMPLOYEES 테이블에서 50번 부서의 최소 급여를 받는 사원보다 많은 급여를 받는 사원의 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 
-- 단 50번은 제외

-- 1) EMPLOYEES 테이블에서 50번 부서의 최소 급여
SELECT min(salary)
FROM employees
WHERE department_id = 50

-- 2) 전체 쿼리
SELECT 
    employee_id,
    CONCAT(first_name, ' ', last_name) AS name,
    job_id,
    hire_date,
    salary,
    department_id
FROM employees
WHERE salary >  (
                    SELECT min(salary)
                    FROM employees
                    WHERE department_id = 50
                )
    and department_id <> 50
ORDER BY department_id, name DESC;

-- 문제11) 부서별로 커미션이 없는 사원들 중 월급이 가장 높은 사원의 이름, 급여를 출력하시오(부서순으로 정렬).
-- 1) 부서별로 커미션이 없는 사원들의 월급 중 최고월급
SELECT MAX(salary)
FROM employees
WHERE commission_pct is null
GROUP BY department_id;

-- 전체 쿼리
SELECT 
    department_id,
    CONCAT(first_name, ' ', last_name) AS name,
    salary
FROM employees
WHERE (department_id, salary)   in   (
                                        SELECT department_id,MAX(salary)
                                        FROM employees
                                        WHERE commission_pct is null
                                        GROUP BY department_id
                                    )
ORDER BY department_id;

-- 문제12) 각 부서별로 최근에 입사한 사원들의 부서번호, 사원번호, 이름, 입사일을 출력하시오(부서순으로 정렬).
-- 각 부서별로 최근에 입사한 사원들


SELECT
    department_id,
    employee_id,
    CONCAT(first_name, ' ', last_name) AS name,
    hire_date
FROM employees
WHERE (department_id, hire_date) in (
    SELECT department_id, max(hire_date)
    from employees
    GROUP BY department_id
)
ORDER BY department_id;




-- 문제13) 업무가 FI_ACCOUNT 이면 월급을 10% 인상하고 ST_MAN 이면 20% 인상, IT_PROG 이면 30% 인상하고 그 외의 사원들은 10% 인상된 금액이 출력하시오. 
SELECT
    CONCAT(first_name, ' ', last_name) AS name,
    salary,
    CASE 
        WHEN job_id  = "FI_ACCOUNT" THEN  salary * 1.1
        WHEN job_id  = "ST_MAN" THEN  salary * 1.2
        WHEN job_id  = "IT_PROG" THEN  salary * 1.3
        ELSE  salary * 1.1
    END as 인상된월급
FROM employees;


-- 문제14) 월급이 
--     15000 이상이면 A, 
--     14999 ~ 10000 B,
--     9999 ~ 7000 C,
--     6999 ~ 3000 D,
--     그 외는 F 가 출력되도록 하시오.
SELECT
    CONCAT(first_name, ' ', last_name) AS name,
    salary,
    CASE 
        WHEN salary>=15000 THEN  "A"
        WHEN salary BETWEEN 10000 AND 14999 THEN  "B"
        WHEN salary BETWEEN 7000 AND 9999 THEN  "C"
        WHEN salary BETWEEN 3000 AND 6999 THEN  "D"
        ELSE  'F'
    END as GRADE
FROM employees;

-- 문제15) 각 매니저의 부하직원 수와 (매니저)사원명을 구하고 제일 많은 순서부터 5위까지 출력하라.
-- manager_id, first_name, 부하직원수

SELECT
    e.manager_id,
    CONCAT(mgr.first_name, ' ', mgr.last_name) AS name,
    COUNT(*) AS 부하직원수
FROM employees e, employees mgr
WHERE e.manager_id = mgr.employee_id
GROUP BY e.manager_id
ORDER BY 부하직원수 DESC
LIMIT 0,5;

-- 1
SELECT mgr.manager_id, e.first_name, cnt
FROM
(
SELECT manager_id, COUNT(*) as cnt
FROM employees
WHERE manager_id is not NULL
GROUP BY manager_id
) mgr, employees e
WHERE mgr.manager_id = e.employee_id
ORDER BY cnt DESC
limit 0,5;

-- 2

SELECT rnum, mgr, ename, total_employee
FROM
(SELECT -- 2) 순위에 따른 번호를 할당
    ROW_NUMBER()OVER(ORDER BY total_employee DESC) as rnum,
    m.manager_id as mgr, 
    e.first_name as ename,
    total_employee
FROM
(
    SELECT manager_id, COUNT(*) as total_employee   -- 1) 매니저들의 아이디와 사원수
    FROM employees
    WHERE manager_id is not NULL
    GROUP BY manager_id
) m, employees e
WHERE m.manager_id = e.employee_id
ORDER BY total_employee desc) a
WHERE rnum BETWEEN 1 and 5; -- 3) 범위를 설정

