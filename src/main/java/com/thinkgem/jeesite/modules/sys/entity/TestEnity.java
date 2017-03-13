package com.thinkgem.jeesite.modules.sys.entity;

import java.io.Serializable;

public class TestEnity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7401487229110127285L;
	private String name;
	private int age;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
