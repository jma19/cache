package com.zte.redis;

import com.zte.redis.bean.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by majun on 15/10/19.
 */
public class GsonSeralizerTest {

    @Test
    public void should_transform_into_gson() throws Exception {
        Employee employee=new Employee().setId(1).setName("12");
        String s = GsonSeralizer.toJson(employee);
        System.out.println(s);
    }
}