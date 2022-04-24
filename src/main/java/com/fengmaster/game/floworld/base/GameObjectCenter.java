package com.fengmaster.game.floworld.base;

import com.almasb.fxgl.dsl.FXGL;
import com.fengmaster.game.floworld.base.obj.BaseGameComponent;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class GameObjectCenter {

    @Getter
    private  Map<String, BaseGameComponent> uuid2ObjectMap =new HashMap<>();

    public void addObject(BaseGameComponent baseGameComponent){
        uuid2ObjectMap.put(baseGameComponent.getUuid(), baseGameComponent);
        FXGL.getGameWorld().addEntity(baseGameComponent);
    }

    public void removeObject(String uuid){
        uuid2ObjectMap.remove(uuid);
    }

}
