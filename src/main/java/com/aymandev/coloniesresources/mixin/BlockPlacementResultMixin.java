/**
 * @author KingoSawada
 */
package com.aymandev.coloniesresources.mixin;

import com.aymandev.coloniesresources.ColoniesResources;
import com.ldtteam.structurize.placement.BlockPlacementResult;
import java.util.Collection;
import java.util.List;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockPlacementResult.class)
public class BlockPlacementResultMixin {

  @Shadow @Final private List<ItemStack> requiredItems;

//  @Redirect(
//      method =
//          "<init>(Lnet/minecraft/core/BlockPos;Lcom/ldtteam/structurize/placement/BlockPlacementResult$Result;Ljava/util/List;)V",
//      at = @At(value = "INVOKE", target = "Ljava/util/List;addAll(Ljava/util/Collection;)Z"))
//  private boolean redirectAddAll(List<ItemStack> list, Collection<? extends ItemStack> collection) {
//    list.add(new ItemStack(ColoniesResources.WOOD.asItem(), 3));
//    return false;
//  }
}
