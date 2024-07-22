-- Active: 1720589160551@@127.0.0.1@3306@hr
USE HR;
/* 
    sub query : query안의 query
    기본 쿼리 보다 먼저 실행됨!

    select 단일 row, 단일 column
    from 다중 row, 다중 column
    where 다중 row, 다중 column
 */

-- select
SELECT employee_id, 
( -- 한개의 컬럼만 사용해야 함
    SELECT first_name
    FROM employees
    WHERE employee_id =100
) -- 다중 column은 안된다.
from employees;

SELECT employee_id, first_name, SALARY,
(
    SELECT count(*)
    FROM employees
) as 총원,
(   
    SELECT AVG(SALARY)
    FROM employees
) as 월급평균
from employees;

-- 평균 이하인지 이상인지 평가 가능
SELECT employee_id, first_name, salary,department_id,
(
    SELECT AVG(salary)
    FROM employees
    GROUP BY department_id
    HAVING department_id = 100
) as `100번 부서의 평균`
FROM employees
WHERE department_id = 100;

-- from <- 새로운 테이블을 생성
-- alias 를 붙여서 사용한다.

-- 50번 부서에서 급여가 5000이 넘는 사원을 구해라
select first_name, department_id, salary
from employees
WHERE department_id = 50 
and salary > 5000;

SELECT department_id, employee_id, first_name, salary -- subquery와 동일한 column 사용해야한다.
FROM( 
    SELECT department_id, employee_id, first_name, salary
    from employees
    WHERE department_id = 50
    ) e
WHERE salary>5000;

-- 업무별로 급여의 합계, 인원수, 사원명, 급여를 출력하시오.
SELECT sum(salary),count(*), first_name, salary -- error
FROM employees
GROUP BY job_id;

SELECT e.job_id, j.job_id, j.total_salary, j.cnt, e.first_name, e.salary
FROM employees e, (
                    SELECT job_id, sum(salary) as total_salary, count(*) as cnt
                    FROM employees
                    GROUP BY job_id
                ) j
WHERE e.job_id = j.job_id;

-- where
-- 평균 급여보다 많이 받는 사원
-- 평균 급여를 구하는 것을 subquery로 만들기!
SELECT *    -- error
FROM employees 
WHERE salary > avg(salary); -- group 함수와 섞어서 사용할 수 없다.

-- 맞는 함수
SELECT 
    employee_id, 
    CONCAT(first_name," ",last_name) as name, 
    salary
from employees
where salary  >
    (
    SELECT avg(salary)
    FROM employees
    );

-- 부서번호가 90인 사원의 업무들
SELECT 
    DISTINCT
    CONCAT(first_name," ",last_name) as name, 
    department_id, 
    job_id
from employees
WHERE department_id = 90;

SELECT 
    DISTINCT
    CONCAT(first_name," ",last_name) as name, 
    department_id, 
    job_id
FROM employees
WHERE job_id in (
                    SELECT job_id
                    FROM employees
                    WHERE department_id =90
                );


-- 부서별로 가장 급여를 적게 받는 사원의 급여와 같은 급여를 받는 사원

SELECT 
    department_id,
    CONCAT(first_name, " ", last_name) AS name,
    salary
FROM employees
WHERE salary in (
                SELECT MIN(salary) 
                FROM  employees
                GROUP BY department_id
                )
ORDER BY department_id;
                
-- 부서별로 가장 급여를 적게 받는 사원들만 출력
SELECT 
    department_id,
    CONCAT(first_name, ' ', last_name) AS name,
    salary
FROM employees
WHERE (department_id, salary) in (
                                    SELECT department_id, min(salary)
                                    FROM employees
                                    WHERE department_id is not null
                                    GROUP BY department_id
                                )
ORDER BY department_id, name;


-- 특수 query
/* 
    java substring  == python

    String str =  "안녕하세요 반갑습니다";
    str.substring(0, 5);
 */

SELECT SUBSTR("hello",1, 2) from dual; -- (문자열, 시작위치, 끝나는 위치) : 1부터 시작!, 끝나는 위치 지정안하면 끝까지 반환한다.

SELECT 
    employee_id, 
    CONCAT(first_name, ' ', last_name) AS name,
    phone_number,
    case SUBSTR(phone_number,1,3)
        WHEN '515' THEN '뉴욕'
        WHEN '590' THEN '보스톤'
        WHEN '650' THEN 'LA'
        ELSE '기타 지역'
    END AS 지역
from employees;

/* 
    OVER() 함수
        GROUP BY 를 보강하기 위해서 나온 함수
    SELECT 절에서만 사용이 가능

    PARTITION BY : select 안에서 group by, over 함수 안에서만 사용 가능
 */
SELECT 
    department_id, 
    CONCAT(first_name, ' ', last_name) AS name, 
    count(*)OVER()
from employees;

SELECT 
    department_id, 
    CONCAT(first_name, ' ', last_name) AS name, 
    count(*)OVER(),
    AVG(salary)OVER()
from employees;

-- 현재 총원의 숫자
SELECT department_id, first_name,
    count(*)OVER(PARTITION by department_id) as 총원,
    AVG(salary)OVER(PARTITION by department_id) as 평균급여
from employees;

/* 
    순위 함수
    rank()          1 2 3 3 5 6
    dense_rank()    1 2 3 3 4 5
    row_number()      1 2 3 4 5 6 
 */

SELECT 
    employee_id,
    CONCAT(first_name, ' ', last_name) AS name,
    salary,
    rank()OVER(ORDER BY salary DESC) as "rank",
    dense_rank()OVER(ORDER BY salary DESC) as "dense_rank",
    ROW_NUMBER()OVER(ORDER BY salary DESC) as "ROW_NUMBER"
from employees;

-- 급여 순위(1 ~ 10)
-- limit사용
SELECT first_name, salary
FROM employees
order by salary ASC
LIMIT 10,10;

-- 1. 번호(순위) 할당
-- 2. 범위를 설정

-- ERROR
SELECT 
    ROW_NUMBER()OVER(ORDER BY salary DESC) as r_num,
    CONCAT(first_name, ' ', last_name) AS name,
    salary
FROM employees
WHERE r_num <= 10;

-- SUCCESS
-- 번호까지 매기면서 순서대로 가져오기
SELECT 
    r_num,
    CONCAT(e.first_name, ' ', e.last_name) AS name,
    salary
FROM
    (
    SELECT 
        ROW_NUMBER()OVER(ORDER BY salary DESC) as r_num,
        CONCAT(first_name, ' ', last_name) AS name,
        salary,
        first_name,
        last_name
    FROM employees
    ORDER BY salary DESC
    ) e
WHERE r_num BETWEEN 1 AND 10;