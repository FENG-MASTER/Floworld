package com.fengmaster.game.floworld.base.obj.display;

import com.almasb.fxgl.dsl.FXGL;
import com.fengmaster.game.floworld.base.obj.BaseGameComponent;
import com.fengmaster.game.floworld.base.obj.PhysicsComponent;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public abstract class DisplayComponent extends BaseGameComponent {

    @Getter
    @Setter
    protected double alpha;
    protected List<String> textures=new ArrayList<>();

    public void addTexture(String texture){
        textures.add(texture);
        if (this.getParentGameObject() instanceof PhysicsComponent){
            this.getParentGameObject().getViewComponent().addChild(FXGL.getAssetLoader().loadTexture(texture,20,20));
        }
    }

    public abstract String getTexture(Object o);


}
