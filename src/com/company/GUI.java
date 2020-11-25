package com.company;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    private JPanel panel1;
    private DrawPanel drawPanel;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button3;
    private JButton button4;
    private JButton применитьButton;

    public GUI() throws HeadlessException {
        setContentPane(panel1);
    }

    private void createUIComponents() {
        drawPanel = new DrawPanel();
    }
}
