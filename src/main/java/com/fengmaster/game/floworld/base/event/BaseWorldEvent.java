package com.fengmaster.game.floworld.base.event;

import com.fengmaster.game.floworld.base.world.CellWorld;
import javafx.event.EventType;
import lombok.Getter;

public abstract class BaseWorldEvent extends BaseEvent{
    @Getter
    private long time;
    @Getter
    private CellWorld cellWorld;

    public BaseWorldEvent(EventType eventType,long time, Object sender, CellWorld cellWorld) {
        super(eventType, sender);
        this.time=time;
        this.cellWorld = cellWorld;
    }
}
