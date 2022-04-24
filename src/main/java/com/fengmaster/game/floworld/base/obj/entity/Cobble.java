package com.fengmaster.game.floworld.base.obj.entity;

import com.fengmaster.game.floworld.base.constant.AttributeKeyEnum;
import com.fengmaster.game.floworld.base.obj.PhysicsComponent;
import com.fengmaster.game.floworld.base.obj.display.DisplayComponent;
import com.fengmaster.game.floworld.base.obj.display.RandomDisplayComponent;

/**
 * 石子
 */
public class Cobble extends PhysicsComponent {

    public Cobble(){
        this.setName("Cobble");
        this.setMass(3000);
        this.setVolume(1);
        DisplayComponent displayComponent=new RandomDisplayComponent();
        addComponent(AttributeKeyEnum.TEXTURE.name(),displayComponent);

        displayComponent.addTexture("obj/cobble1.png");
    }
}
