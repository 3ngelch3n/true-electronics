package net.engelchen.trueelectronics.block.entity.renderer;

import net.engelchen.trueelectronics.block.entity.custom.ElectricBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ElectricBlockRenderer implements BlockEntityRenderer<ElectricBlockEntity> {


    public ElectricBlockRenderer(BlockEntityRendererFactory.Context context) {
    }


    @Override
    public void render(ElectricBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        assert MinecraftClient.getInstance().player != null;
        if (entity.getPos().isWithinDistance(MinecraftClient.getInstance().player.getPos(), 16)) {


            ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
            Map<Byte, ItemStack> cableItems = new HashMap<>();
            cableItems.put((byte) 1, new ItemStack(Items.RED_WOOL));
            cableItems.put((byte) 2, new ItemStack(Items.BLUE_WOOL));
            cableItems.put((byte) 3, new ItemStack(Items.GREEN_WOOL));
            cableItems.put((byte) 4, new ItemStack(Items.YELLOW_WOOL));
            cableItems.put((byte) 5, new ItemStack(Items.GRAY_WOOL));

            byte[][][] thisCable = entity.getCable();

            for (int x = 0; x < 16; x++) {
                for (int y = 0; y < 16; y++) {
                    for (int z = 0; z < 16; z++) {

                        byte cable = thisCable[x][y][z];

                        if (cable != 0) {
                            ItemStack stack = cableItems.get(cable);

                            matrices.push();

                            matrices.translate(
                                    (x + 0.5f) / 16,
                                    (y + 0.5f) / 16,
                                    (z + 0.5f) / 16
                            );

                            matrices.scale(0.125f, 0.125f, 0.125f);

                            if (stack != null && !stack.isEmpty()) {

                                itemRenderer.renderItem(stack, ModelTransformationMode.FIXED,
                                        getLightLevel(Objects.requireNonNull(entity.getWorld()), entity.getPos()),
                                        OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
                            }

                            matrices.pop();
                        }
                    }
                }
            }
        }
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
