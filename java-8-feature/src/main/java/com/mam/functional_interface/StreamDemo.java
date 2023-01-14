package com.mam.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Anmin
 * @Date 2023/01/14
 **/
public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3","1");
        /*list.stream().distinct()
                .filter(s -> "1".equals(s))
                .forEach(System.out::println);*/

        String collect = list.stream().distinct()
                .filter(s -> !"1".equals(s))
                .collect(Collectors.joining(";"));
        System.out.println(collect);

        list.stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
