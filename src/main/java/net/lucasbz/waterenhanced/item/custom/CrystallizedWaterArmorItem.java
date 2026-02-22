package net.lucasbz.waterenhanced.item.custom;

import net.lucasbz.waterenhanced.item.ModArmorMaterials;
import net.lucasbz.waterenhanced.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;

import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.jspecify.annotations.Nullable;

import java.util.logging.Logger;

import static net.minecraft.item.equipment.EquipmentType.HELMET;

public class CrystallizedWaterArmorItem extends Item {
    private final EquipmentType type;

    public CrystallizedWaterArmorItem(EquipmentType type, Settings settings) {
        super(settings.armor(ModArmorMaterials.CRYSTALLIZED_WATER, type));
        this.type = type;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, world, entity, slot);

        if (!(entity instanceof PlayerEntity player)) return;

        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);

        if (helmet.getItem() == ModItems.CRYSTALLIZED_WATER_HELMET && player.isSubmergedInWater()) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 40, 0, false, false, true));
        }

        if (boots.getItem() == ModItems.CRYSTALLIZED_WATER_BOOTS && player.isSubmergedInWater()) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 40, 0, false, false, true));
        }


        boolean fullSet =
                helmet.getItem() == ModItems.CRYSTALLIZED_WATER_HELMET &&
                    chestplate.getItem() == ModItems.CRYSTALLIZED_WATER_CHESTPLATE &&
                    leggings.getItem() == ModItems.CRYSTALLIZED_WATER_LEGGINGS &&
                    boots.getItem() == ModItems.CRYSTALLIZED_WATER_BOOTS;

        if (fullSet && player.isSubmergedInWater()) {
            //TODO: implement walking in water when the full set is equipped, for now just giving the conduit power effect
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 40, 0, false, false, true));
        }
    }
}
