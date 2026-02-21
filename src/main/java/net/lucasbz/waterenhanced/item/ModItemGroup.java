package net.lucasbz.waterenhanced.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lucasbz.waterenhanced.WaterEnhanced;
import net.lucasbz.waterenhanced.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
	public static final RegistryKey<ItemGroup> WATER_ENHANCED_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP,
			Identifier.of(WaterEnhanced.MOD_ID, "water_enhanced_group"));

	public static final ItemGroup WATER_ENHANCED_GROUP = FabricItemGroup.builder()
			.displayName(Text.translatable("itemgroup.waterenhanced.water_enhanced_group"))
			.icon(() -> new ItemStack(ModItems.CRYSTALLIZED_WATER))
			.entries((displayContext, entries) -> {
				entries.add(ModItems.CRYSTALLIZED_WATER);
				entries.add(ModBlocks.CRYSTALLIZED_WATER_BLOCK);
				entries.add(ModItems.CRYSTALLIZED_WATER_INGOT);
				entries.add(ModItems.CRYSTALLIZED_WATER_PICKAXE);
				entries.add(ModItems.CRYSTALLIZED_WATER_AXE);
			})
			.build();

	public static void registerItemGroups() {
		Registry.register(Registries.ITEM_GROUP, WATER_ENHANCED_GROUP_KEY, WATER_ENHANCED_GROUP);
		WaterEnhanced.LOGGER.info("Registering Item Groups for " + WaterEnhanced.MOD_ID);
	}
}
