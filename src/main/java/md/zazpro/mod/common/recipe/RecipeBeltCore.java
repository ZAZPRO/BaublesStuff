package md.zazpro.mod.common.recipe;

import md.zazpro.mod.common.baubles.Belt_Core;
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

public class RecipeBeltCore implements IRecipe {

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
            if (inventory.getStackInSlot(i) != null && inventory.getStackInSlot(i).getItem() == ItemsAndUpgrades.Belt_Core) {
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
            if (inventory.getStackInSlot(i) != null && inventory.getStackInSlot(i).getItem() == ItemsAndUpgrades.Belt_Core) {
                currentStack = inventory.getStackInSlot(i).copy();

                if (currentStack != null && !currentStack.hasTagCompound()) {
                    NBTTagCompound tag = new NBTTagCompound();
                    tag.setBoolean("highStep", false);
                    tag.setInteger("speed", 0);
                    tag.setFloat("jump", 0);
                    tag.setFloat("fallBuffer", 0);
                    tag.setBoolean("fly", false);
                    currentStack.setTagCompound(tag);
                }

                for (int ii = 0; ii < inventory.getSizeInventory(); ii++) {
                    ItemStack currentStack2 = inventory.getStackInSlot(ii);
                    if (currentStack2 != null) {

                        if (currentStack.getItem() == ItemsAndUpgrades.Belt_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_HighStep && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("highStep", true);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Belt_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_SpeedI && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setInteger("speed", 1);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Belt_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_SpeedII && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setInteger("speed", 2);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Belt_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_SpeedIII && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setInteger("speed", 3);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Belt_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_JumpI && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setFloat("jump", 0.2F);
                            currentStack.getTagCompound().setFloat("fallBuffer", 2F);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Belt_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_JumpII && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setFloat("jump", 0.3F);
                            currentStack.getTagCompound().setFloat("fallBuffer", 3F);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Belt_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_JumpIII && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setFloat("jump", 0.4F);
                            currentStack.getTagCompound().setFloat("fallBuffer", 4F);
                        }

                        if (currentStack.getItem() == ItemsAndUpgrades.Belt_Core && currentStack2.getItem() == ItemsAndUpgrades.Upgrade_Fly && currentStack != null && currentStack.hasTagCompound()) {
                            currentStack.getTagCompound().setBoolean("fly", true);
                        }

                    }
                }
            }
        }

        if (currentStack != null)
            for (int i = 0; i < inventory.getSizeInventory(); i++)
                if (inventory.getStackInSlot(i) != null && !(inventory.getStackInSlot(i).getItem() instanceof Belt_Core)) {
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
