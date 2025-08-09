package com.dhjcomical.diamondcraft.tab;

import com.dhjcomical.diamondcraft.handler.RegistryHandler;
import com.dhjcomical.diamondcraft.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DiamondCraftTab extends CreativeTabs {

    private ItemStack icon;

    public DiamondCraftTab(String label) {
        super(label);
    }


    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack createIcon() {
        if (this.icon == null) {
            Item iconItem = RegistryHandler.ITEM_MAP.get(ModItems.IRON_DIAMOND);
            if (iconItem != null) {
                this.icon = new ItemStack(iconItem);
            } else {
                this.icon = new ItemStack(Items.DIAMOND);
            }
        }
        return this.icon;
    }
}