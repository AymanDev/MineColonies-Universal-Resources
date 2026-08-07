/**
 * @author KingoSawada
 */
package com.aymandev.coloniesresources.mixin;

import com.aymandev.coloniesresources.ColoniesResources;
import com.ldtteam.structurize.placement.BlockPlacementResult;
import com.ldtteam.structurize.placement.StructurePlacer;
import java.util.ArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StructurePlacer.class)
public class StructurePlacerMixin {

//  @Inject(method = "getResourceRequirements", at = @At("RETURN"), cancellable = true)
//  public void getResourceRequirements(
//      Level world,
//      BlockPos worldPos,
//      BlockPos localPos,
//      BlockState localState,
//      CompoundTag tileEntityData,
//      CallbackInfoReturnable<BlockPlacementResult> cb) {
//    var result = cb.getReturnValue();
//
//    if (result.getResult() != BlockPlacementResult.Result.MISSING_ITEMS) {
//      return;
//    }
//
//    var requiredItems = new ArrayList<ItemStack>();
//
//    requiredItems.add(new ItemStack(ColoniesResources.WOOD.get(), 1));
//
//    cb.setReturnValue(
//        new BlockPlacementResult(
//            worldPos, BlockPlacementResult.Result.MISSING_ITEMS, requiredItems));
//  }
}
