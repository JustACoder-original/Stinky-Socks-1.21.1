package com.justacoder.stinkysocks.recipe;

import com.justacoder.stinkysocks.StinkySocks;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<WashingMachineRecipe> WASHING_MACHINE_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(StinkySocks.MOD_ID, "washing_machine"),
                    new WashingMachineRecipe.Serializer());

    public static final RecipeType<WashingMachineRecipe> WASHING_MACHINE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(StinkySocks.MOD_ID, "washing_machine"), new RecipeType<WashingMachineRecipe>() {
                @Override
                public String toString() {
                    return "washing_machine";
                }});

    public static void registerRecipes() {
        StinkySocks.LOGGER.info("Registering Custom Recipes for " + StinkySocks.MOD_ID);
    }
}
