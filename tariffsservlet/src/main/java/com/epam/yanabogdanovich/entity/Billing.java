package com.epam.yanabogdanovich.entity;


public enum Billing {
    MINUTE("minute"),
    TWENTY_SECONDS("twenty seconds");

    private String value;

    private Billing(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
