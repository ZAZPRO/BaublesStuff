/*
 * This class (BSUStorage.java) was created by <zazpro>. It's distributed as
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

/**
 * This class is was created by King Lemming as a part of RedstoneFlux API. Check RedstoneFlux API original code here:
 * https://github.om/CoFH/RedstoneFlux-API
 *
 * @author King Lemming
 */
public class BSUStorage implements IBSUStorage {
    protected int energy;
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public BSUStorage(int capacity) {

        this(capacity, capacity, capacity);
    }

    public BSUStorage(int capacity, int maxTransfer) {

        this(capacity, maxTransfer, maxTransfer);
    }

    public BSUStorage(int capacity, int maxReceive, int maxExtract) {

        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
    }

    public BSUStorage readFromNBT(NBTTagCompound nbt) {

        this.energy = nbt.getInteger("BSU");

        if (energy > capacity) {
            energy = capacity;
        }
        return this;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

        if (energy < 0) {
            energy = 0;
        }
        nbt.setInteger("BSU", energy);
        return nbt;
    }

    public BSUStorage setCapacity(int capacity) {

        this.capacity = capacity;

        if (energy > capacity) {
            energy = capacity;
        }
        return this;
    }

    public BSUStorage setMaxTransfer(int maxTransfer) {

        setMaxReceive(maxTransfer);
        setMaxExtract(maxTransfer);
        return this;
    }

    public int getMaxReceive() {

        return maxReceive;
    }

    public BSUStorage setMaxReceive(int maxReceive) {

        this.maxReceive = maxReceive;
        return this;
    }

    public int getMaxExtract() {

        return maxExtract;
    }

    public BSUStorage setMaxExtract(int maxExtract) {

        this.maxExtract = maxExtract;
        return this;
    }

    /**
     * This function is included to allow the containing tile to directly and efficiently modify the energy contained in the EnergyStorage. Do not rely on this
     * externally, as not all IEnergyHandlers are guaranteed to have it.
     *
     * @param energy
     */
    public void modifyBSUStored(int energy) {

        this.energy += energy;

        if (this.energy > capacity) {
            this.energy = capacity;
        } else if (this.energy < 0) {
            this.energy = 0;
        }
    }

    /* IEnergyStorage */
    @Override
    public int receiveBSU(int maxReceive, boolean simulate) {

        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

        if (!simulate) {
            energy += energyReceived;
        }
        return energyReceived;
    }

    @Override
    public int extractBSU(int maxExtract, boolean simulate) {

        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));

        if (!simulate) {
            energy -= energyExtracted;
        }
        return energyExtracted;
    }

    @Override
    public int getBSUStored() {

        return energy;
    }

    /**
     * This function is included to allow for server to client sync. Do not call this externally to the containing Tile Entity, as not all IEnergyHandlers
     * are guaranteed to have it.
     *
     * @param energy
     */
    public void setBSUStored(int energy) {

        this.energy = energy;

        if (this.energy > capacity) {
            this.energy = capacity;
        } else if (this.energy < 0) {
            this.energy = 0;
        }
    }

    @Override
    public int getMaxBSUStored() {

        return capacity;
    }
}
