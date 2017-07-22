package com.nufflee.nlib.mod;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface ITileEntityRegisterable extends IRegisterable {
    void registerTileEntity();

    @SideOnly(Side.CLIENT)
    void registerTESR();
}
