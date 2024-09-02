package rems.carpet;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import net.minecraft.server.MinecraftServer;
import rems.carpet.utils.ComponentTranslate;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;

public class REMSServer implements CarpetExtension, ModInitializer
{
    public static String MOD_ID = "rems-additions";

    private static MinecraftServer minecraftServer;

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static MinecraftServer getServer() {
        return minecraftServer;
    }

    public String get_version() {
        return "1.0.0";
    }

    public static void loadExtension() {
        CarpetServer.manageExtension(new REMSServer());
    }

    @Override
    public void onInitialize() {
        REMSServer.loadExtension();
    }

    @Override
    public void onGameStarted() {

        LOGGER.info(MOD_ID + " " + "v" + get_version() + "载入成功");
        LOGGER.info("开源链接：https://github.com/Hure-herd/REMS-Carpet-extra");
        CarpetServer.settingsManager.parseSettingsClass(REMSSettings.class);

    }

    @Override
    public Map<String, String> canHasTranslations(String lang) {
        return ComponentTranslate.getTranslationFromResourcePath(lang);
    }

}