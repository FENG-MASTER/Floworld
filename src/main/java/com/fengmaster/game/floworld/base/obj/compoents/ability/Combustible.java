package com.fengmaster.game.floworld.base.obj.compoents.ability;

import cn.hutool.core.collection.CollectionUtil;
import com.almasb.fxgl.dsl.FXGL;
import com.fengmaster.game.floworld.base.Game;
import com.fengmaster.game.floworld.base.event.TickEvent;
import com.fengmaster.game.floworld.base.obj.compoents.BaseGameCompoent;
import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import com.fengmaster.game.floworld.base.obj.entity.PhysicsEntity;
import com.fengmaster.game.floworld.base.obj.entity.fluid.Oxygen;
import com.fengmaster.game.floworld.base.world.node.WorldNode;
import com.fengmaster.game.floworld.util.GameTimeUtil;
import com.fengmaster.game.floworld.util.HeatUtil;
import javafx.event.EventHandler;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 可燃的
 */
public class Combustible extends BaseGameCompoent implements  EventHandler<TickEvent>{

    /**
     * 燃点
     */
    @Getter
    private double burnPoint;
    /**
     * 可燃烧时间 秒
     */
    private int totalBurnTime;

    /**
     * 剩余可燃烧时间 秒
     */
    private int remainingBurnTime;

    /**
     * 是否已经点燃
     */
    @Getter
    private boolean isBurning;

    /**
     * 上次燃烧时间
     */
    private long lastBurnTime;

    /**
     * 热值
     * 定义 1千克某种固体（气体）燃料完全燃烧放出的热量称为该燃料的热值
     *  j/kg
     */
    @Getter
    private int calorific;


    public Combustible(double burnPoint, int totalBurnTime, int calorific){
        this.burnPoint=burnPoint;
        this.totalBurnTime = totalBurnTime;
        this.calorific = calorific;
        FXGL.getEventBus().addEventHandler(TickEvent.TICK_EVENT,this);
    }


    /**
     * 燃烧
     */
    public void burn(){

        lastBurnTime = Game.getInstance().getWorld(getParentGameEntity().getWorldName()).getTimeCenter().getTime();
        isBurning=true;
    }


    public void unBurn(){
        lastBurnTime=0;
        isBurning=false;
    }



    @Override
    public void handle(TickEvent tickEvent) {
        if (isBurning){
            long burnTick = tickEvent.getTime() - lastBurnTime;
            double burnSec=GameTimeUtil.tick2Sec(burnTick);
            remainingBurnTime-= burnSec;

            if (remainingBurnTime>0){
                //没烧完，升温
                if (getParentGameEntity() instanceof PhysicsEntity){

                    PhysicsEntity physicsP = (PhysicsEntity) getParentGameEntity();
                    WorldNode worldNode = Game.getInstance().getWorld(physicsP.getWorldName())
                            .getWorldNode(physicsP.getCellCenter());

                    //检查是否可以增大火势
                    List<BaseGameEntity> centerCellObjs = Game.getInstance().getWorld(physicsP.getWorldName()).getWorldObjectByCell(physicsP.getCellCenter());
                    //氧气
                    List<Oxygen> oxygens = centerCellObjs.stream().filter(baseGameComponent -> baseGameComponent instanceof Oxygen)
                            .map(baseGameComponent -> (Oxygen) baseGameComponent).collect(Collectors.toList());



                    if (CollectionUtil.isEmpty(oxygens)||
                            oxygens.stream().mapToDouble(PhysicsEntity::getVolume).sum()<=0){
                        //没有氧气
                        unBurn();
                        return;
                    }


                    //提升环境温度

                    //计算本次产生的热量
                    double heat = burnSec * ((double)calorific / totalBurnTime);
                    //FIXME 每个格子1立方空气
                    worldNode.addTemperature(HeatUtil.heatDissipation2AirTemperatureRise(heat,1.29f));

                }
            }else {
                //烧完了，游戏物体销毁
                this.getParentGameEntity().removeFromWorld();
            }





        }
    }
}
