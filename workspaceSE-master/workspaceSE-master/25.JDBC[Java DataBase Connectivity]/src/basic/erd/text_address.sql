select * from address;

-- insert
insert into address values(address_no_seq.nextval, '홍길동', '123-3456', '경기도 포천시');

-- update (pk)
update address set name = '홍변경' , phone = '888-8888' , address = '서울시 강남구' where no = 1;

-- delete (pk)
delete from address where no = 10;

-- selete (pk)
select no, name, phone, address from address where no = 2;

-- select (all selete)
select no, name, phone, address from address;








-- 단축키 잘 안먹으므로 마우스 우클릭으로 실행하기