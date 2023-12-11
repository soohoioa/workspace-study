drop table board;

create table board(
    board_no number(10) primary key,
    board_title varchar2(255),
    board_content varchar2(4000),
    board_wday date default sysdate,
    board_read_count number(10) default 0
);

drop sequence board_no_seq;

create sequence board_no_seq 
                 increment by 1
                 start with 1
                 nocycle
                 nocache;
                 
                 
--insert
insert into board(board_no,board_title,board_content)
              values(board_no_seq.nextval,'제목','내용입니다');
--pk update
update board set board_title='변경타이틀',board_content='변경content' where board_no=1;
--pk delete
delete board where board_no=1;
--pk select
select * from board where board_no=2;
--all select
select * from board;