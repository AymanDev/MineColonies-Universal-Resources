package com.aymandev.universalresources;

import com.ldtteam.structurize.placement.IPlacementContext;
import com.ldtteam.structurize.placement.handlers.placement.IPlacementHandler;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WrappedPlacementHandler implements IPlacementHandler {

  private final IPlacementHandler delegate;

  public WrappedPlacementHandler(IPlacementHandler delegate) {
    this.delegate = delegate;
  }

  @Override
  public boolean canHandle(Level level, BlockPos blockPos, BlockState blockState) {
    return delegate.canHandle(level, blockPos, blockState);
  }

  @Override
  public ActionProcessingResult handle(
      Level level,
      BlockPos blockPos,
      BlockState blockState,
      @Nullable CompoundTag compoundTag,
      @NotNull IPlacementContext iPlacementContext) {
    return delegate.handle(level, blockPos, blockState, compoundTag, iPlacementContext);
  }

  @Override
  public List<ItemStack> getRequiredItems(
      Level level,
      BlockPos blockPos,
      BlockState blockState,
      @Nullable CompoundTag compoundTag,
      @NotNull IPlacementContext iPlacementContext) {
    var stack = Converter.getItemForBlock(blockState);
    stack.setCount(stack.getCount() * Config.RESOURCE_SPENT_MODIFIER.get());

    return List.of(stack);
  }

  @Override
  public boolean doesWorldStateMatchBlueprintState(
      BlockState blockState,
      BlockState blockState1,
      @Nullable Tuple<BlockEntity, CompoundTag> tuple,
      @NotNull IPlacementContext iPlacementContext) {
    return delegate.doesWorldStateMatchBlueprintState(
        blockState, blockState1, tuple, iPlacementContext);
  }
}
