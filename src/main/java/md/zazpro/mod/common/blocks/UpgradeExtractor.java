package md.zazpro.mod.common.blocks;

import baubles.api.IBauble;
import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.common.tileentity.TEExtractor;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class UpgradeExtractor extends BlockContainer {
    public UpgradeExtractor() {
        super(Material.rock);
        this.setUnlocalizedName("UpgradeExtractor");
        this.setRegistryName("UpgradeExtractor");
        this.setCreativeTab(CreativeTab.tabBaublesStuff);
        this.setHardness(1.0F);
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        boolean statement = false;
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        if (heldItem != null && heldItem.getItem() instanceof IBauble && heldItem.hasTagCompound()) {
            if (heldItem.hasTagCompound() && heldItem.getItem() instanceof IBauble) {
                if (!world.isRemote)
                    for (int i = 0; i < heldItem.getTagCompound().getTagList("ItemStacksInBauble", Constants.NBT.TAG_COMPOUND).tagCount(); i++)
                        world.spawnEntityInWorld(new EntityItem(world, x, y, z, ItemStack.loadItemStackFromNBT(heldItem.getTagCompound().getTagList("ItemStacksInBauble", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i))));
                player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(player.getHeldItemMainhand().getItem(), player.getHeldItemMainhand().stackSize, player.getHeldItemMainhand().getItemDamage()));
                statement = true;
            }
        }
        return statement;
    }

/*    public static void registerRenders() {
        reg(BaublesStuff.UpgradeExtractor);
    }

    private static void reg(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(
                ModInfo.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }

    private static void reg1(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        ModelBakery.registerItemVariants(Item.getItemFromBlock(block), new ResourceLocation(block.getUnlocalizedName().substring(5)));
    }*/

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TEExtractor();
    }
}


