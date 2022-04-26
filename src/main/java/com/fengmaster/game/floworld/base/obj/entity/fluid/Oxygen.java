package com.fengmaster.game.floworld.base.obj.entity.fluid;

import com.fengmaster.game.floworld.base.obj.entity.PhysicsEntity;
import com.fengmaster.game.floworld.base.obj.factory.BaseSpawnData;

/**
 * 氧气
 */
public class Oxygen extends PhysicsEntity {

    public Oxygen(BaseSpawnData baseSpawnData){
        super(baseSpawnData);
        this.setName("Oxygen");
        this.setVolume(1);
        this.setMass(1.29);
    }

    public Oxygen(){
        this(null);
    }
}
