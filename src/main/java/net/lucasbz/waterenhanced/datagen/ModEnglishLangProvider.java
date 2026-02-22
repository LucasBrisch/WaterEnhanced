package net.lucasbz.waterenhanced.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {

    public ModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.waterenhanced.crystallized_water", "Crystallized Water");
        translationBuilder.add("itemgroup.waterenhanced.water_enhanced_group", "Water Enhanced");
        translationBuilder.add("item.waterenhanced.crystallized_water_block", "Crystallized Water Block");
        translationBuilder.add("item.waterenhanced.crystallized_water_ingot", "Crystallized Water Ingot");
        translationBuilder.add("item.waterenhanced.crystallized_water_pickaxe", "Crystallized Water Pickaxe");
        translationBuilder.add("item.waterenhanced.crystallized_water_axe", "Crystallized Water Axe");
        translationBuilder.add("item.waterenhanced.crystallized_water_shovel", "Crystallized Water Shovel");
    }
}