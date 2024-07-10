use hr;

create table tb_test(
	col1 varchar(10),
    col2 varchar(20),
    col3 varchar(20)
);

drop table tb_test;


create table tb_test2(
	id int,
    name varchar(30),
    height decimal(3, 1),
    size int		-- oracle에서는 실행되지 않는다
);

drop table tb_test2;


-- 테이블 복제 : 데이터를 포함
create table tb_test3
as 
select * from jobs;

select * from tb_test3;

drop table tb_test3;

create table tb_test3
as 
select job_title, max_salary from jobs;

create table tb_test3
as 
select job_title as "업무명", max_salary as "최고급여" from jobs;


-- 테이블 복제 : 데이터 미포함
create table if not exists tb_test4
like jobs;

select * from tb_test4;


-- DDL -> object : create, drop, alter 

-- 테이블명의 변경
alter table tb_test4
rename 
to tb_test99;

select * from tb_test99;

desc tb_test99;
desc employees;

-- 테이블에 단일컬럼 추가
alter table tb_test99
add
new_col varchar(30);

-- 테이블에 다중컬럼 추가
alter table tb_test99
add
(new_name varchar(30), birth date);

-- 컬럼의 데이터 자료형을 수정
alter table tb_test99
modify
new_col int;

-- 컬럼명을 변경
alter table tb_test99
change
new_col age int;

-- 컬럼을 삭제
alter table tb_test99
drop
column new_name;

desc tb_test99;


-- 테이블 복제 : 데이터 미포함 <- oracle
drop table tb_test;

create table tb_test
as
select * from departments
where 1=2;

select * from tb_test;

-- 추가
insert into tb_test(department_id, department_name, manager_id, location_id)
values(10, '기획', 100, 120);

insert into tb_test(manager_id, location_id, department_id, department_name)
values(110, 130, 20, '경리');

insert into tb_test
values(30, '개발', 120, 140);

insert into tb_test(department_id, department_name)
values(40, '관리');

set sql_safe_updates = 0;

-- 삭제
delete from tb_test
where department_name = '관리';


select * from tb_test;

-- 수정
update tb_test
set manager_id = 210
where department_id = 20;

-- increment 값자동 증가 1 2 3 4 == sequence
create table tb_test1(
	id int auto_increment primary key,
	name varchar(30)
);

insert into tb_test1(name)
values('홍길동');

select * from tb_test1;

insert into tb_test1(name)
values('성춘향');

insert into tb_test1(name)
values('일지매');

-- CSV -> DB


/*
	무결성 : 	constraints
			column을 지정하는 설정

	Primary Key : 기본키. null을 허용하지 않는다. 중복된 값을 허용하지 않는다. id, 주민번호
    Unique Key : 고유키. null을 허용. 중복된 값을 허용하지 않는다. E-mail
    Foreign Key : 외래키. 테이블과 테이블의 연결(join). null을 허용.
    check : 지정된 값외에는 사용할 수 없다. 범위, 선택. null을 허용.
    Not Null : null을 허용하지 않는다.
*/

-- Not Null 
create table tb_test4(
	col1 varchar(10) not null,
    col2 varchar(20)
);

insert into tb_test4(col1, col2)
values('AAA', '111');

insert into tb_test4(col1)
values('BBB');

insert into tb_test4(col2)	-- error
values('222');

insert into tb_test4(col1, col2) -- error
values('', '222');

select * from tb_test4;

drop table if exists tb_test4;


-- check
create table tb_check(
	col1 varchar(10),
    col2 varchar(20),
    constraint chk_col1 check( col1 in('사과', '배', '바나나')),
    constraint chk_col2 check( col2 > 0 and col2 <= 100 )
);

insert into tb_check(col1, col2)
values('사과', 33);

insert into tb_check(col1, col2)
values('포도', 66);

insert into tb_check(col2)
values(66);

select * from tb_check;

insert into tb_check(col1, col2)
values('사과', 0);

-- Primary Key = Unique Key + Not Null - PK
create table tb_test5(
	pk_col varchar(10) primary key,
    col1 int,
    col2 date
);

insert into tb_test5(pk_col, col1, col2)
values('AAA', 111, now());

select * from tb_test5;

insert into tb_test5(pk_col, col1, col2)
values('AAA', 222, now());

insert into tb_test5(col1, col2)
values(111, now());

drop table if exists tb_test5;

create table tb_test5(
	pk_col varchar(10),
    col1 int,
    col2 date,
    primary key(pk_col)
);

create table tb_test5(
	pk_col varchar(10),
    col1 int,
    col2 date
);

alter table tb_test5
add
primary key(pk_col);

alter table tb_test5
drop
primary key;

-- Unique : 고유키 
create table tb_test6(
	uk_col varchar(10) unique,
    col1 int,
    col2 timestamp
);

insert into tb_test6(uk_col, col1, col2)
values('aaa', 11, now());

insert into tb_test6(col1, col2)
values(22, now());

select * from tb_test6;

/*
	Foreign Key : 외래키
				  기본(부모) 테이블에서 PK, UK로 설정되어 있어야 한다
                  null을 허용
*/

-- parent table
create table dept(
	department_id int,
    deaprtment_name varchar(20),
    location_id decimal(3),
    primary key(department_id)
);

insert into dept(department_id, deaprtment_name, location_id)
values(10, '기획', 100);

insert into dept(department_id, deaprtment_name, location_id)
values(20, '개발', 103);

insert into dept(department_id, deaprtment_name, location_id)
values(30, '영업', 107);

select * from dept;

-- child table
create table emp(
	employee_id int primary key,
    first_name varchar(20),
    department_id int,
    foreign key(department_id) references dept(department_id)
);

insert into emp(employee_id, first_name, department_id)
values(1, '길동', 30);

insert into emp(employee_id, first_name)	 -- null은 허용
values(2, '춘향');

insert into emp(employee_id, first_name, department_id)
values(3, '지매', null);

insert into emp(employee_id, first_name, department_id) 
values(4, '수동', 50);  -- 부모테이블에 없는 값은 추가할 수 없다

select * from emp;

/*

운동부 TABLE을 작성하라.
TEAM : 팀 아이디, 지역, 팀 명, 개설 날짜, 전화번호, 홈페이지
PLAYER : 선수번호, 선수 명, 등록일, 포지션, 키, 팀 아이디

TEAM을 두 개만 등록합니다.
두 개의 TEAM에 선수를 각각 3명씩 등록(추가)합니다.
----------------------------------------------------------------------
온라인 마켓 TABLE을 작성하라.
PRODUCT(상품) : 상품번호, 상품명, 상품가격, 상품설명
CONSUMER(소비자) : 소비자 ID, 이름, 나이
CART(장바구니) : 장바구니 번호, 소비자 ID, 상품번호, 수량

상품 테이블에 상품을 등록합니다(개수는 원하는 데로).
소비자를 등록합니다.
소비자가 쇼핑한 상품을 추가합니다.
*/
















