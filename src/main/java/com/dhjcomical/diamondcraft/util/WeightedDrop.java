package com.dhjcomical.diamondcraft.util;

import com.dhjcomical.diamondcraft.item.ModItems;

public class WeightedDrop {
    public final ModItems item;
    public final double weight;

    public WeightedDrop(ModItems item, double weight) {
        this.item = item;
        this.weight = weight;
    }
}