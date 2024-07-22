-- Active: 1720589160551@@127.0.0.1@3306@hr

-- 1. 사원번호를 입력 받으면 다음과 같이 출력되는 PROCEDURE를 작성하라
-- Purchasing 부서의 Alexander사원입니다
DROP PROCEDURE IF EXISTS getInfo;

DELIMITER //

CREATE PROCEDURE getInfo(IN empno INT)
BEGIN
    SELECT CONCAT(d.department_name, ' 부서의 ', CONCAT(e.first_name, ' ', e.last_name), ' 사원입니다.')
    FROM employees e
    INNER JOIN departments d ON e.department_id = d.department_id
    WHERE e.employee_id = empno;
END//

CREATE PROCEDURE getDeptName(in empno int, out dname VARCHAR(30), out ename VARCHAR(30))
BEGIN
    SELECT 
        department_name,
        CONCAT(e.first_name, ' ', e.last_name)
        INTO dname, ename
    FROM employees e
    INNER JOIN departments d ON e.department_id = d.department_id
    WHERE e.employee_id = empno;
END//

DELIMITER ;


call getInfo(150);

call getDeptName(150, @dname, @ename);
SELECT CONCAT(@dname, ' 부서의 ',@ename, ' 사원입니다.');

-- 2. 사원번호를 입력받고, 소속부서의 최고, 최저연봉 차액을 파라미터로 출력하는 PROCEDURE를 작성하라.
DROP PROCEDURE IF EXISTS getMaxMinSal;
DELIMITER //

CREATE PROCEDURE getMaxMinSal(IN empno INT)
BEGIN
    DECLARE min_salary INT;
    DECLARE max_salary INT;
    DECLARE salary_diff INT;

    -- 부서 id 추출
    DECLARE deptno int;
    SELECT department_id into deptno
    FROM employees
    where employee_id = empno;


    -- min과 max salary 계산
    SELECT 
        MIN(salary) , 
        MAX(salary) 
    INTO 
        min_salary, 
        max_salary
    FROM employees 
    where department_id = deptno;

    -- 차액 계산
    SET salary_diff = max_salary - min_salary;

    -- 결과 반환
    SELECT deptno as department_id, min_salary, max_salary, salary_diff AS 차액;
END//

DELIMITER ;

call getMaxMinSal(130);


-- 강사님
DELIMITER //

create Procedure deptDiffMoney(in empno DOUBLE, OUT diff double)
BEGIN

    DECLARE deptno int;
-- 부서번호를 취득
    SELECT department_id INTO deptno
    FROM employees
    WHERE employee_id =empno;

-- 차액을 구함
    SELECT (MAX(salary) - MIN(salary)) into diff
    FROM employees
    WHERE department_id = deptno;
END

DELIMITER ;

CALL deptDiffMoney(130, @diff);
SELECT @diff;

-- 3. 부서번호를 입력하면 해당 부서에서 근무하는 사원 수를 반환하는 함수를 정의하시오.


DELIMITER //

CREATE Function totalEmp(deptno INT) returns INT

BEGIN
    
    DECLARE result INT;

    SELECT count(*) into result
    from employees 
    WHERE department_id = deptno;


    RETURN result ;

END;
//

DELIMITER ;

set @deptName =  totalEmp(50);
SELECT @deptName;



-- 4. employees 테이블의 사원번호를 입력하면 해당 사원의 관리자 이름을 구하는 함수를 정의하시오.

DROP FUNCTION IF EXISTS getMgrName;
DELIMITER //

CREATE FUNCTION getMgrName(empno INT) RETURNS VARCHAR(40)
BEGIN
    DECLARE mgrName VARCHAR(40);

    SELECT mgr.first_name INTO mgrName
    FROM employees emp
    INNER JOIN employees mgr
        ON emp.manager_id = mgr.employee_id
    WHERE emp.employee_id = empno;

    RETURN mgrName;
END//


DELIMITER ;

SELECT getMgrName(130);

/* 5. employees 테이블을 이용해서 사원번호를 입력하면 급여 등급을 구하는 함수를 정의하시오.
18000 ~ 24000 A, 
12000 ~ 18000 미만 B, 
8000 ~ 12000 미만 C, 
3000 ~ 8000 미만 D, 
그 외에는 F, */
DROP FUNCTION IF EXISTS getSalaryGrade;

DELIMITER //

CREATE FUNCTION getSalaryGrade(empno INT) RETURNS CHAR(1)
BEGIN
    DECLARE sal DECIMAL(15,2);
    DECLARE grade CHAR(1);

    -- 급여 조회
    SELECT salary INTO sal
    FROM employees
    WHERE employee_id = empno;

    -- 급여 등급 결정
    IF sal >= 18000 AND sal <= 24000 THEN
        SET grade = 'A';
    ELSEIF sal >= 12000 AND sal < 18000 THEN
        SET grade = 'B';
    ELSEIF sal >= 8000 AND sal < 12000 THEN
        SET grade = 'C';
    ELSEIF sal >= 3000 AND sal < 8000 THEN
        SET grade = 'D';
    ELSE
        SET grade = 'F';
    END IF;

    RETURN grade;
END//

DELIMITER ;

SELECT getSalaryGrade(100);