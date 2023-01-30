package com.mam.interface_private;

/**
 * @Author Anmin
 * @Date 2023/01/30
 **/
public class ChinaPeople implements People{
    @Override
    public void sleep() {
        System.out.println("睡觉");
    }
}
