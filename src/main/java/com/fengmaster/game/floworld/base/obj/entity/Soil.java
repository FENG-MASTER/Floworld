package com.fengmaster.game.floworld.base.obj.entity;

import com.almasb.fxgl.dsl.FXGL;
import com.fengmaster.game.floworld.base.constant.AttributeKeyEnum;
import com.fengmaster.game.floworld.base.obj.PhysicsComponent;
import com.fengmaster.game.floworld.base.obj.display.DisplayComponent;
import com.fengmaster.game.floworld.base.obj.display.RandomDisplayComponent;

public class Soil extends PhysicsComponent {


    public Soil() {
        this.setName("Soil");
        this.setMass(3000);
        this.setVolume(1);
        DisplayComponent displayComponent=new RandomDisplayComponent();
        addComponent(AttributeKeyEnum.TEXTURE.name(),displayComponent);
        displayComponent.addTexture("obj/soil.png");
    }
}
