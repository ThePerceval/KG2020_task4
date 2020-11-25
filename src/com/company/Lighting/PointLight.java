package com.company.Lighting;

import com.company.Primitive.Vector3;

public class PointLight extends Light {
    private double intensity;
    private Vector3 position;

    public PointLight(double intensity, Vector3 position) {
        this.intensity = intensity;
        this.position = position;
    }

    @Override
    public Vector3 getPosition() {
        return position;
    }

    public double getIntensity() {
        return intensity;
    }

}
