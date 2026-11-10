package pyre.tinkerslevellingaddon.config;

import com.electronwill.nightconfig.core.EnumGetMethod;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import pyre.tinkerslevellingaddon.setup.Sounds;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import com.snackpirate.constructscasting.materials.CCToolStats;

import java.util.List;

import static pyre.tinkerslevellingaddon.util.ToolLevellingUtil.*;

public class Config {

    private static final List<String> DEFAULT_ARMOR_SLOTS_ORDER = List.of(UPGRADE, DEFENSE, UPGRADE, ABILITY, DEFENSE);
    private static final List<String> DEFAULT_ARMOR_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, DEFENSE, DEFENSE, ABILITY);
    private static final List<String> DEFAULT_BATTLESTAFF_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, BOON);
    private static final List<String> DEFAULT_BATTLESTAFF_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, BOON, ABILITY);
    private static final List<String> DEFAULT_BREAKING_TOOL_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, UPGRADE);
    private static final List<String> DEFAULT_BREAKING_TOOL_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, UPGRADE, ABILITY);
    private static final List<String> DEFAULT_DUAL_HEAVY_WEAPON_TOOL_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, UPGRADE);
    private static final List<String> DEFAULT_DUAL_HEAVY_WEAPON_TOOL_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, UPGRADE, ABILITY);
    private static final List<String> DEFAULT_HEAVY_WEAPON_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, UPGRADE);
    private static final List<String> DEFAULT_HEAVY_WEAPON_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, UPGRADE, ABILITY);
    private static final List<String> DEFAULT_LIGHT_WEAPON_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, UPGRADE);
    private static final List<String> DEFAULT_LIGHT_WEAPON_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, UPGRADE, ABILITY);
    private static final List<String> DEFAULT_RANGED_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, UPGRADE);
    private static final List<String> DEFAULT_RANGED_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, UPGRADE, ABILITY);
    private static final List<String> DEFAULT_SHIELD_SLOTS_ORDER = List.of(UPGRADE, DEFENSE, UPGRADE, DEFENSE, ABILITY);
    private static final List<String> DEFAULT_SHIELD_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, DEFENSE, DEFENSE, ABILITY);
    private static final List<String> DEFAULT_SPELLBOOK_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, BOON);
    private static final List<String> DEFAULT_SPELLBOOK_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, BOON, ABILITY);
    private static final List<String> DEFAULT_STAFF_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, DEFENSE, ABILITY);
    private static final List<String> DEFAULT_STAFF_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, DEFENSE, ABILITY);
    private static final List<String> DEFAULT_TOOLS_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, UPGRADE);
    private static final List<String> DEFAULT_TOOLS_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, UPGRADE, ABILITY);
    private static final List<String> DEFAULT_WAND_SLOTS_ORDER = List.of(UPGRADE, UPGRADE, UPGRADE, ABILITY, BOON);
    private static final List<String> DEFAULT_WAND_SLOTS_RANDOM_POOL = List.of(UPGRADE, UPGRADE, UPGRADE, BOON, ABILITY);

    private static final List<String> DEFAULT_ARMOR_STATS_ORDER = List.of(DURABILITY, ARMOR, ARMOR_TOUGHNESS, KNOCKBACK_RESISTANCE);
    private static final List<String> DEFAULT_ARMOR_STATS_RANDOM_POOL = List.of(DURABILITY, ARMOR, ARMOR_TOUGHNESS, KNOCKBACK_RESISTANCE);
    private static final List<String> DEFAULT_BATTLESTAFF_STATS_ORDER = List.of(DURABILITY, ATTACK_DAMAGE, ATTACK_SPEED, MAX_MANA, SPELL_POWER);
    private static final List<String> DEFAULT_BATTLESTAFF_STATS_RANDOM_POOL = List.of(DURABILITY, ATTACK_DAMAGE, ATTACK_SPEED, MAX_MANA, SPELL_POWER);
    private static final List<String> DEFAULT_BREAKING_TOOL_STATS_ORDER = List.of(DURABILITY, MINING_SPEED);
    private static final List<String> DEFAULT_BREAKING_TOOL_STATS_RANDOM_POOL = List.of(DURABILITY, MINING_SPEED, MINING_SPEED);
    private static final List<String> DEFAULT_DUAL_HEAVY_WEAPON_TOOL_STATS_ORDER = List.of(DURABILITY, ATTACK_DAMAGE, MINING_SPEED);
    private static final List<String> DEFAULT_DUAL_HEAVY_WEAPON_TOOL_STATS_RANDOM_POOL = List.of(DURABILITY, ATTACK_DAMAGE, MINING_SPEED);
    private static final List<String> DEFAULT_HEAVY_WEAPON_STATS_ORDER = List.of(DURABILITY, ATTACK_DAMAGE, DURABILITY, ATTACK_DAMAGE, ATTACK_SPEED);
    private static final List<String> DEFAULT_HEAVY_WEAPON_STATS_RANDOM_POOL = List.of(DURABILITY, DURABILITY, ATTACK_DAMAGE, ATTACK_DAMAGE, ATTACK_SPEED);
    private static final List<String> DEFAULT_LIGHT_WEAPON_STATS_ORDER = List.of(DURABILITY, ATTACK_SPEED, ATTACK_DAMAGE);
    private static final List<String> DEFAULT_LIGHT_WEAPON_STATS_RANDOM_POOL = List.of(DURABILITY, ATTACK_SPEED, ATTACK_DAMAGE);
    private static final List<String> DEFAULT_RANGED_STATS_ORDER = List.of(DURABILITY, DRAW_SPEED, VELOCITY, ACCURACY, PROJECTILE_DAMAGE);
    private static final List<String> DEFAULT_RANGED_STATS_RANDOM_POOL = List.of(DURABILITY, DRAW_SPEED, VELOCITY, ACCURACY, PROJECTILE_DAMAGE);
    private static final List<String> DEFAULT_SHIELD_STATS_ORDER = List.of(DURABILITY, BLOCK_AMOUNT, BLOCK_ANGLE, ARMOR_TOUGHNESS, KNOCKBACK_RESISTANCE);
    private static final List<String> DEFAULT_SHIELD_STATS_RANDOM_POOL = List.of(DURABILITY, BLOCK_AMOUNT, BLOCK_ANGLE, ARMOR_TOUGHNESS, KNOCKBACK_RESISTANCE);
    private static final List<String> DEFAULT_SPELLBOOK_STATS_ORDER = List.of(MAX_MANA, SPELL_POWER, SPELL_SLOTS, MAX_MANA, COOLDOWN_REDUCTION);
    private static final List<String> DEFAULT_SPELLBOOK_STATS_RANDOM_POOL = List.of(MAX_MANA, MAX_MANA, SPELL_POWER, SPELL_SLOTS, COOLDOWN_REDUCTION);
    private static final List<String> DEFAULT_STAFF_STATS_ORDER = List.of(DURABILITY, DRAW_SPEED, VELOCITY, ACCURACY, PROJECTILE_DAMAGE, ARMOR);
    private static final List<String> DEFAULT_STAFF_STATS_RANDOM_POOL = List.of(DURABILITY, DRAW_SPEED, VELOCITY, ACCURACY, PROJECTILE_DAMAGE, ARMOR);
    private static final List<String> DEFAULT_TOOLS_STATS_ORDER = List.of(DURABILITY, ATTACK_DAMAGE, ATTACK_SPEED, MINING_SPEED);
    private static final List<String> DEFAULT_TOOLS_STATS_RANDOM_POOL = List.of(DURABILITY, ATTACK_DAMAGE, ATTACK_SPEED, MINING_SPEED);
    private static final List<String> DEFAULT_WAND_STATS_ORDER = List.of(MAX_MANA, SPELL_POWER, CASTING_SPEED, MAX_MANA, COOLDOWN_REDUCTION);
    private static final List<String> DEFAULT_WAND_STATS_RANDOM_POOL = List.of(MAX_MANA, MAX_MANA, SPELL_POWER, CASTING_SPEED, COOLDOWN_REDUCTION);

    public static final ForgeConfigSpec SERVER_CONFIG;
    public static final ForgeConfigSpec CLIENT_CONFIG;

    static {
        ForgeConfigSpec.Builder serverConfigBuilder = new ForgeConfigSpec.Builder();
        generalConfig(serverConfigBuilder);
        toolLevellingConfig(serverConfigBuilder);
        SERVER_CONFIG = serverConfigBuilder.build();
        ForgeConfigSpec.Builder clientConfigBuilder = new ForgeConfigSpec.Builder();
        clientConfig(clientConfigBuilder);
        CLIENT_CONFIG = clientConfigBuilder.build();
    }

    //SERVER
    //General
    public static ForgeConfigSpec.EnumValue<GainingMethod> armorSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> armorStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> battlestaffSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> battlestaffStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> breakingToolSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> breakingToolStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> dualHeavyWeaponToolSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> dualHeavyWeaponToolStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> heavyWeaponSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> heavyWeaponStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> lightWeaponSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> lightWeaponStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> rangedSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> rangedStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> shieldSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> shieldStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> spellbookSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> spellbookStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> staffSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> staffStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> toolsSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> toolsStatGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> wandSlotGainingMethod;
    public static ForgeConfigSpec.EnumValue<GainingMethod> wandStatGainingMethod;
    public static ForgeConfigSpec.IntValue maxLevel;
    public static ForgeConfigSpec.IntValue baseExperience;
    public static ForgeConfigSpec.DoubleValue requiredXpMultiplier;
    public static ForgeConfigSpec.DoubleValue broadToolRequiredXpMultiplier;

    //general.slots
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> armorSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> armorSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> battlestaffSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> battlestaffSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> breakingToolSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> breakingToolSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> dualHeavyWeaponToolSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> dualHeavyWeaponToolSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> heavyWeaponSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> heavyWeaponSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> lightWeaponSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> lightWeaponSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> rangedSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> rangedSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> shieldSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> shieldSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> spellbookSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> spellbookSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> staffSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> staffSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> toolsSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> toolsSlotTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> wandSlotTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> wandSlotTypeOrder;

    //general.stats
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> armorStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> armorStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> battlestaffStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> battlestaffStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> breakingToolStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> breakingToolStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> dualHeavyWeaponToolStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> dualHeavyWeaponToolStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> heavyWeaponStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> heavyWeaponStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> lightWeaponStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> lightWeaponStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> rangedStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> rangedStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> shieldStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> shieldStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> spellbookStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> spellbookStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> staffStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> staffStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> toolsStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> toolsStatTypeOrder;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> wandStatTypeRandomPool;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> wandStatTypeOrder;

    //general.stats.armorValues
    public static ForgeConfigSpec.DoubleValue armorArmorValue;
    public static ForgeConfigSpec.DoubleValue armorArmorToughnessValue;
    public static ForgeConfigSpec.IntValue armorDurabilityValue;
    public static ForgeConfigSpec.DoubleValue armorKnockbackResistanceValue;

    //general.stats.battlestaffValues
    public static ForgeConfigSpec.DoubleValue battlestaffAttackDamageValue;
    public static ForgeConfigSpec.DoubleValue battlestaffAttackSpeedValue;
    public static ForgeConfigSpec.IntValue battlestaffDurabilityValue;
    public static ForgeConfigSpec.DoubleValue battlestaffSpellPowerValue;
    public static ForgeConfigSpec.IntValue battlestaffManaValue;

    //general.stats.breakingTool
    public static ForgeConfigSpec.IntValue breakingToolDurabilityValue;
    public static ForgeConfigSpec.DoubleValue breakingToolMiningSpeedValue;

    //general.stats.dualHeavyWeaponTool
    public static ForgeConfigSpec.DoubleValue dualHeavyWeaponToolAttackDamageValue;
    public static ForgeConfigSpec.IntValue dualHeavyWeaponToolDurabilityValue;
    public static ForgeConfigSpec.DoubleValue dualHeavyWeaponToolMiningSpeedValue;

    //general.stats.heavyWeapon
    public static ForgeConfigSpec.DoubleValue heavyWeaponAttackDamageValue;
    public static ForgeConfigSpec.DoubleValue heavyWeaponAttackSpeedValue;
    public static ForgeConfigSpec.IntValue heavyWeaponDurabilityValue;

    //general.stats.lightWeapon
    public static ForgeConfigSpec.DoubleValue lightWeaponAttackDamageValue;
    public static ForgeConfigSpec.DoubleValue lightWeaponAttackSpeedValue;
    public static ForgeConfigSpec.IntValue lightWeaponDurabilityValue;

    //general.stats.rangedValues
    public static ForgeConfigSpec.DoubleValue rangedAccuracyValue;
    public static ForgeConfigSpec.DoubleValue rangedDrawSpeedValue;
    public static ForgeConfigSpec.IntValue rangedDurabilityValue;
    public static ForgeConfigSpec.DoubleValue rangedProjectileDamageValue;
    public static ForgeConfigSpec.DoubleValue rangedVelocityValue;

    //general.stats.shieldValues
    public static ForgeConfigSpec.DoubleValue shieldArmorToughnessValue;
    public static ForgeConfigSpec.DoubleValue shieldBlockAmountValue;
    public static ForgeConfigSpec.IntValue shieldBlockAngleValue;
    public static ForgeConfigSpec.IntValue shieldDurabilityValue;
    public static ForgeConfigSpec.DoubleValue shieldKnockbackResistanceValue;

    //general.stats.spellbook
    public static ForgeConfigSpec.DoubleValue spellbookSpellPowerValue;
    public static ForgeConfigSpec.IntValue spellbookManaValue;
    public static ForgeConfigSpec.IntValue spellbookSpellSlotsValue;
    public static ForgeConfigSpec.DoubleValue spellbookCooldownReductionValue;

    //general.stats.staffValues
    public static ForgeConfigSpec.DoubleValue staffAccuracyValue;
    public static ForgeConfigSpec.DoubleValue staffArmorValue;
    public static ForgeConfigSpec.DoubleValue staffDrawSpeedValue;
    public static ForgeConfigSpec.IntValue staffDurabilityValue;
    public static ForgeConfigSpec.DoubleValue staffProjectileDamageValue;
    public static ForgeConfigSpec.DoubleValue staffVelocityValue;

    //general.stats.toolValues
    public static ForgeConfigSpec.DoubleValue toolAttackDamageValue;
    public static ForgeConfigSpec.DoubleValue toolAttackSpeedValue;
    public static ForgeConfigSpec.IntValue toolDurabilityValue;
    public static ForgeConfigSpec.DoubleValue toolMiningSpeedValue;

    //general.stats.wand
    public static ForgeConfigSpec.DoubleValue wandSpellPowerValue;
    public static ForgeConfigSpec.IntValue wandManaValue;
    public static ForgeConfigSpec.DoubleValue wandCooldownReductionValue;
    public static ForgeConfigSpec.DoubleValue wandCastingSpeedValue;

    //toolLevelling
    public static ForgeConfigSpec.BooleanValue damageBlocked;
    public static ForgeConfigSpec.BooleanValue damageDealt;
    public static ForgeConfigSpec.BooleanValue damageTaken;
    public static ForgeConfigSpec.BooleanValue enablePvp;
    public static ForgeConfigSpec.IntValue flyingTime;

    //toolLevelling.actions
    public static ForgeConfigSpec.BooleanValue enableAttackingXp;
    public static ForgeConfigSpec.BooleanValue enableBlockingDamageXp;
    public static ForgeConfigSpec.BooleanValue enableBonkingXp;
    public static ForgeConfigSpec.BooleanValue enableBrushingXp;
    public static ForgeConfigSpec.BooleanValue enableBucketingXp;
    public static ForgeConfigSpec.BooleanValue enableFirestarterXp;
    public static ForgeConfigSpec.BooleanValue enableFishingXp;
    public static ForgeConfigSpec.BooleanValue enableFlamewakeXp;
    public static ForgeConfigSpec.BooleanValue enableFlingingXp;
    public static ForgeConfigSpec.BooleanValue enableFlyingXp;
    public static ForgeConfigSpec.BooleanValue enableFrostWalkerXp;
    public static ForgeConfigSpec.BooleanValue enableGlowingXp;
    public static ForgeConfigSpec.BooleanValue enableGrapplingXp;
    public static ForgeConfigSpec.BooleanValue enableHarvestingXp;
    public static ForgeConfigSpec.BooleanValue enableMeltingXp;
    public static ForgeConfigSpec.BooleanValue enableMiningXp;
    public static ForgeConfigSpec.BooleanValue enablePathMakerXp;
    public static ForgeConfigSpec.BooleanValue enablePathMakingXp;
    public static ForgeConfigSpec.BooleanValue enablePlowingXp;
    public static ForgeConfigSpec.BooleanValue enableScrappingXp;
    public static ForgeConfigSpec.BooleanValue enableShearingXp;
    public static ForgeConfigSpec.BooleanValue enableShootingXp;
    public static ForgeConfigSpec.BooleanValue enableSlimeballXp;
    public static ForgeConfigSpec.BooleanValue enableSlurpingXp;
    public static ForgeConfigSpec.BooleanValue enableSnowdriftXp;
    public static ForgeConfigSpec.BooleanValue enableSpillingXp;
    public static ForgeConfigSpec.BooleanValue enableSpittingXp;
    public static ForgeConfigSpec.BooleanValue enableSplashingXp;
    public static ForgeConfigSpec.BooleanValue enableSpringingXp;
    public static ForgeConfigSpec.BooleanValue enableStrippingXp;
    public static ForgeConfigSpec.BooleanValue enableTakingDamageXp;
    public static ForgeConfigSpec.BooleanValue enableThornsXp;
    public static ForgeConfigSpec.BooleanValue enableTillingXp;
    public static ForgeConfigSpec.BooleanValue enableWarpingXp;
    public static ForgeConfigSpec.BooleanValue enableWaxingOffXp;

    //toolLevelling.bonuses
    public static ForgeConfigSpec.IntValue bonusAttackingXp;
    public static ForgeConfigSpec.IntValue bonusBlockingDamageXp;
    public static ForgeConfigSpec.IntValue bonusBonkingXp;
    public static ForgeConfigSpec.IntValue bonusBrushingXp;
    public static ForgeConfigSpec.IntValue bonusBucketingXp;
    public static ForgeConfigSpec.IntValue bonusFirestarterXp;
    public static ForgeConfigSpec.IntValue bonusFishingXp;
    public static ForgeConfigSpec.IntValue bonusFlamewakeXp;
    public static ForgeConfigSpec.IntValue bonusFlingingXp;
    public static ForgeConfigSpec.IntValue bonusFlyingXp;
    public static ForgeConfigSpec.IntValue bonusFrostWalkerXp;
    public static ForgeConfigSpec.IntValue bonusGlowingXp;
    public static ForgeConfigSpec.IntValue bonusGrapplingXp;
    public static ForgeConfigSpec.IntValue bonusHarvestingXp;
    public static ForgeConfigSpec.IntValue bonusMeltingXp;
    public static ForgeConfigSpec.IntValue bonusMiningXp;
    public static ForgeConfigSpec.IntValue bonusPathMakerXp;
    public static ForgeConfigSpec.IntValue bonusPathMakingXp;
    public static ForgeConfigSpec.IntValue bonusPlowingXp;
    public static ForgeConfigSpec.IntValue bonusScrappingXp;
    public static ForgeConfigSpec.IntValue bonusShearingXp;
    public static ForgeConfigSpec.IntValue bonusShootingXp;
    public static ForgeConfigSpec.IntValue bonusSlimeballXp;
    public static ForgeConfigSpec.IntValue bonusSlurpingXp;
    public static ForgeConfigSpec.IntValue bonusSnowdriftXp;
    public static ForgeConfigSpec.IntValue bonusSpillingXp;
    public static ForgeConfigSpec.IntValue bonusSpittingXp;
    public static ForgeConfigSpec.IntValue bonusSplashingXp;
    public static ForgeConfigSpec.IntValue bonusSpringingXp;
    public static ForgeConfigSpec.IntValue bonusStrippingXp;
    public static ForgeConfigSpec.IntValue bonusTakingDamageXp;
    public static ForgeConfigSpec.IntValue bonusThornsXp;
    public static ForgeConfigSpec.IntValue bonusTillingXp;
    public static ForgeConfigSpec.IntValue bonusWarpingXp;
    public static ForgeConfigSpec.IntValue bonusWaxingOffXp;

    //CLIENT
    public static ForgeConfigSpec.BooleanValue enableLevelUpMessage;
    public static ForgeConfigSpec.BooleanValue squashLevelPluses;
    public static ForgeConfigSpec.EnumValue<LevelUpSound> levelUpSound;

    private static void generalConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("General addon settings").push("general");

        armorSlotGainingMethod = builder.comment("Method of gaining modifier slots for armor.")
                .translation("config.tinkerslevellingaddon.general.armor_slot_gaining_method")
                .defineEnum("armorSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        battlestaffSlotGainingMethod = builder.comment("Method of gaining modifier slots for battlestaffs.")
                .translation("config.tinkerslevellingaddon.general.battlestaff_slot_gaining_method")
                .defineEnum("battlestaffSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        breakingToolSlotGainingMethod = builder.comment("Method of gaining modifier slots for mining tools.")
                .translation("config.tinkerslevellingaddon.general.breaking_tool_slot_gaining_method") // To implement
                .defineEnum("breakingToolSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        dualHeavyWeaponToolSlotGainingMethod = builder.comment("Method of gaining modifier slots for tools useable as heavy weapons and for breaking blocks.")
                .translation("config.tinkerslevellingaddon.general.dual_heavy_weapon_tool_slot_gaining_method") // To implement
                .defineEnum("dualHeavyWeaponToolSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        heavyWeaponSlotGainingMethod = builder.comment("Method of gaining modifier slots for heavy weapons.")
                .translation("config.tinkerslevellingaddon.general.heavy_weapon_slot_gaining_method") // To implement
                .defineEnum("heavyWeaponSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        lightWeaponSlotGainingMethod = builder.comment("Method of gaining modifier slots for light weapons.")
                .translation("config.tinkerslevellingaddon.general.light_weapon_slot_gaining_method") // To implement
                .defineEnum("lightWeaponSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        rangedSlotGainingMethod = builder.comment("Method of gaining modifier slots for ranged weapons.")
                .translation("config.tinkerslevellingaddon.general.ranged_slot_gaining_method")
                .defineEnum("rangedSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        shieldSlotGainingMethod = builder.comment("Method of gaining modifier slots for shields.")
                .translation("config.tinkerslevellingaddon.general.shield_slot_gaining_method")
                .defineEnum("shieldSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        spellbookSlotGainingMethod = builder.comment("Method of gaining modifier slots for spellbooks.")
                .translation("config.tinkerslevellingaddon.general.spellbook_slot_gaining_method") // To implement
                .defineEnum("spellbookSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        staffSlotGainingMethod = builder.comment("Method of gaining modifier slots for staffs.")
                .translation("config.tinkerslevellingaddon.general.staff_slot_gaining_method")
                .defineEnum("staffSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        toolsSlotGainingMethod = builder.comment("Method of gaining modifier slots for tools.")
                .translation("config.tinkerslevellingaddon.general.tools_slot_gaining_method")
                .defineEnum("toolsSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        wandSlotGainingMethod = builder.comment("Method of gaining modifier slots for wands.")
                .translation("config.tinkerslevellingaddon.general.wand_slot_gaining_method") // To implement
                .defineEnum("wandSlotGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        slotsConfig(builder);

        armorStatGainingMethod = builder.comment("Method of gaining stats for armor.")
                .translation("config.tinkerslevellingaddon.general.armor_stat_gaining_method")
                .defineEnum("armorStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        battlestaffStatGainingMethod = builder.comment("Method of gaining modifier stats for battlestaffs.")
                .translation("config.tinkerslevellingaddon.general.battlestaff_stat_gaining_method") // To implement
                .defineEnum("battlestaffStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        breakingToolStatGainingMethod = builder.comment("Method of gaining modifier stats for mining tools.")
                .translation("config.tinkerslevellingaddon.general.breaking_tool_stat_gaining_method") // To implement
                .defineEnum("breakingToolStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        dualHeavyWeaponToolStatGainingMethod = builder.comment("Method of gaining modifier stats for tools useable as heavy weapons and for breaking blocks.")
                .translation("config.tinkerslevellingaddon.general.dual_heavy_weapon_tool_stat_gaining_method") // To implement
                .defineEnum("dualHeavyWeaponToolStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        heavyWeaponStatGainingMethod = builder.comment("Method of gaining modifier stats for heavy weapons.")
                .translation("config.tinkerslevellingaddon.general.heavy_weapon_stat_gaining_method") // To implement
                .defineEnum("heavyWeaponStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        lightWeaponStatGainingMethod = builder.comment("Method of gaining modifier stats for light weapons.")
                .translation("config.tinkerslevellingaddon.general.light_weapon_stat_gaining_method") // To implement
                .defineEnum("lightWeaponStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        rangedStatGainingMethod = builder.comment("Method of gaining stats for tools.")
                .translation("config.tinkerslevellingaddon.general.ranged_stat_gaining_method")
                .defineEnum("rangedStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        shieldStatGainingMethod = builder.comment("Method of gaining stats for shields.")
                .translation("config.tinkerslevellingaddon.general.shield_stat_gaining_method")
                .defineEnum("shieldStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        spellbookStatGainingMethod = builder.comment("Method of gaining modifier stats for spellbooks.")
                .translation("config.tinkerslevellingaddon.general.spellbook_stat_gaining_method") // To implement
                .defineEnum("spellbookStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        staffStatGainingMethod = builder.comment("Method of gaining stats for staffs.")
                .translation("config.tinkerslevellingaddon.general.staff_stat_gaining_method")
                .defineEnum("staffStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        toolsStatGainingMethod = builder.comment("Method of gaining stats for tools.")
                .translation("config.tinkerslevellingaddon.general.tools_stat_gaining_method")
                .defineEnum("toolsStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        wandStatGainingMethod = builder.comment("Method of gaining modifier stats for wands.")
                .translation("config.tinkerslevellingaddon.general.wand_stat_gaining_method") // To implement
                .defineEnum("wandStatGainingMethod", GainingMethod.PREDEFINED_ORDER, EnumGetMethod.NAME_IGNORECASE, GainingMethod.values());

        statsConfig(builder);

        maxLevel = builder.comment("Maximum tool level that could be achieved. If set to 0 there is no upper limit.")
                .translation("config.tinkerslevellingaddon.general.max_level")
                .defineInRange("maxLevel", 25, 0, Integer.MAX_VALUE);

        baseExperience = builder.comment("Base amount of experience required to reach next level.")
                .translation("config.tinkerslevellingaddon.general.base_experience")
                .defineInRange("baseExperience", 200, 1, Integer.MAX_VALUE);

        requiredXpMultiplier = builder.comment("How much the amount of experience required to reach next level will be multiplied per level.")
                .translation("config.tinkerslevellingaddon.general.required_xp_multiplier")
                .defineInRange("requiredXpMultiplier", 1.2D, 1D, 10D);

        broadToolRequiredXpMultiplier = builder.comment("Additional multiplier for broad tools for experience required to level up.")
                .translation("config.tinkerslevellingaddon.general.broad_tool_required_xp_multiplier")
                .defineInRange("broadToolRequiredXpMultiplier", 3D, 1D, 10D);

        builder.pop();
    }

    private static void slotsConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Modifier slots settings").push("slots");

        armorSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up armor. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_ARMOR_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getArmorSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.armor_slot_type_order")
                .defineList("armorSlotTypeOrder", DEFAULT_ARMOR_SLOTS_ORDER, t -> getArmorSlotTypes().contains(t));

        armorSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up armor.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_ARMOR_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getArmorSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.armor_slot_type_random_pool")
                .defineList("armorSlotTypeRandomPool", DEFAULT_ARMOR_SLOTS_RANDOM_POOL, t -> getArmorSlotTypes().contains(t));

        battlestaffSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up battlestaffs. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_BATTLESTAFF_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getBattlestaffSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.battlestaff_slot_type_order")
                .defineList("battlestaffSlotTypeOrder", DEFAULT_BATTLESTAFF_SLOTS_ORDER, t -> getBattlestaffSlotTypes().contains(t));

        battlestaffSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up battlestaffs.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_BATTLESTAFF_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getBattlestaffSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.battlestaff_slot_type_random_pool")
                .defineList("battlestaffSlotTypeRandomPool", DEFAULT_BATTLESTAFF_SLOTS_RANDOM_POOL, t -> getBattlestaffSlotTypes().contains(t));

        breakingToolSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up mining tools. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_BREAKING_TOOL_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getBreakingToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.breaking_tool_slot_type_order")
                .defineList("breakingToolSlotTypeOrder", DEFAULT_BREAKING_TOOL_SLOTS_ORDER, t -> getBreakingToolSlotTypes().contains(t));

        breakingToolSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up mining tools.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_BREAKING_TOOL_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getBreakingToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.breaking_tool_slot_type_random_pool")
                .defineList("breakingToolSlotTypeRandomPool", DEFAULT_BREAKING_TOOL_SLOTS_RANDOM_POOL, t -> getBreakingToolSlotTypes().contains(t));

        dualHeavyWeaponToolSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up tools useable as heavy weapons and for breaking blocks. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_DUAL_HEAVY_WEAPON_TOOL_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getDualHeavyWeaponToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.dual_heavy_weapon_tool_slot_type_order")
                .defineList("dualHeavyWeaponToolSlotTypeOrder", DEFAULT_DUAL_HEAVY_WEAPON_TOOL_SLOTS_ORDER, t -> getDualHeavyWeaponToolSlotTypes().contains(t));

        dualHeavyWeaponToolSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up tools useable as heavy weapons and for breaking blocks.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_DUAL_HEAVY_WEAPON_TOOL_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getDualHeavyWeaponToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.dual_heavy_weapon_tool_slot_type_random_pool")
                .defineList("dualHeavyWeaponToolSlotTypeRandomPool", DEFAULT_DUAL_HEAVY_WEAPON_TOOL_SLOTS_RANDOM_POOL, t -> getDualHeavyWeaponToolSlotTypes().contains(t));

        heavyWeaponSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up heavy weapons. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_HEAVY_WEAPON_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getHeavyWeaponSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.heavy_weapon_slot_type_order")
                .defineList("heavyWeaponSlotTypeOrder", DEFAULT_HEAVY_WEAPON_SLOTS_ORDER, t -> getHeavyWeaponSlotTypes().contains(t));

        heavyWeaponSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up heavy weapons.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_HEAVY_WEAPON_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getHeavyWeaponSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.heavy_weapon_slot_type_random_pool")
                .defineList("heavyWeaponSlotTypeRandomPool", DEFAULT_HEAVY_WEAPON_SLOTS_RANDOM_POOL, t -> getHeavyWeaponSlotTypes().contains(t));

        lightWeaponSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up light weapons. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_LIGHT_WEAPON_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getLightWeaponSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.light_weapon_slot_type_order")
                .defineList("lightWeaponSlotTypeOrder", DEFAULT_LIGHT_WEAPON_SLOTS_ORDER, t -> getLightWeaponSlotTypes().contains(t));

        lightWeaponSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up light weapons.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_LIGHT_WEAPON_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getLightWeaponSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.light_weapon_slot_type_random_pool")
                .defineList("lightWeaponSlotTypeRandomPool", DEFAULT_LIGHT_WEAPON_SLOTS_RANDOM_POOL, t -> getLightWeaponSlotTypes().contains(t));

        rangedSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up ranged weapons. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_RANGED_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.ranged_slot_type_order")
                .defineList("rangedSlotTypeOrder", DEFAULT_RANGED_SLOTS_ORDER, t -> getRangedSlotTypes().contains(t));

        rangedSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up ranged weapons.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_RANGED_SLOTS_RANDOM_POOL) + "). 80% chance for upgrade and 20% chance for ability.",
                        "Allowed values: " + String.join(", ", getToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.ranged_slot_type_random_pool")
                .defineList("rangedSlotTypeRandomPool", DEFAULT_RANGED_SLOTS_RANDOM_POOL, t -> getRangedSlotTypes().contains(t));

        shieldSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up shields. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_SHIELD_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getShieldSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.shield_slot_type_order")
                .defineList("shieldSlotTypeOrder", DEFAULT_SHIELD_SLOTS_ORDER, t -> getShieldSlotTypes().contains(t));

        shieldSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up shields.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_SHIELD_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getShieldSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.shield_slot_type_random_pool")
                .defineList("shieldSlotTypeRandomPool", DEFAULT_SHIELD_SLOTS_RANDOM_POOL, t -> getShieldSlotTypes().contains(t));

        spellbookSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up spellbooks. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_SPELLBOOK_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getSpellbookSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.spellbook_slot_type_order")
                .defineList("spellbookSlotTypeOrder", DEFAULT_SPELLBOOK_SLOTS_ORDER, t -> getSpellbookSlotTypes().contains(t));

        spellbookSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up spellbooks.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_SPELLBOOK_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getSpellbookSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.spellbook_slot_type_random_pool")
                .defineList("spellbookSlotTypeRandomPool", DEFAULT_SPELLBOOK_SLOTS_RANDOM_POOL, t -> getSpellbookSlotTypes().contains(t));

        staffSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up staffs. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_STAFF_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getStaffSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.staff_slot_type_order")
                .defineList("staffSlotTypeOrder", DEFAULT_STAFF_SLOTS_ORDER, t -> getStaffSlotTypes().contains(t));

        staffSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up staffs.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_STAFF_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getArmorSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.staff_slot_type_random_pool")
                .defineList("staffSlotTypeRandomPool", DEFAULT_STAFF_SLOTS_RANDOM_POOL, t -> getStaffSlotTypes().contains(t));

        toolsSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up tools. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_TOOLS_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.tools_slot_type_order")
                .defineList("toolsSlotTypeOrder", DEFAULT_TOOLS_SLOTS_ORDER, t -> getToolSlotTypes().contains(t));

        toolsSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up tools.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_TOOLS_SLOTS_RANDOM_POOL) + "). 80% chance for upgrade and 20% chance for ability.",
                        "Allowed values: " + String.join(", ", getToolSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.tools_slot_type_random_pool")
                .defineList("toolsSlotTypeRandomPool", DEFAULT_TOOLS_SLOTS_RANDOM_POOL, t -> getToolSlotTypes().contains(t));

        wandSlotTypeOrder = builder.comment("List of modifier slot types (in order) that will be awarded when leveling up wands. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_WAND_SLOTS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getWandSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.wand_slot_type_order")
                .defineList("wandSlotTypeOrder", DEFAULT_WAND_SLOTS_ORDER, t -> getWandSlotTypes().contains(t));

        wandSlotTypeRandomPool = builder.comment("Set of modifier slot types from which random slot will be awarded when leveling up wands.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_WAND_SLOTS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getWandSlotTypes()))
                .translation("config.tinkerslevellingaddon.general.slots.wand_slot_type_random_pool")
                .defineList("wandSlotTypeRandomPool", DEFAULT_WAND_SLOTS_RANDOM_POOL, t -> getWandSlotTypes().contains(t));

        builder.pop();
    }

    private static void statsConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Stats settings").push("stats");

        armorStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up armor. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_ARMOR_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getArmorStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.armor_stat_type_order")
                .defineList("armorStatTypeOrder", DEFAULT_ARMOR_STATS_ORDER, t -> getArmorStatTypes().contains(t));

        armorStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up armor.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_ARMOR_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getArmorStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.armor_stat_type_random_pool")
                .defineList("armorStatTypeRandomPool", DEFAULT_ARMOR_STATS_RANDOM_POOL, t -> getArmorStatTypes().contains(t));

        armorStatsValuesConfig(builder);

        battlestaffStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up battlestaffs. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_BATTLESTAFF_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getBattlestaffStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.battlestaff_stat_type_order")
                .defineList("battlestaffStatTypeOrder", DEFAULT_BATTLESTAFF_STATS_ORDER, t -> getBattlestaffStatTypes().contains(t));

        battlestaffStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up battlestaffs.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_BATTLESTAFF_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getBattlestaffStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.battlestaff_stat_type_random_pool")
                .defineList("battlestaffStatTypeRandomPool", DEFAULT_BATTLESTAFF_STATS_RANDOM_POOL, t -> getBattlestaffStatTypes().contains(t));

        battlestaffStatsValuesConfig(builder);

        breakingToolStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up mining tools. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_BREAKING_TOOL_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getBreakingToolStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.breaking_tool_stat_type_order")
                .defineList("breakingToolStatTypeOrder", DEFAULT_BREAKING_TOOL_STATS_ORDER, t -> getBreakingToolStatTypes().contains(t));

        breakingToolStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up mining tools.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_BREAKING_TOOL_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getBreakingToolStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.breaking_tool_stat_type_random_pool")
                .defineList("breakingToolStatTypeRandomPool", DEFAULT_BREAKING_TOOL_STATS_RANDOM_POOL, t -> getBreakingToolStatTypes().contains(t));

        breakingToolStatsValuesConfig(builder);

        dualHeavyWeaponToolStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up tools useable as heavy weapons and for breaking blocks. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_DUAL_HEAVY_WEAPON_TOOL_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getDualHeavyWeaponToolStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.dual_heavy_weapon_tool_stat_type_order")
                .defineList("dualHeavyWeaponToolStatTypeOrder", DEFAULT_DUAL_HEAVY_WEAPON_TOOL_STATS_ORDER, t -> getDualHeavyWeaponToolStatTypes().contains(t));

        dualHeavyWeaponToolStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up tools useable as heavy weapons and for breaking blocks.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_DUAL_HEAVY_WEAPON_TOOL_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getDualHeavyWeaponToolStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.dual_heavy_weapon_tool_stat_type_random_pool")
                .defineList("dualHeavyWeaponToolStatTypeRandomPool", DEFAULT_DUAL_HEAVY_WEAPON_TOOL_STATS_RANDOM_POOL, t -> getDualHeavyWeaponToolStatTypes().contains(t));

        dualHeavyWeaponToolStatsValuesConfig(builder);

        heavyWeaponStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up heavy weapons. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_HEAVY_WEAPON_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getHeavyWeaponStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.heavy_weapon_stat_type_order")
                .defineList("heavyWeaponStatTypeOrder", DEFAULT_HEAVY_WEAPON_STATS_ORDER, t -> getHeavyWeaponStatTypes().contains(t));

        heavyWeaponStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up heavy weapons.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_HEAVY_WEAPON_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getHeavyWeaponStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.heavy_weapon_stat_type_random_pool")
                .defineList("heavyWeaponStatTypeRandomPool", DEFAULT_HEAVY_WEAPON_STATS_RANDOM_POOL, t -> getHeavyWeaponStatTypes().contains(t));

        heavyWeaponStatsValuesConfig(builder);

        lightWeaponStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up light weapons. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_LIGHT_WEAPON_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getLightWeaponStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.light_weapon_stat_type_order")
                .defineList("lightWeaponStatTypeOrder", DEFAULT_LIGHT_WEAPON_STATS_ORDER, t -> getLightWeaponStatTypes().contains(t));

        lightWeaponStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up light weapons.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_LIGHT_WEAPON_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getLightWeaponStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.light_weapon_stat_type_random_pool")
                .defineList("lightWeaponStatTypeRandomPool", DEFAULT_LIGHT_WEAPON_STATS_RANDOM_POOL, t -> getLightWeaponStatTypes().contains(t));

        lightWeaponStatsValuesConfig(builder);

        rangedStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up ranged weapons. If level is higher than list size the mod will start over.",
                        "If empty default rotation will be used (" + String.join(", ", DEFAULT_RANGED_STATS_ORDER) + ").",
                        "Possible values: " + String.join(", ", getRangedStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.ranged_stat_type_order")
                .defineList("rangedStatTypeRotation", DEFAULT_RANGED_STATS_ORDER, t -> getRangedStatTypes().contains(t));

        rangedStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up ranged weapons.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_RANGED_STATS_RANDOM_POOL) + ").",
                        "Possible values: " + String.join(", ", getRangedStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.ranged_stat_type_random_pool")
                .defineList("rangedStatTypeRandomPool", DEFAULT_RANGED_STATS_RANDOM_POOL, t -> getRangedStatTypes().contains(t));

        rangedStatsValuesConfig(builder);

        shieldStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up shields. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_SHIELD_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getShieldStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.shield_stat_type_order")
                .defineList("shieldStatTypeOrder", DEFAULT_SHIELD_STATS_ORDER, t -> getShieldStatTypes().contains(t));

        shieldStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up shields.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_SHIELD_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getShieldStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.shield_stat_type_random_pool")
                .defineList("shieldStatTypeRandomPool", DEFAULT_SHIELD_STATS_RANDOM_POOL, t -> getShieldStatTypes().contains(t));

        shieldStatsValuesConfig(builder);

        spellbookStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up spellbooks. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_SPELLBOOK_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getSpellbookStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.spellbook_stat_type_order")
                .defineList("spellbookStatTypeOrder", DEFAULT_SPELLBOOK_STATS_ORDER, t -> getSpellbookStatTypes().contains(t));

        spellbookStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up spellbooks.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_SPELLBOOK_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getSpellbookStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.spellbook_stat_type_random_pool")
                .defineList("spellbookStatTypeRandomPool", DEFAULT_SPELLBOOK_STATS_RANDOM_POOL, t -> getSpellbookStatTypes().contains(t));

        spellbookStatsValuesConfig(builder);

        staffStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up staffs. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_STAFF_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getStaffStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.staff_stat_type_order")
                .defineList("staffStatTypeOrder", DEFAULT_STAFF_STATS_ORDER, t -> getStaffStatTypes().contains(t));

        staffStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up staffs.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_STAFF_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getStaffStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.staff_stat_type_random_pool")
                .defineList("staffStatTypeRandomPool", DEFAULT_STAFF_STATS_RANDOM_POOL, t -> getStaffStatTypes().contains(t));

        staffStatsValuesConfig(builder);

        toolsStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up tools. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_TOOLS_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getToolStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.tools_stat_type_order")
                .defineList("toolsStatTypeOrder", DEFAULT_TOOLS_STATS_ORDER, t -> getToolStatTypes().contains(t));

        toolsStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up tools.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_TOOLS_STATS_RANDOM_POOL) + "). 25% chance for every stat.",
                        "Allowed values: " + String.join(", ", getToolStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.tools_stat_type_random_pool")
                .defineList("toolsStatTypeRandomPool", DEFAULT_TOOLS_STATS_RANDOM_POOL, t -> getToolStatTypes().contains(t));

        toolStatsValuesConfig(builder);

        wandStatTypeOrder = builder.comment("List of stat types (in order) that will be awarded when leveling up wands. If level is higher than list size the mod will start over.",
                        "If empty default order will be used (" + String.join(", ", DEFAULT_WAND_STATS_ORDER) + ").",
                        "Allowed values: " + String.join(", ", getWandStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.wand_stat_type_order")
                .defineList("wandStatTypeOrder", DEFAULT_WAND_STATS_ORDER, t -> getWandStatTypes().contains(t));

        wandStatTypeRandomPool = builder.comment("Set of stat types from which random stat will be awarded when leveling up wands.",
                        "If empty default pool will be used (" + String.join(", ", DEFAULT_WAND_STATS_RANDOM_POOL) + ").",
                        "Allowed values: " + String.join(", ", getWandStatTypes()))
                .translation("config.tinkerslevellingaddon.general.stats.wand_stat_type_random_pool")
                .defineList("wandStatTypeRandomPool", DEFAULT_WAND_STATS_RANDOM_POOL, t -> getWandStatTypes().contains(t));

        wandStatsValuesConfig(builder);

        builder.pop();
    }

    private static void armorStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Armor stat values rewarded on level ups").push("armorValues");

        armorArmorValue = builder.translation("tooltip.tinkerslevellingaddon.stat.armor")
                .defineInRange(ARMOR, 0.25D, 0.1D, 10D);

        armorArmorToughnessValue = builder.translation("tooltip.tinkerslevellingaddon.stat.armor_toughness")
                .defineInRange(ARMOR_TOUGHNESS, 0.1D, 0.1D, 10D);

        armorDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 50, 1, 1000);

        armorKnockbackResistanceValue = builder.translation("tooltip.tinkerslevellingaddon.stat.knockback_resistance")
                .defineInRange(KNOCKBACK_RESISTANCE, 0.1D, 0.1D, 1D);

        builder.pop();
    }

    private static void battlestaffStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Battlestaff stat values rewarded on level ups").push("battlestaffValues");

        battlestaffAttackDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_damage")
                .defineInRange(ATTACK_DAMAGE, 0.5D, 0.1D, 10D);

        battlestaffAttackSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_speed")
                .defineInRange(ATTACK_SPEED, 0.25D, 0.1D, 10D);

        battlestaffDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 50, 1, 1000);

        battlestaffSpellPowerValue = builder.translation("tooltip.tinkerslevellingaddon.stat.spell_power")
                .defineInRange(SPELL_POWER, 0.05D, 0.01D, 1D);

        battlestaffManaValue = builder.translation("tooltip.tinkerslevellingaddon.stat.max_mana")
                .defineInRange(MAX_MANA, 25, 1, 1000);

        builder.pop();
    }

    private static void breakingToolStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Mining tool stat values rewarded on level ups").push("breakingToolValues");

        breakingToolMiningSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.mining_speed")
                .defineInRange(MINING_SPEED, 1D, 0.1D, 10D);

        breakingToolDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 50, 1, 1000);

        builder.pop();
    }

    private static void dualHeavyWeaponToolStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Stat values rewarded on level ups for tools useable as heavy weapons and for breaking blocks").push("dualHeavyWeaponToolValues");

        dualHeavyWeaponToolAttackDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_damage")
                .defineInRange(ATTACK_DAMAGE, 0.5D, 0.1D, 10D);

        dualHeavyWeaponToolMiningSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.mining_speed")
                .defineInRange(MINING_SPEED, 1D, 0.1D, 10D);

        dualHeavyWeaponToolDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 50, 1, 1000);

        builder.pop();
    }

    private static void heavyWeaponStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Heavy weapon stat values rewarded on level ups").push("heavyWeaponValues");

        heavyWeaponAttackDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_damage")
                .defineInRange(ATTACK_DAMAGE, 0.5D, 0.1D, 10D);

        heavyWeaponAttackSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_speed")
                .defineInRange(ATTACK_SPEED, 0.25D, 0.1D, 10D);

        heavyWeaponDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 50, 1, 1000);

        builder.pop();
    }

    private static void lightWeaponStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Light weapon stat values rewarded on level ups").push("lightWeaponValues");

        lightWeaponAttackDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_damage")
                .defineInRange(ATTACK_DAMAGE, 0.5D, 0.1D, 10D);

        lightWeaponAttackSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_speed")
                .defineInRange(ATTACK_SPEED, 0.25D, 0.1D, 10D);

        lightWeaponDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 50, 1, 1000);

        builder.pop();
    }

    private static void rangedStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Ranged weapons stat values rewarded on level ups").push("rangedValues");

        rangedAccuracyValue = builder.translation("tooltip.tinkerslevellingaddon.stat.accuracy")
                .defineInRange(ACCURACY, 0.01D, 0.01D, 1D);

        rangedDrawSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.draw_speed")
                .defineInRange(DRAW_SPEED, 0.1D, 0.1D, 10D);

        rangedDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 30, 1, 1000);

        rangedProjectileDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stat.projectile_damage")
                .defineInRange(PROJECTILE_DAMAGE, 0.1D, 0.1D, 10D);

        rangedVelocityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.velocity")
                .defineInRange(VELOCITY, 0.1D, 0.1D, 10D);

        builder.pop();
    }

    private static void shieldStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Shield stat values rewarded on level ups").push("shieldValues");

        shieldArmorToughnessValue = builder.translation("tooltip.tinkerslevellingaddon.stat.armor_toughness")
                .defineInRange(ARMOR_TOUGHNESS, 0.1D, 0.1D, 10D);

        shieldBlockAmountValue = builder.translation("tooltip.tinkerslevellingaddon.stat.block_amount")
                .defineInRange(BLOCK_AMOUNT, 5.0D, 0.1D, 100D);

        shieldBlockAngleValue = builder.translation("tooltip.tinkerslevellingaddon.stat.block_angle")
                .defineInRange(BLOCK_ANGLE, 2, 1, 360);

        shieldDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 30, 1, 1000);

        shieldKnockbackResistanceValue = builder.translation("tooltip.tinkerslevellingaddon.stat.knockback_resistance")
                .defineInRange(KNOCKBACK_RESISTANCE, 0.1D, 0.1D, 1D);

        builder.pop();
    }

    private static void spellbookStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Spellbook stat values rewarded on level ups").push("spellbookValues");

        spellbookSpellPowerValue = builder.translation("tooltip.tinkerslevellingaddon.stat.spell_power")
                .defineInRange(SPELL_POWER, 0.05D, 0.01D, 10D);

        spellbookManaValue = builder.translation("tooltip.tinkerslevellingaddon.stat.max_mana")
                .defineInRange(MAX_MANA, 25, 1, 1000);

        spellbookSpellSlotsValue = builder.translation("tooltip.tinkerslevellingaddon.stat.spell_slots")
                .defineInRange(SPELL_SLOTS, 1, 1, 3);

        spellbookCooldownReductionValue = builder.translation("tooltip.tinkerslevellingaddon.stat.cooldown_reduction")
                .defineInRange(COOLDOWN_REDUCTION, 0.05D, 0.01D, 10D);

        builder.pop();
    }

    private static void staffStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Staff stat values rewarded on level ups").push("staffValues");

        staffAccuracyValue = builder.translation("tooltip.tinkerslevellingaddon.stat.accuracy")
                .defineInRange(ACCURACY, 0.01D, 0.01D, 1D);

        staffArmorValue = builder.translation("tooltip.tinkerslevellingaddon.stat.armor")
                .defineInRange(ARMOR, 0.25D, 0.1D, 10D);

        staffDrawSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.draw_speed")
                .defineInRange(DRAW_SPEED, 0.1D, 0.1D, 10D);

        staffDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 30, 1, 1000);

        staffProjectileDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stat.projectile_damage")
                .defineInRange(PROJECTILE_DAMAGE, 0.1D, 0.1D, 10D);

        staffVelocityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.velocity")
                .defineInRange(VELOCITY, 0.1D, 0.1D, 10D);

        builder.pop();
    }

    private static void toolStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Tool stat values rewarded on level ups").push("toolValues");

        toolAttackDamageValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_damage")
                .defineInRange(ATTACK_DAMAGE, 0.5D, 0.1D, 10D);

        toolAttackSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.attack_speed")
                .defineInRange(ATTACK_SPEED, 0.25D, 0.1D, 10D);

        toolDurabilityValue = builder.translation("tooltip.tinkerslevellingaddon.stat.durability")
                .defineInRange(DURABILITY, 50, 1, 1000);

        toolMiningSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.mining_speed")
                .defineInRange(MINING_SPEED, 1D, 0.1D, 10D);

        builder.pop();
    }

    private static void wandStatsValuesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Wand stat values rewarded on level ups").push("wandValues");

        wandSpellPowerValue = builder.translation("tooltip.tinkerslevellingaddon.stat.spell_power")
                .defineInRange(SPELL_POWER, 0.05D, 0.01D, 10D);

        wandManaValue = builder.translation("tooltip.tinkerslevellingaddon.stat.max_mana")
                .defineInRange(MAX_MANA, 50, 1, 1000);

        wandCastingSpeedValue = builder.translation("tooltip.tinkerslevellingaddon.stat.casting_speed")
                .defineInRange(CASTING_SPEED, 0.05D, 0.01D, 10D);

        wandCooldownReductionValue = builder.translation("tooltip.tinkerslevellingaddon.stat.cooldown_reduction")
                .defineInRange(COOLDOWN_REDUCTION, 0.05D, 0.01D, 10D);

        builder.pop();
    }

    private static void toolLevellingConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Tool levelling settings").push("toolLevelling");

        damageDealt = builder.comment("Melee only!", "If true, base experience value gained for attacking is equal to damage dealt (rounded to whole number), otherwise 1.")
                .translation("config.tinkerslevellingaddon.levelling.damage_dealt")
                .define("damageDealt", true);
        damageTaken = builder.comment("If true, base experience value gained for taking damage is equal to damage taken (rounded to whole number), otherwise 1.")
                .translation("config.tinkerslevellingaddon.levelling.damage_taken")
                .define("damageTaken", true);
        damageBlocked = builder.comment("If true, base experience value gained for blocking damage is equal to damage blocked (rounded to whole number), otherwise 1.")
                .translation("config.tinkerslevellingaddon.levelling.damage_blocked")
                .define("damageBlocked", true);
        enablePvp = builder.comment("If true, allows to gain experience from dealing damage to or taking damage from other players.")
                .translation("config.tinkerslevellingaddon.levelling.enable_pvp")
                .define("pvp", true);
        flyingTime = builder.comment("The time (in ticks) of continuous flight using an elytra after which experience points will be awarded.",
                        "20 ticks = 1 second")
                .translation("config.tinkerslevellingaddon.levelling.flying_time")
                .defineInRange("flyingTime", 300, 1, 1200);

        actionsConfig(builder);
        bonusesConfig(builder);

        builder.pop();
    }

    private static void actionsConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("If true, given action will yield tool experience.").push("actions");

        enableAttackingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.attacking")
                .define("attacking", true);

        enableBlockingDamageXp = builder
                .translation("config.tinkerslevellingaddon.levelling.blocking_damage")
                .define("blockingDamage", true);

        enableBonkingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.bonking")
                .define("bonking", true);

        enableBrushingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.brushing")
                .define("brushing", true);

        enableBucketingXp = builder.comment("Placing fluids in world only, no container filling, no fluid pickup.")
                .translation("config.tinkerslevellingaddon.levelling.bucketing")
                .define("bucketing", true);

        enableFirestarterXp = builder
                .translation("config.tinkerslevellingaddon.levelling.firestarter")
                .define("firestarter", true);

        enableFishingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.fishing")
                .define("fishing", true);

        enableFlamewakeXp = builder
                .translation("config.tinkerslevellingaddon.levelling.flamewake")
                .define("flamewake", true);

        enableFlingingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.flinging")
                .define("flinging", true);

        enableFlyingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.flying")
                .define("flying", true);

        enableFrostWalkerXp = builder
                .translation("config.tinkerslevellingaddon.levelling.frost_walker")
                .define("frost_walker", true);

        enableGlowingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.glowing")
                .define("glowing", true);

        enableGrapplingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.grappling")
                .define("grappling", true);

        enableHarvestingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.harvesting")
                .define("harvesting", true);

        enableMeltingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.melting")
                .define("melting", true);

        enableMiningXp = builder
                .translation("config.tinkerslevellingaddon.levelling.mining")
                .define("mining", true);

        enablePathMakerXp = builder
                .translation("config.tinkerslevellingaddon.levelling.path_maker")
                .define("path_maker", true);

        enablePathMakingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.path_making")
                .define("pathMaking", true);

        enablePlowingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.plowing")
                .define("plowing", true);

        enableScrappingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.scrapping")
                .define("scrapping", true);

        enableShearingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.shearing")
                .define("shearing", true);

        enableShootingXp = builder.comment("Applies to ranged weapons like longbows and crossbows.")
                .translation("config.tinkerslevellingaddon.levelling.shooting")
                .define("shooting", true);

        enableSlimeballXp = builder
                .translation("config.tinkerslevellingaddon.levelling.slimeball")
                .define("slimeball", true);

        enableSlurpingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.slurping")
                .define("slurping", true);

        enableSnowdriftXp = builder
                .translation("config.tinkerslevellingaddon.levelling.snowdrift")
                .define("snowdrift", true);

        enableSpillingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.spilling")
                .define("spilling", true);

        enableSpittingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.spitting")
                .define("spitting", true);

        enableSplashingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.splashing")
                .define("splashing", true);

        enableSpringingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.springing")
                .define("springing", true);

        enableStrippingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.stripping")
                .define("stripping", true);

        enableTakingDamageXp = builder.comment("Applies to armor only.")
                .translation("config.tinkerslevellingaddon.levelling.taking_damage")
                .define("takingDamage", true);

        enableThornsXp = builder.comment("Applies to armor only. Thorns modifier gives 15% chance per level to gain experience.")
                .translation("config.tinkerslevellingaddon.levelling.thorns")
                .define("thorns", true);

        enableTillingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.tilling")
                .define("tilling", true);

        enableWarpingXp = builder
                .translation("config.tinkerslevellingaddon.levelling.warping")
                .define("warping", true);

        enableWaxingOffXp = builder
                .translation("config.tinkerslevellingaddon.levelling.waxing_off")
                .define("waxingOff", true);


        builder.pop();
    }

    private static void bonusesConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Amount of bonus experience for performing actions. If set to 0 there is no bonus experience.").push("bonuses");

        bonusAttackingXp = builder.translation("config.tinkerslevellingaddon.levelling.attacking")
                .defineInRange("attacking", 0, 0, Integer.MAX_VALUE);

        bonusBlockingDamageXp = builder.translation("config.tinkerslevellingaddon.levelling.blocking_damage")
                .defineInRange("blockingDamage", 0, 0, Integer.MAX_VALUE);

        bonusBonkingXp = builder.translation("config.tinkerslevellingaddon.levelling.bonking")
                .defineInRange("bonking", 0, 0, Integer.MAX_VALUE);

        bonusBrushingXp = builder.translation("config.tinkerslevellingaddon.levelling.brushing")
                .defineInRange("brushing", 0, 0, Integer.MAX_VALUE);

        bonusBucketingXp = builder.translation("config.tinkerslevellingaddon.levelling.bucketing")
                .defineInRange("bucketing", 0, 0, Integer.MAX_VALUE);

        bonusFirestarterXp = builder.translation("config.tinkerslevellingaddon.levelling.firestarter")
                .defineInRange("firestarter", 0, 0, Integer.MAX_VALUE);

        bonusFishingXp = builder.translation("config.tinkerslevellingaddon.levelling.fishing")
                .defineInRange("fishing", 0, 0, Integer.MAX_VALUE);

        bonusFlamewakeXp = builder.translation("config.tinkerslevellingaddon.levelling.flamewake")
                .defineInRange("flamewake", 0, 0, Integer.MAX_VALUE);

        bonusFlingingXp = builder.translation("config.tinkerslevellingaddon.levelling.flinging")
                .defineInRange("flinging", 0, 0, Integer.MAX_VALUE);

        bonusFlyingXp = builder.translation("config.tinkerslevellingaddon.levelling.flying")
                .defineInRange("flying", 0, 0, Integer.MAX_VALUE);

        bonusFrostWalkerXp = builder.translation("config.tinkerslevellingaddon.levelling.frost_walker")
                .defineInRange("frost_walker", 0, 0, Integer.MAX_VALUE);

        bonusGlowingXp = builder.translation("config.tinkerslevellingaddon.levelling.glowing")
                .defineInRange("glowing", 0, 0, Integer.MAX_VALUE);

        bonusGrapplingXp = builder.translation("config.tinkerslevellingaddon.levelling.grappling")
                .defineInRange("grappling", 0, 0, Integer.MAX_VALUE);

        bonusHarvestingXp = builder.translation("config.tinkerslevellingaddon.levelling.harvesting")
                .defineInRange("harvesting", 0, 0, Integer.MAX_VALUE);

        bonusMeltingXp = builder.translation("config.tinkerslevellingaddon.levelling.melting")
                .defineInRange("melting", 0, 0, Integer.MAX_VALUE);

        bonusMiningXp = builder.translation("config.tinkerslevellingaddon.levelling.mining")
                .defineInRange("mining", 0, 0, Integer.MAX_VALUE);

        bonusPathMakerXp = builder.translation("config.tinkerslevellingaddon.levelling.path_maker")
                .defineInRange("path_maker", 0, 0, Integer.MAX_VALUE);

        bonusPathMakingXp = builder.translation("config.tinkerslevellingaddon.levelling.path_making")
                .defineInRange("pathMaking", 0, 0, Integer.MAX_VALUE);

        bonusPlowingXp = builder.translation("config.tinkerslevellingaddon.levelling.plowing")
                .defineInRange("plowing", 0, 0, Integer.MAX_VALUE);

        bonusScrappingXp = builder.translation("config.tinkerslevellingaddon.levelling.scrapping")
                .defineInRange("scrapping", 0, 0, Integer.MAX_VALUE);

        bonusShearingXp = builder.translation("config.tinkerslevellingaddon.levelling.shearing")
                .defineInRange("shearing", 0, 0, Integer.MAX_VALUE);

        bonusShootingXp = builder.translation("config.tinkerslevellingaddon.levelling.shooting")
                .defineInRange("shooting", 0, 0, Integer.MAX_VALUE);

        bonusSlimeballXp = builder.translation("config.tinkerslevellingaddon.levelling.slimeball")
                .defineInRange("slimeball", 0, 0, Integer.MAX_VALUE);

        bonusSlurpingXp = builder.translation("config.tinkerslevellingaddon.levelling.slurping")
                .defineInRange("slurping", 0, 0, Integer.MAX_VALUE);

        bonusSnowdriftXp = builder.translation("config.tinkerslevellingaddon.levelling.snowdrift")
                .defineInRange("snowdrift", 0, 0, Integer.MAX_VALUE);

        bonusSpillingXp = builder.translation("config.tinkerslevellingaddon.levelling.spilling")
                .defineInRange("spilling", 0, 0, Integer.MAX_VALUE);

        bonusSpittingXp = builder.translation("config.tinkerslevellingaddon.levelling.spitting")
                .defineInRange("spitting", 0, 0, Integer.MAX_VALUE);

        bonusSplashingXp = builder.translation("config.tinkerslevellingaddon.levelling.splashing")
                .defineInRange("splashing", 0, 0, Integer.MAX_VALUE);

        bonusSpringingXp = builder.translation("config.tinkerslevellingaddon.levelling.springing")
                .defineInRange("springing", 0, 0, Integer.MAX_VALUE);

        bonusStrippingXp = builder.translation("config.tinkerslevellingaddon.levelling.stripping")
                .defineInRange("stripping", 0, 0, Integer.MAX_VALUE);

        bonusTakingDamageXp = builder.translation("config.tinkerslevellingaddon.levelling.taking_damage")
                .defineInRange("takingDamage", 0, 0, Integer.MAX_VALUE);

        bonusThornsXp = builder.comment("As with Thorns damage calculations, this is the upper bound of the bonus experience that could be granted.",
                        "For example, for the value of 3 (default), we get: 1 (base xp) + 0 to 3 (bonus xp) = 1 to 4 (result xp)")
                .translation("config.tinkerslevellingaddon.levelling.thorns")
                .defineInRange("thorns", 3, 0, Integer.MAX_VALUE);

        bonusTillingXp = builder.translation("config.tinkerslevellingaddon.levelling.tilling")
                .defineInRange("tilling", 0, 0, Integer.MAX_VALUE);

        bonusWarpingXp = builder.translation("config.tinkerslevellingaddon.levelling.warping")
                .defineInRange("warping", 0, 0, Integer.MAX_VALUE);

        bonusWaxingOffXp = builder.translation("config.tinkerslevellingaddon.levelling.waxing_off")
                .defineInRange("waxingOff", 0, 0, Integer.MAX_VALUE);

        builder.pop();
    }

    private static void clientConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Client only settings").push("client");

        enableLevelUpMessage = builder.comment("If true, shows chat message on tool level ups.")
                .translation("config.tinkerslevellingaddon.client.messages")
                .define("message", true);

        squashLevelPluses = builder.comment("If true, uses alternative level name suffix for high level tools.",
                "Instead of appending '+' signs for each consecutive level appearance, +1, +2, +3, etc. notation will be used.")
                .translation("config.tinkerslevellingaddon.client.squash_pluses")
                .define("squashPluses", false);

        levelUpSound = builder.comment("")
                .translation("config.tinkerslevellingaddon.client.sound")
                .defineEnum("sound", LevelUpSound.SNARE_DRUM, EnumGetMethod.NAME_IGNORECASE, LevelUpSound.values());
    }

    public static void init() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }

    public static List<String> getArmorSlotsOrder() {
        List<? extends String> slotsOrder = armorSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_ARMOR_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getArmorSlotsRandomPool() {
        List<? extends String> slotsRandomPool = armorSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_ARMOR_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getArmorStatsOrder() {
        List<? extends String> statsOrder = armorStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_ARMOR_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getArmorStatsRandomPool() {
        List<? extends String> statsRandomPool = armorStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_ARMOR_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getBattlestaffSlotsOrder() {
        List<? extends String> slotsOrder = battlestaffSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_BATTLESTAFF_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getBattlestaffSlotsRandomPool() {
        List<? extends String> slotsRandomPool = battlestaffSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_BATTLESTAFF_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getBattlestaffStatsOrder() {
        List<? extends String> statsOrder = battlestaffStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_BATTLESTAFF_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getBattlestaffStatsRandomPool() {
        List<? extends String> statsRandomPool = battlestaffStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_BATTLESTAFF_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getBreakingToolSlotsOrder() {
        List<? extends String> slotsOrder = breakingToolSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_BREAKING_TOOL_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getBreakingToolSlotsRandomPool() {
        List<? extends String> slotsRandomPool = breakingToolSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_BREAKING_TOOL_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getBreakingToolStatsOrder() {
        List<? extends String> statsOrder = breakingToolStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_BREAKING_TOOL_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getBreakingToolStatsRandomPool() {
        List<? extends String> statsRandomPool = breakingToolStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_BREAKING_TOOL_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getDualHeavyWeaponToolSlotsOrder() {
        List<? extends String> slotsOrder = dualHeavyWeaponToolSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_DUAL_HEAVY_WEAPON_TOOL_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getDualHeavyWeaponToolSlotsRandomPool() {
        List<? extends String> slotsRandomPool = dualHeavyWeaponToolSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_DUAL_HEAVY_WEAPON_TOOL_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getDualHeavyWeaponToolStatsOrder() {
        List<? extends String> statsOrder = dualHeavyWeaponToolStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_DUAL_HEAVY_WEAPON_TOOL_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getDualHeavyWeaponToolStatsRandomPool() {
        List<? extends String> statsRandomPool = dualHeavyWeaponToolStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_DUAL_HEAVY_WEAPON_TOOL_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getHeavyWeaponSlotsOrder() {
        List<? extends String> slotsOrder = heavyWeaponSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_HEAVY_WEAPON_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getHeavyWeaponSlotsRandomPool() {
        List<? extends String> slotsRandomPool = heavyWeaponSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_HEAVY_WEAPON_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getHeavyWeaponStatsOrder() {
        List<? extends String> statsOrder = heavyWeaponStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_HEAVY_WEAPON_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getHeavyWeaponStatsRandomPool() {
        List<? extends String> statsRandomPool = heavyWeaponStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_HEAVY_WEAPON_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getLightWeaponSlotsOrder() {
        List<? extends String> slotsOrder = lightWeaponSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_LIGHT_WEAPON_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getLightWeaponSlotsRandomPool() {
        List<? extends String> slotsRandomPool = lightWeaponSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_LIGHT_WEAPON_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getLightWeaponStatsOrder() {
        List<? extends String> statsOrder = lightWeaponStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_LIGHT_WEAPON_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getLightWeaponStatsRandomPool() {
        List<? extends String> statsRandomPool = lightWeaponStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_LIGHT_WEAPON_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getRangedSlotsOrder() {
        List<? extends String> slotsOrder = rangedSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_RANGED_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getRangedSlotsRandomPool() {
        List<? extends String> slotsRandomPool = rangedSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_RANGED_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getRangedStatsOrder() {
        List<? extends String> statsOrder = rangedStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_RANGED_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getRangedStatsRandomPool() {
        List<? extends String> statsRandomPool = rangedStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_RANGED_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getShieldSlotsOrder() {
        List<? extends String> slotsOrder = shieldSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_SHIELD_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getShieldSlotsRandomPool() {
        List<? extends String> slotsRandomPool = shieldSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_SHIELD_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getShieldStatsOrder() {
        List<? extends String> statsOrder = shieldStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_SHIELD_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getShieldStatsRandomPool() {
        List<? extends String> statsRandomPool = shieldStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_SHIELD_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getSpellbookSlotsOrder() {
        List<? extends String> slotsOrder = spellbookSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_SPELLBOOK_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getSpellbookSlotsRandomPool() {
        List<? extends String> slotsRandomPool = spellbookSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_SPELLBOOK_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getSpellbookStatsOrder() {
        List<? extends String> statsOrder = spellbookStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_SPELLBOOK_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getSpellbookStatsRandomPool() {
        List<? extends String> statsRandomPool = spellbookStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_SPELLBOOK_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getStaffSlotsOrder() {
        List<? extends String> slotsOrder = staffSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_STAFF_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getStaffSlotsRandomPool() {
        List<? extends String> slotsRandomPool = staffSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_STAFF_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getStaffStatsOrder() {
        List<? extends String> statsOrder = staffStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_STAFF_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getStaffStatsRandomPool() {
        List<? extends String> statsRandomPool = staffStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_STAFF_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getToolsSlotsOrder() {
        List<? extends String> slotsOrder = toolsSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_TOOLS_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getToolsSlotsRandomPool() {
        List<? extends String> slotsRandomPool = toolsSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_TOOLS_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getToolsStatsOrder() {
        List<? extends String> statsOrder = toolsStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_TOOLS_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getToolsStatsRandomPool() {
        List<? extends String> statsRandomPool = toolsStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_TOOLS_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static List<String> getWandSlotsOrder() {
        List<? extends String> slotsOrder = wandSlotTypeOrder.get();
        if (slotsOrder.isEmpty()) {
            slotsOrder = DEFAULT_WAND_SLOTS_ORDER;
        }
        return (List<String>) slotsOrder;
    }

    public static List<String> getWandSlotsRandomPool() {
        List<? extends String> slotsRandomPool = wandSlotTypeRandomPool.get();
        if (slotsRandomPool.isEmpty()) {
            slotsRandomPool = DEFAULT_WAND_SLOTS_RANDOM_POOL;
        }
        return (List<String>) slotsRandomPool;
    }

    public static List<String> getWandStatsOrder() {
        List<? extends String> statsOrder = wandStatTypeOrder.get();
        if (statsOrder.isEmpty()) {
            statsOrder = DEFAULT_WAND_STATS_ORDER;
        }
        return (List<String>) statsOrder;
    }

    public static List<String> getWandStatsRandomPool() {
        List<? extends String> statsRandomPool = wandStatTypeRandomPool.get();
        if (statsRandomPool.isEmpty()) {
            statsRandomPool = DEFAULT_WAND_STATS_RANDOM_POOL;
        }
        return (List<String>) statsRandomPool;
    }

    public static double getArmorStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.DURABILITY)) {
            return armorDurabilityValue.get();
        }
        if (stat.equals(ToolStats.ARMOR)) {
            return armorArmorValue.get();
        }
        if (stat.equals(ToolStats.ARMOR_TOUGHNESS)) {
            return armorArmorToughnessValue.get();
        }
        if (stat.equals(ToolStats.KNOCKBACK_RESISTANCE)) {
            return armorKnockbackResistanceValue.get();
        }
        return 0;
    }

    public static double getBattlestaffStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.ATTACK_DAMAGE)) {
            return battlestaffAttackDamageValue.get();
        }
        if (stat.equals(ToolStats.ATTACK_SPEED)) {
            return battlestaffAttackSpeedValue.get();
        }
        if (stat.equals(ToolStats.DURABILITY)) {
            return battlestaffDurabilityValue.get();
        }
        if (stat.equals(CCToolStats.SPELL_POWER)) {
            return battlestaffSpellPowerValue.get();
        }
        if (stat.equals(CCToolStats.MAX_MANA)) {
            return battlestaffManaValue.get();
        }
        return 0;
    }

    public static double getBreakingToolStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.MINING_SPEED)) {
            return breakingToolMiningSpeedValue.get();
        }
        if (stat.equals(ToolStats.DURABILITY)) {
            return breakingToolDurabilityValue.get();
        }
        return 0;
    }

    public static double getDualHeavyWeaponToolStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.ATTACK_DAMAGE)) {
            return dualHeavyWeaponToolAttackDamageValue.get();
        }
        if (stat.equals(ToolStats.MINING_SPEED)) {
            return dualHeavyWeaponToolMiningSpeedValue.get();
        }
        if (stat.equals(ToolStats.DURABILITY)) {
            return dualHeavyWeaponToolDurabilityValue.get();
        }
        return 0;
    }

    public static double getHeavyWeaponStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.ATTACK_DAMAGE)) {
            return heavyWeaponAttackDamageValue.get();
        }
        if (stat.equals(ToolStats.ATTACK_SPEED)) {
            return heavyWeaponAttackSpeedValue.get();
        }
        if (stat.equals(ToolStats.DURABILITY)) {
            return heavyWeaponDurabilityValue.get();
        }
        return 0;
    }

    public static double getLightWeaponStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.ATTACK_DAMAGE)) {
            return lightWeaponAttackDamageValue.get();
        }
        if (stat.equals(ToolStats.ATTACK_SPEED)) {
            return lightWeaponAttackSpeedValue.get();
        }
        if (stat.equals(ToolStats.DURABILITY)) {
            return lightWeaponDurabilityValue.get();
        }
        return 0;
    }

    public static double getRangedStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.DRAW_SPEED)) {
            return rangedDrawSpeedValue.get();
        }
        if (stat.equals(ToolStats.VELOCITY)) {
            return rangedVelocityValue.get();
        }
        if (stat.equals(ToolStats.ACCURACY)) {
            return rangedAccuracyValue.get();
        }
        if (stat.equals(ToolStats.PROJECTILE_DAMAGE)) {
            return rangedProjectileDamageValue.get();
        }
        if (stat.equals(ToolStats.DURABILITY)) {
            return rangedDurabilityValue.get();
        }
        return 0;
    }

    public static double getShieldStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.ARMOR_TOUGHNESS)) {
            return shieldArmorToughnessValue.get();
        }
        if (stat.equals(ToolStats.BLOCK_AMOUNT)) {
            return shieldBlockAmountValue.get();
        }
        if (stat.equals(ToolStats.BLOCK_ANGLE)) {
            return shieldBlockAngleValue.get();
        }
        if (stat.equals(ToolStats.DURABILITY)) {
            return shieldDurabilityValue.get();
        }
        if (stat.equals(ToolStats.KNOCKBACK_RESISTANCE)) {
            return shieldKnockbackResistanceValue.get();
        }
        return 0;
    }

    public static double getSpellbookStatValue(FloatToolStat stat) {
        if (stat.equals(CCToolStats.SPELL_POWER)) {
            return spellbookSpellPowerValue.get();
        }
        if (stat.equals(CCToolStats.MAX_MANA)) {
            return spellbookManaValue.get();
        }
        if (stat.equals(CCToolStats.SPELL_SLOTS)) {
            return spellbookSpellSlotsValue.get();
        }
        if (stat.equals(CCToolStats.COOLDOWN_REDUCTION)) {
            return spellbookCooldownReductionValue.get();
        }
        return 0;
    }

    public static double getStaffStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.DRAW_SPEED)) {
            return staffDrawSpeedValue.get();
        }
        if (stat.equals(ToolStats.VELOCITY)) {
            return staffVelocityValue.get();
        }
        if (stat.equals(ToolStats.ACCURACY)) {
            return staffAccuracyValue.get();
        }
        if (stat.equals(ToolStats.PROJECTILE_DAMAGE)) {
            return staffProjectileDamageValue.get();
        }
        if (stat.equals(ToolStats.DURABILITY)) {
            return staffDurabilityValue.get();
        }
        if (stat.equals(ToolStats.ARMOR)) {
            return staffArmorValue.get();
        }
        return 0;
    }

    public static double getToolStatValue(FloatToolStat stat) {
        if (stat.equals(ToolStats.DURABILITY)) {
            return toolDurabilityValue.get();
        }
        if (stat.equals(ToolStats.ATTACK_DAMAGE)) {
            return toolAttackDamageValue.get();
        }
        if (stat.equals(ToolStats.ATTACK_SPEED)) {
            return toolAttackSpeedValue.get();
        }
        if (stat.equals(ToolStats.MINING_SPEED)) {
            return toolMiningSpeedValue.get();
        }
        return 0;
    }

    public static double getWandStatValue(FloatToolStat stat) {
        if (stat.equals(CCToolStats.SPELL_POWER)) {
            return wandSpellPowerValue.get();
        }
        if (stat.equals(CCToolStats.MAX_MANA)) {
            return wandManaValue.get();
        }
        if (stat.equals(TinkersLevellingAddonStats.CASTING_SPEED)) {
            return wandCastingSpeedValue.get();
        }
        if (stat.equals(CCToolStats.COOLDOWN_REDUCTION)) {
            return wandCooldownReductionValue.get();
        }
        return 0;
    }

    public enum LevelUpSound {
        NONE(null),
        CHIME(Sounds.CHIME.getSound()),
        SNARE_DRUM(Sounds.SNARE_DRUM.getSound()),
        YAY(Sounds.YAY.getSound()),
        BONK(slimeknights.tconstruct.common.Sounds.BONK.getSound());

        private final SoundEvent soundEvent;

        LevelUpSound(SoundEvent soundEvent) {
            this.soundEvent = soundEvent;
        }

        public SoundEvent getSoundEvent() {
            return soundEvent;
        }
    }

    public enum GainingMethod {
        NONE,
        PREDEFINED_ORDER,
        RANDOM
    }
}
