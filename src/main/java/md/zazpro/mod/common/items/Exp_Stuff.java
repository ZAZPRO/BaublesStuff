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

public class Exp_Stuff extends Item {
    Exp_Stuff() {
        super();
        setUnlocalizedName("Exp_Stuff");
        setRegistryName("Exp_Stuff");
        setMaxStackSize(1);
        setCreativeTab(CreativeTab.tabBaublesStuff);
    }

    public static int getInteger(ItemStack stack, String name) {
        if (stack != null && stack.getTagCompound() != null && stack.getTagCompound().hasKey(name)) {
            return stack.getTagCompound().getInteger(name);
        } else return 0;
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
        if (!world.isRemote) {
            if (itemStack.hasTagCompound()) {
                int lvlPlayer = player.experienceLevel;
                int lvlItem = NBTHelper.getInteger(itemStack, "expLVL");
                player.removeExperienceLevel(lvlPlayer);
                player.addExperienceLevel(lvlItem);
                NBTHelper.setInteger(itemStack, "expLVL", lvlPlayer);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStack);
    }

    public EnumActionResult onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (itemStack.hasTagCompound()) {
                if (world.getTileEntity(pos) instanceof TEExpGenerator) {
                    TEExpGenerator te = (TEExpGenerator) world.getTileEntity(pos);
                    int lvlItem = NBTHelper.getInteger(itemStack, "expLVL");
                    int lvlTe = te.getLvlStored();
                    te.setLvlStored(lvlItem);
                    NBTHelper.setInteger(itemStack, "expLVL", lvlTe);
                }
            }
        }
        return EnumActionResult.SUCCESS;
    }
}

