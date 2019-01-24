drop table TB_SYSTEM cascade constraints;
drop table TB_USERS cascade constraints;
drop table TB_USERGROUP cascade constraints;
drop table TB_USERGROUP_INF cascade constraints;
drop table TB_PROGRAM_MAS cascade constraints;
drop table TB_MENU_MAS cascade constraints;
drop table TB_GROUPMENU_AUTH cascade constraints;
drop table TB_GROUPMENU_EXTAUTH cascade constraints;
drop table ORGCHART cascade constraints;
drop table VUSER_PASSWORD cascade constraints;




CREATE TABLE TB_SYSTEM (							
	SYSTEM_CODE        VARCHAR2(10) NOT NULL,						
	SYSTEM_NAME        VARCHAR2(50),						
	DOWNLOAD_BASE_URL  VARCHAR2(500) NOT NULL,						
	INITIALIZE_MODULE  VARCHAR2(500),						
	INITIALIZE_CLASS   VARCHAR2(500),						
	FTP_SERVER_PATH    VARCHAR2(50),						
	USER_ID            VARCHAR2(20),						
	PASSWORD           VARCHAR2(20),						
	INSERT_USER_ID     VARCHAR2(10) NOT NULL,						
	INSERT_DATE        DATE NOT NULL,						
	UPDATE_USER_ID     VARCHAR2(10) NOT NULL,						
	UPDATE_DATE        DATE NOT NULL,						
	FTP_IP             VARCHAR2(100)
);						
							
ALTER TABLE TB_SYSTEM ADD (							
	CONSTRAINT TB_SYSTEM_PK PRIMARY KEY (SYSTEM_CODE));
	
COMMENT ON TABLE TB_SYSTEM IS '사용자그룹관계';


CREATE TABLE TB_USERS (				
	USER_ID         VARCHAR2(7) NOT NULL,			
	KOR_NM          VARCHAR2(100) NOT NULL,			
	ENG_NM          VARCHAR2(100),			
	ASGN_CD         VARCHAR2(20),			
	DEPT_CD         VARCHAR2(20),			
	JOB_TIT_NM      VARCHAR2(100),			
	OFFI_TEL        VARCHAR2(100),			
	USE_YN          CHAR(1) NOT NULL,			
	DEPTNAME        VARCHAR2(200),			
	PASSWORD        VARCHAR2(2000) NOT NULL,			
	WRITE_DATE      DATE NOT NULL,			
	UPDATE_DATE     DATE NOT NULL,			
	END_DATE        VARCHAR2(8),			
	INSERT_USER_ID  VARCHAR2(10) NOT NULL,			
	INSERT_DATE     DATE NOT NULL,			
	UPDATE_USER_ID  VARCHAR2(10) NOT NULL,			
	START_DATE      VARCHAR2(8),			
	ID_GROUP        VARCHAR2(1));			

ALTER TABLE TB_USERS ADD (									
	CONSTRAINT TB_USERS_PK PRIMARY KEY (USER_ID));								

COMMENT ON TABLE TB_SYSTEM IS '사용자 관리';
COMMENT ON COLUMN TB_USERS.ID_GROUP IS 'ID GROUP(1:본사직영, 2:사내협력사, 3:사외협력사)';


CREATE TABLE TB_USERGROUP (						
	GROUP_ID         VARCHAR2(10) NOT NULL,					
	GROUP_NAME       VARCHAR2(50) NOT NULL,					
	USE_YN           CHAR(1) NOT NULL,					
	COMMON_GROUP_YN  CHAR(1),					
	SYSTEM_CODE      VARCHAR2(10),					
	GROUP_AUTH_INFO  VARCHAR2(100),					
	INSERT_USER_ID   VARCHAR2(10) NOT NULL,					
	INSERT_DATE      DATE NOT NULL,					
	UPDATE_USER_ID   VARCHAR2(10) NOT NULL,					
	UPDATE_DATE      DATE NOT NULL,					
	DESCR            VARCHAR2(500));					
						
ALTER TABLE TB_USERGROUP ADD (						
	CONSTRAINT TB_USERGROUP_PK PRIMARY KEY (GROUP_ID));					

COMMENT ON TABLE TB_USERGROUP IS '그룹 관리';


