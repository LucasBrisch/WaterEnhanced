package net.lucasbz.waterenhanced;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.lucasbz.waterenhanced.block.ModBlocks;
import net.lucasbz.waterenhanced.datagen.*;
import net.lucasbz.waterenhanced.item.ModItemGroup;
import net.lucasbz.waterenhanced.item.ModItems;
import net.lucasbz.waterenhanced.item.WaterToolMaterial;

public class WaterEnhancedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModEnglishLangProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModBrazilianPortugueseLangProvider::new);
	}
}
