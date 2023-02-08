create table subscription
(
    -- uuid can not be auto increment
    id uuid default gen_random_uuid()
        constraint subscription_pk
            primary key,
    email varchar not null,
    first_name varchar,
    gender varchar,
    date_of_birth date not null,
    consent bool default false
);

