package net.engelchen.trueelectronics.block.entity.custom.electronics_block;

import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.BakedQuad;

public interface CubeRenderHelper {
    BakedQuad[] getQuads(int direction);

    RenderMaterial[] getMaterials(int direction);

    public static CubeRenderHelper of(BlockState state) {
        return (CubeRenderHelper) state;
    }
}
