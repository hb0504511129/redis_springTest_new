package com.hb.redis.mainTest;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

/**
 * java 客户端 Jedis实现 1.new Jedis(?,?)创建连接 2.jedis.watch("key");
 * 开始监听，一旦有两个及以上对该key操作则事务停止 3..Transaction transaction =
 * jedis.multi();//multi开启事务 4.指令入队列 5.exec执行事务
 * 
 * 文章链接：http://blog.csdn.net/chenxiaodan_danny/article/details/41516441
 * 
 * @author 338342
 *
 */
public class TransactionsTest {
	private static Log logger = LogFactory.getLog(TransactionsTest.class
			.getName());

	private static void withoutTransactions(int count) {
		Jedis jedis = null;
		try {
			jedis = new Jedis("XXX", 6380);// redis 服务器IP
			for (int i = 0; i < count; i++) {
				String result = jedis.set("n" + i, "n" + i);
			}

		} catch (Exception e) {
			logger.error(e);
		} finally {
			if (jedis != null) {
				jedis.disconnect();
			}
		}
	}

	private static void useTransactions(int count) {
		Jedis jedis = null;
		try {
			jedis = new Jedis("XXX", 6380);// redis 服务器IP,端口
			jedis.watch("foo");
			// multi,开启事务
			Transaction transaction = jedis.multi();
			for (int i = 0; i < count; i++) {
				// 指令一依次放入队列,每一条指令成功放入队列，Response<String> exec指令执行前不执行该指令
				transaction.set("n" + i, "n" + i);
			}
			// transaction.set("foo", "bar");
			// Response<String> result1 = transaction.get("foo"); //redis
			// String类型
			// transaction.zadd("foo", 1, "barowitch");
			// transaction.zadd("foo", 0, "barinsky");
			// transaction.zadd("foo", 0, "carty");
			// Response<Set<String>> sose = transaction.zrange("foo", 0,
			// -1);//redis set<String>类型

			// exec指令，开始执行队列里的指令，成功返回一个数值数组，否则返回null
			List<Object> results = transaction.exec();

			// String foolbar = result1.get(); // use Response.get() to retrieve
			// things from a Response
			// int soseSize = sose.get().size(); // on sose.get() you can
			// directly call Set methods!

			// System.out.println("result1:" + foolbar);
			// System.out.println("soseSize:" + soseSize);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			if (jedis != null) {
				jedis.disconnect();
			}
		}

	}

	public static void main(String[] args) {
		int count = 10;
		long start = System.currentTimeMillis();
		withoutTransactions(count);
		long end = System.currentTimeMillis();
		System.out.println("withoutTransaction: " + (end - start) + "ms");

		start = System.currentTimeMillis();
		useTransactions(count);
		end = System.currentTimeMillis();
		System.out.println("useTransaction: " + (end - start) + "ms");

	}
}
