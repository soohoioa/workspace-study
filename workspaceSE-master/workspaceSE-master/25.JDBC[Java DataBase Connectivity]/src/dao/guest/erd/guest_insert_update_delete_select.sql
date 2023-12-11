--guest
/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME              VARCHAR2(50)   
GUEST_DATE              DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE             VARCHAR2(100)  
GUEST_CONTENT           VARCHAR2(4000) 
*/
--pk delete 
delete from guest where guest_no = 1;

--insert
insert into guest values(guest_guest_no_seq.nextval, '홍길동1', sysdate, 'hong@naver.com', 'http://www.naver.com', '방명록사용방법1', '잘사용해볼까요1');
insert into guest values(guest_guest_no_seq.nextval, '홍길동2', sysdate, 'hong@naver.com', 'http://www.naver.com', '방명록사용방법2', '잘사용해볼까요2');
insert into guest values(guest_guest_no_seq.nextval, '홍길동3', sysdate, 'hong@naver.com', 'http://www.naver.com', '방명록사용방법3', '잘사용해볼까요3');
insert into guest values(guest_guest_no_seq.nextval, '홍길동4', sysdate, 'hong@naver.com', 'http://www.naver.com', '방명록사용방법4', '잘사용해볼까요4');
insert into guest values(guest_guest_no_seq.nextval, '홍길동5', sysdate, 'hong@naver.com', 'http://www.naver.com', '방명록사용방법5', '잘사용해볼까요5');

--pk update
update guest SET guest_name = 'name수정', 
                 guest_email = 'email수정', 
                 guest_homepage = 'homepage수정',
                 guest_title = 'title수정',
                 guest_content = 'content수정'
where guest_no=1;

--select pk
select * from guest where guest_no = 1;

--select all
select * from guest;


commit;
