/*
 * This class (LootTableBS.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.village;

import md.zazpro.mod.client.ModInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableBS {
    public static final ResourceLocation LOOT_TABLE_BS = register("loot_table_bs");

    private static ResourceLocation register(String id) {
        return LootTableList.register(new ResourceLocation(ModInfo.MODID, id));
    }
}
