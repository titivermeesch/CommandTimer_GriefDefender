package me.playbosswar.griefdefenderconditions.events;

import com.griefdefender.api.GriefDefender;
import com.griefdefender.api.event.CreateClaimEvent;
import me.playbosswar.com.CommandTimerPlugin;
import me.playbosswar.com.api.ConditionExtension;
import me.playbosswar.com.api.NeededValue;
import me.playbosswar.com.api.events.EventExtension;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ClaimCreateEventExtension extends EventExtension {
    private final ConditionExtension extension;

    public ClaimCreateEventExtension(ConditionExtension extension) {
        this.extension = extension;
        GriefDefender.getEventManager().getBus().subscribe(CreateClaimEvent.class, e -> {
            ArrayList<NeededValue<?>> values = new ArrayList<>();
            values.add(new NeededValue<>("CLAIM_NAME", "Claim name", String.class, e.getClaim().getDisplayName()));
            CommandTimerPlugin.getInstance().getEventsManager().handleTriggeredEvent(extension, this, values);
        });
    }

    @Override
    public @NotNull String getEventName() {
        return "CLAIM_CREATED";
    }

    @Override
    public @NotNull String[] getEventDescription() {
        return new String[0];
    }

    @Override
    public ArrayList<NeededValue<?>> getReturnedValues() {
        return null;
    }
}
