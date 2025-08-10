package com.dhjcomical.diamondcraft.event;

import com.dhjcomical.diamondcraft.Tags;
import com.dhjcomical.diamondcraft.handler.RegistryHandler;
import com.dhjcomical.diamondcraft.item.ModItems;
import com.dhjcomical.diamondcraft.util.WeightedDrop;
import net.minecraft.block.state.IBlockState;
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

    // 【重大改进】
    // 因为 WeightedDrop 现在使用 ModItems 枚举，这个初始化过程不再依赖于任何注册状态。
    // 我们可以安全地把它放回 static 代码块，它会在类加载时被立即、安全地执行。
    // 不再需要在主类中手动调用 initializeDrops() 方法了！
    static {
        DIAMOND_ORE_DROPS.add(new WeightedDrop(ModItems.IRON_DIAMOND, 30.0)); // 40% 的相对概率
        DIAMOND_ORE_DROPS.add(new WeightedDrop(ModItems.GOLD_DIAMOND, 15.0)); // 40% 的相对概率
        DIAMOND_ORE_DROPS.add(new WeightedDrop(ModItems.TIN_DIAMOND, 15.0)); // 15% 的相对概率
        DIAMOND_ORE_DROPS.add(new WeightedDrop(ModItems.COPPER_DIAMOND, 30.0));  // 5% 的相对概率 (稀有)

        // 预计算总权重
        for (WeightedDrop drop : DIAMOND_ORE_DROPS) {
            totalWeight += drop.weight;
        }
        System.out.println("DiamondCraft: Drop table defined.");
    }

    @SubscribeEvent
    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        if (event.getState().getBlock() != Blocks.DIAMOND_ORE) {
            return;
        }

        event.getDrops().clear();

        // 1. 从权重表中选择一个 ModItems 枚举常量
        ModItems chosenMaterial = selectRandomDrop();

        if (chosenMaterial != null) {
            // 2. 【关键桥梁】使用枚举作为键，从 RegistryHandler 的 Map 中获取真正的 Item 对象
            Item finalDropItem = RegistryHandler.ITEM_MAP.get(chosenMaterial);

            // 3. 安全检查，防止因注册失败或 Map 未填充导致的崩溃
            if (finalDropItem != null) {
                final int fortune = event.getFortuneLevel();
                final Random rand = event.getWorld().rand;
                final int quantity = 1 + (fortune > 0 ? rand.nextInt(fortune + 1) : 0);

                // 4. 使用获取到的 Item 对象创建最终的掉落物
                event.getDrops().add(new ItemStack(finalDropItem, quantity));
            }
        }
    }

    /**
     * 这个方法现在返回一个 ModItems 枚举，而不是 Item 对象。
     */
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