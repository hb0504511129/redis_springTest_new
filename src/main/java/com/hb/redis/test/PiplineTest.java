package com.hb.redis.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * <pre>
 *   链接：http://blog.csdn.net/chenxiaodan_danny/article/details/41514065
 * 	参考自：
		http://www.blogjava.net/masfay/archive/2012/07/03/382080.html
		http://blog.csdn.net/freebird_lb/article/details/7778919
		http://redis.io/topics/pipelining 官方文档
		redis pipeline 原理
		1. 基于response-request响应，客户端发送请求-redis服务器返回数据为一个RTT时间，若有多个请求，需要等待前一个请求返回数据完毕，redis服务器才会处理下一个请求
		2.使用redis pipeline 可以使得，多个请求一起发送，redis服务器需要返回的数据存储在内存中，全部处理完毕后，一次性传输回所有数据，这样就只有一个RTT时间，(just one time for several commands)
	
		redis pipeline实现，客户端为基于java 的Jedis
		1.new Jedis(?,?)，建立jedis连接
		2.jedis.pipelined()，创建jedis pipeline
		2.发起count个commands
		3.pipeline.sync()，pipeline一次性获取所有数据
		4.jedis.disconnect ，关闭jedis
 * </pre>
 * @author 338342
 *
 */
public class PiplineTest {
	private static Log logger = LogFactory.getLog(PiplineTest.class.getName());

	public static void main(String[] args) {
		int count = 10000;
		long start = System.currentTimeMillis();
		withoutPipeline(count);
		long end = System.currentTimeMillis();
		System.out.println("withoutPipeline: " + (end - start) + "ms");

		start = System.currentTimeMillis();
		usePipeline(count);
		end = System.currentTimeMillis();
		System.out.println("usePipeline: " + (end - start) + "ms");
		
		/*
		 * 运行结果为：
		 * 运行结果：
		 *		withoutPipeline: 6785ms
		 *		usePipeline: 641ms
		 */
	}

	private static void withoutPipeline(int count) {
		Jedis jedis = null;
		try {
			jedis = new Jedis("127.0.0.1", 6380);// 127.0.0.1 为redis服务器ip

			for (int i = 0; i < count; i++) {
				// 将指定Key的Value原子性的递增1。如果该Key不存在，其初始值为0，在incr之后其值为1,返回递增后的值。
				jedis.incr("testKey1");
			}
			// Ask the server to silently close the connection.
			 jedis.quit();
		} catch (Exception e) {
			logger.error(e);
		} finally {
			if (jedis != null) {
				// 与jedis.quit区别?
				jedis.disconnect();
			}
		}

	}

	private static void usePipeline(int count) {
		Jedis jedis = null;
		try {
			// <pre name="code" class="java"><span
			// style="white-space:pre"></span>
			jedis = new Jedis("127.0.0.1", 6380);// 127.0.0.1 为redis服务器ip
			Pipeline pipeline = jedis.pipelined();
			for (int i = 0; i < count; i++) {
				// 将指定Key的Value原子性的递增1。如果该Key不存在，其初始值为0，在incr之后其值为1,返回递增后的值。
				// 每个操作都发送请求给redis-server
				pipeline.incr("testKey2");
			}
			// Syncronize pipeline by reading all responses.获取所有的response
			pipeline.sync();
		} catch (Exception e) {
			logger.error(e);
		} finally {
			if (jedis != null) {
				jedis.disconnect();
			}
		}
	}

}
