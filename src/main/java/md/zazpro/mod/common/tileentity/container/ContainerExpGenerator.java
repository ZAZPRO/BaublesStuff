/*
 * This class (ContainerExpGenerator.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.tileentity.container;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import baubles.common.container.SlotBauble;
import md.zazpro.mod.common.network.MessageGenerator;
import md.zazpro.mod.common.network.PacketHandler;
import md.zazpro.mod.common.tileentity.TEExpGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerExpGenerator extends Container {
    public IBaublesItemHandler baubles;
    private TEExpGenerator te;
    private int bsu;
    private int lvl;

    public ContainerExpGenerator(EntityPlayer player, IInventory playerInv, TEExpGenerator te) {
        this.te = te;
        this.baubles = BaublesApi.getBaublesHandler(player);

        // Tile Entity, Slot 0-1, Slot IDs 0-1
        this.addSlotToContainer(new Slot(te, 0, 107, 45));
        this.addSlotToContainer(new SlotFurnaceOutput(player, te, 1, 107, 11));

        // Baubles Inventory 0-4, Slod IDs 2-5
        this.addSlotToContainer(new SlotBauble(player, this.baubles, 0, 27, 11));
        this.addSlotToContainer(new SlotBauble(player, this.baubles, 3, 27, 43));
        this.addSlotToContainer(new SlotBauble(player, this.baubles, 1, 134, 11));
        this.addSlotToContainer(new SlotBauble(player, this.baubles, 2, 134, 43));

        // Player Inventory, Slot 9-35, Slot IDs 6-32
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(playerInv, x + (y + 1) * 9, 8 + x * 18, 84 + y * 18));
            }
        }

        // Player Inventory, Slot 0-8, Slot IDs 33-41
        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if (fromSlot < 1) {
                // From TE Inventory to Player Inventory
                if (!this.mergeItemStack(current, 2, 6, true))
                    return null;
            } else {
                // From Player Inventory to TE Inventory
                if (!this.mergeItemStack(current, 0, 1, false))
                    return null;
            }

            if (current.stackSize == 0)
                slot.putStack((ItemStack) null);
            else
                slot.onSlotChanged();

            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(playerIn, current);
        }
        return previous;
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        if (this.bsu != this.te.getField(0)) {
            PacketHandler.INSTANCE.sendToAllAround(new MessageGenerator(this.te), new NetworkRegistry.TargetPoint(this.te.getWorld().provider.getDimension(), this.te.getPos().getX(), this.te.getPos().getY(), this.te.getPos().getZ(), 128d));
        }

        if (this.lvl != this.te.getField(1)) {
            PacketHandler.INSTANCE.sendToAllAround(new MessageGenerator(this.te), new NetworkRegistry.TargetPoint(this.te.getWorld().provider.getDimension(), this.te.getPos().getX(), this.te.getPos().getY(), this.te.getPos().getZ(), 128d));
        }

        this.bsu = this.te.getField(0);
        this.lvl = this.te.getField(0);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.te.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return te.isUseableByPlayer(playerIn);
    }
}
