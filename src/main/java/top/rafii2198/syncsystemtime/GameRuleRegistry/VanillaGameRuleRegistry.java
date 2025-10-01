package top.rafii2198.syncsystemtime.GameRuleRegistry;

import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;

public final class VanillaGameRuleRegistry {
    public static final CustomGameRuleCategory TIME_SYNC = GameRuleUtilities.generateGameRuleCategory("time_sync");

    public static final GameRules.Key<GameRules.BooleanValue> RULE_SYNC =
            GameRuleRegistry.register("syncSystemTime", TIME_SYNC, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.IntegerValue> RULE_OFFSET_SYSTEM =
            GameRuleRegistry.register("systemTimeOffset", TIME_SYNC, GameRuleFactory.createIntRule(0));
    public static final GameRules.Key<GameRules.IntegerValue> RULE_OFFSET_GAME =
            GameRuleRegistry.register("gameTimeOffset", TIME_SYNC, GameRuleFactory.createIntRule(-6000, -23999, 23999));

    public static void init() {}
}
