package com.mam.collect;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Anmin
 * @Date 2023/01/30
 * 集合工厂方法
 **/
public class Client {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c", "d");
        Set<String> set = Set.of("a", "b", "c", "d");
        Map<String, Integer> map = Map.of("key1", 1, "key2", 2, "key3", 3);
        Map<String, Integer> map1 = Map.ofEntries(Map.entry("key1", 1), Map.entry("key2", 2));
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(map1);
    }
}
