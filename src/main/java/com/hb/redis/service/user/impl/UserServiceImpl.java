package com.hb.redis.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.redis.dao.UserDAO;
import com.hb.redis.dao.UserDAOCode;
import com.hb.redis.model.User;
import com.hb.redis.model.UserPage;
import com.hb.redis.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAOCode userDAOCode;

	@Autowired
	private UserDAO userDAO;

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		try {
			return userDAO.insertUser(user);
			// return userDAOCide.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}

	}

	@Override
	public int updateUser(User user) {
		userDAO.updateUser(user);
		return 0;
	}

	@Override
	public int deleteUser(String id) {
		userDAO.deleteUser(id);
		return 0;
	}

	@Override
	public int queryUserById(String id) {
		userDAO.queryUserById(id);
		return 0;
	}

	@Override
	public List<User> queryAllUser() {
		return userDAO.queryAllUser();
	}

	@Override
	public List<User> findByPage(UserPage page) {
		return userDAO.findByPage(page);
	}

	@Override
	public Integer getCount(UserPage page) {
		return userDAO.getCount(page);
	}

}