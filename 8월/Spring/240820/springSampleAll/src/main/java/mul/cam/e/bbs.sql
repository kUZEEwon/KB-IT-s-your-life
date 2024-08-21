select * from bbs;

drop table if exists bbs;

create table bbs(
    seq int auto_increment primary key,
    id varchar(50) not null,

    ref decimal(8) not null,    -- 그룹번호
    step decimal(8) not null,   -- 행번호
    depth decimal(8) not null,  -- 깊이번호

    title varchar(200) not null,
    content varchar(4000) not null,
    wdate timestamp not null,

    del decimal(1) not null,
    readcount decimal(8) not null
);

alter table bbs
add foreign key(id) references member(id);

insert into bbs(id, ref, step, depth, title, content, wdate, del, readcount)
values('abc', (select ifnull(max(ref), 0) + 1 from bbs b), 0, 0, 'title', 'content', now(), 0, 0)
-- 0 -> 0


-- 수정
UPDATE bbs
SET step = step + 1
WHERE ref = (SELECT A.ref FROM (SELECT ref FROM bbs WHERE seq = #{seq}) A)
  AND step > (SELECT B.step FROM (SELECT step FROM bbs WHERE seq = #{seq}) B);


-- 추가
INSERT INTO bbs (id, ref, step, depth, title, content, wdate, del, readcount)
values (#{id},
        (select ref from bbs a where seq = #{seq}),     -- ref
       (select step from bbs b where seq = #{seq}) + 1, -- step
       (select depth from bbs c where seq = #{seq}) + 1, -- depth
       #{title}, #{content} , now(),0,0)