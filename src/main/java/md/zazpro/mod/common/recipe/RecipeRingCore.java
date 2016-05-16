package md.zazpro.mod.common.recipe;

import md.zazpro.mod.common.baubles.Ring_Core;
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

public class RecipeRingCore implements IRecipe {

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
            if (inventory.getStackInSlot(i) != null && inventory.getStackInSlot(i).getItem() == ItemsAndUpgrades.Ring_Core) {
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
            if (inventory.getStackInSlot(i) != null && inventory.getStackInSlot(i).getItem() == ItemsAndUpgrades.Ring_Core) {
                currentStack = inventory.getStackInSlot(i).copy();

                if (currentStack != null && !currentStack.hasTagCompound()) {
                    NBTTagCompound tag = new NBTTagCompound();
                    tag.setBoolean("Invisibility", false);
                    tag.setBoolean("NightVision", false);
                    tag.setBoolean("Growth", false);
                    tag.setBoolean("Repair", false);
                    tag.setFloat("Haste", 0);
                    tag.setInteger("Power", 0);
                    currentStack.setTagCompound(tag);
                }

                for (int ii = 0; ii < inventory.getSizeInventory(); ii++) {
                    ItemStack currentStack2 = inventory.getStackInSlot(ii);
                    if (currentStack2 != null) {
                        if (currentStack.getItem() == ItemsAndUpgrades.Ring_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_Invisibility && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("Invisibility", true);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Ring_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_NightVision && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("NightVision", true);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Ring_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_Growth && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("Growth", true);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Ring_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_Repair && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("Repair", true);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Ring_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_HasteI && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setFloat("Haste", 5);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Ring_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_HasteII && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setFloat("Haste", 10);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Ring_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_HasteIII && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setFloat("Haste", 20);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Ring_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_PowerI && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setInteger("Power", 3);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Ring_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_PowerII && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setInteger("Power", 5);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Ring_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_PowerIII && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setInteger("Power", 10);
                        }

                    }
                }
            }
        }
        if (currentStack != null)
            for (int i = 0; i < inventory.getSizeInventory(); i++)
                if (inventory.getStackInSlot(i) != null && !(inventory.getStackInSlot(i).getItem() instanceof Ring_Core)) {
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
