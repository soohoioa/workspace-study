select * from EMP;
--사원정보
select * from emp where empno=7499;
--사원+부서정보(inner join)
select * from emp e join dept d on e.deptno=d.deptno where e.empno=7499;
--사원+부서정보(outer join)
select * from emp e left outer join dept d on e.deptno=d.deptno where e.empno=7369;

select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,loc from emp e left outer join dept d on e.deptno = d.deptno where empno=7499;
