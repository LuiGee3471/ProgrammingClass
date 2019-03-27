/*
[1일차 수업]
1. 오라클 소프트웨어 다운로드
https://www.oracle.com/technetwork/database/enterprise-edition/downloads/index.html

2. Oracle Database 11g Release 2 Express Edition for Windows 64

3. Oracle 설치(SYS, SYSTEM 계정의 대한 암호 : 1004)

4. Sqlplus 프로그램 제공(CMD): GUI 환경 일반개발자 사용 불편

5. 별도의 Tool 설치 무료(SqlDeveloper), 유료(토드 , 오렌지, SqlGate)

6. SqlDeveloper 툴을 통해서 Oracle Server 접속 ....
  >> HR 계정 : 암호 1004, Unlock 2가지 사용가능 ....(사원관리 실습 테이블)
  >> 새로운 계정 : bituser
  
  -- USER SQL
CREATE USER bituser IDENTIFIED BY 1004 
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";

-- QUOTAS
ALTER USER bituser QUOTA UNLIMITED ON USERS;

-- ROLES
GRANT "CONNECT" TO bituser WITH ADMIN OPTION;
GRANT "RESOURCE" TO bituser WITH ADMIN OPTION;
ALTER USER bituser DEFAULT ROLE "CONNECT","RESOURCE";

-- SYSTEM PRIVILEGES
7. 현재 접속 계정 확인 : show user;  >>  USER이(가) "BITUSER"입니다.

CREATE TABLE EMP
(EMPNO number not null,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR number ,
HIREDATE date,
SAL number ,
COMM number ,
DEPTNO number );
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);

COMMIT;

CREATE TABLE DEPT
(DEPTNO number,
DNAME VARCHAR2(14),
LOC VARCHAR2(13) );

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

COMMIT;



CREATE TABLE SALGRADE
( GRADE number,
LOSAL number,
HISAL number );

INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;

*/
/*
SELECT [DISTINCT] {*, column [alias], . . .}
FROM table_name
[WHERE condition]
[ORDER BY {column, expression} [ASC | DESC]];
*/
SELECT *
FROM emp;

SELECT *
FROM dept;

SELECT *
FROM salgrade;
--1. 사원테이블에서 모든 데이터를 출력하세요
 SELECT *
FROM emp;
-- 쿼리문장은 대소문자를 구별하지 않습니다
 SELECT *
FROM DEPT;

SELECT *
FROM salgrade;
--2. 특정 컬럼 데이터 출력하기
 SELECT empno, ename, sal
FROM emp;
--3. 컬럼에 가명칭(별칭)(alias) 부여하기
 SELECT empno 사번 , ename 이름
FROM emp;

SELECT empno "사    번" , ename "이    름"
FROM emp;
--정식(ansi 문법) as를 보면 아하 별칭이구나 !!
 SELECT empno AS "사    번" , ename AS "이    름"
FROM emp;
-- Oracle 데이터 문자열 (문자열 데이터는 대소문자 구분)
-- 문자열 표기 '문자열'
-- 소문자 : a  대문자 : A 다른 문자 취급
 SELECT empno, ename
FROM emp
WHERE ename = 'king';

SELECT empno, ename
FROM emp
WHERE ename = 'KING';
-- 데이터만 '' 이거고, alias는 "" 이겁니다
-- Oracle SQL : 연산자 (결합연산자(||)와 산술연산자(+) 구분)
-- Java : +(숫자 + 숫자 연산)
-- Java : +(문자열 + 문자열 결합)
-- TIP) ms-sql + (연산, 결합)
 SELECT '사원의 이름은 ' || ename || ' 입니다' AS "사원정보"
FROM emp;
-- 테이블 칼럼은 기본 타입
-- 컬럼의 타입 숫자, 문자, 날짜 ...
 DESc emp;
-- 테이블의 타입 기본정보를 조회 할 수 있다
 SELECT empno || ename
-- number || varchar 올래 말이 안되는데 내부적으로 형변환 (숫자 -> 문자)로 바꿔서 결합
FROM emp;

SELECT empno + ename
-- "invalid number" 타입이 맞지 않아서 산술연산은 불가하다
FROM emp;
-- 사장님 우리 회사에 직종이 몇개나 있나
-- distinct : 중복 데이터 제거
-- distinct 원리 : grouping (중복이되는 얘들을 하나로묶고 출력)
 SELECT DISTINCT job
FROM emp;
-- 재미삼아서 ... (group 에 group 의 데이터)
 SELECT DISTINCT job, deptno
FROM emp
ORDER BY job;

SELECT DISTINCT deptno, job
FROM emp
ORDER BY deptno;
---------------------------------------------------------------------
-- Oracle (SQL 언어)
-- JAVA 언어(연산자)
-- JAVA 거의 동일 ( +, *, - ...) : % 나머지  >> 오라클에선 % 검색 패턴  >> 나머지 구하는 연산자(X) : Mod() 함수
-- 산술연산 (+, *, -, / .....), Mod() 함수 나머지를 구한다
-- 사원 테이블에서 사원의 급여를 100달라 인상한 결과를 출력해보세요
 DESC emp;

SELECT empno, sal, sal + 100 AS "인상급여"
FROM emp;

SELECT 100 + 100
FROM dual;
-- dual 임시 테이블 ...
 SELECT 100 || 100
FROM dual;
-- 100100 (형변환)
 SELECT '100' + 100
FROM dual;
-- 오라클에서 + 는 무조건 산술 (문자를 숫자로바꿈)
 SELECT 'A100' + 100
FROM dual;
-- Error ....
-- 비교 연산자
-- >, <, <=
-- Java 같다 (==) (=)
-- Oracle 같다 (=) 같지 않다 (!=)
-- 논리 연산자
-- AND, OR, NOT
-- 조건절 (원하는 row만 가지고 오겠다)
 SELECT *
FROM emp
WHERE sal >= 3000;

SELECT empno, ename, sal
FROM emp
WHERE sal >= 3000;
-- 이상, 이하 (= 포함)
-- 초과, 미만 (= 포함 아님)
-- 사번이 7788인 사원의 사번, 이름, 직종, 입사일을 출력하세요
-- 실행순서  : 
 SELECT *
FROM emp;

SELECT empno, ename, job, hiredate
-- 3
FROM emp
-- 1 
WHERE empno = 7788;
-- 2
-- 사원의 이름이 king 사원의 사번, 이름, 급여정보를 출력하세요
 SELECT empno, ename, sal
FROM emp
WHERE ename = 'KING';
-- 급여가 2000달러 이상이면서 직종이 manager인 사원의 모든 정보를 출력하세요
-- 두개의 조건을 모두 만족 (둘다 참인)
 SELECT *
FROM emp
WHERE sal >= 2000
AND job = 'MANAGER';
-- 급여가 2000달러 이상이거나 직종이 manager인 사원의 모든 정보를 출력하세요
 SELECT *
FROM emp
WHERE sal >= 2000
OR job = 'MANAGER';
-- 오라클 날짜 (DB서버의 날짜)
-- 오라클 날짜 (sysdate)
-- 모든 시스템은 날짜 정보
-- 게시판 글쓰기
-- insert into board(writer, title, content, regdate) values('홍길동', '방가', '배고파요', sysdate);
-- TIP) ms -sql : select getdate();
 SELECT SYSDATE
FROM dual;

ALTER SESSION SET
nls_date_format = 'YYYY-MM-DD HH24:MI:SS';
-- 접속한 session을 기준으로 날짜가 나온다
 SELECT hiredate
FROM emp;
-- 오라클 시스템 테이블 ...
 SELECT *
FROM SYS.NLS_SESSION_PARAMETERS;
-- NLS_DATE_FORMAT  YYYY-MM-DD HH24:MI:SS
-- NLS_LANGUAGE KOREAN
-- NLS_TIME_FORMAT  HH24:MI:SSXFF
-- 오라클 날짜 조회 : '2019-12-12'
 SELECT *
FROM emp
WHERE hiredate = '1980-12-17';

SELECT *
FROM emp
WHERE hiredate = '1980/12/17';

SELECT *
FROM emp
WHERE hiredate = '80/12/17';
-- 형식은 인정이 안되요
-- 형식 : RR-MM-DD >> YYYY-MM-DD 로 바꿔놓았기 때문에 조회가 되지 않는다
-- 사원의 급여가 2000 이상이고 4000 이하인 모든 사원의 정보를 출력하세요
 SELECT *
FROM emp
WHERE sal >= 2000
AND sal <= 4000;
-- 연산자 : between A and B (= 포함)
-- 주의사항 : 미만 초과의 사용 금지
 SELECT *
FROM emp
WHERE sal BETWEEN 2000 AND 4000;
-- 사원의 급여가 2000 이상이고 4000 이하인 모든 사원의 정보를 출력하세요
 SELECT *
FROM emp
WHERE sal > 2000
AND sal < 4000;
-- 부서번호가 10번 또는 20번 또는 30번인 사원의 사번, 이름, 급여, 부서번호 출력하세요
 SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno = 10
OR deptno = 20
OR deptno = 30;
-- IN연산자 (조건 or 조건 or 조건 ...)
 SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno IN(10, 20, 30);
-- (오라클 내부적으로는) deptno = 10 or deptno = 20 or deptno = 30;
-- 부서번호가 10번 또는 20번이 아닌 사원의 사번, 이름, 급여, 부서번호 출력하세요
 SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno != 10
AND deptno != 20;
-- NOT IN 연산자(부정값 and 부정값 and ...)
 SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno NOT IN(10, 20);
-- deptno != 10 and deptno != 20;
-- POINT : Oracle 값이 없다 (데이터 없다) >> null
-- null (필요악)
 CREATE TABLE MEMBER( userid VARCHAR2(20) NOT NULL,
-- 필수 입력 사항 
 name VARCHAR2(20) NOT NULL,
-- 필수 입력 사항
 hobby VARCHAR2(50)
-- default null (null 값을 허용하겠다)
);

DESC MEMBER;

SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno NOT IN(10, 20);

SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno != 10
AND deptno != 20;

SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno != 10
OR deptno != 20;

INSERT INTO MEMBER(userid, hobby)
VALUES('hong', '농구');
-- 실행 안됨 (name 컬럼에 데이터를 넣지 않아서)
 INSERT INTO MEMBER(userid, name)
VALUES('hong', '홍길동');
-- hobby 컬럼의 데이터는 null 값으로 채워진다
 SELECT *
FROM MEMBER;

INSERT INTO MEMBER(userid, name, hobby)
VALUES('kim', '김씨', '게임');

SELECT *
FROM MEMBER;
-- 실제반영
 COMMIT;
-- 수당을 받지 않는 모든 사원의 정보를 출력하세요
-- 0도 데이터 취급(받는 조건 포함)
 SELECT *
FROM emp
WHERE comm = NULL;
-- (X) 안되는거임
-- null 의 비교는 (is null, is not null)
 SELECT *
FROM emp
WHERE comm IS NULL;
-- 수당(comm)을 받는 모든 사원의 정보를 출력하세요
 SELECT *
FROM emp
WHERE comm IS NOT NULL;
-- 사원테이블에서 사번, 이름, 급여, 수당, 총 급여를 출력하세요
-- 총 급여(급여 + 수당)
 SELECT empno, ename, sal, comm, sal + comm AS "총 급여"
FROM emp;

SELECT empno, ename, sal, comm, sal + NVL(comm, 0) AS "총 급여"
-- comm컬럼에서 null값을 만나면 0으로 바꿔라
FROM emp;
-- POINT null
-- 1. null 과의 모든 연산은 그 결과가 : null
-- 2. 위 문제 해결 : 함수 nvl(), nv12() >> TIP ms-sql : convert(), my-sql : IFNULL() : null 값 대체 ...
 SELECT 1000 + NULL
FROM dual;

SELECT 1000 + NVL(NULL, 0)
FROM dual;

SELECT comm, NVL(comm, 11111)
FROM emp;
-- 사원의 급여가 1000 이상이고 수당을 받지않는 사원의 사번, 이름, 직종, 급여, 수당을 출력하세요
 SELECT empno, ename, job, sal, comm
FROM emp
WHERE sal >= 1000
AND comm IS NULL;
-- DQL(data query language) : SELECT
-- DDL(데이터 정의어) : create, alter, drop.. (객체 생성, 수정, 삭제)
-- create Board (boardno number ...)
-- JAVA : class Board {private int boardno)}
 CREATE TABLE Board ( boardid NUMBER NOT NULL,
-- 숫자, 필수입력
 title VARCHAR2(20) NOT NULL,
-- 한글 10자, 영문자, 특수문자, 공백 20자 필수입력
 content VARCHAR2(2000) NOT NULL,
-- 한글 1000자, 영문자, 특수문자, 공백 2000자 필수입력
 hp VARCHAR2(20)
-- default null 허용 필수입력 사항 (X)
);

DESC Board;
-- DML(데이터 조작어) 반영 여부에 대해서 결정 (실반영할꺼냐(commit), 취소할꺼냐(rollback)) 반드시 수행
-- insert, update, delete 작업
 INSERT INTO Board(boardid, title, content)
VALUES (100, '오라클', '할만하네');

SELECT *
FROM Board;
-- 의사 결정 : 실제 반영 할거야 (commit)
-- 의사 결정 : 실제 반영 안할거야 (rollback)
 ROLLBACK;
-- insert를 했다하더라도 rollback을 하면 테이블에 데이터가 사라짐
 COMMIT;
-- begin
 INSERT INTO Board(boardid, title, content)
VALUES(200, '자바', '그립다');

INSERT INTO Board(boardid, title, content)
VALUES(300, '자바2', '그립다2');
-- commit 둘다반영
-- rollback 둘다취소
 SELECT *
FROM board;

COMMIT;

