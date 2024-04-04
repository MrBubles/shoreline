package net.shoreline.client.mixin.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.shoreline.client.Shoreline;
import net.shoreline.client.impl.event.block.CollisionShapeEvent;
import net.shoreline.client.util.Globals;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author linus
 * @since 1.0
 */
@Mixin(AbstractBlock.AbstractBlockState.class)
public class MixinAbstractBlockState implements Globals {

    @Inject(method = "getCollisionShape(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/ShapeContext;)Lnet/minecraft/util/shape/VoxelShape;", at = @At(value = "RETURN"),
            cancellable = true)
    private void hookGetCollisionShape(BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir) {
        if (Shoreline.EVENT_HANDLER == null || mc.world == null || mc.player == null) return;
        CollisionShapeEvent collisionShapeEvent =
                new CollisionShapeEvent(pos, world.getBlockState(pos), cir.getReturnValue());
        Shoreline.EVENT_HANDLER.dispatch(collisionShapeEvent);
        if (collisionShapeEvent.isCanceled()) {
            cir.setReturnValue(collisionShapeEvent.getVoxelShape());
        }
    }
}
