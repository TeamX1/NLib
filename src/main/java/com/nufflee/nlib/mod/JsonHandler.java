package com.nufflee.nlib.mod;

import com.nufflee.nlib.NLib;
import com.nufflee.nlib.base.BlockBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;
import java.net.URL;

public class JsonHandler implements IHandleEvents {
    @Override
    public void handlePreInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void handleInit(FMLInitializationEvent event) {

    }

    @Override
    public void handlePostInit(FMLPostInitializationEvent event) {

    }

    private void generateItemJSON(BlockBase block) {

    }

    private void generateBlockJSON(BlockBase block) {
        URL modelPath = NLib.modClazz.getClass().getResource("assets/" + NLib.modId + "/models/block/" + block.getUnlocalizedName() + ".json");
        URL itemModelPath = NLib.modClazz.getClass().getResource("assets/" + NLib.modId + "/models/item/" + block.getUnlocalizedName() + ".json");
        URL blockstatePath = NLib.modClazz.getClass().getResource("assets/" + NLib.modId + "/blockstates/" + block.getUnlocalizedName() + ".json");

        String modelText;
        String itemModelText;
        String blockstateText;

        File modelFile;
        File itemModelFile;
        File blockstateFile;

        if (modelPath == null) {
            modelText = "{\n\t\"parent\": \"block/cube_all\",\n\t\"textures\": {\n\t\t\"all\": \"" + NLib.modId + ":blocks/" + block.getUnlocalizedName() + "\"\n\t}\n}";
            modelFile = new File(modelPath.getPath());
        }

        if (itemModelPath == null) {
            itemModelText = "{\n\t\"parent\": \"" + NLib.modId + ":block/" + block.getUnlocalizedName() + "\n}";
            itemModelFile = new File(itemModelPath.getPath());
        }


        if (blockstatePath == null) {
            blockstateText = "{\n";
        }
    }
}
