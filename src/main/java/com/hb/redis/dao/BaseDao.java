package com.hb.redis.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.TypeException;

/**
 * Class description goes here.
 * 
 * @version 1.0 2013-11-29
 * @author xqwu
 */
public interface BaseDao {
	
	/**
	 * 
	 * 获得sqlSession对象.
	 * @author xqwu
	 * @date 2013-11-29 下午4:17:11
	 *
	 * @return
	 */
	public SqlSession getSqlSession() throws TypeException,SQLException,Exception;
	
	/**
	 * 
	 * 插入数据.
	 * @author xqwu
	 * @date 2013-12-6 上午09:56:00
	 *
	 * @param s
	 * @param obj
	 * @throws TypeException
	 * @throws SQLException
	 * @throws Exception
	 */
	public void insert(String s, Object obj) throws TypeException,SQLException,Exception;
	
	/**
	 * 
	 * 查询所有数据.
	 * @author xqwu
	 * @date 2013-11-29 下午3:52:21
	 *
	 * @return
	 */
	public List<?> findAll(String s, Object obj) throws TypeException,SQLException,Exception;
	
	/**
	 * 
	 * 查询指定页数大小.
	 * @author xqwu
	 * @date 2013-11-29 下午3:54:06
	 *
	 * @param s      namespace用于java代码调用时识别指定xml的mapper文件
	 * @param pageNo 页码
	 * @param pageSize 大小
	 * @return
	 */
	public List<?> findList(String s, Object obj, int pageNo, int pageSize) throws TypeException,SQLException,Exception;
	
	/**
	 * 
	 * 查询返回对象.
	 * @author xqwu
	 * @date 2013-12-2 下午02:58:41
	 *
	 * @param s
	 * @param param
	 * @return
	 */
	public Object selectOne(String s, Object param) throws TypeException,SQLException,Exception;
	
	/**
	 * 
	 * 更新数据方法.
	 * @author xqwu
	 * @date 2013-12-4 下午05:59:16
	 *
	 * @param s
	 * @param param
	 * @throws TypeException
	 * @throws SQLException
	 * @throws Exception
	 */
	public void update(String s, Object param) throws TypeException,SQLException,Exception;
	
	
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
            Object sqlParameter, int pageIndex, int pageSize) throws Exception ;
}

