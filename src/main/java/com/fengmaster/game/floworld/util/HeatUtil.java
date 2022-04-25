package com.fengmaster.game.floworld.util;

public class HeatUtil {

    /**
     * 散发热量导致的空气温度上升
     * @param j
     * @return
     */
    public static double heatDissipation2AirTemperatureRise(double j,double k){
        return j/1000/k;
    }


}
