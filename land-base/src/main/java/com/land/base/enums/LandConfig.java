package com.land.base.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;

/**
 * @author LZJ
 * @time 2023-03-23 15:25:21
 **/
@Getter
@AllArgsConstructor
public enum LandConfig {

    MDF_TRACEID      (  0  , "requestID"      ),
    ACCESS_TOKEN     (  0  , "Access-Token"   );

    private int code;
    private String desc;
}
