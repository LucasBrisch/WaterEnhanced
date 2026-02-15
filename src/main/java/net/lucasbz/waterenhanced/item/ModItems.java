package net.lucasbz.waterenhanced.item;

import net.lucasbz.waterenhanced.WaterEnhanced;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item CRYSTALLIZED_WATER;

    public static void registerModItems () {

        CRYSTALLIZED_WATER = registerItem("crystallized_water");


        WaterEnhanced.LOGGER.info("Registering Mod Itens for" + WaterEnhanced.MOD_ID);
    }

    private static Item registerItem(String name) {
        Identifier id = Identifier.of(WaterEnhanced.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item item = Registry.register(Registries.ITEM, key, new Item(new Item.Settings().registryKey(key)));
        return item;
    }


}
