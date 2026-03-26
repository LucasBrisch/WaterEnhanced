package net.lucasbz.waterenhanced.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class ModBrazilianPortugueseLangProvider extends FabricLanguageProvider {

    public ModBrazilianPortugueseLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "pt_br", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.waterenhanced.crystallized_water", "Água Cristalizada");
        translationBuilder.add("itemgroup.waterenhanced.water_enhanced_group", "Water Enhanced");
        translationBuilder.add("item.waterenhanced.crystallized_water_block", "Bloco de Água Cristalizada");
        translationBuilder.add("item.waterenhanced.crystallized_water_ingot", "Lingote de Água Cristalizada");
        translationBuilder.add("item.waterenhanced.crystallized_water_pickaxe", "Picareta de Água Cristalizada");
        translationBuilder.add("item.waterenhanced.crystallized_water_axe", "Machado de Água Cristalizada");
        translationBuilder.add("item.waterenhanced.crystallized_water_shovel", "Pá de Água Cristalizada");
        translationBuilder.add("item.waterenhanced.crystallized_water_sword", "Espada de Água Cristalizada");
        translationBuilder.add("item.waterenhanced.crystallized_water_ore", "Minério de Água Cristalizada");
        translationBuilder.add("item.waterenhanced.crystallized_water_helmet", "Capacete de Água Cristalizada");
        translationBuilder.add("item.waterenhanced.crystallized_water_chestplate", "Peitoral de Água Cristalizada");
        translationBuilder.add("item.waterenhanced.crystallized_water_leggings", "Calças de Água Cristalizada");
        translationBuilder.add("item.waterenhanced.crystallized_water_boots", "Botas de Água Cristalizada");

        translationBuilder.add("tooltip.waterenhanced.charges", "Cargas: %s/%s");

        translationBuilder.add("entity.waterenhanced.crystal_fish", "Peixe de Cristal");
        translationBuilder.add("entity.waterenhanced.abyss_guardian", "Guardião do Abismo");
        translationBuilder.add("item.waterenhanced.abyss_core", "Núcleo do Abismo");
    }
}