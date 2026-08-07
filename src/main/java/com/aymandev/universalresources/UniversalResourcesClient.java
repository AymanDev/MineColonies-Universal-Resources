package com.aymandev.universalresources;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = UniversalResources.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = UniversalResources.MODID, value = Dist.CLIENT)
public class UniversalResourcesClient {
    public UniversalResourcesClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    private static void onClientSetup(FMLClientSetupEvent event) {
    }
}
