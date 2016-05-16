/*
 * This class (CommonRecipes.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.recipe;

import md.zazpro.mod.common.blocks.BlockRegister;
import md.zazpro.mod.common.config.Config;
import md.zazpro.mod.common.items.ItemsAndUpgrades;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonRecipes {
    public static void register() {
        GameRegistry.addRecipe(new ItemStack(BlockRegister.UpgradeExtractor),
                "ALA",
                "IDI",
                "ALA",
                'A', Blocks.stone, 'I', Items.iron_ingot, 'L', new ItemStack(Items.dye, 1, 4), 'D', ItemsAndUpgrades.Upgrade_Stone);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_Stone),
                "ABA",
                "CDC",
                "ABA",
                'A', Blocks.stone, 'B', Items.gold_ingot, 'C', new ItemStack(Items.dye, 1, 4), 'D', Items.iron_ingot);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Belt_Core),
                " B ",
                "BGB",
                " B ",
                'B', Items.leather, 'G', Items.gold_ingot);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Pendant_Core),
                "G G",
                "AGA",
                " A ",
                'A', Items.feather, 'G', Items.gold_ingot);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Ring_Core),
                " G ",
                "G G",
                " G ",
                'G', Items.gold_ingot);

        if (Config.CMagnetRing)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Ring_Magnet),
                    "RA ",
                    "ABA",
                    " AL",
                    'A', Items.iron_ingot, 'B', ItemsAndUpgrades.Upgrade_Stone, 'R', new ItemStack(Items.dye, 1, 1), 'L', new ItemStack(Items.dye, 1, 4));

        //Sheets
        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_Speed),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.sugar);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_Jump),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.reeds);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_Haste),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.golden_pickaxe);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_HealthRegen),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.ghast_tear);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_Invisibility),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.fermented_spider_eye);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_NightVision),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.golden_carrot);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_Power),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.golden_sword);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_WitherImmune),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.nether_star);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_FireImmune),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.magma_cream);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_FallImmune),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.feather);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_WaterBreathing),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', new ItemStack(Items.fish, 1, 3));

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_Growth),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Blocks.melon_block);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_Harvest),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Items.golden_hoe);

        GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Sheet_Repair),
                "BTF",
                "WPX",
                "   ",
                'B', ItemsAndUpgrades.Spell_Book, 'T', new ItemStack(ItemsAndUpgrades.Translator, 1, OreDictionary.WILDCARD_VALUE), 'F', Items.writable_book, 'W', Items.nether_wart, 'P', Items.blaze_powder, 'X', Blocks.iron_block);

        if (Config.CUpgrade_HighStep)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_HighStep),
                    " T ",
                    "ABC",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Speed, 'B', ItemsAndUpgrades.Upgrade_Stone, 'C', ItemsAndUpgrades.Sheet_Jump, 'T', Items.ghast_tear, 'F', Items.blaze_powder);

        //Upgrades
        if (Config.CUpgrade_FireImmune)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_FireImmune),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_FireImmune, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (Config.CUpgrade_FallImmune)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_FallImmune),
                    " D ",
                    "ABA",
                    " D ",
                    'A', ItemsAndUpgrades.Sheet_FallImmune, 'B', ItemsAndUpgrades.Upgrade_Stone, 'D', Items.diamond);

        if (Config.CUpgrade_WaterBreathing)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_WaterBreathing),
                    " X ",
                    "ABA",
                    " X ",
                    'A', ItemsAndUpgrades.Sheet_WaterBreathing, 'B', ItemsAndUpgrades.Upgrade_Stone, 'X', Items.glass_bottle);

        if (Config.CUpgrade_WitherImmune)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_WitherImmune),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_WitherImmune, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (Config.CFly)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_Fly),
                    "SCJ",
                    "QNE",
                    "SXJ",
                    'S', ItemsAndUpgrades.Sheet_Speed, 'C', Items.feather, 'Q', ItemsAndUpgrades.Upgrade_SpeedIII, 'X', ItemsAndUpgrades.Upgrade_FallImmune, 'N', Items.nether_star, 'E', ItemsAndUpgrades.Upgrade_JumpIII, 'J', ItemsAndUpgrades.Sheet_Jump);

        if (Config.CUpgrade_SpeedI)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_SpeedI),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Speed, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (Config.CUpgrade_SpeedII)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_SpeedII),
                    " G ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Speed, 'B', ItemsAndUpgrades.Upgrade_SpeedI, 'G', Items.sugar, 'F', Items.blaze_powder);

        if (Config.CUpgrade_SpeedIII)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_SpeedIII),
                    " T ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Speed, 'B', ItemsAndUpgrades.Upgrade_SpeedII, 'T', Items.ghast_tear, 'F', Items.diamond);

        if (Config.CUpgrade_JumpI)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_JumpI),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Jump, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (Config.CUpgrade_JumpII)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_JumpII),
                    " G ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Jump, 'B', ItemsAndUpgrades.Upgrade_JumpI, 'G', Items.feather, 'F', Items.blaze_powder);

        if (Config.CUpgrade_JumpIII)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_JumpIII),
                    " T ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Jump, 'B', ItemsAndUpgrades.Upgrade_JumpII, 'T', Items.magma_cream, 'F', Items.diamond);

        if (Config.CUpgrade_HasteI)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_HasteI),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Haste, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (Config.CUpgrade_HasteII)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_HasteII),
                    " G ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Haste, 'B', ItemsAndUpgrades.Upgrade_HasteI, 'G', Items.gold_nugget, 'F', Items.blaze_powder);

        if (Config.CUpgrade_HasteIII)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_HasteIII),
                    " T ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Haste, 'B', ItemsAndUpgrades.Upgrade_HasteII, 'T', Items.ghast_tear, 'F', Items.diamond_pickaxe);

        if (Config.CUpgrade_PowerI)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_PowerI),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Power, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (Config.CUpgrade_PowerII)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_PowerII),
                    " G ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Power, 'B', ItemsAndUpgrades.Upgrade_PowerI, 'G', Items.quartz, 'F', Items.blaze_powder);

        if (Config.CUpgrade_PowerIII)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_PowerIII),
                    " T ",
                    "ABA",
                    " F ",
                    'A', ItemsAndUpgrades.Sheet_Power, 'B', ItemsAndUpgrades.Upgrade_PowerII, 'T', Items.ghast_tear, 'F', Items.diamond_sword);

        if (Config.CNotLMagnetRing)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Ring_NotLMagnet),
                    "DAC",
                    "ABA",
                    "DAC",
                    'A', Items.iron_ingot, 'B', ItemsAndUpgrades.Upgrade_Stone, 'D', new ItemStack(Items.dye, 1, 4), 'C', new ItemStack(Items.dye, 1, 1));

        if (Config.CUpgrade_HealthRegen)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_HealthRegen),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_HealthRegen, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (Config.CUpgrade_Invisibility)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_Invisibility),
                    " D ",
                    "ABA",
                    " D ",
                    'A', ItemsAndUpgrades.Sheet_Invisibility, 'B', ItemsAndUpgrades.Upgrade_Stone, 'D', Items.diamond);

        if (Config.CUpgrade_NightVision)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_NightVision),
                    " D ",
                    "ABA",
                    " D ",
                    'A', ItemsAndUpgrades.Sheet_NightVision, 'B', ItemsAndUpgrades.Upgrade_Stone, 'D', Items.diamond);

        if (Config.CUpgrade_Growth)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_Growth),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Growth, 'B', ItemsAndUpgrades.Upgrade_Stone);

        if (Config.CUpgrade_Harvest == true)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_Harvest),
                    " X ",
                    "ABA",
                    " X ",
                    'A', ItemsAndUpgrades.Sheet_Harvest, 'B', ItemsAndUpgrades.Upgrade_Stone, 'X', Items.diamond);

        if (Config.CUpgrade_Repair)
            GameRegistry.addRecipe(new ItemStack(ItemsAndUpgrades.Upgrade_Repair),
                    "   ",
                    "ABA",
                    "   ",
                    'A', ItemsAndUpgrades.Sheet_Repair, 'B', ItemsAndUpgrades.Upgrade_Stone);

    }

}
