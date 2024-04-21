package me.playbosswar.griefdefenderconditions;

import me.playbosswar.com.api.ConditionExtension;
import me.playbosswar.com.api.ConditionRules;
import me.playbosswar.com.api.events.EventExtension;
import me.playbosswar.griefdefenderconditions.conditions.*;
import me.playbosswar.griefdefenderconditions.events.ClaimCreateEventExtension;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

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
        return "1.1.0";
    }

    public @NotNull ConditionRules getRules() {
        return rules;
    }

    public ArrayList<EventExtension> getEvents() {
        ArrayList<EventExtension> events = new ArrayList<>();
        events.add(new ClaimCreateEventExtension(this));

        return events;
    }
}
