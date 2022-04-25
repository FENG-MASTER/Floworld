package com.fengmaster.game.floworld.base.obj.entity;


import com.almasb.fxgl.dsl.FXGL;
import com.fengmaster.game.floworld.base.Game;
import com.fengmaster.game.floworld.base.world.Point3D;
import com.fengmaster.game.floworld.base.world.Vector3D;
import lombok.Getter;
import lombok.Setter;

/**
 * 物理对象
 */
public class PhysicsEntity extends BaseGameEntity {

    /**
     * 位置
     */
    @Getter
    private Point3D cellCenter;

    /**
     * 身体结构
     */
    @Getter
    @Setter
    private Point3D[] relativeBody;


    /**
     * 加速度
     */
    private double acceleratedSpeed;

    private Vector3D acceleratedSpeedDirection;

    /**
     * 速度
     */
    private double speed;

    private Vector3D speedDirection;

    /**
     * 体积 立方米
     */
    @Getter
    @Setter
    private double volume;
    /**
     * 物理质量 千克
     */
    @Getter
    @Setter
    private double mass;

    @Setter
    @Getter
    private boolean ignoreGravityEffect;



    /**
     * 比热容 是指没有相变化和化学变化时，1kg均相物质温度升高1K所需的热量
     *
     * 默认是水的比热容
     */
    @Getter
    private int specificHeatCapacity=4200;

    public PhysicsEntity(){
        relativeBody=new Point3D[1];
        relativeBody[0]=new Point3D(0,0,0);
    }

    /**
     * 密度 kg/m3
     * @return
     */
    public double getDensity(){
        if (volume==0){
            return 0;
        }
        return mass/volume;
    }


    public void setCellCenter(Point3D cellCenter) {
        this.cellCenter = cellCenter;
        this.setPosition3D(Game.getInstance().getGameOption().getCellSize()* cellCenter.getX(),Game.getInstance().getGameOption().getCellSize()* cellCenter.getY(),Game.getInstance().getGameOption().getCellSize()* cellCenter.getZ());
        this.setZIndex(Math.toIntExact(cellCenter.getZ()));
        //        this.setPosition(Game.getInstance().getGameOption().getCellSize()* cellCenter.getX(),Game.getInstance().getGameOption().getCellSize()* cellCenter.getY());
    }

    public void setTexture(String texture){
        this.getViewComponent().addChild(FXGL.getAssetLoader().loadTexture(texture,20,20));
    }
}
