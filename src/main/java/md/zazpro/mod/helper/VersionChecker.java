/*
 * This class (VersionChecker.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.helper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.config.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.versioning.ComparableVersion;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class VersionChecker {

    public static void checkVersion(EntityPlayer player) {
        if (ConfigurationHandler.CUpdate) {
            try {
                String jsonURL = "https://raw.githubusercontent.com/ZAZPRO/BaublesStuff/master/update/versions.json";
                JsonObject main = new JsonParser().parse(getSite(jsonURL, "utf8")).getAsJsonObject();
                JsonObject modLastVersion = main.get("promos").getAsJsonObject();
                JsonObject changelog = main.getAsJsonObject().get(ModInfo.MVERSION).getAsJsonObject();

                String newRecomVersion = modLastVersion.get(ModInfo.MVERSION + "-recommended").getAsString();
                ComparableVersion recommended = new ComparableVersion(newRecomVersion);
                ComparableVersion current = new ComparableVersion(ModInfo.VERSION);
                int diff = recommended.compareTo(current);
                if (diff == 0)
                    System.out.print("Mod is up to date");
                else {
                    System.out.println(changelog.get(newRecomVersion).toString());
                    System.out.print(main.get("homepage").toString().substring(1, 61));

                    player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.WHITE + "Update Baubles Stuff " + modLastVersion.get(ModInfo.MVERSION + "-recommended") + " is available on "));
                    ITextComponent component = ITextComponent.Serializer.jsonToComponent("{\n" +
                            "\"text\":\"Curse\",\n" +
                            "\"color\":\"yellow\",\n" +
                            "\"hoverEvent\":{\n" +
                            "\"action\":\"show_text\",\n" +
                            "\"value\":{\n" +
                            "\"text\":\"Click this button for download latest version\",\n" +
                            "\"color\":\"yellow\"\n" +
                            "}\n" +
                            "},\n" +
                            "\"clickEvent\":{\n" +
                            "\"action\":\"open_url\",\n" +
                            "\"value\":\"" + main.get("homepage").getAsString() + "\"\n" +
                            "}\n" +
                            "}");
                    player.addChatComponentMessage(component);
                    player.addChatComponentMessage(new ITextComponent.Serializer().jsonToComponent("{\n" +
                            "\"text\":\"" + changelog.get(newRecomVersion).getAsString() + "\"\n" +
                            "}"
                    ));
                }
            } catch (Exception e) {
                player.addChatComponentMessage(new TextComponentTranslation("[Baubles Stuff] Update check aborted!"));
            }
        }
    }

    public static String getSite(String url, String enc) throws Exception {

        StringBuffer stringBuffer = new StringBuffer();
        //curl -o file3.htm -H "User-Agent: Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.1.8) Gecko/20100214 Ubuntu/9.10 (karmic) Firefox/3.5.8" -H "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,/;q=0.8" -H "Accept-Language: en-us,en;q=0.5" -H "Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7" -H "Keep-Alive: 300" -H "Connection: keep-alive" http://www.mygarden.com

        if (url.length() < 8 || !(url.substring(0, 7).equalsIgnoreCase("http://") || url.substring(0, 8).equalsIgnoreCase("https://")))
            url = "http://" + url;

        URL urlObj = new URL(url);
        InputStream inputStream = urlObj.openStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, enc));
        String str = br.readLine();
        while (str != null) {
            stringBuffer.append(str);
            str = br.readLine();
        }

        inputStream.close();
        return stringBuffer.toString();
    }
}



