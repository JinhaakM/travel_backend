select * from persistent_logins;


select * from member;
delete member where member.member_id='duwnstj';



select * from chat;
delete chat where chat.chat_no=3;


select * from message;
delete message where message.chat_no=3;


update member set member.role='ADMIN' where member_id='aodwlsgkr'; 
--aodwlsgkr 아이디를 관리자로 지정함ㅁ.