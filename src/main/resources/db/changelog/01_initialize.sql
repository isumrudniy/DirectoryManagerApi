CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS VALUE_DIRECTORY;
DROP TABLE IF EXISTS DIRECTORIES;

create table DIRECTORIES
(
    ID    varchar(40) primary key,
    NAME  varchar(100) not null,
    LOGIN varchar(60)
);

create table VALUE_DIRECTORY
(
    ID           varchar(40) primary key,
    KEY          varchar(100) not null,
    NAME         varchar(100) not null,
    SUP_ATTRS    jsonb,
    DIRECTORY_ID varchar(40),
    foreign key (DIRECTORY_ID) references DIRECTORIES (ID) on delete cascade
);