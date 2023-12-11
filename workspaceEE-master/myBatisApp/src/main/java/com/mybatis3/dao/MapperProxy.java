package com.mybatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MapperProxy /*implements StudentBasicMapper*/ {
	private SqlSession sqlSession;
	//@Override
	public Student findStudentById(Integer studId) {
		String namespace = StudentMapper.class.getName();
		
		Student student=sqlSession.selectOne(namespace+".findStudentById",studId);
		sqlSession.commit();
		sqlSession.close();
		return student;
	}

	//@Override
	public List<Student> findAllStudents() {
		String namespace = StudentMapper.class.getName();
		sqlSession.selectList(namespace+".findAllStudents");
		return null;
		// namespace 와 메소드 이름을 일치시키지 않으면 호출안됨/
	}

}
