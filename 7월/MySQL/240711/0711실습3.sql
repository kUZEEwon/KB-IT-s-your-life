-- Active: 1720592554039@@127.0.0.1@3306@hr
-- select2 에 대한 풀이
-- 정렬
-- 문제1) EMPLOYEES 테이블에서 입사일자 순으로 정렬한 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하라.
SELECT employee_id,first_name,job_id, salary,hire_date,department_id
FROM employees
ORDER BY hire_date; 

-- 문제2) EMPLOYEES 테이블에서 가장 최근에 입사한 순으로 정렬한 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하라.
SELECT employee_id,first_name,job_id, salary,hire_date,department_id
FROM employees
ORDER BY hire_date DESC;

-- 문제3) EMPLOYEES 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우 급여가 많은 순으로 정렬한 사원번호, 성명, 업무, 부서번호, 급여를 출력하여라.
SELECT employee_id, first_name, job_id, department_id, salary
FROM employees
ORDER BY department_id ASC, salary DESC;

-- 문제4) EMPLOYEES 테이블에서 첫번째 정렬은 부서번호로 두번째 정렬은 업무로 세번째 정렬은 급여가 많은 순으로 정렬한 사원번호, 성명, 입사일자, 부서번호, 업무, 급여를 출력하여라.
SELECT employee_id, first_name, hire_date,department_id,job_id,  salary
FROM employees
ORDER BY department_id ASC, job_id DESC, salary DESC;


-- hr 그룹핑
-- 문제1) EMPLOYEES 테이블에서 모든 SALESMAN(SA_)에 대하여 급여의 평균, 최고액, 최저액, 합계를 구하여 출력하여라.
SELECT job_id, avg(salary), max(salary), min(salary), sum(salary)
FROM employees
GROUP BY job_id
HAVING job_id LIKE "SA_%";


-- 문제2) EMPLOYEES 테이블에 등록되어 있는 인원수, 보너스가 NULL이 아닌 인원수, 보너스의 평균, 등록되어 있는 부서의 수를 구하여 출력하라.
-- count : null이 아닌 행을 셈
SELECT 
    COUNT(*) AS total_employees,
    COUNT(commission_pct) AS employees_with_bonus,
    AVG(commission_pct) AS average_bonus,
    COUNT(DISTINCT department_id) AS total_departments
FROM employees;

-- 문제3) EMPLOYEES 테이블에서 부서별로 인원수, 평균 급여, 최저급여, 최고 급여, 급여의 합을 구하여 출력하라.
SELECT 
    department_id,
    COUNT(*) AS employee_count,                -- 부서별 인원수
    AVG(salary) AS average_salary,             -- 부서별 평균 급여
    MIN(salary) AS minimum_salary,             -- 부서별 최저 급여
    MAX(salary) AS maximum_salary,             -- 부서별 최고 급여
    SUM(salary) AS total_salary                -- 부서별 급여의 합
FROM 
    employees
GROUP BY 
    department_id;

-- 문제4) EMPLOYEES 테이블에서 각 부서별로 인원수,급여의 평균, 최저 급여, 최고 급여, 급여의 합을 구하여 급여의 합이 많은 순으로 출력하여라.
SELECT 
    department_id,
    COUNT(*) AS employee_count,                -- 부서별 인원수
    AVG(salary) AS average_salary,             -- 부서별 평균 급여
    MIN(salary) AS minimum_salary,             -- 부서별 최저 급여
    MAX(salary) AS maximum_salary,             -- 부서별 최고 급여
    SUM(salary) AS total_salary                -- 부서별 급여의 합
FROM 
    employees
GROUP BY 
    department_id
ORDER BY total_salary DESC;

-- 문제5) EMPLOYEES 테이블에서 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하여라.
SELECT 
    department_id,
    job_id,
    COUNT(*) AS employee_count,                -- 부서별, 업무별 인원수
    AVG(salary) AS average_salary,             -- 부서별, 업무별 급여의 평균
    SUM(salary) AS total_salary                -- 부서별, 업무별 급여의 합
FROM 
    employees
GROUP BY 
    department_id, 
    job_id;

-- 문제6) EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 구하여 출력하여라
SELECT department_id, count(*) as department_people, sum(salary)
FROM 
    employees
GROUP BY department_id
HAVING department_people>4;

-- 문제7) EMPLOYEES 테이블에서 급여가 최대 10000이상인 부서에 대해서 부서번호, 평균 급여, 급여의 합을 구하여 출력하여라.
SELECT department_id, AVG(salary) as avg_salary ,sum(salary) as total_salary
FROM 
    employees
GROUP BY department_id
HAVING total_salary >= 10000;

-- 문제8) EMPLOYEES 테이블에서 업무별 급여의 평균이 10000 이상인 업무에 대해서 업무명,평균 급여, 급여의 합을 구하여 출력하라.
SELECT job_id, AVG(salary) as avg_salary ,sum(salary) as total_salary
FROM 
    employees
GROUP BY job_id
HAVING total_salary >= 10000;

-- 문제9) EMPLOYEES 테이블에서 전체 월급이 10000을 초과하는 각 업무에 대해서 업무와 월급여 합계를 출력하라. 
-- 단 판매원(SA_)은 제외하고 급여 합계로 정렬(내림차순)하라.
SELECT 
    job_id, 
    SUM(salary) AS total_salary
FROM 
    employees
WHERE 
    job_id NOT LIKE 'SA_%'  -- 'SA_'로 시작하는 업무를 제외
GROUP BY 
    job_id
HAVING 
    SUM(salary) > 10000     -- 전체 월급이 10,000을 초과하는 경우
ORDER BY 
    total_salary DESC;      -- 급여 합계로 내림차순 정렬
