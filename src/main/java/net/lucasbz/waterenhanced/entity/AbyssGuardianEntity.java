package net.lucasbz.waterenhanced.entity;

import net.lucasbz.waterenhanced.WaterEnhanced;
import net.lucasbz.waterenhanced.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class AbyssGuardianEntity extends ElderGuardianEntity {

    public static final RegistryKey<LootTable> LOOT_TABLE_KEY =
            RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(WaterEnhanced.MOD_ID, "entities/abyss_guardian"));

    public AbyssGuardianEntity(EntityType<? extends ElderGuardianEntity> entityType, World world) {
        super(entityType, world);
        this.setPersistent();
        this.setCustomName(Text.translatable("entity.waterenhanced.abyss_guardian"));
        this.setCustomNameVisible(true);
    }

    @Override
    protected void dropLoot(ServerWorld world, DamageSource damageSource, boolean causedByPlayer) {
        dropLoot(world, damageSource, causedByPlayer, LOOT_TABLE_KEY);

        if (causedByPlayer && world.random.nextFloat() < 0.25F && ModItems.ABYSS_CORE != null) {
            this.dropStack(world, new ItemStack(ModItems.ABYSS_CORE));
        }
    }
}

