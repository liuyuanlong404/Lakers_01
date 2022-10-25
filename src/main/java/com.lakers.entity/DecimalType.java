package com.lakers.entity;

/**
 * Created on 2022/10/8 13:25
 *
 * @author Lakers
 */
public enum DecimalType {
    /**
     * 进制转化
     */
    TWO(2, "0b"),
    EIGHT(8, "0"),
    SIXTEEN(16, "0x");

    private long decimal;

    private String prefix;

    DecimalType(long decimal, String prefix) {
        this.decimal = decimal;
        this.prefix = prefix;
    }

    public long getDecimal() {
        return decimal;
    }

    public String getPrefix() {
        return prefix;
    }
}
