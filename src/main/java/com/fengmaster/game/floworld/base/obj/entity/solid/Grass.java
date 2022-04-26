package com.fengmaster.game.floworld.base.obj.entity.solid;

import cn.hutool.core.util.RandomUtil;
import com.fengmaster.game.floworld.base.obj.compoents.ability.Combustible;
import com.fengmaster.game.floworld.base.obj.entity.PhysicsEntity;
import com.fengmaster.game.floworld.base.obj.factory.BaseSpawnData;

public class Grass extends PhysicsEntity {

    public Grass(BaseSpawnData baseSpawnData){
        super(baseSpawnData);
        this.setName("Grass");
        this.setMass(3000);
        this.setVolume(1);
        if (RandomUtil.getRandom().nextBoolean()){
            setTexture("obj/grass1.png");
        }else {
            setTexture("obj/grass2.png");
        }
        addComponent(new Combustible(40,100,800000));
    }

    public Grass(){
        this(null);
    }


}
