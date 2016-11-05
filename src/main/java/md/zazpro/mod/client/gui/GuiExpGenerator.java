/*
 * This class (GuiExpGenerator.java) was created by <zazpro>. It's distributed as
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
import md.zazpro.mod.common.tileentity.TEExpGenerator;
import md.zazpro.mod.common.tileentity.container.ContainerExpGenerator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiUtils;

import java.util.ArrayList;
import java.util.List;

public class GuiExpGenerator extends GuiContainer {
    private static final ResourceLocation resLoc = new ResourceLocation(ModInfo.MODID, "textures/gui/GUI_ExpGenerator.png");
    private final TEExpGenerator expGen;
    private IInventory playerInv;

    public GuiExpGenerator(EntityPlayer player, IInventory playerInv, TEExpGenerator te) {
        super(new ContainerExpGenerator(player, playerInv, te));
        this.expGen = (TEExpGenerator) te;
        this.playerInv = playerInv;
        this.xSize = 176;
        this.ySize = 166;
    }

    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
        return ((mouseX >= x && mouseX <= x + xSize) && (mouseY >= y && mouseY <= y + ySize));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(resLoc);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        if (this.expGen.getBsuStored() > 0) {
            int i = this.expGen.getBsuScaled(50);
            this.drawTexturedModalRect(this.guiLeft + 54, this.guiTop + 61 - i, 176, 0, 15, i);
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = (String.valueOf(this.expGen.getLvlStored()));
        this.fontRendererObj.drawString(s, 89 - this.fontRendererObj.getStringWidth(s) / 2, 13, 16248327);            //#404040
        this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);      //#404040

        int x = mouseX - guiLeft;
        int y = mouseY - guiTop;
        if (isInRect(53, 10, 16, 51, x, y)) {
            drawOverlay(x, y);
        }
    }

    public void drawOverlay(int mouseX, int mouseY) {
        Minecraft mc = Minecraft.getMinecraft();
        List<String> text = new ArrayList<String>();
        text.add(this.getOverlayText());

        GuiUtils.drawHoveringText(text, mouseX, mouseY, mc.displayWidth, mc.displayHeight, -1, mc.fontRendererObj);

    }

    private String getOverlayText() {
        return this.expGen.getBsuStored() + "/" + this.expGen.getBsuMax() + " BSU";
    }
}
