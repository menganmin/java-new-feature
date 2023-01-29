package com.mam.stream.intermedia;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Anmin
 * @Date 2023/01/29
 **/
public class Client {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        list.stream()
                .filter(name -> name.length() == 4)
                .map(name -> "this is " + name)
                .forEach(System.out::println);
    }
}
