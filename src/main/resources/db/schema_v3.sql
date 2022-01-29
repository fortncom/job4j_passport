CREATE TABLE IF NOT EXISTS passport (
    id SERIAL PRIMARY KEY,
    series INT NOT NULL,
    number INT NOT NULL UNIQUE,
    expire_date timestamp NOT NULL
);

insert into passport (series, number, expire_date)
values (4251, 434237, date ('2022-01-25'));

insert into passport (series, number, expire_date)
values (4252, 434236, date ('2022-02-25'));

insert into passport (series, number, expire_date)
values (4253, 434235, date ('2023-01-25'));