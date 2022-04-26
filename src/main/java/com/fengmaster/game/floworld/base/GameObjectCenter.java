package com.fengmaster.game.floworld.base;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Spawns;
import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class GameObjectCenter {

    @Getter
    private  Map<String, BaseGameEntity> uuid2ObjectMap =new HashMap<>();

    public void addObject(BaseGameEntity baseGameEntity){
        uuid2ObjectMap.put(baseGameEntity.getUuid(), baseGameEntity);
    }

    public void removeObject(String uuid){
        uuid2ObjectMap.remove(uuid);
    }

}
