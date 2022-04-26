package com.fengmaster.game.floworld.base.obj.factory;

import com.almasb.fxgl.entity.Spawns;
import com.fengmaster.game.floworld.base.obj.entity.gaseous.Fire;
import com.fengmaster.game.floworld.base.obj.entity.solid.Grass;
import com.fengmaster.game.floworld.base.world.Point3D;
import com.fengmaster.game.floworld.util.CellUtil;

public class FireFactory  extends BaseSpawnFactory{

    @Spawns("fire")
    public Fire spawn(BaseSpawnData spawnData){
        Fire fire= new Fire(300);

        Point3D cellP;
        if (spawnData.getCellPosition()!=null){
            //使用cell坐标
            cellP=spawnData.getCellPosition();
        }else {
            //使用默认坐标
            cellP= CellUtil.getCellPoint3D(new javafx.geometry.Point3D(spawnData.getX(),spawnData.getY(),spawnData.getZ()));
        }

        fire.setCellCenter(cellP);
        fire.setWorldName(spawnData.getWorldName());

        return fire;
    }
}
