package md.zazpro.mod.proxy;

import md.zazpro.mod.common.blocks.BlockRegister;
import md.zazpro.mod.common.items.ItemsAndUpgrades;
import md.zazpro.mod.helper.UpdateHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ItemsAndUpgrades.registerRenders();
        BlockRegister.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        MinecraftForge.EVENT_BUS.register(new UpdateHandler());
    }
}
