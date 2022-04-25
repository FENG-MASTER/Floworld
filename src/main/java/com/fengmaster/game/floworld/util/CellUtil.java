package com.fengmaster.game.floworld.util;

import com.fengmaster.game.floworld.base.world.Point3D;
import lombok.SneakyThrows;

public class CellUtil {

    /**
     * 获取上下左右的相邻点
     * @param point
     * @return
     */
    @SneakyThrows
    public static Point3D[] getNearbyPoint(Point3D point){
        Point3D[] points = new Point3D[6];
        points[0]= (Point3D) point.clone();
        points[0].setX(points[0].getX()+1);

        points[1]= (Point3D) point.clone();
        points[1].setX(points[1].getX()-1);

        points[2]= (Point3D) point.clone();
        points[2].setY(points[2].getY()+1);

        points[3]= (Point3D) point.clone();
        points[3].setY(points[3].getY()-1);

        points[4]= (Point3D) point.clone();
        points[4].setZ(points[4].getZ()+1);

        points[5]= (Point3D) point.clone();
        points[5].setZ(points[5].getZ()-1);
        return points;
    }


    public static boolean mapContain(Point3D point3D,long length,long width,long height){
        if (point3D.getX()<0||point3D.getY()<0||point3D.getZ()<0){
            return false;
        }
        if (point3D.getX()>length||point3D.getY()>width||point3D.getZ()>height){
            return false;
        }

        return true;
    }

}
