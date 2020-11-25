package com.company;

import javax.swing.*;
import java.awt.*;

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
    }
}
