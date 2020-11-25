package com.company.Model;

import com.company.Primitive.Vector3;

import java.awt.*;
import java.util.ArrayList;


public class Sphere extends IModel{
    private double R;
    private Vector3 center;
    
    public Sphere(Vector3 center, double r, Color color, int specular, float reflective) {
        R = r;
        this.center = center;
        super.setSpecular(specular);
        super.setColor(color);
        super.setReflective(reflective);
    }

    public double getR() {
        return R;
    }

    public Vector3 getCenter() {
        return center;
    }

    public ArrayList<Float> IntersectRay(Vector3 O, Vector3 D){
        Vector3 center = this.getCenter();
        Vector3 OC = new Vector3(O.getX() - center.getX(), O.getY() - center.getY(), O.getZ() - center.getZ());

        ArrayList<Float> tmp = new ArrayList<Float>();
        double k1 = Vector3.dot(D, D);
        double k2 = 2 * Vector3.dot(OC, D);
        double k3 = Vector3.dot(OC, OC) - Math.pow(R, 2);

        double dis = Math.pow(k2, 2) - 4 * k1 * k3;

        if(dis < 0){
            tmp.add(Float.MIN_VALUE);
            tmp.add(Float.MIN_VALUE);
        }
        tmp.add((float) ((-k2 - Math.sqrt(dis))/(2 * k1)));
        tmp.add((float) ((-k2 + Math.sqrt(dis))/(2 * k1)));
        return tmp;
    }
}