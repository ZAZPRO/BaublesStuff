/*
 * This class (Wrapper.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;

public class Wrapper {
    public static volatile Wrapper INSTANCE = new Wrapper();

    public Minecraft minecraft() {
        return Minecraft.getMinecraft();
    }

    public WorldClient world() {
        return Minecraft.getMinecraft().theWorld;
    }

}

