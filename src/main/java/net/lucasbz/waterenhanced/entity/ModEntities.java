package net.lucasbz.waterenhanced.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.lucasbz.waterenhanced.WaterEnhanced;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final RegistryKey<EntityType<?>> CRYSTAL_FISH_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(WaterEnhanced.MOD_ID, "crystal_fish"));

    public static final EntityType<CrystalFishEntity> CRYSTAL_FISH = Registry.register(
            Registries.ENTITY_TYPE,
            CRYSTAL_FISH_KEY,
            EntityType.Builder.create(CrystalFishEntity::new, SpawnGroup.WATER_CREATURE)
                    .dimensions(0.5f, 0.3f)
                    .build(CRYSTAL_FISH_KEY)
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(CRYSTAL_FISH, FishEntity.createFishAttributes());
        WaterEnhanced.LOGGER.info("Registering Mod Entities for " + WaterEnhanced.MOD_ID);
    }
}
