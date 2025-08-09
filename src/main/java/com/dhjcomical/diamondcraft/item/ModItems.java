package com.dhjcomical.diamondcraft.item;

public enum ModItems {

    IRON_DIAMOND("iron_diamond"),
    GOLD_DIAMOND("gold_diamond"),
    COPPER_DIAMOND("copper_diamond"),
    REDSTONE_DIAMOND("redstone_diamond"),
    TIN_DIAMOND("tin_diamond"),
    LEADED_DIAMOND("leaded_diamond");


    private final String name;
    private final int maxStackSize;

    ModItems(String name, int maxStackSize) {
        this.name = name;
        this.maxStackSize = maxStackSize;
    }

    ModItems(String name) {
        this(name, 64);
    }


    public String getName() {
        return name;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }
}