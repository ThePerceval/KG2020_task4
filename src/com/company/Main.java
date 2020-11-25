package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        GUI window = new GUI();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(new Dimension(800, 800));
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
