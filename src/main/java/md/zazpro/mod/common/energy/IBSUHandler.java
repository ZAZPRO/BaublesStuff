/*
 * This class (IBSUHandler.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.energy;

import net.minecraft.util.EnumFacing;

/**
 * This class is was created by King Lemming as a part of RedstoneFlux API. Check RedstoneFlux API original code here:
 * https://github.om/CoFH/RedstoneFlux-API
 * <p>
 * Implement this interface on Tile Entities which should handle energy, generally storing it in one or more internal {@link IBSUStorage} objects.
 * Note that {@link IBSUReceiver} and {@link IBSUProvider} are extensions of this.
 *
 * @author King Lemming
 */
public interface IBSUHandler extends IBSUConnection {
    /**
     * Returns the amount of energy currently stored.
     */
    int getBSUStored(EnumFacing from);

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    int getMaxBSUStored(EnumFacing from);
}
