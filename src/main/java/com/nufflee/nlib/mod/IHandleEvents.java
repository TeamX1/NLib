package com.nufflee.nlib.mod;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IHandleEvents {
    void handlePreInit(FMLPreInitializationEvent event);

    void handleInit(FMLInitializationEvent event);

    void handlePostInit(FMLPostInitializationEvent event);
}
