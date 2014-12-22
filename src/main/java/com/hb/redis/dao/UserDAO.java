package com.hb.redis.dao;

import java.util.List;

import com.hb.redis.model.User;



public interface UserDAO {
 
    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
    
    public int updateUser(User user);
    
    public int deleteUser(String id);
    
    public int queryUserById(String id);
    
    public List<User> queryAllUser();
    
    
     
     
}