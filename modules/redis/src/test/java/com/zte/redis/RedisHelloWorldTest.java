package com.zte.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by majun on 15/10/19.
 */
public class RedisHelloWorldTest {
    @Test
    public void shoud_get_a_string_value_when_add_a_strng_value() throws Exception {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("name", "xiaoya");
        String name = jedis.get("name");
        assertThat(name, is("xiaoya"));
    }
}