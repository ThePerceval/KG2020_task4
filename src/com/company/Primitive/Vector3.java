package com.company.Primitive;

public class Vector3 {
    private double x, y, z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public static Vector3 multiVector(Vector3 a, Vector3 b){
        return new Vector3(a.getX() * b.getX(), a.getY() * b.getY(), a.getZ() * b.getZ());
    }

    public static Vector3 multiplication(Vector3 a, double k){
        return new Vector3(a.getX() * k, a.getY() * k,a.getZ() * k);
    }

    public static Vector3 normalVector(Vector3 a){
        double length = length(a);
        return new Vector3(a.getX() / length, a.getY() / length, a.getZ() / length);
    }

    public static Vector3 addition(Vector3 a, Vector3 b){
        return new Vector3(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }

    public static Vector3 subtraction(Vector3 a, Vector3 b){
        return new Vector3(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ() - b.getZ());
    }

    public static double dot(Vector3 a, Vector3 b){
        double tmp;
        tmp = a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
        return tmp;
    }

    public static double length(Vector3 vector){
        return Math.sqrt(Math.pow(vector.getX(), 2) + Math.pow(vector.getY(), 2) + Math.pow(vector.getZ(), 2));
    }
}
