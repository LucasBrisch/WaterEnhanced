package net.lucasbz.waterenhanced.entity;

import net.lucasbz.waterenhanced.WaterEnhanced;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.CodEntity;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CrystalFishEntity extends CodEntity {

    public static final RegistryKey<LootTable> LOOT_TABLE_KEY =
            RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(WaterEnhanced.MOD_ID, "entities/crystal_fish"));

    public CrystalFishEntity(EntityType<? extends CodEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void dropLoot(ServerWorld world, DamageSource damageSource, boolean causedByPlayer) {
        dropLoot(world, damageSource, causedByPlayer, LOOT_TABLE_KEY);
    }
}
