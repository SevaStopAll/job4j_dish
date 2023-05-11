create table IF NOT EXISTS dish(
    id serial primary key not null,
    name varchar(2000) not null,
    description varchar(2000) not null,
    price integer not null
);