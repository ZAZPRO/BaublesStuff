/*
 * This class (Ring_Magnet.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.baubles;

import md.zazpro.mod.helper.EntityMoveHelper;
import md.zazpro.mod.helper.Vector3;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import java.util.Iterator;

public class Ring_Magnet extends RingBaseMagnet {

    int range;

    public Ring_Magnet(String name, int range) {
        super(name, range);
        MinecraftForge.EVENT_BUS.register(this);
        this.range = range;
    }


    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase e) {

        if (!(e instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) e;
        World world = player.worldObj;
        if (world.isRemote) {
            return;
        }

        int cooldown = getCooldown(itemStack);

        double x = player.posX;
        double y = player.posY - (player.worldObj.isRemote ? 1.62 : 0) + 0.75;
        double z = player.posZ;

        if (cooldown <= 0) {
            Iterator iterator = getEntitiesInRange(EntityItem.class, world, player).iterator();
            while (iterator.hasNext()) {
                EntityItem itemToGet = (EntityItem) iterator.next();
                if (isItemInRangeOfNegator(world, itemToGet)) {
                    EntityMoveHelper.setEntityMotionFromVector(itemToGet, new Vector3(x, y, z), 0.45F);
                }
            }

            iterator = getEntitiesInRange(EntityXPOrb.class, world, player).iterator();
            while (iterator.hasNext()) {
                EntityXPOrb xpToGet = (EntityXPOrb) iterator.next();
                if ((!xpToGet.isDead) && (!xpToGet.isInvisible())) {
                    if ((!xpToGet.isDead) && (!xpToGet.isInvisible()))
                        EntityMoveHelper.setEntityMotionFromVector(xpToGet, new Vector3(x, y, z), 0.45F);
                }
            }
        } else setCooldown(itemStack, cooldown - 1);
    }


}
