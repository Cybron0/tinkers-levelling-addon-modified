package pyre.tinkerslevellingaddon.util;

import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import pyre.tinkerslevellingaddon.config.Config;
import pyre.tinkerslevellingaddon.network.LevelUpPacket;
import pyre.tinkerslevellingaddon.network.Messages;
import pyre.tinkerslevellingaddon.setup.TinkersLevellingAddonTags;
import pyre.tinkerslevellingaddon.setup.TinkersLevellingAddonStats;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.nbt.*;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.data.ModifierIds;
import com.snackpirate.constructscasting.materials.CCToolStats;
import com.snackpirate.constructscasting.setup.CCModifiers;

import java.util.*;

import static pyre.tinkerslevellingaddon.ImprovableModule.*;
import static pyre.tinkerslevellingaddon.util.ToolUtil.hasImprovable;

public class ToolLevellingUtil {
    public static final String NONE = "none";
    //slot types
    public static final String UPGRADE = "upgrade";
    public static final String ABILITY = "ability";
    public static final String SOUL = "soul";
    public static final String DEFENSE = "defense";
    public static final String BOON = "boon";
    
    //stat types
    public static final String DURABILITY = "durability";
    public static final String ATTACK_DAMAGE = "attackDamage";
    public static final String ATTACK_SPEED = "attackSpeed";
    public static final String MINING_SPEED = "miningSpeed";
    public static final String ARMOR = "armor";
    public static final String ARMOR_TOUGHNESS = "armorToughness";
    public static final String KNOCKBACK_RESISTANCE = "knockbackResistance";
    //ranged
    public static final String DRAW_SPEED = "drawSpeed";
    public static final String VELOCITY = "velocity";
    public static final String ACCURACY = "accuracy";
    public static final String PROJECTILE_DAMAGE = "projectileDamage";
    //shields
    public static final String BLOCK_AMOUNT = "blockAmount";
    public static final String BLOCK_ANGLE = "blockAngle";
    //Iron's compat
    public static final String MAX_MANA = "maxMana";
    public static final String SPELL_POWER = "spellPower";
    public static final String SPELL_SLOTS = "spellSlots";
    public static final String CASTING_SPEED = "castingSpeed";
    public static final String COOLDOWN_REDUCTION = "cooldownReduction";

    private static final Map<String, SlotType> ARMOR_SLOT_TYPES;
    private static final Map<String, SlotType> IRONS_SLOT_TYPES;
    private static final Map<String, SlotType> TOOL_SLOT_TYPES;
    private static final Map<String, SlotType> ALL_SLOT_TYPES;

    private static final Map<String, FloatToolStat> ARMOR_STAT_TYPES;
    private static final Map<String, FloatToolStat> BATTLESTAFF_STAT_TYPES;
    private static final Map<String, FloatToolStat> BREAKING_TOOL_STAT_TYPES;
    private static final Map<String, FloatToolStat> DUAL_HEAVY_WEAPON_TOOL_STAT_TYPES;
    private static final Map<String, FloatToolStat> HEAVY_WEAPON_STAT_TYPES;
    private static final Map<String, FloatToolStat> LIGHT_WEAPON_STAT_TYPES;
    private static final Map<String, FloatToolStat> RANGED_STAT_TYPES;
    private static final Map<String, FloatToolStat> SHIELD_STAT_TYPES;
    private static final Map<String, FloatToolStat> SPELLBOOK_STAT_TYPES;
    private static final Map<String, FloatToolStat> STAFF_STAT_TYPES;
    private static final Map<String, FloatToolStat> TOOL_STAT_TYPES;
    private static final Map<String, FloatToolStat> WAND_STAT_TYPES;
    private static final Map<String, FloatToolStat> ALL_STAT_TYPES;
    
    private static final Random RANDOM = new Random();
    
