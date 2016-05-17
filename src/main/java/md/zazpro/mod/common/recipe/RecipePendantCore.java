/*
 * This class (RecipePendantCore.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.recipe;

import md.zazpro.mod.common.baubles.Pendant_Core;
import md.zazpro.mod.common.items.ItemsAndUpgrades;
import md.zazpro.mod.interfaces.IUpgrade;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.Constants;

public class RecipePendantCore implements IRecipe {

    public static void addItemStackToBauble(ItemStack is, ItemStack to) {
        if (!is.hasTagCompound())
            is.setTagCompound(new NBTTagCompound());
        NBTTagList tag = is.getTagCompound().getTagList("ItemStacksInBauble", Constants.NBT.TAG_COMPOUND);
        Item ito = to.getItem();
        if (to == null || !(ito instanceof IUpgrade))
            return;
        for (int i = 0; i < is.getTagCompound().getTagList("ItemStacksInBauble", Constants.NBT.TAG_COMPOUND).tagCount(); i++) {
            NBTTagCompound item = is.getTagCompound().getTagList("ItemStacksInBauble", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i);
            if (item.getShort("id") == Item.getIdFromItem(to.getItem()) && item instanceof IUpgrade) {
                is.getTagCompound().setTag("ItemStacksInBauble", tag);
                return;
            }
        }
        NBTTagCompound item = new NBTTagCompound();
        to.writeToNBT(item);
        tag.appendTag(item);
        is.getTagCompound().setTag("ItemStacksInBauble", tag);
    }

    @Override
    public boolean matches(InventoryCrafting inventory, World world) {
        for (int i = 0; i < inventory.getSizeInventory(); i++)
            if (inventory.getStackInSlot(i) != null && inventory.getStackInSlot(i).getItem() == ItemsAndUpgrades.Pendant_Core) {
                for (int ii = 0; ii < inventory.getSizeInventory(); ii++)
                    if (inventory.getStackInSlot(ii) != null && inventory.getStackInSlot(ii).getItem() instanceof IUpgrade)
                        return true;
            }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventory) {
        ItemStack currentStack = null;
        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            if (inventory.getStackInSlot(i) != null && inventory.getStackInSlot(i).getItem() == ItemsAndUpgrades.Pendant_Core) {
                currentStack = inventory.getStackInSlot(i).copy();

                if (currentStack != null && !currentStack.hasTagCompound()) {
                    NBTTagCompound tag = new NBTTagCompound();
                    tag.setBoolean("FireImmune", false);
                    tag.setBoolean("FallImmune", false);
                    tag.setBoolean("WaterBreathing", false);
                    tag.setBoolean("WitherImmune", false);
                    tag.setBoolean("HealthRegen", false);
                    tag.setBoolean("Vampire", false);
                    currentStack.setTagCompound(tag);
                }

                for (int ii = 0; ii < inventory.getSizeInventory(); ii++) {
                    ItemStack currentStack2 = inventory.getStackInSlot(ii);
                    if (currentStack2 != null) {
                        if (currentStack.getItem() == ItemsAndUpgrades.Pendant_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_FireImmune && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("FireImmune", true);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Pendant_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_FallImmune && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("FallImmune", true);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Pendant_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_WaterBreathing && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("WaterBreathing", true);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Pendant_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_WitherImmune && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("WitherImmune", true);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Pendant_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_HealthRegen && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("HealthRegen", true);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Pendant_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_Vampire && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("Vampire", true);
                        }

                    }
                }
            }
        }

        if (currentStack != null)
            for (int i = 0; i < inventory.getSizeInventory(); i++)
                if (inventory.getStackInSlot(i) != null && !(inventory.getStackInSlot(i).getItem() instanceof Pendant_Core)) {
                    ItemStack is1 = inventory.getStackInSlot(i).copy();
                    is1.stackSize = 1;
                    addItemStackToBauble(currentStack, is1);
                }
        return currentStack;
    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        return ForgeHooks.defaultRecipeGetRemainingItems(inv);
    }

}
