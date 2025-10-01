package top.rafii2198.syncsystemtime.GameRuleRegistry;

import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import top.rafii2198.syncsystemtime.Syncsystemtime;

public class GameRuleUtilities {
    public static CustomGameRuleCategory generateGameRuleCategory(String id) {
        Component nameComponent = Component.translatable("gamerule.category.syncsystemtime." + id)
                .withColor(3040490)
                .withStyle(ChatFormatting.BOLD);

        return new CustomGameRuleCategory(
                ResourceLocation.fromNamespaceAndPath(Syncsystemtime.MOD_ID, id), nameComponent);
    }
}
