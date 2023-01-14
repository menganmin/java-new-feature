package com.mam.optional;

import lombok.Data;

import java.util.Optional;

/**
 * @Author Anmin
 * @Date 2023/01/14
 **/
@Data
public class Computer {
    private Optional<SoundCard> soundCard;
}
