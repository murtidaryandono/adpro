create table ADPRO_REGENCY (
    ID varchar(4),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    VERSION integer not null,
    --
    PROVINCE_ID varchar(2) not null,
    NAME varchar(255) not null,
    --
    primary key (ID)
);