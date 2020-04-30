/**
 * 
 */
package com.pratik.redisclient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import redis.clients.jedis.Jedis;

/**
 * @author fab
 *
 */
class RedisClientTest {
	
	RedisClient redisClient = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		redisClient = new RedisClient();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.pratik.redisclient.RedisClient#connect()}.
	 */
	@Test
	void testConnect() {
		
		assertEquals("PONG", redisClient.getJedis().ping());
	}
	
	@Test
	void testPutSingleElement() {
		redisClient.putElement("rate", "3.14");
		String result = redisClient.getElement("rate");
		assertEquals("3.14", result);
	}
	
	@Test
	void getAllElements() {
		redisClient.getAllElements();
	}

}