SELECT boardid, NVL(hp, 'EMPTY') AS "HP"
FROM board;
-- nvl 함수는 숫자, 날짜, 문자열 모두 적용 가능하다 ... 
------------------------------------------------------------------------
-- 문자열 검색
-- 주소 검색 : 검색어 : '역삼' -> 역삼 단어가 있는 모든 문장 (LIKE 검색)
-- 문자열 패턴 검색 (LIKE 연산자)
-- like 연산자 (와일드 카드 문자 ( % : 모든 것, _ : 한 문자) 결합 ...
-- like는 문자열 검색만 가능하다
 SELECT ename
FROM emp
WHERE ename LIKE '%A%';
-- ename 컬럼에 데이터에 A가 들어있는 모든 데이터를 검색하세요
 SELECT ename
FROM emp
WHERE ename LIKE '%a%';
-- 문자열 데이터 대소문자 엄격하게 구분
 SELECT ename
FROM emp
WHERE ename LIKE 'A%';
-- 이름의 첫 글자가 A로 시작
 SELECT ename
FROM emp
WHERE ename LIKE '김%';

SELECT ename
FROM emp
WHERE ename LIKE '김수환무%';

SELECT ename
FROM emp
WHERE ename LIKE '%S';

SELECT ename
FROM emp
WHERE ename LIKE '%LL%';

SELECT ename
FROM emp
WHERE ename LIKE '%A%A%';
-- A가 두개만 있으면 ...
 SELECT ename
FROM emp
WHERE ename LIKE '_A%';
-- 첫 글자 어떤것이 와도 상관없고 두번째 글자는 A가 와야한다
-- WARD
-- MARTIN
-- JAMES
-- 오라클 과제 (regexp_like) 상세 검색
-- select * from emp where regexp_like(ename, '[A-C]');
-- 정규표현식 (java -> oracle -> javascript)
-- 과제 : 정규 표현 예제 5개 만들기 (카페 올려드리면 하세요) 중간 프로젝트 요구사항
--------------------------------------------------------------------------------
-- 데이터 정렬하기
-- Order by 컬럼명 : 문자, 숫자, 날짜
-- 오름차순 asc : 낮은순 (default) 
-- 내림차순 : desc : 높은순
 SELECT *
FROM emp
ORDER BY sal;
-- default asc 오름차순 숫자가 점점 올라가는거임
 SELECT *
FROM emp
ORDER BY sal ASC;
-- 급여를 많이 받는 순으로 정렬해서 출력하세요
 SELECT *
FROM emp
ORDER BY sal DESC;

SELECT ename
FROM emp
ORDER BY ename ASC;
-- 문자열 데이터도 정렬이 가능하다
-- 입사일이 가장 늦은 순으로 정렬해서 사번, 이름 , 급여, 입사일, 데이터를 출력하세요
 SELECT empno, ename, sal, hiredate
FROM emp
ORDER BY hiredate DESC;

/*
실행 순서
SELECT        3
FROM          1
WHERE         2
ORDER BY      4 (select 결과를 정렬)
*/
-- 해석
 SELECT empno, ename, sal, job, hiredate
FROM emp
WHERE job = 'MANAGER'
ORDER BY hiredate DESC;
-- order by 컬럼명 desc, 컬럼명 asc, 컬럼명 desc
 SELECT job, deptno
FROM emp
ORDER BY job ASC, deptno DESC;
-- 연산자
-- 합집합(union) : 테이블과 테이블의 데이터를 합치는 것 (중복값은 배제)
-- 합집합(union all) : 중복값 허용
 CREATE TABLE uta (name VARCHAR2(20));

INSERT INTO uta(name)
VALUES('AAA');

INSERT INTO uta(name)
VALUES('BBB');

INSERT INTO uta(name)
VALUES('CCC');

INSERT INTO uta(name)
VALUES('DDD');

COMMIT;

SELECT *
FROM uta;

CREATE TABLE ut(name VARCHAR2(20));

INSERT INTO ut(name)
VALUES('AAA');

INSERT INTO ut(name)
VALUES('BBB');

INSERT INTO ut(name)
VALUES('CCC');

COMMIT;

SELECT *
FROM ut;
-- union
 SELECT *
FROM ut
UNION SELECT *
FROM uta;

SELECT *
FROM ut
UNION ALL SELECT *
FROM uta;
-- union 규칙
-- 1. 대응대는 컬럼의 타입이 동일
 SELECT empno, ename
FROM emp
UNION SELECT dname, deptno
FROM dept;
-- 대응되는 타입이 틀리다
 SELECT empno, ename
FROM emp
UNION SELECT deptno, dname
FROM dept;
-- 대응되는 타입이 같다
-- 실무 -> subquery (in line view) TIP ....
 SELECT empno, ename
FROM ( SELECT empno, ename
FROM emp
UNION SELECT deptno, dname
FROM dept )
ORDER BY empno DESC;
-- 2. 대응대는 컬럼의 개수가 동일해야 한다 (null 착한일)
 SELECT empno, ename, job, sal
FROM emp
UNION SELECT deptno, dname, loc, NULL
FROM dept;
-- 여기까지가 초보개발자가 의무적으로 해야하는 (단일 테이블) 대상으로 ....
--------------------------------------------------------------------------------
-- 오라클 함수 .......
 CREATE TABLE Student( hakbun NUMBER(20), name VARCHAR2(10), subject VARCHAR2(40), grade NUMBER(10), phone VARCHAR2(20) );

DROP TABLE Student;

INSERT INTO Student(hakbun, name, subject, grade, phone)
VALUES (984104, '한국산', '정보학개론', 3, '050-1234-1234');

INSERT INTO Student(hakbun, name, subject, grade, phone)
VALUES (993355, '강희영', '자료구조', 2, '010-1111-1111');

INSERT INTO Student(hakbun, name, subject, grade, phone)
VALUES (004188, '홍길동', '디지털논리회로', 1, '010-2222-2222');

SELECT *
FROM student;

SELECT *
FROM student
WHERE hakbun LIKE '%6%';

SELECT DISTINCT subject
FROM student
WHERE grade >= 3;
-- [2일차]
-- 오라클 함수 (오라클.pdf 49page)
 /*
단일 행 함수의 종류
1) 문자형 함수 : 문자를 입력 받고 문자와 숫자 값 모두를 RETURN 할 수 있다.
2) 숫자형 함수 : 숫자를 입력 받고 숫자를 RETURN 한다.
3) 날짜형 함수 : 날짜형에 대해 수행하고 숫자를 RETURN 하는 MONTHS_BETWEEN 함수를
제외하고 모두 날짜 데이터형의 값을 RETURN 한다.
4) 변환형 함수 : 어떤 데이터형의 값을 다른 데이터형으로 변환한다. (to_char(), to_number(), to_date())
5) 일반적인 함수 : NVL, DECODE
*/
-- 문자열 함수
 SELECT INITCAP('the super man')
FROM dual;
-- 공백을 기준으로 대문자로 바꿔줌
 SELECT LOWER('AAA'), UPPER('aaaa')
FROM dual;

SELECT ename, LOWER(ename) AS "ename"
FROM emp;

SELECT *
FROM emp
WHERE LOWER(ename) = 'king';
-- select에서만 쓰이는게 아니라 where절에서도 쓰인다
-- 문자열 개수
 SELECT LENGTH('abcd')
FROM dual;
-- 4
 SELECT LENGTH('홍길동')
FROM dual;
-- 3
 SELECT LENGTH(' 홍 a길 동')
FROM dual;
-- 7
-- 결합 연산자 || --> 표현할 수 있는 범위가 넓대
-- concat()
 SELECT 'a' || 'b' || 'c' AS "data"
FROM dual;

SELECT CONCAT('a', 'b') AS "data"
FROM dual;
-- 파라미터 개수에 제한이 있음
 SELECT CONCAT(ename, job)
FROM emp;
-- 띄어쓰기가 안됨
 SELECT ename || '    ' || job
FROM emp;
-- 부분 문자열 추출
-- java (subString)
-- oracle (substr)
 SELECT SUBSTR('ABCDE', 2, 3)
FROM dual;
-- BCD
 SELECT SUBSTR('ABCDE', 1, 1)
FROM dual;
-- 자기 자신 : A
 SELECT SUBSTR('ABCDE', 3, 1)
FROM dual;
-- C
 SELECT SUBSTR('ABCDE', 3)
FROM dual;
-- 3번째부터 뒤에 쫙
 SELECT SUBSTR('ABCDE', -2, 1)
FROM dual;
-- D
 SELECT SUBSTR('ABCDE', -2, 2)
FROM dual;
-- DE
 /*
사원 테이블에서 ename 컬럼 데이터에 대해서 첫글자는 소문자로 나머지 문자는 대문자로 출력하되
하나의 컬럼으로 출력하세요
-- 컬럼의 가명칭은 : fullname
-- 첫글자와 나머지 문자사이에 공백 하나를 넣으세요
ex) SMITH >> s MITH
*/
SELECT SUBSTR(LOWER(ename), 1, 1) || ' ' || SUBSTR(UPPER(ename), 2) AS "fullname"
FROM emp;
-- lpad, rpad(채우기)
 SELECT LPAD('ABC', 10, '*')
FROM dual;

SELECT RPAD('ABC', 10, '%')
FROM dual;
-- Quiz
-- 사용자 비번 : hong1006
-- 화면 : ho****** 출력하고 싶어요 (비번 : 1004 > 10**)
 SELECT RPAD(SUBSTR('hong1006', 1, 2), LENGTH('hong1006'), '*')
FROM dual;

SELECT RPAD(SUBSTR('hong1006', 1, 2), LENGTH('hong1006'), '*') AS "password"
FROM dual;

SELECT RPAD(SUBSTR('1004', 1, 2), LENGTH('1004'), '*') AS "password"
FROM dual;
-- emp 테이블에서 ename 컬럼의 데이터를 출력하는데 첫글자만 출력하고 나머지는 별표로 표시하세요
 SELECT RPAD(SUBSTR(ename, 1, 1), LENGTH(ename), '*') AS "ename"
FROM emp;

CREATE TABLE member2 ( id NUMBER, jumin VARCHAR2(14) );

INSERT INTO member2(id, jumin)
VALUES(100, '123456-1234567');

INSERT INTO member2(id, jumin)
VALUES(200, '234567-1234567');

COMMIT;

SELECT *
FROM member2;
-- Quiz
-- 출력결과
-- 하나의 컬럼으로 출력 : 
-- 100 : 123456-*******
-- 200 : 234567-*******
-- 칼럼의 가명칭 "juminnumber"
 DESC member2;

SELECT id || ' ' || RPAD(SUBSTR(jumin, 1, 7), LENGTH(jumin), '*') AS "juminnumber"
FROM member2;
-- rtrim 함수
-- [오른쪽 문자] 지워라
 SELECT RTRIM('MILLER', 'ER')
FROM dual;
-- MILL
 SELECT LTRIM('MILLLLLLLLLLER', 'MIL')
FROM dual;
-- ER
 SELECT '>' || RTRIM('MILLER     ', ' ') || '<'
FROM dual;
-- >MILLER< 공백제거
-- 치환함수 (replace)
 SELECT ename, REPLACE(ename, 'A', '와우')
FROM emp;
-- ename칼럼에서 A라는 글자를 찾아서 와우로 바꿔라
----------------- 문자열 함수 (END) -----------------
-- [숫자함수]
-- round (반올림 함수)
-- trunc (절삭함수)
-- 나머지 구하는 함수 (mode())
-- -3 -2 -1 0(정수) 1 2 3
 SELECT ROUND(12.345, 0) AS "r"
FROM dual;
-- 12  0은 정수부분만 남겨라, 반올림에 대해 적용해라
 SELECT ROUND(12.567, 0) AS "r"
FROM dual;
-- 13
 SELECT ROUND(12.345, 1) AS "r"
FROM dual;
-- 12.3 1은 소수 첫번째 자리부분만 남기고, 반올림 적용해라
 SELECT ROUND(12.567, 1) AS "r"
FROM dual;
-- 12.6
 SELECT ROUND(12.345, -1) AS "r"
FROM dual;
-- 10
 SELECT ROUND(15.345, -1) AS "r"
FROM dual;
-- 20
 SELECT ROUND(15.345, -2) AS "r"
FROM dual;
-- 0
-- trunc (반올림 하지 않고 버려요)
 SELECT TRUNC(12.345, 0) AS "t"
FROM dual;
-- 12  0은 정수부분만 남겨라, 반올림에 대해 적용해라
 SELECT TRUNC(12.567, 0) AS "t"
FROM dual;
-- 12
 SELECT TRUNC(12.345, 1) AS "t"
FROM dual;
-- 12.3 1은 소수 첫번째 자리부분만 남기고, 반올림 적용해라
 SELECT TRUNC(12.567, 1) AS "t"
FROM dual;
-- 12.5
 SELECT TRUNC(12.345, -1) AS "t"
FROM dual;
-- 10
 SELECT TRUNC(15.345, -1) AS "t"
FROM dual;
-- 10
 SELECT TRUNC(15.345, -2) AS "t"
FROM dual;
-- 0
------------------------------------------------------------------------
-- round, trunc의 차이점은 반올림을 하느냐, 않하느냐의 차이
-- 나머지
 SELECT 12 / 10
FROM dual;
-- 1.2
 SELECT MOD(12, 10)
FROM dual;
-- 나머지구하는 함수는 mod()
 SELECT MOD(0, 0)
FROM dual;
----------------- 숫자 함수 (END) -----------------
-- 날짜 함수
 SELECT SYSDATE
FROM dual;
-- alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS'
-- 날짜 연수(POINT)
-- Date + Number >> Date
-- Date - Number >> Date
-- Date - Date >> Number (일수)
 SELECT *
FROM SYS.NLS_SESSION_PARAMETERS;
-- NLS_DATE_FORMAT  YYYY-MM-DD HH24:MI:SS
 SELECT hiredate
FROM emp;

SELECT MONTHS_BETWEEN('2018-02-27', '2010-02-27')
FROM dual;
-- 개월의 차 96개월
 SELECT ROUND(MONTHS_BETWEEN(SYSDATE, '2010-01-01'), 1)
FROM dual;
-- 110.6
 SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, '2010-01-01'), 1)
FROM dual;
--  110.6
 SELECT TO_DATE('2019-03-20') + 100
FROM dual;
-- 문자를 날짜 형태로 바꿔줌 to_date
 SELECT TO_DATE('2019-03-20') + 1000
FROM dual;

SELECT SYSDATE + 1000
FROM dual;
-- 2021-12-14 11:26:01
-- Quiz
-- 1. 사원테이블에서 사원들의 입사일에서 현재날짜까지 근속월수를 구하세요
-- 단 근속월수는 정수부분만 출력하세요 (반올림 하지마세요)
-- 2. 한달이 31일 이라는 기준에서 근속월수를 구하세요(반올림 하지마세요)
-- 1.
 SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, hiredate), 0) AS "근속월수"
FROM emp;
-- 2.
 SELECT TRUNC((SYSDATE-hiredate)/ 31, 0) AS "근속월수"
FROM emp;
----------------- 숫자 함수 (END) -----------------
-- 문자 ...
-- 숫자 ...
-- 날짜 ... 날짜연산
--------------------------------------------------------------------------------
-- [변환함수] Today POINT
-- Oracle : 문자, 숫자, 날짜
-- to_char() : 숫자 -> 문자 (1000 -> $1000), 날짜 -> 문자 (2019-03-03 -> 2019년03월03일) 형식(format)
-- to_date() : 문자 -> 날짜 >> select '2019-03-03' + 1000 -> select to_date('2019-03-03') + 1000
-- to_number() : 문자 -> 숫자 (자동 형변환) 거의 안쓴데용
 SELECT '100' + 100
FROM dual;

SELECT TO_NUMBER('100') + 100
FROM dual;

/*
오라클 기본 데이터 타입
create table 테이블명 (컬럼명 타입)
create table member (age number); >> 1건 insert .. 1000건

Java : class person .. >> person p = new person(); 1건
            List<person> personlist = new ArrayList<person>();
            personlist.add(new person);
Oralce : create person .. >> ...

문자 타입
-- char(20) >> 20Byte >> 한글 10자, 영문자, 특수문자, 공백 20자 : 고정 길이 문자열
-- varchar2(20) >> 20Byte >> 한글 10자, 영문자, 특수문자, 공백 20자 : 가변 길이 문자열

char(20) >> '홍길동' >> 6Byte >> 홍길동을 20Byte 안에 저장
varchar2(20) >> '홍길동' >> 데이터 크기 만큼 공간 확보 >> 6Byte

고정길이 데이터 : 남, 여
char(2) >> 

성능상의 문제 )
char() -> varchar2() 검색 우선

결국 문제는 한글 ....
unicode (2Byte) : 한글, 영문자, 특수문자, 공백 >> 2Byte

nchar(20) >> 20글자 >> 2*20 40Byte
nvarchar2(30) >> 30글자 ...

*/
--1. to_number() : 문자를 숫자로 (자동 형변환)
 SELECT '1' + 1
FROM dual;

SELECT TO_NUMBER('1')+ 1
FROM dual;
--2. to_char() : 숫자 -> 형식문자, 날짜 -> 형식문자
 SELECT TO_CHAR(SYSDATE) || '일'
FROM dual;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY') || '년', TO_CHAR(SYSDATE, 'YEAR'), TO_CHAR(SYSDATE, 'MM'), TO_CHAR(SYSDATE, 'DD'), TO_CHAR(SYSDATE, 'DAY'), TO_CHAR(SYSDATE, 'DY')
FROM dual;

/*
입사일이 12월인 사원들의 사번, 이름, 입사일, 입사년도, 입사월을 출력하세요
*/
SELECT empno, ename, hiredate, TO_CHAR(hiredate, 'YYYY') AS "입사년도" , TO_CHAR(hiredate, 'MM') AS "입사월"
FROM emp
WHERE TO_CHAR(hiredate, 'MM') = '12';

SELECT TO_CHAR(hiredate, 'YYYY MM DD')
FROM emp;

SELECT TO_CHAR(hiredate, 'YYYY"년"MM"월"DD"일"')
FROM emp;
-- to_char() : 숫자 -> 형식문자
-- 1000000 -> $1,000,000,000(문자형태로)
-- 표 오라클.pdf 71pg
 SELECT '>' || TO_CHAR(12345, '9999999999999') || '<'
FROM dual;

SELECT '>' || TO_CHAR(12345, '09999999999999') || '<'
FROM dual;

SELECT '>' || TO_CHAR(12345, '$9,999,999,999') || '<'
FROM dual;
--$12,345 < 결과는 문자 데이터
 SELECT sal, TO_CHAR(sal, '$999,999')
FROM emp;
-- HR 계정으로 전환-----------------------------
 SELECT *
FROM employees;

/*
사원테이블(employees)에서 사원의 이름은 last_name, first_name 합쳐서 fullname 별칭 부여해서 출력하고
입사일은 YYYY-MM-DD 형식으로 출력하고 연봉(급여*12)을 구하고 연봉의 10%(연봉*1.1)인상한 값을
출력하고 그 결과는 1000단위 콤마 처리해서 출력하세요
단 2005년 이후 입사자들만 출력하세요 그리고 연봉이 높은 순으로 출력하세요
*/
SELECT first_name || last_name AS "fullname", TO_CHAR(hire_date, 'YYYY-MM-DD'), salary*12 AS "연봉", TO_CHAR(salary*12*1.1, '999,999') AS "연봉인상한 값"
FROM employees
WHERE TO_CHAR(hire_date, 'YYYY') >= '2005'
ORDER BY "연봉" DESC;
-- order by 별칭이 올수 있다 (order by 마지막으로 실행되기때문에)
-- 다시 bituser 계정으로 전환-----------------------------
-- to_date() 문자 -> 날짜
 SELECT '2019-03-03' + 100
FROM dual;
-- select에 오는건 문자 데이터다 그래서 날짜로 바꿔준다
 SELECT TO_DATE('2019-03-03') + 100
