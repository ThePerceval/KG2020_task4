package com.company.GUI.drawUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface pixelDrawer {
    void drawPixel(int x, int y, Color color);
    BufferedImage getBI();
}
