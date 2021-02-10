create table ADPRO_INSTITUTION (
    ID bigint,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    VERSION integer not null,
    --
    NAME varchar(255) not null,
    DESCRIPTION varchar(1024),
    ADDRESS varchar(1024) not null,
    ADDRESS_ADDITIONAL varchar(1024),
    VILLAGE_ID varchar(10) not null,
    --
    primary key (ID)
);