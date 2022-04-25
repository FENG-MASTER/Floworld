package com.fengmaster.game.floworld.base.obj.entity;

import com.fengmaster.game.floworld.base.obj.PhysicsEntity;

public class Soil extends PhysicsEntity {


    public Soil() {
        this.setName("Soil");
        this.setMass(3000);
        this.setVolume(1);
        setTexture("obj/soil.png");
    }
}
