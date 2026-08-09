package com.aymandev.universalresources.mixin;

import com.aymandev.universalresources.WrappedPlacementHandler;
import com.ldtteam.structurize.placement.handlers.placement.IPlacementHandler;
import com.ldtteam.structurize.placement.handlers.placement.PlacementHandlers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlacementHandlers.class)
public class PlacementHandlersMixin {

  @ModifyVariable(
      method ={
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

    return new WrappedPlacementHandler(handler);
  }
}
