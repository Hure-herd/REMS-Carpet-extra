package rems.carpet;

import static rems.carpet.utils.REMSRuleCategory.*;
import carpet.api.settings.Rule;
import carpet.api.settings.RuleCategory;

public class REMSSettings
{

    @Rule(
            options = {"ON", "OFF"},
            categories = {REMS, SURVIVAL}
    )
    public static String pistonBlockChunkLoader = "OFF";

    @Rule(
            categories = {REMS, FEATURE}
    )
    public static boolean keepWorldTickUpdate = false;

    @Rule(categories = {REMS, FEATURE, SURVIVAL})
    public static boolean scheduledRandomTickCactus = false;

    @Rule(categories = {REMS, FEATURE, SURVIVAL})
    public static boolean mergeTNTPro = false;

    @Rule(
            categories = {REMS, FEATURE}
    )
    public static boolean disableBatCanSpawn = false;

    @Rule(categories = {REMS, CREATIVE, SURVIVAL})
    public static boolean CactusWrenchSound = false;

    @Rule(
            categories = {REMS, CREATIVE}
    )
    public static boolean disablePortalUpdate = false;
}
