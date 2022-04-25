package com.fengmaster.game.floworld.base.obj.entity.fluid;

import com.fengmaster.game.floworld.base.obj.entity.PhysicsEntity;

/**
 * 氧气
 */
public class Oxygen extends PhysicsEntity {

    public Oxygen(){
        this.setName("Oxygen");
        this.setVolume(1);
        this.setMass(1.29);
    }
}
