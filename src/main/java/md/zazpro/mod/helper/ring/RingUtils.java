/*
 * This class (RingUtils.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.helper.ring;

import md.zazpro.mod.common.items.ItemsAndUpgrades;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RingUtils {

    public static boolean isLegalb(ItemStack is1, ItemStack is2, String tag) {
        Item item1 = null;
        Item item2 = null;
        if (is1 != null)
            item1 = is1.getItem();
        if (is2 != null)
            item2 = is2.getItem();
        return ((is1 != null && item1 == ItemsAndUpgrades.Ring_Core && is1.getTagCompound() != null && is1.getTagCompound().getBoolean(tag))
                || (is2 != null && item2 == ItemsAndUpgrades.Ring_Core && is2.getTagCompound() != null && is2.getTagCompound().getBoolean(tag)))
                && (item1 != item2);
    }

    public static boolean isLegalf(ItemStack is1, ItemStack is2, String tag) {
        Item item1 = null;
        Item item2 = null;
        if (is1 != null)
            item1 = is1.getItem();
        if (is2 != null)
            item2 = is2.getItem();
        return ((is1 != null && item1 == ItemsAndUpgrades.Ring_Core && is1.getTagCompound() != null && (is1.getTagCompound().getFloat(tag) > 0))
                || (is2 != null && item2 == ItemsAndUpgrades.Ring_Core && is2.getTagCompound() != null && (is2.getTagCompound().getFloat(tag) > 0)))
                && (item1 != item2);
    }

    public static float getFloatFromBauble(ItemStack is1, ItemStack is2, String tag) {
        float f = 0;
        if (is1 != null && is1.getTagCompound().getFloat(tag) > 0)
            f = is1.getTagCompound().getFloat(tag);
        else if (is2 != null && is2.getTagCompound().getFloat(tag) > 0)
            f = is2.getTagCompound().getFloat(tag);

        return f;
    }

    public static boolean isLegali(ItemStack is1, ItemStack is2, String tag) {
        Item item1 = null;
        Item item2 = null;
        if (is1 != null)
            item1 = is1.getItem();
        if (is2 != null)
            item2 = is2.getItem();
        return ((is1 != null && item1 == ItemsAndUpgrades.Ring_Core && is1.getTagCompound() != null && (is1.getTagCompound().getInteger(tag) > 0))
                || (is2 != null && item2 == ItemsAndUpgrades.Ring_Core && is2.getTagCompound() != null && (is2.getTagCompound().getInteger(tag) > 0)))
                && (item1 != item2);
    }

    public static int getIntFromBauble(ItemStack is1, ItemStack is2, String tag) {
        int i = 0;
        if (is1 != null && is1.getTagCompound().getInteger(tag) > 0)
            i = is1.getTagCompound().getInteger(tag);
        else if (is2 != null && is2.getTagCompound().getInteger(tag) > 0)
            i = is2.getTagCompound().getInteger(tag);

        return i;
    }

    public static ItemStack getStackFromBoolean(ItemStack is1, ItemStack is2, String tag) {
        ItemStack itemStack = null;
        if (is1 != null && is1.hasTagCompound() && is1.getTagCompound().getBoolean(tag))
            itemStack = is1;
        else if (is2 != null && is2.hasTagCompound() && is2.getTagCompound().getBoolean(tag))
            itemStack = is2;
        return itemStack;
    }

    public static ItemStack getStackFromFloat(ItemStack is1, ItemStack is2, String tag) {
        ItemStack itemStack = null;
        if (is1 != null && is1.hasTagCompound() && is1.getTagCompound().getFloat(tag) > 0)
            itemStack = is1;
        else if (is2 != null && is2.hasTagCompound() && is2.getTagCompound().getFloat(tag) > 0)
            itemStack = is2;
        return itemStack;
    }

    public static ItemStack getStackFromInt(ItemStack is1, ItemStack is2, String tag) {
        ItemStack itemStack = null;
        if (is1 != null && is1.hasTagCompound() && is1.getTagCompound().getInteger(tag) > 0)
            itemStack = is1;
        else if (is2 != null && is2.hasTagCompound() && is2.getTagCompound().getInteger(tag) > 0)
            itemStack = is2;

        return itemStack;
    }
}
