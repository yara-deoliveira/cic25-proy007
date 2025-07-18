    drop table if exists perro cascade
    drop sequence if exists perro_seq
    create sequence perro_seq start with 1 increment by 50
    create table perro (
        edad integer not null,
        vacunado boolean not null,
        id bigint not null,
        raza varchar(255),
        primary key (id)
    )