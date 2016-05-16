package md.zazpro.mod.helper;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import md.zazpro.mod.client.ModInfo;
import md.zazpro.mod.common.config.Config;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class VersionChecker {

    public static void checkVersion(EntityPlayer player) {
        if (Config.CUpdate) {
            try {
                JsonObject object = new JsonParser().parse(getSite("https://widget.mcf.li/mc-mods/minecraft/236988-baubles-stuff.json", "utf8")).getAsJsonObject().get("versions").getAsJsonObject().get(ModInfo.MVERSION).getAsJsonArray().get(0).getAsJsonObject();
                if (findWord(object.get("name").getAsString(), ModInfo.VERSION, false) == -1 && object.get("type").getAsString().equalsIgnoreCase("release")) {
                    player.addChatComponentMessage(new TextComponentTranslation(TextFormatting.WHITE + "Update " + object.get("name") + " are available on "));
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
                            "\"value\":\"" + object.get("url").getAsString() + "\"\n" +
                            "}\n" +
                            "}");
                    player.addChatComponentMessage(component);
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

    public static int findWord(String from, String word, boolean ignoreCase) {
        for (int i = 0; i < from.length(); i++)
            if (equalsChar(from.charAt(i), word.charAt(0), ignoreCase))
                if (checkAllWord(from, i, word, ignoreCase))
                    return i;
        return -1;
    }

    static boolean equalsChar(char a, char b, boolean ignoreCase) {
        return ignoreCase ? (Character.toLowerCase(a) == Character.toLowerCase(b)) || (Character.toTitleCase(a) == Character.toTitleCase(b)) : a == b;
    }

    static boolean checkAllWord(String from, int charp, String word, boolean ignoreCase) {
        if (from.length() >= charp + word.length()) {
            for (int i = 1; i < word.length(); i++)
                if (!equalsChar(from.charAt(charp + i), word.charAt(i), ignoreCase))
                    return false;
        } else return false;
        return true;
    }
}



