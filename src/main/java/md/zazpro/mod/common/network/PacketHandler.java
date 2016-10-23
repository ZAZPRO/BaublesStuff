/*
 * This class (PacketHandler.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.network;

import md.zazpro.mod.client.ModInfo;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    public static SimpleNetworkWrapper INSTANCE = new SimpleNetworkWrapper(ModInfo.MODID);
    public static int ID = 0;

    public static void preInit() {
        INSTANCE.registerMessage(MessageGenerator.class, MessageGenerator.class, ID++, Side.CLIENT);
    }
}
