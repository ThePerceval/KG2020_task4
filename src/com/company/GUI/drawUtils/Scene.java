package com.company.GUI.drawUtils;

import com.company.GUI.Camera.Camera;
import com.company.Objects.Lighting.Light;
import com.company.Objects.Model.IModel;
import com.company.Math.Vector.Vector3;
import com.company.Math.MathUtils.TracerRay;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    private List<IModel> models = new ArrayList<IModel>();
    private List<Light> lightning = new ArrayList<Light>();
    private Color background;

    public Scene(Color background) {
        this.background = background;
    }

    public void drawScene(pixelDrawer pd, Camera camera){
        Vector3 O = new Vector3(0, 0, 0);
        BufferedImage bi = pd.getBI();
        TracerRay tracerRay = new TracerRay(this);
        for (int x = -bi.getWidth() / 2 - 1; x < bi.getWidth() / 2; x++) {
            for (int y = -bi.getHeight() / 2; y < bi.getHeight() / 2; y++) {
                Vector3 D = camera.w2s(toViewport(x, y, bi.getWidth(), bi.getHeight(), 1.4));
                Color color = tracerRay.getColor(O, D, 0.000001f, 100000F, 1, camera);
                pd.drawPixel(bi.getWidth()/ 2 + x,bi.getHeight() / 2 - y, color);
            }
        }
    }

    private Vector3 toViewport(int x, int y, double widthScreen, double heightScreen, double distance){
        return new Vector3((x / widthScreen), (y / heightScreen), distance);
    }

    public void setLightning(List<Light> lightning) {
        this.lightning = lightning;
    }

    public void addModel(IModel model) {
        models.add(model);
    }
    public void addLightning(Light light) {
        lightning.add(light);
    }
    public List<IModel> getModels() {
        return models;
    }
    public List<Light> getLightning() {
        return lightning;
    }
    public Color getBackground() {
        return background;
    }
}
