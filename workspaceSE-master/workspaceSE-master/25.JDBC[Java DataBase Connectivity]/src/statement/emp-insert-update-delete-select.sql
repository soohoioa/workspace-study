-- emp crud

-- selete
select empno, ename, job, sal, hiredate from emp;
select empno, ename, job, sal, hiredate from emp where sal >= 1000 and sal <= 4000 and job = 'SALESMAN' or job = 'CLEPK';


-- insert
insert into emp values(9000, 'JUNG', 'MANAGER', 7369, to_date('2000/01/01', 'YYYY/MM/DD'), 3000.34, 30, 40);

-- update
update emp set sal = sal*1.3 where empno >= 7369 and empno <= 7600;

-- delete
delete from emp where empno = 9000;

-- sql 문에서 실행으로 한번 더 확인해보고 작성하면 오류찾기 쉬움.