package net.lucasbz.waterenhanced.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lucasbz.waterenhanced.block.ModBlocks;
import net.lucasbz.waterenhanced.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    public ModBlockLootTableProvider(
            FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture
    ) {
        super(output, registriesFuture);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CRYSTALLIZED_WATER_BLOCK);
        addDrop(ModBlocks.CRYSTALLIZED_WATER_ORE, oreDrops(ModBlocks.CRYSTALLIZED_WATER_ORE, ModItems.CRYSTALLIZED_WATER));
    }
}