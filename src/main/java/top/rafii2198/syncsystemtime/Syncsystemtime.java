package top.rafii2198.syncsystemtime;

import java.time.LocalDateTime;
import net.fabricmc.api.ModInitializer;
import top.rafii2198.syncsystemtime.GameRuleRegistry.VanillaGameRuleRegistry;

public class Syncsystemtime implements ModInitializer {
    public static final String MOD_ID = "syncsystemtime";

    public static Long calculateInGameTime(int timeOffset, int tickOffset) {
        LocalDateTime time = LocalDateTime.now();
        long ticks =
                (long) (((time.getHour() + (time.getMinute() / 60f) + ((time.getSecond() + timeOffset) / 3600f)) * 1000)
                        + tickOffset);

        while (ticks < 0) {
            ticks += 24000;
        }

        return ticks % 24000;
    }

    @Override
    public void onInitialize() {
        VanillaGameRuleRegistry.init();
    }
}