FROM dual;
--------------------------------------------------------------------------------
-- 변환함수 (to_char(), to_date(), to_number() ----------------------------------
-- 일반함수 (프로그램적인 성격이 강한 함수)
-- nvl(), nvl2() >> null 처리 함수
-- decode() 함수 >> java if 문
-- case() 함수 >> java switch 문
 SELECT comm, NVL(comm, 0)
FROM emp;

CREATE TABLE t_emp( id NUMBER(6), job VARCHAR2(20) );

SELECT *
FROM t_emp;

INSERT INTO t_emp(id, job)
VALUES(100, 'IT');

INSERT INTO t_emp(id, job)
VALUES(200, 'SALES');

INSERT INTO t_emp(id, job)
VALUES(300, 'MGR');

INSERT INTO t_emp(id)
VALUES(400);

INSERT INTO t_emp(id, job)
VALUES(500, 'MGR');

COMMIT;
-- 1. nvl
 SELECT id, job, NVL(job, 'EMPTY...') AS "job"
FROM t_emp;
-- 2. nvl2 >> , null이 아닌 경우, null인 경우
 SELECT id, job, NVL2(job, job || '입니다', 'empty')
FROM t_emp;
--3. decode POINT (통계 데이타 : if, switch)
-- decode(표현식, 조건1, 결과1, 조건2, 결과2, 조건3, 결과3 ....)
 SELECT id, job, DECODE(id, 100, 'IT...', 200, 'SALES...', 300, 'MGR', 'ETC...') AS "decodejob"
FROM t_emp;

SELECT job, DECODE(job, 'IT', 1)
FROM t_emp;

SELECT COUNT(DECODE(job, 'IT', 1)) AS "IT", COUNT(DECODE(job, 'SALES', 1)) AS "SALES", COUNT(DECODE(job, 'MGR', 1)) AS "MGR"
FROM t_emp;

/*
emp 테이블에서 부서번호가 10이면 '인사부', 20이면 '관리부', 30이면 '회계부'
나머지 부서는 기타부서
*/
SELECT deptno, DECODE(deptno, 10, '인사부', 20, '관리부', 30, '회계부', '기타부서') AS "부서"
FROM emp;
-- Quiz
 CREATE TABLE t_emp2 ( id NUMBER(2), jumin CHAR(7) );

INSERT INTO t_emp2(id, jumin)
VALUES(1, '1234567');

INSERT INTO t_emp2(id, jumin)
VALUES(2, '2234567');

INSERT INTO t_emp2(id, jumin)
VALUES(3, '3234567');

INSERT INTO t_emp2(id, jumin)
VALUES(4, '4234567');

INSERT INTO t_emp2(id, jumin)
VALUES(5, '5234567');

COMMIT;

SELECT *
FROM t_emp2;

/*
t_emp2 테이블에서 id, jumin 데이터를 출력하되 jumin 컬럼의 앞자리가 1이면
'남성' 출력 2이면 '여성', 3이면 '중성' 그외는 '기타' 라고 출력하세요
컬럼명은 '성별'
*/
SELECT id, DECODE(SUBSTR(jumin, 1, 1), 1, '남성', 2, '여성', 3, '중성', '기타') AS "성별"
FROM t_emp2;

/*
부서번호가 20번인 사원중에서 SMITH라는 이름을 가진 사원이라면 HELLO 문자 출력하고
부서번호가 20번인 사원중에서 SMITH라는 이름을 가진 사원이 아니라면 WORLD 문자 출력하고
부서번호가 20번인 사원이 아니라면 ETC라는 문자를 출력하세요
*/
SELECT empno, ename, DECODE(deptno, 20, DECODE(ename, 'SMITH', 'HELLO', 'WORLD'), 'ETC')
FROM emp;
-- CASE 문
-- Java : switch
 /*
 case 조건식 when 결과1 then 출력1
            when 결과2 then 출력2
            when 결과3 then 출력3
            ELSE 출력4
  END "컬럼명"
  
  
*/
CREATE TABLE t_zip( zipcode NUMBER(10) );

INSERT INTO t_zip(zipcode)
VALUES(2);

INSERT INTO t_zip(zipcode)
VALUES(31);

INSERT INTO t_zip(zipcode)
VALUES(32);

INSERT INTO t_zip(zipcode)
VALUES(33);

INSERT INTO t_zip(zipcode)
VALUES(41);

COMMIT;

SELECT *
FROM t_zip;

SELECT '0' || TO_CHAR(zipcode) AS "지역번호", CASE zipcode
WHEN 2 THEN '서울'
WHEN 31 THEN '경기'
WHEN 32 THEN '강원'
WHEN 41 THEN '제주'
ELSE '기타지역'
END "regionname"
FROM t_zip;

/*
사원 테이블에서 사원급여가 1000달라 이하면 '4급'
1001달러 2000달러 이하면 '3급'
2001달러 3000달러 이하면 '2급'
3001달러 4000달러 이하면 '1급'
4001달라 이상이면 '특급'
*/
-- 1. case 컬럼명 when 결과 then 출력 (=) 조건
-- 2. case when 컬럼명 조건 비교식 then 출력
 SELECT sal, CASE
WHEN sal <= 1000 THEN '4급'
WHEN sal BETWEEN 1001 AND 2000 THEN '3급'
WHEN sal BETWEEN 2001 AND 3000 THEN '2급'
WHEN sal BETWEEN 3001 AND 4000 THEN '1급'
ELSE '특급'
END "급여등급"
FROM emp;
--------------------------------------------------------------------------------
-- 문자함수
-- 숫자함수
-- 날짜함수
-- 변환함수(to_char(), to_date(), to_number())
-- 일반함수 (nvl(), decode(), case() ...)
--------------------------------------------------------------------------------
-- 오라클.pdf (75page)
-- 집계함수
-- 1. count(*) > row 수, count(컬럼명) >> 데이터 건수 (null을 포함하지 않는다)
-- 2. sum()
-- 3. avg()
-- 4. max()
-- 5. min()
-- 등등
 /*
1. 집계함수는 group by 절과 같이 사용
2. 모든 집계함수는 null 값을 무시한다
3. select 절에 집계함수 이외에 다른 컬럼이 오면 반드시 그 컬럼은 group by 절에 명시되어야 한다
*/
SELECT COUNT(*)
FROM emp;

SELECT COUNT(comm)
FROM emp;
-- null 값을 무시하기 때문에 6건이 나온다
 SELECT COUNT(empno)
FROM emp;
-- select count(comm) from emp; 데이터가 14건 출력하게 ....
 SELECT COUNT(NVL(comm, 0))
FROM emp;
---------------------------------------------------------
-- 급여의 합
 SELECT SUM(sal) AS "급여의 합"
FROM emp;
-- 29025
-- 평균 급여
 SELECT ROUND(AVG(sal), 0) AS "평균 급여"
FROM emp;
-- 2073
-- 사장님이 회사 총 수당이 얼마나 지급되나 .... (수당의 평균)
 SELECT TRUNC(AVG(comm), 0)
FROM emp;
-- 721
 SELECT TRUNC(SUM(comm)/ 6, 0)
FROM emp;
-- 721 ---회사의 규정이 (받는 사원수로 나눈다 ... 721)
 SELECT SUM(comm)
FROM emp;

-4330 SELECT TRUNC(SUM(comm)/ 14, 0)
FROM emp;
-- 309 
 SELECT TRUNC(AVG(NVL(comm, 0)), 0)
FROM emp;
-- null 값을 0으로 바꿔주고, 개수에 포함해주기 위해서
-- 회사의 규정이 (전체 사원수로 나눈다 ... 309)
-- 회사의 규정이 (받는 사원수로 나눈다 ... 721)
 SELECT COUNT(*)
FROM emp
WHERE comm IS NULL;
--데이터 처리 null 검증 처리
 SELECT MAX(sal)
FROM emp;

SELECT MIN(sal)
FROM emp;
-- POINT 집계함수 결과는 1개 (1건 컬럼하나 row하나)
 SELECT empno, COUNT(empno)
FROM emp;
-- 공존하지 못한다
-- 왜냐하면 empno는 14건이고 count는 1건의 데이터이기 때문에
 SELECT SUM(sal), AVG(sal), MAX(sal), MIN(sal), COUNT(sal), COUNT(*)
FROM emp;
-- 부서별 평균 급여를 구하세요
 SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno;
-- 사원 테이블에서 부서번호 별로 묶어서 평균을 내겠다
 SELECT deptno, AVG(sal)
-- deptno는 여러건의 데이터, avg(sal)은 한건의 데이터를 나타내기 때문에
FROM emp;
-- 이거는 안돼용
 SELECT job, AVG(sal)
FROM emp
GROUP BY job;
-- 직종별 평균급여, 급여합, 최대급여, 최소급여, 건수
 SELECT job, AVG(sal), SUM(sal), MAX(sal), MIN(sal), COUNT(sal)
FROM emp
GROUP BY job;

/*
grouping 원리

distinct 컬럼명1, 컬럼명2
order by 컬럼명1, 컬럼명2
group by 컬럼명1, 컬럼명2
*/
-- 부서별, 직종별 급여의 합을 구하세요
 SELECT deptno, job, SUM(sal), COUNT(sal)
FROM emp
GROUP BY deptno, job
ORDER BY deptno;

/*
select      --4
from        --1
where       --2
group by    --3
order by    --5
*/
/*
직종별 평균급여가 3000달러 이상인 사원의 직종과 평균급여를 출력하세요
group by 조건절
having 절
*/
SELECT job, AVG(sal) AS "avgsal"
FROM emp
-- where 순서상 group by보다 우선..
-- where avg(sal) >= 3000
GROUP BY job
HAVING AVG(sal) >= 3000;

/*
from 의 조건절 where
group by 의 조건절 having
*/
/*
select      5
from        1
where       2
group by    3
having      4
order by    6
*/
/*
1. 사원테이블에서 직종별 급여합을 출력하되 수당은 지급받고 급여의 합이 5000 이상인 사원들의 목록을 출력하세요
-- 급여의 합이 낮은 순으로 출력하세요

2. 사원테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 출력하세요

3. 사원테이블에서 직종별 급여의 합이 5000를 초과하는 직종과 급여의 합을 출력하세요
단 판매직종(salesman)은 제외하고 급여합으로 내림차순 정렬하세요
*/
-- 1.
 SELECT job, AVG(sal) AS "급여 합"
FROM emp
WHERE comm IS NOT NULL
GROUP BY job
HAVING SUM(sal)>= 5000
ORDER BY AVG(sal) ASC;
-- 2. 사원테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 출력하세요
 SELECT *
FROM emp;

SELECT deptno, COUNT(*) AS "부서별인원" , SUM(sal) AS "부서별 급여의 합"
FROM emp
GROUP BY deptno
HAVING COUNT(*) >4;
-- 3. 사원테이블에서 직종별 급여의 합이 5000를 초과하는 직종과 급여의 합을 출력하세요
-- 단 판매직종(salesman)은 제외하고 급여합으로 내림차순 정렬하세요
 SELECT job, SUM(sal)
FROM emp
WHERE job != 'SALESMAN'
GROUP BY job
HAVING SUM(sal) >5000
ORDER BY SUM(sal) DESC;

세팅) CREATE TABLE student2( name VARCHAR2(20) NOT NULL, age NUMBER NOT NULL, phone NUMBER(30), birthday DATE NOT NULL );

INSERT INTO student2 (name, age, phone, birthday)
VALUES ('김민지', 16, 01012341234, '2004-08-04');

INSERT INTO student2 (name, age, phone, birthday)
VALUES ('강소심', 15, 01023456789, '2004-01-04');

INSERT INTO student2 (name, age, phone, birthday)
VALUES ('김나나', 15, 01034567890, '2005-01-02');

INSERT INTO student2 (name, age, phone, birthday)
VALUES ('장윤지', 15, 01056789012, '2005-01-17');

INSERT INTO student2 (name, age, birthday)
VALUES ('홍래경', 15, '2005-07-04');

INSERT INTO student2 (name, age, birthday)
VALUES ('문소진', 15, '2005-11-04');

INSERT INTO student2 (name, age, phone, birthday)
VALUES ('김지석', 14, 01067890123, '2006-01-01');

INSERT INTO student2 (name, age, phone, birthday)
VALUES ('김나나', 14, 01078901234, '2006-06-06');

INSERT INTO student2 (name, age, phone, birthday)
VALUES ('장석규', 14, 01089012345, '2006-05-04');

INSERT INTO student2 (name, age, phone, birthday)
VALUES ('김민지', 16, 01012341234, '2004-08-04');

SELECT name AS "학생 이름", age + 10 AS "age", phone, birthday
FROM student2
ORDER BY name ASC;
--문제1)
--전체 테이블을 name 오름차순으로 출력하세요.
--name칼럼을 ‘학생 이름‘으로 바꾸세요
--학생테이블에서 학생들에 나이에 10씩 더해서 출력하세요.
--문제2)
--성이 김씨거나, 장씨, 문씨인 학생들을 출력하고, 이름 앞에 나이, 이름 뒤에 ‘착한 학생’이라는 단어를 붙이세요. (or 사용, 정규표현식 사용)
 SELECT age || name || ' ' || '착한 학생', phone, birthday
FROM student2
WHERE SUBSTR(name, 1, 1) = '김'
OR SUBSTR(name, 1, 1) = '장'
OR SUBSTR(name, 1, 1) = '문';
--문제3)
--이름과 나이가 중복되는 값이 없게 나이과 이름을 내림차순으로 출력하세요. (로우중복이 안되면 된다)
 SELECT DISTINCT name, age
FROM student2
ORDER BY name, age DESC;
--문제4)
--dual 테이블에서 2000 /3의 나머지를 출력하세요
 SELECT MOD(2000, 3)
FROM dual;
--문제5)
-- 생일이 2005년도~2006년에 태어난 학생들을 출력하세요. (번호없는 학생은 ‘0’으로 같이 출력되게..)
 SELECT *
FROM student2;

SELECT name, age, NVL(phone, 0) AS "phone", birthday
FROM student2
WHERE TO_CHAR(birthday, 'YYYY') BETWEEN '2005' AND '2006';

SELECT *
FROM employees;
--* HR 계정으로 하세요
--* 1. 부서 번호(department_id)가 50인 사원들의 이메일 아이디(email)를 불러와 아이디를 소문자로 바꾸고 아이디@oracle.com 형식으로 출력하세요.
--* 출력 : abull@oracle.com
 SELECT LOWER(email) || '@oracle.com'
FROM employees
WHERE department_id = 50;
--* 2. 모든 사원의 전화번호(phone_number)를 불러와 앞의 3개 숫자를 010으로 바꾸고 '.'을 '-'로 바꿔서 출력하세요
--* - ex) 515.123.4567 >> 010-123-4567
 SELECT REPLACE(REPLACE(phone_number, SUBSTR(phone_number, 1, 3), '010'), '.', '-')
FROM employees;
--* 3. 부서 번호 별로 급여(salary)의 총합이 얼마인지 출력하되 사원 번호(employee_id)가 100번부터 150번까지인 사람만 계산해서 출력하세요
 SELECT SUM(salary)
FROM employees
WHERE employee_id BETWEEN '100' AND '150'
GROUP BY department_id;
--* 4. 입사 연도별로 입사등급을 나눠 출력하고 사원의 이름(first_name)과 성(last_name)을 중간에 공백을 넣어 같이 출력하세요
--* - 2002년 입사 >> 원로
--* - 2005년 입사 >> 청년
--* - 2007년 입사 >> 꼬꼬마
--* - 그외 >> 외계인
--* 출력 : Steven King 외계인
--*/
 SELECT *
FROM employees;

SELECT DECODE(TO_CHAR(hire_date, 'YY'), '02', '원로', '05', '아무개', '07', '뚱뚱이', '외계인') AS "입사등급", first_name || ' ' || last_name AS "이름출력"
FROM employees;
--------------------------------------------------------------------------------
-- [JOIN] 다중 테이블로부터 데이터 검색
-- 오라클.pdf (85 Page)
-- 조인 실습 테이블 구성하기--
CREATE TABLE M (M1 CHAR(6) , M2 CHAR(10));

CREATE TABLE S (S1 CHAR(6) , S2 CHAR(10));

CREATE TABLE X (X1 CHAR(6) , X2 CHAR(10));

INSERT INTO M
VALUES('A', '1');

INSERT INTO M
VALUES('B', '1');

INSERT INTO M
VALUES('C', '3');

INSERT INTO M
VALUES(NULL, '3');

COMMIT;

INSERT INTO S
VALUES('A', 'X');

INSERT INTO S
VALUES('B', 'Y');

INSERT INTO S
VALUES(NULL, 'Z');

COMMIT;

INSERT INTO X
VALUES('A', 'DATA');

COMMIT;

SELECT *
FROM m;

SELECT *
FROM s;

SELECT *
FROM x;
-- 종류
-- 1. 등가조인(equi join) 70%
-- 원테이블과 대응대는 테이블에 있는 컬럼의 데이터를 1:1 맵핑
-- SQL JOIN 문법
-- ANSI 문법 (권장) [inner] join on ~ 조건절
-- SQL JOIN
SELECT *
FROM m, s
WHERE m.m1 = s.s1;

