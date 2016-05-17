/*
 * This class (AchievementEvents.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.achievements;

import md.zazpro.mod.common.blocks.BlockRegister;
import md.zazpro.mod.common.items.ItemsAndUpgrades;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class AchievementEvents {

    @SubscribeEvent
    public void onPlayerLogin(PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        player.addStat(BaublesStuffAchievement.installMod, 1);
    }

    @SubscribeEvent
    public void onPlayerCrafted(ItemCraftedEvent event) {
        if (event.crafting.getItem() == Item.getItemFromBlock(BlockRegister.UpgradeExtractor)) {
            event.player.addStat(BaublesStuffAchievement.craftExtractor, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Belt_Core) {
            event.player.addStat(BaublesStuffAchievement.craftBelt, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Pendant_Core) {
            event.player.addStat(BaublesStuffAchievement.craftPendant, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Ring_Core) {
            event.player.addStat(BaublesStuffAchievement.craftRing, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Ring_Magnet) {
            event.player.addStat(BaublesStuffAchievement.craftMagnetRing, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Ring_NotLMagnet) {
            event.player.addStat(BaublesStuffAchievement.craftNotLMagnetRing, 1);
        }

        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_HighStep) {
            event.player.addStat(BaublesStuffAchievement.craftHighStep, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_SpeedI) {
            event.player.addStat(BaublesStuffAchievement.craftSpeedI, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_SpeedII) {
            event.player.addStat(BaublesStuffAchievement.craftSpeedII, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_SpeedIII) {
            event.player.addStat(BaublesStuffAchievement.craftSpeedIII, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_JumpI) {
            event.player.addStat(BaublesStuffAchievement.craftJumpI, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_JumpII) {
            event.player.addStat(BaublesStuffAchievement.craftJumpII, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_JumpIII) {
            event.player.addStat(BaublesStuffAchievement.craftJumpIII, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_Fly) {
            event.player.addStat(BaublesStuffAchievement.craftFly, 1);
        }

        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_FireImmune) {
            event.player.addStat(BaublesStuffAchievement.craftFireImmune, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_FallImmune) {
            event.player.addStat(BaublesStuffAchievement.craftFallImmune, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_WitherImmune) {
            event.player.addStat(BaublesStuffAchievement.craftWitherImmune, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_WaterBreathing) {
            event.player.addStat(BaublesStuffAchievement.craftWaterBreathing, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_Vampire) {
            event.player.addStat(BaublesStuffAchievement.craftVampire, 1);
        }

        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_Invisibility) {
            event.player.addStat(BaublesStuffAchievement.craftInvisibility, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_HasteI) {
            event.player.addStat(BaublesStuffAchievement.craftHasteI, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_HasteII) {
            event.player.addStat(BaublesStuffAchievement.craftHasteII, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_HasteIII) {
            event.player.addStat(BaublesStuffAchievement.craftHasteIII, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_HealthRegen) {
            event.player.addStat(BaublesStuffAchievement.craftHealthRegen, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_PowerI) {
            event.player.addStat(BaublesStuffAchievement.craftPowerI, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_PowerII) {
            event.player.addStat(BaublesStuffAchievement.craftPowerII, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_PowerIII) {
            event.player.addStat(BaublesStuffAchievement.craftPowerIII, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_NightVision) {
            event.player.addStat(BaublesStuffAchievement.craftNightVision, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_Growth) {
            event.player.addStat(BaublesStuffAchievement.craftGrowth, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_Harvest) {
            event.player.addStat(BaublesStuffAchievement.craftHarvest, 1);
        }
        if (event.crafting.getItem() == ItemsAndUpgrades.Upgrade_Repair) {
            event.player.addStat(BaublesStuffAchievement.craftRepair, 1);
        }
    }
}
