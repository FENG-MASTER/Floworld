package com.fengmaster.game.floworld.base.obj.entity;

import cn.hutool.core.util.RandomUtil;
import com.fengmaster.game.floworld.base.obj.PhysicsEntity;

public class Grass extends PhysicsEntity {

    public Grass(){
        this.setName("Grass");
        this.setMass(3000);
        this.setVolume(1);
        if (RandomUtil.getRandom().nextBoolean()){
            setTexture("obj/grass1.png");
        }else {
            setTexture("obj/grass2.png");
        }
    }


}
