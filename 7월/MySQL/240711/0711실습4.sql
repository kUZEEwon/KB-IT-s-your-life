-- Active: 1720592554039@@127.0.0.1@3306@hr
create DATABASE shop;
use shop;

create table product3(
    id int,
    name VARCHAR(20),
    content VARCHAR(100),
    price int,
    company VARCHAR(30),
    img VARCHAR(30)
);

select *
from product3
ORDER BY price desc;

SELECT name, content, price
from product3
ORDER BY company;

SELECT DISTINCT company
from product3;

select name,5*price as price5
from product3;

select name,company
from product3
where price=5000;

-- 8. price가 3000이상 6000미만 사이인 제품명과 가격, 회사명 검색
SELECT name, price, company
FROM product3
WHERE price >= 3000 and price < 6000;
-- 9. 회사명이 c100이 아닌 회사명과 제품명
SELECT name, company
FROM product3
WHERE company != "c100";
-- 10. 회사명이 c100, c200인 제품명과 가격
SELECT name, price
FROM product3
WHERE company in ("c100","c200");
-- 11. 제품명에 4로 끝나는 제품의 전체 정보 검색
SELECT *
FROM product3
WHERE name LIKE "%4";
-- 12. 제품내용에 food를 포함하는 제품의 전체 정보 검색
SELECT *
FROM product3
WHERE content LIKE "%food%";
-- 13. price가 5000원인 제품의 content를 품절로 수정
UPDATE product3
set content="품절"
WHERE price=5000;
-- 14. id가 100, 102번 제품의 img를 o.png로, price를 10000으로 수정
UPDATE product3
set img="o.png", price = 10000
WHERE id in (100,102);

-- 15. 회사명이 c100인 경우 모든 정보 삭제
DELETE FROM product3
WHERE company = "c100";
-- 16. 테이블의 모든 정보 삭제
DELETE FROM product3;
-- 17. 테이블 삭제
DROP TABLE product3;

-- productOrder 테이블 생성
create table productOrder(
    id VARCHAR(100) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    price INT,
    buydate DATE,
    addr VARCHAR(200) DEFAULT "home" NOT NULL
);

INSERT INTO productOrder(id, title, price, buydate, addr)
VALUES
(100,"hat",1000,now(),"office");
INSERT INTO productOrder(id, title, price, buydate)
VALUES
(200,"mouse",2000,now());
INSERT INTO productOrder(id, title,  buydate)
VALUES
(300,"pen",now());

