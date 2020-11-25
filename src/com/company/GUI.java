package com.company;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    private JPanel panel;
    private DrawPanel drawPanel;

    public GUI() throws HeadlessException {
        setContentPane(panel);
    }

    private void createUIComponents() {
        drawPanel = new DrawPanel();
    }
}
