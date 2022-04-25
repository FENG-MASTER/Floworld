package com.fengmaster.game.floworld.base.obj.entity;

import com.fengmaster.game.floworld.base.obj.PhysicsEntity;

/**
 * 石子
 */
public class Cobble extends PhysicsEntity {

    public Cobble(){
        this.setName("Cobble");
        this.setMass(3000);
        this.setVolume(1);
        setTexture("obj/cobble1.png");

    }
}
