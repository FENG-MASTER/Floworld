package com.fengmaster.game.floworld.base.obj.factory;

import com.almasb.fxgl.entity.Spawns;
import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import com.fengmaster.game.floworld.base.obj.entity.gaseous.Fire;
import com.fengmaster.game.floworld.base.world.Point3D;
import com.fengmaster.game.floworld.util.CellUtil;
import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

public class GeneralEntitySpawnFactory extends BaseSpawnFactory{

    private Class<? extends BaseGameEntity> clazz;

    private Constructor<? extends BaseGameEntity> constructor;

    public GeneralEntitySpawnFactory(Class<? extends BaseGameEntity> clazz){
        this.clazz=clazz;
        try {
            constructor = clazz.getConstructor(BaseSpawnData.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return clazz.getSimpleName();
    }


    @SneakyThrows
    @Spawns()
    public BaseGameEntity spawn(BaseSpawnData spawnData){
        BaseGameEntity gameEntity= constructor.newInstance(spawnData);

        Point3D cellP;
        if (spawnData.getCellPosition()!=null){
            //使用cell坐标
            cellP=spawnData.getCellPosition();
        }else {
            //使用默认坐标
            cellP= CellUtil.getCellPoint3D(new javafx.geometry.Point3D(spawnData.getX(),spawnData.getY(),spawnData.getZ()));
        }

        gameEntity.setCellCenter(cellP);
        gameEntity.setWorldName(spawnData.getWorldName());

        return gameEntity;
    }

}
