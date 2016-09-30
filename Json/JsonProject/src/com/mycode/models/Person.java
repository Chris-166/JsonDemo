package com.mycode.models;

/**
 * 实例，即要封装成Json的数据
 * @author FanFF
 *
 */
public class Person {
	
	private int id;
	private String name;
	private String address;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//toString重写用以在调用该对象的时候得到想要输出的信息 
	@Override
	public String toString() {
		return "Person [address=" + address + ", id=" + id + ", name=" + name
				+ "]";
	}	
}
