

select * from community_board;

select max(mateno) from community_board;

select * from CM_IMG;

select * from member;

select * from cm_comment;

SELECT MAX(mateno) FROM Community_board;

drop table cm_comment;



insert into MEMBER (member_id) values ('ddd@naver.com');
create sequence mate_no_seq
start with 1
increment by 1
nocache
nocycle;

select mate_no_seq.nextval from dual;

drop sequence mate_no_seq;


drop table community_board;

alter sequence mate_no_seq
nocache; --nocache로 수정 // community_board
 
alter sequence mate_no_seq
nocycle; --nocycle로 수정

--생성된 gongji_no_seq시퀀스 번호값 확인
select mate_no_seq.nextval as "시퀀스 번호값" from dual;

 

alter sequence cmimg_no_seq
nocache; -- Cm_img
alter sequence cmimg_no_seq
nocycle;


alter sequence repl_no_seq
nocache; --댓글 시퀀스 Cm_repl
alter sequence repl_no_seq
nocycle;