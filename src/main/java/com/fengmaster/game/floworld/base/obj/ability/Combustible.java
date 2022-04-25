package com.fengmaster.game.floworld.base.obj.ability;

import com.almasb.fxgl.dsl.FXGL;
import com.fengmaster.game.floworld.base.Game;
import com.fengmaster.game.floworld.base.event.TickEvent;
import com.fengmaster.game.floworld.base.obj.BaseGameEntity;
import com.fengmaster.game.floworld.base.obj.compoents.BaseGameCompoent;
import javafx.event.EventHandler;
import lombok.Getter;

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
     * 可燃烧时间
     */
    private double burnTime;

    /**
     * 剩余可燃烧时间
     */
    private double remainingBurnTime;

    /**
     * 是否已经点燃
     */
    @Getter
    private boolean isBurning;

    /**
     * 上次燃烧时间
     */
    private long lastBurnTime;


    public Combustible(double burnPoint,double burnTime){
        this.burnPoint=burnPoint;
        this.burnTime=burnTime;
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
            long burnTime = tickEvent.getTime() - lastBurnTime;
            remainingBurnTime-=burnTime;
            if(remainingBurnTime<0){
                //烧完了，游戏物体销毁
                this.getParentGameEntity().removeFromWorld();
            }
        }
    }
}
