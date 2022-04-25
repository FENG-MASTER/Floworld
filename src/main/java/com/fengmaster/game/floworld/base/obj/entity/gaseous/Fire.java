package com.fengmaster.game.floworld.base.obj.entity.gaseous;

import cn.hutool.core.util.RandomUtil;
import com.almasb.fxgl.dsl.FXGL;
import com.fengmaster.game.floworld.base.event.TickEvent;
import com.fengmaster.game.floworld.base.obj.compoents.ability.Combustible;
import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import com.fengmaster.game.floworld.base.obj.entity.PhysicsEntity;
import com.fengmaster.game.floworld.base.obj.entity.fluid.Oxygen;
import com.fengmaster.game.floworld.base.world.Point3D;
import com.fengmaster.game.floworld.base.world.World;
import com.fengmaster.game.floworld.base.world.node.WorldNode;
import com.fengmaster.game.floworld.base.Game;

import com.fengmaster.game.floworld.util.CellUtil;
import com.fengmaster.game.floworld.util.GameTimeUtil;
import javafx.event.EventHandler;
import lombok.Getter;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 火
 *
 * 火只负责点燃可燃物，燃烧实际代码在可燃物内
 */
public class Fire extends PhysicsEntity implements EventHandler<TickEvent> {

    /**
     * 持续时间 s
     */
    private int duration;

    /**
     * 剩余燃烧时间 s
     */
    private int timeLeft;

    private long lastTick;

    /**
     * 火势情况
     */
    @Getter
    private double spread;

    public Fire(int duration) {
        //小火焰
        this.duration=duration;
        this.timeLeft=duration;
        this.setName("Fire");
        this.setVolume(0.001);
        setTexture("obj/fire.png");

        FXGL.getEventBus().addEventHandler(TickEvent.TICK_EVENT,this);

    }

    public void setSpread(double spread){
        this.spread=spread;
        this.setVolume(spread);
    }

    private void tick(TickEvent tickEvent){
        if (lastTick==0){
            lastTick=tickEvent.getTime();
        }



        if (spread>=1){
            //开始扩撒,向四周6个格子扩散，生成小火种

            Point3D[] nearbyPoint = CellUtil.getNearbyPoint(getCellCenter());
            World world = Game.getInstance().getWorld(getWorldName());
            for (Point3D np : nearbyPoint) {
                if (!CellUtil.mapContain(np,world.getLength(),world.getWidth(),world.getHeight())){
                    continue;
                }
                PhysicsEntity fire = new Fire(RandomUtil.randomInt(100));
                fire.setCellCenter(np);
                fire.setWorldName(this.getWorldName());
                world.addEntity(fire);
            }
            spread=0;

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
                    if(combustible.isBurning()){
                        //可燃物已经点燃的逻辑代码在可燃物里视线
                        return;
                    }else if(combustible.getBurnPoint()<worldNode.getTemperature()) {
                            //没有点着，但是温度已经达到燃点
                            combustible.burn();
                    }


                    //没有点燃可燃物，则让温度上升，这样才能点燃可燃物
                    worldNode.addTemperature(0.5);




                }
            }

        }

        timeLeft-= GameTimeUtil.tick2Sec(tickEvent.getTime()-lastTick);
        spread+=0.05;
        lastTick=tickEvent.getTime();
        if (timeLeft<=0){
            removeFromWorld();
            return;

        }

    }


    @Override
    public void handle(TickEvent event) {
        tick(event);
    }
}
