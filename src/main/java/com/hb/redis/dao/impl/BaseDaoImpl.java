package com.hb.redis.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeException;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionUtils;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hb.redis.dao.BaseDao;


/**
 * Dao基类，所有Dao都继承该类.
 * 
 * @version 1.0 2013-11-29
 * @author xqwu
 */
public class BaseDaoImpl implements BaseDao{
	
//	@Autowired
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactoryBean sqlSessionFactoryBean;

	@Override
	public SqlSession getSqlSession() throws TypeException,SQLException,Exception {
		SqlSessionFactory sessionFactory = sqlSessionFactoryBean.getObject();
		 SqlSession session = SqlSessionUtils.getSqlSession(sessionFactory);
//		return sessionFactory.openSession();
		 return session;
	}

	@Override
	public List<?> findAll(String s, Object obj) throws TypeException,SQLException,Exception {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSession();
		try{
			List list = session.selectList(s, obj);
			return list;
		} finally{
			session.close();
		}
	}
	
	@Override
	public List<?> findList(String s, Object obj, int pageNo, int pageSize) throws TypeException,SQLException,Exception {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSession();
		try{
			List list = session.selectList(s, obj, new RowBounds((pageNo-1)*pageSize, pageSize));
			return list;
		} finally{
			session.close();
		}
	}

	@Override
	public Object selectOne(String s, Object param) throws TypeException,SQLException,Exception {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSession();
		try{
			Object object = session.selectOne(s, param);
			return object;
		} finally{
			session.close();
		}
	}

	@Override
	public void update(String s, Object param) throws TypeException,SQLException, Exception {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSession();
		try{
			session.update(s, param);
			session.commit();
		} finally{
			session.close();
		}
	}

	/* （non-Javadoc）
	 * <p>Title: insert</p>
	 * <p>Description: </p>
	 * 
	 * @param s     mapper.xml文件中的插入xml配置id
	 * @param obj   javabean对象
	 * 
	 * @throws TypeException
	 * @throws SQLException
	 * @throws Exception
	 * @see com.opro.ims.i.restservice.core.BaseDao#insert(java.lang.String, java.lang.Object)
	 */
	@Override
	public void insert(String s, Object param) throws TypeException, SQLException, Exception {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSession();
		try{
			session.insert(s, param);
			session.commit();
		} finally{
			session.close();
		}
	}
	
	/**
     * 查询分页数据
     * 
     * @param mapperClass
     * @param sqlId
     * @param sqlParameter
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
	public List<?> getPageList(Class<?> mapperClass, String sqlId,
            Object sqlParameter, int pageIndex, int pageSize) throws Exception {
    	SqlSession session = null;
        try {
            session = getSqlSession();
            
            if (pageIndex <= 0) {
                pageIndex = 1;
            }
            if (pageSize <= 0) {
                pageSize = 10;
            }
            PageBounds pageBounds = new PageBounds(pageIndex, pageSize);
            return session.selectList(mapperClass.getName() + "." + sqlId,
                    sqlParameter, pageBounds);
        } finally {
        	if(session != null)
        	{
        		session.close();
        	}
        }

    }
	
}