SELECT m.m1, m.m2, s.s2
FROM m, s
WHERE m.m1 = s.s1;
-- ANSI 문법
-- where (from 절의 조건절)
-- where JOIN 조건절로 사용 (어떤것이 JOIN 조건이고, 어떤것이 From 절의 조건절인지 혼동)
-- ANSI JOIN의 조건절은 ON 표기
SELECT *
FROM m
INNER JOIN s
-- inner는 생략가능
 ON
m.m1 = s.s1;

SELECT m.m1, s.s1, s.s2
FROM m
JOIN s
-- inner 구문은 생략 가능
 ON
m.m1 = s.s1;

SELECT m.m2, x.x1, x.x2
FROM m
JOIN x ON
m.m1 = x.x1;
-- 사원번호, 사원이름, 사원 부서번호, 사원부서명을 알고 싶어요
SELECT emp.empno, emp.ename, emp.deptno, dept.dname
FROM emp
JOIN dept ON
emp.deptno = dept.deptno;
-- JOIN 에서 테이블에 별칭 부여 ..
SELECT e.empno, e.ename, e.deptno, d.dname
FROM emp e
JOIN dept d ON
e.deptno = d.deptno;
-- SQL JOIN 문법 (3개 테이블 조인)
SELECT *
FROM m, s, x
WHERE m.m1 = s.s1
AND s.s1 = x.x1;
-- A = B, B = C >> A = C
SELECT m.m1, s.s2, x.x2
FROM m
JOIN s ON
m.m1 = s.s1
JOIN x ON
s.s1 = x.x1;
--[ HR 계정으로 이동 ] 
SELECT *
FROM employees;
-- department_id
SELECT *
FROM departments;
-- department_id, location_id
 SELECT *
FROM locations;
-- location_id
-- 1. 사번, 이름(last_name), 부서번호, 부서이름(departments 테이블에 있음)을 출력
 SELECT e.employee_id, e.last_name, e.department_id, d.department_name
FROM employees e
JOIN departments d ON
e.department_id = d.department_id
ORDER BY e.employee_id ASC;
-- 문제점
 SELECT COUNT(*)
FROM employees;
-- 107명
-- 위 join 쿼리의 결과는 : 106명 (누군가는 누락 ...)
-- 등가 조인으로 해결불가 ... outer join
-- 2. 사번, 이름(last_name), 부서번호, 부서명, 지역코드, 도시명 출력하세요
SELECT e.employee_id, e.last_name, e.department_id, d.department_name, l.location_id, l.city
FROM employees e
JOIN departments d ON
e.department_id = d.department_id
JOIN locations l ON
d.location_id = l.location_id;
---------------------------------------------------------------
-- 2. 비등가 JOIN(non-equi join) => 의미만 존재
-- 원테이블과 대응되는 테이블에 있는 컬럼이 1:1 매핑이 되지 않는 경우
-- ex) emp, salgrade 급여 등급(emp 테이블에 있는 sal >> salgrade losal <= sal <= hisal

SELECT
  *
FROM emp;

SELECT
  *
FROM salgrade;

SELECT
  e.empno,
  e.ename,
  e.sal,
  s.grade
FROM emp e
INNER JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
-----------------------------------------------------------------------------
-- 3. outer join (equi join + null)
-- outer join : 주종 관계 파악 >> 주가 되는 테이블의 데이터를 가져오는 방법 (equi JOIN하고 남는 데이터)
-- 문법) LEFT OUTER JOIN(왼쪽 주)
--       RIGHT OUTER JOIN(오른쪽 주)
--       FULL OUTER JOIN(LEFT + RIGHT >> UNION)

SELECT * FROM m INNER JOIN s ON m.m1 = s.s1;

SELECT * FROM m LEFT JOIN s ON m.m1 = s.s1;

SELECT * FROM m RIGHT JOIN s ON m.m1 = s.s1;

SELECT * FROM m FULL OUTER JOIN s ON m.m1 = s.s1;

-- HR 계정으로 이동
SELECT e.employee_id, e.last_name, e.department_id, d.department_name
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id
ORDER BY e.employee_id ASC;

SELECT * FROM employees WHERE DEPARTMENT_ID IS NULL; -- GRANT

SELECT 
  e.employee_id, 
  e.last_name, 
  e.department_id, 
  d.department_name
FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id
ORDER BY e.employee_id;
----------------------------------------------------------------------
-- SELF JOIN(자기 참조) -> 문법 > 등가 JOIN
-- 하나의 테이블에서 특정 컬럼이 다른 컬럼을 참조하는 경우

SELECT * FROM emp;

SELECT 
  e1.empno, 
  e1.ename, 
  e2.ename AS Manager
FROM emp e1
LEFT JOIN emp e2 
       ON e1.mgr = e2.empno;
-----------------------------------------------------------------------       
-- 1. 사원들의 이름, 부서번호, 부서이름을 출력하라.
SELECT
  e.ename,
  e.deptno,
  d.dname
FROM emp e
INNER JOIN dept d
        ON e.deptno = d.deptno; 
      
-- 2. DALLAS에서 근무하는 사원의 이름, 직위, 부서번호, 부서이름을
-- 출력하라.
SELECT
  e.ename,
  e.job,
  e.deptno,
  d.dname
FROM emp e
INNER JOIN dept d
        ON e.deptno = d.deptno
WHERE d.loc = 'DALLAS';
 
-- 3. 이름에 'A'가 들어가는 사원들의 이름과 부서이름을 출력하라.
SELECT
  e.ename,
  d.dname
FROM emp e
INNER JOIN dept d
        ON e.ename LIKE '%A%' AND e.deptno = d.deptno;

-- 4. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을
--출력하는데 월급이 3000이상인 사원을 출력하라.
SELECT
  e.ename,
  d.dname,
  e.sal
FROM emp e
INNER JOIN dept d
        ON e.deptno = d.deptno
WHERE e.sal >= 3000;
 
-- 5. 직위(직종)가 'SALESMAN'인 사원들의 직위와 그 사원이름, 그리고
-- 그 사원이 속한 부서 이름을 출력하라.
SELECT
  e.job,
  e.ename,
  d.dname
FROM emp e
INNER JOIN dept d
        ON e.deptno = d.deptno
WHERE e.job = 'SALESMAN';
 
-- 6. 커미션이 책정된 사원들의 사원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '사원번호', '사원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하라.
--(비등가 ) 1 : 1 매핑 대는 컬럼이 없다
SELECT
  e.empno AS 사원번호,
  e.ename AS 사원이름,
  e.sal * 12 AS 연봉,
  e.sal * 12 + e.comm AS 실급여,
  s.grade AS 급여등급
FROM emp e
INNER JOIN salgrade s
        ON e.sal BETWEEN s.losal AND s.hisal
WHERE e.comm IS NOT NULL;

-- 7. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름,
-- 월급, 급여등급을 출력하라.
SELECT
  e.deptno,
  d.dname,
  e.ename,
  e.sal,
  s.grade
FROM emp e
INNER JOIN dept d
        ON e.deptno = d.deptno
INNER JOIN salgrade s
        ON e.sal BETWEEN s.losal AND s.hisal
WHERE e.deptno = 10;
 
-- 8. 부서번호가 10번, 20번인 사원들의 부서번호, 부서이름,
-- 사원이름, 월급, 급여등급을 출력하라. 그리고 그 출력된
-- 결과물을 부서번호가 낮은 순으로, 월급이 높은 순으로
-- 정렬하라.
SELECT
  e.deptno,
  d.dname,
  e.ename,
  e.sal,
  s.grade
FROM emp e
INNER JOIN dept d
        ON e.deptno = d.deptno
INNER JOIN salgrade s
        ON e.sal BETWEEN s.losal AND s.hisal
WHERE e.deptno IN (10, 20)
ORDER BY e.deptno, e.sal DESC;
 
-- 9. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의
-- 사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호',
-- '사원이름', '관리자번호', '관리자이름'으로 하여 출력하라.
--SELF JOIN (자기 자신테이블의 컬럼을 참조 하는 경우)
SELECT
  e1.empno AS 사원번호,
  e1.ename AS 사원이름,
  e1.mgr AS 관리자번호,
  e2.ename AS 관리자이름
FROM emp e1
LEFT JOIN emp e2
        ON e1.mgr = e2.empno;

----------------------------------------------------------------------------------------------------
-- [subquery] 오라클.pdf( 100 page)
-- sql의 꽃이다 >> sql 만능 해결사
--함수 >> 조인 >> subquery

-- 사원 테이블에서 사원들의 평균 월급보다 더 많은 급여를 받는 사원의 사번 이름 급여를 출력하세요

select *
from emp
where 2073<sal;

select *
from emp where sal > (select avg(sal) from emp); --subquery ....

--subquery
-- 1. single row subquery : subquery 의 결과가 1개의 row(단일값) : 한개의 값 (단일 컬럼)
-- 2. multi row subquery : subquery 의 결과가 1개 이상의 row (단일컬럼)
-- 구분하는 이유는 : 사용되는 연산자의 차이
-- multi row (IN , NOT IN) (ANY , ALL)
-- ALL : sal > 1000 and sal >2000 and ....
-- ANY : sal >1000 or sal >2000 or .......

--정의(subquery)
-- 1. 괄호 안에 있어야 한다. (select avg(sal) from emp)
-- 2. 단일 컬럼으로 구성되어야 한다. >> (select sal , deptno from emp) >> (X) 단일 컬럼이 아니다.
-- 3. 단독으로 실행 가능해야 한다.

-- 실행순서
-- 1. subquery 먼저 실행
-- 2. subquery 의 결과를 가지고 main query 실행

-- 사원테이블에서 jones의 급여보다 더 많은 급여를 받는 사원의 사번 , 이름, 급여를 출력하세요
SELECT sal FROM emp WHERE ename = 'JONES'; -- 2975

SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'JONES'); -- single row

-- 급여가 2000달러 이상인 ...
SELECT sal
FROM emp
WHERE sal > 2000; -- 결과 row 1개 이상

SELECT *
FROM emp 
-- WHERE sal = (SELECT sal FROM emp WHERE sal > 2000); (X)
WHERE sal IN (SELECT sal FROM emp WHERE sal > 2000); -- (O) multi-row
-- sal = 2001 OR sal = 3000 OR ...

SELECT *
FROM emp 
WHERE sal NOT IN (SELECT sal FROM emp WHERE sal > 2000);
-- sal != 2001 AND sal != 3000 AND ...

-- 부하 직원이 있는 사원의 사번과 이름을 출력하세요
-- = 내 사번이 mgr 컬럼에 있다
SELECT empno, ename
FROM emp
WHERE empno IN (SELECT mgr FROM emp);
-- empno = 7902 OR empno = 7698 OR empno is NULL

-- 부하 직원이 없는 사원의 사번과 이름을 출력하세요
SELECT empno, ename
FROM emp
WHERE empno NOT IN (SELECT nvl(mgr, 0) FROM emp);
-- empno != 7902 and empno != 7698 and empno != 7839 and empno is not null

-- KING에게 보고하는, 즉 직속 상관이 KING인 사원의 사번, 이름, 직종, 관리자 사번을 출력
SELECT empno, ename, job, mgr 
FROM emp 
WHERE mgr = (SELECT empno FROM emp WHERE ename = 'KING');

-- 20번 부서의 사원 중에서 가장 많은 급여를 받는 사원보다 더 많은 급여를 받는 사원의 사번, 이름, 급여
-- 부서 번호를 출력하세요
SELECT empno, ename, sal, deptno
FROM emp 
WHERE sal > (SELECT max(sal) FROM emp WHERE deptno = 20);

SELECT *
FROM emp 
WHERE deptno IN (SELECT deptno FROM emp WHERE job = 'SALESMAN')
AND sal IN (SELECT sal FROM emp WHERE job = 'SALESMAN');

-- Quiz)
-- 자기 부서의 평균 월급보다 더 많은 월급을 받는 사원의 사번, 이름, 부서번호, 부서별 평균 월급을 출력하세요
-- 1단계 : 부서번호와 부서의 평균 월급을 담고 있는 테이블이 존재한다면
SELECT e.empno, e.ename, e.deptno, s.avg
FROM emp e
INNER JOIN (SELECT deptno, avg(sal) AS avg FROM emp GROUP BY deptno) s
        ON e.deptno = s.deptno
WHERE e.sal > s.avg;



SELECT deptno, avg(sal)
FROM emp
GROUP BY deptno;

SELECT e.empno, e.ename, e.deptno, e.sal, s.avg
FROM emp e
INNER JOIN (SELECT deptno, avg(sal) AS avg FROM emp GROUP BY deptno) s
ON e.deptno = s.deptno
WHERE e.sal > s.avg;

--1. 'SMITH'보다 월급을 많이 받는 사원들의 이름과 월급을 출력하라.
SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SMITH');
 
--2. 10번 부서의 사원들과 같은 월급을 받는 사원들의 이름, 월급,
-- 부서번호를 출력하라.
SELECT ename, sal, deptno
FROM emp
WHERE sal IN (SELECT sal FROM emp WHERE deptno = 10);

 
--3. 'BLAKE'와 같은 부서에 있는 사원들의 이름과 고용일을 뽑는데
-- 'BLAKE'는 빼고 출력하라.
SELECT ename, hiredate
FROM emp 
WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'BLAKE')
AND ename != 'BLAKE';

--4. 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을
-- 출력하되, 월급이 높은 사람 순으로 출력하라.
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT avg(sal) FROM emp)
ORDER BY sal DESC;

--5. 이름에 'T'를 포함하고 있는 사원들과 같은 부서에서 근무하고
-- 있는 사원의 사원번호와 이름을 출력하라.
SELECT empno, ename
FROM emp
WHERE deptno IN (SELECT deptno FROM emp WHERE ename LIKE '%T%');

--6. 30번 부서에 있는 사원들 중에서 가장 많은 월급을 받는 사원보다
-- 많은 월급을 받는 사원들의 이름, 부서번호, 월급을 출력하라.
--(단, ALL(and) 또는 ANY(or) 연산자를 사용할 것)
SELECT ename, deptno, sal
FROM emp
WHERE sal > ALL (SELECT sal FROM emp WHERE deptno = 30);
 
 
--7. 'DALLAS'에서 근무하고 있는 사원과 같은 부서에서 일하는 사원의
-- 이름, 부서번호, 직업을 출력하라.
SELECT ename, deptno, job
FROM emp
WHERE deptno = ANY (SELECT deptno
                    FROM dept
                    WHERE loc = 'DALLAS'); 

--8. SALES 부서에서 일하는 사원들의 부서번호, 이름, 직업을 출력하라.
SELECT deptno, ename, job
FROM emp
WHERE deptno in (SELECT deptno
                 FROM dept
                 WHERE dname = 'SALES');

--9. 'KING'에게 보고하는 모든 사원의 이름과 급여를 출력하라
--king 이 사수인 사람 (mgr 데이터가 king 사번)
SELECT ename, sal
FROM emp
WHERE mgr = (SELECT empno FROM emp WHERE ename = 'KING');
 
--10. 자신의 급여가 평균 급여보다 많고, 이름에 'S'가 들어가는
-- 사원과 동일한 부서에서 근무하는 모든 사원의 사원번호, 이름,
-- 급여를 출력하라.
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL)
             FROM EMP)
AND DEPTNO IN(SELECT DEPTNO
              FROM EMP
              WHERE ENAME LIKE '%S%');
            
--11. 커미션을 받는 사원과 부서번호, 월급이 같은 사원의
-- 이름, 월급, 부서번호를 출력하라.            
SELECT ename, sal, deptno
FROM emp 
WHERE deptno in (SELECT deptno FROM emp WHERE comm IS NOT null)
AND sal in (SELECT sal FROM emp WHERE comm IS NOT null);

--12. 30번 부서 사원들과 월급과 커미션이 같지 않은
-- 사원들의 이름, 월급, 커미션을 출력하라.
SELECT sal ,comm FROM emp WHERE deptno = 30;
SELECT ename, sal, comm
FROM emp
WHERE sal NOT IN (SELECT nvl(sal, 0) FROM emp WHERE deptno = 30)
AND comm NOT IN (SELECT nvl(comm, 0) FROM emp WHERE deptno = 30);
---------------------------------------------------------------

-- INSERT UPDATE DELETE
/*
 * DDL(데이터 정의어) : create, alter, drop, truncate, rename, modify
 * DML(데이터 조작어) : insert, update, delete
 * DQL(데이터 질의어) : select
 * DCL(데이터 제어어) : grant, revoke
 * TCL(트랜잭션 처리) : commit, rollback, savepoint
 */

-- DML (트랜잭션 : 하나의 논리적인 작업 단위)
-- A은행에서 출금, B라는 은행 입금 (하나의 논리적인 단위)
-- A라는 계좌 : 100 출금 : UPDATE
-- ...
-- B라는 계좌 : 100 입금 : UPDATE
-- 둘다 성공 : commit
-- 둘중에 하나라도 실패 : rollback

