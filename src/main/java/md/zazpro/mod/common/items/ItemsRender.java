/*
 * This class (ItemsRender.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.items;

import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.baubles.base.GlobalBaubleMesh;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

import java.util.ArrayList;

public class ItemsRender {
    public static final String[] Body_CoreVariants = {"Body_Core.A", "Body_Core.B", "Body_Core.C", "Body_Core.D", "Body_Core.E", "Body_Core.F", "Body_Core.G", "Body_Core.H", "Body_Core.I"};
    public static final String[] Charm_CoreVariants = {"Charm_Core.DEFAULT", "Charm_Core.WINGS"};
    public static final String[] Head_CoreVariants = {"Head_Core.DEFAULT", "Head_Core.PERL", "Head_Core.DIAMOND", "Head_Core.EMERALD"};

    public static void registerRenders() {
        reg(ItemsAndUpgrades.Spell_Book);
        reg(ItemsAndUpgrades.Translator);
        reg(ItemsAndUpgrades.Broken_Translator);
        reg(ItemsAndUpgrades.Exp_Stuff);
        reg(ItemsAndUpgrades.Sheet_FireImmune);
        reg(ItemsAndUpgrades.Sheet_FallImmune);
        reg(ItemsAndUpgrades.Sheet_Haste);
        reg(ItemsAndUpgrades.Sheet_HealthRegen);
        reg(ItemsAndUpgrades.Sheet_Invisibility);
        reg(ItemsAndUpgrades.Sheet_Jump);
        reg(ItemsAndUpgrades.Sheet_NightVision);
        reg(ItemsAndUpgrades.Sheet_Power);
        reg(ItemsAndUpgrades.Sheet_Speed);
        reg(ItemsAndUpgrades.Sheet_WaterBreathing);
        reg(ItemsAndUpgrades.Sheet_WitherImmune);
        reg(ItemsAndUpgrades.Sheet_Growth);
        reg(ItemsAndUpgrades.Sheet_Harvest);
        reg(ItemsAndUpgrades.Sheet_Repair);
        reg(ItemsAndUpgrades.Belt_Core);
        reg(ItemsAndUpgrades.Pendant_Core);
        reg(ItemsAndUpgrades.Ring_Core);
        reg(ItemsAndUpgrades.Ring_Magnet);
        reg(ItemsAndUpgrades.Ring_NotLMagnet);
        reg(ItemsAndUpgrades.Upgrade_Stone);
        reg(ItemsAndUpgrades.Upgrade_HighStep);
        reg(ItemsAndUpgrades.Upgrade_SpeedI);
        reg(ItemsAndUpgrades.Upgrade_SpeedII);
        reg(ItemsAndUpgrades.Upgrade_SpeedIII);
        reg(ItemsAndUpgrades.Upgrade_JumpI);
        reg(ItemsAndUpgrades.Upgrade_JumpII);
        reg(ItemsAndUpgrades.Upgrade_JumpIII);
        reg(ItemsAndUpgrades.Upgrade_Fly);
        reg(ItemsAndUpgrades.Upgrade_FireImmune);
        reg(ItemsAndUpgrades.Upgrade_FallImmune);
        reg(ItemsAndUpgrades.Upgrade_WaterBreathing);
        reg(ItemsAndUpgrades.Upgrade_WitherImmune);
        reg(ItemsAndUpgrades.Upgrade_Invisibility);
        reg(ItemsAndUpgrades.Upgrade_HealthRegen);
        reg(ItemsAndUpgrades.Upgrade_NightVision);
        reg(ItemsAndUpgrades.Upgrade_HasteI);
        reg(ItemsAndUpgrades.Upgrade_HasteII);
        reg(ItemsAndUpgrades.Upgrade_HasteIII);
        reg(ItemsAndUpgrades.Upgrade_PowerI);
        reg(ItemsAndUpgrades.Upgrade_PowerII);
        reg(ItemsAndUpgrades.Upgrade_PowerIII);
        reg(ItemsAndUpgrades.Upgrade_Growth);
        reg(ItemsAndUpgrades.Upgrade_Harvest);
        reg(ItemsAndUpgrades.Upgrade_Repair);
        reg(ItemsAndUpgrades.Upgrade_Vampire);
    }

    public static void renderPreInit() {
        addItemRender(ItemsAndUpgrades.Body_Core);
        addItemVariants(ItemsAndUpgrades.Body_Core, Body_CoreVariants);
        addItemRender(ItemsAndUpgrades.Charm_Core);
        addItemVariants(ItemsAndUpgrades.Charm_Core, Charm_CoreVariants);
        addItemRender(ItemsAndUpgrades.Head_Core);
        addItemVariants(ItemsAndUpgrades.Head_Core, Head_CoreVariants);
    }

    private static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(
                ModInfo.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

    private static void addItemRender(Item item) {
        ModelLoader.setCustomMeshDefinition(item, new GlobalBaubleMesh());
    }

    private static void addItemVariants(Item item, String[] variants) {
        int len = variants.length;

        ArrayList<ModelResourceLocation> resources = new ArrayList<ModelResourceLocation>();

        if (len > 0) {
            for (String variant : variants) {
                ModelResourceLocation model = new ModelResourceLocation(new ResourceLocation(ModInfo.MODID, variant), "inventory");
                resources.add(model);
            }
        }
        ModelBakery.registerItemVariants(item, resources.toArray(new ModelResourceLocation[len]));
    }
}
