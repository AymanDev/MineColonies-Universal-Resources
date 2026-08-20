package com.aymandev.universalresources.mixin;

import com.aymandev.universalresources.UniversalResources;
import com.aymandev.universalresources.WrappedPlacementHandler;
import com.ldtteam.structurize.placement.handlers.placement.IPlacementHandler;
import com.ldtteam.structurize.placement.handlers.placement.PlacementHandlers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(
    value = {PlacementHandlers.class},
    priority = 2000)
public class PlacementHandlersMixin {

  @ModifyVariable(
      method = {
        "add(Lcom/ldtteam/structurize/placement/handlers/placement/IPlacementHandler;)V",
        "add(Lcom/ldtteam/structurize/placement/handlers/placement/IPlacementHandler;Ljava/lang/Class;)V",
        "add(Lcom/ldtteam/structurize/placement/handlers/placement/IPlacementHandler;Ljava/lang/Class;Lcom/ldtteam/structurize/placement/handlers/placement/PlacementHandlers$AddType;)V"
      },
      at = @At("HEAD"),
      argsOnly = true)
  private static IPlacementHandler add(IPlacementHandler handler) {
    return universalresources$wrap(handler);
  }

  @Unique
  private static IPlacementHandler universalresources$wrap(IPlacementHandler handler) {
    if (handler instanceof WrappedPlacementHandler) {
      return handler;
    }

      UniversalResources.LOGGER.info("Wrapping placement handler: {}", handler);
    return new WrappedPlacementHandler(handler);
  }
}
