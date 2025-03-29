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
package net.engelchen.trueelectronics.item;

import net.engelchen.trueelectronics.TrueElectronics;
import net.engelchen.trueelectronics.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup TRUE_ELECTRONICS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TrueElectronics.MOD_ID, "true_electronics_item"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.COPPER_WIRE))
                    .displayName(Text.translatable("itemgroup.true-electronics.true_electronics_item"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.SILICON_WAFER);
                      entries.add(ModItems.GOLDEN_CONDUCTOR_TRACKS);
                      entries.add(ModItems.COPPER_WIRE);
                      entries.add(ModBlocks.ORE_PROCESSING_UNIT);
                      entries.add(ModBlocks.ASSEMBLY_WORKBENCH);
                    }).build());


    public static void registerItemGroups() {
        TrueElectronics.LOGGER.info("Registering Item Groups for " + TrueElectronics.MOD_ID);
    }
}
