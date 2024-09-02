
create table user(
    username varchar(100) primary key,      -- id
    password varchar(100) not null,
    email varchar(100) not null,
    authority varchar(100) not null,        -- ROLE_USER
    enabled int
);

-- 비번:1111
insert into USER(USERNAME, PASSWORD, email, AUTHORITY, ENABLED)
values('user', '$2a$10$0SOwezDKCaj2tZ1fnDaLpulyboMi.5I0IzMa4nAF5RFxgMr72FtU2',
       'user@naver', 'ROLE_USER', 1);

-- 비번:1234
insert into USER(USERNAME, PASSWORD, email, AUTHORITY, ENABLED)
values('admin', '$2a$10$hzfs8zUia3NsIwA3VM7rROlkj1JdLamUjhw4PeWePTWyzNL19aCc.',
       'admin@nate', 'ROLE_ADMIN', 1);

select * from user;