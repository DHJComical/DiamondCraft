package com.dhjcomical.diamondcraft.handler;

import com.dhjcomical.diamondcraft.DiamondCraftMod;
import com.dhjcomical.diamondcraft.Tags;
import com.dhjcomical.diamondcraft.item.ModItems;
import com.dhjcomical.diamondcraft.util.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.EnumMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class RegistryHandler {

    public static final Map<ModItems, Item> ITEM_MAP = new EnumMap<>(ModItems.class);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        System.out.println("DiamondCraft: Registering items from enum...");

        for (ModItems material : ModItems.values()) {
            String name = material.getName();
            int stackSize = material.getMaxStackSize();

            Item item = new ItemBase(name, stackSize);

            event.getRegistry().register(item);

            ITEM_MAP.put(material, item);

            DiamondCraftMod.proxy.registerItemRenderer(item, 0, "inventory");
        }

    }

}