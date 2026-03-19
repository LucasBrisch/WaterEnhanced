package net.lucasbz.waterenhanced.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.lucasbz.waterenhanced.WaterEnhanced;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.attribute.EntityAttributes;
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

    public static final RegistryKey<EntityType<?>> ABYSS_GUARDIAN_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(WaterEnhanced.MOD_ID, "abyss_guardian"));

    public static final EntityType<AbyssGuardianEntity> ABYSS_GUARDIAN = Registry.register(
            Registries.ENTITY_TYPE,
            ABYSS_GUARDIAN_KEY,
            EntityType.Builder.create(AbyssGuardianEntity::new, SpawnGroup.MONSTER)
                    // Increase both collision and visual scale consistency.
                    .dimensions(2.5f, 2.5f)
                    .eyeHeight(1.85f)
                    .build(ABYSS_GUARDIAN_KEY)
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(CRYSTAL_FISH, FishEntity.createFishAttributes());
        FabricDefaultAttributeRegistry.register(ABYSS_GUARDIAN,
                GuardianEntity.createGuardianAttributes()
                        .add(EntityAttributes.MAX_HEALTH, 200.0D)
                        .add(EntityAttributes.ATTACK_DAMAGE, 12.0D)
        );
        WaterEnhanced.LOGGER.info("Registering Mod Entities for " + WaterEnhanced.MOD_ID);
    }
}
