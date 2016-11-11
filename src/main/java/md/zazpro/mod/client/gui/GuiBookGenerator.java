/*
 * This class (GuiBookGenerator.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.client.gui;

import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.tileentity.TEBookGenerator;
import md.zazpro.mod.common.tileentity.container.ContainerBookGenerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiBookGenerator extends GuiContainer {
    private static final ResourceLocation resLoc = new ResourceLocation(ModInfo.MODID, "textures/gui/GUI_BookGenerator.png");
    private final TEBookGenerator bookGenerator;
    private IInventory playerInv;

    public GuiBookGenerator(EntityPlayer player, IInventory playerInv, TEBookGenerator te) {
        super(new ContainerBookGenerator(player, playerInv, te));
        this.bookGenerator = te;
        this.playerInv = playerInv;
        this.xSize = 175;
        this.ySize = 165;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(resLoc);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {         //#404040
        this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);      //#404040
    }
}
