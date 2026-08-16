package com.aymandev.universalresources;

import java.util.List;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
  private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

  public static final ModConfigSpec.IntValue RESOURCE_SPENT_MODIFIER =
      BUILDER
          .comment("Modifier for how many resources are needed per block")
          .defineInRange("resourceSpendModifier", 1, 0, Integer.MAX_VALUE);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> WOOD_BLOCKS =
      BUILDER
          .comment("Items or block tags that are will be as wood resources")
          .defineListAllowEmpty(
              "woodBlocks",
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
                  BuiltInRegistries.BLOCK.getKey(Blocks.CRAFTING_TABLE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.TORCH).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.REDSTONE_TORCH).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.SOUL_TORCH).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.WALL_TORCH).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.REDSTONE_WALL_TORCH).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.SOUL_WALL_TORCH).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.CHEST).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.BARREL).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.CRAFTER).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> WOOD_ITEMS =
      BUILDER
          .comment("Items or block tags that are be as wood resources")
          .defineListAllowEmpty(
              "woodItems",
              List.of(
                  "#" + ItemTags.PLANKS.location(),
                  "#" + ItemTags.LOGS.location(),
                  "#" + ItemTags.WOODEN_BUTTONS.location(),
                  "#" + ItemTags.HANGING_SIGNS.location(),
                  "#" + ItemTags.SIGNS.location(),
                  "#" + ItemTags.BAMBOO_BLOCKS.location(),
                  "#" + ItemTags.WOODEN_BUTTONS.location(),
                  "#" + ItemTags.WOODEN_DOORS.location(),
                  "#" + ItemTags.WOODEN_FENCES.location(),
                  "#" + ItemTags.WOODEN_PRESSURE_PLATES.location(),
                  "#" + ItemTags.WOODEN_SLABS.location(),
                  "#" + ItemTags.WOODEN_STAIRS.location(),
                  "#" + ItemTags.WOODEN_TRAPDOORS.location(),
                  BuiltInRegistries.ITEM.getKey(Items.CRAFTING_TABLE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.CHEST).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.BARREL).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.TORCH).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.SOUL_TORCH).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.REDSTONE_TORCH).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.STICK).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.CRAFTER).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> STONE_BLOCKS =
      BUILDER
          .comment("Items or block tags that are be as stone resources")
          .defineListAllowEmpty(
              "stoneBlocks",
              List.of(
                  "#" + BlockTags.BASE_STONE_OVERWORLD.location(),
                  "#" + BlockTags.STONE_BRICKS.location(),
                  "#" + BlockTags.STONE_BUTTONS.location(),
                  "#" + BlockTags.STONE_ORE_REPLACEABLES.location(),
                  "#" + BlockTags.STONE_PRESSURE_PLATES.location(),
                  "#" + BlockTags.BASE_STONE_NETHER.location(),
                  "#" + BlockTags.DEEPSLATE_ORE_REPLACEABLES.location(),
                  "#" + BlockTags.SMELTS_TO_GLASS.location(),
                  "#" + BlockTags.STAIRS.location(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.FURNACE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.ANDESITE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.POLISHED_ANDESITE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.FURNACE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.STONE_STAIRS).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.STONE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.INFESTED_COBBLESTONE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.COBBLESTONE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.COBBLESTONE_SLAB).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.COBBLESTONE_STAIRS).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.COBBLESTONE_WALL).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.MOSSY_COBBLESTONE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.MOSSY_COBBLESTONE_WALL).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.MOSSY_COBBLESTONE_SLAB).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.MOSSY_COBBLESTONE_STAIRS).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> STONE_ITEMS =
      BUILDER
          .comment("Items or block tags that are be as stone resources")
          .defineListAllowEmpty(
              "stoneItems",
              List.of(
                  "#" + ItemTags.STONE_BRICKS.location(),
                  "#" + ItemTags.STONE_BUTTONS.location(),
                  "#" + ItemTags.SLABS.location(),
                  "#" + ItemTags.STAIRS.location(),
                  "#" + ItemTags.COAL_ORES.location(),
                  "#" + ItemTags.SMELTS_TO_GLASS.location(),
                  "#" + ItemTags.DIRT.location(),
                  "#" + ItemTags.SAND.location(),
                  "#" + ItemTags.STAIRS.location(),
                  BuiltInRegistries.ITEM.getKey(Items.FURNACE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.STONE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.INFESTED_COBBLESTONE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.COBBLESTONE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.COBBLESTONE_SLAB).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.COBBLESTONE_STAIRS).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.COBBLESTONE_WALL).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.MOSSY_COBBLESTONE).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.MOSSY_COBBLESTONE_WALL).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.MOSSY_COBBLESTONE_SLAB).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.MOSSY_COBBLESTONE_STAIRS).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> IRON_BLOCKS =
      BUILDER
          .comment("Items or block tags that are be as iron resources")
          .defineListAllowEmpty(
              "ironBlocks",
              List.of(
                  "#" + BlockTags.IRON_ORES.location(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.IRON_BLOCK).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.CHAIN).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.IRON_TRAPDOOR).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.IRON_BARS).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.IRON_DOOR).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> IRON_ITEMS =
      BUILDER
          .comment("Items or block tags that are be as iron resources")
          .defineListAllowEmpty(
              "ironItems",
              List.of(
                  "#" + ItemTags.IRON_ORES.location(),
                  BuiltInRegistries.ITEM.getKey(Items.IRON_BLOCK).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.CHAIN).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.RAW_IRON).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.IRON_TRAPDOOR).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.IRON_BARS).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.IRON_DOOR).toString(),
                  BuiltInRegistries.ITEM.getKey(Items.HEAVY_WEIGHTED_PRESSURE_PLATE).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> RARE_METAL_BLOCKS =
      BUILDER
          .comment("Items or block tags that are be as rare metals resources")
          .defineListAllowEmpty(
              "rareMetalBlocks",
              List.of(
                  BuiltInRegistries.BLOCK.getKey(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.GOLD_BLOCK).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.GOLD_ORE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.DEEPSLATE_GOLD_ORE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.NETHER_GOLD_ORE).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.RAW_GOLD_BLOCK).toString()),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> RARE_METAL_ITEMS =
      BUILDER
          .comment("Items or block tags that are be as rare metals resources")
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
          .comment("Items or block tags that are be as tools resources")
          .defineListAllowEmpty("toolsItems", List.of(), () -> "", Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> FREE_BLOCKS =
      BUILDER
          .comment("Items or block tags that are be as tools resources")
          .defineListAllowEmpty(
              "freeBlocks",
              List.of(
                  "#" + BlockTags.DIRT.location(),
                  "#" + BlockTags.SAND.location(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.DIRT).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.SAND).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.DIRT_PATH).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.GRASS_BLOCK).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.SHORT_GRASS).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.TALL_GRASS).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.SEAGRASS).toString(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.WATER).toString(),
                  "structurize:blockSolidSubstitution".toLowerCase(),
                  "structurize:blockFluidSubstitution".toLowerCase(),
                  "structurize:blockSubstitution".toLowerCase(),
                  "#structurize:blockTagSubstitution".toLowerCase(),
                  BuiltInRegistries.BLOCK.getKey(Blocks.TALL_SEAGRASS).toString()),
              () -> "",
              Config::validateItemName);

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

    if (BuiltInRegistries.BLOCK.containsKey(id)) {
      return true;
    }

    return BuiltInRegistries.ITEM.containsKey(id);
  }
}
