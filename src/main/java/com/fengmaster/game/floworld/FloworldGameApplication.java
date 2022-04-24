package com.fengmaster.game.floworld;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.localization.Language;
import com.fengmaster.game.floworld.base.Game;
import com.fengmaster.game.floworld.base.obj.BaseGameComponent;
import javafx.geometry.Point2D;

import java.util.List;
import java.util.Map;

public class FloworldGameApplication extends GameApplication {


    private long currentShowTick;

    private boolean nextTick;

    private String worldName;

    private int currentZ = 0;

    private int commandWaitTime = 5;


    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(720);
        gameSettings.setHeight(480);
        gameSettings.setTitle("Floworld");
//        gameSettings.setDefaultLanguage(Language.CHINESE);
        gameSettings.setVersion("0.1");

    }


    @Override
    protected void initGame() {
        Game.getInstance().init();
        worldName = "main";

//        Game.getInstance().getEventCenter().getWorldEventBus(worldName).register(this);

//
//        FXGL.entityBuilder().at(new Point2D(50,50))
//                .view(FXGL.getAssetLoader()
//                        .loadTexture("obj/cobble1.png",10,10)).buildAndAttach();


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

    public static void main(String[] args) {
        launch(args);
    }
}
