package com.hb.redis.model;

/**
 *    User 分页查询公共条件类   @author Voishion
 */
public class UserPage {

	/**
	 * 当前页码
	 */
	Integer firstRec;
	
	/**
	 * 一页数量
	 */
	Integer pageSize;
	
	/**
	 * 查询对象
	 */
	User user;
	
	public Integer getFirstRec() {
		return firstRec;
	}
	public void setFirstRec(Integer firstRec) {
		this.firstRec = firstRec;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
