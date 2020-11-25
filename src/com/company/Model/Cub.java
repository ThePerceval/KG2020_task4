package com.company.Model;

import com.company.Primitive.Vector3;

import java.util.ArrayList;
import java.util.List;

public class Cub extends IModel {
    private List<Vector3> listPoint = new ArrayList<Vector3>();

    public Cub(Vector3 point1, double height, double width) {
    }

    @Override
    public ArrayList<Float> IntersectRay(Vector3 O, Vector3 D) {
        return null;
    }

    @Override
    public Vector3 getCenter() {
        return null;
    }
}