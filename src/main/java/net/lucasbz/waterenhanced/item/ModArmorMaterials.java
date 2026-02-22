package net.lucasbz.waterenhanced.item;

import net.lucasbz.waterenhanced.WaterEnhanced;

import net.lucasbz.waterenhanced.datagen.ModItemTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModArmorMaterials {

    public static final RegistryKey<EquipmentAsset> CRYSTALLIZED_WATER_ASSET =
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(WaterEnhanced.MOD_ID, "crystallized_water"));

    public static final ArmorMaterial CRYSTALLIZED_WATER = new ArmorMaterial(
            15,
            Map.of(
                    EquipmentType.HELMET, 2,
                    EquipmentType.CHESTPLATE, 6,
                    EquipmentType.LEGGINGS, 5,
                    EquipmentType.BOOTS, 2
            ),
            9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            ModItemTagProvider.REPAIRS_CRYSTALLIZED_WATER_ARMOR,
            CRYSTALLIZED_WATER_ASSET
    );
}