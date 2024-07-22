-- Active: 1720589160551@@127.0.0.1@3306@hr
use hr;

-- 프로시저

-- 변수
SELECT @@AUTOCOMMIT;    -- auto commit 확인 (1: true)

-- auto commit 끄기
SET AUTOCOMMIT = false;

SELECT 'HELLO PL' FROM DUAL;

SET @count=1;   -- int count = 1 (변수 설정)
SELECT @count;

SET @message= '안녕하세요';
SELECT @message;

SELECT first_name, salary, @message
from employees;

SET @height = 172.1 +21;
SELECT @height;

-- procedure
/* 
    delimiter $$
                                proc( in s String )
    create Procedure 프로시저명( in 매개변수명 자료형, out 매개변수명 자료형 )
    begin

        query + 제어문

    end$$
    delimiter ;
 */

drop PROCEDURE if EXISTS hello;

delimiter $$
create Procedure hello()
BEGIN
    declare message VARCHAR(20);  -- String message

    SET message := "hello PL";

    SELECT CONCAT('message = ', message);

end$$
-- 다음 쿼리 까지 실행하고 싶은경우 ;를 붙인다.
-- $$을 붙이면 지금 여기 END 구문까지만 실행됨

CREATE PROCEDURE world()
BEGIN
    DECLARE msg DECIMAL(5,1);

    SET msg = 172.1;
    SELECT concat('신장 :', msg);
END$$

create Procedure myproc(in innum int, out outnum int) -- 실행할 땐 outnum에는 변수를 집어넣어야 한다.
BEGIN
    
    SELECT innum;

    SET outnum = 333;
END$$

DELIMITER ;

CALL hello();
CALL world();

CALL myproc(111,@outnumber);
SELECT @outnumber;

INSERT into departments(department_id, department_name, location_id)
VALUES(300, '관리부', 1400);

DELIMITER //

CREATE Procedure add_dept(  in dnum int, 
                            in dname VARCHAR(30), 
                            in lnum INT)
    BEGIN
        DECLARE EXIT HANDLER for 1365
        BEGIN
            SELECT 'Sorry, you cannot divide by zero';
        END;    
        INSERT into departments(department_id, department_name, location_id)
        VALUES(dnum, dname, lnum);
    END;
    //

DELIMITER ;

CALL add_dept(301,'경제부',1400);


-- 사원번호를 입력받아서 월급을 30% 인상하는 procedure
DELIMITER //
CREATE Procedure updateSal(in v_empno int)
BEGIN
    DECLARE EXIT HANDLER for 1365
    BEGIN
        SELECT "수정에 실패했습니다";
    end;

    UPDATE employees
    SET salary = salary * 1.3
    WHERE employee_id = v_empno;
end;
//
DELIMITER ;

CALL updateSal(300);

-- 사원번호를 입력하면 이름, 입사일, 사원급여가 출력되는 프로시저를 작성한다.
DELIMITER //

create Procedure emp_info(in v_empno int)
BEGIN
    DECLARE fname VARCHAR(20);
    DECLARE hdate DATE;
    DECLARE sal DECIMAL(8,2);

    SELECT 
        first_name,
        hire_date,
        salary
        INTO fname, hdate, sal
    FROM employees
    where employee_id = v_empno;

    SELECT fname as 이름, hdate as 입사일, sal as 월급;

END;
DELIMITER ;

CALL emp_info(100);


-- 문제 : 사원번호를 입력받고 그 사원의 급여에 1000을 더한 값으로 갱신하라.
-- 사원 번호와 갱신된 급여를 출력하시오.
-- 내 풀이
DELIMITER //

create Procedure updateSal2(in v_empno int)
BEGIN
    DECLARE EXIT HANDLER for 1365
    BEGIN
        SELECT "수정에 실패했습니다";
    end;

    UPDATE employees
    SET salary = salary + 1000
    WHERE employee_id = v_empno;

    SELECT 
        employee_id as 사원번호,
        salary as '인상된 월급'
    FROM employees
    where employee_id = v_empno;

END;
DELIMITER ;

CALL updateSal2(199);

-- 강사님 풀이

delimiter //

create procedure salaryPlus1000(in empno int)
begin
	declare v_sal decimal(8, 2);
    declare v_salaryTotal decimal(8, 2);
    
    set v_sal = 1000;
    
    -- 확인
    select salary into v_salaryTotal
    from employees
    where employee_id = empno;
    
    select concat(empno, '번 사원의 급여', v_salaryTotal);
    
    -- update
    update employees
    set salary = salary + v_sal
    where employee_id = empno;
    
    -- commit;
    
    -- 갱신 값확인
    select salary into v_salaryTotal
    from employees
    where employee_id = empno;
    
    select concat(empno, '번 사원의 수정된 급여', v_salaryTotal);

end;
//

delimiter ;

call salaryPlus1000(199);

-- IF
SELECT IF(2 >1 , 'true','false') as result;

SELECT first_name, salary, if(salary > 10000, '상위', '보통')  as 레벨
from employees;

select commission_pct, IFNULL(commission_pct, 0)        -- NVL
from employees; -- IFNULL : NULL이면 0으로 나타난다. 매개 변수 2개!!

DELIMITER //

CREATE PROCEDURE levelProc(in empno int)

BEGIN
    DECLARE emp_sal DECIMAL(8,2);
    DECLARE emp_name VARCHAR(20);

    SELECT CONCAT(first_name, ' ', last_name) AS name, salary into emp_name, emp_sal
    FROM employees
    WHERE employee_id = empno;

    IF emp_sal >= 10000 THEN
        SELECT "상위레벨", emp_sal,emp_name;
    ELSEIF emp_sal < 10000 and emp_sal > 6000 THEN
        SELECT "평균레벨", emp_sal,emp_name;
    ELSE
        SELECT "하위레벨", emp_sal,emp_name;
    END IF;

END;
// 
DELIMITER ;

CALL levelProc(190);

-- while
CREATE Table nonPrimeNum(
    num int
);

DELIMITER //

CREATE Procedure loopTest()
BEGIN
    DECLARE i INT DEFAULT 1;    -- int i = 1;

    while (i<=10) do 
        insert into nonPrimeNum
        VALUES(i);
        SET i = i+1;
    END WHILE;

end; //

DELIMITER ;

call looptest();

-- repeat
DELIMITER //

CREATE Procedure repeatTest()
BEGIN
    DECLARE x INT DEFAULT 0;

    REPEAT
        INSERT INTO nonprimenum 
        VALUES(x);
        SET x= x+2;
    UNTIL x > 10
    END REPEAT;
END;

DELIMITER ;

CALL repeatTest();