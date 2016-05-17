/*
 * This class (BaublesStuffAchievement.java) was created by <zazpro>. It's distributed as
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
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class BaublesStuffAchievement {
    public static Achievement installMod;
    public static Achievement craftBelt, craftPendant, craftRing, craftMagnetRing, craftNotLMagnetRing;
    public static Achievement craftHighStep, craftSpeedI, craftSpeedII, craftSpeedIII, craftJumpI, craftJumpII, craftJumpIII, craftFly;
    public static Achievement craftFireImmune, craftFallImmune, craftWitherImmune, craftWaterBreathing, craftHealthRegen, craftVampire;
    public static Achievement craftInvisibility, craftGrowth, craftHarvest, craftRepair, craftNightVision, craftHasteI, craftHasteII, craftHasteIII, craftPowerI, craftPowerII, craftPowerIII;
    public static Achievement craftExtractor;

    public static AchievementPage BaublesAchievementPage;

    public static void loadAchievements() {
        installMod = new Achievement("achievement.bs_install", "bs_install", 0, 0, ItemsAndUpgrades.Upgrade_Stone, null).setSpecial().registerStat();

        craftExtractor = new Achievement("achievement.bs_craftExtractor", "bs_craftExtractor", -6, -4, BlockRegister.UpgradeExtractor, null).setSpecial().registerStat();


        craftBelt = new Achievement("achievement.bs_craftBelt", "bs_craftBelt", 2, 0, ItemsAndUpgrades.Belt_Core, installMod).setSpecial().registerStat();
        craftPendant = new Achievement("achievement.bs_craftPendant", "bs_craftPendant", -2, 0, ItemsAndUpgrades.Pendant_Core, installMod).setSpecial().registerStat();
        craftRing = new Achievement("achievement.bs_craftRing", "bs_craftRing", 0, 2, ItemsAndUpgrades.Ring_Core, installMod).setSpecial().registerStat();
        craftMagnetRing = new Achievement("achievement.bs_craftMagnetRing", "bs_craftMagnetRing", -1, -2, ItemsAndUpgrades.Ring_Magnet, installMod).setSpecial().registerStat();
        craftNotLMagnetRing = new Achievement("achievement.bs_craftNotLMagnetRing", "bs_craftNotLMagnetRing", 1, -2, ItemsAndUpgrades.Ring_NotLMagnet, installMod).setSpecial().registerStat();

        craftHighStep = new Achievement("achievement.bs_craftHighStep", "bs_craftHighStep", 4, -2, ItemsAndUpgrades.Upgrade_HighStep, craftBelt).registerStat();
        craftSpeedI = new Achievement("achievement.bs_craftSpeedI", "bs_craftSpeedI", 4, -1, ItemsAndUpgrades.Upgrade_SpeedI, craftBelt).registerStat();
        craftSpeedII = new Achievement("achievement.bs_craftSpeedII", "bs_craftSpeedII", 6, -1, ItemsAndUpgrades.Upgrade_SpeedII, craftSpeedI).registerStat();
        craftSpeedIII = new Achievement("achievement.bs_craftSpeedIII", "bs_craftSpeedIII", 8, -1, ItemsAndUpgrades.Upgrade_SpeedIII, craftSpeedII).registerStat();
        craftJumpI = new Achievement("achievement.bs_craftJumpI", "bs_craftJumpI", 4, 0, ItemsAndUpgrades.Upgrade_JumpI, craftBelt).registerStat();
        craftJumpII = new Achievement("achievement.bs_craftJumpII", "bs_craftJumpII", 6, 0, ItemsAndUpgrades.Upgrade_JumpII, craftJumpI).registerStat();
        craftJumpIII = new Achievement("achievement.bs_craftJumpIII", "bs_craftJumpIII", 8, 0, ItemsAndUpgrades.Upgrade_JumpIII, craftJumpII).registerStat();
        craftFly = new Achievement("achievement.bs_craftFly", "bs_craftFly", 4, 1, ItemsAndUpgrades.Upgrade_Fly, craftBelt).registerStat();


        craftFireImmune = new Achievement("achievement.bs_craftFireImmune", "bs_craftFireImmune", -4, -2, ItemsAndUpgrades.Upgrade_FireImmune, craftPendant).registerStat();
        craftFallImmune = new Achievement("achievement.bs_craftFallImmune", "bs_craftFallImmune", -4, -1, ItemsAndUpgrades.Upgrade_FallImmune, craftPendant).registerStat();
        craftWitherImmune = new Achievement("achievement.bs_craftWitherImmune", "bs_craftWitherImmune", -4, 0, ItemsAndUpgrades.Upgrade_WitherImmune, craftPendant).registerStat();
        craftWaterBreathing = new Achievement("achievement.bs_craftWaterBreathing", "bs_craftWaterBreathing", -4, 1, ItemsAndUpgrades.Upgrade_WaterBreathing, craftPendant).registerStat();
        craftHealthRegen = new Achievement("achievement.bs_craftHealthRegen", "bs_craftHealthRegen", -4, 2, ItemsAndUpgrades.Upgrade_HealthRegen, craftPendant).registerStat();
        craftVampire = new Achievement("achievement.bs_craftVampire", "bs_craftVampire", -5, 2, ItemsAndUpgrades.Upgrade_Vampire, craftHealthRegen).registerStat();

        craftInvisibility = new Achievement("achievement.bs_craftInvisibility", "bs_craftInvisibility", -2, 4, ItemsAndUpgrades.Upgrade_Invisibility, craftRing).registerStat();
        craftHasteI = new Achievement("achievement.bs_craftHasteI", "bs_craftHasteI", -1, 4, ItemsAndUpgrades.Upgrade_HasteI, craftRing).registerStat();
        craftHasteII = new Achievement("achievement.bs_craftHasteII", "bs_craftHasteII", -1, 6, ItemsAndUpgrades.Upgrade_HasteII, craftHasteI).registerStat();
        craftHasteIII = new Achievement("achievement.bs_craftHasteIII", "bs_craftHasteIII", -1, 8, ItemsAndUpgrades.Upgrade_HasteIII, craftHasteII).registerStat();
        craftGrowth = new Achievement("achievement.bs_craftGrowth", "bs_craftGrowth", 0, 4, ItemsAndUpgrades.Upgrade_Growth, craftRing).registerStat();
        craftHarvest = new Achievement("achievement.bs_craftHarvest", "bs_craftHarvest", 0, 5, ItemsAndUpgrades.Upgrade_Harvest, craftGrowth).registerStat();
        craftRepair = new Achievement("achievement.bs_craftRepair", "bs_craftRepair", 0, 6, ItemsAndUpgrades.Upgrade_Repair, craftHarvest).registerStat();
        craftPowerI = new Achievement("achievement.bs_craftPowerI", "bs_craftPowerI", 1, 4, ItemsAndUpgrades.Upgrade_PowerI, craftRing).registerStat();
        craftPowerII = new Achievement("achievement.bs_craftPowerII", "bs_craftPowerII", 1, 6, ItemsAndUpgrades.Upgrade_PowerII, craftPowerI).registerStat();
        craftPowerIII = new Achievement("achievement.bs_craftPowerIII", "bs_craftPowerIII", 1, 8, ItemsAndUpgrades.Upgrade_PowerIII, craftPowerII).registerStat();
        craftNightVision = new Achievement("achievement.bs_craftNightVision", "bs_craftNightVision", 2, 4, ItemsAndUpgrades.Upgrade_NightVision, craftRing).registerStat();


        BaublesAchievementPage = new AchievementPage("Baubles Stuff", installMod, craftBelt, craftPendant, craftRing, craftMagnetRing, craftNotLMagnetRing,
                craftHighStep, craftSpeedI, craftSpeedII, craftSpeedIII, craftJumpI, craftJumpII, craftJumpIII, craftFly,
                craftFireImmune, craftFallImmune, craftWitherImmune, craftWaterBreathing, craftHealthRegen, craftVampire,
                craftInvisibility, craftHasteI, craftHasteII, craftHasteIII, craftGrowth, craftHarvest, craftRepair, craftPowerI, craftPowerII, craftPowerIII, craftNightVision,
                craftExtractor);
    }

    public static void registerPage() {
        AchievementPage.registerAchievementPage(BaublesAchievementPage);
    }


}