    static {
        //slots
        ARMOR_SLOT_TYPES = new LinkedHashMap<>();
        ARMOR_SLOT_TYPES.put(NONE, null);
        ARMOR_SLOT_TYPES.put(UPGRADE, SlotType.UPGRADE);
        ARMOR_SLOT_TYPES.put(ABILITY, SlotType.ABILITY);
        ARMOR_SLOT_TYPES.put(SOUL, SlotType.SOUL);
        ARMOR_SLOT_TYPES.put(DEFENSE, SlotType.DEFENSE);

        IRONS_SLOT_TYPES = new LinkedHashMap<>();
        IRONS_SLOT_TYPES.put(NONE, null);
        IRONS_SLOT_TYPES.put(UPGRADE, SlotType.UPGRADE);
        IRONS_SLOT_TYPES.put(ABILITY, SlotType.ABILITY);
        IRONS_SLOT_TYPES.put(SOUL, SlotType.SOUL);
        IRONS_SLOT_TYPES.put(BOON, CCModifiers.AFFINITY_SLOT);

        TOOL_SLOT_TYPES = new LinkedHashMap<>();
        TOOL_SLOT_TYPES.put(NONE, null);
        TOOL_SLOT_TYPES.put(UPGRADE, SlotType.UPGRADE);
        TOOL_SLOT_TYPES.put(ABILITY, SlotType.ABILITY);
        TOOL_SLOT_TYPES.put(SOUL, SlotType.SOUL);
        TOOL_SLOT_TYPES.put(DEFENSE, SlotType.DEFENSE);
        
        ALL_SLOT_TYPES = new HashMap<>(TOOL_SLOT_TYPES);
        ALL_SLOT_TYPES.putAll(ARMOR_SLOT_TYPES);
        ALL_SLOT_TYPES.putAll(IRONS_SLOT_TYPES);

        //stats
        ARMOR_STAT_TYPES = new LinkedHashMap<>();
        ARMOR_STAT_TYPES.put(NONE, null);
        ARMOR_STAT_TYPES.put(DURABILITY, ToolStats.DURABILITY);
        ARMOR_STAT_TYPES.put(ARMOR, ToolStats.ARMOR);
        ARMOR_STAT_TYPES.put(ARMOR_TOUGHNESS, ToolStats.ARMOR_TOUGHNESS);
        ARMOR_STAT_TYPES.put(KNOCKBACK_RESISTANCE, ToolStats.KNOCKBACK_RESISTANCE);

        BATTLESTAFF_STAT_TYPES = new LinkedHashMap<>();
        BATTLESTAFF_STAT_TYPES.put(NONE, null);
        BATTLESTAFF_STAT_TYPES.put(ATTACK_DAMAGE, ToolStats.ATTACK_DAMAGE);
        BATTLESTAFF_STAT_TYPES.put(ATTACK_SPEED, ToolStats.ATTACK_SPEED);
        BATTLESTAFF_STAT_TYPES.put(DURABILITY, ToolStats.DURABILITY);
        BATTLESTAFF_STAT_TYPES.put(MAX_MANA, CCToolStats.MAX_MANA);
        BATTLESTAFF_STAT_TYPES.put(SPELL_POWER, CCToolStats.SPELL_POWER);

        BREAKING_TOOL_STAT_TYPES = new LinkedHashMap<>();
        BREAKING_TOOL_STAT_TYPES.put(NONE, null);
        BREAKING_TOOL_STAT_TYPES.put(MINING_SPEED, ToolStats.MINING_SPEED);
        BREAKING_TOOL_STAT_TYPES.put(DURABILITY, ToolStats.DURABILITY);

        DUAL_HEAVY_WEAPON_TOOL_STAT_TYPES = new LinkedHashMap<>();
        DUAL_HEAVY_WEAPON_TOOL_STAT_TYPES.put(NONE, null);
        DUAL_HEAVY_WEAPON_TOOL_STAT_TYPES.put(ATTACK_DAMAGE, ToolStats.ATTACK_DAMAGE);
        DUAL_HEAVY_WEAPON_TOOL_STAT_TYPES.put(MINING_SPEED, ToolStats.MINING_SPEED);
        DUAL_HEAVY_WEAPON_TOOL_STAT_TYPES.put(DURABILITY, ToolStats.DURABILITY);

        HEAVY_WEAPON_STAT_TYPES = new LinkedHashMap<>();
        HEAVY_WEAPON_STAT_TYPES.put(NONE, null);
        HEAVY_WEAPON_STAT_TYPES.put(ATTACK_DAMAGE, ToolStats.ATTACK_DAMAGE);
        HEAVY_WEAPON_STAT_TYPES.put(ATTACK_SPEED, ToolStats.ATTACK_SPEED);
        HEAVY_WEAPON_STAT_TYPES.put(DURABILITY, ToolStats.DURABILITY);

        LIGHT_WEAPON_STAT_TYPES = new LinkedHashMap<>();
        LIGHT_WEAPON_STAT_TYPES.put(NONE, null);
        LIGHT_WEAPON_STAT_TYPES.put(ATTACK_DAMAGE, ToolStats.ATTACK_DAMAGE);
        LIGHT_WEAPON_STAT_TYPES.put(ATTACK_SPEED, ToolStats.ATTACK_SPEED);
        LIGHT_WEAPON_STAT_TYPES.put(DURABILITY, ToolStats.DURABILITY);
    
        RANGED_STAT_TYPES = new LinkedHashMap<>();
        RANGED_STAT_TYPES.put(NONE, null);
        RANGED_STAT_TYPES.put(DRAW_SPEED, ToolStats.DRAW_SPEED);
        RANGED_STAT_TYPES.put(VELOCITY, ToolStats.VELOCITY);
        RANGED_STAT_TYPES.put(ACCURACY, ToolStats.ACCURACY);
        RANGED_STAT_TYPES.put(PROJECTILE_DAMAGE, ToolStats.PROJECTILE_DAMAGE);
        RANGED_STAT_TYPES.put(DURABILITY, ToolStats.DURABILITY);

        SHIELD_STAT_TYPES = new LinkedHashMap<>();
        SHIELD_STAT_TYPES.put(NONE, null);
        SHIELD_STAT_TYPES.put(DURABILITY, ToolStats.DURABILITY);
        SHIELD_STAT_TYPES.put(ARMOR_TOUGHNESS, ToolStats.ARMOR_TOUGHNESS);
        SHIELD_STAT_TYPES.put(KNOCKBACK_RESISTANCE, ToolStats.KNOCKBACK_RESISTANCE);
        SHIELD_STAT_TYPES.put(BLOCK_AMOUNT, ToolStats.BLOCK_AMOUNT);
        SHIELD_STAT_TYPES.put(BLOCK_ANGLE, ToolStats.BLOCK_ANGLE);

        SPELLBOOK_STAT_TYPES = new LinkedHashMap<>();
        SPELLBOOK_STAT_TYPES.put(NONE, null);
        SPELLBOOK_STAT_TYPES.put(MAX_MANA, CCToolStats.MAX_MANA);
        SPELLBOOK_STAT_TYPES.put(SPELL_POWER, CCToolStats.SPELL_POWER);
        SPELLBOOK_STAT_TYPES.put(COOLDOWN_REDUCTION, CCToolStats.COOLDOWN_REDUCTION);
        SPELLBOOK_STAT_TYPES.put(SPELL_SLOTS, CCToolStats.SPELL_SLOTS);
        
        STAFF_STAT_TYPES = new LinkedHashMap<>();
        STAFF_STAT_TYPES.put(NONE, null);
        STAFF_STAT_TYPES.put(DRAW_SPEED, ToolStats.DRAW_SPEED);
        STAFF_STAT_TYPES.put(VELOCITY, ToolStats.VELOCITY);
        STAFF_STAT_TYPES.put(ACCURACY, ToolStats.ACCURACY);
        STAFF_STAT_TYPES.put(PROJECTILE_DAMAGE, ToolStats.PROJECTILE_DAMAGE);
        STAFF_STAT_TYPES.put(DURABILITY, ToolStats.DURABILITY);
        STAFF_STAT_TYPES.put(ARMOR, ToolStats.ARMOR);

        TOOL_STAT_TYPES = new LinkedHashMap<>();
        TOOL_STAT_TYPES.put(NONE, null);
        TOOL_STAT_TYPES.put(DURABILITY, ToolStats.DURABILITY);
        TOOL_STAT_TYPES.put(ATTACK_DAMAGE, ToolStats.ATTACK_DAMAGE);
        TOOL_STAT_TYPES.put(ATTACK_SPEED, ToolStats.ATTACK_SPEED);
        TOOL_STAT_TYPES.put(MINING_SPEED, ToolStats.MINING_SPEED);

        WAND_STAT_TYPES = new LinkedHashMap<>();
        WAND_STAT_TYPES.put(NONE, null);
        WAND_STAT_TYPES.put(MAX_MANA, CCToolStats.MAX_MANA);
        WAND_STAT_TYPES.put(SPELL_POWER, CCToolStats.SPELL_POWER);
        WAND_STAT_TYPES.put(COOLDOWN_REDUCTION, CCToolStats.COOLDOWN_REDUCTION);
        WAND_STAT_TYPES.put(CASTING_SPEED, TinkersLevellingAddonStats.CASTING_SPEED);

        ALL_STAT_TYPES = new HashMap<>(TOOL_STAT_TYPES);
        ALL_STAT_TYPES.putAll(ARMOR_STAT_TYPES);
        ALL_STAT_TYPES.putAll(BATTLESTAFF_STAT_TYPES);
        ALL_STAT_TYPES.putAll(BREAKING_TOOL_STAT_TYPES);
        ALL_STAT_TYPES.putAll(DUAL_HEAVY_WEAPON_TOOL_STAT_TYPES);
        ALL_STAT_TYPES.putAll(HEAVY_WEAPON_STAT_TYPES);
        ALL_STAT_TYPES.putAll(LIGHT_WEAPON_STAT_TYPES);
        ALL_STAT_TYPES.putAll(RANGED_STAT_TYPES);
        ALL_STAT_TYPES.putAll(SHIELD_STAT_TYPES);
        ALL_STAT_TYPES.putAll(SPELLBOOK_STAT_TYPES);
        ALL_STAT_TYPES.putAll(STAFF_STAT_TYPES);
        ALL_STAT_TYPES.putAll(WAND_STAT_TYPES);
    }

