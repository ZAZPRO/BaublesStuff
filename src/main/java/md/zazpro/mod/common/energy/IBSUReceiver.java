/*
 *  This class (IBSUReceiver.java) was created by <zazpro>. It's distributed as
 *  part of the Baubles Stuff Mod. Get the Source Code in github:
 *  https://github.com/ZAZPRO/BaublesStuff
 *
 *  Baubles Stuff is Open Source and distributed under the
 *  Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 *  © 2016 zazpro
 */

package md.zazpro.mod.common.energy;

import net.minecraft.util.EnumFacing;

/**
 * This class is was created by King Lemming as a part of RedstoneFlux API. Check RedstoneFlux API original code here:
 * https://github.om/CoFH/RedstoneFlux-API
 * <p>
 * Implement this interface on Tile Entities which should receive energy, generally storing it in one or more internal {@link IEnergyStorage} objects.
 * <p>
 *
 * @author King Lemming
 */
public interface IBSUReceiver {
    /**
     * Add energy to an IBSUReceiver, internal distribution is left entirely to the IBSUReceiver.
     *
     * @param from       Orientation the energy is received from.
     * @param maxReceive Maximum amount of energy to receive.
     * @param simulate   If TRUE, the charge will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) received.
     */
    int receiveBSU(EnumFacing from, int maxReceive, boolean simulate);
}
