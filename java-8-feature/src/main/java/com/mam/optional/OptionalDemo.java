package com.mam.optional;

import java.util.Optional;

/**
 * @Author Anmin
 * @Date 2023/01/14
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        checkOptional();
        whenIsPresent();
        //getValue();
        whenIsNullGet();
        fun();
    }

    /**
     * 创建一个Optional
     */
    public static void createOptional(){
        // Optional 构造方式1 - of 传入的值不能为 null

        Optional<String> helloOption = Optional.of("hello");

        // Optional 构造方式2 - empty 一个空 optional
        Optional<String> emptyOptional = Optional.empty();

        // Optional 构造方式3 - ofNullable 支持传入 null 值的 optional
        Optional<String> nullOptional = Optional.ofNullable(null);
    }

    /**
     * 检查是否有值
     */
    public static void checkOptional(){
        Optional<String> optional = Optional.of("Hello");
        System.out.println(optional.isPresent());

        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent());
    }

    /**
     * 如果有值，输出长度
     */
    public static void whenIsPresent(){
        Optional<String> optional = Optional.of("Hello");
        optional.ifPresent(s -> System.out.println(s.length()));
    }

    /**
     * 使用get方法可以获取值，如果不存在，就会抛出异常NoSuchElementException
     */
    public static void getValue(){
        Optional<String> optional = Optional.of("Hello");
        System.out.println(optional.get());

        Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());
    }

    /**
     * 使用orElse orElseGet方法可以在没有值的情况下获取给定的默认值
     */
    public static void whenIsNullGet(){
        Optional<String> optional = Optional.of("Hello");
        String s = optional.orElse("default");
        System.out.println(s);
        System.out.println("==========");
        Optional<String> empty = Optional.empty();
        Object default_hello = empty.orElse("default orElse Hello");
        System.out.println(default_hello);
        System.out.println("==========");
        String orElseGet = empty.orElseGet(() -> "default orElseGet Hello");
        System.out.println(orElseGet);
    }

    /**
     * 使用 orElseThrow 在没有值的时候抛出异常
     */
    public static void whenIsNullThrow() throws Exception {
        Optional<String> empty = Optional.empty();
        String s = empty.orElseThrow(() -> new Exception("没有值"));
        System.out.println(s);
    }

    public static void fun(){
        Optional<Integer> optional = Optional.of(123);
        optional.filter(num -> num == 123).ifPresent(num -> System.out.println(num));

        Optional<Integer> optional1 = Optional.of(456);
        optional1.map(num -> String.valueOf(num))
                .map(num -> num.length())
                .ifPresent(length -> System.out.println(length));


    }
}
