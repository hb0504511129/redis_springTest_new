package com.hb.redis.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.redis.dao.UserDAO;
import com.hb.redis.dao.UserDAOCode;
import com.hb.redis.model.User;
import com.hb.redis.service.user.UserService;
 
 
 
@Service
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDAOCode userDAOCode;
    
    @Autowired
    private UserDAO userDAO;
     
    @Override
    public int insertUser(User user) {
        // TODO Auto-generated method stub
        try {
        	return userDAO.insertUser(user);
//			return userDAOCide.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}
        
    }

	@Override
	public String list(String name, int start, int size, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStudent(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryUserById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

 
}