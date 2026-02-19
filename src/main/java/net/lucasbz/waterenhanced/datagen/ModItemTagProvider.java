package net.lucasbz.waterenhanced.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;

import net.lucasbz.waterenhanced.WaterEnhanced;
import net.lucasbz.waterenhanced.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public static final TagKey<Item> WATER_TOOL_MATERIALS =
            TagKey.of(RegistryKeys.ITEM,
                    Identifier.of(WaterEnhanced.MOD_ID, "water_tool_materials"));

    public ModItemTagProvider(FabricDataOutput output,
                              CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

    }
}
