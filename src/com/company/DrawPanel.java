package com.company;

import com.company.Lighting.AmbientLight;
import com.company.Lighting.DirectionalLight;
import com.company.Lighting.Light;
import com.company.Lighting.PointLight;
import com.company.Model.IModel;
import com.company.Model.Sphere;
import com.company.Primitive.Vector3;
import com.company.drawUtils.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class DrawPanel extends JPanel{
    Vector3 O = new Vector3(0, 0, 0);
    private Scene scene;

    DrawPanel(){
        setPreferredSize(new Dimension(800, 800));
        setMinimumSize(new Dimension(800, 800));
        setMaximumSize(new Dimension(800, 800));
        scene = new Scene(Color.BLACK, O);
        scene.addModel(new Sphere(new Vector3( 2, 0, 4), 1, Color.BLUE, -1, 0.4F));
        scene.addModel(new Sphere(new Vector3( 0, -1, 3), 1, Color.RED, 1000, 0.4F));
        scene.addModel(new Sphere(new Vector3(-2, 0, 4), 1, Color.GREEN, 20, 0));
        scene.addModel(new Sphere(new Vector3(0, 3, 20), 1, Color.GREEN, 20, 0));
        scene.addModel(new Sphere(new Vector3(0, -5001, 0), 5000, Color.YELLOW, 1000, 0.4F));
        scene.addLightning(new AmbientLight(0.2));
        //scene.addLightning(new PointLight(1, new Vector3(0,5000,0)));
        scene.addLightning(new PointLight(0.6, new Vector3(2,3,4)));
        scene.addLightning(new DirectionalLight(0.2, new Vector3(1,4,4)));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = bi.createGraphics();
        gr.setColor(Color.BLACK);
        gr.fillRect(0,0, getWidth(), getHeight());
        scene.drawScene(bi, gr);
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
}
