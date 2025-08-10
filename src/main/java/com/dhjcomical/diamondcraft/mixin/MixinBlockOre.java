package com.dhjcomical.diamondcraft.mixin;

import com.dhjcomical.diamondcraft.handler.RegistryHandler;
import com.dhjcomical.diamondcraft.item.ModItems;
import com.dhjcomical.diamondcraft.util.WeightedDrop;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mixin(Block.class)
public abstract class MixinBlockOre {

    private static final List<WeightedDrop> DIAMOND_ORE_DROPS = new ArrayList<>();
    private static double totalWeight = 0.0;

    static {
        DIAMOND_ORE_DROPS.add(new WeightedDrop(ModItems.IRON_DIAMOND, 30.0)); // 40% 的相对概率
        DIAMOND_ORE_DROPS.add(new WeightedDrop(ModItems.GOLD_DIAMOND, 15.0)); // 40% 的相对概率
        DIAMOND_ORE_DROPS.add(new WeightedDrop(ModItems.TIN_DIAMOND, 15.0)); // 15% 的相对概率
        DIAMOND_ORE_DROPS.add(new WeightedDrop(ModItems.COPPER_DIAMOND, 30.0));  // 5% 的相对概率 (稀有)

        for (WeightedDrop drop : DIAMOND_ORE_DROPS) {
            totalWeight += drop.weight;
        }
    }

    @ModifyReturnValue(method = "getDrops", at = @At("RETURN"))
    private List<ItemStack> modifyDrops(List<ItemStack> original, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        if (state.getBlock() == Blocks.DIAMOND_ORE) {
            original.clear();

            ModItems chosenMaterial = selectRandomDrop();

            if (chosenMaterial != null) {
                Item finalDropItem = RegistryHandler.ITEM_MAP.get(chosenMaterial);

                if (finalDropItem != null) {
                    int quantity = 1 + (fortune > 0 ? new Random().nextInt(fortune + 1) : 0);
                    original.add(new ItemStack(finalDropItem, quantity));
                }
            }
        }
        return original;
    }

    private ModItems selectRandomDrop() {
        if (totalWeight <= 0) {
            return null;
        }

        double randomValue = Math.random() * totalWeight;

        for (WeightedDrop drop : DIAMOND_ORE_DROPS) {
            randomValue -= drop.weight;
            if (randomValue <= 0.0) {
                return drop.item;
            }
        }
        return null;
    }
}