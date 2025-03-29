package net.engelchen.trueelectronics;

import net.engelchen.trueelectronics.block.ModBlocks;
import net.engelchen.trueelectronics.block.entity.ModBlockEntities;
import net.engelchen.trueelectronics.item.ModItemGroup;
import net.engelchen.trueelectronics.item.ModItems;
import net.engelchen.trueelectronics.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueElectronics implements ModInitializer {
	public static final String MOD_ID = "true-electronics";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}
}