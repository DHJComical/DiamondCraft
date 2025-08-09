package com.dhjcomical.diamondcraft.util;

import com.dhjcomical.diamondcraft.DiamondCraftMod;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String name, int maxStackSize) {
        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(DiamondCraftMod.DIAMONDCRAFT_TAB);
        this.setMaxStackSize(maxStackSize);
    }
}