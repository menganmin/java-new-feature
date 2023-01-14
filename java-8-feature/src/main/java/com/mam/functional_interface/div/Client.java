package com.mam.functional_interface.div;

/**
 * @Author Anmin
 * @Date 2023/01/14
 **/
public class Client {
    public static void main(String[] args) {
        hello(((name, age) -> System.out.println(name + "-" + age)));
    }

    public static void hello(FunctionInterfaceDemo functionalInterface){
        functionalInterface.hello("小老弟",18);
    }
}