CREATE TABLE TB_USERGROUP_INF (						
	USER_ID         VARCHAR2(20) NOT NULL,					
	GROUP_ID        VARCHAR2(10) NOT NULL,					
	INSERT_DATE     DATE,					
	INSERT_USER_ID  VARCHAR2(20),					
	UPDATE_DATE     DATE,					
	UPDATE_USER_ID  VARCHAR2(20),					
	SID             VARCHAR2(10) DEFAULT 'IMS'  NOT NULL);					
						
ALTER TABLE TB_USERGROUP_INF ADD (						
	PRIMARY KEY (SID, USER_ID, GROUP_ID));					
						
COMMENT ON TABLE TB_USERGROUP_INF IS '사용자그룹관계';						
COMMENT ON COLUMN TB_USERGROUP_INF.USER_ID IS '사용자ID';						
COMMENT ON COLUMN TB_USERGROUP_INF.GROUP_ID IS '그룹ID';						


CREATE TABLE TB_PROGRAM_MAS (							
	PROGRAM_ID          VARCHAR2(30) NOT NULL,						
	SYSTEM_CD           VARCHAR2(10) NOT NULL,						
	PROGRAM_NM          VARCHAR2(100) NOT NULL,						
	URL                 VARCHAR2(250) NOT NULL,						
	CLASS_NAME          VARCHAR2(400),						
	APPLICATION_TYPE    NUMBER(2),						
	PARAMETER           VARCHAR2(500),						
	INSERT_DATE         DATE,						
	INSERT_USER_ID      VARCHAR2(20),						
	UPDATE_DATE         DATE,						
	UPDATE_USER_ID      VARCHAR2(20),						
	PARAM_YN            CHAR(1),						
	SAVE_YN             CHAR(1),						
	OUT_YN              CHAR(1),						
	EXTR_APP_PROGRAMID  VARCHAR2(20),						
	APP_NAME            VARCHAR2(20),						
	SID                 VARCHAR2(10) DEFAULT 'IMS'  NOT NULL,						
	PIC1                VARCHAR2(7),						
	PIC2                VARCHAR2(7),						
	MANUAL_FILE         VARCHAR2(100));						
							
ALTER TABLE TB_PROGRAM_MAS ADD (							
	PRIMARY KEY (PROGRAM_ID, SID));						
							
COMMENT ON TABLE TB_PROGRAM_MAS IS '프로그램';							
COMMENT ON COLUMN TB_PROGRAM_MAS.PROGRAM_ID IS '프로그램ID';							
COMMENT ON COLUMN TB_PROGRAM_MAS.SYSTEM_CD IS '시스템코드';							
COMMENT ON COLUMN TB_PROGRAM_MAS.PROGRAM_NM IS '프로그램명';							
COMMENT ON COLUMN TB_PROGRAM_MAS.URL IS 'URL';							
COMMENT ON COLUMN TB_PROGRAM_MAS.CLASS_NAME IS '클래스';							
COMMENT ON COLUMN TB_PROGRAM_MAS.APPLICATION_TYPE IS '응용프로그램분류';							
COMMENT ON COLUMN TB_PROGRAM_MAS.PARAMETER IS '전달인자';							
COMMENT ON COLUMN TB_PROGRAM_MAS.MANUAL_FILE IS '메뉴얼 파일';							



CREATE TABLE TB_MENU_MAS (					
	MENU_ID         VARCHAR2(15) NOT NULL,				
	PROGRAM_ID      VARCHAR2(30),				
	PARENT_ID       VARCHAR2(15),				
	TITLE           VARCHAR2(150) NOT NULL,				
	MSG_CD          VARCHAR2(60),				
	MENU_ACTION     NUMBER(4),				
	EXTRA_INFO      VARCHAR2(250),				
	CUSTOM_ACTION   NUMBER(2),				
	MENU_ORDER      NUMBER(5) DEFAULT 0,				
	EXPANDED        CHAR(1) DEFAULT 'N',				
	MENU_HIDE       CHAR(1) DEFAULT 'N',				
	STAFF_USER_ID   VARCHAR2(20),				
	USE_YN          CHAR(1) DEFAULT 'Y',				
	INSERT_DATE     DATE,				
	INSERT_USER_ID  VARCHAR2(20),				
	UPDATE_DATE     TIMESTAMP(6),				
	UPDATE_USER_ID  VARCHAR2(20),				
	PNO             VARCHAR2(5),				
	SID             VARCHAR2(10) DEFAULT 'IMS'  NOT NULL);				
					
