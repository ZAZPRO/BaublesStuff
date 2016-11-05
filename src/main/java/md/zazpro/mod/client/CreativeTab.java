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

import md.zazpro.mod.common.items.ItemsAndUpgrades;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab {

    public static CreativeTabs tabBaublesStuff = new CreativeTabs("TabBaublesStuff") {

        @Override
        public Item getTabIconItem() {
            return ItemsAndUpgrades.Pendant_Core;
        }
    };

    public static void TabRegister() {
    }

}

