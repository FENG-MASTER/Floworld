package com.fengmaster.game.floworld.base;


import com.almasb.fxgl.dsl.FXGL;
import lombok.Getter;

public class GameOption {

    public Map mapOption;

    @Getter
    private int cellSize=20;

    public static class Map{
        public String generatorType;
        public String params;
    }


    public GameOption(){
        mapOption=new Map();


        mapOption.generatorType="1";
        mapOption.params="";
    }

}
