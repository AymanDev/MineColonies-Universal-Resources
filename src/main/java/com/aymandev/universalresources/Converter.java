package com.aymandev.universalresources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class Converter {

  private static final Map<Item, List<? extends String>> ITEM_TO_TAG_LIST_MAP = new HashMap<>();

  static {
    ITEM_TO_TAG_LIST_MAP.put(UniversalResourcesItems.WOOD_PILE.get(), Config.WOOD_ITEMS.get());
    ITEM_TO_TAG_LIST_MAP.put(UniversalResourcesItems.STONE_PILE.get(), Config.STONE_ITEMS.get());
  }

  public static ItemStack getItemForBlock(BlockState blockState) {
    for (var entry : ITEM_TO_TAG_LIST_MAP.entrySet()) {
      var item = entry.getKey();
      var list = entry.getValue();
      var stack = tryToGetItemStackForCategory(item, list, blockState);

      if (stack == null) {
        continue;
      }

      return stack;
    }

    return new ItemStack(UniversalResourcesItems.UNIVERSAL_PACK.get(), 1);
  }

  private static ItemStack tryToGetItemStackForCategory(
      Item itemForCategory, List<? extends String> tagList, BlockState blockState) {

    if (tagList.isEmpty()) {
      return null;
    }

    for (var str : tagList) {
      if (!matches(blockState, str)) {
        continue;
      }

      return new ItemStack(itemForCategory, 1);
    }

    return null;
  }

  private static boolean matches(BlockState blockState, String value) {
    if (value.startsWith("#")) {
      var loc = ResourceLocation.parse(value.substring(1));
      var tag = TagKey.create(BuiltInRegistries.BLOCK.key(), loc);

      return blockState.is(tag);
    }

    var loc = ResourceLocation.parse(value);
    var block = BuiltInRegistries.BLOCK.get(loc);

    return blockState.is(block);
  }
}
