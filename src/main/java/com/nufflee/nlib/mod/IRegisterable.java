package com.nufflee.nlib.mod;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IRegisterable {
    void register();

    @SideOnly(Side.CLIENT)
    void registerRenders();
}
