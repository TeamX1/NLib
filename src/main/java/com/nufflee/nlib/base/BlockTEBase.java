package com.nufflee.nlib.base;

import com.nufflee.nlib.NLib;
import com.nufflee.nlib.enums.BlockHarvestLevel;
import com.nufflee.nlib.enums.BlockHarvestTool;
import com.nufflee.nlib.mod.ITileEntityRegisterable;
import com.nufflee.nlib.utils.Logger;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;
import java.lang.reflect.ParameterizedType;

public abstract class BlockTEBase<T extends TileEntity> extends BlockBase implements ITileEntityProvider, ITileEntityRegisterable {
    @SuppressWarnings("unchecked")
    private Class<T> tileEntityClazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public BlockTEBase(String unlocalizedName, Material material, float hardness, float resistance, BlockHarvestTool harvestTool, BlockHarvestLevel harvestLevel) {
        super(unlocalizedName, material, hardness, resistance, harvestTool, harvestLevel);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        try {
            return tileEntityClazz.newInstance();
        } catch (Exception e) {
            Logger.getLogger().error(e);
        }

        return null;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        try {
            return tileEntityClazz.newInstance();
        } catch (Exception e) {
            Logger.getLogger().error(e);
        }

        return null;
    }

    @Override
    public void registerTileEntity() {
        GameRegistry.registerTileEntity(tileEntityClazz, NLib.modId + ":" + getUnlocalizedName());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void registerTESR() {
        if (getTESR() != null) {
            ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClazz, getTESR());
        }
    }

    public TileEntitySpecialRenderer getTESR() {
        return null;
    }
}
