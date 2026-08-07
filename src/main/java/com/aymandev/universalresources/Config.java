package com.aymandev.universalresources;

import java.util.List;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
  private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

  public static final ModConfigSpec.IntValue RESOURCE_SPENT_MODIFIER =
      BUILDER
          .comment("Modifier for how much resources are needed per block")
          .defineInRange("resourceSpendModifier", 1, 0, Integer.MAX_VALUE);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> WOOD_ITEMS =
      BUILDER
          .comment("Items or block tags that are will be as wood resources")
          .defineListAllowEmpty(
              "woodItems",
              List.of(
                  "#" + BlockTags.PLANKS.location(),
                  "#" + BlockTags.LOGS.location(),
                  "#" + BlockTags.SAPLINGS.location(),
                  "#" + BlockTags.ALL_HANGING_SIGNS.location(),
                  "#" + BlockTags.ALL_SIGNS.location(),
                  "#" + BlockTags.BAMBOO_BLOCKS.location(),
                  "#" + BlockTags.WOODEN_BUTTONS.location(),
                  "#" + BlockTags.WOODEN_DOORS.location(),
                  "#" + BlockTags.WOODEN_FENCES.location(),
                  "#" + BlockTags.WOODEN_PRESSURE_PLATES.location(),
                  "#" + BlockTags.WOODEN_SLABS.location(),
                  "#" + BlockTags.WOODEN_STAIRS.location(),
                  "#" + BlockTags.WOODEN_TRAPDOORS.location(),
                  BuiltInRegistries.ITEM.getKey(Items.CRAFTING_TABLE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.CHEST).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.BARREL).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.CRAFTER).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> STONE_ITEMS =
      BUILDER
          .comment("Items or block tags that are will be as stone resources")
          .defineListAllowEmpty(
              "stoneItems",
              List.of(
                  "#" + BlockTags.BASE_STONE_OVERWORLD.location(),
                  "#" + BlockTags.STONE_BRICKS.location(),
                  "#" + BlockTags.STONE_BUTTONS.location(),
                  "#" + BlockTags.STONE_ORE_REPLACEABLES.location(),
                  "#" + BlockTags.STONE_PRESSURE_PLATES.location(),
                  "#" + BlockTags.BASE_STONE_NETHER.location(),
                  "#" + BlockTags.DEEPSLATE_ORE_REPLACEABLES.location(),
                  "#" + BlockTags.SMELTS_TO_GLASS.location(),
                  "#" + BlockTags.DIRT.location(),
                  "#" + BlockTags.SAND.location(),
                  "#" + BlockTags.STAIRS.location(),
                  BuiltInRegistries.ITEM.getKey(Items.FURNACE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.STONE_STAIRS).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> IRON_ITEMS =
      BUILDER
          .comment("Items or block tags that are will be as iron resources")
          .defineListAllowEmpty(
              "ironItems",
              List.of(
                  "#" + BlockTags.IRON_ORES.location(),
                  BuiltInRegistries.ITEM.getKey(Items.IRON_BLOCK).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.CHAIN).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.RAW_IRON).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.IRON_TRAPDOOR).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.IRON_BARS).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.IRON_DOOR).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.HEAVY_WEIGHTED_PRESSURE_PLATE).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> RARE_METAL_ITEMS =
      BUILDER
          .comment("Items or block tags that are will be as rare metals resources")
          .defineListAllowEmpty(
              "rareMetalItems",
              List.of(
                  BuiltInRegistries.ITEM.getKey(Items.LIGHT_WEIGHTED_PRESSURE_PLATE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.GOLD_BLOCK).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.GOLD_ORE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.RAW_GOLD).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.DEEPSLATE_GOLD_ORE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.NETHER_GOLD_ORE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.RAW_GOLD_BLOCK).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> TOOLS_ITEMS =
      BUILDER
          .comment("Items or block tags that are will be as tools resources")
          .defineListAllowEmpty("toolsItems", List.of(), () -> "", Config::validateItemName);

  static final ModConfigSpec SPEC = BUILDER.build();

  private static boolean validateItemName(final Object obj) {
    if (!(obj instanceof String name)) {
      return false;
    }

    if (name.startsWith("#")) {
      var id = ResourceLocation.tryParse(name.substring(1));

      return id != null;
    }

    var id = ResourceLocation.tryParse(name);

    if (id == null) {
      return false;
    }

    return BuiltInRegistries.BLOCK.containsKey(id);
  }
}
