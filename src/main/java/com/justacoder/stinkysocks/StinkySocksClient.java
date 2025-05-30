package com.justacoder.stinkysocks;

import com.justacoder.stinkysocks.screen.ModScreenHandlers;
import com.justacoder.stinkysocks.screen.custom.WashingMachineScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class StinkySocksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.WASHING_MACHINE_SCREEN_HANDLER, WashingMachineScreen::new);
    }
}
