package com.justacoder.stinkysocks.block;

import com.justacoder.stinkysocks.StinkySocks;
import com.justacoder.stinkysocks.block.custom.WashingMachineBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block WASHING_MACHINE = registerBlock("washing_machine",
            new WashingMachineBlock(AbstractBlock.Settings.create()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StinkySocks.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(StinkySocks.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }



    public static void registerModBlocks() {
        StinkySocks.LOGGER.info("Registering Mod Blocks for " + StinkySocks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.WASHING_MACHINE);
        });
    }
}

