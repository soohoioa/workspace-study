select * from dept;
--부서번호로 부서정보
select * from dept where deptno=30;
--부서번호로 부서정보 와 부서에소속된사원들정보 select

select * 
   from dept d join emp e on d.deptno=e.deptno where d.deptno=30;
   
   desc orderIteml