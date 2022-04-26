package com.fengmaster.game.floworld.base.obj.entity.solid;

import com.fengmaster.game.floworld.base.obj.entity.PhysicsEntity;
import com.fengmaster.game.floworld.base.obj.factory.BaseSpawnData;

/**
 * 石子
 */
public class Cobble extends PhysicsEntity {

    public Cobble(BaseSpawnData baseSpawnData){
        super(baseSpawnData);
        this.setName("Cobble");
        this.setMass(3000);
        this.setVolume(1);
        setTexture("obj/cobble1.png");
    }

    public Cobble(){
        this(null);
    }
}
