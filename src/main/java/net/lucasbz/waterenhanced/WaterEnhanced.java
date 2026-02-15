package net.lucasbz.waterenhanced;

import net.fabricmc.api.ModInitializer;

import net.lucasbz.waterenhanced.block.ModBlocks;
import net.lucasbz.waterenhanced.item.ModItemGroup;
import net.lucasbz.waterenhanced.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaterEnhanced implements ModInitializer {
	public static final String MOD_ID = "waterenhanced";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroup.registerItemGroups();
	}
}