ALTER TABLE TB_MENU_MAS ADD (					
	PRIMARY KEY (SID, MENU_ID));				
					
COMMENT ON TABLE TB_MENU_MAS IS '메뉴정보';					
COMMENT ON COLUMN TB_MENU_MAS.MENU_ID IS '메뉴ID';					
COMMENT ON COLUMN TB_MENU_MAS.PROGRAM_ID IS '프로그램ID';					
COMMENT ON COLUMN TB_MENU_MAS.PARENT_ID IS '부모메뉴ID';					
COMMENT ON COLUMN TB_MENU_MAS.TITLE IS '제목';					
COMMENT ON COLUMN TB_MENU_MAS.MSG_CD IS '메뉴표시명';					
COMMENT ON COLUMN TB_MENU_MAS.MENU_ACTION IS '메뉴기본동작';					
COMMENT ON COLUMN TB_MENU_MAS.EXTRA_INFO IS '추가정보';					
COMMENT ON COLUMN TB_MENU_MAS.CUSTOM_ACTION IS '메뉴커스텀동작';					
COMMENT ON COLUMN TB_MENU_MAS.MENU_ORDER IS '메뉴순서';					
COMMENT ON COLUMN TB_MENU_MAS.EXPANDED IS '하위메뉴확장여부';					
COMMENT ON COLUMN TB_MENU_MAS.MENU_HIDE IS '메뉴숨김여부';					
COMMENT ON COLUMN TB_MENU_MAS.STAFF_USER_ID IS '메뉴담당자ID';					
COMMENT ON COLUMN TB_MENU_MAS.USE_YN IS '사용여부';					
COMMENT ON COLUMN TB_MENU_MAS.PNO IS '메뉴번호';					



CREATE TABLE TB_GROUPMENU_AUTH (							
	MENU_ID         VARCHAR2(15) NOT NULL,						
	GROUP_ID        VARCHAR2(10) NOT NULL,						
	BASIC_ACLC      NUMBER(1) NOT NULL,						
	BASIC_ACLR      NUMBER(1) NOT NULL,						
	BASIC_ACLU      NUMBER(1) NOT NULL,						
	BASIC_ACLD      NUMBER(1) NOT NULL,						
	INSERT_DATE     TIMESTAMP(6),						
	INSERT_USER_ID  VARCHAR2(20),						
	UPDATE_DATE     TIMESTAMP(6),						
	UPDATE_USER_ID  VARCHAR2(20),						
	SID             VARCHAR2(10) DEFAULT 'IMS'  NOT NULL);						
							
ALTER TABLE TB_GROUPMENU_AUTH ADD (							
	PRIMARY KEY (SID, MENU_ID, GROUP_ID));						
							
COMMENT ON TABLE TB_GROUPMENU_AUTH IS '사용자그룹메뉴권한';							
COMMENT ON COLUMN TB_GROUPMENU_AUTH.MENU_ID IS '메뉴ID';							
COMMENT ON COLUMN TB_GROUPMENU_AUTH.GROUP_ID IS '사용자그룹ID';							
COMMENT ON COLUMN TB_GROUPMENU_AUTH.BASIC_ACLC IS '생성';							
COMMENT ON COLUMN TB_GROUPMENU_AUTH.BASIC_ACLR IS '조회';							
COMMENT ON COLUMN TB_GROUPMENU_AUTH.BASIC_ACLU IS '수정';							
COMMENT ON COLUMN TB_GROUPMENU_AUTH.BASIC_ACLD IS '삭제';							
							
							
CREATE TABLE TB_GROUPMENU_EXTAUTH (							
	GROUP_ID        VARCHAR2(10) NOT NULL,						
	MENU_ID         VARCHAR2(15) NOT NULL,						
	AUTH_ID         VARCHAR2(20) NOT NULL,						
	USE_YN          CHAR(1),						
	INSERT_DATE     TIMESTAMP(6),						
	INSERT_USER_ID  VARCHAR2(20),						
	UPDATE_DATE     TIMESTAMP(6),						
	UPDATE_USER_ID  VARCHAR2(20),						
	SID             VARCHAR2(10) DEFAULT 'IMS'  NOT NULL);						
							
ALTER TABLE TB_GROUPMENU_EXTAUTH ADD (							
	PRIMARY KEY (SID, GROUP_ID, MENU_ID, AUTH_ID));						
							
