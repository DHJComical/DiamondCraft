package com.dhjcomical.diamondcraft.item;

public enum ModItems {

    // --- Metal-Infused Diamonds ---
    POOR_IRON_DIAMOND("poor_iron_diamond"),
    IRON_DIAMOND("iron_diamond"),
    RICH_IRON_DIAMOND("rich_iron_diamond"),

    POOR_GOLD_DIAMOND("poor_gold_diamond"),
    GOLD_DIAMOND("gold_diamond"),
    RICH_GOLD_DIAMOND("rich_gold_diamond"),

    POOR_SILVER_DIAMOND("poor_silver_diamond"),
    SILVER_DIAMOND("silver_diamond"),
    RICH_SILVER_DIAMOND("rich_silver_diamond"),

    POOR_COPPER_DIAMOND("poor_copper_diamond"),
    COPPER_DIAMOND("copper_diamond"),
    RICH_COPPER_DIAMOND("rich_copper_diamond"),

    POOR_NICKEL_DIAMOND("poor_nickel_diamond"),
    NICKEL_DIAMOND("nickel_diamond"),
    RICH_NICKEL_DIAMOND("rich_nickel_diamond"),

    POOR_TITANIUM_DIAMOND("poor_titanium_diamond"),
    TITANIUM_DIAMOND("titanium_diamond"),
    RICH_TITANIUM_DIAMOND("rich_titanium_diamond"),

    POOR_LEAD_DIAMOND("poor_lead_diamond"),
    LEAD_DIAMOND("lead_diamond"),
    RICH_LEAD_DIAMOND("rich_lead_diamond"),

    POOR_REDSTONE_DIAMOND("poor_redstone_diamond"),
    REDSTONE_DIAMOND("redstone_diamond"),
    RICH_REDSTONE_DIAMOND("rich_redstone_diamond"),

    POOR_ZINC_DIAMOND("poor_zinc_diamond"),
    ZINC_DIAMOND("zinc_diamond"),
    RICH_ZINC_DIAMOND("rich_zinc_diamond"),

    POOR_TIN_DIAMOND("poor_tin_diamond"),
    TIN_DIAMOND("tin_diamond"),
    RICH_TIN_DIAMOND("rich_tin_diamond"),

    POOR_SULFUR_DIAMOND("poor_sulfur_diamond"),
    SULFUR_DIAMOND("sulfur_diamond"),
    RICH_SULFUR_DIAMOND("rich_sulfur_diamond"),

    // --- Mineral Slag ---
    IRON_SLAG("iron_slag"),
    GOLD_SLAG("gold_slag"),
    SILVER_SLAG("silver_slag"),
    COPPER_SLAG("copper_slag"),
    NICKEL_SLAG("nickel_slag"),
    TITANIUM_SLAG("titanium_slag"),
    LEAD_SLAG("lead_slag"),
    REDSTONE_SLAG("redstone_slag"),
    ZINC_SLAG("zinc_slag"),
    TIN_SLAG("tin_slag"),
    SULFUR_SLAG("sulfur_slag"),

    // --- Special Diamonds ---
    BEDROCK_DIAMOND("bedrock_diamond"),
    REINFORCED_BEDROCK_DIAMOND("reinforced_bedrock_diamond"),

    // --- Gears ---
    WOOD_GEAR("wood_gear"),
    STONE_GEAR("stone_gear"),
    IRON_GEAR("iron_gear"),
    SILVER_GEAR("silver_gear"),
    COPPER_GEAR("copper_gear"),
    GOLD_GEAR("gold_gear"),
    TITANIUM_GEAR("titanium_gear"),
    BRONZE_GEAR("bronze_gear"),
    REINFORCED_OBSIDIAN_GEAR("reinforced_obsidian_gear"),
    STEEL_GEAR("steel_gear"),

    // --- Axles ---
    WOOD_AXLE("wood_axle"),
    STONE_AXLE("stone_axle"),
    IRON_AXLE("iron_axle"),
    SILVER_AXLE("silver_axle"),
    COPPER_AXLE("copper_axle"),
    GOLD_AXLE("gold_axle"),
    TITANIUM_AXLE("titanium_axle"),
    BRONZE_AXLE("bronze_axle"),
    REINFORCED_OBSIDIAN_AXLE("reinforced_obsidian_axle"),
    STEEL_AXLE("steel_axle"),

    // --- Frames ---
    WOOD_FRAME("wood_frame"),
    STONE_FRAME("stone_frame"),
    IRON_FRAME("iron_frame"),
    SILVER_FRAME("silver_frame"),
    COPPER_FRAME("copper_frame"),
    GOLD_FRAME("gold_frame"),
    BRONZE_FRAME("bronze_frame"),
    DIAMOND_FRAME("diamond_frame"),
    STEEL_FRAME("steel_frame"),

    // --- Grinding Hammers ---
    WOOD_GRINDING_HAMMER("wood_grinding_hammer", 1),
    STONE_GRINDING_HAMMER("stone_grinding_hammer", 1),
    IRON_GRINDING_HAMMER("iron_grinding_hammer", 1),
    DIAMOND_GRINDING_HAMMER("diamond_grinding_hammer", 1),
    STEEL_GRINDING_HAMMER("steel_grinding_hammer", 1),

    // --- Blower Nozzles ---
    WOOD_BLOWER_NOZZLE("wood_blower_nozzle"),
    STONE_BLOWER_NOZZLE("stone_blower_nozzle"),
    IRON_BLOWER_NOZZLE("iron_blower_nozzle"),
    STEEL_BLOWER_NOZZLE("steel_blower_nozzle");


    private final String name;
    private final int maxStackSize;

    ModItems(String name, int maxStackSize) {
        this.name = name;
        this.maxStackSize = maxStackSize;
    }

    ModItems(String name) {
        this(name, 64);
    }

    public String getName() {
        return name;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }
}