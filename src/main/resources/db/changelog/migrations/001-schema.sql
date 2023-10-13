create table person
(
    age             integer      not null,
    city_of_living  varchar(255),
    name            varchar(255) not null,
    phone_of_number varchar(255),
    surname         varchar(255) not null,
    primary key (age, name, surname)
)