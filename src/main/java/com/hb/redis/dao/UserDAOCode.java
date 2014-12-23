package com.hb.redis.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.TypeException;
import org.springframework.stereotype.Component;

import com.hb.redis.dao.impl.BaseDaoImpl;

@Component
public class UserDAOCode extends BaseDaoImpl{

	public int insertUser(Object param) throws TypeException, SQLException, Exception {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSession();
		try{
			session.insert("insertUser",param);
			session.commit();
			
		}catch(Exception e){
			throw e;
		}
		finally{
			session.close();
		}
		
		return 1;
	}
		
}
