package net.engelchen.trueelectronics.screen;

import net.engelchen.trueelectronics.TrueElectronics;
import net.engelchen.trueelectronics.screen.custom.AssemblyWorkbenchScreenHandler;
import net.engelchen.trueelectronics.screen.custom.OreProcessingUnitScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<OreProcessingUnitScreenHandler> ORE_PROCESSING_UNIT_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(TrueElectronics.MOD_ID, "ore_processing_screen_handler"),
                    new ExtendedScreenHandlerType<>(OreProcessingUnitScreenHandler::new, BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<AssemblyWorkbenchScreenHandler> ASSEMBLY_WORKBENCH_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(TrueElectronics.MOD_ID, "assembly_workbench_screen_handler"),
                    new ExtendedScreenHandlerType<>(AssemblyWorkbenchScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void registerScreenHandlers() {
        TrueElectronics.LOGGER.info("Registering Screen Handlers for " + TrueElectronics.MOD_ID);
    }
}