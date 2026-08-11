package com.aymandev.universalresources.datagen;

import com.aymandev.universalresources.UniversalResources;
import com.aymandev.universalresources.UniversalResourcesItems;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
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
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.WOOD_PILE.get(), 8)
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', ItemTags.LOGS)
        .define('B', ItemTags.PLANKS)
        .unlockedBy("has_logs", has(ItemTags.LOGS))
        .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.WOOD_PILE.get(), 16)
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', Items.DEEPSLATE)
        .define('B', ItemTags.PLANKS)
        .unlockedBy("has_logs", has(ItemTags.LOGS))
        .save(
            output,
            ResourceLocation.fromNamespaceAndPath(UniversalResources.MODID, "wood_pile_x16"));

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.STONE_PILE.get(), 8)
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', ItemTags.LOGS)
        .define('B', Items.STONE)
        .unlockedBy("has_logs", has(ItemTags.LOGS))
        .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.STONE_PILE.get(), 16)
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', Items.DEEPSLATE)
        .define('B', Items.STONE)
        .unlockedBy("has_logs", has(ItemTags.LOGS))
        .save(
            output,
            ResourceLocation.fromNamespaceAndPath(UniversalResources.MODID, "stone_pile_x16"));

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.IRON_PILE.get(), 8)
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', ItemTags.LOGS)
        .define('B', Items.COPPER_INGOT)
        .unlockedBy("has_logs", has(ItemTags.LOGS))
        .save(output);

    ShapedRecipeBuilder.shaped(
            RecipeCategory.MISC, UniversalResourcesItems.RARE_METAL_PILE.get(), 8)
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', ItemTags.LOGS)
        .define('B', Items.GOLD_INGOT)
        .unlockedBy("has_logs", has(ItemTags.LOGS))
        .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.TOOLS_PACK.get(), 8)
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', ItemTags.LOGS)
        .define('B', Items.IRON_NUGGET)
        .unlockedBy("has_logs", has(ItemTags.LOGS))
        .save(output);

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UniversalResourcesItems.UNIVERSAL_PACK.get())
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', ItemTags.LOGS)
        .define('B', Items.IRON_INGOT)
        .unlockedBy("has_logs", has(ItemTags.LOGS))
        .save(output);

    ShapedRecipeBuilder.shaped(
            RecipeCategory.MISC, UniversalResourcesItems.UNIVERSAL_PACK.get(), 16)
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', ItemTags.LOGS)
        .define('B', Items.IRON_BLOCK)
        .unlockedBy("has_logs", has(ItemTags.LOGS))
        .save(
            output,
            ResourceLocation.fromNamespaceAndPath(UniversalResources.MODID, "universal_pack_x16"));
  }
}
