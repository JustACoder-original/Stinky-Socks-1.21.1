package com.justacoder.stinkysocks.block.entity;

import com.justacoder.stinkysocks.StinkySocks;
import com.justacoder.stinkysocks.block.ModBlocks;
import com.justacoder.stinkysocks.block.entity.custom.WashingMachineBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<WashingMachineBlockEntity> WASHING_MACHINE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(StinkySocks.MOD_ID, "washing_machine_be"),
                    BlockEntityType.Builder.create(WashingMachineBlockEntity::new, ModBlocks.WASHING_MACHINE).build(null));


    public static void registerBlockEntities() {
        StinkySocks.LOGGER.info("Registering Block Entities for " + StinkySocks.MOD_ID);
    }
}
