package net.lucasbz.waterenhanced.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;


public class CrystallizedWaterAxeItem extends Item {

    public CrystallizedWaterAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(settings.axe(material, attackDamage, attackSpeed));
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        float base = super.getMiningSpeed(stack, state);
        PlayerEntity player = MinecraftClient.getInstance().player;

        if (player.isSubmergedInWater()){
            return base * 3f;
        }
        return base;
    }

}

