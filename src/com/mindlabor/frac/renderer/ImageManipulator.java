/* 
 * Copyright (C) MindProjects - All Rights Reserved

 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential

 * Written by Samuel Braun <office.samigo.a@gmail.com>, January 2019
 */
package com.mindlabor.frac.renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import com.mindlabor.frac.main.ui.Edit;
import com.mindlabor.frac.math.Tools;

public class ImageManipulator {

    public static BufferedImage mix(float h, float s, float v, BufferedImage image) {
        try {
            BufferedImage cache = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < cache.getWidth(); x += (8-Edit.previewQuality)) {
                for (int y = 0; y < cache.getHeight(); y += (8-Edit.previewQuality)) {
                    cache = setRGBForRegion(x, y, mix(h, s, v, image.getRGB(x, y), x, y), cache.getWidth(), cache.getHeight(), cache);
                }
            }
            
            return cache;
        } catch (OutOfMemoryError e) { e.printStackTrace();  }
        return null;
    }

    public static int mix(float h, float s, float v, int color, int x, int y) {
        Color rgbColor = Tools.INTtoRGB(color);
        float[] hsv = new float[3];
        hsv = Color.RGBtoHSB(rgbColor.getRed(), rgbColor.getGreen(), rgbColor.getBlue(), hsv);

        hsv[0] = (hsv[0] + h) % 1f;
        hsv[1] = hsv[1] * s;
        hsv[2] = hsv[2] * v * 1f;

        return Color.HSBtoRGB(hsv[0], hsv[1], hsv[2]);
    }

    public static ImageIcon mix(float h, float s, float v, ImageIcon icon) {
        try {
            BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            image.getGraphics().drawImage(icon.getImage(), 0, 0, icon.getImageObserver());
            image = mix(h, s, v, image);
            return new ImageIcon(image);
        } catch (OutOfMemoryError e) { e.printStackTrace(); }
        return null;
    }

    public static BufferedImage setRGBForRegion(int x, int y, int color, int width, int height, BufferedImage image) {
        for (int i = 0; i < (8-Edit.previewQuality); i++) {
            for (int o = 0; o < (8-Edit.previewQuality); o++) {
                if (x + i < width && y + o < height) {
                    image.setRGB(x + i, y + o, color);
                }
            }
        }
        return image;
    }

}
