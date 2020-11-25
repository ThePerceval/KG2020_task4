package com.company;

import com.company.Lighting.AmbientLight;
import com.company.Lighting.*;
import com.company.Primitive.Vector3;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args){
        GUI window = new GUI();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
<<<<<<< HEAD
        window.setSize(new Dimension(1100, 800));
=======
        window.setSize(new Dimension(800, 800));
>>>>>>> initial commit
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //Light lf = new AmbientLight(0.2);
        //st(lf);
    }

    private static void st(Light lf){
        try{
            Class<?> cl = Class.forName(lf.getClass().getName());
            System.out.println(lf.getClass().getName());
            Constructor<?> constructor = cl.getConstructor(double.class, Vector3.class);
            Light lg = (Light) constructor.newInstance(0.2, new Vector3(1,1,1));
            System.out.println(lg.getPosition() + " " + lg.getIntensity());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
