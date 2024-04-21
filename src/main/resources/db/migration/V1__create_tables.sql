create table book
(
    id     uuid primary key,
    name   varchar(256) not null,
    author varchar(256) not null,
    isbn   varchar(16)  not null
);

create table person
(
    id         uuid primary key,
    name       varchar(256) not null,
    surname    varchar(256) not null,
    patronymic varchar(256) not null,
    birthdate  date         not null
);

create table person_book
(
    id         uuid primary key,
    book_id    uuid references book (id) on delete cascade,
    person_id  uuid references person (id) on delete cascade,
    taken_date date not null
);