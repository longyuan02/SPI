package com.kt.cinterface;

import com.kt.libinterface.LDisplay;

/**
 * @Author: dr
 * @Data: 2020/3/18
 */
public class IMainDisplay implements LDisplay {
    @Override
    public String display() {
        return "IMainDisplay_show";
    }
}