    //slots
    public static Set<String> getArmorSlotTypes() {
        return ARMOR_SLOT_TYPES.keySet();
    }

    public static Set<String> getBattlestaffSlotTypes() {
        return IRONS_SLOT_TYPES.keySet();
    }

    public static Set<String> getBreakingToolSlotTypes() {
        return TOOL_SLOT_TYPES.keySet();
    }

    public static Set<String> getDualHeavyWeaponToolSlotTypes() {
        return TOOL_SLOT_TYPES.keySet();
    }

    public static Set<String> getHeavyWeaponSlotTypes() {
        return TOOL_SLOT_TYPES.keySet();
    }

    public static Set<String> getLightWeaponSlotTypes() {
        return TOOL_SLOT_TYPES.keySet();
    }
    
    public static Set<String> getRangedSlotTypes() {
        //this probably always be the same as tools
        return TOOL_SLOT_TYPES.keySet();
    }

    public static Set<String> getShieldSlotTypes() {
        return TOOL_SLOT_TYPES.keySet();
    }

    public static Set<String> getSpellbookSlotTypes() {
        return IRONS_SLOT_TYPES.keySet();
    }
    
    public static Set<String> getStaffSlotTypes() {
        //this probably always be the same as tools
        return TOOL_SLOT_TYPES.keySet();
    }

    public static Set<String> getToolSlotTypes() {
        return TOOL_SLOT_TYPES.keySet();
    }

    public static Set<String> getWandSlotTypes() {
        return IRONS_SLOT_TYPES.keySet();
    }

    //stats
    public static Set<String> getArmorStatTypes() {
        return ARMOR_STAT_TYPES.keySet();
    }

    public static Set<String> getBattlestaffStatTypes() {
        return BATTLESTAFF_STAT_TYPES.keySet();
    }

    public static Set<String> getBreakingToolStatTypes() {
        return BREAKING_TOOL_STAT_TYPES.keySet();
    }

    public static Set<String> getDualHeavyWeaponToolStatTypes() {
        return DUAL_HEAVY_WEAPON_TOOL_STAT_TYPES.keySet();
    }

    public static Set<String> getHeavyWeaponStatTypes() {
        return HEAVY_WEAPON_STAT_TYPES.keySet();
    }

    public static Set<String> getLightWeaponStatTypes() {
        return LIGHT_WEAPON_STAT_TYPES.keySet();
    }
    
    public static Set<String> getRangedStatTypes() {
        return RANGED_STAT_TYPES.keySet();
    }

    public static Set<String> getShieldStatTypes() {
        return SHIELD_STAT_TYPES.keySet();
    }

    public static Set<String> getSpellbookStatTypes() {
        return SPELLBOOK_STAT_TYPES.keySet();
    }
    
