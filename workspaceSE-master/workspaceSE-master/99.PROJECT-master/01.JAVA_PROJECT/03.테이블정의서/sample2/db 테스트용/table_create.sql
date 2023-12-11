
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
	writer varchar2(20)
);

create table basket(
	no number primary key,
	product_no varchar2(25) not null,
	quantity number not null,
	id varchar2(20) not null,
	money number not null
);

create table bookorder (
	no number primary key,
	product_no varchar2(25) not null,
	quantity number not null,
	odate varchar2(10) not null,
	state varchar2(10) not null,
	id varchar2(20) not null,
	dno number,
	money number not null
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
	job varchar2(30)
);
insert into member values('test', 'test', 'test', 'test@test', '010-0101-0101', '111-111', '채문석 팀장 집', '마루타', '중성');

create table addr (
	zipcode char(10) not null,
	area1 char(20) not null,
	area2 char(30) not null,
	area3 char(30) not null,
	area4 char(60) not null
);

create table destination (
	dno number primary key,
	account varchar2(50) not null,
	delivery_name varchar2(20) not null,
	delivery_tel varchar2(20) not null,
	delivery_addr varchar2(150) not null
);

create table finance (
	account varchar2(50) primary key,
	bank varchar2(50) not null,
	name varchar2(30) not null
);
insert into finance values('1111-11111','국민은행','미디어심플');
insert into finance values('2222-22222','우리은행','미디어심플');
insert into finance values('3333-33333','신한은행','미디어심플');
insert into finance values('4444-44444','농협','미디어심플');
insert into finance values('5555-55555','하나은행','미디어심플');

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
	lev number null
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
	lev number null
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
	lev number null
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
	lev number null
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
	ip varchar2(20) not null
);

commit;

