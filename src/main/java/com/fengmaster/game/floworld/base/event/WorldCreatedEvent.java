package com.fengmaster.game.floworld.base.event;

import com.fengmaster.game.floworld.base.world.CellWorld;
import javafx.event.EventType;
import lombok.Getter;

/**
 * 世界生成事件
 */
public class WorldCreatedEvent extends BaseEvent{

    public static EventType<WorldCreatedEvent> WORLD_CREATED_EVENT=new EventType<>(EventType.ROOT,"WorldCreatedEvent");


    @Getter
    private CellWorld cellWorld;


    public WorldCreatedEvent(CellWorld cellWorld) {
        super(WORLD_CREATED_EVENT, cellWorld);

    }
}
