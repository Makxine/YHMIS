package com.tedu.pojo;
/**
 * 这个类用来描述用户表
 *
 */
public class User {
	//描述id字段
	private Integer id;
	
	//描述name字段
	private String name;
	
	//描述addr字段
	private String addr;
	
	//描述age字段
	private Integer age;

	//setters and getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	//toString
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}
	
	
}
