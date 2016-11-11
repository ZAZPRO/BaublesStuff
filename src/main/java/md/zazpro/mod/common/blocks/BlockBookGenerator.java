/*
 * This class (BlockBookGenerator.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.blocks;

import md.zazpro.mod.BaublesStuff;
import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.client.gui.BSGuiHandler;
import md.zazpro.mod.common.tileentity.TEBookGenerator;
import md.zazpro.mod.common.tileentity.TEExpGenerator;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBookGenerator extends BlockContainer {
    private boolean isBookGenerator;

    protected BlockBookGenerator() {
        super(Material.ROCK);
        this.setUnlocalizedName("BlockBookGenerator");
        this.setRegistryName("BlockBookGenerator");
        this.setCreativeTab(CreativeTab.tabBaublesStuff);
        this.setHardness(1.0F);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing par6, float par7, float par8, float par9) {
        if (!world.isRemote) {
            if (this.isBookGenerator) {
                TEBookGenerator test = (TEBookGenerator) world.getTileEntity(pos);
                if (test != null) {
                    player.openGui(BaublesStuff.instance, BSGuiHandler.BOOK_GEN_TILE_ENTITY_GUI, world, pos.getX(), pos.getY(), pos.getZ());
                }
            } else {
                TEBookGenerator test = (TEBookGenerator) world.getTileEntity(pos);
                if (test != null) {
                    player.openGui(BaublesStuff.instance, BSGuiHandler.BOOK_GEN_TILE_ENTITY_GUI, world, pos.getX(), pos.getY(), pos.getZ());
                }
            }
            return true;
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
        TEBookGenerator te = (TEBookGenerator) world.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(world, pos, te);
        super.breakBlock(world, pos, blockstate);
    }


    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (stack.hasDisplayName()) {
            ((TEBookGenerator) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
        }
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TEBookGenerator();
    }
}
