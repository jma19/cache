package com.zte.redis.bean;

/**
 * Created by majun on 15/10/19.
 */
public class Employee {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

}
