package com.fengmaster.game.floworld.util;

public class GameTimeUtil {

    /**
     * 每 1t 等于 10秒
     * @param tick
     * @return
     */
    public static double tick2Sec(long tick){
        return tick*10;
    }

    /**
     * 每 1t 等于 10/60分钟
     * @param tick
     * @return
     */
    public static double tick2Min(long tick){
        return tick/6.0;
    }

    /**
     * 每 1t 等于 0.6/60
     * @param tick
     * @return
     */
    public static double tick2Hour(long tick){
        return tick/6.0/60;
    }


}
