package top.rafii2198.syncsystemtime.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.storage.ServerLevelData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.rafii2198.syncsystemtime.GameRuleRegistry.VanillaGameRuleRegistry;
import top.rafii2198.syncsystemtime.Syncsystemtime;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {
    @Shadow
    public abstract GameRules getGameRules();

    @Shadow
    @Final
    private ServerLevelData serverLevelData;

    @Inject(method = "setDayTime", at = @At("HEAD"), cancellable = true)
    private void addSyncingBehavior(CallbackInfo ci) {
        if (this.getGameRules().getBoolean(VanillaGameRuleRegistry.RULE_SYNC)) {
            if (this.getGameRules().getBoolean(GameRules.RULE_DAYLIGHT)) {
                this.serverLevelData.setDayTime(Syncsystemtime.calculateInGameTime(
                        this.getGameRules().getInt(VanillaGameRuleRegistry.RULE_OFFSET_SYSTEM),
                        this.getGameRules().getInt(VanillaGameRuleRegistry.RULE_OFFSET_GAME)));
            }
            ci.cancel();
        }
    }
}
