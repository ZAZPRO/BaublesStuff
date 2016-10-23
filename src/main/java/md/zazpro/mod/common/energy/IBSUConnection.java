/*
 * This class (IBSUConnection.java) was created by <zazpro>. It's distributed as
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
 * Implement this interface on TileEntities which should connect to BSU transportation blocks. This is intended for blocks which generate energy but do not
 * accept it; otherwise just use IBSUHandler.
 *
 * @author King Lemming
 */
public interface IBSUConnection {
    /**
     * Returns TRUE if the TileEntity can connect on a given side.
     */
    boolean canConnectEnergy(EnumFacing from);
}
