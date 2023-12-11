DROP TABLE address CASCADE CONSTRAINTS;

CREATE TABLE address(
		no                            		NUMBER(10)		 NULL ,
		name                          		VARCHAR2(50)		 NULL ,
		phone                         		VARCHAR2(50)		 NULL ,
		address                       		VARCHAR2(60)		 NULL 
);

DROP SEQUENCE address_no_SEQ;

CREATE SEQUENCE address_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER address_no_TRG
BEFORE INSERT ON address
FOR EACH ROW
BEGIN
IF :NEW.no IS NOT NULL THEN
  SELECT address_no_SEQ.NEXTVAL INTO :NEW.no FROM DUAL;
END IF;
END;



ALTER TABLE address ADD CONSTRAINT IDX_address_PK PRIMARY KEY (no);

