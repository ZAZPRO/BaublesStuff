/*
 * This class (IBSUContainerItem.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.energy;

import net.minecraft.item.ItemStack;

/**
 * This class is was created by King Lemming as a part of RedstoneFlux API. Check RedstoneFlux API original code here:
 * https://github.om/CoFH/RedstoneFlux-API
 * @author King Lemming
 */

public interface IBSUContainerItem {
    /**
     * Adds energy to a container item. Returns the quantity of energy that was accepted. This should always return 0 if the item cannot be externally charged.
     *
     * @param container  ItemStack to be charged.
     * @param maxReceive Maximum amount of energy to be sent into the item.
     * @param simulate   If TRUE, the charge will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) received by the item.
     */
    int receiveBSU(ItemStack container, int maxReceive, boolean simulate);

    /**
     * Removes energy from a container item. Returns the quantity of energy that was removed. This should always return 0 if the item cannot be externally
     * discharged.
     *
     * @param container  ItemStack to be discharged.
     * @param maxExtract Maximum amount of energy to be extracted from the item.
     * @param simulate   If TRUE, the discharge will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) extracted from the item.
     */
    int extractBSU(ItemStack container, int maxExtract, boolean simulate);

    /**
     * Get the amount of energy currently stored in the container item.
     */
    int getBSUStored(ItemStack container);

    /**
     * Get the max amount of energy that can be stored in the container item.
     */
    int getMaxBSUStored(ItemStack container);

    int getMaxBSUTransfer (ItemStack container);
}
