package com.mam.optional;

import java.util.Optional;

/**
 * @Author Anmin
 * @Date 2023/01/14
 **/
public class Client {
    public static void main(String[] args) {
        //空值的情况
        Computer computer = new Computer();
        computer.setSoundCard(Optional.empty());
        Optional<Computer> optional = Optional.ofNullable(computer);
        String version = optional.flatMap(computer1 -> computer1.getSoundCard())
                .flatMap(soundCard -> soundCard.getUsd())
                .map(usd -> usd.getVersion())
                .orElse("UNKNOWN");
        System.out.println(version);
        System.out.println("=============");

        //有值的情况
        SoundCard soundCard = new SoundCard();
        Usd usd = new Usd();
        usd.setVersion("1.0");
        soundCard.setUsd(Optional.ofNullable(usd));
        Optional<SoundCard> cardOptional = Optional.ofNullable(soundCard);
        if (cardOptional.isPresent()){
            System.out.println(cardOptional.get());
        }
        System.out.println("================");
        //获取1.0的值
        cardOptional.map(soundCard1 -> soundCard1.getUsd())
                .filter(usd1 -> "2.0".equals(usd1.map(Usd::getVersion)))
                .orElse(Optional.ofNullable(new Usd("UNKNOWN")))
                .ifPresent(version1 -> System.out.println(version1));


    }
}
