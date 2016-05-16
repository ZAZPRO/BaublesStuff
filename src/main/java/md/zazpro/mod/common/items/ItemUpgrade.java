package md.zazpro.mod.common.items;

import md.zazpro.mod.client.CreativeTab;
import md.zazpro.mod.interfaces.IUpgrade;
import net.minecraft.item.Item;

public class ItemUpgrade extends Item implements IUpgrade {
    public ItemUpgrade(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setMaxDamage(0);
        setCreativeTab(CreativeTab.tabBaublesStuff);
    }
}