-- 테이블 정보 보기
SELECT * FROM tab; -- 사용자(계정)가 만든 테이블 목록 출력

SELECT * FROM tab WHERE tname = 'BOARD'; -- 데이터가 있다는 것은 이미 BOARD 테이블이 존재

SELECT * FROM col;

SELECT * FROM col WHERE tname = 'EMP';

SELECT * FROM user_tables; -- 시스템 관리자

SELECT * FROM user_tables WHERE table_name = 'DEPT';
-----------------------------------------------------------------------------------------
-- DML (오라클.pdf p.168)
/*
 * insert into table_name [(column1[,column2,....])]
 * VALUES (value1[,value2,...]);
 */
CREATE TABLE temp(
  id NUMBER PRIMARY KEY, -- id 컬럼에는 null(X), 중복 데이터(X), 유일한 데이터 1건 보장, where id = 10
  name varchar2(20) -- default : null 허용
);

-- 1. 가장 일반적인 INSERT 
INSERT INTO temp (id, name)
VALUES (100, '홍길동');

SELECT * FROM temp;
-- 실반영
COMMIT;

-- 2. 컬럼 목록 생략 (되도록이면 생략하지 말 것)
INSERT INTO temp
VALUES (200, '김유신');
COMMIT;

-- 1. 문제 (id 컬럼에 PK 제약 정보)
INSERT INTO temp (id, name)
VALUES (100, '아무개'); -- unique constraint (BITUSER.SYS_C007006) violated

INSERT INTO temp (name) -- cannot insert NULL into ("BITUSER"."TEMP"."ID")
VALUES ('아무개');

---------------------------------------------------
-- 일반 SQL은 프로그램적인 요소 (X)
-- PL-SQL (변수, 제어문)

-- pl-sql
CREATE TABLE temp2 (id varchar2(20));

-- pl-sql 사용
/*
BEGIN 
  FOR i IN 1..1000 LOOP
    INSERT INTO temp2 (id) 
    VALUES ('A' || to_char(i));
  END LOOP;
END;
*/

SELECT * FROM temp2;

SELECT * FROM temp2 ORDER BY id DESC;
--------------------------------------------------------------
CREATE TABLE temp3( 
  memberid NUMBER(3) NOT NULL,
  name varchar2(10), -- null 허용
  regdate DATE DEFAULT sysdate); -- 기본값 설정하기 (regdate 값을 insert하지 않으면 자동으로 시스템 날짜)
 
INSERT INTO temp3(memberid, name, regdate)
VALUES (100, '홍길동', '2019-03-21');

SELECT * FROM temp3;
COMMIT;

INSERT INTO temp3(memberid, name)
VALUES (200, '아무개'); -- regdate date default sysdate
COMMIT;

INSERT INTO temp3(memberid)
VALUES (300); -- name null 기본적으로
COMMIT;

INSERT INTO temp3(name)
VALUES ('아무개'); -- cannot insert NULL (X) 

-- 1. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 
-- 입사년도(hire_date)별 평균 급여를 출력하시오.
-- 출력 시 년도를 기준으로 오름차순 정렬하시오.
SELECT to_char(hire_date, 'YYYY'), avg(salary)
FROM employees
WHERE job_id = (SELECT job_id FROM jobs WHERE job_title = 'Sales Manager')
GROUP BY to_char(hire_date, 'YYYY')
ORDER BY to_char(hire_date, 'YYYY');

--2. 각 도시(city)에 있는 모든 부서 직원들의 평균급여를 조회하고자 한다.
--   평균급여가 가장 낮은 도시부터 도시명(city)과 평균연봉, 해당 도시의 직원수를 출력하시오.
--   단, 도시에 근 무하는 직원이 10명 이상인 곳은 제외하고 조회하시오.
SELECT l.city, avg(e.salary), count(e.salary)
FROM employees e
INNER JOIN departments d
        ON e.department_id = d.department_id
        INNER JOIN locations l
                ON d.location_id = l.location_id
GROUP BY l.city
HAVING count(e.salary) < 10
ORDER BY avg(e.salary);
                   
--3. ‘Public  Accountant’의 직책(job_title)으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하시오.
--   (현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사원은 고려 하지 않는다.)
--   이름은 first_name, last_name을 아래의 실행결과와 같이 출력한다.
SELECT DISTINCT e.employee_id, e.first_name || ' ' || e.last_name AS name
FROM employees e
INNER JOIN job_history j ON e.employee_id = j.employee_id
WHERE (SELECT job_id FROM jobs WHERE job_title = 'Public Accountant') IN (SELECT job_id FROM job_history WHERE employee_id = e.employee_id);

-- 4. 자신의 매니저보다 연봉(salary)를 많이 받는 직원들의 성(last_name)과 연봉(salary)를 출 력하시오.
SELECT e1.last_name, e1.salary
FROM employees e1
LEFT JOIN employees e2
       ON e1.manager_id = e2.employee_id
WHERE e1.salary > e2.salary;

--5. 2007년에 입사(hire_date)한 직원들의 사번(employee_id), 이름(first_name), 성(last_name),
--   부서명(department_name)을 조회합니다.
--   이때, 부서에 배치되지 않은 직원의 경우, ‘<Not Assigned>’로 출력하시오.
SELECT e.employee_id, e.first_name, e.last_name, nvl(d.department_name, '<Not Assigned>')
FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id
WHERE TO_CHAR(e.hire_date, 'YYYY') = '2007';

--6. 업무명(job_title)이 ‘Sales Representative’인 직원 중에서 연봉(salary)이 9,000이상, 10,000 이하인
--   직원들의 이름(first_name), 성(last_name)과 연봉(salary)를 출력하시오
SELECT e.first_name, e.last_name, e.salary
FROM employees e
LEFT JOIN jobs j ON e.job_id = j.job_id
WHERE j.job_title = 'Sales Representative'
AND e.salary BETWEEN 9000 AND 10000;

--7. 부서별로 가장 적은 급여를 받고 있는 직원의 이름, 부서이름, 급여를 출력하시오.
--   이름은 last_name만 출력하며, 부서이름으로 오름차순 정렬하고,
--   부서가 같은 경우 이름을 기준 으로 오름차순 정렬하여 출력합니다.
SELECT * FROM EMPLOYEES ORDER BY LAST_NAME;
SELECT e.last_name, d.department_name
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id
INNER JOIN (SELECT department_id, min(salary) AS minsal FROM employees GROUP BY department_id) m ON d.DEPARTMENT_ID = m.department_id
WHERE e.salary = m.minsal
ORDER BY department_name, last_name;

-- 8. EMPLOYEES 테이블에서 급여를 많이 받는 순서대로 조회했을 때 결과처럼 6번째부터 10 번째까지
--   5명의 last_name, first_name, salary를 조회하는 sql문장을 작성하시오. -- RANK
SELECT e.last_name, e.first_name, e.salary, r.ranking
FROM employees e
INNER JOIN (SELECT employee_id, RANK() OVER (ORDER BY salary desc) AS ranking FROM employees) r ON e.employee_id = r.employee_id
WHERE ranking BETWEEN 6 AND 10;

--9. 사원의 부서가 속한 도시(city)가 ‘Seattle’인 사원의 이름, 해당 사원의 매니저 이름, 사원 의 부서이름을 출력하시오.
--   이때 사원의 매니저가 없을 경우 ‘<없음>’이라고 출력하시오. 이름은 last_name만 출력하며,
--   사원의 이름을 오름차순으로 정렬하시오.
SELECT e1.last_name, e2.last_name, d.department_name
FROM employees e1
INNER JOIN employees e2 ON e1.manager_id = e2.employee_id
INNER JOIN departments d ON e1.department_id = d.department_id
INNER JOIN locations l ON d.location_id = l.location_id
WHERE l.city = 'Seattle';

--10. 각 업무(job) 별로 연봉(salary)의 총합을 구하고자 한다. 연봉 총합이 가장 높은 업무부터
--    업무명(job_title)과 연봉 총합을 조회하시오. 단 연봉총합이 30,000보다 큰 업무만 출력하시오.
SELECT j.job_title, sum(e.salary)
FROM employees e
INNER JOIN jobs j ON e.job_id = j.job_id
GROUP BY j.job_title
HAVING sum(e.salary) > 30000
ORDER BY sum(e.salary) desc;


--11. 각 사원(employee)에 대해서 사번(employee_id), 이름(first_name), 업무명(job_title),
--    부서 명(department_name)을 조회하시오.
--    단 도시명(city)이 ‘Seattle’인 지역(location)의 부서 (department)에 근무하는 직원을 사원번호 오름차순으로 출력하시오.
SELECT employee_id, first_name, job_title, department_name
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id
INNER JOIN jobs j ON e.job_id = j.job_id
INNER JOIN locations l ON d.location_id = l.LOCATION_ID
ORDER BY
  CASE
    WHEN l.city = 'Seattle' THEN employee_id
  END ASC;


--12. 2001~20003년사이에 입사한 직원의 이름(first_name), 입사일(hire_date), 관리자사번 (employee_id),
--    관리자 이름(fist_name)을 조회합니다. 단, 관리자가 없는 사원정보도 출력 결과에 포함시켜 출력한다.
SELECT e1.first_name, e1.hire_date, e1.manager_id, e2.first_name
FROM employees e1
LEFT JOIN employees e2 ON e1.manager_id = e2.employee_id
WHERE e1.hire_date BETWEEN to_date('2001-01-01') AND to_date('2003-12-31');


--13. ‘Sales’ 부서에 속한 직원의 이름(first_name), 급여(salary), 부서이름(department_name)을 조회하시오.
--    단, 급여는 100번 부서의 평균보다 적게 받는 직원 정보만 출력되어야 한다.
SELECT first_name, salary, department_name
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id
WHERE salary < (SELECT avg(salary) FROM employees WHERE department_id = 100);


--14. Employees 테이블에서 입사한달(hire_date)별로 인원수를 조회하시오.
SELECT to_char(hire_date, 'MM'), count(*)
FROM employees
GROUP BY to_char(hire_date, 'MM')
ORDER BY to_char(hire_date, 'MM');

--15. 부서별 직원들의 최대, 최소, 평균급여를 조회하되,
--    평균급여가 ‘IT’ 부서의 평균급여보다 많고, ‘Sales’ 부서의 평균보다 적은 부서 정보만 출력하시오.
SELECT max(salary), min(salary), avg(salary)
FROM employees
GROUP BY department_id
HAVING avg(salary) > (SELECT avg(salary) FROM employees WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'IT'))
AND avg(salary) < (SELECT avg(salary) FROM employees WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'Sales'));


--16. 각 부서별로 직원이 한명만 있는 부서만 조회하시오.
--    단, 직원이 없는 부서에 대해서는 ‘<신생부서>‘라는 문자열이 출력되도록 하고,
--    출력결과는 다음과 같이 부서명이 내림차순 으로 정렬되어야한다.
SELECT
  CASE p.np
    WHEN 1 THEN p.department_name 
    WHEN 0 THEN '<신생부서>'
  END AS 부서명
FROM (SELECT d.department_id, d.department_name, nvl(c.people, 0) AS np
      FROM departments d
      LEFT JOIN (SELECT department_id, count(*) AS people FROM employees GROUP BY department_id) c ON d.department_id = c.department_id) p
WHERE p.np IN (0, 1)
ORDER BY 부서명 desc;

-- 17. 부서별 입사월별 직원수를 출력하시오.
--    단, 직원수가 5명 이상인 부서만 출력되어야 하며 출력결과는 부서이름 순으로 한다.
SELECT d.department_name, to_char(hire_date, 'MM'), count(*)
FROM employees e
INNER JOIN (SELECT department_id
            FROM employees e
            GROUP BY department_id
            HAVING count(*) >= 5) i 
        ON e.department_id = i.department_id
INNER JOIN departments d ON e.department_id = d.department_id        
GROUP BY d.department_name, to_char(hire_date, 'MM')
ORDER BY d.department_name;

--18. 국가(country_name) 별 도시(city)별 직원수를 조회하시오.
--    단, 부서에 속해있지 않은 직원 이 있기 때문에 106명의 직원만 출력이 된다.
--    부서정보가 없는 직원은 국가명과 도시명 대신에 ‘<부서없음>‘이 출력되도록 하여 107명 모두 출력되게 한다.
SELECT nvl(country_name, '<부서없음>') AS 국가, nvl(city, '<부서없음>') AS 도시, count(*) AS 직원수
FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id
LEFT JOIN locations l ON d.location_id = l.location_id
LEFT JOIN countries c ON l.country_id = c.country_id
GROUP BY country_name, city;

--19. 각 부서별 최대 급여자의 아이디(employee_id), 이름(first_name), 급여(salary)를 출력하시오.
--    단, 최대 급여자가 속한 부서의 평균급여를 마지막으로 출력하여 평균급여와 비교할 수 있게 할 것. 
SELECT employee_id, first_name, salary, s.salavg
FROM employees e
INNER JOIN (SELECT department_id, max(salary) AS salmax, avg(salary) AS salavg
            FROM employees
            GROUP BY department_id) s
            ON e.salary = s.salmax AND e.department_id = s.department_id;

--20. 커미션(commission_pct)별 직원수를 조회하시오.
--    커미션은 아래실행결과처럼 0.2, 0.25는 모두 .2로, 0.3, 0.35는 .3 형태로 출력되어야 한다.
--    단, 커미션 정보가 없는 직원들도 있는 데 커미션이 없는 직원 그룹은 ‘<커미션 없음>’이 출력되게 한다.
SELECT nvl(to_char(trunc(commission_pct, 1)), '<커미션 없음>'), count(*)
FROM employees
GROUP BY commission_pct;

--21. 커미션(commission_pct)을 가장 많이 받은 상위 4명의 부서명(department_name),
--    직원명 (first_name), 급여(salary), 커미션(commission_pct) 정보를 조회하시오.
--    출력결과는 커미션 을 많이 받는 순서로 출력하되 동일한 커미션에 대해서는 급여가 높은 직원이 먼저 출력 되게 한다.
SELECT *
FROM employees
WHERE commission_pct IS NOT NULL
ORDER BY commission_pct DESC;


---------------------------------------------------------------------------------------------------------------------
-- insert(tip)
-- 1. 대량 데이터 insert 하기
CREATE TABLE temp4 (id number);
CREATE TABLE temp5 (num number);
INSERT INTO temp4(id) VALUES (1);
INSERT INTO temp4(id) VALUES (2);
INSERT INTO temp4(id) VALUES (3);
INSERT INTO temp4(id) VALUES (4);
INSERT INTO temp4(id) VALUES (5);
INSERT INTO temp4(id) VALUES (6);
INSERT INTO temp4(id) VALUES (7);
INSERT INTO temp4(id) VALUES (8);
INSERT INTO temp4(id) VALUES (9);
INSERT INTO temp4(id) VALUES (10);
COMMIT;
SELECT * FROM temp4;

-- 요구사항 : temp4에 있는 모든 데이터를 temp5에 넣고 싶어요
-- insert into 테이블명(컬럼 리스트) values(값 리스트)
-- insert into 테이블명(컬럼 리스트) select 구문 (단, 컬럼의 개수와 타입이 동일)

INSERT INTO temp5(num) 
SELECT id FROM temp4; -- VALUES 대신에 select문

SELECT * FROM temp5;
COMMIT;

-- 2. insert
-- 테이블이 없는 상황에서 테이블을 생성 + 대량 데이터 삽입
-- 단, 제약 정보는 복사 불가능 (PK, FK 등)
-- 순수한 구조정보(컬럼 이름, 타입)만 복사

-- CREATE TABLE 테이블명(컬럼명 타입 정보)
CREATE TABLE copyemp -- 구조(schema) + 데이터 insert
AS SELECT * FROM emp;

SELECT * FROM copyemp;

CREATE TABLE copyemp2
AS SELECT empno, ename, sal
FROM emp
WHERE deptno = 30;

SELECT * FROM copyemp2;

-- 질문) 구조(틀)만 복사하고 데이터는 복사하고 싶지 않아요
CREATE TABLE copyemp3
AS SELECT * 
FROM emp WHERE 1 = 2;

SELECT * FROM col WHERE tname = 'COPYEMP3';

-- tip
-- 오라클 시스템 테이블 (다양한 정보)
-- 제약 정보 (PK, FK..)
SELECT * FROM user_constraints WHERE table_name = 'EMP';
SELECT * FROM user_constraints WHERE table_name = 'COPYEMP';

CREATE TABLE pktest(id NUMBER PRIMARY KEY); -- not null, unique

SELECT * FROM user_constraints WHERE table_name = 'PKTEST'; -- constraint_type = P
INSERT INTO pktest(id)
VALUES (100);
-- 제약정보는 복사되지 않아요 검증
CREATE TABLE pktest2
AS SELECT * FROM pktest;

