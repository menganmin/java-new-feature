package com.mam.functional_interface;

/**
 * @Author Anmin
 * @Date 2023/01/14
 **/
public class LambdaDemo {
    public static void main(String[] args) {
        createLambda();
    }

    public static void createLambda(){
        //之前的代码格式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程创建");
            }
        }).start();

        //使用lambda之后
        new Thread(() -> System.out.println("lambda 线程创建")).start();
    }

}
