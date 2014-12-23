package com.hb.redis.model;

import java.util.Date;

public class User implements java.io.Serializable {

	// Fields

	private Integer id; // 主键
	private String name;// 名字
	private Integer age;// 年龄
	private Date birthday;// 生日
	private String address;// 地址
	private String password;// 密码
	
	private Date createTime;//创建时间
	private Date modifyTime;//修改时间
	
	private static final String OBJECT_KEY = "USER";

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public User(Integer id, String name, Integer age, Date birthday,
			String address, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.address = address;
		this.password = password;
	}

	public User(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getCreateTime() {
		 if (createTime == null) {
			 createTime =  new Date();
		}
		return createTime;
	}

	public Date getModifyTime() {
		if(modifyTime == null)
		{
			modifyTime = createTime;
		}
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	public String getObjectKey() {
		return OBJECT_KEY;
	}

	public Object getKey() {
		// TODO Auto-generated method stub
		return this.id;
	}

}