-- PK 제약정보는 복사되지 않았다
SELECT * FROM user_constraints WHERE table_name = 'PKTEST2';

----------------------------------------------[INSERT END]------------------------------
-- [UPDATE]
/*
 * update table_name
 * set column1 = value, column2 = value2
 * where 조건
 * 
 * update table_name
 * set column1 = (subquery)
 * where 조건
 */

SELECT * FROM copyemp;

UPDATE copyemp
SET sal = 0
WHERE deptno = 20;

SELECT * FROM copyemp WHERE deptno = 20;
COMMIT;

-- update (set 구문에 subquery 사용)
UPDATE copyemp
SET sal = (SELECT sum(sal) FROM emp);

-- 여러 개 컬럼 update
UPDATE copyemp
SET ename = 'AAA', job = 'BBB', hiredate = sysdate, sal = (SELECT sum(sal) FROM emp)
WHERE deptno = 10;

SELECT * 
FROM copyemp 
WHERE deptno = 30;
COMMIT;
-----------------------------[UPDATE END]-----------------------------------
-- [DELETE]
-- 원칙 : DELETE -> COMMIT : 복원 불가
-- 백업 데이터가 있다면 복원 가능

DELETE FROM copyemp;

SELECT * FROM copyemp;

ROLLBACK;

DELETE FROM copyemp
WHERE deptno IN (10, 20);
ROLLBACK;
----------------------------[DELETE END]-----------------------------------
/*
 * APP(Java) -> JDBC API -> DB 작업(Oracle) 
 * 
 * CRUD
 * 
 * create : insert
 * read : select (전체, 조건 조회)
 * update : update
 * delete : delete
 * 
 * (DML : INSERT, UPDATE, DELETE) >> 트랜잭션 : commit, rollback 강제
 * 
 * JDBC -> Oracle
 * 전체 조회(함수), 조건 조회(함수), 삭제(함수), 수정(함수), 삽입(함수) => 개발자가 할 일
 * 
 * -- public List<Emp> getEmpAllList() { select * from emp... }
 * -- public Emp getEmpListByEmpno(int empno) { select * from emp where empno = empno }
 * -- public int insertEmp(Emp emp) { insert into emp values(emp.get(), ....) } 
 * */ 
--------------------------------------------------------------------------------------------
-- [DDL]
-- CREATE, ALTER, DROP (테이블 기준)

SELECT * FROM user_tables WHERE lower(table_name) = 'board';

DROP TABLE board;

CREATE TABLE board(
  boardid NUMBER,
  title varchar2(50),
  content varchar2(4000),
  regdate DATE
);

--------------------------------
-- 개발자 편하게 살기
SELECT * FROM user_tables WHERE lower(table_name) = 'board';
SELECT * FROM user_constraints WHERE lower(table_name) = 'board';
----------------------------------
-- Oracle 11g 가상컬럼(조합컬럼)
-- 학생성적 테이블 : 국어, 영어, 수학, 총점 컬럼
-- 국어, 영어, 수학 데이터만 insert하면 자동으로 총점이 구해졌으면

CREATE TABLE vtable(
  no1 NUMBER,
  no2 NUMBER,
  no3 NUMBER GENERATED ALWAYS AS (no1 + no2) VIRTUAL 
);

INSERT INTO vtable(no1, no2)
VALUES (100, 50);

SELECT * FROM vtable;

INSERT INTO vtable(no1, no2)
VALUES (80, 60);

-- INSERT INTO vtable(no1, no2, no3)
-- VALUES (80, 60, 10); 가상 컬럼에 데이터 삽입 불가능

-- 컬럼의 정보 보기 (default value값 확인하기)
SELECT column_name, data_type, data_default
FROM user_tab_columns 
WHERE table_name = 'VTABLE';

-- 실무에서 활용하는 코드
-- 제품 정보 (입고일 기준 분기별 데이터 : 4분기)
-- 입고일 : 2019-03-01 >> 1분기

CREATE TABLE vtable2(
  no NUMBER, -- 순번
  p_code char(4), -- 제품코드(A001, B002)
  p_date char(8), -- 입고일(20190303)
  p_qty NUMBER, -- 수량
  p_bungi NUMBER(1) GENERATED ALWAYS AS (CASE 
                                           WHEN substr(p_date, 5, 2) IN ('01', '02', '03') THEN 1
                                           WHEN substr(p_date, 5, 2) IN ('04', '05', '06') THEN 2
                                           WHEN substr(p_date, 5, 2) IN ('07', '08', '09') THEN 3
                                           ELSE 4
                                         END) VIRTUAL);

SELECT column_name, data_type, data_default
FROM user_tab_columns WHERE table_name = 'VTABLE2';

INSERT INTO vtable2(p_date)
VALUES ('20180101');
INSERT INTO vtable2(p_date)
VALUES ('20180126');
INSERT INTO vtable2(p_date)
VALUES ('20190301');
INSERT INTO vtable2(p_date)
VALUES ('20190701');
INSERT INTO vtable2(p_date)
VALUES ('20191225');
COMMIT;

SELECT * FROM vtable2;
SELECT * FROM vtable2 WHERE p_bungi = 1;

---------------------------------------------------------------------------
-- DDL 테이블 다루기 (pdf 9장)

-- 1. 테이블 생성하기
CREATE TABLE temp6(id number);

-- 2. 테이블 생성했는데 컬럼 추가하기
-- 기존 테이블에 컬럼 추가하기
ALTER TABLE temp6
ADD (ename varchar2(20));

-- 3. 기존 테이블에 있는 컬럼의 이름을 잘못 표기
-- 기존 테이블에 있는 기존 컬럼의 이름 바꾸기
ALTER TABLE temp6
RENAME COLUMN ename TO username;

SELECT * FROM temp6;

-- 기존 테이블에 있는 기존 컬럼의 타입 정보 수정하기
-- (modify)
ALTER TABLE temp6
MODIFY (username varchar2(2000));

-- 5. 기존 테이블에 있는 기존 컬럼 삭제
ALTER TABLE temp6
DROP COLUMN username;

-- 6. 테이블 삭제
-- 6.1 데이터만 삭제 : delete
-- 테이블 처음 만들면 처음 크기 >> 데이터를 넣으면 크기 증가
-- ex) 처음 1M >> 10만건 >> 100M >> delete 10만건 삭제 >> 여전히 테이블의 크기는 100M

-- 테이블 데이터 삭제하면서 공간의 크기를 줄일 수 있을까
-- truncate (where 절을 사용 못함)
-- ex) 처음 1M >> 10만건 >> 100M >> truncate 10만건 삭제 >> 테이블의 크기는 1M

-- 7. 테이블 삭제 : DROP

DROP TABLE temp6;

-------------------------------------------------------------------------------------
--테이블 제약 설정하기
--오라클.pdf( 144 Page)
--데이터 무결성 확보
--제약 (constraint) : insert , update  주로 적용
/*
 * NOT NULL(NN) : 열은 NULL 값을 포함할 수 없습니다.
 
 * UNIQUE key(UK) 테이블의 모든 행을 [유일하게 하는 값]을 가진 열(NULL 을 허용) 
   - unique 제약은 null 값을 가질 수 있다 >> null 값을 못가지게 할려면 not null 포함
 
 * PRIMARY KEY(PK) 유일하게 테이블의 각행을 식별(NOT NULL 과 UNIQUE 조건을 만족) 
   - not null 하고 unique 한 제약 (내부적으로 index 가 자동 설정)
   
 * FOREIGN KEY(FK) 열과 참조된 열 사이의 외래키 관계를 적용하고 설정합니다.
   - (참조제약)  [테이블]과 [테이블]간의 관계 설정
    
 * CHECK(CK) 참이어야 하는 조건을 지정함(대부분 업무 규칙을 설정) 
   - 설정한 범위 내의 값만 입력받겠다  (gender : 컬럼에 '남' 또는 '여' 하는 데이터만)
   - ex) where gender in ('남','여')

   제약을 만드는 시점
     1. 테이블 만들면서 바로 생성   (create table ....)
     2. 테이블 생성 이후  (alter table ...  add constraint....)  >> 자동 생성 툴 (exerd)
 */

-- 1. 
SELECT *
FROM user_constraints
WHERE table_name = 'EMP'; -- 오라클 not null도 제약으로 판단
-------------------------------------------------------------------------------
CREATE TABLE temp7(
  --id NUMBER PRIMARY KEY); -- 권장하지 않음 (줄임 표현) -- SYS_C007012 제약 이름 (나중에 제약 수정, 삭제)
  id NUMBER CONSTRAINT pk_temp7_id PRIMARY KEY, -- 관용적 표현 : pk_테이블명_컬럼명
  name varchar2(20) NOT NULL,
  addr varchar2(50));

SELECT *
FROM user_constraints
WHERE table_name = 'TEMP7';

INSERT INTO temp7 (name, addr)
VALUES ('홍길동', '서울시 강남구'); -- (X)

INSERT INTO temp7(id, name, addr)
VALUES (10, '홍길동', '서울시 강남구');

INSERT INTO temp7(id, name, addr)
VALUES (10, '김유신', '서울시 강북구'); -- (X)
COMMIT;

-- 1. primary key는 테이블에 몇 개까지 걸 수 있을까? 1개....
-- 여러 개의 컬럼을 묶어서 한 개는 가능 (ename, age) => 복합 키

CREATE TABLE temp8(
  id NUMBER CONSTRAINT pk_temp8_id PRIMARY KEY,
  name varchar2(20) NOT NULL,
  jumin char(6) CONSTRAINT uk_temp8_jumin UNIQUE, -- 중복값(X) >> null 허용 >> not null constraint....로 null 금지
  addr varchar2(20));

SELECT *
FROM user_constraints
WHERE table_name = 'TEMP8';

INSERT INTO temp8(id, name, jumin, addr)
VALUES (10, '홍길동', '123456', '경기도');

COMMIT;

INSERT INTO temp8(id, name, jumin, addr)
VALUES (20, '김유신', '123456', '경기도'); -- (X)

-- null 값 허용할까
INSERT INTO temp8(id, name, addr)
VALUES (20, '김유신', '경기도'); -- null 데이터 허용 (null끼리 중복체크는?)

SELECT *
FROM temp8;

INSERT INTO temp8(id, name, addr)
VALUES (30, '아무개', '강원도'); -- null끼리는 중복 체크가 안된다 (null은 여러 개 가능) >> not null + unique

----------------------------------------------------------------------------
-- 테이블 생성 후에 제약 걸기

CREATE TABLE temp9(id number);

-- 기존 테이블에 제약 추가하기
-- 주의) 기존 데이터가 제약을 위반한다면 제약은 추가되지 않음 >> 중복된 데이터가 있다면 삭제 후 제약
-- 제약 걸기 전에 데이터 검사 작업 수행

ALTER TABLE temp9
ADD CONSTRAINT pk_temp9_id PRIMARY key(id);
-- add constraint pk_temp9_id primary key(id, name, addr)
-- 3개 컬럼이 모두 중복이 아니면 됨

SELECT *
FROM user_constraints
WHERE table_name = 'TEMP9';

ALTER TABLE temp9
ADD (ename varchar2(20));

SELECT * FROM temp9;

-- not null 제약 추가하기
ALTER TABLE temp9
MODIFY (ename NOT NULL);
---------------------------------------------------
-- CHECK 제약
-- WHERE 조건과 동일한 형태의 제약 ex) where gender in ('남', '여')

CREATE TABLE temp10(
 id NUMBER CONSTRAINT pk_temp10_id PRIMARY KEY,
 name varchar2(20) NOT NULL,
 jumin char(6) CONSTRAINT uk_temp10_jumin UNIQUE,
 addr varchar2(20),
 age NUMBER CONSTRAINT ck_temp10_age CHECK (age >= 19)); -- where age >= 19

SELECT *
FROM user_constraints
WHERE table_name = 'TEMP10';

INSERT INTO temp10(id, name, jumin, addr, age)
VALUES (100, '홍길동', '123456', '서울시', 25);

INSERT INTO temp10(id, name, jumin, addr, age)
VALUES (200, '김유신', '123456', '부산시', 18); -- check constraint violated

COMMIT;

-----------------------------------------------------------------------
-- 참조 제약 : 테이블과 테이블과의 제약
-- EMP (DEPTNO) 컬럼은 DEPT (DEPTNO) 컬럼을 참조한다

CREATE TABLE c_emp
AS SELECT empno, ename, deptno FROM emp WHERE 1=2;

CREATE TABLE c_dept
AS SELECT deptno, dname FROM dept WHERE 1=2;

SELECT * FROM c_emp;
SELECT * FROM c_dept;

-- 1. 참조 제약 (c_emp 테이블에 있는 deptno 컬럼에 insert되는 데이터는 c_dept의 deptno가 가지는 데이터 중에 하나가 되도록)

ALTER TABLE c_emp
ADD CONSTRAINT fk_emp_deptno FOREIGN KEY(deptno) REFERENCES c_dept(deptno);
-- ERROR 발생
-- c_dept >> deptno에서 데이터를 빌려쓸거야...
-- deptno 가지는 데이터는 중복 데이터 없고 null 값 없다 >> primary key

-- c_dept >> deptno >> primary key 선행

-- 1)
ALTER TABLE c_dept
ADD CONSTRAINT pk_dept_deptno PRIMARY KEY(deptno);

-- 2)
ALTER TABLE c_emp
ADD CONSTRAINT fk_emp_deptno FOREIGN KEY(deptno) REFERENCES c_dept(deptno);

INSERT INTO c_dept(deptno, dname)
VALUES (100, '인사팀');
INSERT INTO c_dept(deptno, dname)
VALUES (200, '관리팀');
INSERT INTO c_dept(deptno, dname)
VALUES (300, '회계팀');
COMMIT;

SELECT * FROM c_dept;

-- 신입사원 입사
INSERT INTO c_emp(empno, ename)
VALUES (100, '홍길동'); -- FK는 not null 하지 않아(null 허용)
-- 신입사원은 부서를 갖지 않을 수 있다

-- 규칙 신입사원은 무조건 부서를 가져야 한다 (deptno not null constraint ... FK ...)
----------------------
INSERT INTO c_emp(empno, ename, deptno)
VALUES (200, '아무개', 500); -- (X)

INSERT INTO c_emp(empno, ename, deptno)
VALUES (200, '아무개', 300);


----------------------------
-- 테이블 (부모, 자식 테이블)
-- 테이블 (mmster, detail)
-- 두 개 테이블 deptno 관계에서 부모 : c_dept(PK), master
--                              자식 : c_emp
                                
-- c_emp 테이블
-- d.dept 테이블

-- 주의점
SELECT * FROM c_emp;
SELECT * FROM c_dept;

-- 이때 : c_dept 테이블에서 300 데이터 삭제 불가능
DELETE FROM c_dept
WHERE deptno = 300;
DELETE FROM c_dept
WHERE deptno = 100; -- 빌려쓰이지 않는 데이터는 삭제 가능

COMMIT;

/*
column datatype [CONSTRAINT constraint_name]
 REFERENCES table_ name (column1[,column2,..] [ON DELETE CASCADE])
column datatype,
. . . . . . . ,
[CONSTRAINT constraint_name] FOREIGN KEY (column1[,column2,..])
 REFERENCES table_name (column1[,column2,..] [ON DELETE CASCADE])
*/
-- [ON DELETE CASCADE] 부모테이블과 생명을 같이 하겠다
-- 300 삭제하겠나요? 네
-- delete from c_dept where deptno = 300;
-- 참조하는 자식 데이터 같이 삭제
-- delete from c_emp where deptno = 300; 같이 실행

ALTER TABLE c_emp
ADD CONSTRAINT fk_emp_deptno FOREIGN KEY(deptno) REFERENCES c_dept(deptno) ON DELETE CASCADE;

--학생 성적 테이블 (Table student_grade)
--학번의 데이터는 중복되거나 NULL 값을 허용하면 안된다 (id primary)
--이름 NULL 값을 허용하지 않는다 (name not null)
--국어 (korean)
--영어 (english)
--수학 점수 컬럼은 숫자 타입이고 NULL 값을 허용 (math, number)
--는 값을 입력하지 않으면  default로 0값을 갖는다 (default 0)
--총점 ,평균 컬럼은 가상컬럼으로(조합컬럼) 생성한다 (virtual)
--학과코드는 학과 테이블에 학과코드를 참조한다 (dept_id foreign key)
--학번 , 이름 , 국어 , 영어 , 수학 , 총점 , 평균 , 학과코드 (id, name, korean, english, math, total, average, dept_id)

--학과 테이블 table(department)
--학과코드 데이터는 중복되거나 NULL 값을 허용하면 안된다, (dept_id primary)
--학과명 은 null값을 허락하지 않는다 (dept_name not null)

--학과코드 , 학과명

--그리고 select 결과는
--학번 , 이름  총점, 평균 , 학과코드 , 학과명 을 출력하세요 (id, name, total, average, dept_id, dept_name)

