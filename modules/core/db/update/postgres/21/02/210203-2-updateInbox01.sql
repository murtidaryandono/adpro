alter table ADPRO_INBOX add column NOTIFICATION_STATUS boolean ^
update ADPRO_INBOX set NOTIFICATION_STATUS = false where NOTIFICATION_STATUS is null ;
alter table ADPRO_INBOX alter column NOTIFICATION_STATUS set not null ;
