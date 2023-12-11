DROP TABLE account CASCADE CONSTRAINTS;

CREATE TABLE account(
		no                            		NUMBER(10)		 NULL ,
		owner                         		VARCHAR2(50)		 NULL ,
		balance                       		NUMBER(10)		 NULL ,
		iyul                          		NUMBER(5,1)		 NULL 
);

DROP SEQUENCE account_no_SEQ;

CREATE SEQUENCE account_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER account_no_TRG
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
IF :NEW.no IS NOT NULL THEN
  SELECT account_no_SEQ.NEXTVAL INTO :NEW.no FROM DUAL;
END IF;
END;



ALTER TABLE account ADD CONSTRAINT IDX_account_PK PRIMARY KEY (no);

