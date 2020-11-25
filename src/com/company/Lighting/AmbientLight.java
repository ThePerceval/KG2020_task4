package com.company.Lighting;

import com.company.Primitive.Vector3;

public class AmbientLight extends Light {
    private double intensity;

    public AmbientLight(double intensity, Vector3 point){
        this(intensity);
    }

    public AmbientLight(double intensity) {
        this.intensity = intensity;
    }

    public double getIntensity() {
        return intensity;
    }

}