    public static Set<String> getStaffStatTypes() {
        return STAFF_STAT_TYPES.keySet();
    }

    public static Set<String> getToolStatTypes() {
        return TOOL_STAT_TYPES.keySet();
    }

    public static Set<String> getWandStatTypes() {
        return WAND_STAT_TYPES.keySet();
    }
    
    public static boolean isSlotsLevellingEnabled(IToolContext context) {
        if (isArmor(context)) {
            return Config.armorSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isBattlestaff(context)) {
            return Config.battlestaffSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isBreakingTool(context)) {
            return Config.breakingToolSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isDualHeavyWeaponTool(context)) {
            return Config.dualHeavyWeaponToolSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isHeavyWeapon(context)) {
            return Config.heavyWeaponSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isLightWeapon(context)) {
            return Config.lightWeaponSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isRanged(context)) {
            return Config.rangedSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isShield(context)) {
            return Config.shieldSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isSpellbook(context)) {
            return Config.spellbookSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isStaff(context)) {
            return Config.staffSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isWand(context)) {
            return Config.wandSlotGainingMethod.get() != Config.GainingMethod.NONE;
        }
        //tools
        return Config.toolsSlotGainingMethod.get() != Config.GainingMethod.NONE;
    }
    
    public static boolean isStatsLevellingEnabled(IToolContext context) {
        if (isArmor(context)) {
            return Config.armorStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isBattlestaff(context)) {
            return Config.battlestaffStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isBreakingTool(context)) {
            return Config.breakingToolStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isDualHeavyWeaponTool(context)) {
            return Config.dualHeavyWeaponToolStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isHeavyWeapon(context)) {
            return Config.heavyWeaponStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isLightWeapon(context)) {
            return Config.lightWeaponStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isRanged(context)) {
            return Config.rangedStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isShield(context)) {
            return Config.shieldStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isSpellbook(context)) {
            return Config.spellbookStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isStaff(context)) {
            return Config.staffStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        if (isWand(context)) {
            return Config.wandStatGainingMethod.get() != Config.GainingMethod.NONE;
        }
        //tools
        return Config.toolsStatGainingMethod.get() != Config.GainingMethod.NONE;
    }
    
    public static boolean canPredictNextSlot(ToolStack tool) {
        if (isArmor(tool)) {
            return Config.armorSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isBattlestaff(tool)) {
            return Config.battlestaffSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isBreakingTool(tool)) {
            return Config.breakingToolSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isDualHeavyWeaponTool(tool)) {
            return Config.dualHeavyWeaponToolSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isHeavyWeapon(tool)) {
            return Config.heavyWeaponSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isLightWeapon(tool)) {
            return Config.lightWeaponSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isRanged(tool)) {
            return Config.rangedSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isShield(tool)) {
            return Config.shieldSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isSpellbook(tool)) {
            return Config.spellbookSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isStaff(tool)) {
            return Config.staffSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isWand(tool)) {
            return Config.wandSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        //tools
        return Config.toolsSlotGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
    }
    
    public static boolean canPredictNextStat(ToolStack tool) {
        if (isArmor(tool)) {
            return Config.armorStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isBattlestaff(tool)) {
            return Config.battlestaffStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isBreakingTool(tool)) {
            return Config.breakingToolStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isDualHeavyWeaponTool(tool)) {
            return Config.dualHeavyWeaponToolStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isHeavyWeapon(tool)) {
            return Config.heavyWeaponStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isLightWeapon(tool)) {
            return Config.lightWeaponStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isRanged(tool)) {
            return Config.rangedStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isShield(tool)) {
            return Config.shieldStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isSpellbook(tool)) {
            return Config.spellbookStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isStaff(tool)) {
            return Config.staffStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        if (isWand(tool)) {
            return Config.wandStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
        }
        //tools
        return Config.toolsStatGainingMethod.get() == Config.GainingMethod.PREDEFINED_ORDER;
    }
    
    public static String getSlot(IToolStackView tool, int level) {
        if (isArmor(tool)) {
            return switch (Config.armorSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getArmorSlotForLevel(level);
                case RANDOM -> getRandomArmorSlot();
            };
        }

        if (isBattlestaff(tool)) {
            return switch (Config.battlestaffSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getBattlestaffSlotForLevel(level);
                case RANDOM -> getRandomBattlestaffSlot();
            };
        }

        if (isBreakingTool(tool)) {
            return switch (Config.breakingToolSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getBreakingToolSlotForLevel(level);
                case RANDOM -> getRandomBreakingToolSlot();
            };
        }

        if (isDualHeavyWeaponTool(tool)) {
            return switch (Config.dualHeavyWeaponToolSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getDualHeavyWeaponToolSlotForLevel(level);
                case RANDOM -> getRandomDualHeavyWeaponToolSlot();
            };
        }

        if (isHeavyWeapon(tool)) {
            return switch (Config.heavyWeaponSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getHeavyWeaponSlotForLevel(level);
                case RANDOM -> getRandomHeavyWeaponSlot();
            };
        }

        if (isLightWeapon(tool)) {
            return switch (Config.lightWeaponSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getLightWeaponSlotForLevel(level);
                case RANDOM -> getRandomLightWeaponSlot();
            };
        }

        if (isRanged(tool)) {
            return switch (Config.rangedSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getRangedSlotForLevel(level);
                case RANDOM -> getRandomRangedSlot();
            };
        }

        if (isShield(tool)) {
            return switch (Config.shieldSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getShieldSlotForLevel(level);
                case RANDOM -> getRandomShieldSlot();
            };
        }

        if (isSpellbook(tool)) {
            return switch (Config.spellbookSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getSpellbookSlotForLevel(level);
                case RANDOM -> getRandomSpellbookSlot();
            };
        }

        if (isStaff(tool)) {
            return switch (Config.staffSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getStaffSlotForLevel(level);
                case RANDOM -> getRandomStaffSlot();
            };
        }

        if (isWand(tool)) {
            return switch (Config.wandSlotGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getWandSlotForLevel(level);
                case RANDOM -> getRandomWandSlot();
            };
        }
        //tools
        return switch (Config.toolsSlotGainingMethod.get()) {
            case NONE -> null;
            case PREDEFINED_ORDER -> getToolSlotForLevel(level);
            case RANDOM -> getRandomToolSlot();
        };
    }
    
    public static String getStat(IToolStackView tool, int level) {
        if (isArmor(tool)) {
            return switch (Config.armorStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getArmorStatForLevel(level);
                case RANDOM -> getRandomArmorStat();
            };
        }

        if (isBattlestaff(tool)) {
            return switch (Config.battlestaffStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getBattlestaffStatForLevel(level);
                case RANDOM -> getRandomBattlestaffStat();
            };
        }

        if (isBreakingTool(tool)) {
            return switch (Config.breakingToolStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getBreakingToolStatForLevel(level);
                case RANDOM -> getRandomBreakingToolStat();
            };
        }

        if (isDualHeavyWeaponTool(tool)) {
            return switch (Config.dualHeavyWeaponToolStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getDualHeavyWeaponToolStatForLevel(level);
                case RANDOM -> getRandomDualHeavyWeaponToolStat();
            };
        }

        if (isHeavyWeapon(tool)) {
            return switch (Config.heavyWeaponStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getHeavyWeaponStatForLevel(level);
                case RANDOM -> getRandomHeavyWeaponStat();
            };
        }

        if (isLightWeapon(tool)) {
            return switch (Config.lightWeaponStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getLightWeaponStatForLevel(level);
                case RANDOM -> getRandomLightWeaponStat();
            };
        }

        if (isRanged(tool)) {
            return switch (Config.rangedStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getRangedStatForLevel(level);
                case RANDOM -> getRandomRangedStat();
            };
        }

        if (isShield(tool)) {
            return switch (Config.shieldStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getShieldStatForLevel(level);
                case RANDOM -> getRandomShieldStat();
            };
        }

        if (isSpellbook(tool)) {
            return switch (Config.spellbookStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getSpellbookStatForLevel(level);
                case RANDOM -> getRandomSpellbookStat();
            };
        }

        if (isStaff(tool)) {
            return switch (Config.staffStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getStaffStatForLevel(level);
                case RANDOM -> getRandomStaffStat();
            };
        }

        if (isWand(tool)) {
            return switch (Config.wandStatGainingMethod.get()) {
                case NONE -> null;
                case PREDEFINED_ORDER -> getWandStatForLevel(level);
                case RANDOM -> getRandomWandStat();
            };
        }
        //tools
        return switch (Config.toolsStatGainingMethod.get()) {
            case NONE -> null;
            case PREDEFINED_ORDER -> getToolStatForLevel(level);
            case RANDOM -> getRandomToolStat();
        };
    }
    
    public static double getStatValue(IToolContext tool, String stat) {
        return getStatValue(tool, ALL_STAT_TYPES.get(stat));
    }
    
    public static double getStatValue(IToolContext tool, FloatToolStat stat) {
        if (isArmor(tool)) {
            return Config.getArmorStatValue(stat);
        }
        if (isBattlestaff(tool)) {
            return Config.getBattlestaffStatValue(stat);
        }
        if (isBreakingTool(tool)) {
            return Config.getBreakingToolStatValue(stat);
        }
        if (isDualHeavyWeaponTool(tool)) {
            return Config.getDualHeavyWeaponToolStatValue(stat);
        }
        if (isHeavyWeapon(tool)) {
            return Config.getHeavyWeaponStatValue(stat);
        }
        if (isLightWeapon(tool)) {
            return Config.getLightWeaponStatValue(stat);
        }
        if (isRanged(tool)){
            return Config.getRangedStatValue(stat);
        }
        if (isShield(tool)) {
            return Config.getShieldStatValue(stat);
        }
        if (isSpellbook(tool)) {
            return Config.getSpellbookStatValue(stat);
        }
        if (isStaff(tool)) {
            return Config.getStaffStatValue(stat);
        }
        if (isWand(tool)) {
            return Config.getWandStatValue(stat);
        }
        //tools
        return Config.getToolStatValue(stat);
    }
    
    public static List<SlotType> parseSlotsHistory(String historyString) {
        ArrayList<SlotType> result = new ArrayList<>();
        if (!historyString.isBlank()) {
            for (String slotString : historyString.split(";")) {
                if (slotString.equals(NONE)) {
                    continue;
                }
                SlotType slot = ALL_SLOT_TYPES.get(slotString);
                if (slot != null) {
                    result.add(slot);
                } else {
                    throw new UnsupportedOperationException("Unsupported slot type " + slotString);
                }
            }
        }
        return result;
    }
    
    public static List<FloatToolStat> parseStatsHistory(String historyString) {
        ArrayList<FloatToolStat> result = new ArrayList<>();
        if (!historyString.isBlank()) {
            for (String statString : historyString.split(";")) {
                if (statString.equals(NONE)) {
                    continue;
                }
                FloatToolStat stat = ALL_STAT_TYPES.get(statString);
                if (stat != null) {
                    result.add(stat);
                } else {
                    throw new UnsupportedOperationException("Unsupported stat type " + statString);
                }
            }
        }
        return result;
    }
    
    public static boolean canLevelUp(int level) {
        return Config.maxLevel.get() == 0 || Config.maxLevel.get() > level;
    }
    
    public static int getXpNeededForLevel(int level, boolean isBroadTool) {
        double base = Config.baseExperience.get();
        double multiplier = Config.requiredXpMultiplier.get();

        double experienceNeeded = base * Math.pow(multiplier, Math.max(1, level) - 1.0);

        if (isBroadTool) {
            experienceNeeded *= Config.broadToolRequiredXpMultiplier.get();
        }
        return (int) Math.min(experienceNeeded, Integer.MAX_VALUE);
    }
    
    public static void addExperience(IToolStackView tool, int amount) {
        if (tool == null) {
            return;
        }
        
        ModDataNBT data = tool.getPersistentData();
        int currentLevel = data.getInt(LEVEL_KEY);
        int currentExperience = data.getInt(EXPERIENCE_KEY) + amount;
        boolean isBroadTool = isBroadTool(tool);
        int experienceNeeded = getXpNeededForLevel(currentLevel + 1, isBroadTool);
        
        while (currentExperience >= experienceNeeded) {
            if (!canLevelUp(currentLevel)) {
                return;
            }
            data.putInt(LEVEL_KEY, ++currentLevel);
            currentExperience -= experienceNeeded;
            experienceNeeded = getXpNeededForLevel(currentLevel + 1, isBroadTool);
            
            String slotName = getSlot(tool, currentLevel);
            if (slotName != null) {
                appendHistory(SLOT_HISTORY_KEY, slotName, data);
            }
            String statName = getStat(tool, currentLevel);
            if (statName != null) {
                appendHistory(STAT_HISTORY_KEY, statName, data);
            }

            data.putInt(PENDING_LEVEL_UP_KEY, currentLevel);
        }
        data.putInt(EXPERIENCE_KEY, currentExperience);
    }

    public static void processPendingLevelUp(ServerPlayer player, ItemStack itemStack) {
        if (hasImprovable(itemStack)) {
            ToolStack tool = ToolStack.from(itemStack);
            ToolDataNBT data = tool.getPersistentData();
            if (data.contains(PENDING_LEVEL_UP_KEY)) {
                ToolStack toolCopy = tool.copy();
                toolCopy.getPersistentData().putInt(EXPERIENCE_KEY, 0);
                Messages.sendToPlayer(new LevelUpPacket(data.getInt(PENDING_LEVEL_UP_KEY),
                        toolCopy.createStack().getDisplayName()), player);

                data.remove(PENDING_LEVEL_UP_KEY);
                tool.rebuildStats();
            }
        }
    }

    public static int getThornsBonus(IToolStackView tool) {
        int thornsLevel = tool.getModifierLevel(ModifierIds.thorns);
        if (!Config.enableThornsXp.get() || thornsLevel == 0) {
            return 0;
        }
        return RANDOM.nextFloat() < (thornsLevel * 0.15f) ? 1 + RANDOM.nextInt(Config.bonusThornsXp.get() + 1) : 0;
    }

    public static boolean isArmor(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.ARMOR);
    }

    public static boolean isBattlestaff(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.BATTLESTAFF);
    }

    public static boolean isBreakingTool(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.BREAKING_TOOL);
    }

