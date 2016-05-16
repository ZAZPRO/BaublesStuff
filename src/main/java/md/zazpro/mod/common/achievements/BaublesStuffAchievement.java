package md.zazpro.mod.common.achievements;

import md.zazpro.mod.common.blocks.BlockRegister;
import md.zazpro.mod.common.items.ItemsAndUpgrades;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class BaublesStuffAchievement {
    public static Achievement installMod;
    public static Achievement craftBelt, craftPendant, craftRing, craftMagnetRing, craftNotLMagnetRing;
    public static Achievement craftHighStep, craftSpeedI, craftSpeedII, craftSpeedIII, craftJumpI, craftJumpII, craftJumpIII, craftFly;
    public static Achievement craftFireImmune, craftFallImmune, craftWitherImmune, craftWaterBreathing, craftHealthRegen;
    public static Achievement craftInvisibility, craftGrowth, craftRepair, craftNightVision, craftHasteI, craftHasteII, craftHasteIII, craftPowerI, craftPowerII, craftPowerIII;
    public static Achievement craftExtractor;

    public static AchievementPage BaublesAchievementPage;

    public static void loadAchievements() {
        installMod = new Achievement("achievement.bs_install", "bs_install", 0, 0, ItemsAndUpgrades.Upgrade_Stone, null).setSpecial();
        installMod.registerStat();

        craftExtractor = new Achievement("achievement.bs_craftExtractor", "bs_craftExtractor", -6, -4, BlockRegister.UpgradeExtractor, null).setSpecial();
        craftExtractor.registerStat();

        craftBelt = new Achievement("achievement.bs_craftBelt", "bs_craftBelt", 2, 0, ItemsAndUpgrades.Belt_Core, installMod).setSpecial();
        craftBelt.registerStat();
        craftPendant = new Achievement("achievement.bs_craftPendant", "bs_craftPendant", -2, 0, ItemsAndUpgrades.Pendant_Core, installMod).setSpecial();
        craftPendant.registerStat();
        craftRing = new Achievement("achievement.bs_craftRing", "bs_craftRing", 0, 2, ItemsAndUpgrades.Ring_Core, installMod).setSpecial();
        craftRing.registerStat();
        craftMagnetRing = new Achievement("achievement.bs_craftMagnetRing", "bs_craftMagnetRing", -1, -2, ItemsAndUpgrades.Ring_Magnet, installMod).setSpecial();
        craftMagnetRing.registerStat();
        craftNotLMagnetRing = new Achievement("achievement.bs_craftNotLMagnetRing", "bs_craftNotLMagnetRing", 1, -2, ItemsAndUpgrades.Ring_NotLMagnet, installMod).setSpecial();
        craftNotLMagnetRing.registerStat();

        craftHighStep = new Achievement("achievement.bs_craftHighStep", "bs_craftHighStep", 4, -2, ItemsAndUpgrades.Upgrade_HighStep, craftBelt);
        craftHighStep.registerStat();
        craftSpeedI = new Achievement("achievement.bs_craftSpeedI", "bs_craftSpeedI", 4, -1, ItemsAndUpgrades.Upgrade_SpeedI, craftBelt);
        craftSpeedI.registerStat();
        craftSpeedII = new Achievement("achievement.bs_craftSpeedII", "bs_craftSpeedII", 6, -1, ItemsAndUpgrades.Upgrade_SpeedII, craftSpeedI);
        craftSpeedII.registerStat();
        craftSpeedIII = new Achievement("achievement.bs_craftSpeedIII", "bs_craftSpeedIII", 8, -1, ItemsAndUpgrades.Upgrade_SpeedIII, craftSpeedII);
        craftSpeedIII.registerStat();
        craftJumpI = new Achievement("achievement.bs_craftJumpI", "bs_craftJumpI", 4, 0, ItemsAndUpgrades.Upgrade_JumpI, craftBelt);
        craftJumpI.registerStat();
        craftJumpII = new Achievement("achievement.bs_craftJumpII", "bs_craftJumpII", 6, 0, ItemsAndUpgrades.Upgrade_JumpII, craftJumpI);
        craftJumpII.registerStat();
        craftJumpIII = new Achievement("achievement.bs_craftJumpIII", "bs_craftJumpIII", 8, 0, ItemsAndUpgrades.Upgrade_JumpIII, craftJumpII);
        craftJumpIII.registerStat();
        craftFly = new Achievement("achievement.bs_craftFly", "bs_craftFly", 4, 1, ItemsAndUpgrades.Upgrade_Fly, craftBelt);
        craftFly.registerStat();

        craftFireImmune = new Achievement("achievement.bs_craftFireImmune", "bs_craftFireImmune", -4, -2, ItemsAndUpgrades.Upgrade_FireImmune, craftPendant);
        craftFireImmune.registerStat();
        craftFallImmune = new Achievement("achievement.bs_craftFallImmune", "bs_craftFallImmune", -4, -1, ItemsAndUpgrades.Upgrade_FallImmune, craftPendant);
        craftFallImmune.registerStat();
        craftWitherImmune = new Achievement("achievement.bs_craftWitherImmune", "bs_craftWitherImmune", -4, 0, ItemsAndUpgrades.Upgrade_WitherImmune, craftPendant);
        craftWitherImmune.registerStat();
        craftWaterBreathing = new Achievement("achievement.bs_craftWaterBreathing", "bs_craftWaterBreathing", -4, 1, ItemsAndUpgrades.Upgrade_WaterBreathing, craftPendant);
        craftWaterBreathing.registerStat();
        craftHealthRegen = new Achievement("achievement.bs_craftHealthRegen", "bs_craftHealthRegen", -4, 2, ItemsAndUpgrades.Upgrade_HealthRegen, craftPendant);
        craftHealthRegen.registerStat();

        craftInvisibility = new Achievement("achievement.bs_craftInvisibility", "bs_craftInvisibility", -2, 4, ItemsAndUpgrades.Upgrade_Invisibility, craftRing);
        craftInvisibility.registerStat();
        craftHasteI = new Achievement("achievement.bs_craftHasteI", "bs_craftHasteI", -1, 4, ItemsAndUpgrades.Upgrade_HasteI, craftRing);
        craftHasteI.registerStat();
        craftHasteII = new Achievement("achievement.bs_craftHasteII", "bs_craftHasteII", -1, 6, ItemsAndUpgrades.Upgrade_HasteII, craftHasteI);
        craftHasteII.registerStat();
        craftHasteIII = new Achievement("achievement.bs_craftHasteIII", "bs_craftHasteIII", -1, 8, ItemsAndUpgrades.Upgrade_HasteIII, craftHasteII);
        craftHasteIII.registerStat();
        craftGrowth = new Achievement("achievement.bs_craftGrowth", "bs_craftGrowth", 0, 4, ItemsAndUpgrades.Upgrade_Growth, craftRing);
        craftGrowth.registerStat();
        craftRepair = new Achievement("achievement.bs_craftRepair", "bs_craftRepair", 0, 5, ItemsAndUpgrades.Upgrade_Repair, craftGrowth);
        craftRepair.registerStat();
        craftPowerI = new Achievement("achievement.bs_craftPowerI", "bs_craftPowerI", 1, 4, ItemsAndUpgrades.Upgrade_PowerI, craftRing);
        craftPowerI.registerStat();
        craftPowerII = new Achievement("achievement.bs_craftPowerII", "bs_craftPowerII", 1, 6, ItemsAndUpgrades.Upgrade_PowerII, craftPowerI);
        craftPowerII.registerStat();
        craftPowerIII = new Achievement("achievement.bs_craftPowerIII", "bs_craftPowerIII", 1, 8, ItemsAndUpgrades.Upgrade_PowerIII, craftPowerII);
        craftPowerIII.registerStat();
        craftNightVision = new Achievement("achievement.bs_craftNightVision", "bs_craftNightVision", 2, 4, ItemsAndUpgrades.Upgrade_NightVision, craftRing);
        craftNightVision.registerStat();

        BaublesAchievementPage = new AchievementPage("Baubles Stuff", installMod, craftBelt, craftPendant, craftRing, craftMagnetRing, craftNotLMagnetRing,
                craftHighStep, craftSpeedI, craftSpeedII, craftSpeedIII, craftJumpI, craftJumpII, craftJumpIII, craftFly,
                craftFireImmune, craftFallImmune, craftWitherImmune, craftWaterBreathing, craftHealthRegen,
                craftInvisibility, craftHasteI, craftHasteII, craftHasteIII, craftGrowth, craftRepair, craftPowerI, craftPowerII, craftPowerIII, craftNightVision,
                craftExtractor);
    }

    public static void registerPage() {
        AchievementPage.registerAchievementPage(BaublesAchievementPage);
    }


}
