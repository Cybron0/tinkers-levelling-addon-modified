package pyre.tinkerslevellingaddon.setup;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TinkersLevellingAddonTags {

    private static final String MOD_ID = "tinkerslevellingaddon";

    public static final TagKey<Item> ARMOR = create("armor");
    public static final TagKey<Item> BATTLESTAFF = create("battlestaff");
    public static final TagKey<Item> BREAKING_TOOL = create("breaking_tool");
    public static final TagKey<Item> DUAL_HEAVY_WEAPON_TOOL = create("dual_heavy_weapon_tool");
    public static final TagKey<Item> HEAVY_WEAPON = create("heavy_weapon");
    public static final TagKey<Item> LIGHT_WEAPON = create("light_weapon");
    public static final TagKey<Item> RANGED = create("ranged");
    public static final TagKey<Item> SHIELD = create("shield");
    public static final TagKey<Item> SPELLBOOK = create("spellbook");
    public static final TagKey<Item> STAFF = create("staff");
    public static final TagKey<Item> WAND = create("wand");

    public static final TagKey<Item> IMPROVABLE = create("improvable");

    private static TagKey<Item> create(String name) {
        return TagKey.create(
                Registries.ITEM,
                new ResourceLocation(MOD_ID, name)
        );
    }

    private TinkersLevellingAddonTags() {
    }
}
