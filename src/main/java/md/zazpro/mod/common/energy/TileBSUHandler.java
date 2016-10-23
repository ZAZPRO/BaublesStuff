/*
 * This class (TileBSUHandler.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileBSUHandler extends TileEntity implements IBSUReceiver, IBSUProvider {
    protected BSUStorage storage = new BSUStorage(100000);

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        return storage.writeToNBT(nbt);
    }

    @Override
    public boolean canConnectEnergy(EnumFacing from) {
        return true;
    }

    @Override
    public int getBSUStored(EnumFacing from) {
        return storage.getBSUStored();
    }

    @Override
    public int getMaxBSUStored(EnumFacing from) {
        return storage.getMaxBSUStored();
    }

    @Override
    public int receiveBSU(EnumFacing from, int maxReceive, boolean simulate) {
        return storage.receiveBSU(maxReceive, simulate);
    }

    @Override
    public int extractBSU(EnumFacing from, int maxExtract, boolean simulate) {
        return storage.extractBSU(maxExtract, simulate);
    }
}
