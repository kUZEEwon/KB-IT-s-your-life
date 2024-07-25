-- Active: 1720589160551@@127.0.0.1@3306@hr

/* 
    view:   가상테이블
            실체가 없는 테이블
            (다른 테이블에 접근하기 위한 테이블)
    속도가 빠르다.
    한개의 뷰로 여러개의 테이블을 검색할 수 있다.
 */
SELECT * FROM jobs;
CREATE VIEW ub_test1
as 
SELECT job_id, job_title, max_salary
from jobs;

insert into ub_test1(job_id, job_title, max_salary) VALUES
('DEVELOPER','개발자', 10000);

SELECT * FROM jobs;

DELETE from jobs
WHERE job_id ="developer";

CREATE TABLE tb_emp
AS
SELECT employee_id, CONCAT(first_name, ' ', last_name) AS name, salary
from employees;

CREATE View ub_emp_view
AS
SELECT employee_id, name, salary FROM tb_emp;

INSERT INTO ub_emp_view(employee_id, name, salary) VALUES
(300, '홍길동',12000);

SELECT * from ub_emp_view;

-- 사원번호, 이름, 부서번호, 부서명, 지역명
create VIEW deft_emp_loc_view 
AS
SELECT employee_id, CONCAT(first_name, ' ', last_name) AS name, e.department_id, department_name, city
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id 
AND d.location_id = l.location_id;

SELECT *
FROM deft_emp_loc_view
WHERE employee_id = 133;