/*
 * This class (BaubleBSUContainer.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.energy;

import md.zazpro.mod.common.baubles.base.BaubleBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * This class is was created by King Lemming as a part of RedstoneFlux API. Check RedstoneFlux API original code here:
 * https://github.om/CoFH/RedstoneFlux-API
 *
 * @author King Lemming
 */

public abstract class BaubleBSUContainer extends BaubleBase implements IBSUContainerItem {
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public BaubleBSUContainer() {

    }

    public BaubleBSUContainer(int capacity) {
        this(capacity, capacity, capacity);
    }

    public BaubleBSUContainer(int capacity, int maxTransfer) {
        this(capacity, maxTransfer, maxTransfer);
    }

    public BaubleBSUContainer(int capacity, int maxReceive, int maxExtract) {
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
    }

    public BaubleBSUContainer setCapacity(int capacity) {

        this.capacity = capacity;
        return this;
    }

    public BaubleBSUContainer setMaxTransfer(int maxTransfer) {

        setMaxReceive(maxTransfer);
        setMaxExtract(maxTransfer);
        return this;
    }

    public BaubleBSUContainer setMaxReceive(int maxReceive) {

        this.maxReceive = maxReceive;
        return this;
    }

    public BaubleBSUContainer setMaxExtract(int maxExtract) {

        this.maxExtract = maxExtract;
        return this;
    }

    /* IEnergyContainerItem */
    @Override
    public int receiveBSU(ItemStack container, int maxReceive, boolean simulate) {

        if (!container.hasTagCompound()) {
            container.setTagCompound(new NBTTagCompound());
            container.getTagCompound().setInteger("BSU", 0);
        }
        int energy = container.getTagCompound().getInteger("BSU");
        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

        if (!simulate) {
            energy += energyReceived;
            container.getTagCompound().setInteger("BSU", energy);
        }
        return energyReceived;
    }

    @Override
    public int extractBSU(ItemStack container, int maxExtract, boolean simulate) {

        if (container.getTagCompound() == null || !container.getTagCompound().hasKey("BSU")) {
            return 0;
        }
        int energy = container.getTagCompound().getInteger("BSU");
        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));

        if (!simulate) {
            energy -= energyExtracted;
            container.getTagCompound().setInteger("BSU", energy);
        }
        return energyExtracted;
    }

    @Override
    public void setBSUStored(ItemStack container, int amount) {

        if (!container.hasTagCompound()) {
            container.setTagCompound(new NBTTagCompound());
            container.getTagCompound().setInteger("BSU", 0);
        }
        container.getTagCompound().setInteger("BSU", amount);
    }

    @Override
    public int getBSUStored(ItemStack container) {

        if (container.getTagCompound() == null || !container.getTagCompound().hasKey("BSU")) {
            return 0;
        }
        return container.getTagCompound().getInteger("BSU");
    }

    @Override
    public int getMaxBSUStored(ItemStack container) {

        return capacity;
    }

    @Override
    public int getMaxBSUTransfer(ItemStack container) {

        return maxReceive;
    }

    @Override
    public boolean showDurabilityBar(ItemStack container) {
        return !(getBSUStored(container) == getMaxBSUStored(container));
    }

    @Override
    public double getDurabilityForDisplay(ItemStack container) {
        double bsuDif = getMaxBSUStored(container) - getBSUStored(container);
        double maxAmount = getMaxBSUStored(container);
        return bsuDif / maxAmount;
    }

    @Override
    public int getDamage(ItemStack container) {
        return getBSUStored(container);
    }
}
