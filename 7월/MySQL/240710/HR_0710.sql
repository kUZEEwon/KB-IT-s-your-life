-- Active: 1720589160551@@127.0.0.1@3306@0710과제
/* 
    운동부 table 작성하기
    TEAM : 팀 아이디, 지역, 팀 명, 개설 날짜, 전화번호, 홈페이지
    PLAYER : 선수 번호, 선수 명, 등록일, 포지션, 키, 팀 아이디

    TEAM을 두 개만 등록
    두 개의 TEAM에 선수를 각각 3명씩 등록(추가)한다.

    선수를 입력하면 그 선수의 팀 명과 전화번호, 홈페이지가 출력되도록 합니다. 
    JOIN 해 보도록 한다.
 */
use 0710과제;
create table TEAM (
    team_id INT primary key,
    location VARCHAR(40),
    team_name VARCHAR(40),
    start_date DATE,
    tel VARCHAR(30),
    homepage VARCHAR(40)
);

drop table `PLAYER`;

create table PLAYER (
    player_id int PRIMARY key,
    player_name VARCHAR(40),
    resi_date DATE,
    position VARCHAR(40),
    height decimal (4,1),
    team_id INT,
    FOREIGN KEY(team_id) REFERENCES TEAM(team_id)
);

INSERT INTO TEAM (team_id, location, team_name, start_date, tel, homepage) VALUES
(1, '서울', 'Seoul Tigers', '2020-01-15', '010-1234-5678', 'www.seoultigers.com'),
(2, '부산', 'Busan Dolphins', '2019-03-21', '010-2345-6789', 'www.busandolphins.com');

INSERT INTO PLAYER (player_id, player_name, resi_date, position, height, team_id) 
VALUES (1, '이대호', '1999-09-21', '타자', 180, 2);

INSERT INTO PLAYER (player_id, player_name, resi_date, position, height, team_id) 
VALUES 
(2, '한현희', '2023-01-21', '투수', 189.2, 2),
(3, '장두성', '2018-02-21', '외야수', 181.3, 2);


INSERT INTO PLAYER (player_id, player_name, resi_date, position, height, team_id) 
VALUES 
(4, '강동훈', '2020-10-21', '투수', 189.2, 1),
(5, '곽도규', '2023-02-03', '내야수', 189.2, 1),
(6, '김동규', '2019-12-18', '외야수', 181.3, 1);

/* 
    온라인 마켓 테이블을 작성하라
    PRODUCT(상품) : 상품번호, 상품명, 상품가격, 상품설명
    Consumer(소비자) : 소비자 id, 이름, 나이
    Cart(장바구니) : 장바구니 번호, 소비자 Id, 상품번호, 수량

    상품 테이블에 상품을 등록(개수는 원하는 대로)
    소비자를 등록
    소비자가 쇼핑한 상품을 추가

    쇼핑한 상품을 출력합니다 <- join
 */

create Table product (
    product_id int PRIMARY KEY,
    product_name VARCHAR(50), 
    price int,
    COMMENT VARCHAR(100)
);

create TABLE consumer(
    consumer_id int PRIMARY key,
    consumer_name VARCHAR(40),
    age int 
);

create table cart(
    cart_id int PRIMARY key,
    consumer_id INT,
    product_id int,
    count int,
    FOREIGN KEY(consumer_id) REFERENCES consumer(consumer_id),
    FOREIGN KEY(product_id) REFERENCES product(product_id)
);


-- 상품 데이터 삽입
INSERT INTO product (product_id, product_name, price, COMMENT) VALUES
(1, 'Laptop', 1000, 'High performance laptop'),
(2, 'Smartphone', 700, 'Latest model smartphone'),
(3, 'Headphones', 100, 'Noise cancelling headphones');

-- 소비자 데이터 삽입
INSERT INTO consumer (consumer_id, consumer_name, age) VALUES
(1, 'John Doe', 30),
(2, 'Jane Smith', 25),
(3, 'Alice Johnson', 28);

-- 장바구니 데이터 삽입
INSERT INTO cart (cart_id, consumer_id, product_id, count) VALUES
(1, 1, 1, 1), -- John Doe가 Laptop 1개 구매
(2, 2, 2, 2), -- Jane Smith가 Smartphone 2개 구매
(3, 3, 3, 1), -- Alice Johnson이 Headphones 1개 구매
(4, 1, 3, 2); -- John Doe가 Headphones 2개 추가 구매