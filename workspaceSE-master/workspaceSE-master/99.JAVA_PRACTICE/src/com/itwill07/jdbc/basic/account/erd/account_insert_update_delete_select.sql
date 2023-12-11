
DROP TABLE account;

CREATE TABLE account(
    account_no NUMBER(10) PRIMARY KEY,
    account_owner VARCHAR2(50),
    account_balance NUMBER(10),
    account_iyul NUMBER(5, 1)
);

DROP SEQUENCE account_no_seq;

CREATE SEQUENCE account_no_seq
                 increment by 1
                 start with 1
                 nocycle
                 nocache;


--insert
INSERT INTO account(account_no, account_owner, account_balance, account_iyul) VALUES(account_no_seq.nextval,'이름', 951951 , 3.1);

--udate
UPDATE account SET account_owner = '홍길동' , account_balance = 123456789 WHERE account_no = 1;

 --delete
DELETE account WHERE accoount_no = 1;
 
 --select pk
SELECT * FROM account WHERE account_no = 2;
 
 --select all
SELECT * FROM account;
 