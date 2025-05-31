package com.justacoder.stinkysocks;

import com.justacoder.stinkysocks.block.ModBlocks;
import com.justacoder.stinkysocks.block.entity.ModBlockEntities;
import com.justacoder.stinkysocks.item.ModItems;
import com.justacoder.stinkysocks.recipe.ModRecipes;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StinkySocks implements ModInitializer {
	public static final String MOD_ID = "stinkysocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModRecipes.registerRecipes();
	}
}