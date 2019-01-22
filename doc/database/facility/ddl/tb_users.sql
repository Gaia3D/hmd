drop table if exists TB_USERS cascade;

CREATE TABLE TB_USERS (
	USER_ID         VARCHAR2(7) NOT NULL,			
	KOR_NM          VARCHAR2(100) NOT NULL,			
	ENG_NM          VARCHAR2(100),			
);