package pyre.tinkerslevellingaddon.setup;

import com.snackpirate.constructscasting.materials.CCToolStats.BonusFloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.library.tools.stat.ToolStatId;

public class TinkersLevellingAddonStats {
    public static final BonusFloatToolStat CASTING_SPEED = ToolStats.registerConditional(
            new BonusFloatToolStat(
                    new ToolStatId("tinkerslevellingaddon", "casting_speed"),
                    0xFF55FFFF,
                    0,
                    -100,
                    1000,
                    null
            )
    );

    private TinkersLevellingAddonStats() {
    }
}