package com.fengmaster.game.floworld.base.obj.factory;

import com.almasb.fxgl.entity.Spawns;
import com.fengmaster.game.floworld.base.obj.entity.solid.Grass;
import com.fengmaster.game.floworld.base.obj.entity.solid.Soil;
import com.fengmaster.game.floworld.base.world.Point3D;
import com.fengmaster.game.floworld.util.CellUtil;

public class SoilFactory extends BaseSpawnFactory {

    @Spawns("soil")
    public Soil spawn(BaseSpawnData spawnData){
        Soil soil= new Soil();

        Point3D cellP;
        if (spawnData.getCellPosition()!=null){
            //使用cell坐标
            cellP=spawnData.getCellPosition();
        }else {
            //使用默认坐标
            cellP= CellUtil.getCellPoint3D(new javafx.geometry.Point3D(spawnData.getX(),spawnData.getY(),spawnData.getZ()));
        }

        soil.setCellCenter(cellP);
        soil.setWorldName(spawnData.getWorldName());

        return soil;
    }
}
