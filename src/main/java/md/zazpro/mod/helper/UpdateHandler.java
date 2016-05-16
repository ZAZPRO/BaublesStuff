package md.zazpro.mod.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class UpdateHandler {
    public static boolean triedToWarnPlayer = false;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && Minecraft.getMinecraft().thePlayer != null && !triedToWarnPlayer) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            VersionChecker.checkVersion(player);
            triedToWarnPlayer = true;
        }
    }

}
