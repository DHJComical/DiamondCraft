package com.dhjcomical.diamondcraft.event;

import com.dhjcomical.diamondcraft.Tags;
import com.dhjcomical.diamondcraft.handler.RegistryHandler;
import com.dhjcomical.diamondcraft.item.ModItems;
import com.dhjcomical.diamondcraft.util.WeightedDrop;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class ModEvents {

    private static final List<WeightedDrop> DIAMOND_ORE_DROPS = new ArrayList<>();
    private static double totalWeight = 0.0;

    static {
        final double COMMON_METAL_BASE_WEIGHT = 20.0;
        final double UNCOMMON_METAL_BASE_WEIGHT = 12.0;
        final double RARE_METAL_BASE_WEIGHT = 6.0;
        final double JACKPOT_DIAMOND_WEIGHT = 2.0;

        final double POOR_MULTIPLIER = 3.0;
        final double NORMAL_MULTIPLIER = 6.0;
        final double RICH_MULTIPLIER = 1.0;

        addMetalDrops(ModItems.POOR_IRON_DIAMOND, ModItems.IRON_DIAMOND, ModItems.RICH_IRON_DIAMOND, COMMON_METAL_BASE_WEIGHT);
        addMetalDrops(ModItems.POOR_LEAD_DIAMOND, ModItems.LEAD_DIAMOND, ModItems.RICH_LEAD_DIAMOND, COMMON_METAL_BASE_WEIGHT);
        addMetalDrops(ModItems.POOR_TIN_DIAMOND, ModItems.TIN_DIAMOND, ModItems.RICH_TIN_DIAMOND, COMMON_METAL_BASE_WEIGHT);
        addMetalDrops(ModItems.POOR_COPPER_DIAMOND, ModItems.COPPER_DIAMOND, ModItems.RICH_COPPER_DIAMOND, COMMON_METAL_BASE_WEIGHT);

        addMetalDrops(ModItems.POOR_SILVER_DIAMOND, ModItems.SILVER_DIAMOND, ModItems.RICH_SILVER_DIAMOND, UNCOMMON_METAL_BASE_WEIGHT);
        addMetalDrops(ModItems.POOR_NICKEL_DIAMOND, ModItems.NICKEL_DIAMOND, ModItems.RICH_NICKEL_DIAMOND, UNCOMMON_METAL_BASE_WEIGHT);
        addMetalDrops(ModItems.POOR_ZINC_DIAMOND, ModItems.ZINC_DIAMOND, ModItems.RICH_ZINC_DIAMOND, UNCOMMON_METAL_BASE_WEIGHT);
        addMetalDrops(ModItems.POOR_REDSTONE_DIAMOND, ModItems.REDSTONE_DIAMOND, ModItems.RICH_REDSTONE_DIAMOND, UNCOMMON_METAL_BASE_WEIGHT);
        addMetalDrops(ModItems.POOR_SULFUR_DIAMOND, ModItems.SULFUR_DIAMOND, ModItems.RICH_SULFUR_DIAMOND, UNCOMMON_METAL_BASE_WEIGHT);

        addMetalDrops(ModItems.POOR_GOLD_DIAMOND, ModItems.GOLD_DIAMOND, ModItems.RICH_GOLD_DIAMOND, RARE_METAL_BASE_WEIGHT);
        addMetalDrops(ModItems.POOR_TITANIUM_DIAMOND, ModItems.TITANIUM_DIAMOND, ModItems.RICH_TITANIUM_DIAMOND, RARE_METAL_BASE_WEIGHT);

        DIAMOND_ORE_DROPS.add(new WeightedDrop(ModItems.BEDROCK_DIAMOND, JACKPOT_DIAMOND_WEIGHT));


        for (WeightedDrop drop : DIAMOND_ORE_DROPS) {
            totalWeight += drop.weight;
        }
        System.out.println("DiamondCraft: Diamond Ore drop table initialized with " + DIAMOND_ORE_DROPS.size() + " possible drops and total weight of " + totalWeight);
    }

    private static void addMetalDrops(ModItems poor, ModItems normal, ModItems rich, double baseWeight) {
        DIAMOND_ORE_DROPS.add(new WeightedDrop(poor, baseWeight * 3.0));
        DIAMOND_ORE_DROPS.add(new WeightedDrop(normal, baseWeight * 6.0));
        DIAMOND_ORE_DROPS.add(new WeightedDrop(rich, baseWeight * 1.0));
    }


    @SubscribeEvent
    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        if (event.getState().getBlock() != Blocks.DIAMOND_ORE) {
            return;
        }

        event.getDrops().clear();

        ModItems chosenMaterial = selectRandomDrop();

        if (chosenMaterial != null) {
            Item finalDropItem = RegistryHandler.ITEM_MAP.get(chosenMaterial);

            if (finalDropItem != null) {
                final int fortune = event.getFortuneLevel();
                final Random rand = event.getWorld().rand;
                final int quantity = 1 + (fortune > 0 ? rand.nextInt(fortune + 1) : 0);

                event.getDrops().add(new ItemStack(finalDropItem, quantity));
            }
        }
    }

    private static ModItems selectRandomDrop() {
        if (totalWeight <= 0) return null;
        double randomValue = Math.random() * totalWeight;
        for (WeightedDrop drop : DIAMOND_ORE_DROPS) {
            randomValue -= drop.weight;
            if (randomValue <= 0.0) {
                return drop.material;
            }
        }
        return null;
    }
}