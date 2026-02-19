package net.lucasbz.waterenhanced.item;

import net.lucasbz.waterenhanced.datagen.ModItemTagProvider;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.block.Block;

public class WaterToolMaterial {
    public static ToolMaterial CRYSTALLIZED_WATER = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            500,
            6.0F,
            2.0F,
            18,
            ModItemTagProvider.WATER_TOOL_MATERIALS
    );



}
