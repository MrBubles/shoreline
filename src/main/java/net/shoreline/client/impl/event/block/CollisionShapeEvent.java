package net.shoreline.client.impl.event.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.shoreline.client.api.event.Cancelable;
import net.shoreline.client.api.event.Event;

/**
 * @author linus
 * @since 1.0
 */
@Cancelable
public class CollisionShapeEvent extends Event {
    //
    private final BlockPos pos;
    private final BlockState state;
    private VoxelShape voxelShape;

    public CollisionShapeEvent(BlockPos pos, BlockState state, VoxelShape voxelShape) {
        this.pos = pos;
        this.state = state;
        this.voxelShape = voxelShape;
    }

    /**
     * @return
     */
    public BlockState getState() {
        return state;
    }

    /**
     * @return
     */
    public VoxelShape getVoxelShape() {
        return voxelShape;
    }

    /**
     * @param voxelShape
     */
    public void setVoxelShape(VoxelShape voxelShape) {
        this.voxelShape = voxelShape;
    }

    public BlockPos getPos() {
        return pos;
    }
}
