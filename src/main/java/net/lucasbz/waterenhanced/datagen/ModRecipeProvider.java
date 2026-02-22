package net.lucasbz.waterenhanced.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.lucasbz.waterenhanced.block.ModBlocks;
import net.minecraft.data.recipe.*;

import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import net.lucasbz.waterenhanced.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup lookup,
                                                 RecipeExporter exporter) {
        return new RecipeGenerator(lookup, exporter) {

            private void generateIngots() {
                ShapedRecipeJsonBuilder.create(
                            this.registries.getOrThrow(RegistryKeys.ITEM),
                            RecipeCategory.MISC,
                            ModItems.CRYSTALLIZED_WATER_INGOT,
                            2
                        )
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern("AAA")
                        .input('A', ModItems.CRYSTALLIZED_WATER)
                        .input('B', Items.IRON_INGOT)
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER),
                        conditionsFromItem(ModItems.CRYSTALLIZED_WATER))
                        .offerTo(exporter, "crystallized_water_ingot_from_crystallized_water_and_iron_ingot");
            }

            private void generateSmelting() {

                CookingRecipeJsonBuilder.createSmelting(
                            Ingredient.ofItems(ModItems.CRYSTALLIZED_WATER),
                            RecipeCategory.MISC,
                            Items.WIND_CHARGE,
                            0.7f,
                            200
                        )
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER),
                                conditionsFromItem(ModItems.CRYSTALLIZED_WATER))
                        .offerTo(exporter, "smelting_crystallized_water_to_wind_charge");
            }

            private void generateStorageBlocks() {
                ShapedRecipeJsonBuilder.create(
                            this.registries.getOrThrow(RegistryKeys.ITEM),
                            RecipeCategory.MISC,
                            ModBlocks.CRYSTALLIZED_WATER_BLOCK,
                            1
                        )
                        .pattern("AAA")
                        .pattern("AAA")
                        .pattern("AAA")
                        .input('A', ModItems.CRYSTALLIZED_WATER)
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER),
                                conditionsFromItem(ModItems.CRYSTALLIZED_WATER))
                        .offerTo(exporter, "crystallized_water_block_from_crystallized_water");
            }

            private void generateStorageBlocksReverse() {
                ShapelessRecipeJsonBuilder.create(
                            this.registries.getOrThrow(RegistryKeys.ITEM),
                            RecipeCategory.MISC,
                            ModItems.CRYSTALLIZED_WATER,
                            9
                        )
                        .input(ModBlocks.CRYSTALLIZED_WATER_BLOCK)
                        .criterion(hasItem(ModBlocks.CRYSTALLIZED_WATER_BLOCK),
                                conditionsFromItem(ModBlocks.CRYSTALLIZED_WATER_BLOCK))
                        .offerTo(exporter, "crystallized_water_from_block");
            }

            private void generateArmor() {
                ShapedRecipeJsonBuilder.create(
                        this.registries.getOrThrow(RegistryKeys.ITEM),
                        RecipeCategory.COMBAT,
                        ModItems.CRYSTALLIZED_WATER_HELMET,
                        1
                )
                        .pattern("AAA")
                        .pattern("A A")
                        .pattern("   ")
                        .input('A', ModItems.CRYSTALLIZED_WATER_INGOT)
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER_INGOT),
                                conditionsFromItem(ModItems.CRYSTALLIZED_WATER_INGOT))
                        .offerTo(exporter, "crystallized_water_helmet_from_ingots");

                ShapedRecipeJsonBuilder.create(
                        this.registries.getOrThrow(RegistryKeys.ITEM),
                        RecipeCategory.COMBAT,
                        ModItems.CRYSTALLIZED_WATER_CHESTPLATE,
                        1
                )
                        .pattern("A A")
                        .pattern("AAA")
                        .pattern("AAA")
                        .input('A', ModItems.CRYSTALLIZED_WATER_INGOT)
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER_INGOT),
                                conditionsFromItem(ModItems.CRYSTALLIZED_WATER_INGOT))
                        .offerTo(exporter, "crystallized_water_chestplate_from_ingots");

                ShapedRecipeJsonBuilder.create(
                        this.registries.getOrThrow(RegistryKeys.ITEM),
                        RecipeCategory.COMBAT,
                        ModItems.CRYSTALLIZED_WATER_LEGGINGS,
                        1
                )
                        .pattern("AAA")
                        .pattern("A A")
                        .pattern("A A")
                        .input('A', ModItems.CRYSTALLIZED_WATER_INGOT)
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER_INGOT),
                                conditionsFromItem(ModItems.CRYSTALLIZED_WATER_INGOT))
                        .offerTo(exporter, "crystallized_water_leggings_from_ingots");

                ShapedRecipeJsonBuilder.create(
                        this.registries.getOrThrow(RegistryKeys.ITEM),
                        RecipeCategory.COMBAT,
                        ModItems.CRYSTALLIZED_WATER_BOOTS,
                        1
                )
                        .pattern("   ")
                        .pattern("A A")
                        .pattern("A A")
                        .input('A', ModItems.CRYSTALLIZED_WATER_INGOT)
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER_INGOT),
                                conditionsFromItem(ModItems.CRYSTALLIZED_WATER_INGOT))
                        .offerTo(exporter, "crystallized_water_boots_from_ingots"

                );
            }

            private void generateTools() {
                ShapedRecipeJsonBuilder.create(
                        this.registries.getOrThrow(RegistryKeys.ITEM),
                        RecipeCategory.TOOLS,
                        ModItems.CRYSTALLIZED_WATER_PICKAXE,
                        1
                )
                        .pattern("AAA")
                        .pattern(" B ")
                        .pattern(" B ")
                        .input('A', ModItems.CRYSTALLIZED_WATER_INGOT)
                        .input('B', Items.STICK)
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER_INGOT),
                                conditionsFromItem(ModItems.CRYSTALLIZED_WATER_INGOT))
                        .offerTo(exporter, "crystallized_water_pickaxe_from_ingots_and_sticks");

                ShapedRecipeJsonBuilder.create(
                        this.registries.getOrThrow(RegistryKeys.ITEM),
                        RecipeCategory.TOOLS,
                        ModItems.CRYSTALLIZED_WATER_AXE,
                        1
                )
                        .pattern(" AA")
                        .pattern(" BA")
                        .pattern(" B ")
                        .input('A', ModItems.CRYSTALLIZED_WATER_INGOT)
                        .input('B', Items.STICK)
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER_INGOT),
                                conditionsFromItem(ModItems.CRYSTALLIZED_WATER_INGOT))
                        .offerTo(exporter, "crystallized_water_axe_from_ingots_and_sticks");

                ShapedRecipeJsonBuilder.create(
                        this.registries.getOrThrow(RegistryKeys.ITEM),
                        RecipeCategory.TOOLS,
                        ModItems.CRYSTALLIZED_WATER_SHOVEL,
                        1
                )
                        .pattern(" A ")
                        .pattern(" B ")
                        .pattern(" B ")
                        .input('A', ModItems.CRYSTALLIZED_WATER_INGOT)
                        .input('B', Items.STICK)
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER_INGOT),
                                conditionsFromItem(ModItems.CRYSTALLIZED_WATER_INGOT))
                        .offerTo(exporter, "crystallized_water_shovel_from_ingots_and_sticks");

                ShapedRecipeJsonBuilder.create(
                        this.registries.getOrThrow(RegistryKeys.ITEM),
                        RecipeCategory.COMBAT,
                        ModItems.CRYSTALLIZED_WATER_SWORD,
                        1
                )
                        .pattern(" A ")
                        .pattern(" A ")
                        .pattern(" B ")
                        .input('A', ModItems.CRYSTALLIZED_WATER_INGOT)
                        .input('B', Items.STICK)
                        .criterion(hasItem(ModItems.CRYSTALLIZED_WATER_INGOT),
                                conditionsFromItem(ModItems.CRYSTALLIZED_WATER_INGOT))
                        .offerTo(exporter, "crystallized_water_sword_from_ingots_and_sticks");

            }


            @Override
            public void generate() {
                generateIngots();
                generateSmelting();
                generateStorageBlocks();
                generateStorageBlocksReverse();
                generateTools();
                generateArmor();
            }

        };
    }

    @Override
    public String getName() {
        return "WaterEnhanced Recipes";
    }



}
