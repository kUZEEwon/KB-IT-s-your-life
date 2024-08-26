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
update bbs
set step=step+1
where ref = (select ref from (select ref from bbs a where seq=#{seq}) A)
    and step > (select step from (select step from bbs b where seq=#{seq}) B);

-- 추가
/*
insert into bbs(id, ref, step, depth, title, content, wdate, del, readcount)
values(#{id}, (select ref from bbs a where seq=#{seq}),
              (select step from bbs b where seq=#{seq}) + 1,
              (select depth from bbs c where seq=#{seq}) + 1,
               #{title}, #{content}, now(), 0, 0);
*/



select * from bbs;

create table bbscomment(
    seq int not null,
    id varchar(50) not null,
    content varchar(1000) not null,
    wdate timestamp not null
);

alter table bbscomment
add foreign key(id) references member(id);

select * from bbscomment;