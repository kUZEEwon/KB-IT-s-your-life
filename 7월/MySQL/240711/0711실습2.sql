-- Active: 1720592554039@@127.0.0.1@3306
/* 
	형식 :
		select 값, 컬럼명, 함수, subquery
		from 테이블 명, sub query

 */
use hr;

select * FROM employees;

SELECT employee_id, last_name, salary
FROM employees;

desc employees;

SELECT '이름:',20, first_name, last_name
FROM employees;

-- 컬럼 별명(alias - as)
select last_name '성', first_name '이름'
from employees;

SELECT first_name, salary * 12 as 연봉
FROM employees;

-- 문자 연산 -> 문자열 합치기 (concat)
SELECT concat('이름 : ',first_name, last_name)
FROM employees;

-- where
/*
	where : 조건절

	=, !=, >, <, >=, <=, <>(다르다)

	IS NULL ( == NULL )
	IS NOT NULL ( != NULL )

	and -> &&
	or -> ||

	like (완젼 중요)
*/

SELECT first_name, salary
FROM employees
WHERE first_name <> "John";


SELECT first_name, salary
FROM employees
WHERE first_name <> "john"; -- oracle에서는 안됨

SELECT first_name, salary
FROM employees
WHERE salary >= 9000;

SELECT first_name
FROM employees
WHERE first_name >= "John";

SELECT first_name, hire_date, salary
FROM employees
WHERE hire_date < "1990-01-01";

SELECT first_name, manager_id
FROM employees
WHERE manager_id IS NULL; -- "" != null(null은 빈칸이 아니다)

SELECT first_name, manager_id, salary
FROM employees
WHERE manager_id IS NOT NULL 
	AND
	salary >= 10000;

SELECT first_name, manager_id, salary
FROM employees
WHERE manager_id IS NULL 
	OR
	salary <= 3000;


/*
	ALL, ANY, IN, EXISTS, BETWEEN
	AND, OR,  OR  			>= <=
*/

SELECT first_name, salary
FROM employees
WHERE salary = ALL(SELECT salary
					From employees
					WHERE salary = 8000);

SELECT first_name, salary
FROM employees
WHERE salary = ANY(SELECT salary
				FROM employees
				WHERE job_id = "it_prog");

SELECT first_name, salary
FROM employees
WHERE salary not in(8000,3200,6000);

SELECT first_name, salary, job_id
FROM employees a
WHERE EXISTS (
	select 1 FROM dual
	WHERE a.job_id = "it_prog"
);

-- BETWEEN
SELECT first_name, salary
FROM employees
WHERE salary >= 3200 and salary <= 9000;

SELECT first_name, salary
FROM employees
WHERE salary NOT BETWEEN 3200 and 9000;

-- LIKE
SELECT first_name, salary
FROM employees
WHERE first_name LIKE "G_ra_d"; -- _는 한글자(뭐가 와도 상관 없다)

SELECT first_name, salary
FROM employees
WHERE first_name LIKE "K%y"; -- %는 문자열을 의미한다.

SELECT first_name, salary
FROM employees
WHERE first_name LIKE "%e%";

SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE "1997-08%";

SELECT first_name, salary
FROM employees
WHERE first_name LIKE "%ni%";

/* 
	order by : sorting, 올림과 내림
 */
SELECT *
FROM employees
ORDER BY salary DESC; -- 월급으로 오름차순 정렬

SELECT employee_id, first_name
FROM employees
ORDER BY employee_id;

SELECT first_name, hire_date
FROM employees
WHERE hire_date like "1999%"
ORDER BY hire_date;

SELECT first_name, salary
FROM employees
ORDER BY salary DESC; 

SELECT first_name, job_id, salary
FROM employees
WHERE job_id = "it_prog"
ORDER BY salary DESC;

SELECT employee_id, first_name,  salary, manager_id
FROM employees
ORDER BY manager_id is NULL ASC; -- NULL은 젤 마지막에 출력
-- DESC : NULL부터 출력

SELECT first_name,  salary, commission_pct
FROM employees
ORDER BY commission_pct is null desc, salary desc;

SELECT first_name,  salary, salary*12 as 연봉
FROM employees
ORDER BY 연봉 desc;

/*
	GROUP BY
	그룹으로 묶는 기능
	1. distinct - select에서만 사용
	2. group by 
*/

SELECT DISTINCT job_id
FROM employees
ORDER BY job_id; -- DISTINCT : 중복을 허용하지 않음

SELECT job_id
FROM employees
GROUP BY job_id -- 중복된 값을 제거
ORDER BY job_id; 

-- 통계
/* 
	그룹 함수
	count
	sum
	avg
	max
	min
 */

SELECT count(*) , sum(salary) , avg(salary), sum(salary)/count(*),
	max(salary),min(salary)
--FROM employees;
WHERE job_id = "it_prog";

-- 각 부서별로 급여 합계, 최고 급여, 평균 급여 구해라
SELECT department_id, sum(salary),max(salary), TRUNCATE(avg(salary),0)
FROM employees
GROUP BY department_id;

SELECT department_id, job_id
FROM employees
GROUP BY department_id, job_id;

-- having : GROUP BY의 조건
SELECT job_id, sum(salary)
FROM employees
GROUP BY job_id
HAVING sum(salary) >=30000;

-- 급여가 5000이상 받은 사원으로 합계를 내서 업무로 그룹화 하여 금여의 합계가 20000을 초과하는 업무명, 사원수, 합계, 평균
SELECT job_id,count(*) ,sum(salary),TRUNCATE(avg(salary),0)
FROM employees
WHERE salary >= 5000
GROUP BY job_id
HAVING sum(salary) > 20000
ORDER BY sum(salary) DESC;