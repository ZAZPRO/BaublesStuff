package md.zazpro.mod.common.items;

import md.zazpro.mod.client.CreativeTab;
import net.minecraft.item.Item;

public class ItemSheet extends Item {
    public ItemSheet(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(64);
        setMaxDamage(0);
        setCreativeTab(CreativeTab.tabBaublesStuff);
    }

}
