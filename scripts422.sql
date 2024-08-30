CREATE TABLE humans
(
    id                    bigint primary key      not null,
    name                  varchar(25)             not null,
    age                   integer CHECK (age > 0) not null,
    car                   varchar(25) references cars (id),
    is_have_driverLicense boolean                 not null
);

CREATE TABLE cars
(
    id     bigint primary key not null,
    brand  varchar(25) UNIQUE not null,
    model varchar,
    cost   integer            not null
);

SELECT s.name AS name, s.age AS age, f.name AS faculty
FROM student s
         JOIN faculty f ON s.faculty_id = f.id;

SELECT s.name AS name, s.age AS age, f.name AS faculty
FROM student s
         JOIN faculty f ON s.faculty_id = f.id
         join avatar a on s.id = a.student_id;

