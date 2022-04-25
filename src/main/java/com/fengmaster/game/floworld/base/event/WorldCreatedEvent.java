package com.fengmaster.game.floworld.base.event;

import com.fengmaster.game.floworld.base.world.World;
import javafx.event.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 世界生成事件
 */
public class WorldCreatedEvent extends BaseEvent{

    public static EventType<WorldCreatedEvent> WORLD_CREATED_EVENT=new EventType<>(EventType.ROOT,"WorldCreatedEvent");


    @Getter
    private World world;


    public WorldCreatedEvent(World world) {
        super(WORLD_CREATED_EVENT,world);

    }
}
