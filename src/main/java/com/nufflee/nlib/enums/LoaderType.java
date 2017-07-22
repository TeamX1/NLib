package com.nufflee.nlib.enums;

public enum LoaderType {
    ITEM(0),
    BLOCK(1);

    private int value;

    LoaderType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
