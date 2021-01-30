alter table ADPRO_INBOX add constraint FK_ADPRO_INBOX_ON_USER foreign key (USER_ID) references SEC_USER(ID);
create index IDX_ADPRO_INBOX_ON_USER on ADPRO_INBOX (USER_ID);
create index IDX_ADPRO_INBOX on ADPRO_INBOX (TITLE, MESSAGE, USER_ID);
