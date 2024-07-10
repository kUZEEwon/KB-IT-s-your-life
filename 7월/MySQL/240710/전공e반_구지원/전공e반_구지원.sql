CREATE DATABASE shop4;
use shop4;

-- 1. Q1 문제 ERD에 해당하는 모든 테이블에 대해 CREATE문을 작성하시오 .
create table member(
	id varchar(100) primary key not null,
    pw varchar(100) not null,
    name varchar(100) not null,
    tel varchar(100) not null
);

create table bbs(
	no INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    title varchar(100),
    content varchar(100),
    writer varchar(100),
    FOREIGN KEY (writer) REFERENCES member(id)
);

create table  reply(
	id varchar(100) primary key not null,
    oriid INT,
    content varchar(100),
    writer varchar(100),
	FOREIGN KEY (writer) REFERENCES member(id),
    FOREIGN KEY (oriid) REFERENCES bbs(no)
);

INSERT INTO member
values
(1, "1234","ALICE","010-1111-2222"),
(2, "2356","BOB","010-1548-2222");

INSERT INTO bbs
values
(1, "제목1","내용1",1),
(2, "제목2","내용2",2);

INSERT INTO reply
values
(1, 1,"내용1",2),
(2, 2,"내용2",1);

-- 2. member table내 tel의 컬럼 데이터 타입을 varchar(50)으로 수정하시오
ALTER TABLE member
MODIFY tel varchar(50);

-- 3. bbs table내 title column을 삭제하시오.
ALTER TABLE bbs DROP title;

-- 4. member table내 pw컬럼을 varchar(100), null 허용하지 않는 조건으로 을 추가하시오 .
ALTER TABLE member
MODIFY COLUMN pw VARCHAR(100) NOT NULL;

-- 5. member table의 상세 항목 및 제약조건을 출력하시오 .
desc member;

-- 6. 전체 테이블 목록을 출력하시오.
SHOW TABLES;

-- 7. 전체 데이터베이스 목록을 출력하시오 .
SHOW DATABASES;

-- 8. 각 테이블을 reply, bbs, member순서대로 삭제하시오 .
DROP TABLE reply;
DROP TABLE bbs;
DROP TABLE member;