/*
 * This class (Pendant_Core.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.baubles;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.common.config.ConfigurationHandler;
import md.zazpro.mod.common.energy.BaubleBSUContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class Pendant_Core extends BaubleBSUContainer {
    private static final int COST_INTERVAL = 20;

    public Pendant_Core(String name) {
        super(800000, 1000, 1000);
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.tabBaublesStuff);
        setHasSubtypes(true);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static int getCooldown(ItemStack itemStack) {
        return itemStack.getTagCompound().getInteger("cooldown");
    }

    private static void setCooldown(ItemStack itemStack, int cooldown) {
        itemStack.getTagCompound().setInteger("cooldown", cooldown);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player,
                               java.util.List list, boolean p_77624_4_) {

        list.add(TextFormatting.GOLD + (this.getBSUStored(itemStack) + "/" + this.getMaxBSUStored(itemStack) + " BSU"));
        list.add(I18n.translateToLocal("tooltip.shift"));

        if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.pendant.FireIm"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.pendant.FallIm"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.pendant.WitherIm"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.pendant.WaterBreath"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.pendant.HealthRegen"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.pendant.Vampire"));
        } else if (itemStack.getTagCompound() != null) {
            Boolean FireImmune = itemStack.getTagCompound().getBoolean("FireImmune");
            if (FireImmune) list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.pendant.FireIm"));
            Boolean FallImmune = itemStack.getTagCompound().getBoolean("FallImmune");
            if (FallImmune) list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.pendant.FallIm"));
            Boolean WitherImmune = itemStack.getTagCompound().getBoolean("WitherImmune");
            if (WitherImmune) list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.pendant.WitherIm"));
            Boolean WaterBreathing = itemStack.getTagCompound().getBoolean("WaterBreathing");
            if (WaterBreathing)
                list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.pendant.WaterBreath"));
            Boolean HealthRegen = itemStack.getTagCompound().getBoolean("HealthRegen");
            if (HealthRegen)
                list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.pendant.HealthRegen"));
            Boolean Vampire = itemStack.getTagCompound().getBoolean("Vampire");
            if (Vampire)
                list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.pendant.Vampire"));
        }

    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase e) {
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase e) {
        setFireImmune(e, false);
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase e) {
        if (itemStack.getTagCompound() != null) {
            if (e instanceof EntityPlayer) {
                int cooldown = getCooldown(itemStack);
                Boolean FireImmune = itemStack.getTagCompound().getBoolean("FireImmune");
                EntityPlayer player = (EntityPlayer) e;
                if (FireImmune && (player.isInLava() || player.isBurning()) && this.getBSUStored(itemStack) >= ConfigurationHandler.Pendant_FIRE) {
                    if (player.ticksExisted % COST_INTERVAL == 0)
                        this.extractBSU(itemStack, ConfigurationHandler.Pendant_FIRE, false);
                    player.extinguish();
                    setFireImmune(player, true);
                } else {
                    setFireImmune(player, false);
                }

                Boolean FallImmune = itemStack.getTagCompound().getBoolean("FallImmune");
                if (FallImmune && !player.isCreative() && !player.onGround && this.getBSUStored(itemStack) >= ConfigurationHandler.Pendant_FALL) {
                    if (player.ticksExisted % COST_INTERVAL == 0)
                        this.extractBSU(itemStack, ConfigurationHandler.Pendant_FALL, false);
                    player.fallDistance = 0;
                }

                Boolean WaterBreathing = itemStack.getTagCompound().getBoolean("WaterBreathing");
                if (WaterBreathing && player.isInsideOfMaterial(Material.WATER) && this.getBSUStored(itemStack) >= ConfigurationHandler.Pendant_WATER) {
                    if (player.ticksExisted % COST_INTERVAL == 0)
                        this.extractBSU(itemStack, ConfigurationHandler.Pendant_WATER, false);
                    player.setAir(280);
                }

                Boolean WitherImmune = itemStack.getTagCompound().getBoolean("WitherImmune");
                if (WitherImmune && (player.getActivePotionEffect(Potion.getPotionById(20)) != null) && this.getBSUStored(itemStack) >= ConfigurationHandler.Pendant_WITHER) {
                    if (player.ticksExisted % COST_INTERVAL == 0)
                        this.extractBSU(itemStack, ConfigurationHandler.Pendant_WITHER, false);
                    player.removeActivePotionEffect(Potion.getPotionById(20));
                }

                Boolean healthRegen = itemStack.getTagCompound().getBoolean("HealthRegen");
                if (healthRegen) {
                    if (cooldown <= 0) {
                        if (player.getHealth() < player.getMaxHealth() && this.getBSUStored(itemStack) >= ConfigurationHandler.Pendant_HEALTH) {
                            if (player.ticksExisted % COST_INTERVAL == 0)
                                this.extractBSU(itemStack, ConfigurationHandler.Pendant_HEALTH, false);
                            player.heal(1.0F);
                            setCooldown(itemStack, 100);
                        }
                    } else setCooldown(itemStack, cooldown - 1);
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            ItemStack itemStack = null;
            if (BaublesApi.getBaublesHandler(player).getStackInSlot(0) != null && BaublesApi.getBaublesHandler(player).getStackInSlot(0).hasTagCompound()) {
                itemStack = BaublesApi.getBaublesHandler(player).getStackInSlot(0);
                boolean Vampire = itemStack.getTagCompound().getBoolean("Vampire");
                if (Vampire) {
                    if (player.getHealth() < player.getMaxHealth() && this.getBSUStored(itemStack) >= ConfigurationHandler.Pendant_VAMPIRE) {
                        this.extractBSU(itemStack, ConfigurationHandler.Pendant_VAMPIRE, false);
                        player.heal(event.getAmount() / ConfigurationHandler.VampireAmount);
                    }
                }
            }
        }
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.AMULET;
    }


    private void setFireImmune(Entity entity, boolean isImmune) {
        ReflectionHelper.setPrivateValue(Entity.class, entity, isImmune, "isImmuneToFire", "field_70178_ae", "ag");
    }

    // This is a fun method which allows us to run some code when our item is
    // shown in a creative tab.
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List itemList)
    {
        ItemStack itemStack = new ItemStack(item);
        this.setBSUStored(itemStack, 0);
        itemList.add(itemStack);
        ItemStack itemStack1 = new ItemStack(item);
        this.setBSUStored(itemStack1, this.getMaxBSUStored(itemStack));
        itemList.add(itemStack1);
    }

}
