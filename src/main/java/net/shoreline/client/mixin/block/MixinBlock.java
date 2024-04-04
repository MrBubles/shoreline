package net.shoreline.client.mixin.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.shoreline.client.Shoreline;
import net.shoreline.client.impl.event.block.BlockSlipperinessEvent;
import net.shoreline.client.impl.event.entity.VelocityMultiplierEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author linus
 * @since 1.0
 */
@Mixin(Block.class)
public class MixinBlock {
    /**
     * @param cir
     */
    @Inject(method = "getSlipperiness", at = @At(value = "RETURN"),
            cancellable = true)
    private void hookGetSlipperiness(CallbackInfoReturnable<Float> cir) {
        BlockSlipperinessEvent blockSlipperinessEvent =
                new BlockSlipperinessEvent((Block) (Object) this, cir.getReturnValueF());
        Shoreline.EVENT_HANDLER.dispatch(blockSlipperinessEvent);
        if (blockSlipperinessEvent.isCanceled()) {
            cir.cancel();
            cir.setReturnValue(blockSlipperinessEvent.getSlipperiness());
        }
    }

    @Inject(method = "getVelocityMultiplier", at = @At(value = "RETURN"),
            cancellable = true)
    private void hookGetVelocityMultiplier(CallbackInfoReturnable<Float> cir) {
        VelocityMultiplierEvent velocityMultiplierEvent =
                new VelocityMultiplierEvent((Block) (Object) this);
        Shoreline.EVENT_HANDLER.dispatch(velocityMultiplierEvent);
        if (velocityMultiplierEvent.isCanceled()) {
            cir.setReturnValue(Blocks.DIRT.getVelocityMultiplier());
        }
    }
}
