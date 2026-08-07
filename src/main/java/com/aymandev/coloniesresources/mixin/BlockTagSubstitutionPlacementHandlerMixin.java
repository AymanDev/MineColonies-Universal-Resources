/**
 * @author KingoSawada
 */
package com.aymandev.coloniesresources.mixin;

import com.aymandev.coloniesresources.ColoniesResources;
import com.ldtteam.structurize.placement.IPlacementContext;
import com.ldtteam.structurize.placement.handlers.placement.DoBlockPlacementHandler;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DoBlockPlacementHandler.class)
public class BlockTagSubstitutionPlacementHandlerMixin {

//  @Inject(method = "getRequiredItems", at = @At("RETURN"), cancellable = true)
//  public void getRequiredItems(
//      @NotNull final Level world,
//      @NotNull final BlockPos pos,
//      @NotNull final BlockState blockState,
//      @Nullable final CompoundTag tileEntityData,
//      @NotNull final IPlacementContext placementContext,
//      CallbackInfoReturnable<List<ItemStack>> cb) {
//
//    var result = cb.getReturnValue();
//
//    if (result.isEmpty()) {
//      return;
//    }
//
//
//    result.clear();
//    result.add(new ItemStack(ColoniesResources.WOOD.asItem(), 10));
//  }
}
