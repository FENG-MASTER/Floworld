package com.fengmaster.game.floworld.base.world;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Point3D {

    private long x;
    private long y;
    private long z;


    @Override
    public Object clone() throws CloneNotSupportedException {
        Point3D point3D = new Point3D(x,y,z);
        return point3D;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return x == point3D.x && y == point3D.y && z == point3D.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
