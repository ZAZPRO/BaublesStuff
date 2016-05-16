package md.zazpro.mod.common.baubles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.Iterator;

public class Ring_NotLMagnet extends RingBaseMagnet {

    int range;

    public Ring_NotLMagnet(String name, int range) {
        super(name, range);
        MinecraftForge.EVENT_BUS.register(this);
        this.range = range;
    }

    @Override
    public void onWornTick(ItemStack item, EntityLivingBase e) {

        if (!(e instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) e;
        World world = player.worldObj;
        if (world.isRemote) {
            return;
        }

        int cooldown = getCooldown(item);

        if (cooldown <= 0) {
            Iterator iterator = getEntitiesInRange(EntityItem.class, world, player).iterator();
            while (iterator.hasNext()) {
                EntityItem itemToGet = (EntityItem) iterator.next();
                if (isItemInRangeOfNegator(world, itemToGet)) {
                    EntityItemPickupEvent pickupEvent = new EntityItemPickupEvent(player, itemToGet);
                    ItemStack itemStackToGet = itemToGet.getEntityItem();
                    int stackSize = itemStackToGet.stackSize;
                    if ((pickupEvent.getResult() == Event.Result.ALLOW) || (stackSize <= 0) || (player.inventory.addItemStackToInventory(itemStackToGet))) {
                        player.onItemPickup(itemToGet, stackSize);
                    }
                }
            }
            iterator = getEntitiesInRange(EntityXPOrb.class, world, player).iterator();
            while (iterator.hasNext()) {
                EntityXPOrb xpToGet = (EntityXPOrb) iterator.next();
                if ((!xpToGet.isDead) && (!xpToGet.isInvisible())) {
                    int xpAmount = xpToGet.xpValue;
                    xpToGet.xpValue = 0;
                    player.xpCooldown = 0;
                    player.addExperience(xpAmount);
                    xpToGet.setDead();
                    xpToGet.setInvisible(true);
                }
            }
        } else setCooldown(item, cooldown - 1);
    }

}
