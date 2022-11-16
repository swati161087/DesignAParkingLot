package com.scaler.parkinglot;

import java.util.HashMap;

public class ObjectRegistry  {
    private static HashMap<String,Object> objectHashMap=new HashMap<>();
    public static void put(String name,Object object)
    {
        objectHashMap.put(name,object);
    }
    public static Object get(String name)
    {
        return objectHashMap.get(name);
    }
}
