package com.dhjcomical.diamondcraft;

import com.dhjcomical.diamondcraft.proxy.IProxy;
import com.dhjcomical.diamondcraft.tab.DiamondCraftTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class DiamondCraftMod {
    public static final CreativeTabs DIAMONDCRAFT_TAB = new DiamondCraftTab("diamondcraft_tab");

    @SidedProxy(
            clientSide = "com.dhjcomical.diamondcraft.proxy.ClientProxy",
            serverSide = "com.dhjcomcial.diamondcraft.proxy.ServerProxy"
    )
    public static IProxy proxy;

    @Mod.Instance
    public static DiamondCraftMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
