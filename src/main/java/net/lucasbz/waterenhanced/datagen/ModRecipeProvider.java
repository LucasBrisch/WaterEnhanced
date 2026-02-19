package net.lucasbz.waterenhanced.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;

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
                        .offerTo(exporter);
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
                        .offerTo(exporter);
            }


            @Override
            public void generate() {
                generateIngots();
                generateSmelting();
            }

        };
    }

    @Override
    public String getName() {
        return "WaterEnhanced Recipes";
    }



}
