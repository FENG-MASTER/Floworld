package com.fengmaster.game.floworld.base.world;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.almasb.fxgl.dsl.FXGL;
import com.fengmaster.game.floworld.base.TimeCenter;
import com.fengmaster.game.floworld.base.event.TickEvent;
import com.fengmaster.game.floworld.base.event.WorldCreatedEvent;
import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import com.fengmaster.game.floworld.base.world.gen.BaseWorldGenerator;
import com.fengmaster.game.floworld.base.world.node.WorldNode;
import lombok.Getter;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 世界对象
 */
@Log
public class World {

    @Getter
    private String name ;

    private long length=10;
    private long width=10;
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


    public World(String name ,BaseWorldGenerator worldGenerator){
        this.name=name;
        TimeInterval timer = DateUtil.timer();
        log.info("开始生成地图");
        timer.start();
        worldNodeMap=worldGenerator.generateWorldNode(this);
        gameObjectMap=worldGenerator.generateObj(this);

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


    public List<BaseGameEntity> getWorldObject(long x, long y, long z){
        return gameObjectMap.get(z).get(x).get(y);
    }

    public List<BaseGameEntity> getWorldObject(Point3D point3D){
        return gameObjectMap.get(point3D.getZ()).get(point3D.getX()).get(point3D.getY());
    }

    public WorldNode getWorldNode(Point3D point3D){
        return worldNodeMap.get(point3D.getZ()).get(point3D.getX()).get(point3D.getY());
    }

}
