-- Active: 1720589160551@@127.0.0.1@3306@hr
USE HR;
/* 
    sub query : query안의 query
    기본 쿼리 보다 먼저 실행됨!

    select 한개 row, 한개 column
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