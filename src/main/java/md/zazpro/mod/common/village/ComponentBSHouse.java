/*
 * This class (ComponentBSHouse.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.village;

import md.zazpro.mod.common.blocks.BlockRegister;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

public class ComponentBSHouse extends StructureVillagePieces.Village {
    public ComponentBSHouse() {
    }

    public ComponentBSHouse(StructureVillagePieces.Start start, int weight, Random random, StructureBoundingBox box, EnumFacing facing) {
        super(start, weight);
        this.setCoordBaseMode(facing);
        this.boundingBox = box;
    }

    public static ComponentBSHouse func_175854_a(StructureVillagePieces.Start start, List<StructureComponent> list, Random rand, int p_175854_3_, int p_175854_4_, int p_175854_5_, EnumFacing facing, int p_175854_7_) {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175854_3_, p_175854_4_, p_175854_5_, 0, 0, 0, 9, 9, 6, facing);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(list, structureboundingbox) == null ? new ComponentBSHouse(start, p_175854_7_, rand, structureboundingbox, facing) : null;
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox bbox) {
        if (this.averageGroundLvl < 0) {
            this.averageGroundLvl = this.getAverageGroundLevel(world, bbox);

            if (this.averageGroundLvl < 0) {
                return true;
            }

            this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + 9 - 1, 0);
        }

        this.fillWithBlocks(world, bbox, 1, 1, 1, 7, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        IBlockState stone = Blocks.COBBLESTONE.getDefaultState();
        IBlockState planks = Blocks.PLANKS.getDefaultState();
        IBlockState wood = Blocks.LOG.getDefaultState();
        IBlockState pane = Blocks.GLASS_PANE.getDefaultState();

        //Bottom square
        this.fillWithBlocks(world, bbox, 0, 0, 0, 0, 0, 5, stone, stone, false);
        this.fillWithBlocks(world, bbox, 1, 0, 5, 8, 0, 5, stone, stone, false);
        this.fillWithBlocks(world, bbox, 8, 0, 0, 8, 0, 4, stone, stone, false);
        this.fillWithBlocks(world, bbox, 1, 0, 0, 7, 0, 0, stone, stone, false);

        this.fillWithBlocks(world, bbox, 1, 0, 1, 7, 0, 4, planks, planks, false);
        this.fillWithBlocks(world, bbox, 0, 5, 0, 8, 5, 5, wood, wood, false);
        this.fillWithBlocks(world, bbox, 0, 6, 1, 8, 6, 4, planks, planks, false);
        this.fillWithBlocks(world, bbox, 0, 7, 2, 8, 7, 3, planks, planks, false);

        IBlockState rotatedStairs = Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH);
        IBlockState rotatedStairs1 = Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH);
        for (int k = -1; k <= 2; ++k) {
            for (int l = 0; l <= 8; ++l) {
                this.setBlockState(world, rotatedStairs, l, 6 + k, k, bbox);
                this.setBlockState(world, rotatedStairs1, l, 6 + k, 5 - k, bbox);
            }
        }


        this.fillWithBlocks(world, bbox, 0, 1, 1, 0, 1, 4, planks, planks, false);
        this.fillWithBlocks(world, bbox, 1, 1, 5, 7, 1, 5, planks, planks, false);
        this.fillWithBlocks(world, bbox, 8, 1, 1, 8, 1, 4, planks, planks, false);
        this.fillWithBlocks(world, bbox, 2, 1, 0, 7, 1, 0, planks, planks, false);
        this.fillWithBlocks(world, bbox, 0, 1, 0, 0, 4, 0, wood, wood, false);
        this.fillWithBlocks(world, bbox, 0, 1, 5, 0, 4, 5, wood, wood, false);
        this.fillWithBlocks(world, bbox, 8, 1, 5, 8, 4, 5, wood, wood, false);
        this.fillWithBlocks(world, bbox, 8, 1, 0, 8, 4, 0, wood, wood, false);
        this.fillWithBlocks(world, bbox, 0, 2, 1, 0, 4, 4, planks, planks, false);
        this.fillWithBlocks(world, bbox, 1, 2, 5, 7, 4, 5, planks, planks, false);
        this.fillWithBlocks(world, bbox, 8, 2, 1, 8, 4, 4, planks, planks, false);
        this.fillWithBlocks(world, bbox, 1, 2, 0, 7, 4, 0, planks, planks, false);
        this.setBlockState(world, pane, 3, 2, 0, bbox);
        this.setBlockState(world, pane, 4, 2, 0, bbox);
        this.setBlockState(world, pane, 5, 2, 0, bbox);
        this.setBlockState(world, pane, 6, 2, 0, bbox);
        this.setBlockState(world, pane, 3, 3, 0, bbox);
        this.setBlockState(world, pane, 4, 3, 0, bbox);
        this.setBlockState(world, pane, 5, 3, 0, bbox);
        this.setBlockState(world, pane, 6, 3, 0, bbox);
        this.setBlockState(world, pane, 0, 2, 2, bbox);
        this.setBlockState(world, pane, 0, 2, 3, bbox);
        this.setBlockState(world, pane, 0, 3, 2, bbox);
        this.setBlockState(world, pane, 0, 3, 3, bbox);
        this.setBlockState(world, pane, 8, 2, 2, bbox);
        this.setBlockState(world, pane, 8, 2, 3, bbox);
        this.setBlockState(world, pane, 8, 3, 2, bbox);
        this.setBlockState(world, pane, 8, 3, 3, bbox);
        this.setBlockState(world, pane, 2, 2, 5, bbox);
        this.setBlockState(world, pane, 3, 2, 5, bbox);
        this.setBlockState(world, pane, 2, 3, 5, bbox);
        this.setBlockState(world, pane, 3, 3, 5, bbox);
        this.setBlockState(world, pane, 5, 2, 5, bbox);
        this.setBlockState(world, pane, 6, 2, 5, bbox);
        this.setBlockState(world, pane, 5, 3, 5, bbox);
        this.setBlockState(world, pane, 6, 3, 5, bbox);
        this.fillWithBlocks(world, bbox, 1, 4, 1, 7, 4, 1, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);
        this.fillWithBlocks(world, bbox, 1, 4, 4, 7, 4, 4, Blocks.BOOKSHELF.getDefaultState(), Blocks.BOOKSHELF.getDefaultState(), false);

        this.setBlockState(world, Blocks.OAK_FENCE.getDefaultState(), 7, 1, 4, bbox);
        this.setBlockState(world, BlockRegister.UpgradeExtractor.getDefaultState(), 7, 1, 3, bbox);
        this.generateChest(world, bbox, random, 7, 1, 2, LootTableBS.LOOT_TABLE_BS);

        this.setBlockState(world, Blocks.OAK_FENCE.getDefaultState(), 7, 1, 1, bbox);
        this.setBlockState(world, Blocks.OAK_FENCE.getDefaultState(), 7, 2, 4, bbox);
        this.setBlockState(world, Blocks.OAK_FENCE.getDefaultState(), 7, 2, 1, bbox);
        this.setBlockState(world, Blocks.GLOWSTONE.getDefaultState(), 7, 3, 4, bbox);
        this.setBlockState(world, Blocks.GLOWSTONE.getDefaultState(), 7, 3, 1, bbox);
        this.setBlockState(world, Blocks.OAK_FENCE.getDefaultState(), 1, 1, 4, bbox);
        this.setBlockState(world, Blocks.OAK_FENCE.getDefaultState(), 1, 2, 4, bbox);
        this.setBlockState(world, Blocks.GLOWSTONE.getDefaultState(), 1, 3, 4, bbox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 1, 4, 2, bbox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 1, 4, 3, bbox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 7, 4, 2, bbox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 7, 4, 3, bbox);

        this.setBlockState(world, Blocks.AIR.getDefaultState(), 1, 1, 0, bbox);
        this.setBlockState(world, Blocks.AIR.getDefaultState(), 1, 2, 0, bbox);

        //this.placeDoorCurrentPosition(world, bbox, random, 1, 1, 0, EnumFacing.SOUTH);
        this.func_189915_a(world, bbox, random, 1, 1, 0, EnumFacing.SOUTH, Blocks.OAK_DOOR);

        IBlockState iblockstate = Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH);
        if (this.getBlockStateFromPos(world, 2, 0, -1, bbox).getMaterial() == Material.AIR && this.getBlockStateFromPos(world, 2, -1, -1, bbox).getMaterial() != Material.AIR) {
            this.setBlockState(world, iblockstate, 1, 0, -1, bbox);
        }

        for (int k = 0; k < 9; ++k) {
            for (int j = 0; j < 5; ++j) {
                this.clearCurrentPositionBlocksUpwards(world, j, 12, k, bbox);
                this.replaceAirAndLiquidDownwards(world, Blocks.COBBLESTONE.getDefaultState(), j, -1, k, bbox);
            }
        }

        this.spawnVillagers(world, bbox, 2, 1, 2, 2);
        return true;
    }

}
