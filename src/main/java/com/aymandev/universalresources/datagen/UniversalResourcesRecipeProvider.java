package com.aymandev.universalresources.datagen;

import com.aymandev.universalresources.UniversalResourcesItems;
import java.util.concurrent.CompletableFuture;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class UniversalResourcesRecipeProvider extends RecipeProvider {
  public UniversalResourcesRecipeProvider(
      PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
    super(output, registries);
  }

  @Override
  protected void buildRecipes(@NotNull RecipeOutput output) {
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.WOOD_PILE.get(), 3)
        .pattern("AAA")
        .pattern("CCC")
        .pattern("AAA")
        .define('A', ItemTags.PLANKS)
        .define('C', ItemTags.LOGS)
        .unlockedBy("has_logs", has(ItemTags.LOGS))
        .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.STONE_PILE.get(), 3)
        .pattern("AAA")
        .pattern("CCC")
        .pattern("AAA")
        .define('A', Items.STONE)
        .define('C', Items.COBBLESTONE)
        .unlockedBy(
            "has_stone_and_cobblestone",
            inventoryTrigger(
                ItemPredicate.Builder.item().of(Items.STONE, Items.COBBLESTONE).build()))
        .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.IRON_PILE.get(), 2)
        .pattern("AAA")
        .pattern("CBC")
        .pattern("AAA")
        .define('A', Items.IRON_NUGGET)
        .define('B', Items.IRON_BLOCK)
        .define('C', Items.IRON_INGOT)
        .unlockedBy(
            "has_iron_ingot",
            inventoryTrigger(
                ItemPredicate.Builder.item().of(Items.IRON_INGOT, Items.IRON_NUGGET).build()))
        .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.RARE_METAL_PILE.get())
        .pattern("AAA")
        .pattern("BDB")
        .pattern("CCC")
        .define('A', Items.IRON_NUGGET)
        .define('B', Items.COPPER_INGOT)
        .define('C', Items.GOLD_NUGGET)
        .define('D', Items.GOLD_BLOCK)
        .unlockedBy(
            "has_rare_metals",
            inventoryTrigger(
                ItemPredicate.Builder.item()
                    .of(Items.IRON_NUGGET, Items.COPPER_INGOT, Items.GOLD_NUGGET)
                    .build()))
        .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.TOOLS_PACK.get())
        .pattern("AAA")
        .pattern("BBB")
        .pattern("CCC")
        .define('A', Items.IRON_NUGGET)
        .define('B', Items.COPPER_INGOT)
        .define('C', Items.GOLD_NUGGET)
        .unlockedBy(
            "has_rare_metals",
            inventoryTrigger(
                ItemPredicate.Builder.item()
                    .of(Items.IRON_NUGGET, Items.COPPER_INGOT, Items.GOLD_NUGGET)
                    .build()))
        .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.UNIVERSAL_PACK.get())
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', Items.GOLD_INGOT)
        .define('B', Items.DIAMOND)
        .unlockedBy(
            "has_gold_and_diamond",
            inventoryTrigger(
                ItemPredicate.Builder.item().of(Items.GOLD_INGOT, Items.DIAMOND).build()))
        .save(output);
  }
}
