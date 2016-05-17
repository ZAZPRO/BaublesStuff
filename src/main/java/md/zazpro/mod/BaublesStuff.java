/*
 * This class (BaublesStuff.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod;

import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.achievements.AchievementEvents;
import md.zazpro.mod.common.achievements.BaublesStuffAchievement;
import md.zazpro.mod.common.blocks.BlockRegister;
import md.zazpro.mod.common.config.ConfigurationHandler;
import md.zazpro.mod.common.items.ItemsAndUpgrades;
import md.zazpro.mod.common.recipe.CommonRecipes;
import md.zazpro.mod.common.recipe.RecipeBeltCore;
import md.zazpro.mod.common.recipe.RecipePendantCore;
import md.zazpro.mod.common.recipe.RecipeRingCore;
import md.zazpro.mod.common.tileentity.TEExtractor;
import md.zazpro.mod.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

@Mod(modid = ModInfo.MODID, version = ModInfo.VERSION, name = ModInfo.NAME, guiFactory = ModInfo.GUI_FACTORY_CLASS, updateJSON = ModInfo.UPDATE_LINK, dependencies = "required-after:Baubles; after:rarmor")
public class BaublesStuff {

    //Mod Instance
    @Instance("baublesstuff")
    public static BaublesStuff instance;

    //Mod Integrations var
    public static boolean isRarmor;

    //Proxy
    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.SERVER_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //Mod detection
        isRarmor = Loader.isModLoaded("rarmor");

        //Blocks
        BlockRegister.init();

        //Creative Tab
        CreativeTab.TabRegister();

        //Configs
        ConfigurationHandler.loadConfig(event.getSuggestedConfigurationFile());

        //Item Registration/Initialization
        ItemsAndUpgrades.init();
        ItemsAndUpgrades.registerItems();

        //Achievements
        BaublesStuffAchievement.loadAchievements();
        BaublesStuffAchievement.registerPage();

        //Loot
        //TODO, change gen.
        //ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ItemsAndUpgrades.Spell_Book),1,1,10));

        //Recipes
        CommonRecipes.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //TE Register
        GameRegistry.registerTileEntity(TEExtractor.class, "tileEntityDisassembler");

        //Achievement Events Register
        MinecraftForge.EVENT_BUS.register(new AchievementEvents());

        //Proxy init
        proxy.init(event);

        //Craft Recipes
        GameRegistry.addRecipe(new RecipeBeltCore());
        RecipeSorter.register("BaubleStuff:Belt", RecipeBeltCore.class, Category.SHAPELESS, "after:minecraft:shapeless");
        GameRegistry.addRecipe(new RecipePendantCore());
        RecipeSorter.register("BaubleStuff:Pendant", RecipePendantCore.class, Category.SHAPELESS, "after:minecraft:shapeless");
        GameRegistry.addRecipe(new RecipeRingCore());
        RecipeSorter.register("BaubleStuff:Ring", RecipeRingCore.class, Category.SHAPELESS, "after:minecraft:shapeless");

        System.out.println("Baubles Stuff here :3");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
