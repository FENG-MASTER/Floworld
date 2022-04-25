package com.fengmaster.game.floworld.base.obj.entity;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.component.ComponentListener;
import com.fengmaster.game.floworld.base.Game;
import com.fengmaster.game.floworld.base.obj.compoents.BaseGameCompoent;
import lombok.Getter;

import java.util.*;

/**
 * 游戏对象基类
 */
public class BaseGameEntity extends Entity implements ComponentListener {

    @Getter
    @Deprecated
    private String worldName;

    /**
     * ID
     */
    @Getter
    private String uuid;
    /**
     * 名称
     */
    private String name;

    private Map<String, List<BaseGameEntity>> components;





    public BaseGameEntity(){
        uuid=UUID.randomUUID().toString();
        components=new HashMap<>();
        Game.getInstance().getGameObjectCenter().addObject(this);
        this.addComponentListener(this);
    }

    public void tick(long tick) {

    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
        //TODO :默认情况下，会将其他组件都设置成同一个世界ID

    }


    @Override
    public void onAdded(Component component) {
        if (component instanceof BaseGameCompoent){
            ((BaseGameCompoent)component).setParentGameEntity(this);
        }
    }

    @Override
    public void onRemoved(Component component) {

    }
}
