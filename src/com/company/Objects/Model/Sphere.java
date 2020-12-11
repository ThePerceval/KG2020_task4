package com.company.Objects.Model;

import com.company.Math.Vector.Vector3;

import java.awt.*;
import java.util.ArrayList;

public class Sphere extends IModel{
    private double R;
    private Vector3 center;
    private Vector3 O = null;
    private Vector3 OC = null;
    private double Rpow2;
    private double k3;

    public Sphere(Vector3 center, double r, Color color, int specular, double reflective) {
        R = r;
        Rpow2 = Math.pow(R, 2);
        this.center = center;
        super.setSpecular(specular);
        super.setColor(color);
        super.setReflective(reflective);
    }

    public Vector3 getCenter() {
        return center;
    }

    @Override
    public void setCenter(Vector3 vector3) {
        this.center = vector3;
    }


    @Override
    public Vector3 getVectorNormal() { return null; }

    public ArrayList<Double> IntersectRay(Vector3 O, Vector3 D){

        if(this.O == null || !this.O.equals(O)){
            this.O = O;
            this.OC = new Vector3(O.getX() - center.getX(), O.getY() - center.getY(), O.getZ() - center.getZ());
            this.k3 = (Vector3.dot(OC, OC) - Rpow2);
        }

        ArrayList<Double> tmp = new ArrayList<Double>();
        double k1 = Vector3.dot(D, D);
        double k2 = 2 * Vector3.dot(OC, D);

        double dis = (Math.pow(k2, 2) - 4 * k1 * k3);

        if(dis < 0){
            tmp.add(Double.MIN_VALUE);
            tmp.add(Double.MIN_VALUE);
        }
        tmp.add(((-k2 - Math.sqrt(dis))/(2 * k1)));
        tmp.add(((-k2 + Math.sqrt(dis))/(2 * k1)));
        return tmp;
    }
}