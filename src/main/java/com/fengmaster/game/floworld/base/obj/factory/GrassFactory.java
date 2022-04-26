package com.fengmaster.game.floworld.base.obj.factory;

import cn.hutool.core.util.RandomUtil;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import com.fengmaster.game.floworld.base.obj.entity.PhysicsEntity;
import com.fengmaster.game.floworld.base.obj.entity.solid.Grass;
import com.fengmaster.game.floworld.base.obj.entity.solid.Soil;
import com.fengmaster.game.floworld.base.world.Point3D;
import com.fengmaster.game.floworld.util.CellUtil;


public class GrassFactory extends BaseSpawnFactory {

    @Spawns("grass")
    public Grass spawn(BaseSpawnData spawnData){
        Grass grass= new Grass();

        Point3D cellP;
        if (spawnData.getCellPosition()!=null){
            //使用cell坐标
            cellP=spawnData.getCellPosition();
        }else {
            //使用默认坐标
            cellP=CellUtil.getCellPoint3D(new javafx.geometry.Point3D(spawnData.getX(),spawnData.getY(),spawnData.getZ()));
        }

        grass.setCellCenter(cellP);
        grass.setWorldName(spawnData.getWorldName());

        return grass;
    }

}
