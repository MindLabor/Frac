package com.mindlabor.frac.math;

import java.awt.Color;

public class Tools 
{
    
    public static double map(double value, double start1, double stop1, double start2, double stop2){
        return ((value - start1) / (stop1 - start1)) * (stop2 - start2) + start2;
    }
    
    public static int RGBtoINT(int red, int green, int blue) {
        return (((red << 8) | green) << 8) | blue;
    }

    public static Color INTtoRGB(int rgb) {
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;
        return new Color(r, g, b);
    }
}
