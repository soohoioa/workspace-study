package com.mybatis3.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
// EqualsAndHashCode : 객체 같은지 검증
public class Tutor implements Serializable
{
	private Integer tutorId;
	private String name;
	private String email;
	private Address address;
	private List<Course> courses;

}
