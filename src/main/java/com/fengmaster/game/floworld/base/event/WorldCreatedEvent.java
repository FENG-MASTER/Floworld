package com.fengmaster.game.floworld.base.event;

import com.fengmaster.game.floworld.base.world.World;
import javafx.event.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 世界生成事件
 */
public class WorldCreatedEvent extends BaseEvent{
    @Getter
    private World world;


    public WorldCreatedEvent(World world) {
        super(EventCenter.TYPE.WORLD_CREATED_EVENT,world);

    }
}
