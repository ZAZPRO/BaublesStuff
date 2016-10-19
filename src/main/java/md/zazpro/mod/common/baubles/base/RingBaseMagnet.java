/*
 * This class (RingBaseMagnet.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.baubles.base;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;
import java.util.List;

public abstract class RingBaseMagnet extends BaubleBase {

    public static final List<String> BLACKLIST = Arrays.asList("appliedenergistics2:item.ItemCrystalSeed");

    private int range;

    public RingBaseMagnet(String name, int range) {
        super(name);
        MinecraftForge.EVENT_BUS.register(this);
        this.range = range;
    }

    public static void addItemToBlackList(String item) {
        BLACKLIST.add(item);
    }

    public static int getCooldown(ItemStack itemStack) {
        return itemStack.getTagCompound().getInteger("cooldown");
    }

    public static void setCooldown(ItemStack itemStack, int cooldown) {
        itemStack.getTagCompound().setInteger("cooldown", cooldown);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.RING;
    }

    @Override
    public void onEquipped(ItemStack arg0, EntityLivingBase arg1) {
    }

    @Override
    public void onUnequipped(ItemStack arg0, EntityLivingBase arg1) {
    }

    @Override
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
        if (!(par3Entity instanceof EntityPlayer)) {
            return;
        }

        if (par1ItemStack.getTagCompound() == null) {
            par1ItemStack.setTagCompound(new NBTTagCompound());
            par1ItemStack.getTagCompound().setInteger("cooldown", 0);
        }
    }


    public List getEntitiesInRange(Class entityType, World world, EntityPlayer player) {
        return world.getEntitiesWithinAABB(entityType, new AxisAlignedBB(player.posX - this.range, player.posY - this.range, player.posZ - this.range, player.posX + this.range, player.posY + this.range, player.posZ + this.range));
    }

    public boolean isItemInRangeOfNegator(World world, EntityItem item) {
        int x = MathHelper.floor_double(item.posX);
        int y = MathHelper.floor_double(item.posY);
        int z = MathHelper.floor_double(item.posZ);
        int range = 16;
        for (int x2 = x - range; x2 < x + range; x2++) {
            for (int z2 = z - range; z2 < z + range; z2++) {
                for (int y2 = y - range; y2 < y + range; y2++) {
                    ItemStack itemStack = item.getEntityItem();
                    if (itemStack == null || BLACKLIST.contains(Item.REGISTRY.getNameForObject(itemStack.getItem()).toString())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @SubscribeEvent
    public void onTossItem(ItemTossEvent event) {
        IBaublesItemHandler inv = BaublesApi.getBaublesHandler(event.getPlayer());
        for (int i = 0; i < inv.getSlots(); i++) {
            ItemStack itemStack = inv.getStackInSlot(i);
            if (itemStack != null && itemStack.getTagCompound() != null && itemStack.getItem() instanceof RingBaseMagnet) {
                setCooldown(itemStack, 100);
            }
        }
    }

}
