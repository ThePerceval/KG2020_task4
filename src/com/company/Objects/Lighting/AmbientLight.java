package com.company.Objects.Lighting;

import com.company.Math.MathUtils.Intersection;
import com.company.Math.Vector.Vector3;

import java.awt.*;

public class AmbientLight extends Light {

    public AmbientLight(double intensity, Color color) {
        super.setIntensity(intensity);
        super.setColor(color);
    }

    @Override
    public Color computeLight(Vector3 point, Vector3 normal, Vector3 vector, double specular, boolean intersection, Intersection inter) {
        return getLight();
    }

    private Color getLight() {
        double i = super.getIntensity();
        return new Color((int) (super.getColor().getRed()   * i),
                         (int) (super.getColor().getGreen() * i),
                         (int) (super.getColor().getBlue()  * i));
    }

}
