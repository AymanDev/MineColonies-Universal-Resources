/**
 * @author KingoSawada
 */
package com.aymandev.coloniesresources.mixin;

import com.aymandev.coloniesresources.ColoniesResources;
import com.ldtteam.structurize.placement.IPlacementContext;
import java.util.ArrayList;
import java.util.List;

import com.minecolonies.core.placementhandlers.GeneralBlockPlacementHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GeneralBlockPlacementHandler.class)
public class GeneralBlockPlacementHandlerMixin {
//  /**
//   * @author
//   * @reason
//   */
//  @Overwrite
//  public List<ItemStack> getRequiredItems(
//      final Level world,
//      final BlockPos pos,
//      final BlockState blockState,
//      @Nullable final CompoundTag tileEntityData,
//      final IPlacementContext placementContext) {
//    var list = new ArrayList<ItemStack>();
//    list.add(new ItemStack(ColoniesResources.WOOD.get(), 1));
//
//    return list;
//  }
}
