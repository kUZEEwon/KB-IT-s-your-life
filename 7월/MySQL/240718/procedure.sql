use hr;

-- 변수
-- autocommit 확인
select @@autocommit;

set autocommit = true;

select 'Hello PL';

-- 변수선언
set @count = 1;		-- int count = 1;
select @count;

set @message = '안녕하세요';
select @message;

select first_name, salary, @message
from employees;

set @height = 172.1 + 21;
select @height;

-- procedure
/*
	delimiter $$
							 proc( in s String )
    create procedure 프로시저명( in 매개변수명 자료형, out 매개변수명 자료형)
    begin

		query + 제어문

	end$$
    
	delimiter ;    
*/

drop procedure if exists hello;

drop procedure if exists world;

delimiter $$

create procedure hello()
begin
	declare message varchar(20);	-- String message;
    
    set message := "hello pl";

	select concat('message = ', message);
end;
-- 다음 쿼리까지 실행하고 싶은 경우 ;을 붙인다. 
-- $$를 붙이면 지금 여기 END구문까지만 실행됨

create procedure world()
begin
	declare msg decimal(5, 1);
    
    set msg = 172.1;
    select concat('신장:', msg);    

end;

create procedure myproc(in inum int, out onum int)
begin
	select inum;

	set onum = 333;
end$$

delimiter ;

call hello();

call world();

call myproc(111, @outNum);
select @outNum;





insert into departments(department_id, department_name, location_id)
values(300, '관리부', 1400);

delimiter //

create procedure add_dept(in dnum int, in dname varchar(30), in lnum int)
begin
	declare exit handler for 1365
    begin
		select 'Sorry, you cannot divide by zero';
    end;
    
    insert into departments(department_id, department_name, location_id)
	values(dnum, dname, lnum);

end;
//

delimiter ;

call add_dept(301, '경제부', 1400);

-- 사원번호를 입력받아서 월급을 30%를 인상시키는 procedure

delimiter //

create procedure updateSal(in v_empno int)
begin
	declare exit handler for 1365
    begin
		select '수정에 실패했습니다';
    end;
    
    update employees
    set salary = salary * 1.3
    where employee_id = v_empno;
    
end;
//

delimiter ;

call updateSal(103);


-- 사원번호를 입력하면 이름, 입사일, 사원급여가 출력되는 프로시저를 작성

drop procedure if exists emp_info;

delimiter //

create procedure emp_info(in v_empno int)
begin
	declare fname varchar(20);
    declare hdate date;
    declare sal decimal(8, 2);

	select first_name, hire_date, salary
		into fname, hdate, sal
    from employees
    where employee_id = v_empno;
    
    select fname as 이름, hdate as 입사일, sal as 월급;    
end;
//

delimiter ;

call emp_info(100);


-- 사원번호를 입력받고 그 사원의 급여에 1000을 더한 값으로 갱신(UPDATE)하라.
-- 사원번호와 갱신된 급여를 출력하라.

drop procedure if exists salaryPlus1000;

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

call salaryPlus1000(100);


-- if
select if(2 > 1, 'true', 'false') as result;

select if(1 > 2, 1, 0) as result;

select first_name, salary, if(salary > 10000, '상위', '보통') as 레벨
from employees;

select commission_pct, ifnull(commission_pct, 0)	-- nvl <- oracle  nvl2
from employees;

delimiter //

create procedure levelProc(in empno int)
begin
	declare emp_sal decimal(8, 2);
    declare emp_name varchar(20);
    
    select first_name, salary into emp_name, emp_sal
    from employees
    where employee_id = empno;
    
    if emp_sal >= 10000 then
		select "상위레벨", emp_sal, emp_name;
	elseif emp_sal < 10000 and emp_sal > 6000 then
		select "평균레벨", emp_sal, emp_name;
    else
		select "하위레벨", emp_sal, emp_name;
	end if;
    
end;
//

delimiter ;

call levelProc(100);
call levelProc(120);
call levelProc(180);


-- while
create table nonprimenum(
	num int
);

delimiter //

create procedure loopTest()
begin
	declare i int default 1;	-- int i = 1;
    
    while(i <= 10) do
		insert into nonprimenum
        values(i);
        
        set i = i + 1;
	end while;  
    
end;
//

delimiter ;

call loopTest();

select * from nonprimenum;

-- repeat
delimiter //

create procedure repeatTest()
begin
	declare x int default 0;
    
    repeat
		insert into nonprimenum(num)
        values( x );
        
        set x = x + 2;
	until x > 10
    end repeat;

end;
//

delimiter ;

call repeatTest();

select * from nonprimenum;