    public static boolean isDualHeavyWeaponTool(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.DUAL_HEAVY_WEAPON_TOOL);
    }

    public static boolean isHeavyWeapon(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.HEAVY_WEAPON);
    }

    public static boolean isLightWeapon(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.LIGHT_WEAPON);
    }

    public static boolean isRanged(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.RANGED);
    }

    public static boolean isShield(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.SHIELD);
    }

    public static boolean isSpellbook(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.SPELLBOOK);
    }

    public static boolean isStaff(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.STAFF);
    }

    public static boolean isWand(IToolContext tool) {
        return tool.hasTag(TinkersLevellingAddonTags.WAND);
    }

    public static boolean isBroadTool(IToolStackView tool) {
        return tool.getMaterials().size() > 3 || isStaff(tool);
    }
    
    public static TextColor getSlotColor(String slotName) {
        return ALL_SLOT_TYPES.get(slotName).getColor();
    }
    
    public static TextColor getStatColor(String statName) {
        return ALL_STAT_TYPES.get(statName).getColor();
    }

    //slots
    private static String getArmorSlotForLevel(int level) {
        List<String> armorSlotsOrder = Config.getArmorSlotsOrder();
        return armorSlotsOrder.get((level - 1) % armorSlotsOrder.size());
    }

    private static String getRandomArmorSlot() {
        List<String> armorSlotsRandomPool = Config.getArmorSlotsRandomPool();
        return armorSlotsRandomPool.get(RANDOM.nextInt(armorSlotsRandomPool.size()));
    }

    private static String getBattlestaffSlotForLevel(int level) {
        List<String> battlestaffSlotsOrder = Config.getBattlestaffSlotsOrder();
        return battlestaffSlotsOrder.get((level - 1) % battlestaffSlotsOrder.size());
    }

    private static String getRandomBattlestaffSlot() {
        List<String> battlestaffSlotsRandomPool = Config.getBattlestaffSlotsRandomPool();
        return battlestaffSlotsRandomPool.get(RANDOM.nextInt(battlestaffSlotsRandomPool.size()));
    }

    private static String getBreakingToolSlotForLevel(int level) {
        List<String> breakingToolSlotsOrder = Config.getBreakingToolSlotsOrder();
        return breakingToolSlotsOrder.get((level - 1) % breakingToolSlotsOrder.size());
    }

    private static String getRandomBreakingToolSlot() {
        List<String> breakingToolSlotsRandomPool = Config.getBreakingToolSlotsRandomPool();
        return breakingToolSlotsRandomPool.get(RANDOM.nextInt(breakingToolSlotsRandomPool.size()));
    }

    private static String getDualHeavyWeaponToolSlotForLevel(int level) {
        List<String> dualHeavyWeaponToolSlotsOrder = Config.getDualHeavyWeaponToolSlotsOrder();
        return dualHeavyWeaponToolSlotsOrder.get((level - 1) % dualHeavyWeaponToolSlotsOrder.size());
    }

    private static String getRandomDualHeavyWeaponToolSlot() {
        List<String> dualHeavyWeaponToolSlotsRandomPool = Config.getDualHeavyWeaponToolSlotsRandomPool();
        return dualHeavyWeaponToolSlotsRandomPool.get(RANDOM.nextInt(dualHeavyWeaponToolSlotsRandomPool.size()));
    }

    private static String getHeavyWeaponSlotForLevel(int level) {
        List<String> heavyWeaponSlotsOrder = Config.getHeavyWeaponSlotsOrder();
        return heavyWeaponSlotsOrder.get((level - 1) % heavyWeaponSlotsOrder.size());
    }

    private static String getRandomHeavyWeaponSlot() {
        List<String> heavyWeaponSlotsRandomPool = Config.getHeavyWeaponSlotsRandomPool();
        return heavyWeaponSlotsRandomPool.get(RANDOM.nextInt(heavyWeaponSlotsRandomPool.size()));
    }

    private static String getLightWeaponSlotForLevel(int level) {
        List<String> lightWeaponSlotsOrder = Config.getLightWeaponSlotsOrder();
        return lightWeaponSlotsOrder.get((level - 1) % lightWeaponSlotsOrder.size());
    }

    private static String getRandomLightWeaponSlot() {
        List<String> lightWeaponSlotsRandomPool = Config.getLightWeaponSlotsRandomPool();
        return lightWeaponSlotsRandomPool.get(RANDOM.nextInt(lightWeaponSlotsRandomPool.size()));
    }
    
    private static String getRangedSlotForLevel(int level) {
        List<String> rangedSlotsOrder = Config.getRangedSlotsOrder();
        return rangedSlotsOrder.get((level - 1) % rangedSlotsOrder.size());
    }
    
    private static String getRandomRangedSlot() {
        List<String> rangedSlotsRandomPool = Config.getRangedSlotsRandomPool();
        return rangedSlotsRandomPool.get(RANDOM.nextInt(rangedSlotsRandomPool.size()));
    }

    private static String getShieldSlotForLevel(int level) {
        List<String> shieldSlotsOrder = Config.getShieldSlotsOrder();
        return shieldSlotsOrder.get((level - 1) % shieldSlotsOrder.size());
    }

    private static String getRandomShieldSlot() {
        List<String> shieldSlotsRandomPool = Config.getShieldSlotsRandomPool();
        return shieldSlotsRandomPool.get(RANDOM.nextInt(shieldSlotsRandomPool.size()));
    }

    private static String getSpellbookSlotForLevel(int level) {
        List<String> spellbookSlotsOrder = Config.getSpellbookSlotsOrder();
        return spellbookSlotsOrder.get((level - 1) % spellbookSlotsOrder.size());
    }

    private static String getRandomSpellbookSlot() {
        List<String> spellbookSlotsRandomPool = Config.getSpellbookSlotsRandomPool();
        return spellbookSlotsRandomPool.get(RANDOM.nextInt(spellbookSlotsRandomPool.size()));
    }

    private static String getStaffSlotForLevel(int level) {
        List<String> staffSlotsOrder = Config.getStaffSlotsOrder();
        return staffSlotsOrder.get((level - 1) % staffSlotsOrder.size());
    }

    private static String getRandomStaffSlot() {
        List<String> staffSlotsRandomPool = Config.getStaffSlotsRandomPool();
        return staffSlotsRandomPool.get(RANDOM.nextInt(staffSlotsRandomPool.size()));
    }

    private static String getToolSlotForLevel(int level) {
        List<String> toolsSlotsOrder = Config.getToolsSlotsOrder();
        return toolsSlotsOrder.get((level - 1) % toolsSlotsOrder.size());
    }

    private static String getRandomToolSlot() {
        List<String> toolsSlotsRandomPool = Config.getToolsSlotsRandomPool();
        return toolsSlotsRandomPool.get(RANDOM.nextInt(toolsSlotsRandomPool.size()));
    }

    private static String getWandSlotForLevel(int level) {
        List<String> wandSlotsOrder = Config.getWandSlotsOrder();
        return wandSlotsOrder.get((level - 1) % wandSlotsOrder.size());
    }

    private static String getRandomWandSlot() {
        List<String> wandSlotsRandomPool = Config.getWandSlotsRandomPool();
        return wandSlotsRandomPool.get(RANDOM.nextInt(wandSlotsRandomPool.size()));
    }

    //stats
    private static String getArmorStatForLevel(int level) {
        List<String> armorStatsOrder = Config.getArmorStatsOrder();
        return armorStatsOrder.get((level - 1) % armorStatsOrder.size());
    }

    private static String getRandomArmorStat() {
        List<String> armorStatsRandomPool = Config.getArmorStatsRandomPool();
        return armorStatsRandomPool.get(RANDOM.nextInt(armorStatsRandomPool.size()));
    }

    private static String getBattlestaffStatForLevel(int level) {
        List<String> battlestaffStatsRotation = Config.getBattlestaffStatsOrder();
        return battlestaffStatsRotation.get((level - 1) % battlestaffStatsRotation.size());
    }

    private static String getRandomBattlestaffStat() {
        List<String> battlestaffStatsRandomPool = Config.getBattlestaffStatsRandomPool();
        return battlestaffStatsRandomPool.get(RANDOM.nextInt(battlestaffStatsRandomPool.size()));
    }

    private static String getBreakingToolStatForLevel(int level) {
        List<String> breakingToolStatsRotation = Config.getBreakingToolStatsOrder();
        return breakingToolStatsRotation.get((level - 1) % breakingToolStatsRotation.size());
    }

    private static String getRandomBreakingToolStat() {
        List<String> breakingToolStatsRandomPool = Config.getBreakingToolStatsRandomPool();
        return breakingToolStatsRandomPool.get(RANDOM.nextInt(breakingToolStatsRandomPool.size()));
    }

    private static String getDualHeavyWeaponToolStatForLevel(int level) {
        List<String> dualHeavyWeaponToolStatsRotation = Config.getDualHeavyWeaponToolStatsOrder();
        return dualHeavyWeaponToolStatsRotation.get((level - 1) % dualHeavyWeaponToolStatsRotation.size());
    }

    private static String getRandomDualHeavyWeaponToolStat() {
        List<String> dualHeavyWeaponToolStatsRandomPool = Config.getDualHeavyWeaponToolStatsRandomPool();
        return dualHeavyWeaponToolStatsRandomPool.get(RANDOM.nextInt(dualHeavyWeaponToolStatsRandomPool.size()));
    }

    private static String getHeavyWeaponStatForLevel(int level) {
        List<String> heavyWeaponStatsRotation = Config.getHeavyWeaponStatsOrder();
        return heavyWeaponStatsRotation.get((level - 1) % heavyWeaponStatsRotation.size());
    }

    private static String getRandomHeavyWeaponStat() {
        List<String> heavyWeaponStatsRandomPool = Config.getHeavyWeaponStatsRandomPool();
        return heavyWeaponStatsRandomPool.get(RANDOM.nextInt(heavyWeaponStatsRandomPool.size()));
    }

    private static String getLightWeaponStatForLevel(int level) {
        List<String> lightWeaponStatsRotation = Config.getLightWeaponStatsOrder();
        return lightWeaponStatsRotation.get((level - 1) % lightWeaponStatsRotation.size());
    }

    private static String getRandomLightWeaponStat() {
        List<String> lightWeaponStatsRandomPool = Config.getLightWeaponStatsRandomPool();
        return lightWeaponStatsRandomPool.get(RANDOM.nextInt(lightWeaponStatsRandomPool.size()));
    }
    
    private static String getRangedStatForLevel(int level) {
        List<String> rangedStatsRotation = Config.getRangedStatsOrder();
        return rangedStatsRotation.get((level - 1) % rangedStatsRotation.size());
    }
    
    private static String getRandomRangedStat() {
        List<String> rangedStatsRandomPool = Config.getRangedStatsRandomPool();
        return rangedStatsRandomPool.get(RANDOM.nextInt(rangedStatsRandomPool.size()));
    }

    private static String getShieldStatForLevel(int level) {
        List<String> shieldStatsOrder = Config.getShieldStatsOrder();
        return shieldStatsOrder.get((level - 1) % shieldStatsOrder.size());
    }

    private static String getRandomShieldStat() {
        List<String> shieldStatsRandomPool = Config.getShieldStatsRandomPool();
        return shieldStatsRandomPool.get(RANDOM.nextInt(shieldStatsRandomPool.size()));
    }

    private static String getSpellbookStatForLevel(int level) {
        List<String> spellbookStatsRotation = Config.getSpellbookStatsOrder();
        return spellbookStatsRotation.get((level - 1) % spellbookStatsRotation.size());
    }

    private static String getRandomSpellbookStat() {
        List<String> spellbookStatsRandomPool = Config.getSpellbookStatsRandomPool();
        return spellbookStatsRandomPool.get(RANDOM.nextInt(spellbookStatsRandomPool.size()));
    }

    private static String getStaffStatForLevel(int level) {
        List<String> staffStatsOrder = Config.getStaffStatsOrder();
        return staffStatsOrder.get((level - 1) % staffStatsOrder.size());
    }

    private static String getRandomStaffStat() {
        List<String> staffStatsRandomPool = Config.getStaffStatsRandomPool();
        return staffStatsRandomPool.get(RANDOM.nextInt(staffStatsRandomPool.size()));
    }

    private static String getToolStatForLevel(int level) {
        List<String> toolsStatsOrder = Config.getToolsStatsOrder();
        return toolsStatsOrder.get((level - 1) % toolsStatsOrder.size());
    }

    private static String getRandomToolStat() {
        List<String> toolsStatsRandomPool = Config.getToolsStatsRandomPool();
        return toolsStatsRandomPool.get(RANDOM.nextInt(toolsStatsRandomPool.size()));
    }

    private static String getWandStatForLevel(int level) {
        List<String> wandStatsRotation = Config.getWandStatsOrder();
        return wandStatsRotation.get((level - 1) % wandStatsRotation.size());
    }

    private static String getRandomWandStat() {
        List<String> wandStatsRandomPool = Config.getWandStatsRandomPool();
        return wandStatsRandomPool.get(RANDOM.nextInt(wandStatsRandomPool.size()));
    }
    
    private static void appendHistory(ResourceLocation historyKey, String value, ModDataNBT data) {
        String modifierHistory = data.getString(historyKey);
        modifierHistory = modifierHistory + value + ";";
        data.putString(historyKey, modifierHistory);
    }
    
    private ToolLevellingUtil() {
        //hide constructor
    }
}
