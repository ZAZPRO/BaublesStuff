package md.zazpro.mod.helper;

import net.minecraft.entity.Entity;

public class Vector3 {

    public double x;
    public double y;
    public double z;


    public Vector3(double d, double d1, double d2) {
        x = d;
        y = d1;
        z = d2;
    }

    public Vector3(Vector3 vec) {
        x = vec.x;
        y = vec.y;
        z = vec.z;
    }


    public static Vector3 fromEntityCenter(Entity e) {
        return new Vector3(e.posX, e.posY - e.getYOffset() + e.height / 2, e.posZ);
    }

    public Vector3 copy() {
        return new Vector3(this);
    }


    public Vector3 subtract(Vector3 vec) {
        x -= vec.x;
        y -= vec.y;
        z -= vec.z;
        return this;
    }


    public Vector3 multiply(double d) {
        x *= d;
        y *= d;
        z *= d;
        return this;
    }


    public double mag() {
        return Math.sqrt(x * x + y * y + z * z);
    }


    public Vector3 normalize() {
        double d = mag();
        if (d != 0)
            multiply(1 / d);

        return this;
    }

}