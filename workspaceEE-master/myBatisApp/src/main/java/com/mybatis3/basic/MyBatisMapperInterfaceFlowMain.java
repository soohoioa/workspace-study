package com.mybatis3.basic;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentBasicMapper;
import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MyBatisMapperInterfaceFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0.mybatis-config-mapper-interface.xml --> InputStream
		 */
		InputStream myBatisConfigInputStream = 
				Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
		// 클래스를 매핑해줌
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
		/*
		 * 2. SqlSessionFactory
		 */
		SqlSessionFactory sqlSessionFactory=
				sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		/*
		 * 3. SqlSession open (Connection)
		 * 	  autocommit true
		 */
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		System.out.println("#### SqlSession객체:"+sqlSession);
		
		
		/*
		 * 4. StudentBasicMapper[MapperInterface]생성
		 *    org.apache.ibatis.binding.MapperProxy
		 */
		StudentBasicMapper studentBasicMapper = 
				sqlSession.getMapper(StudentBasicMapper.class); 
		// StudentBasicMapper 를 줘서 studentBasicMapper 구현체를 만들고 
				
		System.out.println("#### StudentMapper객체:" + studentBasicMapper);
		/*
		 * 5. StudentMapper[MapperInterface]사용(CRUD)
		*/
		System.out.println("#### studentList:" + studentBasicMapper.findAllStudents());
		
		System.out.println("#### student:" + studentBasicMapper.findStudentById(1));
		
		/*
		 * 6. SqlSession close
		 */
		sqlSession.close();
		
	}
}













