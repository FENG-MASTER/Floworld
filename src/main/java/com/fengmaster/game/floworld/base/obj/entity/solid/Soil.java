package com.fengmaster.game.floworld.base.obj.entity.solid;

import com.fengmaster.game.floworld.base.obj.entity.PhysicsEntity;
import com.fengmaster.game.floworld.base.obj.factory.BaseSpawnData;

public class Soil extends PhysicsEntity {



    public Soil(BaseSpawnData baseSpawnData) {
        super(baseSpawnData);
        this.setName("Soil");
        this.setMass(3000);
        this.setVolume(1);
        setTexture("obj/soil.png");
    }

    public Soil(){
        this(null);
    }
}
