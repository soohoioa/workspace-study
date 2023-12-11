package com.mybatis3.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class StudentDaoMapperInterface{
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapper.";
	
	public StudentDaoMapperInterface() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			this.sqlSessionFactory = 
					sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
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
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student =studentMapper.findStudentById(studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudents() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList=studentMapper.findAllStudents();
		sqlSession.close();
		return studentList;
	}

	/*
	 * resultMap :  DTO
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.findStudentByIdResultMap(studId);
		sqlSession.close();
		return null;
	}

	public List<Student> findAllStudentsResultMap() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = studentMapper.findAllStudentsResultMap();
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
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student=studentMapper.findStudentByIdWithAddress(studId);
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
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student=studentMapper.findStudentByIdWithCourses(studId);
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
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student =studentMapper.findStudentByIdWithCourses(studId);
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
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		int rowCount=sqlSession.insert(NAMESPACE+"insertStudentBySequence", student);
		sqlSession.close();
		return rowCount;
	}
	
	public int insertStudentBySequenceReturnPrimaryKey(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		int rowCount=
				sqlSession.insert(NAMESPACE+"insertStudentBySequenceReturnPrimaryKey", student);
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
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		int rowCount=sqlSession.update(NAMESPACE+"updateStudentById", updateStudent);
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
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		int rowCount=sqlSession.delete(NAMESPACE+"deleteStudentById", studId);
		sqlSession.close();
		return rowCount;
	}
	
	public int deleteStudentByName(String name) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		int rowCount=sqlSession.delete(NAMESPACE+"deleteStudentByName", name);
		sqlSession.close();
		return rowCount;
	}
	
	public int deleteStudentByNameLike(String name) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		int rowCount=sqlSession.delete(NAMESPACE+"deleteStudentByNameLike", name);
		sqlSession.close();
		return rowCount;
	}
	
	
	
}