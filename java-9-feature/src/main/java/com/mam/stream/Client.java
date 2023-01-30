package com.mam.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Anmin
 * @Date 2023/01/30
 **/
public class Client {
    public static void main(String[] args) {
        takeWhile();
        System.out.println("==========");
        dropWhile();
    }

    /**
     * takeWhile: 从头开始筛选，遇到不满足的就结束了
     */
    public static void takeWhile(){
        List<Integer> list = List.of(1, 2, 3, 4);
        List<Integer> collect = list.stream()
                .takeWhile(x -> x < 3)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * dropWhile: 从头开始删除，遇到不满足的就结束了
     */
    public static void dropWhile(){
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> collect = list.stream()
                .dropWhile(x -> x < 3)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


}
