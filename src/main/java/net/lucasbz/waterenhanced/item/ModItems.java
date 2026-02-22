package net.lucasbz.waterenhanced.item;

import net.lucasbz.waterenhanced.WaterEnhanced;
import net.lucasbz.waterenhanced.item.custom.CrystallizedWaterAxeItem;
import net.lucasbz.waterenhanced.item.custom.CrystallizedWaterPickaxeItem;
import net.lucasbz.waterenhanced.item.custom.CrystallizedWaterShovelItem;
import net.lucasbz.waterenhanced.item.custom.CrystallizedWaterSwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static Item CRYSTALLIZED_WATER;
    public static Item CRYSTALLIZED_WATER_INGOT;
    public static Item CRYSTALLIZED_WATER_PICKAXE;
    public static Item CRYSTALLIZED_WATER_AXE;
    public static Item CRYSTALLIZED_WATER_SHOVEL;
    public static Item CRYSTALLIZED_WATER_SWORD;

    public static void registerModItems() {

        ToolMaterial crystallizedToolsMaterial = WaterToolMaterial.CRYSTALLIZED_WATER;

        CRYSTALLIZED_WATER = registerItem("crystallized_water",
                settings -> new Item(settings));

        CRYSTALLIZED_WATER_INGOT = registerItem("crystallized_water_ingot",
                settings -> new Item(settings));

        CRYSTALLIZED_WATER_PICKAXE = registerItem("crystallized_water_pickaxe",
                settings -> new CrystallizedWaterPickaxeItem(crystallizedToolsMaterial, 1.0F, -2.8F, settings));

        CRYSTALLIZED_WATER_AXE = registerItem("crystallized_water_axe",
                settings -> new CrystallizedWaterAxeItem(crystallizedToolsMaterial, 5.0F, -3.0F, settings));

        CRYSTALLIZED_WATER_SHOVEL = registerItem("crystallized_water_shovel",
                settings -> new CrystallizedWaterShovelItem(crystallizedToolsMaterial, 1.5F, -3.0F, settings));

        CRYSTALLIZED_WATER_SWORD = registerItem("crystallized_water_sword",
                settings -> new CrystallizedWaterSwordItem(crystallizedToolsMaterial, 3.5F, -2.4F, settings));

        WaterEnhanced.LOGGER.info("Registering Mod Items for " + WaterEnhanced.MOD_ID);
    }

    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        Identifier id = Identifier.of(WaterEnhanced.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        Item.Settings settings = new Item.Settings().registryKey(key);
        Item item = factory.apply(settings);

        Item registered = Registry.register(Registries.ITEM, key, item);
        WaterEnhanced.LOGGER.info("Registered item: " + id);
        return registered;
    }
}
