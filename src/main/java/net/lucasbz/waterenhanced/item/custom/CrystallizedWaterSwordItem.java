package net.lucasbz.waterenhanced.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.StyleSpriteSource;
import net.minecraft.text.Text;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Box;

import java.util.List;

import java.util.function.Consumer;


public class CrystallizedWaterSwordItem extends Item {

    public CrystallizedWaterSwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.sword(material, attackDamage, attackSpeed));
    }

    private static final String HIT_COUNTER_KEY = "HitCounter";

    private int getHitCounter(ItemStack stack) {
        NbtComponent customData = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);
        NbtCompound nbt = customData.copyNbt();

        return nbt.getInt(HIT_COUNTER_KEY).orElse(0);
    }

    private void setHitCounter(ItemStack stack, int value) {
        NbtComponent customData = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);
        NbtCompound nbt = customData.copyNbt();

        nbt.putInt(HIT_COUNTER_KEY, value);
        stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
    }

    private void spawnWaterShockwave(ServerWorld world, double x, double y, double z) {
        double[] radii = {1.2, 2.0, 2.8};
        int points = 48;

        for (double radius : radii) {
            for (int i = 0; i < points; i++) {
                double angle = (2 * Math.PI) * i / points;
                double px = x + Math.cos(angle) * radius;
                double pz = z + Math.sin(angle) * radius;

                world.spawnParticles(ParticleTypes.SPLASH, px, y, pz, 1, 0, 0, 0, 0.02);
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent,
                              Consumer<Text> textConsumer, TooltipType type) {
        int hits = getHitCounter(stack);
        textConsumer.accept(Text.translatable(
                "tooltip.waterenhanced.charges",
                hits, 3
        ));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }

    @Override
    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {

        PlayerEntity player = MinecraftClient.getInstance().player;

        if (player.isSubmergedInWater()) {
            return baseAttackDamage * 2F;
        }
        return super.getBonusAttackDamage(target, baseAttackDamage, damageSource);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        super.postHit(stack, target, attacker);

        if (!(attacker instanceof PlayerEntity player)) {
            return;
        }

        int hits = getHitCounter(stack) + 1;

        if (hits >= 3) {

            if (!(player.getEntityWorld() instanceof ServerWorld serverWorld)) {
                return;
            }

            double baseDamage = player.getAttributeValue(EntityAttributes.ATTACK_DAMAGE);

            Box damageArea = target.getBoundingBox().expand(3);

            List<LivingEntity> nearbyEntities =
                    serverWorld.getEntitiesByClass(
                            LivingEntity.class,
                            damageArea,
                            e -> e != player && e != target
                    );

            DamageSource source = player.getDamageSources().playerAttack(player);

            for (LivingEntity entity : nearbyEntities) {

                entity.damage(serverWorld, source, (float)(baseDamage * 1.25F));

                entity.addStatusEffect(
                        new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1)
                );
            }

                target.addStatusEffect(
                        new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 1)
                );

            spawnWaterShockwave(serverWorld, target.getX(), target.getY() + 0.1, target.getZ());

            hits = 0;
        }

        setHitCounter(stack, hits);
    }


}

