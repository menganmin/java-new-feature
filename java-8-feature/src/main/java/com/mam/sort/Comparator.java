package com.mam.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2023/01/14
 **/
public class Comparator {
    public static void main(String[] args) {
        List<Person> list= new ArrayList<>();
        list.add(new Person("小白",20));
        list.add(new Person("小黄",19));
        list.add(new Person("小老弟",21));
        Collections.sort(list, new java.util.Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getAge() - t1.getAge();//升序
            }
        });
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
