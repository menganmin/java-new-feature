package com.mam.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2023/01/14
 **/
public class Lambda {
    public static void main(String[] args) {
        List<Person> list= new ArrayList<>();
        list.add(new Person("小白",20));
        list.add(new Person("小黄",19));
        list.add(new Person("小老弟",21));
        list.sort(Comparator.comparing(Person::getAge));
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
