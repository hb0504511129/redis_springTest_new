package com.hb.redis.service.user;

import java.util.List;

import com.hb.redis.model.User;


/**
 * 业务服务对象
 * @author 338342
 *
 */
public interface UserService {
 
    public int insertUser(User user);

	public String list(String name, int start, int size, String order);
	
	 public int updateStudent(User user);
	    
	    public int deleteUser(String id);
	    
	    public int queryUserById(String id);
	    
	    public List<User> queryAllUser();
}