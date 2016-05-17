/*
 * This class (ConfigurationHandler.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.config;

import md.zazpro.mod.client.ModInfo;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static final String CAT_UPDATE = "update check";
    public static final String CAT_BCRAFT = "baubles crafting";
    public static final String CAT_UCRAFT = "upgades crafting";
    //public static final String CAT_VILLAGE = "village stuff";
    public static final String CAT_MODCOMP = "mod compatibility";
    public static final String CAT_BTWEAK = "balance tweak";
    public static final String s1 = "Is ";
    public static final String s2 = " recipe enabled";
    public static Configuration configuration;
    public static boolean CUpdate;
    public static boolean CRarmor;
    public static boolean CUpgrade_Fly, CUpgrade_FireImmune, CUpgrade_Vampire, CUpgrade_HighStep, CUpgrade_FallImmune, CUpgrade_WaterBreathing, CUpgrade_SpeedI, CUpgrade_SpeedII, CUpgrade_SpeedIII;
    public static boolean CUpgrade_JumpI, CUpgrade_JumpII, CUpgrade_JumpIII, CUpgrade_WitherImmune, CMagnetRing, CUpgrade_HealthRegen, CUpgrade_Invisibility, CNotLMagnetRing;
    public static boolean CUpgrade_HasteI, CUpgrade_HasteII, CUpgrade_HasteIII, CUpgrade_PowerI, CUpgrade_PowerII, CUpgrade_PowerIII, CUpgrade_NightVision, CUpgrade_Growth, CUpgrade_Repair, CUpgrade_Harvest;

    public static int MagnetRange;
    public static int GrowthChance;
    public static int RepairChance;
    public static int VampireAmount;
    public static int TranslatorChance;
    public static int TranslatorDurability;
    public static int BookChance;

    //public static int villagerId;

    public static void loadConfig(File configFile) {
        if (configuration == null)
            configuration = new Configuration(configFile);

        configuration.load();
        loadValues();

        MinecraftForge.EVENT_BUS.register(new ChangeHandler());
    }

    private static void loadValues() {
        configuration.getCategory(CAT_UPDATE).setComment("Check for new mod version?");
        CUpdate = configuration.get(CAT_UPDATE, "Check for updates", true, "Disable version check").getBoolean();

        configuration.getCategory(CAT_UCRAFT).setComment("Can you craft this upgrade?");
        configuration.setCategoryRequiresMcRestart(CAT_UCRAFT, true);

        CUpgrade_Fly = configuration.get(CAT_UCRAFT, "Flying Upgrade", true, s1 + "Flying Upgrade" + s2).getBoolean();
        CUpgrade_HighStep = configuration.get(CAT_UCRAFT, "HighStep Upgrade", true, s1 + "HighStep Upgrade" + s2).getBoolean();
        CUpgrade_SpeedI = configuration.get(CAT_UCRAFT, "Speed Upgrade I", true, s1 + "Speed Upgrade I" + s2).getBoolean();
        CUpgrade_SpeedII = configuration.get(CAT_UCRAFT, "Speed Upgrade II", true, s1 + "Speed Upgrade II" + s2).getBoolean();
        CUpgrade_SpeedIII = configuration.get(CAT_UCRAFT, "Speed Upgrade III", true, s1 + "Speed Upgrade III" + s2).getBoolean();
        CUpgrade_JumpI = configuration.get(CAT_UCRAFT, "Jump Upgrade I", true, s1 + "Jump Upgrade I" + s2).getBoolean();
        CUpgrade_JumpII = configuration.get(CAT_UCRAFT, "Jump Upgrade II", true, s1 + "Jump Upgrade II" + s2).getBoolean();
        CUpgrade_JumpIII = configuration.get(CAT_UCRAFT, "Jump Upgrade III", true, s1 + "Jump Upgrade III" + s2).getBoolean();
        CUpgrade_HasteI = configuration.get(CAT_UCRAFT, "Haste Upgrade I", true, s1 + "Haste Upgrade I" + s2).getBoolean();
        CUpgrade_HasteII = configuration.get(CAT_UCRAFT, "Haste Upgrade II", true, s1 + "Haste Upgrade II" + s2).getBoolean();
        CUpgrade_HasteIII = configuration.get(CAT_UCRAFT, "Haste Upgrade III", true, s1 + "Haste Upgrade III" + s2).getBoolean();
        CUpgrade_PowerI = configuration.get(CAT_UCRAFT, "Power Upgrade I", true, s1 + "Power Upgrade I" + s2).getBoolean();
        CUpgrade_PowerII = configuration.get(CAT_UCRAFT, "Power Upgrade II", true, s1 + "Power Upgrade II" + s2).getBoolean();
        CUpgrade_PowerIII = configuration.get(CAT_UCRAFT, "Power Upgrade III", true, s1 + "Power Upgrade III" + s2).getBoolean();
        CUpgrade_FireImmune = configuration.get(CAT_UCRAFT, "Fire Immune Upgrade", true, s1 + "Fire Immune Upgrade" + s2).getBoolean();
        CUpgrade_FallImmune = configuration.get(CAT_UCRAFT, "Fall Damage Immune Upgrade", true, s1 + "Fall Damage Immune Upgrade" + s2).getBoolean();
        CUpgrade_WaterBreathing = configuration.get(CAT_UCRAFT, "Water Breathing Upgrade", true, s1 + "Water Breathing Upgrade" + s2).getBoolean();
        CUpgrade_WitherImmune = configuration.get(CAT_UCRAFT, "Wither Immune Upgrade", true, s1 + "Wither Immune Upgrade" + s2).getBoolean();
        CUpgrade_HealthRegen = configuration.get(CAT_UCRAFT, "Health Regen Upgrade", true, s1 + "Health Regen Upgrade" + s2).getBoolean();
        CUpgrade_Invisibility = configuration.get(CAT_UCRAFT, "Invisibility Upgrade", true, s1 + "Invisibility Upgrade" + s2).getBoolean();
        CUpgrade_NightVision = configuration.get(CAT_UCRAFT, "Night Vision Upgrade", true, s1 + "Night Vision Upgradee" + s2).getBoolean();
        CUpgrade_Growth = configuration.get(CAT_UCRAFT, "Plant Acceleration Upgrade", true, s1 + "Plant Acceleration Upgrade" + s2).getBoolean();
        CUpgrade_Repair = configuration.get(CAT_UCRAFT, "Stuff Repairing Upgrade", true, s1 + "Stuff Repairing Upgrade" + s2).getBoolean();
        CUpgrade_Harvest = configuration.get(CAT_UCRAFT, "Plant Harvest Upgrade", true, s1 + "Plant Harvest Upgrade" + s2).getBoolean();

        configuration.getCategory(CAT_BCRAFT).setComment("Can you craft this bauble?");
        configuration.setCategoryRequiresMcRestart(CAT_BCRAFT, true);
        CMagnetRing = configuration.get(CAT_BCRAFT, "Magnet Ring", true, s1 + "Magnet Ring" + s2).getBoolean();
        CNotLMagnetRing = configuration.get(CAT_BCRAFT, "Instantaneous Magnet Ring", true, s1 + "Instantaneous Magnet Ring" + s2).getBoolean();

        //    configuration.getCategory(CAT_VILLAGE).setComment("Configure village stuff here");
        //    configuration.setCategoryRequiresMcRestart(CAT_VILLAGE, true);
        //    villagerId = configuration.get(CAT_VILLAGE, "Villager ID", 20, "If you have crash of village ID change this").getInt();

        configuration.getCategory(CAT_MODCOMP).setComment("Configure mod compatibility here");
        configuration.setCategoryRequiresMcRestart(CAT_MODCOMP, true);
        CRarmor = configuration.get(CAT_MODCOMP, "RArmor compatibility", true, "Set it to false to turn off RArmor compatibility").getBoolean();

        configuration.getCategory(CAT_BTWEAK).setComment("Configure balance of the mod here");
        MagnetRange = configuration.get(CAT_BTWEAK, "Magnets Range", 16, "Magnets Range # Default value=16.0").getInt();
        TranslatorChance = configuration.get(CAT_BTWEAK, "Translator Drop Chance", 15, "Chance of Translator Dropping 1/X # Default value=15").getInt();
        TranslatorDurability = configuration.get(CAT_BTWEAK, "Translator Max uses", 16, "Amount of uses before translator breaking # Default value=16").getInt();
        BookChance = configuration.get(CAT_BTWEAK, "Book of Spells Drop Chance", 20, "Chance of Book of Spells Dropping 1/X # Default value=20").getInt();
        GrowthChance = configuration.get(CAT_BTWEAK, "Plant Update Chance", 25, "Chance of Plant Updating (Plant Acceleration Upgrade) 1/X # Default value=25").getInt();
        RepairChance = configuration.get(CAT_BTWEAK, "Item Repair Chance", 35, "Chance of Item Repairing 1/X (Stuff Repairing Upgrade) # Default value=35").getInt();
        VampireAmount = configuration.get(CAT_BTWEAK, "Vampire Upgrade heal amount", 3, "How much will heal vampire upgrade damage/X  # Default value=3").getInt();

        if (configuration.hasChanged())
            configuration.save();
    }

    /**
     * Reloads the config values upon change
     */
    public static class ChangeHandler {
        @SubscribeEvent
        public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(ModInfo.MODID))
                loadValues();
        }
    }
}
