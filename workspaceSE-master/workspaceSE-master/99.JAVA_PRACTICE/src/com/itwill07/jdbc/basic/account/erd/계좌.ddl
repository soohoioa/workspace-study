DROP TABLE account CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: account */
/**********************************/
CREATE TABLE account(
		no                            		NUMBER(10)		 NULL ,
		owner                         		VARCHAR2(50)		 NULL ,
		balance                       		NUMBER(10)		 NULL ,
		iyul                          		NUMBER(5,1)		 NULL 
);

COMMENT ON TABLE account is 'account';
COMMENT ON COLUMN account.no is 'no';
COMMENT ON COLUMN account.owner is 'owner';
COMMENT ON COLUMN account.balance is 'balance';
COMMENT ON COLUMN account.iyul is 'iyul';



ALTER TABLE account ADD CONSTRAINT IDX_account_PK PRIMARY KEY (no);

