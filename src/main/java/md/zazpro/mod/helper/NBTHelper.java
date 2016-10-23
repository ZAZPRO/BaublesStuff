package md.zazpro.mod.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {
    public static int getInteger(ItemStack stack, String name) {
        if (stack != null && stack.getTagCompound() != null && stack.getTagCompound().hasKey(name)) {
            return stack.getTagCompound().getInteger(name);
        } else return 0;
    }

    public static void checkForNBT(ItemStack stack) {
        if (stack != null) {
            if (stack.getTagCompound() == null) {
                stack.setTagCompound(new NBTTagCompound());
            }
        } else {
            System.out.println("An Error occurred while writing/reading a ItemStack");
        }
    }

    public static void setInteger(ItemStack stack, String name, int i) {
        checkForNBT(stack);
        stack.getTagCompound().setInteger(name, i);
    }
}
