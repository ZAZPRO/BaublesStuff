/*
 * This class (VillageStuff.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.village;

import md.zazpro.mod.common.items.ItemsAndUpgrades;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class VillageStuff {

    final static EntityVillager.ITradeList[][] masterTrades = {
            {
                    new EntityVillager.EmeraldForItems(ItemsAndUpgrades.Upgrade_Stone, new EntityVillager.PriceInfo(1, 1))
                    , new EntityVillager.EmeraldForItems(ItemsAndUpgrades.Spell_Book, new EntityVillager.PriceInfo(3, 5))
                    , new EntityVillager.EmeraldForItems(ItemsAndUpgrades.Translator, new EntityVillager.PriceInfo(5, 8))},
    };

    public static void preInit() {
        VillagerRegistry villagerRegistry = VillagerRegistry.instance();
        VillageCreationHandler villageBS = new VillageCreationHandler();
        villagerRegistry.registerVillageCreationHandler(villageBS);

        VillagerRegistry.VillagerProfession prof = new VillagerRegistry.VillagerProfession("baublesstuff:villager", "baublesstuff:textures/village/bsvillager.png", "minecraft:textures/entity/zombie_villager/zombie_villager.png");
        villagerRegistry.register(prof);
        VillagerRegistry.VillagerCareer master = new VillagerRegistry.VillagerCareer(prof, "baublesmaster");

        master.addTrade(1,
                new EntityVillager.EmeraldForItems(ItemsAndUpgrades.Upgrade_Stone, new EntityVillager.PriceInfo(18, 22)),
                new EntityVillager.ListItemForEmeralds(ItemsAndUpgrades.Upgrade_FallImmune, new EntityVillager.PriceInfo(8, 6))
        );

        master.addTrade(2,
                new EntityVillager.ItemAndEmeraldToItem(ItemsAndUpgrades.Upgrade_SpeedIII, new EntityVillager.PriceInfo(1, 1), Items.EMERALD, new EntityVillager.PriceInfo(2, 2)),
                new EntityVillager.ListItemForEmeralds(ItemsAndUpgrades.Spell_Book, new EntityVillager.PriceInfo(3, 5))
        );

        master.addTrade(3,
                new EntityVillager.ItemAndEmeraldToItem(ItemsAndUpgrades.Upgrade_Fly, new EntityVillager.PriceInfo(1, 1), Items.EMERALD, new EntityVillager.PriceInfo(3, 4)),
                new EntityVillager.ListItemForEmeralds(ItemsAndUpgrades.Translator, new EntityVillager.PriceInfo(5, 8))
        );

        try {
            MapGenStructureIO.registerStructureComponent(ComponentBSHouse.class, "BSHouse");
        } catch (Throwable e) {
            System.out.println("[BaublesStuff] Village house could not be registered.");
        }
    }

    public static void init() {

    }

}
