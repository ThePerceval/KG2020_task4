package com.company.Math.MathUtils;

import com.company.Objects.Model.IModel;
import com.company.Math.Vector.Vector3;

import java.util.List;

public class Intersection {
    private List<IModel> models;

    public Intersection(List<IModel> models) {
        this.models = models;
    }

    public boolean closestIntersection(Vector3 O, Vector3 D, double t_min, double t_max){
        for(IModel model : models){
            List<Double> list = model.IntersectRay(O, D);
            double t1 = list.get(0);
            double t2 = list.get(1);
            if(t1 >= t_min && t1 <= t_max && t1 < t_max){
                return true;
            }
            if(t2 >= t_min && t2 <= t_max && t2 < t_max){
                return true;
            }
        }
        return false;
    }
}
