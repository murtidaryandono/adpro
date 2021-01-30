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
    --
    primary key (ID)
);