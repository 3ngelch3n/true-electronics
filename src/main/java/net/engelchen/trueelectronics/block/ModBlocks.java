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
package net.engelchen.trueelectronics.block;

import net.engelchen.trueelectronics.TrueElectronics;
import net.engelchen.trueelectronics.block.custom.AssemblyWorkbenchBlock;
import net.engelchen.trueelectronics.block.custom.ElectricBlock;
import net.engelchen.trueelectronics.block.custom.ElectronicsBlock;
import net.engelchen.trueelectronics.block.custom.OreProcessingUnitBlock;
import net.engelchen.trueelectronics.block.entity.custom.electronics_block.ElectronicsItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.mixin.item.ItemSettingsMixin;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.awt.*;

public class ModBlocks  {

    public static final Block ORE_PROCESSING_UNIT = registerBlock("ore_processing_unit",
            new OreProcessingUnitBlock(AbstractBlock.Settings.create().
                    nonOpaque().
                    strength(4f).requiresTool().
                    sounds(BlockSoundGroup.STONE).
                    mapColor(MapColor.STONE_GRAY).
                    instrument(NoteBlockInstrument.BASEDRUM)));

    public static final Block ASSEMBLY_WORKBENCH = registerBlock("assembly_workbench",
            new AssemblyWorkbenchBlock(AbstractBlock.Settings.create().
                    nonOpaque().
                    strength(2f).requiresTool().
                    sounds(BlockSoundGroup.LANTERN).
                    mapColor(MapColor.BLUE).
                    instrument(NoteBlockInstrument.BASEDRUM)));

    public static final Block ELECTRIC_BLOCK = registerBlock("electric_block",
            new ElectricBlock(AbstractBlock.Settings.create().
                    nonOpaque().
                    noCollision().
                    strength(2f).requiresTool().
                    sounds(BlockSoundGroup.LANTERN).
                    mapColor(MapColor.BLUE).
                    instrument(NoteBlockInstrument.BASEDRUM)));

    //public static final ElectricBlock ELECTRIC_BLOCK = new ElectricBlock(AbstractBlock.Settings.create()
    //        .nonOpaque().dynamicBounds().hardness(3.0f));

    /*public static final ElectronicsBlock ELECTRONICS_BLOCK = new ElectronicsBlock(AbstractBlock.Settings.create()
            .nonOpaque().dynamicBounds().hardness(4.0f).
            luminance(s -> s.get(ElectronicsBlock.LIGHT_LEVEL)));

    public static final BlockItem ELECTRONICS_BLOCK_ITEM = new BlockItem(ELECTRONICS_BLOCK, new Item.Settings());

    public static final ElectronicsItem ELECTRONICS_ITEM = new ElectronicsItem(new Item.Settings().maxCount(256));
*/
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TrueElectronics.MOD_ID, name), block);
    }



    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TrueElectronics.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TrueElectronics.LOGGER.info("Registering Mod Blocks for " + TrueElectronics.MOD_ID);

    }
}
