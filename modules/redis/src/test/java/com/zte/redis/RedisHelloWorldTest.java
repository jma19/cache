package com.zte.redis;

import com.zte.redis.bean.Employee;
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
    @Test
    public void shoud_get_string_value_when_add_strng_value() throws Exception {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        long start=System.currentTimeMillis();
        for (long i = 0; i < 1000000; i++) {
            Employee employee = new Employee().setName("xiaoya").setId("employee:" + i);
            jedis.set(employee.getId(), GsonSeralizer.toJson(employee));
            Employee employee1 = GsonSeralizer.toObject(jedis.get(employee.getId()), Employee.class);
            assertThat(employee,is(employee1));
        }
        long duralTime=(System.currentTimeMillis()-start)/1000;
        System.out.println("消耗时间:"+duralTime+"s");
    }

    @Test
    public void should_delet_all_data() throws Exception {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        long start=System.currentTimeMillis();
        for (long i = 0; i < 1000000; i++) {
            Employee employee = new Employee().setName("xiaoya").setId("employee:" + i);
            jedis.del(employee.getId());
        }
        long duralTime=(System.currentTimeMillis()-start)/1000;
        System.out.println("消耗时间:"+duralTime+"s");
    }
    //47s左右完成1百万条数据数据删除


}