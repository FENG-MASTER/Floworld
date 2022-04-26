package com.fengmaster.game.floworld.base.obj.factory;

import com.almasb.fxgl.entity.SpawnData;
import com.fengmaster.game.floworld.base.world.Point3D;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class BaseSpawnData extends SpawnData {

    @Getter
    @Setter
    private Point3D cellPosition;


    @Getter
    @Setter
    private String worldName;

}
