package com.aymandev.universalresources;

import java.util.List;
import java.util.stream.Stream;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
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
              Stream.of(
                      BlockTags.PLANKS.location().toString(),
                      BlockTags.LOGS.location().toString(),
                      BlockTags.SAPLINGS.location().toString(),
                      BlockTags.ALL_HANGING_SIGNS.location().toString(),
                      BlockTags.ALL_SIGNS.location().toString(),
                      BlockTags.BAMBOO_BLOCKS.location().toString(),
                      BlockTags.WOODEN_BUTTONS.location().toString(),
                      BlockTags.WOODEN_DOORS.location().toString(),
                      BlockTags.WOODEN_FENCES.location().toString(),
                      BlockTags.WOODEN_PRESSURE_PLATES.location().toString(),
                      BlockTags.WOODEN_SLABS.location().toString(),
                      BlockTags.WOODEN_STAIRS.location().toString(),
                      BlockTags.WOODEN_TRAPDOORS.location().toString())
                  .map(t -> "#" + t)
                  .toList(),
              () -> "",
              Config::validateItemName);

  public static final ModConfigSpec.ConfigValue<List<? extends String>> STONE_ITEMS =
      BUILDER
          .comment("Items or block tags that are will be as stone resources")
          .defineListAllowEmpty(
              "stoneItems",
              Stream.of(
                      BlockTags.BASE_STONE_OVERWORLD.location().toString(),
                      BlockTags.STONE_BRICKS.location().toString(),
                      BlockTags.STONE_BUTTONS.location().toString(),
                      BlockTags.STONE_ORE_REPLACEABLES.location().toString(),
                      BlockTags.STONE_PRESSURE_PLATES.location().toString(),
                      BlockTags.BASE_STONE_NETHER.location().toString(),
                      BlockTags.DEEPSLATE_ORE_REPLACEABLES.location().toString(),
                      BlockTags.SMELTS_TO_GLASS.location().toString(),
                      BlockTags.DIRT.location().toString(),
                      BlockTags.SAND.location().toString())
                  .map(t -> "#" + t)
                  .toList(),
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

    return BuiltInRegistries.BLOCK.containsKey(id);
  }
}
