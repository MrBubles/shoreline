package net.shoreline.client.impl.event.entity;

import net.minecraft.block.Block;
import net.shoreline.client.api.event.Cancelable;
import net.shoreline.client.api.event.Event;

/**
 * @author linus
 * @since 1.0
 */
@Cancelable
public class VelocityMultiplierEvent extends Event {
    //
    private final Block block;

    /**
     * @param block
     */
    public VelocityMultiplierEvent(Block block) {
        this.block = block;
    }

    /**
     * @return
     */
    public Block getBlock() {
        return block;
    }
}
