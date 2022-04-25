package com.fengmaster.game.floworld.base.obj.entity;

import com.fengmaster.game.floworld.base.constant.AttributeKeyEnum;
import com.fengmaster.game.floworld.base.event.TickEvent;
import com.fengmaster.game.floworld.base.obj.BaseGameEntity;
import com.fengmaster.game.floworld.base.obj.PhysicsEntity;
import com.fengmaster.game.floworld.base.obj.ability.Combustible;
import com.fengmaster.game.floworld.base.obj.fluid.Oxygen;
import com.fengmaster.game.floworld.base.world.node.WorldNode;
import com.fengmaster.game.floworld.base.Game;

import lombok.Getter;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 火
 */
public class Fire extends PhysicsEntity {

    /**
     * 火势情况
     */
    @Getter
    private double spread;

    public Fire() {
        //小火焰
        this.setName("Fire");
        this.setVolume(0.001);
        setTexture("obj/fire.png");
    }

    public void setSpread(double spread){
        this.spread=spread;
        this.setVolume(spread);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void tick(TickEvent tickEvent){
        if (spread>=1){
            //开始扩撒,向四周八个格子扩散，生成小火种

        }else {
            //检查是否可以增大火势
            List<BaseGameEntity> centerCellObjs = Game.getInstance().getWorld(getWorldName()).getWorldObject(getCellCenter());
            //氧气
            List<Oxygen> oxygens = centerCellObjs.stream().filter(baseGameComponent -> baseGameComponent instanceof Oxygen)
                    .map(baseGameComponent -> (Oxygen) baseGameComponent).collect(Collectors.toList());

            WorldNode worldNode = Game.getInstance().getWorld(getWorldName()).getWorldNode(this.getCellCenter());
            for (BaseGameEntity gameEntity : centerCellObjs) {
                if (gameEntity.hasComponent(Combustible.class)){
                    //物品属于可燃物
                    Combustible combustible = gameEntity.getComponent(Combustible.class);
                    if(combustible.isBurning() ){
                            //可燃物，并且已经着了
//                        if (CollectionUtil.isNotEmpty(oxygens)||oxygens.stream().map(new Func).count()<=0){
//                            //一点氧气都没用了
//                            combustible.unBurn();
//                        }

                    }else if(combustible.getBurnPoint()<worldNode.getTemperature()) {
                            //没有点着，但是温度已经达到燃点

                    }

                }
            }

        }

    }


}
