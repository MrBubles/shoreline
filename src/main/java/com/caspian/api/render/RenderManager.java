package com.caspian.api.render;

import com.caspian.util.Globals;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;

public class RenderManager implements Globals
{
    //
    public static final Tessellator TESSELLATOR = Tessellator.getInstance();
    public static final BufferBuilder BUFFER = TESSELLATOR.getBuffer();

    public static void renderBox(BlockPos p, int color)
    {

    }

    /**
     *
     *
     * @param box
     * @param width
     * @param color
     */
    public static void renderBoundingBox(Box box, float width, int color)
    {

    }

    /**
     *
     *
     * @param p
     * @param width
     * @param color
     */
    public static void renderBoundingBox(BlockPos p, float width, int color)
    {
        renderBoundingBox(new Box(p), width, color);
    }

    /**
     *
     *
     * @param matrices
     * @param text
     * @param x
     * @param y
     * @param color
     */
    public static void renderText(MatrixStack matrices, String text, float x,
                                  float y, int color)
    {
        mc.textRenderer.drawWithShadow(matrices, text, x, y, color);
    }
}
