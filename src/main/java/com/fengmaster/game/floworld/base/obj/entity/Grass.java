package com.fengmaster.game.floworld.base.obj.entity;

import cn.hutool.core.util.RandomUtil;
import com.fengmaster.game.floworld.base.constant.AttributeKeyEnum;
import com.fengmaster.game.floworld.base.obj.PhysicsComponent;
import com.fengmaster.game.floworld.base.obj.display.DisplayComponent;
import com.fengmaster.game.floworld.base.obj.display.RandomDisplayComponent;

public class Grass extends PhysicsComponent {

    public Grass(){
        this.setName("Grass");
        this.setMass(3000);
        this.setVolume(1);
        DisplayComponent displayComponent=new RandomDisplayComponent();
        addComponent(AttributeKeyEnum.TEXTURE.name(),displayComponent);

        if (RandomUtil.getRandom().nextBoolean()){
            displayComponent.addTexture("obj/grass1.png");
        }else {
            displayComponent.addTexture("obj/grass2.png");

        }
    }


}
