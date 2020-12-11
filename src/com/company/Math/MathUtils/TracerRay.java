package com.company.Math.MathUtils;

import com.company.GUI.Camera.Camera;
import com.company.Objects.Lighting.Light;
import com.company.Objects.Model.IModel;
import com.company.Math.Vector.Vector3;
import com.company.GUI.drawUtils.Scene;

import java.awt.*;
import java.util.List;

public class TracerRay {
    private Scene scene;
    private Intersection intersection;

    public TracerRay(Scene scene) {
        this.scene = scene;
        this.intersection = new Intersection(scene.getModels());
    }

    public Color getColor(Vector3 O, Vector3 D, float t_min, float t_max, int depth, Camera camera){
        return TraceRay(O, D, t_min, t_max, depth, camera);
    }

    private Color TraceRay(Vector3 O, Vector3 D, double t_min, double t_max, int depth, Camera camera){
        IModel model = closestIntersection(O, D, t_min, t_max); // решает квадратное уравнение
        if(model == null)
            return scene.getBackground();
        Vector3 P = Vector3.addition(O, Vector3.multiplication(D, closed_t)); // точка пересечения
        //P = camera.w2s(P);
        Vector3 N = Vector3.normalVector(Vector3.subtraction(P, model.getCenter())); // находит вектор нормали
        Color light = computeLightning(P, N, Vector3.multiplication(D, -1), model.getSpecular()); // вычисляет освещение
        Color color = new Color((int)(model.getColor().getRed()   * (light.getRed()   / 255D)),
                                (int)(model.getColor().getGreen() * (light.getGreen() / 255D)),
                                (int)(model.getColor().getBlue()  * (light.getBlue()  / 255D))); // применяет освещение к цвету в пиксели
        double r = model.getReflective(); // если есть отражение то считаем его
        if(depth <= 0 || r <= 0)
            return color;
        Vector3 R = Vector3.reflectRay(Vector3.multiplication(D, -1), N);
        Color reflected_color = TraceRay(P, R, 0.001F, 10000000F, depth - 1, camera);
        double red = color.getRed() * (1 - r) + reflected_color.getRed() * r,
                green = color.getGreen() * (1 - r) + reflected_color.getGreen() * r,
                blue = color.getBlue() * (1 - r) + reflected_color.getBlue() * r;
        return new Color((int)red, (int)green, (int)blue);
    }

    private Double closed_t = null;
    private IModel closestIntersection(Vector3 O, Vector3 D, double t_min, double t_max){
        double closest_t = t_max;
        IModel closed_model = null;
        for(IModel model : scene.getModels()){
            List<Double> list = model.IntersectRay(O, D);
            double t1 = list.get(0);
            double t2 = list.get(1);
            if(t1 >= t_min && t1 <= t_max && t1 < closest_t){
                closed_model = model;
                closest_t = t1;
            }
            if(t2 >= t_min && t2 <= t_max && t2 < closest_t){
                closed_model = model;
                closest_t = t2;
            }
        }
        double distantChess = Double.MAX_VALUE;


        this.closed_t = closest_t;
        return closed_model;
    }


    private Color computeLightning(Vector3 P, Vector3 N, Vector3 V, double s) {
        Color color = Color.BLACK;
        for(Light light: scene.getLightning()){
                Color tmp = light.computeLight(P, N, V, s, false, this.intersection);
                color = new Color(Math.min(color.getRed()   + tmp.getRed()  , 255),
                                  Math.min(color.getGreen() + tmp.getGreen(), 255),
                                  Math.min(color.getBlue()  + tmp.getBlue() , 255));
        }
        return color;
    }

}