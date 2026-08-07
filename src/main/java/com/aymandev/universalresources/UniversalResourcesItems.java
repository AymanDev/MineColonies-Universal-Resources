package com.aymandev.universalresources;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UniversalResourcesItems {
  public static final DeferredRegister.Items ITEMS =
      DeferredRegister.createItems(UniversalResources.MODID);

  public static final DeferredItem<Item> WOOD_PILE = ITEMS.registerSimpleItem("wood_pile");
  public static final DeferredItem<Item> STONE_PILE = ITEMS.registerSimpleItem("stone_pile");
  public static final DeferredItem<Item> IRON_PILE = ITEMS.registerSimpleItem("iron_pile");
  public static final DeferredItem<Item> RARE_METAL_PILE =
      ITEMS.registerSimpleItem("rare_metals_pile");
  public static final DeferredItem<Item> TOOLS_PACK = ITEMS.registerSimpleItem("tools_pack");
  public static final DeferredItem<Item> UNIVERSAL_PACK =
      ITEMS.registerSimpleItem("universal_pack");

  public static void register(IEventBus modEventBus) {
    ITEMS.register(modEventBus);
  }

  public static void addToCreative(BuildCreativeModeTabContentsEvent event) {
    if (event.getTab() != UniversalResourcesTabs.UNIVERSAL_RESOURCES_TAB.get()) {
      return;
    }

    event.accept(WOOD_PILE);
    event.accept(STONE_PILE);
    event.accept(IRON_PILE);
    event.accept(RARE_METAL_PILE);
    event.accept(TOOLS_PACK);
    event.accept(UNIVERSAL_PACK);
  }
}
