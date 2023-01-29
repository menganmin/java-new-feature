package com.mam.stream.use;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author Anmin
 * @Date 2023/01/29
 **/
public class Client {
    public static void main(String[] args) {
        createStream();
        System.out.println("==========");
        map();
        System.out.println("==============");
        flatMap();
        System.out.println("=============");
        filter();
        System.out.println("===============");
        findFirst();
        System.out.println("===============");
        converter();
        System.out.println("===============");
        limitOrSkip();
        System.out.println("==============");
        statistics();
        System.out.println("===================");
        groupingBy();
        System.out.println("=================");
        partitioningBy();
        System.out.println("===================");
        generate();
    }

    public static void createStream() {
        List<String> list = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        String[] strings = {"Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter"};
        //集合获取Stream流
        Stream<String> stream = list.stream();
        //数组获取Stream流
        Stream<String> stringStream = Stream.of(strings);
        Stream<String> stringStream1 = Arrays.stream(strings);
        //从静态方法获取流
        IntStream intStream = IntStream.range(0, 10);
        intStream.limit(10).forEach(num -> System.out.print(num + ","));
        System.out.println();
        IntStream intStream1 = IntStream.of(1, 2, 3, 3, 4);
        intStream1.forEach(num -> System.out.print(num + ","));
        System.out.println();
    }

    public static void map(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> collect = list.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
        collect.forEach(num -> System.out.println(num));
    }

    public static void flatMap(){
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3),
                Arrays.asList(4, 5, 6)
        );
        List<Integer> collect = list.stream()
                .flatMap(num -> num.stream())
                .map(num -> num * 2)
                .collect(Collectors.toList());
        collect.forEach(num -> System.out.println(num));
    }

    public static void filter(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = list.stream()
                .filter(num -> num > 3)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public static void findFirst(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = list.stream()
                .findFirst();
        System.out.println(first.orElse(-1));
    }

    public static void converter(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // to array
        Integer[] array = list.stream().toArray(Integer[]::new);
        //to list
        List<Integer> integerList = list.stream().collect(Collectors.toList());
        //to set
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        //to string
        String string = list.stream()
                .map(num -> String.valueOf(num))
                .collect(Collectors.joining(","))
                .toString();
        System.out.println(string);

    }

    public static void limitOrSkip(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.stream()
                .limit(3)
                .forEach(System.out::println);
        System.out.println("------------");
        list.stream()
                .skip(3)
                .forEach(System.out::println);
    }

    public static void statistics(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        IntSummaryStatistics statistics = list.stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println("最大值：" + statistics.getMax());
        System.out.println("最小值：" + statistics.getMin());
        System.out.println("个数：" + statistics.getCount());
        System.out.println("和：" + statistics.getSum());
        System.out.println("平均数：" + statistics.getAverage());
    }

    public static void groupingBy(){
        List<Integer> list = Arrays.asList(11, 12, 13, 22, 23, 24);
        Map<Integer, List<Integer>> map = list.stream()
                .collect(Collectors.groupingBy(age -> age / 10));
        map.forEach((k,v) -> System.out.println("年龄有" + k + "0多岁的有" + v));
    }

    /**
     * partitioningBy
     * 按某个条件分组，返回的key为boolean类型
     */
    public static void partitioningBy(){
        List<Integer> list = Arrays.asList(11, 22, 33, 13, 25, 27);
        Map<Boolean, List<Integer>> map = list.stream()
                .collect(Collectors.partitioningBy(age -> age > 18));
        System.out.println("未成年：" + map.get(false));
        System.out.println("成年：" + map.get(true));
    }

    public static void generate(){
        //生成随机数流
        Random random = new Random();
        Stream<Integer> integerStream = Stream.generate(random::nextInt);
        integerStream.limit(5).forEach(System.out::println);
        System.out.println("=======");
        //生成UUID流
        Stream<UUID> uuidStream = Stream.generate(UUID::randomUUID);
        uuidStream.limit(5).forEach(System.out::println);
    }
}
