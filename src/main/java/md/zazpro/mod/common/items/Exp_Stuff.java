package md.zazpro.mod.common.items;

import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.common.tileentity.TEExpGenerator;
import md.zazpro.mod.helper.NBTHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class Exp_Stuff extends Item {
    Exp_Stuff() {
        super();
        setUnlocalizedName("Exp_Stuff");
        setRegistryName("Exp_Stuff");
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.tabBaublesStuff);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player,
                               java.util.List list, boolean p_77624_4_) {
        list.add(TextFormatting.DARK_GREEN + I18n.translateToLocal("tooltip.Exp_Stuff") + ": " + NBTHelper.getInteger(itemStack, "expLVL"));
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        if (!stack.hasTagCompound()) {
            NBTHelper.setInteger(stack, "expLVL", 0);
        }
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
        int expLVL;
        int lvlItem;
        if (!world.isRemote) {
            if (itemStack.hasTagCompound()) {
                expLVL = player.experienceLevel;
                lvlItem = NBTHelper.getInteger(itemStack, "expLVL");
                if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    if (expLVL < lvlItem) {
                        NBTHelper.setInteger(itemStack, "expLVL", expLVL);
                        player.removeExperienceLevel(expLVL);
                        player.experienceTotal = 0;
                        player.experience = 0;
                        player.addExperienceLevel(lvlItem);
                    }
                } else if (expLVL > lvlItem) {
                    NBTHelper.setInteger(itemStack, "expLVL", expLVL);
                    player.removeExperienceLevel(expLVL);
                    player.experienceTotal = 0;
                    player.experience = 0;
                    player.addExperienceLevel(lvlItem);
                }
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }

    public EnumActionResult onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (itemStack.hasTagCompound()) {
                if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    if (world.getTileEntity(pos) instanceof TEExpGenerator) {
                        TEExpGenerator te = (TEExpGenerator) world.getTileEntity(pos);
                        int lvlItem = NBTHelper.getInteger(itemStack, "expLVL");
                        int lvlTe = te.getLvlStored();
                        te.setLvlStored(lvlItem);
                        NBTHelper.setInteger(itemStack, "expLVL", lvlTe);
                    }
                }
            }
        }
        return EnumActionResult.SUCCESS;
    }

    public static int getInteger(ItemStack stack, String name) {
        if (stack != null && stack.getTagCompound() != null && stack.getTagCompound().hasKey(name)) {
            return stack.getTagCompound().getInteger(name);
        } else return 0;
    }
}

