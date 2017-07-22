package com.nufflee.nlib.base;

import com.nufflee.nlib.NLib;
import com.nufflee.nlib.mod.IRegisterable;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemBase extends Item implements IRegisterable {
    public ItemBase(String unlocalizedName) {
        setUnlocalizedName(unlocalizedName);
        setRegistryName(new ResourceLocation(NLib.modId, unlocalizedName));
        setCreativeTab(NLib.tab);
    }

    @Override
    public void register() {
        GameRegistry.register(this);
    }

    @Override
    public void registerRenders() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(new ResourceLocation(NLib.modId, getUnlocalizedName().substring(5)), "inventory"));
    }
}
