package com.fengmaster.game.floworld.base.event;

import com.fengmaster.game.floworld.base.world.CellWorld;
import javafx.event.EventType;

/**
 * 时间流逝事件
 */
public class TickEvent extends BaseWorldEvent {
    public static EventType<TickEvent> TICK_EVENT=new EventType<>(EventType.ROOT,"tickEvent");

    public TickEvent(long time, Object sender, CellWorld cellWorld) {
        super(TICK_EVENT,time, sender, cellWorld);
    }
}