COMMENT ON TABLE TB_GROUPMENU_EXTAUTH IS '사용자그룹확장권한';							
COMMENT ON COLUMN TB_GROUPMENU_EXTAUTH.GROUP_ID IS '그룹ID';							
COMMENT ON COLUMN TB_GROUPMENU_EXTAUTH.MENU_ID IS '메뉴ID';							
COMMENT ON COLUMN TB_GROUPMENU_EXTAUTH.AUTH_ID IS '권한ID';							


CREATE TABLE ORGCHART (						
	GBN          CHAR(1),					
	GRP          VARCHAR2(2),					
	DEPT         VARCHAR2(2),					
	SECT         CHAR(2),					
	RESP         CHAR(2),					
	TEAM         CHAR(2),					
	GRP_NM       VARCHAR2(35),					
	DEPT_NM      VARCHAR2(20),					
	DEPT_ENM     VARCHAR2(150),					
	SECT_NM      VARCHAR2(20),					
	RESP_NM      VARCHAR2(20),					
	TEAM_NM      VARCHAR2(20),					
	NSOSOG       VARCHAR2(4),					
	SOSOG        VARCHAR2(4),					
	SOSOGNM      VARCHAR2(40),					
	SBN          CHAR(6),					
	HNAME        VARCHAR2(10),					
	ENAME        VARCHAR2(20),					
	JIKWI        CHAR(2),					
	JNM          VARCHAR2(40),					
	J_ENM        VARCHAR2(40),					
	JIKCHK       VARCHAR2(2),					
	JIKCHKNM     VARCHAR2(40),					
	HMIBSA       DATE,					
	HND_PHN      VARCHAR2(15),					
	WEBMAILID    VARCHAR2(35),					
	SANE_TEL_NO  VARCHAR2(5),					
	JUSER        VARCHAR2(2));					
						
CREATE INDEX ORGCHART_IDX04 ON ORGCHART (GRP, JIKCHK);						
CREATE INDEX ORGCHART_IDX05 ON ORGCHART (GRP, DEPT, JIKCHK);						
CREATE INDEX ORGCHART_IDX06 ON ORGCHART (GRP, DEPT, SECT, JIKCHK);						
CREATE INDEX ORGCHART_IDX02 ON ORGCHART (HNAME);						
CREATE INDEX ORGCHART_IDX03 ON ORGCHART (SOSOG, JIKCHK);						
CREATE INDEX ORGCHART_IDX01 ON ORGCHART (SBN);						



CREATE TABLE VUSER_PASSWORD (							
	USER_ID        VARCHAR2(7) NOT NULL,						
	PASSWORD       VARCHAR2(100) NOT NULL,						
	EMP_NO         VARCHAR2(7) NOT NULL,						
	EMP_NAME       VARCHAR2(50) NOT NULL,						
	INSERT_DATE    DATE NOT NULL,						
	REPL_DATE      DATE NOT NULL,						
	PW_ERROR_CHK   NUMBER(2) DEFAULT 0,						
	ACCESS_CHK     CHAR(1),						
	INFO_CHK       CHAR(1),						
	TREE_EXPAND    CHAR(1) DEFAULT 'Y',						
	LAST_LOGIN_DT  DATE,						
	SOSOG          VARCHAR2(4),						
	CELL_PHONE     VARCHAR2(15),						
	EMAIL          VARCHAR2(50),						
	DORMANCY_YN    CHAR(1) DEFAULT 'N',						
	DEPT_CD        CHAR(2),						
	TWX_YN         CHAR(1) DEFAULT 'N');						
							
ALTER TABLE VUSER_PASSWORD ADD (							
	CONSTRAINT VUSER_PASSWORD_PRM PRIMARY KEY (USER_ID));						
							
CREATE UNIQUE INDEX VUSER_PASSWORD_IDX02 ON VUSER_PASSWORD (EMP_NO);							
							
COMMENT ON COLUMN VUSER_PASSWORD.PW_ERROR_CHK IS '패스워드 입력오류체크';							
COMMENT ON COLUMN VUSER_PASSWORD.ACCESS_CHK IS '접근유무';							
COMMENT ON COLUMN VUSER_PASSWORD.TREE_EXPAND IS 'Y:트리메뉴펼침,N:펼치지않음';							
COMMENT ON COLUMN VUSER_PASSWORD.TWX_YN IS 'Thingworx 사용 유무';							
