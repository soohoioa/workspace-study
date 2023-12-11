package com.mybatis3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	
	private SqlSessionFactory sqlSessionFactory;
	/*
	 SqlSessionFactory는 데이터베이스와의 연결과 SQL의 실행에 대한 모든 것을 가진 가장 중요한 객체다.
	 */
	public static final String NAMESPACE = "com.mybatis3.dao.mapper.StudentMapper.";
	public StudentDao() {
		try {
			sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")); 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**************************************************
	1. SELECT[결과타입이 DTO[DTO List] 객체인경우] 
	**************************************************/
	/*
	 resultType :  DTO
	*/
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		// SqlSession 은 쓰고 받드시 닫아야 하므로 위에 올릴수없음. 그냥 계속 쓰고 닫아야한다.
		// 대신 스프링에서는 올림
		Student student = sqlSession.selectOne(NAMESPACE+"findStudentById",studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudents() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Student> studentList=
				sqlSession.selectList(NAMESPACE+"findAllStudents");
		sqlSession.close();
		return studentList;
	}

	/*
	 * resultMap :  DTO
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student =
				sqlSession.selectOne(NAMESPACE+"findStudentByIdResultMap",studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudentsResultMap() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Student> studentList=
				sqlSession.selectList(NAMESPACE+"findAllStudentsResultMap");
		sqlSession.close();
		return studentList;
	}
	/*******************************************************************
	 2. SELECT[결과타입이 Wrapper(String)[Wrapper(String) List]객체인경우] 
	*******************************************************************/
	/*
	 * resultType :  String,Wrapper,List<Wrapper>,List<String>
	 */
	public String  findStudentNameById(Integer studId) {
		String name="";
		return name;
	}
	public List<String> findStudentNameList(){
		List<String> nameList=null;
		return nameList;
	}
	/**************************************************
	 3. SELECT[student + address JOIN]( 1 : 1 )
	 **************************************************/
	/*
	 * resultMap : studentWithAddressResultMap
	 */
	public Student findStudentByIdWithAddress(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student=sqlSession.selectOne(NAMESPACE+"findStudentByIdWithAddress",studId);
		sqlSession.close();
		return student;
	}

	/*********************************************************
	 4. SELECT[students + courses[course_enrollment]+course] JOIN( 1 : N )
	 ********************************************************/
	/*
	 * resultMap : studentWithCoursesResultMap
	 */
	public Student findStudentByIdWithCourses(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student=sqlSession.selectOne(NAMESPACE+"findStudentByIdWithCourses",studId);
		sqlSession.close();
		return student;
	}
	
	/**************************************************
	 5. SELECT[students + address + courses[course_enrollment] JOIN( 1 : 1 : N )
	**************************************************/
	/*
	 * resultMap : studentWithAddressWithCoursesResultMap
	 */
	public Student findStudentByIdWithAddressAndCourses(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Student student=sqlSession.selectOne(NAMESPACE+"findStudentByIdWithAddressAndCourses",studId);
		sqlSession.close();
		return student;
	}
	
	/**************************************************
	 * INSERT
	 ***************************************************/
	/*
	parameterType: DTO,VO,Domain
	*/
	public int insertStudentBySequence(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount= sqlSession.insert(NAMESPACE + "insertStudentBySequence", student);	
		sqlSession.close();
		return rowCount;
	}
	
	public int insertStudentBySequenceReturnPrimaryKey(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount= sqlSession.insert(NAMESPACE + "insertStudentBySequenceReturnPrimaryKey", student);	
		// int rowCount 를 반환 안하고 getStudId pk로 반환함
		sqlSession.close();
		return student.getStudId();
	}



	/**************************************************
	 * UPDATE
	 ***************************************************/
	/*
	  parameterType: DTO,VO,Domain
	 */
	public int updateStudentById(Student updateStudent) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount= sqlSession.update(NAMESPACE + "updateStudentById", updateStudent);		
		sqlSession.close();
		return rowCount;
	}

	/**************************************************
	 * DELETE
	 ***************************************************/
	/*
	 parameterType: java.lang.Integer,java.lang.String
	 */
	public int deleteStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount= sqlSession.delete(NAMESPACE + "deleteStudentById", studId);	
		sqlSession.close();
		return rowCount;
	}
	public int deleteStudentByName(String name) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount= sqlSession.delete(NAMESPACE + "deleteStudentByName", name);	
		sqlSession.close();
		return rowCount;
	}
	public int deleteStudentByNameLike(String name) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int rowCount= sqlSession.delete(NAMESPACE + "deleteStudentByNameLike", name);
		sqlSession.close();
		return rowCount;
	}

	

}
