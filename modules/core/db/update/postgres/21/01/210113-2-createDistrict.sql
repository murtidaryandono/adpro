alter table ADPRO_DISTRICT add constraint FK_ADPRO_DISTRICT_ON_REGENCY foreign key (REGENCY_ID) references ADPRO_REGENCY(ID);
create index IDX_ADPRO_DISTRICT_ON_REGENCY on ADPRO_DISTRICT (REGENCY_ID);
create index IDX_ADPRO_DISTRICT on ADPRO_DISTRICT (REGENCY_ID, NAME);