package com.justacoder.stinkysocks.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record WashingMachineRecipe(Ingredient inputItem, ItemStack output) implements Recipe<WashingMachineRecipeeInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(WashingMachineRecipeeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(WashingMachineRecipeeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.WASHING_MACHINE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.WASHING_MACHINE_TYPE;
    }

    public static class Serializer implements RecipeSerializer<WashingMachineRecipe> {
        public static final MapCodec<WashingMachineRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(WashingMachineRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(WashingMachineRecipe::output)
        ).apply(inst, WashingMachineRecipe::new));

        public static final PacketCodec<RegistryByteBuf, WashingMachineRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, WashingMachineRecipe::inputItem,
                        ItemStack.PACKET_CODEC, WashingMachineRecipe::output,
                        WashingMachineRecipe::new);

        @Override
        public MapCodec<WashingMachineRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, WashingMachineRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}

