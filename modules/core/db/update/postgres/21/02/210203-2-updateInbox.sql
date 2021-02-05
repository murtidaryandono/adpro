alter table ADPRO_INBOX add column READ_STATUS boolean ^
update ADPRO_INBOX set READ_STATUS = false where READ_STATUS is null ;
alter table ADPRO_INBOX alter column READ_STATUS set not null ;
