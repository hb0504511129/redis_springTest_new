package com.hb.redis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hb.redis.model.User;
import com.hb.redis.model.UserPage;

public interface UserDAO {

	/**
	 * 添加新用户
	 * 
	 * @param user
	 * @return
	 */
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
	
	
	public PageList<User> findPage(PageBounds pageRequest);
	
	public PageList<User> findPageByFirstName(@Param("name") String name, PageBounds pageRequest);

}