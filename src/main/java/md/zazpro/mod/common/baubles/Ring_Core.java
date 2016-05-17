/*
 * This class (Ring_Core.java) was created by <zazpro>. It's distributed as
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
import md.zazpro.mod.helper.Wrapper;
import md.zazpro.mod.helper.ring.RingUtils;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

public class Ring_Core extends BaubleBase {

    private boolean NightVision = false;

    public Ring_Core(String name) {
        super(name);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player,
                               java.util.List list, boolean p_77624_4_) {

        list.add(I18n.translateToLocal("tooltip.shift"));

        if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            list.add(TextFormatting.RED + I18n.translateToLocal("tooltip.ring.warning"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.ring.Invisibility"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.ring.NightVision"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.ring.Haste"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.ring.Power"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.ring.FastGrowth"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.ring.Harvest"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.ring.Repair"));
        } else if (itemStack.getTagCompound() != null) {
            Boolean invisibility = itemStack.getTagCompound().getBoolean("Invisibility");
            if (invisibility)
                list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.ring.Invisibility"));
            Boolean nightVision = itemStack.getTagCompound().getBoolean("NightVision");
            if (nightVision) list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.ring.NightVision"));
            Float haste = itemStack.getTagCompound().getFloat("Haste");
            if (haste > 0)
                list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.ring.HasteLVL") + ": +" + Math.round(haste));
            Integer power = itemStack.getTagCompound().getInteger("Power");
            if (power > 0)
                list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.ring.PowerLVL") + ": +" + power);
            Boolean Growth = itemStack.getTagCompound().getBoolean("Growth");
            if (Growth) list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.ring.FastGrowth"));
            Boolean Harvest = itemStack.getTagCompound().getBoolean("Harvest");
            if (Harvest) list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.ring.Harvest"));
            Boolean Repair = itemStack.getTagCompound().getBoolean("Repair");
            if (Repair) list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.ring.Repair"));
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void clientTick(TickEvent.ClientTickEvent event) {
        if (Minecraft.getMinecraft().thePlayer != null && !NightVision) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            ItemStack itemStack1 = PlayerHandler.getPlayerBaubles(player).getStackInSlot(1);
            ItemStack itemStack2 = PlayerHandler.getPlayerBaubles(player).getStackInSlot(2);
            if (RingUtils.isLegalb(itemStack1, itemStack2, "NightVision")) {
                float[] bright = Wrapper.INSTANCE.world().provider.getLightBrightnessTable();
                for (int i = 0; i < bright.length; i++) {
                    bright[i] = 1.0F;
                    NightVision = false;
                }

            } else {
                Wrapper.INSTANCE.world().provider.registerWorld(Wrapper.INSTANCE.world());
                NightVision = false;
            }
        }
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase e) {
        NightVision = true;
    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase e) {
        e.setInvisible(false);
        NightVision = true;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase e) {
        if (itemStack.getTagCompound() != null) {
            if (e instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) e;
                ItemStack itemStack1 = PlayerHandler.getPlayerBaubles(player).getStackInSlot(1);
                ItemStack itemStack2 = PlayerHandler.getPlayerBaubles(player).getStackInSlot(2);
                World world = player.worldObj;

                if (RingUtils.isLegalb(itemStack1, itemStack2, "Invisibility"))
                    player.setInvisible(true);

                if (RingUtils.isLegalb(itemStack1, itemStack2, "Growth"))
                    UpdatePlant(player, world);

                if (RingUtils.isLegalb(itemStack1, itemStack2, "Harvest"))
                    HarvestPlant(player, world);

                if (RingUtils.isLegalb(itemStack1, itemStack2, "Repair"))
                    RepairItem(player, world);

            }
        }
    }

    private void UpdatePlant(EntityPlayer player, World world) {
        if (!world.isRemote) {
            int range = 5;
            int verticalRange = 2;
            int posX = (int) Math.round(player.posX - 0.5f);
            int posY = (int) player.posY;
            int posZ = (int) Math.round(player.posZ - 0.5f);

            for (int ix = posX - range; ix <= posX + range; ix++)
                for (int iz = posZ - range; iz <= posZ + range; iz++)
                    for (int iy = posY - verticalRange; iy <= posY + verticalRange; iy++) {
                        Block block = world.getBlockState(new BlockPos(ix, iy, iz)).getBlock();
                        IBlockState state = world.getBlockState(new BlockPos(ix, iy, iz));

                        if (block instanceof IPlantable)
                            if (world.rand.nextInt(ConfigurationHandler.GrowthChance) == 0)
                                block.updateTick(world, new BlockPos(ix, iy, iz), state, world.rand);
                    }
        }
    }

    private void HarvestPlant(EntityPlayer Player, World world) {
        if (!world.isRemote) {
            int range = 5;
            int verticalRange = 2;
            int posX = (int) Math.round(Player.posX - 0.5f);
            int posY = (int) Player.posY;
            int posZ = (int) Math.round(Player.posZ - 0.5f);

            for (int ix = posX - range; ix <= posX + range; ix++)
                for (int iz = posZ - range; iz <= posZ + range; iz++)
                    for (int iy = posY - verticalRange; iy <= posY + verticalRange; iy++) {
                        BlockPos pos = new BlockPos(ix, iy, iz);
                        Block block = world.getBlockState(pos).getBlock();
                        if (block == Blocks.melon_stem || block == Blocks.pumpkin_stem)
                            continue;
                        if (block == Blocks.melon_block || block == Blocks.pumpkin) {
                            block.dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
                            world.setBlockToAir(pos);
                        }
                        if (block instanceof IGrowable && !((IGrowable) block).canGrow(world, pos, world.getBlockState(pos), true)) {
                            block.dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
                            world.setBlockState(pos, block.getDefaultState(), 2);
                        }
                    }
        }
    }

    private void RepairItem(EntityPlayer player, World world) {
        if (!world.isRemote) {
            if (world.rand.nextInt(ConfigurationHandler.RepairChance) == 0) {
                IInventory inv = player.inventory;

                for (int i = 0; i < inv.getSizeInventory(); i++) {
                    ItemStack invStack = inv.getStackInSlot(i);

                    if (invStack == null || !invStack.getItem().isRepairable()) {
                        continue;
                    }
                    if (invStack.equals(player.getHeldItemMainhand()) && player.isSwingInProgress) {
                        continue;
                    }
                    if (invStack.equals(player.getHeldItemOffhand()) && player.isSwingInProgress) {
                        continue;
                    }
                    if (!invStack.getHasSubtypes() && invStack.getMaxDamage() != 0 && invStack.getItemDamage() > 0) {
                        invStack.setItemDamage(invStack.getItemDamage() - 1);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onBreaking(PlayerEvent.BreakSpeed event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            ItemStack itemStack = player.getHeldItemMainhand();
            ItemStack itemStack1 = PlayerHandler.getPlayerBaubles(player).getStackInSlot(1);
            ItemStack itemStack2 = PlayerHandler.getPlayerBaubles(player).getStackInSlot(2);

            if (itemStack != null && RingUtils.isLegalf(itemStack1, itemStack2, "Haste")) {
                float haste = RingUtils.getFloatFromBauble(itemStack1, itemStack2, "Haste");
                float f = event.getOriginalSpeed() + haste;
                event.setNewSpeed(f);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            ItemStack itemStack1 = PlayerHandler.getPlayerBaubles(player).getStackInSlot(1);
            ItemStack itemStack2 = PlayerHandler.getPlayerBaubles(player).getStackInSlot(2);
            if (RingUtils.isLegali(itemStack1, itemStack2, "Power")) {
                float power = (float) RingUtils.getIntFromBauble(itemStack1, itemStack2, "Power");
                float amount = event.getAmount() + power;
                event.setAmount(amount);
            }
        }
    }


    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.RING;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPlayerLoggedInEvent(PlayerLoggedInEvent event) {
        NightVision = true;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPlayerChangedDimensionEvent(PlayerChangedDimensionEvent event) {
        NightVision = true;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPlayerLoggedOutEvent(PlayerLoggedOutEvent event) {
        NightVision = true;
    }

}
