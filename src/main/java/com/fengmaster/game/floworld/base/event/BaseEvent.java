package com.fengmaster.game.floworld.base.event;

import javafx.event.Event;
import javafx.event.EventType;
import lombok.Data;

public abstract class BaseEvent extends javafx.event.Event{

    /**
     * 发送者
     */
    private Object sender;

    public BaseEvent(EventType eventType, Object sender) {
        super(eventType);
        this.sender=sender;
    }




}
