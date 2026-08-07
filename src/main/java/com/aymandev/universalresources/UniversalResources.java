package com.aymandev.universalresources;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(UniversalResources.MODID)
public class UniversalResources {
  public static final String MODID = "universal_resources";
  public static final Logger LOGGER = LogUtils.getLogger();
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

  public UniversalResources(IEventBus modEventBus, ModContainer modContainer) {
    modEventBus.addListener(this::commonSetup);
    modEventBus.addListener(this::onLoadComplete);

    BLOCKS.register(modEventBus);
    UniversalResourcesItems.register(modEventBus);
    UniversalResourcesTabs.register(modEventBus);

    modEventBus.addListener(UniversalResourcesItems::addToCreative);
    modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(FMLCommonSetupEvent event) {}

  private void onLoadComplete(FMLLoadCompleteEvent event) {
    if (!System.getProperty("neoforge.datagen", "").isEmpty()) {
      return;
    }

    PlacementHandlerOverrider.init();
  }
}
