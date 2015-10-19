package com.zte.redis;

import com.google.gson.Gson;

/**
 * Created by majun on 15/10/19.
 */
public class GsonSeralizer {

    private static Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static <T> T toObject(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }


}
