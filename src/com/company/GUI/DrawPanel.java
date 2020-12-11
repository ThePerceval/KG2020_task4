package com.company.GUI;

import com.company.GUI.Camera.Camera;
import com.company.GUI.Camera.CameraController;
import com.company.GUI.drawUtils.BufferedImagePixelDrawer;
import com.company.Objects.Lighting.AmbientLight;
import com.company.Objects.Lighting.DirectionalLight;
import com.company.Objects.Lighting.Light;
import com.company.Objects.Lighting.PointLight;
import com.company.Objects.Model.IModel;
import com.company.Objects.Model.Sphere;
import com.company.Math.Vector.Vector3;
import com.company.Screen.ScreenConverter;
import com.company.GUI.drawUtils.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class DrawPanel extends JPanel implements CameraController.RepaintListener {
    private ScreenConverter sc;
    private Scene scene;
    private Camera camera;
    private CameraController camControl;
    private Light ambientLight = new AmbientLight( 0.2, Color.white);
    private Light lightSource1 = new PointLight(0.5, Color.white, new Vector3(2,3,4));
    private Light lightSource2 = new DirectionalLight(0.2, Color.white, new Vector3(1,4,4));

    DrawPanel(){
        sc = new ScreenConverter(-1, -1, 2, 2, 800, 800);
        camera = new Camera();
        camControl = new CameraController(camera, sc);
        scene = new Scene(Color.BLACK);
        scene.addModel(new Sphere(new Vector3(0, -1, 3), 1, Color.WHITE,  14525, 0.4F));
        scene.addModel(new Sphere(new Vector3(-2, 0, 4), 1, Color.GREEN, 20,  0.8f));
        scene.addModel(new Sphere(new Vector3(0,  3, 20),1, Color.white, 20,  0.3f));
        scene.addModel(new Sphere(new Vector3(2,  0, 4), 1, Color.BLUE, 1000, 0.4F));
        scene.addModel(new Sphere(new Vector3(0, -5001, 0), 5000, Color.YELLOW, 1000, 0.4F));
        scene.addLightning(ambientLight);
        scene.addLightning(lightSource1);
        scene.addLightning(lightSource2);

        camControl.addRepaintListener(this);
        this.addMouseListener(camControl);
        this.addMouseWheelListener(camControl);
        this.addMouseMotionListener(camControl);
    }


    @Override
    public void paint(Graphics g) {
        scene.setLightning(new ArrayList<Light>());
        scene.addLightning(ambientLight);
        scene.addLightning(lightSource1);
        scene.addLightning(lightSource2);
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImagePixelDrawer pd = new BufferedImagePixelDrawer(bi);
        Graphics2D gr = bi.createGraphics();
        gr.setColor(Color.BLACK);
        gr.fillRect(0,0, getWidth(), getHeight());
        scene.drawScene(pd, camera);
        g.drawImage(bi,0, 0, null);
        gr.dispose();
    }

    public void addLight(Light light){
        scene.addLightning(light);
        repaint();
    }

    public void addModel(IModel model){
        scene.addModel(model);
        repaint();
    }

    public void setAmbientLight(Light light) {
        this.ambientLight = light;
    }

    public void setLightSource1(Light light) {
        this.lightSource1 = light;
    }

    public void setLightSource2(Light light) {
        this.lightSource2 = light;
    }

    @Override
    public void shouldRepaint() {
        repaint();
    }
}
