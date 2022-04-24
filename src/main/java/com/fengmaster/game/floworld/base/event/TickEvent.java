package com.fengmaster.game.floworld.base.event;

import com.fengmaster.game.floworld.base.world.World;

/**
 * 时间流逝事件
 */
public class TickEvent extends BaseWorldEvent {

    public TickEvent(long time, Object sender, World world) {
        super(EventCenter.TYPE.TICK_EVENT,time, sender, world);
    }
}
