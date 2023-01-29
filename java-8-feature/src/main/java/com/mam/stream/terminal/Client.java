package com.mam.stream.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Anmin
 * @Date 2023/01/29
 **/
public class Client {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        List<String> collect = list.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        collect.forEach(name -> System.out.println(name));
    }
}
