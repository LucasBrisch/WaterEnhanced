package net.lucasbz.waterenhanced.block;

import net.lucasbz.waterenhanced.WaterEnhanced;
import net.lucasbz.waterenhanced.item.custom.CrystallizedWaterPickaxeItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static Block CRYSTALLIZED_WATER_BLOCK;
    public static Block CRYSTALLIZED_WATER_ORE;

    public static void registerModBlocks() {
        CRYSTALLIZED_WATER_BLOCK = register(
            "crystallized_water_block",
            Block::new,
                AbstractBlock.Settings.create()
                        .strength(5.0F, 6.0F)
                        .requiresTool()
                        .sounds(BlockSoundGroup.AMETHYST_BLOCK),
            true
        );

        CRYSTALLIZED_WATER_ORE = register(
            "crystallized_water_ore",
            Block::new,
                AbstractBlock.Settings.create()
                        .strength(5.0F, 6.0F)
                        .requiresTool()
                        .sounds(BlockSoundGroup.STONE),
            true
        );
    }

    private static Block register(
        String name,
        Function<AbstractBlock.Settings, Block> blockFactory,
        AbstractBlock.Settings settings,
        boolean shouldRegisterItem
    ) {
        Identifier id = Identifier.of(WaterEnhanced.MOD_ID, name);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        AbstractBlock.Settings settingsWithKey = settings.registryKey(blockKey);

        Block block = blockFactory.apply(settingsWithKey);
        Block registeredBlock = Registry.register(Registries.BLOCK, blockKey, block);

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
            BlockItem blockItem = new BlockItem(
                registeredBlock,
                new Item.Settings().registryKey(itemKey)
            );
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return registeredBlock;
    }
}