package com.nufflee.nlib.enums;

public enum BlockHarvestTool {
    ANY("any"),
    PICKAXE("pickaxe"),
    AXE("axe"),
    SHOVEL("spade"),
    HOE("hoe"),
    SWORD("sword");

    String value;

    BlockHarvestTool(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
