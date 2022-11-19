package me.playbosswar.griefdefenderconditions;

import me.playbosswar.com.api.ConditionExtension;
import me.playbosswar.com.api.ConditionRules;
import me.playbosswar.griefdefenderconditions.conditions.*;
import org.jetbrains.annotations.NotNull;

public class CommandTimerGriefDefenderConditions extends ConditionExtension {
    ConditionRules rules = new ConditionRules();

    public CommandTimerGriefDefenderConditions() {
        rules.register(
                new IsInRegionCondition(),
                new IsInWildernessCondition(),
                new IsInTownCondition(),
                new IsInBasicClaim(),
                new IsInSubdivisionClaim(),
                new IsInAdminClaim()
        );
    }

    @Override
    public @NotNull String getConditionGroupName() {
        return "GRIEFDEFENDER";
    }

    @Override
    public @NotNull
    String[] getDescription() {
        return new String[]{"§7Look up GriefDefender data for certain conditions"};
    }

    @Override
    public @NotNull String getAuthor() {
        return "PlayBossWar";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    public @NotNull ConditionRules getRules() {
        return rules;
    }
}
