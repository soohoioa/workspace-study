package com.mybatis3.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/*
이름      널?       유형           
------- -------- ------------ 
STUD_ID NOT NULL NUMBER(11)   
NAME    NOT NULL VARCHAR2(50) 
EMAIL   NOT NULL VARCHAR2(50) 
PHONE            VARCHAR2(15) 
DOB              DATE         
ADDR_ID          NUMBER(11)   

*/


@Getter
@Setter
@NoArgsConstructor //인자없는 기본생성자
@AllArgsConstructor // 모두받는 기본생성자
@RequiredArgsConstructor // @NonNull 이 필요하다. 
// 이 어노테이션은 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다. 
public class Student {
	@NonNull // 이렇게 작성 후 null 넣으면 에러발생한다.
	private Integer studId;
	@NonNull
	private String name;
	@NonNull
	private String email;
	@NonNull // 널이 아니다.
	private Date dob;
	
	private Address address;
	private List<Course> courseList;
	
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email=" + email + ", dob=" + dob + ", address="
				+ address + ", courseList=" + courseList + "]\n";
	}
	
}
