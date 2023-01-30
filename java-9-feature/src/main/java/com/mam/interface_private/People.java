package com.mam.interface_private;

/**
 * @Author Anmin
 * @Date 2023/01/30
 **/
public interface People {
    void sleep();

    //默认方法
    default void eat(){
        drink();
    }

    private void drink(){
        System.out.println("喝水");
    }
}
