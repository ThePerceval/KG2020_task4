package com.company.Objects.Model;

import com.company.Math.Vector.Vector3;

import java.awt.*;
import java.util.ArrayList;

public abstract class IModel {
    private Color color;
    private int specular;
    private double reflective;


    public void setReflective(double reflective) {
        this.reflective = reflective;
    }
    public double getReflective(){
        return reflective;
    }

    public void setSpecular(int specular) {
        this.specular = specular;
    }
    public int getSpecular() {
        return specular;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public abstract ArrayList<Double> IntersectRay(Vector3 O, Vector3 D);

    public abstract Vector3 getCenter();
    public abstract void setCenter(Vector3 vector3);
    public abstract Vector3 getVectorNormal();
}
