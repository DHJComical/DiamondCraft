package com.dhjcomical.diamondcraft.item;

public enum ModItems {

    RAW_RUBY("raw_ruby");


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