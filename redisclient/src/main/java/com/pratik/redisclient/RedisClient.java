/**
 * 
 */
package com.pratik.redisclient;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * @author Pratik
 *
 */
public class RedisClient {
	
	Jedis jedis = null;
	
	public RedisClient() {
		 connect() ;
	}
	
	
	public Jedis getJedis() {
		return jedis;
	}


	public void putElement(String key, String value) {
		jedis.set(key, value);
	}
	
	public void putElementList(final String key, List<String> values) {
		// store in liist
		values.forEach((val)->{
			jedis.lpush(key, val);
		});
	}
	
	public String getElement(String key) {
		return jedis.get(key);
	}
	
	public void getAllElements() {
		Set<String> keys = jedis.keys("*");
		keys.forEach(key->{
			System.out.println(key + ": " + jedis.get(key));
		});
	}
	
	private void connect() {
		//Connecting to Redis server on localhost 
	      jedis = new Jedis("localhost"); 
	      
	}

}
