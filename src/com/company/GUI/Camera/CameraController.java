package com.company.GUI.Camera;

import com.company.Math.Matrix.Matrix4Factories;
import com.company.Screen.ScreenConverter;
import com.company.Screen.ScreenPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CameraController implements MouseListener, MouseWheelListener, MouseMotionListener {
    private List<RepaintListener> listeners = new ArrayList<RepaintListener>();

    public interface RepaintListener {
        void shouldRepaint();
    }

    public void addRepaintListener(RepaintListener repaintListener){
        listeners.add(repaintListener);
    }

    public void removeRepaintListener(RepaintListener repaintListener){
        listeners.remove(repaintListener);
    }

    private void onRepaint(){
        for(RepaintListener listener : listeners){
            listener.shouldRepaint();
        }
    }

    private Camera camera;
    private ScreenConverter sc;

    public CameraController(Camera camera, ScreenConverter sc) {
        this.camera = camera;
        this.sc = sc;
    }

    public ICamera getCamera() { return camera; }
    public void setCamera(Camera camera) { this.camera = camera; }
    public ScreenConverter getSc() { return sc; }
    public void setSc(ScreenConverter sc) { this.sc = sc; }

    private Point pointPressed;
    private boolean leftButton = false;
    private boolean middleButton = false;
    private boolean rightButton = false;

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e))
            leftButton = true;
        if(SwingUtilities.isRightMouseButton(e))
            rightButton = true;
        if(SwingUtilities.isMiddleMouseButton(e))
            middleButton = true;
        pointPressed = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e))
            leftButton = false;
        if(SwingUtilities.isRightMouseButton(e))
            rightButton = false;
        if(SwingUtilities.isMiddleMouseButton(e))
            middleButton = false;
        if(!leftButton && !rightButton && !middleButton)
            pointPressed = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        Point current = e.getPoint();
        if(pointPressed != null){
            int dx =pointPressed.x - current.x;
            int dy =pointPressed.y - current.y;
            if(leftButton){
                double deltaA = dx * Math.PI / 180;
                double deltaB = dy * Math.PI / 180;
                camera.modifyRotation(Matrix4Factories.rotationXYZ(deltaA, Matrix4Factories.Axis.Y).mul(
                        Matrix4Factories.rotationXYZ(deltaB, Matrix4Factories.Axis.X))
                );
            }
        }
        onRepaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {}
}
