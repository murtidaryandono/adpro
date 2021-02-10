-- begin ADPRO_DISTRICT
create table ADPRO_DISTRICT (
    ID varchar(7),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    VERSION integer not null,
    --
    REGENCY_ID varchar(4) not null,
    NAME varchar(255) not null,
    --
    primary key (ID)
);
-- end ADPRO_DISTRICT
-- begin ADPRO_REGENCY
create table ADPRO_REGENCY
(
    ID          varchar(4),
    CREATE_TS   timestamp,
    CREATED_BY  varchar(50),
    UPDATE_TS   timestamp,
    UPDATED_BY  varchar(50),
    DELETE_TS   timestamp,
    DELETED_BY  varchar(50),
    VERSION     integer      not null,
    --
    PROVINCE_ID varchar(2)   not null,
    NAME        varchar(255) not null,
    --
    primary key (ID)
);
-- end ADPRO_REGENCY
-- begin ADPRO_PROVINCE
create table ADPRO_PROVINCE (
    ID varchar(2),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    VERSION integer not null,
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
);
-- end ADPRO_PROVINCE
-- begin ADPRO_VILLAGE
create table ADPRO_VILLAGE (
    ID varchar(10),
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    VERSION integer not null,
    --
    DISTRICT_ID varchar(7) not null,
    NAME varchar(255) not null,
    --
    primary key (ID)
);
-- end ADPRO_VILLAGE
-- begin ADPRO_INBOX
create table ADPRO_INBOX (
    ID bigint,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    VERSION integer not null,
    --
    TITLE varchar(255) not null,
    MESSAGE varchar(1028) not null,
    USER_ID uuid not null,
    READ_STATUS boolean not null,
    NOTIFICATION_STATUS boolean not null,
    --
    primary key (ID)
);
-- end ADPRO_INBOX
-- begin ADPRO_INSTITUTION
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
    PROVINCE_ID varchar(2) not null,
    REGENCY_ID varchar(4) not null,
    DISTRICT_ID varchar(7) not null,
    VILLAGE_ID varchar(10) not null,
    --
    primary key (ID)
)
-- end ADPRO_INSTITUTION
