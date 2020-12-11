package com.company.Objects.Lighting;

import com.company.Math.MathUtils.Intersection;
import com.company.Math.Vector.Vector3;

import java.awt.*;

/**
 * Интерфейс описывающий источник света
 */
public abstract class Light {
    private Color color;
    private double intensity;
    private Vector3 vector;

    protected void setColor(Color color) { this.color = color; }
    protected Color getColor() { return color; }

    protected void setIntensity(double intensity) { this.intensity = intensity; }
    protected double getIntensity() { return intensity; }

    protected void setVector(Vector3 vector) { this.vector = vector; }

    public abstract Color computeLight(Vector3 point, Vector3 normal, Vector3 vector, double specular, boolean intersection, Intersection inter);

    public Vector3 getPosition(){return vector;}
}
