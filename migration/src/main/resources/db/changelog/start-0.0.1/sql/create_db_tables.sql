create table category(
    id bigserial primary key ,
    name varchar(255)
);

create table storage(
    id bigserial primary key ,
    name varchar(255) not null ,
    quantity integer ,
    price_per_unit integer,
    producer_id bigint,
    category_id bigint,
    created_at date,
    updated_at date
);

create table producer(
    id bigserial primary key ,
    name varchar(255)
)