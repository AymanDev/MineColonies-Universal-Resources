package com.aymandev.universalresources;

import com.ldtteam.domumornamentum.block.IMateriallyTexturedBlock;
import com.ldtteam.domumornamentum.recipe.architectscutter.ArchitectsCutterRecipe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class Converter {

  private static final Map<Item, List<? extends String>> ITEM_TO_TAG_LIST_MAP = new HashMap<>();

  static {
    ITEM_TO_TAG_LIST_MAP.put(UniversalResourcesItems.TOOLS_PACK.get(), Config.TOOLS_ITEMS.get());
    ITEM_TO_TAG_LIST_MAP.put(
        UniversalResourcesItems.RARE_METAL_PILE.get(), Config.RARE_METAL_BLOCKS.get());
    ITEM_TO_TAG_LIST_MAP.put(UniversalResourcesItems.IRON_PILE.get(), Config.IRON_BLOCKS.get());
    ITEM_TO_TAG_LIST_MAP.put(UniversalResourcesItems.STONE_PILE.get(), Config.STONE_BLOCKS.get());
    ITEM_TO_TAG_LIST_MAP.put(UniversalResourcesItems.WOOD_PILE.get(), Config.WOOD_BLOCKS.get());
  }

  public static ItemStack getItemForBlock(Level level, BlockState blockState) {
    if (blockState.isAir() || isFree(blockState)) {
      return new ItemStack(Items.AIR);
    }

    for (var entry : ITEM_TO_TAG_LIST_MAP.entrySet()) {
      var item = entry.getKey();
      var list = entry.getValue();
      var stack = tryToGetItemStackForCategory(item, list, blockState);

      if (stack == null) {
        continue;
      }

      return stack;
    }

    var block = blockState.getBlock();

    if (isBlockCraftableWith(level, block, getIngredientFromConfig(Config.WOOD_ITEMS.get()))) {
      return new ItemStack(UniversalResourcesItems.WOOD_PILE.get());
    }

    if (isBlockCraftableWith(level, block, getIngredientFromConfig(Config.STONE_ITEMS.get()))) {
      return new ItemStack(UniversalResourcesItems.STONE_PILE.get());
    }

    if (isBlockCraftableWith(level, block, getIngredientFromConfig(Config.IRON_ITEMS.get()))) {
      return new ItemStack(UniversalResourcesItems.IRON_PILE.get());
    }

    if (isBlockCraftableWith(level, block, getIngredientFromConfig(Config.TOOLS_ITEMS.get()))) {
      return new ItemStack(UniversalResourcesItems.TOOLS_PACK.get());
    }

    if (isBlockCraftableWith(
        level, block, getIngredientFromConfig(Config.RARE_METAL_ITEMS.get()))) {
      return new ItemStack(UniversalResourcesItems.RARE_METAL_PILE.get());
    }

    UniversalResources.LOGGER.info(
        "{} does not have configured conversion in config. Fallback to universal bag", block);

    return getDefaultItem();
  }

  private static ItemStack getDefaultItem() {
    return new ItemStack(UniversalResourcesItems.UNIVERSAL_PACK.get(), 1);
  }

  private static boolean isFree(BlockState blockState) {
    if (Config.FREE_BLOCKS.get().isEmpty()) {
      return false;
    }

    for (var str : Config.FREE_BLOCKS.get()) {
      if (matches(blockState, str)) {
        return true;
      }
    }

    return false;
  }

  private static ItemStack tryToGetItemStackForCategory(
      Item itemForCategory, List<? extends String> tagList, BlockState blockState) {

    if (tagList.isEmpty()) {
      return null;
    }

    for (var str : tagList) {
      if (matches(blockState, str)) {
        return new ItemStack(itemForCategory, 1);
      }
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

  private static Ingredient getIngredientFromConfig(List<? extends String> strList) {
    var list = new ArrayList<Ingredient.Value>();

    for (var str : strList) {
      if (str.startsWith("#")) {
        var loc = ResourceLocation.parse(str.substring(1));
        var tag = TagKey.create(BuiltInRegistries.ITEM.key(), loc);

        list.add(new Ingredient.TagValue(tag));
        continue;
      }

      var loc = ResourceLocation.parse(str);
      var item = BuiltInRegistries.ITEM.get(loc);

      list.add(new Ingredient.ItemValue(new ItemStack(item)));
    }

    return Ingredient.fromValues(list.stream());
  }

  private static boolean isBlockCraftableWith(
      Level level, Block block, Ingredient requiredIngredient) {

    var item = block.asItem();

    for (var holder : level.getRecipeManager().getRecipes()) {
      var recipe = holder.value();

      var result = recipe.getResultItem(level.registryAccess());
      if (!result.is(item)) {
        continue;
      }

      if (recipe instanceof ArchitectsCutterRecipe cutterRecipe) {
        return architectsCutterContainsIngredient(cutterRecipe, requiredIngredient);
      }

      for (var ingredient : recipe.getIngredients()) {
        if (containsIngredient(ingredient, requiredIngredient)) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean containsIngredient(
      Ingredient recipeIngredient, Ingredient requiredIngredient) {
    for (var stack : recipeIngredient.getItems()) {
      if (requiredIngredient.test(stack)) {
        return true;
      }
    }

    return false;
  }

  private static boolean architectsCutterContainsIngredient(
      ArchitectsCutterRecipe recipe, Ingredient requiredIngredient) {
    var output = recipe.getBlock();

    if (!(output instanceof IMateriallyTexturedBlock textured)) {
      return false;
    }

    for (var component : textured.getComponents()) {
      var validSkins = component.getValidSkins();

      for (var stack : requiredIngredient.getItems()) {
        if (!(stack.getItem() instanceof BlockItem item)) {
          continue;
        }

        if (item.getBlock().defaultBlockState().is(validSkins)) {
          return true;
        }
      }
    }

    return false;
  }
}
