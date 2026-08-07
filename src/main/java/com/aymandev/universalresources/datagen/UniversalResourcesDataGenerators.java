package com.aymandev.universalresources.datagen;

import com.aymandev.universalresources.UniversalResources;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = UniversalResources.MODID)
public class UniversalResourcesDataGenerators {

  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    var generator = event.getGenerator();
    var output = generator.getPackOutput();

    var lookup = event.getLookupProvider();

    generator.addProvider(
        event.includeServer(), new UniversalResourcesRecipeProvider(output, lookup));
  }
}
