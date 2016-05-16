package md.zazpro.mod.common.items;

import md.zazpro.mod.client.CreativeTab;
import net.minecraft.item.Item;

public class Broken_Translator extends Item {
    public Broken_Translator() {
        super();
        setUnlocalizedName("Broken_Translator");
        setRegistryName("Broken_Translator");
        setMaxStackSize(64);
        setMaxDamage(0);
        setCreativeTab(CreativeTab.tabBaublesStuff);
    }
}
