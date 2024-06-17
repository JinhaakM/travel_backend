select * from persistent_logins;


select * from chat;
delete member where member.member_id='duwnstj';

select * from plan;
drop table member;
drop table chat;
drop table message;
drop table persistent_logins;
drop table national;
drop table city;
drop table plan;
drop table destination;

select * from plan;
delete chat where chat.chat_no=3;


select * from payment;
delete message where message.chat_no=3;

select * from CM_IMG;
drop table payment;
select * from cm_comment;
select * from COMMUNITY_BOARD;

SELECT OWNER, TABLE_NAME
FROM ALL_TABLES
WHERE TABLESPACE_NAME = 'TRAVEL';


update member set member.role='ADMIN' where member_id='aodwlsgkr'; 
--aodwlsgkr 아이디를 관리자로 지정함ㅁ.