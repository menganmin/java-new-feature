package com.mam.functional_interface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2023/01/14
 * 方法引用
 **/
public class UserClient {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("小老弟",18));
        list.add(new User("小白",20));
        list.add(new User("小黄",21));
        list.stream().sorted(Comparator.comparing(User::getAge))
                .forEach(System.out::println);
    }
}
