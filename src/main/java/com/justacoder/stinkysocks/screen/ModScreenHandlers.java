package com.justacoder.stinkysocks.screen;

import com.justacoder.stinkysocks.StinkySocks;
import com.justacoder.stinkysocks.screen.custom.WashingMachineScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<WashingMachineScreenHandler> WASHING_MACHINE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(StinkySocks.MOD_ID, "washing_machine_screen_handler"),
                    new ExtendedScreenHandlerType<>(WashingMachineScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void registerScreenHandlers() {
        StinkySocks.LOGGER.info("Registering Screen Handlers for " + StinkySocks.MOD_ID);
    }
}