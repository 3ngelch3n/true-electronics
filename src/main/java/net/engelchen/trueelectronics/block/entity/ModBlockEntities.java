/*
 * MIT License
 *
 * Copyright (c) 2024 KaupenJoe
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES, OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.engelchen.trueelectronics.block.entity;

import net.engelchen.trueelectronics.TrueElectronics;
import net.engelchen.trueelectronics.block.ModBlocks;
import net.engelchen.trueelectronics.block.entity.custom.AssemblyWorkbenchBlockEntity;
import net.engelchen.trueelectronics.block.entity.custom.ElectricBlockEntity;
import net.engelchen.trueelectronics.block.entity.custom.OreProcessingUnitBlockEntity;
import net.engelchen.trueelectronics.block.entity.custom.electronics_block.ElectronicsBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlockEntities {
    public static final BlockEntityType<OreProcessingUnitBlockEntity> ORE_PROCESSING_UNIT_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(TrueElectronics.MOD_ID, "ore_processing_unit_be"),
                    BlockEntityType.Builder.create(OreProcessingUnitBlockEntity::new, ModBlocks.ORE_PROCESSING_UNIT).build(null));

    public static final BlockEntityType<AssemblyWorkbenchBlockEntity> ASSEMBLY_WORKBENCH_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(TrueElectronics.MOD_ID, "assembly_workbench_be"),
                    BlockEntityType.Builder.create(AssemblyWorkbenchBlockEntity::new, ModBlocks.ASSEMBLY_WORKBENCH).build(null));

    //public static BlockEntityType<ElectricBlockEntity> ELECTRIC_BLOCK_ENTITY;

    public static final BlockEntityType<ElectricBlockEntity> ELECTRIC_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(TrueElectronics.MOD_ID, "electric_block_be"),
                    BlockEntityType.Builder.create(ElectricBlockEntity::new, ModBlocks.ELECTRIC_BLOCK).build(null));


    //public static BlockEntityType<ElectronicsBlockEntity> ELECTRONICS_BLOCK_ENTITY;


    public static void registerBlockEntities() {
        TrueElectronics.LOGGER.info("Registering Block Entities for " + TrueElectronics.MOD_ID);
    }
}
