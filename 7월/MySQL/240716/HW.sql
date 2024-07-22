-- Active: 1720589160551@@127.0.0.1@3306@hr
-- 데이터베이스 생성
CREATE DATABASE 학생정보DB;
USE 학생정보DB;

-- 학생 테이블 생성
CREATE TABLE 학생 (
    학생번호 INT PRIMARY KEY,
    학생명 VARCHAR(50),
    연락처 VARCHAR(20)
);

-- 동아리 테이블 생성
CREATE TABLE 동아리 (
    학생번호 INT,
    동아리신청과목 VARCHAR(50),
    담당교수 VARCHAR(50),
    PRIMARY KEY (학생번호, 동아리신청과목),
    FOREIGN KEY (학생번호) REFERENCES 학생(학생번호)
);

-- 담당교수 테이블 생성
CREATE TABLE 담당교수 (
    담당교수 VARCHAR(50) PRIMARY KEY,
    연구실 VARCHAR(50),
    연락처 VARCHAR(20)
);

INSERT INTO 학생 (학생번호, 학생명, 연락처) VALUES (100, '김멀티', '02 123 1111');
INSERT INTO 학생 (학생번호, 학생명, 연락처) VALUES (200, '김세븐', '031 111 2222');
INSERT INTO 학생 (학생번호, 학생명, 연락처) VALUES (300, '박멀티', '02 844 0114');

INSERT INTO 담당교수 (담당교수, 연구실, 연락처) VALUES ('김천재', '공학관 100 호', '02 555 2222');
INSERT INTO 담당교수 (담당교수, 연구실, 연락처) VALUES ('박천재', '공학관 200 호', '02 555 3333');
INSERT INTO 담당교수 (담당교수, 연구실, 연락처) VALUES ('송천재', '공학관 300 호', '02 555 4444');

INSERT INTO 동아리 (학생번호, 동아리신청과목, 담당교수) VALUES (100, '발레', '김천재');
INSERT INTO 동아리 (학생번호, 동아리신청과목, 담당교수) VALUES (200, '농구', '박천재');
INSERT INTO 동아리 (학생번호, 동아리신청과목, 담당교수) VALUES (300, '농구', '박천재');
INSERT INTO 동아리 (학생번호, 동아리신청과목, 담당교수) VALUES (100, '코딩', '김천재');
INSERT INTO 동아리 (학생번호, 동아리신청과목, 담당교수) VALUES (300, '스키', '송천재');


-- 특정 학생 삭제 (예: 학생번호가 100인 학생)
DELETE FROM 학생 WHERE 학생번호 = 100;

-- 해당 학생번호가 100인 동아리 정보가 삭제되는지 확인
SELECT * FROM 동아리 WHERE 학생번호 = 100;
