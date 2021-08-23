create table students
(
    id          bigserial primary key,
    name        varchar(30) not null unique,
    age         integer
);

insert into students(name, age)
values ('Aleksey', 18),
       ('Aleksandr', 19),
       ('Vladimir', 18);