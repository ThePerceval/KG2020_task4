package com.company.Screen;

import com.company.Math.Vector.Vector3;

public class ScreenConverter {
    private double xReal, yReal, widthReal, heightReal;
    private int widthScreen, heightScreen;

    public ScreenConverter(double xReal, double yReal, double widthReal, double heightReal, int widthScreen, int heightScreen) {
        this.xReal = xReal;
        this.yReal = yReal;
        this.widthReal = widthReal;
        this.heightReal = heightReal;
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
    }

    public ScreenPoint converterReal2Screen(Vector3 realPoint){
        double x = (realPoint.getX() - xReal) * widthScreen / widthReal;
        double y = (yReal - realPoint.getY()) * heightScreen / heightReal;
        return new ScreenPoint((int) x, (int) y);
    }
    public double converterReal2ScreenX(double realX){
        return (realX - xReal) * widthScreen / widthReal;
    }
    public double converterReal2ScreenY(double realY){
        return (yReal - realY) * heightScreen / heightReal;
    }

    public Vector3 converterScreen2Real(ScreenPoint screenPoint, double z){
        double x = xReal + (screenPoint.getX() * widthReal / widthScreen);
        double y = yReal - (screenPoint.getY() * heightReal / heightScreen);
        return new Vector3(x, y, z);
    }

    public double converterScreen2RealX(int screenX){
        return xReal + (screenX * widthReal / widthScreen);
    }
    public double converterScreen2RealY(int screenY){
        return yReal - (screenY * heightReal / heightScreen);
    }

    public double getxReal() {
        return xReal;
    }

    public void setxReal(double xReal) {
        this.xReal = xReal;
    }

    public double getyReal() {
        return yReal;
    }

    public void setyReal(double yReal) {
        this.yReal = yReal;
    }

    public double getWidthReal() {
        return widthReal;
    }

    public void setWidthReal(double widthReal) {
        this.widthReal = widthReal;
    }

    public double getHeightReal() {
        return heightReal;
    }

    public void setHeightReal(double heightReal) {
        this.heightReal = heightReal;
    }

    public int getWidthScreen() {
        return widthScreen;
    }

    public void setWidthScreen(int widthScreen) {
        this.widthScreen = widthScreen;
    }

    public int getHeightScreen() {
        return heightScreen;
    }

    public void setHeightScreen(int heightScreen) {
        this.heightScreen = heightScreen;
    }
}
