package me.playbosswar.griefdefenderconditions.conditions;

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.claim.Claim;
import me.playbosswar.com.api.ConditionRule;
import me.playbosswar.com.api.NeededValue;
import org.bukkit.entity.Player;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.UUID;

public class IsInRegionCondition implements ConditionRule {
    @Override
    public String getName() {
        return "IS_IN_CLAIM";
    }

    @Override
    public String getDescription() {
        return "Check if player is in region a specific claim";
    }

    @Override
    public boolean evaluate(Facts facts) {
        Player p = facts.get("player");
        String claimUuid = facts.get("claimUuid");
        Claim claim = GriefDefender.getCore().getClaimAt(p.getLocation());

        if (claim == null) {
            return false;
        }

        return claim.getUniqueId().equals(UUID.fromString(claimUuid));
    }

    @Override
    public ArrayList<NeededValue<?>> getNeededValues() {
        ArrayList<NeededValue<?>> values = new ArrayList<>();

        values.add(new NeededValue<>(
                "claimUuid",
                "Claim UUID",
                String.class,
                ""));

        return values;
    }

    @Override
    public void execute(Facts facts) {
    }

    @Override
    public int compareTo(@NotNull Rule o) {
        return 0;
    }
}
