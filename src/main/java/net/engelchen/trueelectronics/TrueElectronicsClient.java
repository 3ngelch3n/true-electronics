package net.engelchen.trueelectronics;

import net.engelchen.trueelectronics.block.entity.ModBlockEntities;
import net.engelchen.trueelectronics.block.entity.renderer.ElectricBlockRenderer;
import net.engelchen.trueelectronics.block.entity.renderer.OreProcessingUnitBlockRenderer;
import net.engelchen.trueelectronics.screen.ModScreenHandlers;
import net.engelchen.trueelectronics.screen.custom.AssemblyWorkbenchScreen;
import net.engelchen.trueelectronics.screen.custom.OreProcessingUnitScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class TrueElectronicsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        RegisterScreens();

    }


    void RegisterScreens() {
        HandledScreens.register(ModScreenHandlers.ORE_PROCESSING_UNIT_SCREEN_HANDLER, OreProcessingUnitScreen::new);
        HandledScreens.register(ModScreenHandlers.ASSEMBLY_WORKBENCH_SCREEN_HANDLER, AssemblyWorkbenchScreen::new);


        BlockEntityRendererFactories.register(ModBlockEntities.ELECTRIC_BLOCK_ENTITY, ElectricBlockRenderer::new);
    }
}
