package com.nufflee.nlib.enums;

public enum BlockHarvestLevel {
    ANY(-1),
    WOODEN(0),
    STONE(1),
    IRON(2),
    DIAMOND(3);

    private int value;

    BlockHarvestLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
