package com.company.Model;

import com.company.Primitive.Vector3;

import java.util.ArrayList;
import java.util.List;

public class Pyramid extends IModel{
    private List<Vector3> list = new ArrayList<Vector3>();

    public Pyramid(List<Vector3> list) {
        this.list = list;
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
