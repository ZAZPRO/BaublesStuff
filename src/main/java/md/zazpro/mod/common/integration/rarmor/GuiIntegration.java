/*
 * This class (GuiIntegration.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.integration.rarmor;

import baubles.client.gui.GuiBaublesButton;
import baubles.common.network.PacketHandler;
import baubles.common.network.PacketOpenBaublesInventory;
import de.canitzp.rarmor.inventory.gui.GuiRFArmor;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiIntegration {
    public static void proxyReg() {
        MinecraftForge.EVENT_BUS.register(new GuiIntegration());
    }

    @SideOnly(value = Side.CLIENT)
    @SubscribeEvent
    public void guiPostInit(GuiScreenEvent.InitGuiEvent.Post event) {

        if (event.getGui() instanceof GuiRFArmor) {
            GuiRFArmor gui = (GuiRFArmor) event.getGui();
            event.getButtonList().add(new GuiBaublesButton(55, gui.getGuiLeft() + 103, gui.getGuiTop() + 11, 64, 9,
                    I18n.format((event.getGui() instanceof GuiInventory) ? "button.baubles" : "button.normal", new Object[0])));
        }

    }

    @SideOnly(value = Side.CLIENT)
    @SubscribeEvent
    public void guiPostAction(GuiScreenEvent.ActionPerformedEvent.Post event) {

        if (event.getGui() instanceof GuiRFArmor) {
            if (event.getButton().id == 55) {
                PacketHandler.INSTANCE.sendToServer(new PacketOpenBaublesInventory(event.getGui().mc.thePlayer));
            }
        }

    }

}
