/**
 * @author KingoSawada
 */
package com.aymandev.coloniesresources.mixin;

import com.aymandev.coloniesresources.ColoniesResources;
import com.ldtteam.structurize.placement.IPlacementContext;
import com.ldtteam.structurize.placement.handlers.placement.DoBlockPlacementHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DoBlockPlacementHandler.class)
public class DoBlockPlacementHandlerMixin {

//  /**
//   * @author
//   * @reason
//   */
//  @Overwrite
//  public List<ItemStack> getRequiredItems(
//      @NotNull final Level world,
//      @NotNull final BlockPos pos,
//      @NotNull final BlockState blockState,
//      @Nullable final CompoundTag tileEntityData,
//      @NotNull final IPlacementContext placementContext) {
//    if (tileEntityData == null) {
//      return Collections.emptyList();
//    }
//
//    var blockpos =
//        new BlockPos(
//            tileEntityData.getInt("x"), tileEntityData.getInt("y"), tileEntityData.getInt("z"));
//    var blockEntity =
//        BlockEntity.loadStatic(blockpos, blockState, tileEntityData, world.registryAccess());
//
//    if (blockEntity == null) {
//      return Collections.emptyList();
//    }
//
//    var itemList = new ArrayList<ItemStack>();
//
//    itemList.add(new ItemStack(ColoniesResources.WOOD.get(), 1));
//
//    return itemList;
//  }
  //
  //  @Unique
  //  private ItemStack coloniesresources$convertToResource(BlockEntity blockEntity) {
  //    if (!(blockEntity instanceof AbstractMateriallyTexturedBlockEntity texturedBlockEntity)) {
  //      return ItemStack.EMPTY;
  //    }
  //
  //    return new ItemStack(ColoniesResources.WOOD.asItem(), 1);
  //  }
}
