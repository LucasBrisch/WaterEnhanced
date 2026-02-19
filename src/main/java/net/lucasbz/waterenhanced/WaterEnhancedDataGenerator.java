package net.lucasbz.waterenhanced;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.lucasbz.waterenhanced.datagen.ModEnglishLangProvider;
import net.lucasbz.waterenhanced.datagen.ModModelProvider;
import net.lucasbz.waterenhanced.datagen.ModRecipeProvider;

public class WaterEnhancedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModEnglishLangProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
