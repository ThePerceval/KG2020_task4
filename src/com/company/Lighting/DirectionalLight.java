package com.company.Lighting;

import com.company.Primitive.Vector3;

public class DirectionalLight extends Light {
    private double intensity;
    private Vector3 vector;

    public DirectionalLight(double intensity, Vector3 vector) {
        this.intensity = intensity;
        this.vector = vector;
    }

    @Override
    public Vector3 getPosition() {
        return vector;
    }

    public double getIntensity() {
        return intensity;
    }
}
