alter table ADPRO_INSTITUTION add constraint FK_ADPRO_INSTITUTION_ON_PROVINCE foreign key (PROVINCE_ID) references ADPRO_PROVINCE(ID);
create index IDX_ADPRO_INSTITUTION_ON_PROVINCE on ADPRO_INSTITUTION (PROVINCE_ID);
