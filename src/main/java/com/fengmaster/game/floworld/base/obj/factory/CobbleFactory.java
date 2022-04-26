package com.fengmaster.game.floworld.base.obj.factory;

import com.almasb.fxgl.entity.Spawns;
import com.fengmaster.game.floworld.base.obj.entity.solid.Cobble;
import com.fengmaster.game.floworld.base.obj.entity.solid.Grass;
import com.fengmaster.game.floworld.base.world.Point3D;
import com.fengmaster.game.floworld.util.CellUtil;

public class CobbleFactory extends BaseSpawnFactory{

    @Spawns("cobble")
    public Cobble spawn(BaseSpawnData spawnData){
        Cobble cobble= new Cobble();

        Point3D cellP;
        if (spawnData.getCellPosition()!=null){
            //使用cell坐标
            cellP=spawnData.getCellPosition();
        }else {
            //使用默认坐标
            cellP= CellUtil.getCellPoint3D(new javafx.geometry.Point3D(spawnData.getX(),spawnData.getY(),spawnData.getZ()));
        }

        cobble.setCellCenter(cellP);
        cobble.setWorldName(spawnData.getWorldName());

        return cobble;
    }
}
