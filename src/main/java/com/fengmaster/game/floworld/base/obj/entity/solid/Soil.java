package com.fengmaster.game.floworld.base.obj.entity.solid;

import com.fengmaster.game.floworld.base.obj.entity.PhysicsEntity;

public class Soil extends PhysicsEntity {


    public Soil() {
        this.setName("Soil");
        this.setMass(3000);
        this.setVolume(1);
        setTexture("obj/soil.png");
    }
}
