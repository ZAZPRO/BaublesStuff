/*
 * This class (ItemsAndUpgrades.java) was created by <zazpro>. It's distributed as
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
import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.baubles.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemsAndUpgrades {
    public static Item Spell_Book;
    public static Item Translator;
    public static Item Broken_Translator;
    public static Item Belt_Core;
    public static Item Pendant_Core;
    public static Item Ring_Core;
    public static Item Ring_Magnet;
    public static Item Ring_NotLMagnet;
    public static Item Upgrade_Stone;
    public static Item Upgrade_HighStep;
    public static Item Upgrade_SpeedI;
    public static Item Upgrade_SpeedII;
    public static Item Upgrade_SpeedIII;
    public static Item Upgrade_JumpI;
    public static Item Upgrade_JumpII;
    public static Item Upgrade_JumpIII;
    public static Item Upgrade_Fly;
    public static Item Upgrade_FireImmune;
    public static Item Upgrade_FallImmune;
    public static Item Upgrade_WaterBreathing;
    public static Item Upgrade_WitherImmune;
    public static Item Upgrade_Invisibility;
    public static Item Upgrade_HealthRegen;
    public static Item Upgrade_NightVision;
    public static Item Upgrade_Growth;
    public static Item Upgrade_HasteI;
    public static Item Upgrade_HasteII;
    public static Item Upgrade_HasteIII;
    public static Item Upgrade_PowerI;
    public static Item Upgrade_PowerII;
    public static Item Upgrade_PowerIII;
    public static Item Upgrade_Repair;
    public static Item Sheet_FireImmune;
    public static Item Sheet_FallImmune;
    public static Item Sheet_Haste;
    public static Item Sheet_HealthRegen;
    public static Item Sheet_Invisibility;
    public static Item Sheet_Jump;
    public static Item Sheet_NightVision;
    public static Item Sheet_Power;
    public static Item Sheet_Speed;
    public static Item Sheet_WaterBreathing;
    public static Item Sheet_WitherImmune;
    public static Item Sheet_Growth;
    public static Item Sheet_Repair;

    public static void init() {
        Upgrade_Stone = new Item().setUnlocalizedName("Upgrade_Stone").setRegistryName("Upgrade_Stone").setMaxDamage(0).setCreativeTab(CreativeTab.tabBaublesStuff);
        Spell_Book = new SpellBook();
        Translator = new Translator();
        Broken_Translator = new Broken_Translator();
        Belt_Core = new Belt_Core("Belt_Core");
        Pendant_Core = new Pendant_Core("Pendant_Core");
        Ring_Core = new Ring_Core("Ring_Core");
        Ring_Magnet = new Ring_Magnet("Ring_Magnet", 16);
        Ring_NotLMagnet = new Ring_NotLMagnet("Ring_NotLMagnet", 16);
        Upgrade_HighStep = new ItemUpgrade("Upgrade_HighStep");
        Upgrade_SpeedI = new ItemUpgrade("Upgrade_SpeedI");
        Upgrade_SpeedII = new ItemUpgrade("Upgrade_SpeedII");
        Upgrade_SpeedIII = new ItemUpgrade("Upgrade_SpeedIII");
        Upgrade_JumpI = new ItemUpgrade("Upgrade_JumpI");
        Upgrade_JumpII = new ItemUpgrade("Upgrade_JumpII");
        Upgrade_JumpIII = new ItemUpgrade("Upgrade_JumpIII");
        Upgrade_Fly = new ItemUpgrade("Upgrade_Fly");
        Upgrade_FireImmune = new ItemUpgrade("Upgrade_FireImmune");
        Upgrade_FallImmune = new ItemUpgrade("Upgrade_FallImmune");
        Upgrade_WaterBreathing = new ItemUpgrade("Upgrade_WaterBreathing");
        Upgrade_WitherImmune = new ItemUpgrade("Upgrade_WitherImmune");
        Upgrade_Invisibility = new ItemUpgrade("Upgrade_Invisibility");
        Upgrade_HealthRegen = new ItemUpgrade("Upgrade_HealthRegen");
        Upgrade_NightVision = new ItemUpgrade("Upgrade_NightVision");
        Upgrade_Growth = new ItemUpgrade("Upgrade_Growth");
        Upgrade_HasteI = new ItemUpgrade("Upgrade_HasteI");
        Upgrade_HasteII = new ItemUpgrade("Upgrade_HasteII");
        Upgrade_HasteIII = new ItemUpgrade("Upgrade_HasteIII");
        Upgrade_PowerI = new ItemUpgrade("Upgrade_PowerI");
        Upgrade_PowerII = new ItemUpgrade("Upgrade_PowerII");
        Upgrade_PowerIII = new ItemUpgrade("Upgrade_PowerIII");
        Upgrade_Repair = new ItemUpgrade("Upgrade_Repair");
        Sheet_FireImmune = new ItemSheet("Sheet_FireImmune");
        Sheet_FallImmune = new ItemSheet("Sheet_FallImmune");
        Sheet_Haste = new ItemSheet("Sheet_Haste");
        Sheet_HealthRegen = new ItemSheet("Sheet_HealthRegen");
        Sheet_Invisibility = new ItemSheet("Sheet_Invisibility");
        Sheet_Jump = new ItemSheet("Sheet_Jump");
        Sheet_NightVision = new ItemSheet("Sheet_NightVision");
        Sheet_Power = new ItemSheet("Sheet_Power");
        Sheet_Speed = new ItemSheet("Sheet_Speed");
        Sheet_WaterBreathing = new ItemSheet("Sheet_WaterBreathing");
        Sheet_WitherImmune = new ItemSheet("Sheet_WitherImmune");
        Sheet_Growth = new ItemSheet("Sheet_Growth");
        Sheet_Repair = new ItemSheet("Sheet_Repair");
    }

    public static void registerItems() {
        GameRegistry.register(Spell_Book);
        GameRegistry.register(Translator);
        GameRegistry.register(Broken_Translator);
        GameRegistry.register(Sheet_FireImmune);
        GameRegistry.register(Sheet_FallImmune);
        GameRegistry.register(Sheet_Haste);
        GameRegistry.register(Sheet_HealthRegen);
        GameRegistry.register(Sheet_Invisibility);
        GameRegistry.register(Sheet_Jump);
        GameRegistry.register(Sheet_NightVision);
        GameRegistry.register(Sheet_Power);
        GameRegistry.register(Sheet_Speed);
        GameRegistry.register(Sheet_WaterBreathing);
        GameRegistry.register(Sheet_WitherImmune);
        GameRegistry.register(Sheet_Growth);
        GameRegistry.register(Sheet_Repair);
        GameRegistry.register(Belt_Core);
        GameRegistry.register(Pendant_Core);
        GameRegistry.register(Ring_Core);
        GameRegistry.register(Ring_Magnet);
        GameRegistry.register(Ring_NotLMagnet);
        GameRegistry.register(Upgrade_Stone);
        GameRegistry.register(Upgrade_HighStep);
        GameRegistry.register(Upgrade_SpeedI);
        GameRegistry.register(Upgrade_SpeedII);
        GameRegistry.register(Upgrade_SpeedIII);
        GameRegistry.register(Upgrade_JumpI);
        GameRegistry.register(Upgrade_JumpII);
        GameRegistry.register(Upgrade_JumpIII);
        GameRegistry.register(Upgrade_Fly);
        GameRegistry.register(Upgrade_FireImmune);
        GameRegistry.register(Upgrade_FallImmune);
        GameRegistry.register(Upgrade_WaterBreathing);
        GameRegistry.register(Upgrade_WitherImmune);
        GameRegistry.register(Upgrade_Invisibility);
        GameRegistry.register(Upgrade_HealthRegen);
        GameRegistry.register(Upgrade_NightVision);
        GameRegistry.register(Upgrade_HasteI);
        GameRegistry.register(Upgrade_HasteII);
        GameRegistry.register(Upgrade_HasteIII);
        GameRegistry.register(Upgrade_PowerI);
        GameRegistry.register(Upgrade_PowerII);
        GameRegistry.register(Upgrade_PowerIII);
        GameRegistry.register(Upgrade_Growth);
        GameRegistry.register(Upgrade_Repair);
    }

    public static void registerRenders() {
        reg(Spell_Book);
        reg(Translator);
        reg(Broken_Translator);
        reg(Sheet_FireImmune);
        reg(Sheet_FallImmune);
        reg(Sheet_Haste);
        reg(Sheet_HealthRegen);
        reg(Sheet_Invisibility);
        reg(Sheet_Jump);
        reg(Sheet_NightVision);
        reg(Sheet_Power);
        reg(Sheet_Speed);
        reg(Sheet_WaterBreathing);
        reg(Sheet_WitherImmune);
        reg(Sheet_Growth);
        reg(Sheet_Repair);
        reg(Belt_Core);
        reg(Pendant_Core);
        reg(Ring_Core);
        reg(Ring_Magnet);
        reg(Ring_NotLMagnet);
        reg(Upgrade_Stone);
        reg(Upgrade_HighStep);
        reg(Upgrade_SpeedI);
        reg(Upgrade_SpeedII);
        reg(Upgrade_SpeedIII);
        reg(Upgrade_JumpI);
        reg(Upgrade_JumpII);
        reg(Upgrade_JumpIII);
        reg(Upgrade_Fly);
        reg(Upgrade_FireImmune);
        reg(Upgrade_FallImmune);
        reg(Upgrade_WaterBreathing);
        reg(Upgrade_WitherImmune);
        reg(Upgrade_Invisibility);
        reg(Upgrade_HealthRegen);
        reg(Upgrade_NightVision);
        reg(Upgrade_HasteI);
        reg(Upgrade_HasteII);
        reg(Upgrade_HasteIII);
        reg(Upgrade_PowerI);
        reg(Upgrade_PowerII);
        reg(Upgrade_PowerIII);
        reg(Upgrade_Growth);
        reg(Upgrade_Repair);
    }

    private static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(
                ModInfo.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

}
