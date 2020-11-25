package com.company.Model;

import com.company.Primitive.Vector3;

import java.awt.*;
import java.util.ArrayList;

public abstract class IModel {
    private Color color;
    private int specular;
    private float reflective;


    public void setReflective(float reflective) {
        this.reflective = reflective;
    }

    public float getReflective(){
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

    public abstract ArrayList<Float> IntersectRay(Vector3 O, Vector3 D);

    public abstract Vector3 getCenter();
}
