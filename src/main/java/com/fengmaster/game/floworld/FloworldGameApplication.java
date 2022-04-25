package com.fengmaster.game.floworld;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.Camera3D;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.InputModifier;
import com.almasb.fxgl.input.InputSequence;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.localization.Language;
import com.fengmaster.game.floworld.base.Game;
import com.fengmaster.game.floworld.base.obj.BaseGameComponent;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Map;

import static com.almasb.fxgl.dsl.FXGL.*;

@Log
public class FloworldGameApplication extends GameApplication {


    private long currentShowTick;

    private boolean nextTick;

    private String worldName;

    private int currentZ = 1;

    private int commandWaitTime = 5;


    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(720);
        gameSettings.setHeight(480);
        gameSettings.setTitle("Floworld");
//        gameSettings.setDefaultLanguage(Language.CHINESE);
        gameSettings.setVersion("0.1");

    }

    Entity entity;
    @Override
    protected void initGame() {
        Game.getInstance().init();
        worldName = "main";



//        Game.getInstance().getEventCenter().getWorldEventBus(worldName).register(this);

//
        entity= FXGL.entityBuilder().at(new Point2D(50, 50))
                .view(FXGL.getAssetLoader()
                        .loadTexture("obj/fire.png", 10, 10)).buildAndAttach();
//        getGameScene().getViewport().bindToEntity(entity, getAppWidth() / 2, getAppHeight() / 2);
//        for (Map.Entry<Long, Map<Long, Map<Long, List<BaseGameComponent>>>> entryZ : Game.getInstance().getWorld(worldName).getGameObjectMap().entrySet()) {
//            if (entryZ.getKey() > currentZ) {
//                continue;
//            }
//
//            Long z = entryZ.getKey();
//            for (Map.Entry<Long, Map<Long, List<BaseGameComponent>>> entryX : entryZ.getValue().entrySet()) {
//                Long x = entryX.getKey();
//                for (Map.Entry<Long, List<BaseGameComponent>> entryY : entryX.getValue().entrySet()) {
//                    Long y = entryY.getKey();
//
//                    for (BaseGameComponent gameComponent : entryY.getValue()) {
//                        if (!gameComponent.containsComponent(AttributeKeyEnum.TEXTURE.name()) || !gameComponent.getWorldName().equals(worldName)){
//                            continue;
//                        }
//
//                        DisplayComponent displayComponent = gameComponent.getComponent(AttributeKeyEnum.TEXTURE.name(), DisplayComponent.class).get(0);
//
//                        if ( !(gameComponent instanceof PhysicsComponent)){
//                            continue;
//                        }
//                        Point3D point3D = ((PhysicsComponent)(gameComponent)).getCenter();
//
//                        if (guiCam.unproject(new Vector3(point3D.getX() * 20, point3D.getY() * 20, 0)).x > 0
//                                && guiCam.unproject(new Vector3(point3D.getX() * 20, point3D.getY() * 20, 0)).x < 480
//                                && guiCam.unproject(new Vector3(point3D.getX() * 20, point3D.getY() * 20, 0)).y < 320
//                                && guiCam.unproject(new Vector3(point3D.getX() * 20, point3D.getY() * 20, 0)).y > 0) {
////                                越靠前当前层，越清楚
//
//
//                            batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, 1 - ((float) currentZ - point3D.getZ()) / 5);
//                            batch.draw(TextureCenter.getTexture(displayComponent.getTexture(null)), point3D.getX() * 20, point3D.getY() * 20, 20, 20);
//                        }
//
//
//                    }
//
//                }
//
//
//            }
//
//
//        }


    }

    @Override
    protected void onUpdate(double tpf) {
        super.onUpdate(tpf);
//        log.info("z:"+currentZ);
    }

    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new UserAction("up level") {
            @Override
            protected void onActionEnd() {
                currentZ+=1;
                for (Entity entity1 : getGameWorld().getEntities()) {
                        entity1.setVisible(!((entity1.getZ()/20)>=currentZ));
                }
        log.info("z:"+currentZ);

            }
        },KeyCode.S);

        FXGL.getInput().addAction(new UserAction("up level1") {
            @Override
            protected void onActionEnd() {
                currentZ-=1;
                for (Entity entity1 : getGameWorld().getEntities()) {
                    entity1.setVisible(!((entity1.getZ()/20)>=currentZ));

                }
                        log.info("z:"+currentZ);

            }
        },KeyCode.W);


    }

    public static void main(String[] args) {
        launch(args);
    }
}
