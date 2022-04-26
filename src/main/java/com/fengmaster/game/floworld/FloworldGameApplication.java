package com.fengmaster.game.floworld;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.fengmaster.game.floworld.base.Game;
import com.fengmaster.game.floworld.base.obj.entity.BaseGameEntity;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import lombok.extern.java.Log;

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

    @Override
    protected void initGame() {
        Game.getInstance().init();
        worldName = "main";

        FXGL.getEventBus().setLoggingEnabled(true);


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
                    boolean v = !((entity1.getZ() / 20) >= currentZ);
                    entity1.setVisible(v);
                    if (v){
                        if (entity1 instanceof BaseGameEntity){
                            BaseGameEntity b= (BaseGameEntity) entity1;
                            entity1.getViewComponent().setOpacity( Math.pow(0.8f,currentZ-b.getCellCenter().getZ()));


                        }
                    }
                }
        log.info("z:"+currentZ);

            }
        },KeyCode.S);

        FXGL.getInput().addAction(new UserAction("up level1") {
            @Override
            protected void onActionEnd() {
                currentZ-=1;
                for (Entity entity1 : getGameWorld().getEntities()) {
                    boolean v = !((entity1.getZ() / 20) >= currentZ);
                    entity1.setVisible(v);
                    if (v){
                        if (entity1 instanceof BaseGameEntity){
                            BaseGameEntity b= (BaseGameEntity) entity1;
                            entity1.getViewComponent().setOpacity(Math.pow(0.8f,currentZ-b.getCellCenter().getZ()));


                        }
                    }

                }
                    log.info("z:"+currentZ);

            }
        },KeyCode.W);

        FXGL.getInput().addAction(new UserAction("up level2") {
            @Override
            protected void onActionEnd() {
                Game.getInstance().getWorld(worldName).tick();
                log.info("T:"+Game.getInstance().getWorld(worldName).getTimeCenter().getTime());

            }
        },KeyCode.T);


    }

    public static void main(String[] args) {
        launch(args);
    }
}
