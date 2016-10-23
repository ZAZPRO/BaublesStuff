/*
 *  This class (IBSUProvider.java) was created by <zazpro>. It's distributed as
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
 * Implement this interface on Tile Entities which should provide energy, generally storing it in one or more internal {@link IBSUStorage} objects.
 * <p>
 *
 * @author King Lemming
 */
public interface IBSUProvider extends IBSUHandler {
    /**
     * Remove energy from an IBSUProvider, internal distribution is left entirely to the IBSUProvider.
     *
     * @param from       Orientation the energy is extracted from.
     * @param maxExtract Maximum amount of energy to extract.
     * @param simulate   If TRUE, the extraction will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) extracted.
     */
    int extractBSU(EnumFacing from, int maxExtract, boolean simulate);
}
