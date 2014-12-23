package com.hb.redis.service.user;

import java.util.List;

import com.hb.redis.model.User;
import com.hb.redis.model.UserPage;

/**
 * 业务服务对象
 * 
 * @author 338342
 *
 */
public interface UserService {

	public int insertUser(User user);

	public int updateUser(User user);

	public int deleteUser(String id);

	public int queryUserById(String id);

	public List<User> queryAllUser();
	
	/**
	 * 分页查询 
	 * @param page
	 * @return
	 */
	public List<User> findByPage(UserPage page);     
	
	/**
	 * 分页查询时得到符合条件的数据
	 * @param page
	 * @return
	 */
	public Integer getCount(UserPage page); 
}