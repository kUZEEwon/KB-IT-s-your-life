create table calendar(
    seq int auto_increment primary key,
    username varchar(100) not null,
    level int,
    title varchar(200) not null,
    content varchar(4000) not null,
    startdate varchar(19) not null,
    enddate varchar(19),
    wdate timestamp not null
);

alter table calendar
add foreign key(username) references member(username);