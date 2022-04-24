package com.fengmaster.game.floworld.base;

import com.fengmaster.game.floworld.base.event.EventCenter;
import com.fengmaster.game.floworld.base.world.World;
import com.fengmaster.game.floworld.base.world.gen.PureWorldGenerator;
import lombok.Getter;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Game {

    private static  Game instance=new Game();

    public static Game getInstance() {
        return instance;
    }

    @Getter
    private GameOption gameOption;

    private Map<String, World> worldMap;

    @Getter
    private GameObjectCenter gameObjectCenter;

    @Getter
    private EventCenter eventCenter;


    private Game(){
        //TODO:


    }

    public void init(){
        gameOption =new GameOption();
        eventCenter=new EventCenter();
        worldMap=new ConcurrentHashMap<>();

        gameObjectCenter=new GameObjectCenter();

        World world=new World("main",new PureWorldGenerator());
        worldMap.put(world.getName(),world);
    }

    public World getWorld(String name){
        return worldMap.get(name);
    }

    public Collection<String> getWorldNames(){
        return worldMap.keySet();
    }

}
