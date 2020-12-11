package com.company.Objects.Lighting;

import com.company.Math.MathUtils.Intersection;
import com.company.Math.Vector.Vector3;

import java.awt.*;

public class PointLight extends Light {

    public PointLight(double intensity, Color color, Vector3 position){
        super.setIntensity(intensity);
        super.setColor(color);
        super.setVector(position);
    }

    @Override
    public Color computeLight(Vector3 point, Vector3 normal, Vector3 vector, double specular, boolean intersection, Intersection inter) {
        Vector3 L = Vector3.subtraction(super.getPosition(), point);
        // тень
        if(inter.closestIntersection(point, L, 0.00001F, 1F))
            return Color.BLACK;
        // свет
        double n_dot_l = Vector3.dot(normal, L);
        Color light = getLight(n_dot_l, normal, L);
        if(specular == -1)
            return light;
        // отражение
        Color specularColor = getReflection(L, normal, vector, specular);
        return new Color(Math.min(light.getRed()   + specularColor.getRed()  , 255),
                         Math.min(light.getGreen() + specularColor.getGreen(), 255),
                         Math.min(light.getBlue()  + specularColor.getBlue() , 255));
    }


    private Color getLight(double n_dot_l, Vector3 N, Vector3 L) {
        double i = Math.abs(super.getIntensity() * n_dot_l / (Vector3.length(N) * Vector3.length(L)));
        return new Color((int)Math.min((super.getColor().getRed()   * i), 255),
                         (int)Math.min((super.getColor().getGreen() * i), 255),
                         (int)Math.min((super.getColor().getBlue()  * i), 255));

    }

    private Color getReflection(Vector3 L, Vector3 N, Vector3 V, double specular) {
        Vector3 R = Vector3.reflectRay(L, N);
        double r_dot = Vector3.dot(R, V);
        if(r_dot < 0)
            return Color.BLACK;
        double i = Math.abs(super.getIntensity() * Math.pow(r_dot / (Vector3.length(R) * Vector3.length(V)), specular));
        return new Color((int)(super.getColor().getRed()   * i),
                         (int)(super.getColor().getGreen() * i),
                         (int)(super.getColor().getBlue()  * i));
    }


}
