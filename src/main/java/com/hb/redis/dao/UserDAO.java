package com.hb.redis.dao;

import com.hb.redis.model.User;



public interface UserDAO {
 
    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
     
     
}