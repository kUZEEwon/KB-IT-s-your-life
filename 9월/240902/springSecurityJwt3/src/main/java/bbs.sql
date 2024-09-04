create table bbs(
    seq int auto_increment primary key,
    username varchar(100) not null,

    ref int not null,
    step int not null,
    depth int not null,

    title varchar(1000) not null,
    content varchar(4000) not null,
    wdate timestamp,

    del decimal(1) not null,
    readcount decimal(8) not null
);

alter table bbs
add foreign key(username) references member(username);

insert into bbs(username, ref, step, depth, title, content, wdate, del, readcount)
values('abc', (select ifnull(max(ref), 0)+1 from bbs b), 0, 0, '제목', '내용', now(), 0, 0);

select * from bbs;