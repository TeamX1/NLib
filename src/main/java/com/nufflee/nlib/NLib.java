package com.nufflee.nlib;

import com.nufflee.nlib.mod.ModHandler;
import com.nufflee.nlib.utils.Logger;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.lang.reflect.Field;

public class NLib {
    public static String modId;
    public static CreativeTabs tab;
    public static Class modClazz;
    public ModHandler modHandler;

    public NLib() {
        modHandler = new ModHandler();

        Class clazz = null;

        try {
            clazz = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(clazz == null){
            Logger.getLogger().error("Mod class is null!");
            return;
        }

        if (clazz.isAnnotationPresent(Mod.class)) {
            Mod mod = (Mod) clazz.getAnnotation(Mod.class);

            NLib.modClazz = clazz;
            modId = mod.modid();

            for (Field field : modClazz.getDeclaredFields()) {
                if (field.getType() == CreativeTabs.class) {
                    try {
                        tab = (CreativeTabs) field.get(this);
                        break;
                    } catch (IllegalAccessException e) {
                        Logger.getLogger().error("Could not access tab field!");
                    }
                }
            }
        } else {
            Logger.getLogger().error("Could not initialize NLib because given class is not the main mod class");
        }
    }

    public void preInit(FMLPreInitializationEvent event) {
        modHandler.handlePreInit(event);
    }

    public void init(FMLInitializationEvent event) {
        modHandler.handleInit(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        modHandler.handlePostInit(event);
    }
}
