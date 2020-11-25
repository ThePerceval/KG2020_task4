package com.company.drawUtils;

import com.company.Lighting.AmbientLight;
import com.company.Lighting.Light;
import com.company.Lighting.PointLight;
import com.company.Model.IModel;
import com.company.Primitive.Vector3;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    private List<IModel> models = new ArrayList<IModel>();
    private List<Light> lightning = new ArrayList<Light>();
    private Color background;
    private Vector3 O;
    private double width = 1;
    private double height = 1;
    private float distance = 1;

    public Scene(Color backgroundRGB, Vector3 cameraPosition) {
        this.background = backgroundRGB;
        this.O = cameraPosition;
    }

    /**
     * Метод отрисовки на экране
     * @param bi - холст, где рисуем
     * @param gr - графика, с помощью которой рисуем
     */
    public void drawScene(BufferedImage bi, Graphics2D gr){
        O = new Vector3(0, 0, 0);
        for (int x = -bi.getWidth() / 2 - 1; x < bi.getWidth() / 2; x++) {
            for (int y = -bi.getHeight() / 2; y < bi.getHeight() / 2; y++) {
                Vector3 D = Vector3.multiVector(toViewport(x, y, bi.getWidth(), bi.getHeight(), distance), new Vector3(1, 1, 1));
                Color color = TraceRay(O, D, 0.001F, 10000, 1);
                gr.setColor(color);
                gr.fillRect(bi.getWidth()/ 2 + x, bi.getHeight() / 2 - y, 1, 1);
            }
        }
    }

    private double computeLightning(Vector3 P, Vector3 N, Vector3 V, int s){
        double i = 0.0;
        float t_max;
        for(Light light: lightning){
            if(light instanceof AmbientLight){
                i += light.getIntensity();
            } else {
                Vector3 L;
                if(light instanceof PointLight){
                    L = Vector3.subtraction(light.getPosition(), P);
                    t_max = 1;
                }
                else {
                    L = light.getPosition();
                    t_max = 1000000F;
                }
                double n_dot_l = Vector3.dot(N, L);

                // тень
                IModel model = closestIntersection(P, L, 0.001F, t_max);
                if(model != null){
                    closed_t = null;
                    continue;
                }
                // освещение
                if(n_dot_l > 0){
                    i+= light.getIntensity() * n_dot_l / (Vector3.length(N) * Vector3.length(L));
                }
                // отражение
                if(s != -1){
                    Vector3 R = reflectRay(L, N);
                    double r_dot = Vector3.dot(R, V);
                    if(light.getIntensity() * Math.pow(r_dot / (Vector3.length(R) * Vector3.length(V)), s) > 1)
                        System.out.println(r_dot + " " + (Vector3.length(R) * Vector3.length(V)));
                    if(r_dot > 0)
                        i += light.getIntensity() * Math.pow(r_dot / (Vector3.length(R) * Vector3.length(V)), s);
                }
            }
        }
        return i > 1 ? 1 : i;
    }

    private Vector3 reflectRay(Vector3 R, Vector3 N){
        return Vector3.subtraction(Vector3.multiplication(Vector3.multiplication(N,2), Vector3.dot(N, R)), R);
    }

    private Float closed_t = null;
    private Color TraceRay(Vector3 O, Vector3 D, float t_min, float t_max, int depth){
        IModel model = closestIntersection(O, D, t_min, t_max);
        if(model == null)
            return background;
        Vector3 P = Vector3.addition(O, Vector3.multiplication(D, closed_t));
        Vector3 N = Vector3.normalVector(Vector3.subtraction(P, model.getCenter()));
        double light = computeLightning(P, N, Vector3.multiplication(D, -1), model.getSpecular());
        Color color = new Color((int)(model.getColor().getRed() * light),
                                (int)(model.getColor().getGreen() * light),
                                (int)(model.getColor().getBlue() * light));
        float r = model.getReflective();
        if(depth <= 0 || r <= 0)
            return color;

        Vector3 R = reflectRay(Vector3.multiplication(D, -1), N);
        Color reflected_color = TraceRay(P, R, 0.001F, 10000000F, depth - 1);
        double red = color.getRed() * (1 - r) + reflected_color.getRed() * r,
             green = color.getGreen() * (1 - r) + reflected_color.getGreen() * r,
              blue = color.getBlue() * (1 - r) + reflected_color.getBlue() * r;

        closed_t = null;
        return new Color((int)red, (int)green, (int)blue);
    }

    private IModel closestIntersection(Vector3 O, Vector3 D, float t_min, float t_max){
        float closest_t = t_max;
        IModel closed_model = null;
        for(IModel model : models){
            List<Float> list = model.IntersectRay(O, D);
            float t1 = list.get(0);
            float t2 = list.get(1);
            if(t1 >= t_min && t1 <= t_max && t1 < closest_t){
                closed_model = model;
                closest_t = t1;
            }
            if(t2 >= t_min && t2 <= t_max && t2 < closest_t){
                closed_model = model;
                closest_t = t2;
            }
        }
        this.closed_t = closest_t;
        return closed_model;
    }

    private Vector3 toViewport(int x, int y, double widthScreen, double heightScreen, float distance){
        return new Vector3(x * width / widthScreen,y * height / heightScreen, distance);
    }

    public void addModel(IModel model) {
        models.add(model);
    }

    public void addLightning(Light light) {
        lightning.add(light);
    }

    private void forName(String ambientLight) {
    }
}
