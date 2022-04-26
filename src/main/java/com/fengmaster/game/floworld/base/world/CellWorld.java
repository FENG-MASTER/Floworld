package com.fengmaster.game.floworld.base.world;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityWorldListener;
import com.fengmaster.game.floworld.base.TimeCenter;
import com.fengmaster.game.floworld.base.event.TickEvent;
import com.fengmaster.game.floworld.base.event.WorldCreatedEvent;
import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import com.fengmaster.game.floworld.base.world.gen.BaseWorldGenerator;
import com.fengmaster.game.floworld.base.world.node.WorldNode;
import lombok.Getter;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 世界对象
 */
@Log
public class CellWorld implements EntityWorldListener {

    @Getter
    private String name ;

    @Getter
    private long length=10;
    @Getter
    private long width=10;
    @Getter
    private long height=10;

    @Getter
    private TimeCenter timeCenter;

    /**
     * z,x,y地图节点
     */
    private Map<Long,Map<Long,Map<Long, WorldNode>>> worldNodeMap =new HashMap<>();

    //  z,x,y地图
    @Getter
    private Map<Long,Map<Long,Map<Long, List<BaseGameEntity>>>> gameObjectMap =new HashMap<>();


    public CellWorld(String name , BaseWorldGenerator worldGenerator){
        this.name=name;
        TimeInterval timer = DateUtil.timer();
        FXGL.getGameWorld().addWorldListener(this);
        log.info("开始生成地图");
        timer.start();
        worldNodeMap=worldGenerator.generateWorldNode(this);


        for (long z = 0; z < height; z++) {
            gameObjectMap.put(z, new HashMap<>());
            for (long x = 0; x < length; x++) {
                gameObjectMap.get(z).put(x, new HashMap<>());

                for (long y = 0; y < width; y++) {
                    gameObjectMap.get(z).get(x).put(y, new ArrayList<>());

                }

            }
        }

        worldGenerator.generateObj(this);

        log.info("生成地图完毕，耗时"+timer.intervalSecond()+"秒");

        timeCenter=new TimeCenter();

        FXGL.getEventBus().fireEvent(new WorldCreatedEvent(this));
    }


    public void start(){
        timeCenter.start("2020-01-01T00:00:00");
    }

    public void tick(){
        timeCenter.next();
        FXGL.getEventBus().fireEvent(new TickEvent(timeCenter.getTime(),this,this));
    }


    public List<BaseGameEntity> getWorldObjectByCell(long x, long y, long z){
        return gameObjectMap.get(z).get(x).get(y);
    }

    public List<BaseGameEntity> getWorldObjectByCell(Point3D point3D){
        return gameObjectMap.get(point3D.getZ()).get(point3D.getX()).get(point3D.getY());
    }

    public WorldNode getWorldNode(Point3D point3D){
        return worldNodeMap.get(point3D.getZ()).get(point3D.getX()).get(point3D.getY());
    }


    @Override
    public void onEntityAdded(Entity entity) {
        if (entity instanceof BaseGameEntity){
            BaseGameEntity baseGameEntity= (BaseGameEntity) entity;
            List<BaseGameEntity> list = gameObjectMap.get(baseGameEntity.getCellCenter().getZ() / 20)
                    .get(baseGameEntity.getCellCenter().getX())
                    .get(baseGameEntity.getCellCenter().getY());
            if (!list.contains(baseGameEntity)){
                list.add(baseGameEntity);
            }

        }

    }

    @Override
    public void onEntityRemoved(Entity entity) {
        if (entity instanceof BaseGameEntity){
            BaseGameEntity baseGameEntity= (BaseGameEntity) entity;
            gameObjectMap.get(baseGameEntity.getCellCenter().getZ())
                    .get(baseGameEntity.getCellCenter().getX())
                    .get(baseGameEntity.getCellCenter().getY())
                    .remove(baseGameEntity);
        }
    }
}