CREATE TABLE student_grade(
  id NUMBER,
  name varchar(20) NOT NULL,
  korean NUMBER DEFAULT 0,
  english NUMBER DEFAULT 0,
  math NUMBER DEFAULT 0,
  total NUMBER GENERATED ALWAYS AS (korean + english + math) VIRTUAL,
  average NUMBER GENERATED ALWAYS AS ((korean + english + math) / 3) VIRTUAL
  dept_id NUMBER);

CREATE TABLE department(
  dept_id NUMBER, 
  dept_name varchar(50) NOT NULL);

ALTER TABLE student_grade
ADD CONSTRAINT pk_student_grade_id PRIMARY KEY(id);

ALTER TABLE student_grade
ADD dept_id NUMBER;

ALTER TABLE department
ADD CONSTRAINT pk_deparment_dept_id PRIMARY KEY(dept_id);

ALTER TABLE student_grade
ADD CONSTRAINT fk_student_grade_dept_id FOREIGN KEY(dept_id) REFERENCES department(dept_id);

INSERT INTO student_grade (id, name, korean, english, math, dept_id)
VALUES (1001, '홍길동', 50, 70, 90, 400);
INSERT INTO student_grade (id, name, korean, math, dept_id)
VALUES (1002, '홍길동', 50, 90, 400);
INSERT INTO student_grade (id, name, math, dept_id)
VALUES (1003, '김유신', 90, 100);
COMMIT;

INSERT INTO department
VALUES (100, '경영학과');
INSERT INTO department
VALUES (200, '경제학과');
INSERT INTO department
VALUES (300, '사회학과');
INSERT INTO department
VALUES (400, '컴퓨터과학과');
INSERT INTO department
VALUES (500, '심리학과');
COMMIT;

SELECT s.id, s.name, s.total, s.average, s.dept_id, d.dept_name
FROM student_grade s
INNER JOIN department d ON s.dept_id = d.dept_id;

SELECT * FROM student_grade;
SELECT * FROM deparment;

SELECT * 
FROM user_constraints 
WHERE TABLE_name IN ('STUDENT_GRADE', 'DEPARTMENT');

-------------------------------------------------------------
-- 1.
CREATE TABLE emp(
  emp_no NUMBER(8) CONSTRAINT pk_emp_empno PRIMARY KEY,
  emp_name varchar2(10) NOT NULL,
  emp_hdate DATE DEFAULT sysdate,
  emp_mgr_no NUMBER(8),
  CONSTRAINTS fk_emp_mgr FOREIGN KEY (emp_mgr_no) REFERENCES emp(emp_no)
);

-- 2.
SELECT department_id, sum(salary), avg(salary)
FROM employees
GROUP BY department_id
HAVING avg(salary) > 8000;

-- 3.
CREATE TABLE s_emp(
  name varchar2(20),
  age NUMBER,
  s_level NUMBER,
  dept_id NUMBER
);

CREATE TABLE s_dept(
  dept_id NUMBER,
  dept_name varchar2(20),
  num NUMBER 
);

INSERT INTO s_dept
VALUES (10, '기획팀', 4);
INSERT INTO s_dept
VALUES (20, '영업팀', 6);
INSERT INTO s_dept
VALUES (30, '개발팀', 30);
INSERT INTO s_dept
VALUES (40, '경영지원팀', 5);
INSERT INTO s_dept
VALUES (50, '디자인팀', 7);
COMMIT;

INSERT INTO s_emp
VALUES ('홍길동', 27, 4, 20);
INSERT INTO s_emp
VALUES ('강감찬', 40, 7, 30);
INSERT INTO s_emp
VALUES ('이순신', 52, 7, 40);
INSERT INTO s_emp
VALUES ('계백', 32, 6, 10);
INSERT INTO s_emp
VALUES ('이성계', 57, 8, 50);

SELECT name, e.dept_id, dept_name
FROM s_emp e
INNER JOIN s_dept d ON e.dept_id = d.dept_id
ORDER BY age desc;

-- 4.
SELECT city, department_name, e.job_id, count(*) AS people, sum(salary) AS total_salary
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id
INNER JOIN locations l ON d.location_id = l.location_id
GROUP BY city, department_name, e.job_id
ORDER BY city, department_name, job_id;

-- VIEW 객체 (가상 테이블)
-- 오라클.pdf p.192

-- view 객체(create, drop)
-- create view 뷰이름 as [select 구문] (view를 통해서 볼 수 있는 데이터 목록)
-- View는 테이블처럼 사용 가능 (가상 테이블) -> emp, dept같은 논리로 접근 사용
-- View는 메모리 상에만 존재하는 가상 테이블 (subquery -> in line view -> from (select deptno, avg(sal)... )

-- View : 가상 테이블 >> 사용법은 테이블 사용법과 동일
-- DML(insert, update, delete) -> View를 통해서 DML 가능 -> View가 가지고 있는(볼 수 있는) 실제 테이블의 데이터 변경

-- View는 별도의 권한이 필요하다
CREATE VIEW v_001
AS SELECT empno, ename
   FROM emp; -- insufficient privileges

GRANT CREATE VIEW TO "BITUSER";
-- view 사용 목적
-- 1. 개발자의 편리성 (join, subquery)
-- 2. 편리성 (쿼리 단순화) -> 복잡한 쿼리 미리 만들어 두고 사용
-- 3. 보안 (권한 처리) -> 노출하고 싶은 데이터만 모아서 view 생성 -> view 권한 부여

-- 보안 (특정 사용자에게)
CREATE VIEW v_emp
AS SELECT empno, ename, job, hiredate
   FROM emp;

SELECT *
FROM v_emp;

SELECT empno, ename
FROM v_emp;

SELECT *
FROM v_emp
WHERE empno = 7788;

-- 편리성(쿼리 단순화)
CREATE VIEW v_002
AS SELECT e.empno, e.ename, d.deptno, d.dname
   FROM emp e
   INNER JOIN dept d 
   ON e.deptno = d.deptno;
 
SELECT *
FROM v_002;

SELECT *
FROM v_002
WHERE deptno = 30;

-- View는 가상 테이블 : 컬럼명이 반드시 필요
CREATE VIEW v_003
AS SELECT deptno, avg(sal) AS avgsal
   FROM emp
   GROUP BY deptno;

SELECT *
FROM emp e JOIN v_003 s
ON e.deptno = s.deptno
WHERE e.sal > s.avgsal;

-- 테이블 1개 이상 >> JOIN >> subquery >> VIEW

-- CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW view_name [(alias[,alias,...])]
-- AS Subquery
-- [WITH CHECK OPTION [CONSTRAINT constraint ]]
-- [WITH READ ONLY]

-- OR REPLACE 이미 존재한다면 다시 생성한다.
-- FORCE Base Table 유무에 관계없이 VIEW 을 만든다.
-- NOFORCE 기본 테이블이 존재할 경우에만 VIEW 를 생성한다.
-- view_name VIEW 의 이름
-- Alias Subquery 를 통해 선택된 값에 대한 Column 명이 된다.
-- Subquery SELECT 문장을 기술한다.
-- WITH CHECK OPTION VIEW 에 의해 액세스 될 수 있는 행만이 입력,갱신될 수 있다.
-- Constraint CHECK OPTON 제약 조건에 대해 지정된 이름이다.
-- WITH READ ONLY 이 VIEW 에서 DML 이 수행될 수 없게 한다.

DROP VIEW v_007;

CREATE OR REPLACE VIEW v_007
AS SELECT avg(sal) AS avgsal
   FROM emp; -- 함수 적용
 
SELECT *
FROM v_007;

CREATE OR REPLACE VIEW v_007
AS SELECT round(avg(sal)) AS avgsal
   FROM emp;

-- VIEW를 통한 DML 작업 (insert, update, delete)
-- 단, VIEW는 테이블이 아니기 때문에 VIEW를 통해서 볼 수 있는 데이터에 대해서만 작업 가능
-- 복합 VIEW : 하나 이상의 테이블로 구성 -> DML 불가(하지 마)
-- 단순 VIEW : 테이블 하나로 만든 뷰

SELECT * -- view를 통해서 볼 수 있는 데이터, empno, ename, job, hiredate
FROM v_emp;

UPDATE v_emp
SET sal = 0; -- (X) v_emp로 sal을 볼 수 없음

UPDATE v_emp -- 원본 테이블 가서 데이터를 update -- 결국 emp 테이블의 데이터 변경
SET job = 'IT';

ROLLBACK;

SELECT *
FROM emp;

CREATE OR REPLACE VIEW v_emp2
AS SELECT *
   FROM emp
   WHERE deptno = 20;
   
-- 1.
UPDATE v_emp2 -- 자기가 볼 수 있는 데이터만
SET sal = 0;

SELECT * FROM emp WHERE deptno = 20; -- VIEW를 통해서 볼 수 있는 테이블의 데이터만

SELECT *
FROM user_views; -- VIEW 목록 보기
------------------------------------------------------------------------------------

--1. 30번 부서 사원들의 직위, 이름, 월급을 담는 VIEW를 만들어라.

CREATE OR REPLACE VIEW emp_30
AS SELECT job, ename, sal
   FROM emp
   WHERE deptno = 30;

SELECT * FROM emp_30;

--2. 30번 부서 사원들의  직위, 이름, 월급을 담는 VIEW를 만드는데,

-- 각각의 컬럼명을 직위, 사원이름, 월급으로 ALIAS를 주고 월급이

-- 300보다 많은 사원들만 추출하도록 하라.

-- create or replace view view001 (컬럼명, 컬럼명, .....)

CREATE OR REPLACE VIEW emp_30_300 (직위, 이름, 월급)
AS SELECT job, ename, sal
   FROM emp
   WHERE deptno = 30 AND sal > 300;

SELECT * FROM emp_30_300;
--3. 부서별 최대월급, 최소월급, 평균월급을 담는 VIEW를 만들어라.
CREATE VIEW v_sal
AS SELECT deptno, max(sal) AS 최대월급, min(sal) AS 최소월급, avg(sal) AS 평균월급
   FROM emp
   GROUP BY deptno;

SELECT *
FROM v_sal;


--4. 부서별 평균월급을 담는 VIEW를 만들되, 평균월급이 2000 이상인

-- 부서만 출력하도록 하라.

CREATE VIEW v_avg
AS SELECT deptno, avg(sal) AS 평균월급
   FROM emp
   GROUP BY deptno
   HAVING avg(sal) >= 2000;

SELECT *
FROM v_avg;

--5. 직위별 총월급을 담는 VIEW를 만들되, 직위가 MANAGER인

-- 사원들은 제외하고 총월급이 3000이상인 직위만 출력하도록 하라

CREATE VIEW v_sum
AS SELECT job, sum(sal) AS 총월급
   FROM emp
   WHERE job != 'MANAGER'
   GROUP BY job
   HAVING sum(sal) >= 3000;
   
SELECT *
FROM v_sum;
-------------------------------------------------------------------------------------
-- 시퀀스
-- pdf 11장 p.185
-- 순번 추출하기 (번호)
-- 자동으로 번호를 생성하는 객체

/*
CREATE SEQUENCE sequence_name
[INCREMENT BY n]
[START WITH n]
[{MAXVALUE n | NOMAXVALUE}]
[{MINVALUE n | NOMINVALUE}]
[{CYCLE | NOCYCLE}]
[{CACHE | NOCACHE}];

sequence_name   SEQUENCE 의 이름입니다.
INCREMENT BY n  정수 값인 n 으로 SEQUENCE 번호 사이의 간격을 지정.
                이 절이 생략되면 SEQUENCE 는 1 씩 증가.
START WITH n    생성하기 위해 첫번째 SEQUENCE 를 지정.
                이 절이 생략되면 SEQUENCE 는 1 로 시작.
MAXVALUE n      SEQUENCE 를 생성할 수 있는 최대 값을 지정.
NOMAXVALUE      오름차순용 10^27 최대값과 내림차순용-1 의 최소값을 지정.
MINVALUE n      최소 SEQUENCE 값을 지정.
NOMINVALUE      오름차순용 1 과 내림차순용-(10^26)의 최소값을 지정.
CYCLE | NOCYCLE 최대 또는 최소값에 도달한 후에 계속 값을 생성할 지의 여부를
                지정. NOCYCLE 이 디폴트.
CACHE | NOCACHE 얼마나 많은 값이 메모리에 오라클 서버가 미리 할당하고 유지
                하는가를 지정. 디폴트로 오라클 서버는 20 을 CACHE.
*/

CREATE TABLE board (
  boardid NUMBER CONSTRAINT pk_board_id PRIMARY KEY,
  title varchar2(100)
);

-- boardid 컬럼 (not null, unique, index)
-- 개발자 : where boardid = ? 무조건 1건의 데이터를 return

-- INSERT INTO board(boardid, title) VALUES (...)
-- 그러면 중복되지 않고, null 값이 아니다 라는 보장

-- 조건 : 처음 글을 쓰면 1이라는 값을 INSERT, 그 다음 글부터는 2, 3, 4, 순차적인 값을 insert

SELECT max(boardid)
FROM board;

DELETE FROM board;

INSERT INTO board(boardid, title)
VALUES ((SELECT nvl(max(boardid), 0) FROM board) + 1, '제목');

SELECT * FROM board;

COMMIT;
-----------------------------------------------------------------------------
-- Sequence 번호를 추출 (규칙에 맞게) : 중복값이 없고 순차적인 값들 (공유 객체)
-----------------------------------------------------------------------------
CREATE SEQUENCE board_num;

SELECT * from sys.USER_SEQUENCES;

/*
NEXTVAL 과 CURRVAL 의사열

가) 특징
1) NEXTVAL 는 다음 사용 가능한 SEQUENCE 값을 반환 한다.
2) SEQUENCE 가 참조될 때 마다, 다른 사용자에게 조차도 유일한 값을 반환한다.
3) CURRVAL 은 현재 SEQUENCE 값을 얻는다.
4) CURRVAL 이 참조되기 전에 NEXTVAL 이 사용되어야 한다.
*/
-- 실채번
SELECT board_num.NEXTVAL FROM dual;

-- 몇번까지 했지
SELECT board_num.CURRVAL FROM dual; -- 마지막으로 추출한 번호는 2번이야
----------------------------------------------------------------------------
CREATE SEQUENCE kboard_num;

CREATE TABLE kboard (
  num NUMBER CONSTRAINT pk_kboard_id PRIMARY KEY,
  title varchar2(100)
);

INSERT INTO kboard(num, title)
VALUES (kboard_num.NEXTVAL, '처음 글');

SELECT *
FROM kboard;

SELECT kboard_num.currval FROM dual;

DELETE FROM kboard WHERE num = 2;

INSERT INTO kboard(num, title)
VALUES (kboard_num.NEXTVAL, '와!');
INSERT INTO kboard(num, title)
VALUES (kboard_num.NEXTVAL, '샌즈!');
INSERT INTO kboard(num, title)
VALUES (kboard_num.NEXTVAL, '파피루스!');

-----------------------------------------------------------------------------
-- 1. SEQUENCE 객체 : 테이블 간 공유 객체 >> 여러 개의 테이블에서 사용 가능
-- A(1)(4), B(2), C(3)

-- 사이트 (게시판) 10개
-- 상품 게시판, 관리자 게시판, 회원 게시판
-- SEQUENCE 따로 만들어서 사용.... 하나의 sequence를 공유해도 된다

-- Tip)
-- MS-SQL : create table board(boardnum int identity(1, 1), title varchar(20)) >> identity는 테이블에 종속
-- insert into board(title) values ('방가') -> boardnum 1 값이 자동 insert
-- MS-SQL 2012 버전부터 sequence 도입

-- MySQL : create table board(boardnum int auto_increment, title varchar(20))

-- MariaDB : Sequence 존재
-----------------------------------------------------------------------------
-- sequence 객체 옵션
CREATE SEQUENCE seq_num
START WITH 10
INCREMENT BY 2;

SELECT seq_num.nextval FROM dual;
SELECT seq_num.currval FROM dual;

-- 게시판 글을 insert
-- 게시판 최신글 순으로 보이기
SELECT *
FROM board
ORDER BY boardid DESC;
------------------------------------------------------------------------------
-- 개발자 필수 2
-- rownum 의사 컬럼 : 실제 물리적으로 존재하는 컬럼이 아니고 논리적인 존재

-- ROWNUM : 실제로 테이블에 컬럼으로 존재하지 않지만 내부적으로 행의 번호를 부여할 수 있는 가상 컬럼
-- ROWID : 주소값 (행이 실제로 저장되는 내부 주소값) -> 인덱스 만들 때 사용

SELECT rownum AS 순번, empno, ename FROM emp; -- select한 결과를 가지고 순번을 붙여준다

-- Top-n 쿼리
-- 테이블에서 조건에 맞는 상위 (TOP) 레코드(row) n개 추출

-- MS-SQL : select top 10, * from order by sal desc
-- Oracle : rownum (의사 컬럼) : 기준을 정의
-------------------------------------------------------------------------
-- rownum 사용

