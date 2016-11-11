/*
 * This class (BSGuiHandler.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.client.gui;

import md.zazpro.mod.common.tileentity.TEBookGenerator;
import md.zazpro.mod.common.tileentity.TEExpGenerator;
import md.zazpro.mod.common.tileentity.container.ContainerBookGenerator;
import md.zazpro.mod.common.tileentity.container.ContainerExpGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class BSGuiHandler implements IGuiHandler {
    public static final int EXP_GEN_TILE_ENTITY_GUI = 20;
    public static final int BOOK_GEN_TILE_ENTITY_GUI = 21;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == EXP_GEN_TILE_ENTITY_GUI)
            return new ContainerExpGenerator(player, player.inventory, (TEExpGenerator) world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == BOOK_GEN_TILE_ENTITY_GUI)
            return new ContainerBookGenerator(player, player.inventory, (TEBookGenerator) world.getTileEntity(new BlockPos(x, y, z)));

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == EXP_GEN_TILE_ENTITY_GUI)
            return new GuiExpGenerator(player, player.inventory, (TEExpGenerator) world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == BOOK_GEN_TILE_ENTITY_GUI)
            return new GuiBookGenerator(player, player.inventory, (TEBookGenerator) world.getTileEntity(new BlockPos(x, y, z)));

        return null;
    }
}
