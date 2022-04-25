package com.fengmaster.game.floworld.base.obj.fluid;

import com.fengmaster.game.floworld.base.obj.PhysicsEntity;

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
