package com.company.Lighting;

import com.company.Primitive.Vector3;

/**
 * Интерфейс описывающий источник света
 */
public abstract class Light {
    public Vector3 getPosition(){
        return null;
    }

    public abstract double getIntensity();
}
