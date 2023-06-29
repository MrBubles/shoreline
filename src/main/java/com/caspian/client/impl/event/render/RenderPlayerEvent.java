package com.caspian.client.impl.event.render;

import com.caspian.client.api.event.Cancelable;
import com.caspian.client.api.event.Event;
import net.minecraft.client.network.AbstractClientPlayerEntity;

/**
 *
 *
 * @author linus
 * @since 1.0
 *
 * @see com.caspian.client.mixin.render.entity.MixinPlayerEntityRenderer
 */
@Cancelable
public class RenderPlayerEvent extends Event
{
    //
    private final AbstractClientPlayerEntity entity;
    //
    private float yaw;
    private float pitch;

    /**
     *
     *
     * @param entity
     */
    public RenderPlayerEvent(AbstractClientPlayerEntity entity)
    {
        this.entity = entity;
    }

    /**
     *
     *
     * @return
     */
    public AbstractClientPlayerEntity getEntity()
    {
        return entity;
    }


    public float getYaw()
    {
        return yaw;
    }

    public float getPitch()
    {
        return pitch;
    }

    public void setYaw(float yaw)
    {
        this.yaw = yaw;
    }

    public void setPitch(float pitch)
    {
        this.pitch = pitch;
    }
}