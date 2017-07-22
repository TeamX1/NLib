package com.nufflee.nlib.mod;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModHandler implements IHandleEvents {
    public static LoaderHandler loaderHandler = new LoaderHandler();

    @Override
    public void handlePreInit(FMLPreInitializationEvent event) {
        loaderHandler.handlePreInit(event);
    }

    @Override
    public void handleInit(FMLInitializationEvent event) {

    }

    @Override
    public void handlePostInit(FMLPostInitializationEvent event) {

    }
}
