package com.zte.redis;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import redis.clients.jedis.Jedis;

/**
 * Created by majun on 15/10/19.
 */
public class RedisClient {
    private static final String ip = "127.0.0.1";
    private static final int port = 6379;

    public Jedis getClient() {
        return Suppliers.memoize(new Supplier<Jedis>() {
            public Jedis get() {
                return new Jedis(ip, port);
            }
        }).get();
    }

    public Object get(String key){
        return getClient().get(key);
    }
}
