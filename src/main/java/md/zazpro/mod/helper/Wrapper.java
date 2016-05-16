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

