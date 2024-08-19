-- Active: 1720589160551@@127.0.0.1@3306@hr
drop Table bbs;

CREATE TABLE bbs(
    seq int AUTO_INCREMENT PRIMARY KEY,
    id VARCHAR(200) not NULL,
    ref DECIMAL(8) NOT NULL, -- group번호
    step DECIMAL(8) NOT NULL, -- 행 번호
    depth DECIMAL(8) NOT NULL, -- 깊이 번호
    title VARCHAR(255) not null,
    content TEXT not null,
    wdate TIMESTAMP not null,
    del DECIMAL(1) NOT null,
    readcount decimal(8) NOT NULL
 );


ALTER TABLE bbs
ADD FOREIGN KEY(id) REFERENCES member(id);

INSERT INTO bbs(id, ref,step, depth, title, content, wdate, del, readcount)
VALUES(
    'abc', 
    (
    SELECT IFNULL(max(ref), 0) + 1 FROM bbs b
    ), 0, 0, 'title','content', now(), 0, 0
)