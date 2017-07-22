package com.nufflee.nlib.base;

import com.nufflee.nlib.enums.BlockHarvestLevel;
import com.nufflee.nlib.enums.BlockHarvestTool;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockOreBase extends BlockBase {
    private Item drop;
    private int leastQuantity;
    private int mostQuantity;

    public BlockOreBase(String unlocalizedName, Material material, float hardness, float resistance, BlockHarvestTool harvestTool, BlockHarvestLevel harvestLevel) {
        this(unlocalizedName, material, hardness, resistance, harvestTool, harvestLevel, null, 1, 1);
    }

    public BlockOreBase(String unlocalizedName, Material material, float hardness, float resistance, BlockHarvestTool harvestTool, BlockHarvestLevel harvestLevel, Item drop, int leastQuantity, int mostQuantity) {
        super(unlocalizedName, material, hardness, resistance, harvestTool, harvestLevel);

        this.drop = drop;
        this.leastQuantity = leastQuantity;
        this.mostQuantity = mostQuantity;
    }

    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return drop != null ? drop : Item.getItemFromBlock(this);
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        if (leastQuantity >= mostQuantity) {
            return leastQuantity;
        }

        return leastQuantity + random.nextInt(mostQuantity - leastQuantity + fortune + 1);
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        return super.getExpDrop(state, world, pos, fortune);
    }


}
