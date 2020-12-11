package com.company;

import com.company.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        GUI window = new GUI();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(new Dimension(1150, 800));
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}