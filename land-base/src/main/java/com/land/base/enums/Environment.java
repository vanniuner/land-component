package com.land.base.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;

/**
 * @author LZJ
 * @time 2023-03-23 15:25:49
 **/
@Getter
@AllArgsConstructor
public enum Environment {

    DEV      (  0  , "DEV"   ),
    TEST     (  1  , "TEST"  ),
    PRE      (  2  , "PRE"   ),
    UAT      (  3  , "UAT"   ),
    PROD     (  4  , "PROD"  );

    private int code;
    private String desc;
}
