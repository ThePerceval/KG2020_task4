package com.company.Math.Vector;

public class Vector3 {
    private double[] values;

    public Vector3(double x, double y, double z) {
        values = new double[]{x, y, z};
    }

    public double getX() {
        return values[0];
    }

    public double getY() {
        return values[1];
    }

    public double getZ() {
        return values[2];
    }

    public static Vector3 multiVector(Vector3 a, Vector3 b){
        return new Vector3(a.getX() * b.getX(), a.getY() * b.getY(), a.getZ() * b.getZ());
    }

    public static Vector3 multiplication(Vector3 a, double k){
        if(a.getX() == -0.5 && a.getY() == 0)
            System.out.println(true);
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

    public static Vector3 reflectRay(Vector3 R, Vector3 N){
        return Vector3.subtraction(Vector3.multiplication(Vector3.multiplication(N,2), Vector3.dot(N, R)), R);
    }
}
