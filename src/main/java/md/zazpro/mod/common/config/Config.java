package md.zazpro.mod.common.config;

import md.zazpro.mod.client.ModInfo;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;

import java.io.File;

public class Config {

    public static Configuration config;
    public static boolean CUpdate;
    public static boolean CFly, CUpgrade_FireImmune, CUpgrade_HighStep, CUpgrade_FallImmune, CUpgrade_WaterBreathing, CUpgrade_SpeedI, CUpgrade_SpeedII, CUpgrade_SpeedIII;
    public static boolean CUpgrade_JumpI, CUpgrade_JumpII, CUpgrade_JumpIII, CUpgrade_WitherImmune, CMagnetRing, CUpgrade_HealthRegen, CUpgrade_Invisibility, CNotLMagnetRing;
    public static boolean CUpgrade_HasteI, CUpgrade_HasteII, CUpgrade_HasteIII, CUpgrade_PowerI, CUpgrade_PowerII, CUpgrade_PowerIII, CUpgrade_NightVision, CUpgrade_Growth, CUpgrade_Repair;

    public static void createConfig() {
        File configFile = new File(Loader.instance().getConfigDir(), "BaublessStuff.cfg");
        config = new Configuration(configFile, ModInfo.VERSION);
        config.getCategory("main");
        CUpdate = Config.config.get("main", "Check for mod updates?", true).getBoolean();
        config.getCategory("upgrades");
        CFly = Config.config.get("upgrades", "Flying upgrade", true).getBoolean();
        CUpgrade_HighStep = Config.config.get("upgrades", "HighStep Upgrade", true).getBoolean();
        CUpgrade_SpeedI = Config.config.get("upgrades", "Speed Upgrade I", true).getBoolean();
        CUpgrade_SpeedII = Config.config.get("upgrades", "Speed Upgrade II", true).getBoolean();
        CUpgrade_SpeedIII = Config.config.get("upgrades", "Speed Upgrade III", true).getBoolean();
        CUpgrade_JumpI = Config.config.get("upgrades", "Jump Upgrade I", true).getBoolean();
        CUpgrade_JumpII = Config.config.get("upgrades", "Jump Upgrade II", true).getBoolean();
        CUpgrade_JumpIII = Config.config.get("upgrades", "Jump Upgrade III", true).getBoolean();
        CUpgrade_HasteI = Config.config.get("upgrades", "Haste Upgrade I", true).getBoolean();
        CUpgrade_HasteII = Config.config.get("upgrades", "Haste Upgrade II", true).getBoolean();
        CUpgrade_HasteIII = Config.config.get("upgrades", "Haste Upgrade III", true).getBoolean();
        CUpgrade_PowerI = Config.config.get("upgrades", "Power Upgrade I", true).getBoolean();
        CUpgrade_PowerII = Config.config.get("upgrades", "Power Upgrade II", true).getBoolean();
        CUpgrade_PowerIII = Config.config.get("upgrades", "Power Upgrade III", true).getBoolean();
        CUpgrade_FireImmune = Config.config.get("upgrades", "Fire Immune Upgrade", true).getBoolean();
        CUpgrade_FallImmune = Config.config.get("upgrades", "Fall Damage Immune Upgrade", true).getBoolean();
        CUpgrade_WaterBreathing = Config.config.get("upgrades", "Water Breathing Upgrade", true).getBoolean();
        CUpgrade_WitherImmune = Config.config.get("upgrades", "Wither Immune Upgrade", true).getBoolean();
        CMagnetRing = Config.config.get("upgrades", "Magnet Ring", true).getBoolean();
        CNotLMagnetRing = Config.config.get("upgrades", "Instantaneous Magnet Ring", true).getBoolean();
        CUpgrade_HealthRegen = Config.config.get("upgrades", "Health Regen", true).getBoolean();
        CUpgrade_Invisibility = Config.config.get("upgrades", "Invisibility Upgrade", true).getBoolean();
        CUpgrade_NightVision = Config.config.get("upgrades", "Night Vision", true).getBoolean();
        CUpgrade_Growth = Config.config.get("upgrades", "Plant Acceleration", true).getBoolean();
        CUpgrade_Repair = Config.config.get("upgrades", "Stuff Repairing", true).getBoolean();

        config.save();
        config.load();

    }
}