package com.company.Math.Vector;

public class Vector4 {
    private double[] values;

    public Vector4(double x, double y, double z, double w) { values = new double[]{x, y, z, w}; }
    public Vector4(double x, double y, double z) { this(x, y, z, 0); }
    public Vector4(Vector3 v, double w) { this(v.getX(), v.getY(), v.getZ(), w); }
    public Vector4(Vector3 v) { this(v, 0); }

    private Vector4(double[] array) { this.values = array; }
    public static Vector4 zero() { return new Vector4(new double[4]); }

    public Vector4 mul(double number) {
        double[] array = new double[4];
        for (int i = 0; i < array.length; i++)
            array[i] = number * this.at(i);
        return new Vector4(array);
    }

    public Vector4 add(Vector4 other) {
        double[] array = new double[4];
        for (int i = 0; i < array.length; i++)
            array[i] = this.at(i) + other.at(i);
        return new Vector4(array);
    }

    private static final double EPSILON = 1e-10f;

    public Vector4 normalized() {
        if (Math.abs(getW()) < EPSILON)
            return new Vector4(this.getX(), this.getY(), this.getZ(), 0);
        return new Vector4(this.getX() / this.getW(), this.getY() / this.getW(), this.getZ() / this.getW(), 1);
    }

    public Vector3 asVector3() {
        Vector4 n = this.normalized();
        return new Vector3(n.getX(), n.getY(), n.getZ());
    }

    public double getX() { return values[0]; }
    public double getY() { return values[1]; }
    public double getZ() { return values[2]; }
    public double getW() { return values[3]; }
    public double at(int idx) { return values[idx]; }
}
