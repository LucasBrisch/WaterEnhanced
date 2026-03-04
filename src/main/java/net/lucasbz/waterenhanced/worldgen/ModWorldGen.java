package net.lucasbz.waterenhanced.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.lucasbz.waterenhanced.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import net.lucasbz.waterenhanced.WaterEnhanced;

public class ModWorldGen {

    private static final RegistryKey<PlacedFeature> CRYSTALLIZED_WATER_ORE_PLACED =
            RegistryKey.of(
                    RegistryKeys.PLACED_FEATURE,
                    Identifier.of(WaterEnhanced.MOD_ID, "crystallized_water_ore")
            );

    public static void bootstrap() {
        BiomeModifications.addFeature(
                BiomeSelectors.tag(ConventionalBiomeTags.IS_OCEAN),
                GenerationStep.Feature.UNDERGROUND_ORES,
                CRYSTALLIZED_WATER_ORE_PLACED
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.tag(ConventionalBiomeTags.IS_OCEAN),
                SpawnGroup.WATER_CREATURE,
                ModEntities.CRYSTAL_FISH,
                8, 2, 6
        );
    }
}