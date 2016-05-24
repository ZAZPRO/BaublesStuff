/*
 * This class (BSGuiConfig.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.client.gui;

import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.config.ConfigurationHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class BSGuiConfig extends GuiConfig {
    public BSGuiConfig(GuiScreen guiScreen) {
        super(guiScreen,
                getConfigElements(),
                ModInfo.MODID,
                false,
                false,
                "Baubles Stuff configuration");
    }

    /**
     * Compiles a list of config elements
     */
    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();

        for (String name : ConfigurationHandler.configuration.getCategoryNames()) {
            list.add(new ConfigElement(ConfigurationHandler.configuration.getCategory(name)));
        }

        return list;
    }
}
