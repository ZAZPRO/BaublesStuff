/*
 * This class (BlockRegister.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.common.blocks;

import md.zazpro.mod.client.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegister {

    public static Block UpgradeExtractor;
    public static Block BlockExpGenerator;

    private static void registerBlock(Block block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        itemBlock.setRegistryName(block.getRegistryName());
        GameRegistry.register(itemBlock);
    }

    private static void registerRender(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(
                ModInfo.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }

    public static void init() {
        UpgradeExtractor = new UpgradeExtractor();
        ItemBlock itemUpgradeExtractor = new ItemBlock(UpgradeExtractor);
        registerBlock(UpgradeExtractor, itemUpgradeExtractor);

        BlockExpGenerator = new BlockExpGenerator();
        ItemBlock itemBlockExpGenerator = new ItemBlock(BlockExpGenerator);
        registerBlock(BlockExpGenerator, itemBlockExpGenerator);
    }

    public static void registerRenders() {
        registerRender(UpgradeExtractor);
        registerRender(BlockExpGenerator);
    }
}
