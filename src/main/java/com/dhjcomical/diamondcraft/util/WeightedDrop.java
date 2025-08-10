package com.dhjcomical.diamondcraft.util;


import com.dhjcomical.diamondcraft.item.ModItems;

public class WeightedDrop {
    public final ModItems material;
    public final double weight;

    public WeightedDrop(ModItems material, double weight) {
        this.material = material;
        this.weight = weight;
    }
}