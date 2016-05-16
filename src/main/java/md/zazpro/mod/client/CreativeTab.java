package md.zazpro.mod.client;

import md.zazpro.mod.common.items.ItemsAndUpgrades;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTab {

    public static CreativeTabs tabBaublesStuff = new CreativeTabs("TabBaublesStuff") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return ItemsAndUpgrades.Pendant_Core;
        }
    };

    public static void TabRegister() {
    }

}

