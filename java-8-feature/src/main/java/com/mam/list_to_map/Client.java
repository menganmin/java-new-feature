package com.mam.list_to_map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Author Anmin
 * @Date 2023/01/29
 **/
public class Client {
    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("小白",18));
        list.add(new Dog("小黑",20));
        list.add(new Dog("小老弟",19));
        toMap(list);
        System.out.println("=================");
        toMap1(list);
        System.out.println("============");
        list.add(new Dog("小白",20));
        toMap2(list);
        System.out.println("===========");
        toMap3(list);
    }

    /**
     * 把包含不同品种的狗类集合转换成 key 为狗的品种，value 为狗的年龄的 Map
     */
    public static void toMap(List<Dog> list){
        Map<String, Integer> map = list.stream()
                .collect(Collectors.toMap(dog -> dog.getName(), dog -> dog.getAge()));
        map.forEach((k,v) -> System.out.println("名称：" + k + ",年龄：" + v));
    }

    /**
     * 把包含不同品种的狗类集合转换成 key 为狗的品种，value 为狗的信息对象的 Map
     */
    public static void toMap1(List<Dog> list){
        Map<String, Dog> map = list.stream()
                .collect(Collectors.toMap(Dog::getName, dog -> dog));
        map.forEach((k,v) -> System.out.println("名称：" + k + "的小狗：" + v));
    }

    /**
     * List 转 Map 使用 Collectors.toMap 进行转换时，如果有 key 冲突
     * 传入第三个参数，当 Key 冲突时，选择使用 新值
     */
    public static void toMap2(List<Dog> list){
        Map<String, Integer> map = list.stream()
                .collect(Collectors.toMap(Dog::getName, Dog::getAge, (oldName, newName) -> newName));
        map.forEach((k,v) -> System.out.println("名称：" + k + ",年龄：" + v));
    }

    /**
     * List 转 Map，指定 Map 类型
     * 传入第四个参数，指定 Map 类型
     */
    public static void toMap3(List<Dog> list){
        ConcurrentHashMap<String, Integer> map = list.stream()
                .collect(Collectors.toMap(Dog::getName, Dog::getAge, (oldName, newName) -> newName,
                        ConcurrentHashMap::new));
        System.out.println(map.getClass());
    }
}
