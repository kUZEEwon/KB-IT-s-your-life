CREATE TABLE member(
                       username varchar(100) PRIMARY KEY,
                       password varchar(300) NOT NULL,
                       name varchar(45) NOT NULL,
                       email varchar(45) NOT NULL,
                       auth varchar(50) NOT NULL	-- ROLE_USER
);

select * from member;

