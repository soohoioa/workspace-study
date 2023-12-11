
create table bookgroup(
	cnum number primary key,
	code varchar2(20) unique,
	cname varchar2(30) not null
);

create table book(
	no number primary key,
	code varchar2(20) not null, 
	name varchar2(50) not null,
	price number not null,
	pspec varchar2(12),
	detail varchar2(1000),       
	pdate varchar2(20),
	stock number not null,
	image varchar2(100),
	company varchar2(30),
	writer varchar2(20),
	constraint book_code_fk foreign key(code) references bookgroup(code)
);

create table finance (
	account varchar2(50) primary key,
	bank varchar2(50) not null,
	name varchar2(30) not null
);
insert into finance values('1111-11111','��������','�̵�����');
insert into finance values('2222-22222','�츮����','�̵�����');
insert into finance values('3333-33333','��������','�̵�����');
insert into finance values('4444-44444','����','�̵�����');
insert into finance values('5555-55555','�ϳ�����','�̵�����');

create table addr (
	zipcode varchar2(10) not null,
	area1 varchar2(20) not null,
	area2 varchar2(30) not null,
	area3 varchar2(30) not null,
	area4 varchar2(60) not null
);

create table destination (
	dno number primary key,
	account varchar2(50) not null,
	delivery_name varchar2(20) not null,
	delivery_tel varchar2(20) not null,
	delivery_addr varchar2(150) not null,
	constraint destination_account_fk foreign key(account) references finance(account)
);

create table manager (
	manager_id varchar2(20) primary key,
	manager_passwd varchar2(20) not null
);
insert into manager values('admin','12345');

create table member (
	id varchar2(20) primary key,
	passwd varchar2(20) not null,
	name varchar2(20) not null,
	email varchar2(50) unique,
	phone varchar2(20) not null,
	zipcode varchar2(10) not null,
	address varchar2(150) not null,
	job varchar2(30),
	sex varchar2(10) not null
);
insert into member values('test', 'test', 'test', 'test@test', '010-0101-0101', '111-111', 'ä���� ���� ��', '����Ÿ', '�߼�');

create table basket(
	no number primary key,
	product_no number not null,
	quantity number not null,
	id varchar2(20) not null,
	money number not null,
	constraint basket_product_no_fk foreign key(product_no) references book(no),
	constraint basket_product_no_id foreign key(id) references member(id)
);

create table bookorder (
	no number primary key,
	product_no number not null,
	quantity number not null,
	odate varchar2(10) not null,
	state varchar2(10) not null,
	id varchar2(20) not null,
	dno number,
	money number not null,
	constraint bookorder_product_no_fk foreign key(product_no) references book(no),
	constraint bookorder_id_fk foreign key(id) references member(id)
);

create table qnaboard (
	qna_num number primary key,
	id varchar2(20) not null,
	email varchar2(50),
	subject varchar2(100) not null,
	password varchar2(20) not null,
	reg_date date not null,
	readcount number,
	content varchar2(4000) not null,
	ip varchar2(20) not null,
	ans_num number null,
	lev number null,
	constraint qnaboard_id_fk foreign key(id) references member(id)
);

create table repboard (
	ans_num number primary key,
	manager_id varchar2(20) not null,
	email varchar2(50),
	subject varchar2(100) not null,
	password varchar2(20) not null,
	reg_date date not null,
	readcount number,
	content varchar2(4000) not null,
	ip varchar2(20) not null,
	qna_num number not null,
	lev number null,
	constraint repboard_manager_id_fk foreign key(manager_id) references manager(manager_id),
	constraint repboard_qna_num_fk foreign key(qna_num) references qnaboard(qna_num)
);

create table freeboard (
	free_num number primary key,
	id varchar2(20) not null,
	email varchar2(50),
	subject varchar2(100) not null,
	password varchar2(20) not null,
	reg_date date not null,
	readcount number,
	content varchar2(4000) not null,
	ip varchar2(20) not null,
	lev number null,
	constraint freeboard_id_fk foreign key(id) references member(id)
);  

create table infoboard (
	info_num number primary key,
	manager_id varchar2(20) not null,
	email varchar2(50),
	subject varchar2(100) not null,
	password varchar2(20) not null,
	reg_date date not null,
	readcount number,
	content varchar2(4000) not null,
	ip varchar2(20) not null,
	lev number null,
	constraint infoboard_manager_id_fk foreign key(manager_id) references manager(manager_id)
);

create table faqboard (
	faq_num number primary key,
	manager_id varchar2(20) not null,
	email varchar2(50),
	subject varchar2(100) not null,
	password varchar2(20) not null,
	reg_date date not null,
	readcount number,
	content varchar2(4000) not null,
	ip varchar2(20) not null,
	constraint faqboard_manager_id_fk foreign key(manager_id) references manager(manager_id)
);

commit;

