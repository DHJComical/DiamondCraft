// src/main/java/com/yourname/diamondcraft/proxy/IProxy.java

package com.dhjcomical.diamondcraft.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public interface IProxy {


    void preInit(FMLPreInitializationEvent event);

    void init(FMLInitializationEvent event);

    void postInit(FMLPostInitializationEvent event);


    void registerItemRenderer(Item item, int meta, String id);
}