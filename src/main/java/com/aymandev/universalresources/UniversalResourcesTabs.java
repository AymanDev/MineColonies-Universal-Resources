package com.aymandev.universalresources;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UniversalResourcesTabs {

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UniversalResources.MODID);

  public static final DeferredHolder<CreativeModeTab, CreativeModeTab> UNIVERSAL_RESOURCES_TAB =
      CREATIVE_MODE_TABS.register(
          "universal_resources_tab",
          () ->
              CreativeModeTab.builder()
                  .title(Component.translatable("itemGroup.universal_resources"))
                  .withTabsBefore(CreativeModeTabs.COMBAT)
                  .icon(() -> UniversalResourcesItems.WOOD_PILE.get().getDefaultInstance())
                  .build());

  public static void register(IEventBus modEventBus) {
    CREATIVE_MODE_TABS.register(modEventBus);
  }
}
