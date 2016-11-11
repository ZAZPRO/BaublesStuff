/*
 * This class (CreativeTab.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.client;

import md.zazpro.mod.common.energy.BaubleBSUContainer;
import md.zazpro.mod.common.items.ItemsAndUpgrades;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTab {
    static ItemStack itemStack = null;
    public static CreativeTabs tabBaublesStuff = new CreativeTabs("TabBaublesStuff") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return ItemsAndUpgrades.Pendant_Core;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getIconItemStack() {
            if (itemStack == null) {
                itemStack = new ItemStack(ItemsAndUpgrades.Pendant_Core);
                ((BaubleBSUContainer)ItemsAndUpgrades.Pendant_Core).setBSUStored(itemStack,((BaubleBSUContainer) itemStack.getItem()).getMaxBSUStored(itemStack));
            }
            return itemStack;
        }
    };

    public static void TabRegister() {
    }

}

