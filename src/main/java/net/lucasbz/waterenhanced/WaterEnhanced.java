package net.lucasbz.waterenhanced;

import net.fabricmc.api.ModInitializer;

import net.lucasbz.waterenhanced.block.ModBlocks;
import net.lucasbz.waterenhanced.entity.AbyssGuardianSpawnHandler;
import net.lucasbz.waterenhanced.entity.ModEntities;
import net.lucasbz.waterenhanced.item.ModItemGroup;
import net.lucasbz.waterenhanced.item.ModItems;
import net.lucasbz.waterenhanced.item.WaterToolMaterial;
import net.lucasbz.waterenhanced.worldgen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaterEnhanced implements ModInitializer {
	public static final String MOD_ID = "waterenhanced";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.register();
		AbyssGuardianSpawnHandler.register();
		ModItemGroup.registerItemGroups();
		ModWorldGen.bootstrap();
	}
}