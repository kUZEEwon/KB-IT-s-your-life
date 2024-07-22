-- Active: 1720589160551@@127.0.0.1@3306@hr
use hr;

/* 
    procedure   ( out 매개변수 자료형 )
    insert, delete, update

    function    ()  return 자료형
    select

    형식:
        CREATE function 함수명(매개변수 자료형 ...) returns 자료형
            query + 제어문

 */

SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER //

CREATE Function doubleValue(p_val DOUBLE) returns DOUBLE

BEGIN

    DECLARE v_val DOUBLE;

    SET v_val = p_val;
    SET v_val = v_val * 2;

    return v_val;

END;
//

DELIMITER ;

SET @num = doubleValue(20);
SELECT @num;

-- 월급과 커미션을 합친 금액의 세금을 계산하는 함수
DELIMITER //

CREATE Function tax(p_sal DECIMAL(8,2), p_bonus DECIMAL(2,2)) returns DOUBLE

BEGIN
    RETURN((p_sal + IFNULL(p_bonus,0) * p_sal) * 0.15) ;

END;
//

DELIMITER ;

select 
    first_name,
    salary + salary * IFNULL(commission_pct,0) as 실급여,
    salary * IFNULL(commission_pct,0) as 보너스급여,
    tax(salary, commission_pct) as 세금
FROM employees
order by 보너스급여 desc;

-- 사원번호를 입력하면, 업무명을 취득할 수 있는 함수

-- 내풀이
DELIMITER //

CREATE Function getJob(eNum INT) returns VARCHAR(30)

BEGIN
    
    DECLARE eid INT;
    DECLARE job varchar(30);

    SELECT j.job_title into job
    from employees e INNER JOIN jobs j 
    ON e.job_id = j.job_id
    WHERE employee_id = eNum;

    RETURN job ;

END;
//

DELIMITER ;

set @job =  getJob(150);
SELECT @job;

-- 강사님  풀이
DELIMITER //

CREATE Function getJobName(empno INT) returns VARCHAR(35)

BEGIN
    
    DECLARE v_jobname varchar(30);

    SELECT j.job_title into v_jobname
    from employees e INNER JOIN jobs j 
    ON e.job_id = j.job_id
    WHERE employee_id = empno;


    RETURN v_jobname ;

END;
//

DELIMITER ;

set @jobName =  getJobName(103);
SELECT @jobName;

SELECT 
    CONCAT(first_name, ' ', last_name) AS name,
    job_id,
    getJobName(employee_id)
FROM employees;



/* 
    trigger : 촉발하다. == 자동호출

    CREATE trigger 트리거명
    { before|after } {insert|update|delete}
    on 테이블명
    for each row 
    begin 
        트리거 처리
    end
 */

create table deptUpdate(
    oldname VARCHAR(30),
    newname VARCHAR(30)
);

DELIMITER //

CREATE TRIGGER trigger_test

-- update 되기 전에
    BEFORE UPDATE
    ON departments
    for each row 

    BEGIN
        INSERT INTO deptupdate(oldname, newname) VALUES
        (old.department_name, new.department_name); -- old는 기존값 new는 새로운 값

    end;
    //
DELIMITER ;

select * FROM deptupdate;

UPDATE departments
SET department_name = "인사부"
WHERE department_id = 300;