/*
 * userinfo
 */

/*
 * product
 */
-- 제품리스트
select * from product;
-- 제품 상세보기
select * from product where p_no=1;

/*
 * cart
 */
--1. 로그인한 guard1 멤버한사람의 카트아이템리스트
select * from cart where userid = 'guard1';
select * from cart c join product p on c.p_no = p.p_no where userid = 'guard1';

--2.guard1 멤버한사람의 카트에 제품번호 존재여부
select count(*) as p_count from cart where userId = 'guard1' and p_no = 3;

--3.guard1 카트에 있는 1번제품의 수량을 1증가
update cart set cart_qty = cart_qty +1 where userid = 'guard1' and p_no = 1;

--4.guard1 카트에 있는 1번제품의 수량을 3으로 수정
update cart set cart_qty = 3 where userid = 'guard1' and p_no = 1; -- p_no 가 아니여도 cart pk로도 수정가능

--5.guard1님 카트아이템1개삭제; pk삭제하면 된다
delete from cart where cart_no = 1;
-- 유저조건 필요없다; 카트안에 있는 pk로 지우기때문에;

--6.guard1님 카트아이템모두삭제
delete from cart where userid = 'guard1';


/*
 * order
 */
--1. 멤버 한사람의 주문전체목록
select * from orders where userid='guard1';
--2. 주문한개(멤버 한사람의) 
select * from orders where o_no=1;
--3. 주문한개의 주문아이템 여러개(주문상세)
select * from orders o join order_item oi on o.o_no=oi.o_no  where o.o_no=1;
--4. 주문한개의 주문아이템,제품정보 여러개(주문상세,제품)
select * from orders o join order_item oi on o.o_no=oi.o_no join product p on oi.p_no=p.p_no where o.o_no=1;

--5. 멤버 한사람의(guard1) 주문전체목록(주문아이템+제품정보 여러개)(주문상세,제품)
select * from orders o join order_item oi on o.o_no=oi.o_no join product p on oi.p_no=p.p_no where o.userid='guard1';

--5. 주문한개삭제(주문1개삭제,주문상세삭제)
delete from order_item where o_no=1;
delete from orders where o_no=1;
--on delete cascade
delete from orders where o_no=1;

--6. 멤버한사람의 주문내역전체삭제
----on delete cascade
delete from orders where userid='guard2';






