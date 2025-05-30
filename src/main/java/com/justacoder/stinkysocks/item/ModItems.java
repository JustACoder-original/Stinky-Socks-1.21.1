package com.justacoder.stinkysocks.item;

import com.justacoder.stinkysocks.StinkySocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DRY_SOCKS = registerItem("dry_socks", new Item(new Item.Settings()));
    public static final Item WET_SOCKS = registerItem("wet_socks", new Item(new Item.Settings()));
    public static final Item STINKY_WET_SOCKS = registerItem("stinky_wet_socks", new Item(new Item.Settings()));
    public static final Item STINKY_SOCKS = registerItem("stinky_socks", new Item(new Item.Settings()));
    public static final Item WASHING_MACHINE = registerItem("washing_machine", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(StinkySocks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        StinkySocks.LOGGER.info("Registering Mod Items for " + StinkySocks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(DRY_SOCKS);
            fabricItemGroupEntries.add(WET_SOCKS);
            fabricItemGroupEntries.add(STINKY_WET_SOCKS);
            fabricItemGroupEntries.add(STINKY_SOCKS);
        });
    }
}
