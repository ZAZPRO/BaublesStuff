/*
 * This class (Translator.java) was created by <zazpro>. It's distributed as
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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class Translator extends Item {

    public Translator() {
        super();
        MinecraftForge.EVENT_BUS.register(this);
        this.setUnlocalizedName("Translator");
        setRegistryName("Translator");
        this.setMaxDamage(17);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTab.tabBaublesStuff);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player,
                               java.util.List list, boolean p_77624_4_) {
        list.add(I18n.translateToLocal("tooltip.items.Pigman"));
        list.add(I18n.translateToLocal("tooltip.translator.uses") + ": 16");
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        if (itemStack.getItemDamage() < (itemStack.getMaxDamage() - 2)) {
            ItemStack stack = itemStack.copy();
            stack.setItemDamage(stack.getItemDamage() + 1);
            stack.stackSize = 1;
            return stack;
        } else return new ItemStack(ItemsAndUpgrades.Broken_Translator);
    }

    @Override
    public boolean hasContainerItem(ItemStack itemstack) {
        return true;
    }

    @SubscribeEvent
    public void onKill(LivingDropsEvent event) {
        if (event.getEntity() instanceof EntityPigZombie) {
            if (randInt(0, 14) == 0)
                event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX,
                        event.getEntity().posY, event.getEntity().posZ, new ItemStack(ItemsAndUpgrades.Translator)));
        }
    }

}