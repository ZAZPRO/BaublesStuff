/*
 * This class (Broken_Translator.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.items;

import md.zazpro.mod.client.CreativeTab;
import net.minecraft.item.Item;

public class Broken_Translator extends Item {
    public Broken_Translator() {
        super();
        setUnlocalizedName("Broken_Translator");
        setRegistryName("Broken_Translator");
        setMaxStackSize(64);
        setMaxDamage(0);
        setCreativeTab(CreativeTab.tabBaublesStuff);
    }
}
