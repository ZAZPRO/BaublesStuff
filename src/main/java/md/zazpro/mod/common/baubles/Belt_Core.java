/*
 * This class (Belt_Core.java) was created by <zazpro>. It's distributed as
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
import baubles.api.cap.IBaublesItemHandler;
import baubles.api.render.IRenderBauble;
import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.config.ConfigurationHandler;
import md.zazpro.mod.common.energy.BaubleBSUContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class Belt_Core extends BaubleBSUContainer implements IRenderBauble {

    private static final int COST_INTERVAL = 20;
    private static final ResourceLocation texture = new ResourceLocation("baublesstuff:textures/model/Belt_Core.png");
    public static List<String> playersWith1Step = new ArrayList();
    @SideOnly(Side.CLIENT)
    private static ModelBiped model;


    public Belt_Core(String name) {
        super(800000, 1000, 1000);
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.tabBaublesStuff);
        setHasSubtypes(true);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player,
                               java.util.List list, boolean p_77624_4_) {

        list.add(TextFormatting.GOLD + (this.getBSUStored(itemStack) + "/" + this.getMaxBSUStored(itemStack) + " BSU"));
        list.add(I18n.translateToLocal("tooltip.shift"));

        if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.belt.HighStep"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.belt.Speed"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.belt.Jump"));
            list.add(TextFormatting.WHITE + I18n.translateToLocal("tooltip.belt.Fly"));
        } else if (itemStack.getTagCompound() != null) {
            Boolean highStep = itemStack.getTagCompound().getBoolean("highStep");
            if (highStep) list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.belt.HighStep"));
            Integer speed = itemStack.getTagCompound().getInteger("speed");
            if (speed > 0)
                list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.belt.SpeedLVL") + ": " + speed);
            float jump = itemStack.getTagCompound().getFloat("jump");
            if (jump > 0)
                list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.belt.JumpLVL") + ": " + (Math.round(jump * 10) - 1));
            Boolean fly = itemStack.getTagCompound().getBoolean("fly");
            if (fly) list.add(TextFormatting.AQUA + I18n.translateToLocal("tooltip.belt.Fly"));
        }
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase e) {
        if (itemStack.getTagCompound() != null) {

            Boolean stepHeight = itemStack.getTagCompound().getBoolean("highStep");
            Integer speed = itemStack.getTagCompound().getInteger("speed");
            Float jump = itemStack.getTagCompound().getFloat("jump");
            Boolean fly = itemStack.getTagCompound().getBoolean("fly");

            if (e instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) e;
                if (speed > 0 && player.moveForward > 0F) {
                    if (this.getBSUStored(itemStack) >= ConfigurationHandler.Belt_SPEED) {
                        if (player.ticksExisted % COST_INTERVAL == 0)
                            this.extractBSU(itemStack, ConfigurationHandler.Belt_SPEED, false);
                        player.moveRelative(0F, 1F, player.capabilities.isFlying ? 0.030F : (speed * 0.05F));
                    }
                }

                if (stepHeight) {
                    if (player.worldObj.isRemote) {
                        if (player.ticksExisted % COST_INTERVAL == 0 && this.getBSUStored(itemStack) >= ConfigurationHandler.Belt_STEP && !player.isSneaking()) {
                            this.extractBSU(itemStack, ConfigurationHandler.Belt_STEP, false);
                            player.stepHeight = 1F;
                        } else if (player.isSneaking())
                            player.stepHeight = 0.5F;
                    }
                }

                if (fly && !player.capabilities.isCreativeMode && !player.onGround) {
                    if (this.getBSUStored(itemStack) >= ConfigurationHandler.Belt_FLY) {
                        if (player.ticksExisted % COST_INTERVAL == 0)
                            this.extractBSU(itemStack, ConfigurationHandler.Belt_FLY, false);
                        player.capabilities.allowFlying = true;
                        player.sendPlayerAbilities();
                    } else {
                        player.capabilities.allowFlying = false;
                        player.sendPlayerAbilities();
                    }
                }

                if (jump > 0.1F && !player.onGround)
                    player.jumpMovementFactor = 0.1F;
            }
        }
    }

    @SubscribeEvent
    public void onPlayerJump(LivingJumpEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            ItemStack itemStack = BaublesApi.getBaublesHandler(player).getStackInSlot(3);

            if (itemStack != null && itemStack.getTagCompound() != null && itemStack.getItem() instanceof Belt_Core) {
                float jump = itemStack.getTagCompound().getFloat("jump");
                if (this.getBSUStored(itemStack) >= ConfigurationHandler.Belt_JUMP) {
                    this.extractBSU(itemStack, ConfigurationHandler.Belt_JUMP, false);
                    player.motionY += jump;
                }
            }
        }
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase e) {
    /*    if (itemStack.getTagCompound() != null) {
            Boolean fly = itemStack.getTagCompound().getBoolean("fly");
            Integer speed = itemStack.getTagCompound().getInteger("speed");
            EntityPlayer player = (EntityPlayer) e;

            if (speed > 0 && player.worldObj.isRemote) {
                player.capabilities.setPlayerWalkSpeed(player.capabilities.getWalkSpeed() + (speed * 0.08F));
                player.capabilities.setFlySpeed(player.capabilities.getFlySpeed() + (speed * 0.06F));
            }

            if (fly) {
                player.capabilities.allowFlying = true;
            }
            player.sendPlayerAbilities();
        }*/
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase e) {
        EntityPlayer player = (EntityPlayer) e;
        player.stepHeight = 0.5F;
        player.setAIMoveSpeed(0.1F);
        if (!player.capabilities.isCreativeMode) {
            player.capabilities.allowFlying = false;
        }
        if (player.worldObj.isRemote) {
            player.capabilities.setPlayerWalkSpeed(0.1F);
            player.capabilities.setFlySpeed(0.05F);
        }
        player.sendPlayerAbilities();
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.BELT;
    }

    @SubscribeEvent
    public void onPlayerLoggedInEvent(PlayerLoggedInEvent event) {
        if (event.player != null) {

            if (!event.player.worldObj.isRemote) {
                EntityPlayer entityPlayer = event.player;
                IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(entityPlayer);

                ItemStack itemStack = baubles.getStackInSlot(3);
                Item item;
                if (itemStack != null) {
                    item = itemStack.getItem();
                    if (item instanceof Belt_Core) {
                        onEquipped(itemStack, entityPlayer);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerLoggedInEvent(PlayerChangedDimensionEvent event) {
        if (event.player != null) {

            if (!event.player.worldObj.isRemote) {
                EntityPlayer entityPlayer = event.player;
                IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(entityPlayer);

                ItemStack itemStack = baubles.getStackInSlot(3);
                Item item;
                if (itemStack != null) {
                    item = itemStack.getItem();
                    if (item instanceof Belt_Core) {
                        onEquipped(itemStack, entityPlayer);
                    }
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onLivingUpdate(LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer && event.getEntityLiving().worldObj.isRemote) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);

            boolean highStepListed = playersWith1Step.contains(player.getGameProfile().getName());
            boolean hasHighStep = baubles.getStackInSlot(3) != null && baubles.getStackInSlot(3).getItem() == this;
            boolean stepHeight = false;
            ItemStack itemStack = baubles.getStackInSlot(3);
            if (itemStack != null && itemStack.hasTagCompound() && itemStack.getItem() == this)
                stepHeight = itemStack.getTagCompound().getBoolean("highStep");

            if (!highStepListed && (hasHighStep && stepHeight))
                playersWith1Step.add(player.getGameProfile().getName());


            if ((!hasHighStep || !stepHeight) && highStepListed) {
                playersWith1Step.remove(player.getGameProfile().getName());
                player.stepHeight = 0.5F;
            }
        }
    }

    // This is a fun method which allows us to run some code when our item is
    // shown in a creative tab.
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List itemList) {
        ItemStack itemStack = new ItemStack(item);
        this.setBSUStored(itemStack, 0);
        itemList.add(itemStack);
        ItemStack itemStack1 = new ItemStack(item);
        this.setBSUStored(itemStack1, this.getMaxBSUStored(itemStack));
        itemList.add(itemStack1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onPlayerBaubleRender(ItemStack itemStack, EntityPlayer entityPlayer, RenderType renderType, float v) {
        if (renderType == RenderType.BODY) {
            Minecraft.getMinecraft().renderEngine.bindTexture(getRenderTexture());
            Helper.rotateIfSneaking(entityPlayer);

            GlStateManager.translate(0F, 0.2F, 0F);

            float s = 1.05F / 16F;
            GlStateManager.scale(s, s, s);
            if (model == null)
                model = new ModelBiped();

            model.bipedBody.render(1F);
        }
    }

    @SideOnly(Side.CLIENT)
    ResourceLocation getRenderTexture() {
        System.out.println(texture);
        return texture;
    }
}

