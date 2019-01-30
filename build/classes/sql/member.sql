SELECT * FROM member;
DD : Table 
DD : 계정만는법
table구조로 만들어진다.
	* 
ststem/password  : object 원래 있는놈
	* 
----------------계정생성--------------------------------
	* 
CREATE USER oracle  IDENTIFIED BY password; =데이터  만드는
	* 
oracle/password
	* 
--------------------권한 부여------------------------------
	* 
GRANT RESOURCE, CONNECT , DBA TO oracle;
	* 
------------------------현재 사용자 정보---------------
	* 
SHOW USER;
	* 
SELECT * FROM TAB;
	* 
-----------테이블 생성-----------------------
    CREATE TABLE member(
    id VARCHAR2(10), 
    name VARCHAR2(10),
    pass VARCHAR2(10),
    ssn VARCHAR2(14)
   );
-------------테이블 지우는법------------
    DROP TABLE member;
-----------------인스턴스 생성------------------
    DB에서 한 row 를 추가하는것
    INSERT INTO  member(id,name,pass,ssn) :인스턴스 생성 명령어
    VALUES('hong','홍길동','1','960826-1234567')
    
    SELECT * FROM member;
    
    
    