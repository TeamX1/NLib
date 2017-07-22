package com.nufflee.nlib.mod;

import com.nufflee.nlib.base.BlockBase;
import com.nufflee.nlib.base.BlockTEBase;
import com.nufflee.nlib.base.ItemBase;
import com.nufflee.nlib.enums.LoaderType;
import com.nufflee.nlib.mod.loader.Loader;
import com.nufflee.nlib.utils.Logger;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LoaderHandler implements IHandleEvents {
    private static List<ItemBase> items = new ArrayList<ItemBase>();
    private static List<BlockBase> blocks = new ArrayList<BlockBase>();

    public static List<ItemBase> getItems() {
        return items;
    }

    public static List<BlockBase> getBlocks() {
        return blocks;
    }

    @Override
    public void handlePreInit(FMLPreInitializationEvent event) {
        setupLoaders(event);

        register();
    }

    @Override
    public void handleInit(FMLInitializationEvent event) {

    }

    @Override
    public void handlePostInit(FMLPostInitializationEvent event) {

    }

    private void register() {
        for (ItemBase item : items) {
            item.register();
            item.registerRenders();
        }

        for (BlockBase block : blocks) {
            block.register();
            block.registerRenders();
            if (block instanceof BlockTEBase) {
                ((BlockTEBase) block).registerTileEntity();
                ((BlockTEBase) block).registerTESR();
            }
        }
    }

    private void setupLoaders(FMLPreInitializationEvent event) {
        for (ASMDataTable.ASMData data : event.getAsmData().getAll(Loader.class.getName())) {
            Class<?> clazz = null;

            try {
                clazz = Class.forName(data.getClassName());
            } catch (ClassNotFoundException e) {
                Logger.getLogger().error(e);
            }

            Loader annotation = clazz.getAnnotation(Loader.class);

            for (Field field : clazz.getDeclaredFields()) {
                if (annotation.type() == LoaderType.ITEM) {
                    try {
                        items.add((ItemBase) clazz.getField(field.getName()).get(this));
                    } catch (Exception e) {
                        Logger.getLogger().error(String.format("Failed to cast types! (Field: %s, Class: %s)", field.getName(), clazz.getName()));
                    }
                } else {
                    try {
                        blocks.add((BlockBase) field.get(this));
                    } catch (IllegalAccessException e) {
                        Logger.getLogger().error(String.format("Failed to cast types! (Field: %s, Class: %s)", field.getName(), clazz.getName()));
                    }
                }
            }

        }
    }
}
