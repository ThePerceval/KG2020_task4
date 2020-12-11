package com.company.GUI;

import com.company.Math.Vector.Vector3;
import com.company.Objects.Lighting.AmbientLight;
import com.company.Objects.Lighting.DirectionalLight;
import com.company.Objects.Lighting.PointLight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private JPanel panel;
    private DrawPanel drawPanel;
    private JButton ButtonExecute;
    private JComboBox comboBox4;
    private JTextField textField4;
    private JButton button4;
    private JComboBox comboBox3;
    private JTextField textField3;
    private JButton button3;
    private JTextField textField1textFieldFirstIntensity;
    private JTextField textFieldSecondIntensity;
    private JTextField textFieldFirstLightRed;
    private JTextField textFieldFirstLightGreen;
    private JTextField textFieldFirstLightBlue;
    private JTextField textFieldSecondLightRed;
    private JTextField textFieldSecondLightGreen;
    private JTextField textFieldSecondLightBlue;
    private JTextField textField1X;
    private JTextField textField1Y;
    private JTextField textField1Z;
    private JComboBox comboBoxFirstLight;
    private JComboBox comboBoxSecondLight;
    private JTextField textFieldAmbient;
    private JSpinner spinnerAmbientRed;
    private JSpinner spinnerAmbientGreen;
    private JSpinner spinnerAmbientBlue;
    private JSpinner spinnerLight1Red;
    private JSpinner spinnerLight1Green;
    private JSpinner spinnerLight1Blue;
    private JSpinner spinnerLight2Red;
    private JSpinner spinnerLight2Green;
    private JSpinner spinnerLight2Blue;
    private JTextField textField2X;
    private JTextField textField2Y;
    private JTextField textField2Z;
    private JLabel textField2;
    private JTextField textFieldAmbientRed;
    private JTextField textFieldAmbientGreen;
    private JTextField textFieldAmbientBlue;

    public GUI() throws HeadlessException {
        setContentPane(panel);


        ButtonExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color1 = getColor(spinnerAmbientRed, spinnerAmbientGreen, spinnerAmbientBlue);
                Color color2 = getColor(spinnerLight1Red, spinnerLight1Green, spinnerLight1Blue);
                Color color3 = getColor(spinnerLight2Red, spinnerLight2Green, spinnerLight2Blue);
                Vector3 pos1 = getPosition(textField1X, textField1Y, textField1Z);
                Vector3 pos2 = getPosition(textField2X, textField2Y, textField2Z);

                drawPanel.setAmbientLight(new AmbientLight(Double.parseDouble(textFieldAmbient.getText()), color1));
                if(comboBoxFirstLight.getSelectedIndex() == 0)
                    drawPanel.setLightSource1(new PointLight(Double.parseDouble(textField1textFieldFirstIntensity.getText()), color2, pos1));
                else
                    drawPanel.setLightSource1(new DirectionalLight(Double.parseDouble(textField1textFieldFirstIntensity.getText()), color2, pos1));
                if(comboBoxSecondLight.getSelectedIndex() == 0)
                    drawPanel.setLightSource2(new PointLight(Double.parseDouble(textFieldSecondIntensity.getText()), color3, pos2));
                else
                    drawPanel.setLightSource2(new DirectionalLight(Double.parseDouble(textFieldSecondIntensity.getText()), color3, pos2));

                drawPanel.shouldRepaint();
            }
        });
    }

    private Vector3 getPosition(JTextField jtf1,JTextField jtf2, JTextField jtf3){
        int X = Integer.parseInt(jtf1.getText()),
            Y = Integer.parseInt(jtf2.getText()),
            Z = Integer.parseInt(jtf3.getText());
        return new Vector3(X, Y, Z);
    }
    private Color getColor(JSpinner jtf1,JSpinner jtf2, JSpinner jtf3){
        int red = (Integer)jtf1.getValue(),
          green = (Integer)jtf2.getValue(),
           blue = (Integer)jtf3.getValue();
        return new Color(red, green, blue);
    }
    private void createUIComponents() {
        drawPanel = new DrawPanel();
        drawPanel.setFocusable(true);
        spinnerAmbientRed = new JSpinner();
        spinnerAmbientGreen = new JSpinner();
        spinnerAmbientBlue = new JSpinner();
        spinnerLight1Red = new JSpinner();
        spinnerLight1Green = new JSpinner();
        spinnerLight1Blue = new JSpinner();
        spinnerLight2Red = new JSpinner();
        spinnerLight2Green = new JSpinner();
        spinnerLight2Blue = new JSpinner();
        spinnerAmbientRed.setModel(new SpinnerNumberModel(255, 0, 255, 1));
        spinnerAmbientGreen.setModel(new SpinnerNumberModel(255, 0, 255, 1));
        spinnerAmbientBlue.setModel(new SpinnerNumberModel(255, 0, 255, 1));
        spinnerLight1Red.setModel(new SpinnerNumberModel(255, 0, 255, 1));
        spinnerLight1Green.setModel(new SpinnerNumberModel(255, 0, 255, 1));
        spinnerLight1Blue.setModel(new SpinnerNumberModel(255, 0, 255, 1));
        spinnerLight2Red.setModel(new SpinnerNumberModel(255, 0, 255, 1));
        spinnerLight2Green.setModel(new SpinnerNumberModel(255, 0, 255, 1));
        spinnerLight2Blue.setModel(new SpinnerNumberModel(255, 0, 255, 1));
    }
}
