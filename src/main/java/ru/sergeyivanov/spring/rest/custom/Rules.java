package ru.sergeyivanov.spring.rest.custom;

import java.util.HashMap;
import java.util.Map;

public class Rules {
    public static Map<String, String> stringMap = new HashMap<>();
    public static String name = "травоядных";
    public static final String SELECT_HERBIVORES = "select count(*) as count from data where type_animal = 'ТРАВОЯДНОЕ';";
    static {
        stringMap.put(name, SELECT_HERBIVORES);
    }
}