-- 1. 정렬의 기준을 정의하는 작업이 선행
-- 2. 정렬이 된 상황에서 앞에 순번 부여, 조건절 제시, 데이터 추출

-- 1단계
SELECT *
FROM (SELECT *
      FROM emp
      ORDER BY sal DESC) e;
      
-- 2단계
SELECT rownum AS "num", e.*
FROM (SELECT *
      FROM emp
      ORDER BY sal DESC) e;
      
-- 3단계 (급여 많이 받는 사원 5명만)
SELECT rownum AS num, e.*
FROM (SELECT *
      FROM emp
      ORDER BY sal DESC) e
WHERE rownum <= 5;

-- 페이징 처리에 사용 (게시판에 필수)
------------------------------------------------------------------
SELECT *
FROM (SELECT rownum AS num, e.*
      FROM (SELECT *
            FROM emp
            ORDER BY sal DESC) e) n
WHERE num < 10;
-----------------------------------------------------------------
-- 게시판 (페이징 처리)
-- 100건의 데이터
-- 10건씩 나누어서 보여주기

-- 총 100건
-- page size = 10 (한 화면에 보여줄 데이터 건수)
-- page 개수 >> 10

-- 1~10 1page (DB에서 1~10번 글까지 select, APP에서 출력)
-- 11~20 2page
-- ...
-- 91~100 10page

-----------------------------------------------------------------
-- HR 계정으로 이동
SELECT * FROM employees;

-- 41 ~ 50번째 사원 데이터를 출력하세요 (조건 : 사원번호가 낮은 순)
SELECT *
FROM (SELECT rownum AS num, e.*
      FROM (SELECT *
            FROM employees
            ORDER BY employee_id) e)
WHERE num BETWEEN 41 AND 50;

SELECT rownum, e.*
FROM (SELECT *
      FROM employees
      ORDER BY employee_id) e
WHERE rownum >= 2 AND rownum <= 4;

---SQL 기본과정 END-------------------------------------------------------------------
-- SQL 고급과정 (3차 프로젝트 전에)

--1> 부서테이블의 모든 데이터를 출력하라.
SELECT *
FROM dept;
 
--2> EMP테이블에서 각 사원의 직업, 사원번호, 이름, 입사일을 출력하라.
SELECT job, empno, ename, hiredate
FROM emp;

--3> EMP테이블에서 직업을 출력하되, 각 항목(ROW)가 중복되지 않게
-- 출력하라.
SELECT DISTINCT job
FROM emp;
 
--4> 급여가 2850 이상인 사원의 이름 및 급여를 출력하라.
SELECT ename, sal
FROM emp
WHERE sal >= 2850;
 
--5> 사원번호가 7566인 사원의 이름 및 부서번호를 출력하라.
SELECT ename, deptno
FROM emp
WHERE empno = 7566;
 
--6> 급여가 1500이상 ~ 2850이하의 범위에 속하지 않는 모든 사원의 이름
-- 및 급여를 출력하라.
SELECT ename, sal
FROM emp
WHERE sal NOT BETWEEN 1500 AND 2850;
 
--7> 1981년 2월 20일 ~ 1981년 5월 1일에 입사한 사원의 이름,직업 및 
--입사일을 출력하라. 입사일을 기준으로 해서 오름차순으로 정렬하라.
SELECT ename, job, hiredate
FROM emp
WHERE hiredate BETWEEN '1981-02-20' AND '1981-05-01'
ORDER BY hiredate;
 
--8> 10번 및 30번 부서에 속하는 모든 사원의 이름과 부서 번호를
-- 출력하되, 이름을 알파벳순으로 정렬하여 출력하라.
SELECT ename, deptno
FROM emp
WHERE deptno IN (10, 30)
ORDER BY ename;

--9> 10번 및 30번 부서에 속하는 모든 사원 중 급여가 1500을 넘는
-- 사원의 이름 및 급여를 출력하라.
--(단 컬럼명을 각각 employee 및 Monthly Salary로 지정하시오)
SELECT ename AS employee, sal AS "Monthly Salary"
FROM emp
WHERE deptno IN (10, 30) AND sal > 1500;

--10> 관리자가 없는 모든 사원의 이름 및 직위를 출력하라.
SELECT ename, job
FROM emp
WHERE mgr IS NULL;
 
--11> 커미션을 받는 모든 사원의 이름, 급여 및 커미션을 출력하되, 
-- 급여를 기준으로 내림차순으로 정렬하여 출력하라.
SELECT ename, sal, comm
FROM emp
WHERE comm IS NOT NULL
ORDER BY sal DESC;
 
--12> 이름의 세 번째 문자가 A인 모든 사원의 이름을 출력하라.
SELECT ename
FROM emp
WHERE ename LIKE '__A%';

--13> 이름에 L이 두 번 들어가며 부서 30에 속해있는 사원의 이름을 
--출력하라.
SELECT ename
FROM emp
WHERE ename LIKE '%L%L%' AND deptno = 30;
 
--14> 직업이 Clerk 또는 Analyst 이면서 급여가 1000,3000,5000 이 
-- 아닌 모든 사원의 이름, 직업 및 급여를 출력하라.
SELECT ename, job, sal
FROM emp
WHERE job IN ('CLERK', 'ANALYST') AND sal NOT IN (1000, 3000, 5000);

--15> 사원번호, 이름, 급여 그리고 15%인상된 급여를 정수로 표시하되 
--컬럼명을 New Salary로 지정하여 출력하라.
SELECT empno, ename, sal, round(sal * 1.15) AS "New Salary"
FROM emp;
 
--16> 15번 문제와 동일한 데이타에서 급여 인상분(새 급여에서 이전 
-- 급여를 뺀 값)을 추가해서 출력하라.(컬럼명은 Increase로 하라). 
SELECT empno, ename, sal, round(sal * 1.15) AS "New Salary", round(sal * 1.15) - sal AS Increase
FROM emp;
 
--18> 모든 사원의 이름(첫 글자는 
-- 대문자로, 나머지 글자는 소문자로 표시) 및 이름 길이를 표시하는
-- 쿼리를 작성하고 컬럼 별칭은 적당히 넣어서 출력하라.
SELECT INITCAP(ename) AS Name, length(ename) AS "Length of Name"
FROM emp;
 
--19> 사원의 이름과 커미션을 출력하되, 커미션이 책정되지 않은 
-- 사원의 커미션은 'no commission'으로 출력하라.
SELECT ename, nvl(to_char(comm), 'no commision')
FROM emp;
 
--20> 모든 사원의 이름,부서번호,부서이름을 표시하는 질의를 작성하라.
SELECT e.ename, e.deptno, d.dname
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno;
 
--21> 30번 부서에 속한 사원의 이름과 부서번호 그리고 부서이름을 출력하라.
SELECT ename, e.deptno, dname
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE e.deptno = 30;
 
--22> 30번 부서에 속한 사원들의 모든 직업과 부서위치를 출력하라.
--(단, 직업 목록이 중복되지 않게 하라.)
SELECT DISTINCT e.job, d.loc
FROM emp e
INNER JOIN dept d ON e.deptno = d.deptno
WHERE e.deptno = 30;
 
--23> 커미션이 책정되어 있는 모든 사원의 이름, 부서이름 및 위치를 출력하라.
SELECT ename, dname, loc
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE comm IS NOT NULL;
 
--24> 이름에 A가 들어가는 모든 사원의 이름과 부서 이름을 출력하라.
SELECT ename, dname
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE ename LIKE '%A%';
 
--25> Dallas에서 근무하는 모든 사원의 이름, 직업, 부서번호 및 부서이름을 
-- 출력하라.
SELECT e.ename, e.job, e.deptno, d.dname
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE d.loc = 'DALLAS';
 
--26> 사원이름 및 사원번호, 해당 관리자이름 및 관리자 번호를 출력하되,
-- 각 컬럼명을 employee,emp#,manager,mgr#으로 표시하여 출력하라
SELECT e1.ename AS employee, e1.empno AS emp#, e2.ename AS manager, e2.empno AS mgr# 
FROM emp e1
INNER JOIN emp e2
ON e1.mgr = e2.empno;

--27> 모든 사원의 이름,직업,부서이름,급여 및 등급을 출력하라.
SELECT e.ename, e.job, d.dname, e.sal, s.grade
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
INNER JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal;
 
--28> Smith보다 늦게 입사한 사원의 이름 및 입사일을 출력하라.
SELECT ename, hiredate
FROM emp
WHERE hiredate > (SELECT hiredate 
                  FROM emp 
                  WHERE ename = 'SMITH');
                
--29> 자신의 관리자보다 먼저 입사한 모든 사원의 이름, 입사일, 
-- 관리자의 이름, 관리자의 입사일을 출력하되 각각 컬럼명을 
-- Employee,EmpHiredate, Manager,MgrHiredate로 표시하여 
-- 출력하라.
SELECT e1.ename AS Employee, e1.hiredate AS EmpHireDate, e2.ename AS Manager, e2.hiredate AS MgrHireDate
FROM emp e1
INNER JOIN emp e2 
ON e1.mgr = e2.empno
WHERE e1.hiredate < e2.hiredate;

--30> 모든 사원의 급여 최고액,최저액,총액 및 평균액을 출력하되 
-- 각 컬럼명을 Maximum,Minimum,Sum,Average로 지정하여 출력하라.
SELECT max(sal) AS Maximum, min(sal) AS Minimum, sum(sal) AS sum, avg(sal) AS Average
FROM emp;


--31> 각 직업별로 급여 최저액.최고액,총액 및 평균액을 출력하라.
SELECT job, min(sal), max(sal), sum(sal), avg(sal)
FROM emp
GROUP BY job;


--32> 직업이 동일한 사람 수를 직업과 같이 출력하라.
SELECT job, count(*)
FROM emp
GROUP BY job;


--33> 관리자의 수를 출력하되, 관리자 번호가 중복되지 않게하라.
-- 그리고, 컬럼명을 Number of Manager로 지정하여 출력하라.
SELECT count(DISTINCT(mgr)) AS "Number of Manager"
FROM emp;
 
--34> 최고 급여와 최저 급여의 차액을 출력하라.
SELECT max(sal) - min(sal)
FROM emp;

--35> 관리자 번호 및 해당 관리자에 속한 사원들의 최저 급여를 출력하라.
-- 단, 관리자가 없는 사원 및 최저 급여가 1000 미만인 그룹은 제외시키고 
-- 급여를 기준으로 출력 결과를 내림차순으로 정렬하라.
SELECT e1.empno, min(e2.sal)
FROM emp e1
INNER JOIN emp e2
ON e1.empno = e2.mgr
GROUP BY e1.empno
HAVING min(e2.sal) >= 1000
ORDER BY min(e2.sal) DESC;

 
--36> 부서별로 부서이름, 부서위치, 사원 수 및 평균 급여를 출력하라.
-- 그리고 각각의 컬럼명을 부서명,위치,사원의 수,평균급여로 표시하라.
SELECT d.dname AS 부서명, d.loc AS 위치, count(*) AS 사원수, avg(e.sal) AS 평균급여
FROM dept d
INNER JOIN emp e
ON e.deptno= d.deptno
GROUP BY d.dname, d.loc;
 
--37> Smith와 동일한 부서에 속한 모든 사원의 이름 및 입사일을 출력하라.
-- 단, Smith는 제외하고 출력하시오
SELECT ename, hiredate
FROM emp
WHERE deptno = (SELECT deptno
                FROM emp
                WHERE ename = 'SMITH')
AND ename != 'SMITH';
 
--38> 자신의 급여가 평균 급여보다 많은 모든 사원의 사원 번호, 이름, 급여를 
--    표시하는 질의를 작성하고 급여를 기준으로 결과를 내림차순으로 정렬하라.
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT avg(sal) FROM emp)
ORDER BY sal desc;
 
--39> 이름에 T가 들어가는 사원의 속한 부서에서 근무하는 모든 사원의 사원번호
-- 및 이름을 출력하라.
SELECT empno, ename
FROM emp
WHERE deptno in (SELECT deptno
                 FROM emp
                 WHERE ename LIKE '%T%');
 
--40> 부서위치가 Dallas인 모든 사원의 이름,부서번호 및 직위를 출력하라.
SELECT e.ename, e.deptno, e.job
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE d.loc = 'DALLAS';
 
--41> KING에게 보고하는 모든 사원의 이름과 급여를 출력하라.
SELECT ename, sal
FROM emp
WHERE mgr = (SELECT empno
             FROM emp
             WHERE ename = 'KING');
 
--42> Sales 부서의 모든 사원에 대한 부서번호, 이름 및 직위를 출력하라.
SELECT e.deptno, e.ename, e.job
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE d.dname = 'SALES';
 
--43> 자신의 급여가 평균 급여보다 많고 이름에 T가 들어가는 사원과 동일한
-- 부서에 근무하는 모든 사원의 사원 번호, 이름 및 급여를 출력하라.
SELECT empno, ename, sal
FROM emp
WHERE deptno in (SELECT deptno
                 FROM emp
                 WHERE ename LIKE '%T%') 
AND sal > (SELECT avg(sal)
           FROM emp);
 
--44> 커미션을 받는 사원과 급여가 일치하는 사원의 이름,부서번호,급여를 
-- 출력하라.
SELECT ename, deptno, sal
FROM emp
WHERE sal in (SELECT sal
              FROM emp
              WHERE comm IS NOT null);
 
--45> Dallas에서 근무하는 사원과 직업이 일치하는 사원의 이름,부서이름,
--     및 급여를 출력하시오
SELECT e.ename, d.dname, e.sal
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE job in (SELECT job
              FROM emp e
              INNER JOIN dept d
              ON e.deptno = d.deptno
              WHERE d.loc = 'DALLAS');
 
--46> Scott과 동일한 급여 및 커미션을 받는 모든 사원의 이름, 입사일 및 
-- 급여를 출력하시오
SELECT ename, hiredate, sal
FROM emp
WHERE sal = (SELECT sal 
             FROM emp 
             WHERE ename = 'SCOTT')
AND nvl(comm, 0) = (SELECT nvl(comm, 0) 
                    FROM emp 
                    WHERE ename = 'SCOTT');
 
--47> 직업이 Clerk 인 사원들보다 더 많은 급여를 받는 사원의 사원번호,
-- 이름, 급여를 출력하되, 결과를 급여가 높은 순으로 정렬하라.
SELECT empno, ename, sal
FROM emp e
WHERE sal > (SELECT max(sal)
             FROM emp
             WHERE job = 'CLERK')
ORDER BY sal DESC;
  
--48> 이름에 A가 들어가는 사원과 같은 직업을 가진 사원의 이름과
-- 월급, 부서번호를 출력하라.
SELECT ename, sal, deptno
FROM emp e
WHERE job in (SELECT job
              FROM emp
              WHERE ename LIKE '%A%');
 
--49> New  York 에서 근무하는 사원과 급여 및 커미션이 같은 사원의 
-- 사원이름과 부서명을 출력하라.
SELECT ename, dname
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE sal in (SELECT sal
              FROM emp e1
              INNER JOIN dept d1 ON e1.deptno = d1.deptno
              WHERE d1.loc = 'NEW YORK')
AND nvl(comm, 0) IN (SELECT nvl(comm, 0)
                     FROM emp e2
                     INNER JOIN dept d2 ON e2.deptno = d2.deptno
                     WHERE d2.loc = 'NEW YORK');     
 
--50> Dallas에서 근무하는 사원과 직업 및 관리자가 같은 사원의 사원번호,사원이름,
--    직업,월급,부서명,커미션을 출력하되 커미션이 책정되지 않은 사원은 NoCommission
--    으로 표시하고, 커미션의 컬럼명은 Comm으로 나오게 출력하시오.
--    단, 최고월급부터 출력되게 하시오
SELECT e.empno, e.ename, e.job, e.sal, d.dname, nvl(to_char(e.comm), 'NoCommission') AS Comm
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE job in (SELECT job
              FROM emp e
              INNER JOIN dept d
              ON e.deptno = d.deptno
              WHERE d.loc = 'DALLAS')
AND mgr IN (SELECT mgr
            FROM emp e
            INNER JOIN dept d
            ON e.deptno = d.deptno
            WHERE d.loc = 'DALLAS');             

SELECT * FROM dmlemp;

CREATE TABLE trans_A (
  num NUMBER,
  name varchar2(20));

CREATE TABLE trans_B (
  num NUMBER CONSTRAINT pk_trans_B_num PRIMARY KEY,
  name varchar2(20));

SELECT * FROM trans_A;
SELECT * FROM trans_B;
  
SELECT * FROM dept;

SELECT * FROM user_constraints WHERE table_name = 'DEPT';
DROP TABLE student_grade;
DROP TABLE department;

CREATE TABLE department(
  deptno NUMBER,
  dname varchar2(20)
);

ALTER TABLE department
ADD CONSTRAINTS pk_department_deptno PRIMARY KEY(deptno);