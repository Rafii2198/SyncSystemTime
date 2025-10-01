package top.rafii2198.syncsystemtime.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import top.rafii2198.syncsystemtime.GameRuleRegistry.VanillaGameRuleRegistry;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {

    @WrapOperation(
            method = "synchronizeTime",
            at =
                    @At(
                            value = "INVOKE",
                            target =
                                    "Lnet/minecraft/world/level/GameRules;getBoolean(Lnet/minecraft/world/level/GameRules$Key;)Z"))
    private boolean wrapGameRule(
            GameRules instance, GameRules.Key<GameRules.BooleanValue> key, Operation<Boolean> original) {
        return !(instance.getBoolean(VanillaGameRuleRegistry.RULE_SYNC) || !original.call(instance, key));
    }
}
