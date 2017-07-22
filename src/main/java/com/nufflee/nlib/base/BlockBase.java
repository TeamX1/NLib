package com.nufflee.nlib.base;


import com.nufflee.nlib.NLib;
import com.nufflee.nlib.enums.BlockHarvestLevel;
import com.nufflee.nlib.enums.BlockHarvestTool;
import com.nufflee.nlib.mod.IRegisterable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockBase extends Block implements IRegisterable {
    public BlockBase(String unlocalizedName, Material material, float hardness, float resistance, BlockHarvestTool harvestTool, BlockHarvestLevel harvestLevel) {
        super(material);

        setUnlocalizedName(unlocalizedName);
        setRegistryName(new ResourceLocation(NLib.modId, unlocalizedName));
        setHardness(hardness);
        setResistance(resistance);
        if(harvestLevel != BlockHarvestLevel.ANY || harvestTool != BlockHarvestTool.ANY)
            setHarvestLevel(harvestTool.toString(), harvestLevel.getValue());

        setCreativeTab(NLib.tab);
    }

    @Override
    public void register() {
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerRenders() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(new ResourceLocation(NLib.modId, getUnlocalizedName().substring(5)), "inventory"));
    }
}
