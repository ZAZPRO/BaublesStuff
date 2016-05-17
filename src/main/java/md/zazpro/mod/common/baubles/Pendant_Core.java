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
import baubles.common.lib.PlayerHandler;
import md.zazpro.mod.common.baubles.base.BaubleBase;
import md.zazpro.mod.common.config.ConfigurationHandler;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import org.lwjgl.input.Keyboard;

public class Pendant_Core extends BaubleBase {
    public Pendant_Core(String name) {
        super(name);
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
                if (FireImmune) {
                    setFireImmune(player, true);
                }
                Boolean FallImmune = itemStack.getTagCompound().getBoolean("FallImmune");
                if (FallImmune) {
                    player.fallDistance = 0;
                }
                Boolean WaterBreathing = itemStack.getTagCompound().getBoolean("WaterBreathing");
                if (WaterBreathing && player.isInsideOfMaterial(Material.water)) {
                    player.setAir(280);
                }
                Boolean WitherImmune = itemStack.getTagCompound().getBoolean("WitherImmune");
                if (WitherImmune && (player.getActivePotionEffect(Potion.getPotionById(20)) != null)) {
                    player.removeActivePotionEffect(Potion.getPotionById(20));
                }
                Boolean healthRegen = itemStack.getTagCompound().getBoolean("HealthRegen");
                if (healthRegen) {
                    if (cooldown <= 0) {
                        if (player.getHealth() < player.getMaxHealth()) {
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
            ItemStack itemStack = PlayerHandler.getPlayerBaubles(player).getStackInSlot(0);
            boolean Vampire = itemStack.getTagCompound().getBoolean("Vampire");
            if (Vampire) {
                if (player.getHealth() < player.getMaxHealth()) {
                    player.heal(event.getAmount() / ConfigurationHandler.VampireAmount);
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


}
