package com.fengmaster.game.floworld.base.event;

import com.fengmaster.game.floworld.base.world.World;
import javafx.event.EventType;
import lombok.Getter;

public abstract class BaseWorldEvent extends BaseEvent{
    @Getter
    private long time;
    @Getter
    private World world;

    public BaseWorldEvent(EventType eventType,long time, Object sender, World world) {
        super(eventType, sender);
        this.time=time;
        this.world=world;
    }
}
