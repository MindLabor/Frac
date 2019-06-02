/*
 *  Frac Community Edition 2019 by MindProjects
 *  
 *  Copyright (C) MindProjects - All Rights Reserved
 *  
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  
 *  Written by Samuel Braun <office.samigo.a@gmail.com>, January 2019
 */
package ml.mindprojects.frac.community.renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import ml.mindprojects.frac.community.main.Main;
import ml.mindprojects.frac.community.main.ui.Edit;
import ml.mindprojects.frac.community.main.ui.Settings;
import ml.mindprojects.frac.community.math.Complex;
import static ml.mindprojects.frac.community.main.Main.*;
import ml.mindprojects.frac.community.math.Tools;
import ml.mindprojects.frac.community.pmanager.PManager;

/**
 *
 * @author Samuel Braun <MindProjects at www.mindprojects.ml>
 */
public class Renderer implements Runnable {
    
    public static double maxY = 0, minY = 0, maxX = 0, minX = 0;
    public static Thread[] threads = new Thread[Main.AVAILABLE_CORES];
    public static BufferedImage image;
    public static boolean miniOption = false;
    int threadIndex = 0;

    public Renderer(boolean miniOption) {
        Renderer.miniOption = miniOption;
    }
    public Renderer(int index) {
        threadIndex = index;
    }

    public BufferedImage render() {
        calcMathematicalWindowBounds();
        calcImage();
        return image;
    }
    
    void calcMathematicalWindowBounds(){
        maxY = Settings.coordinate.im() + 3.0 / (2.0 * Settings.zoom);
        minY = Settings.coordinate.im() - 3.0 / (2.0 * Settings.zoom);
        maxX = Settings.coordinate.re() + ((maxY - minY) * PManager.width / (2.0 * PManager.height));
        minX = Settings.coordinate.re() - ((maxY - minY) * PManager.width / (2.0 * PManager.height));
    }
    
    void calcImage(){
        image = new BufferedImage(PManager.width, PManager.height, BufferedImage.TYPE_INT_RGB);
        
        for(int i=0; i<AVAILABLE_CORES; i++) {
            threads[i] = new Thread(new Renderer(i));
            threads[i].start();
        }
        
        waitForThreads();
    }
    
    void waitForThreads(){
        for(Thread thread : threads){
            try {thread.join();} catch (InterruptedException ex) { ex.printStackTrace(); }
        }
    }
    
    //############################################# FRACTAL LOGIC ##################################################
    
    @Override
    public void run() {
        Complex c, z = new Complex(0, 0);
        
        masterLoop:
        for (int x = threadIndex*(PManager.width/AVAILABLE_CORES); x < (threadIndex+1)*(PManager.width/AVAILABLE_CORES); x += (8-Edit.previewQuality)) {
            for (int y = 0; y < PManager.height; y += (8-Edit.previewQuality)) {
                if (!PManager.running) break masterLoop;
                
                c = new Complex(Tools.map(x, 0, PManager.width, minX, maxX), -Tools.map(y, 0, PManager.height, maxY, minY));
                z = calcInitialValue(x, y);
                
                int currentIteration = -1;
                boolean abort = true;
                while (abort && ++currentIteration < PManager.iterations) {
                    z = applyFormula(z, c);
                    abort = applyTerminationCondition(z, c);
                }
                if (currentIteration < PManager.iterations)
                    setRGBForRegion(x, y, getColor(z, currentIteration), (threadIndex+1)*(PManager.width/AVAILABLE_CORES));
            }
        }
        
    }
    
    Complex calcInitialValue(int x, int y){
        switch(Settings.type){
            case GEOM: case MANDELBROT: return new Complex(0, 0);
            case JULIA: return new Complex(1.5 * (x - PManager.width / 2) / (0.5 * PManager.width), (y - PManager.height / 2) / (0.5 * PManager.height));
            case NEWTON: break;
        }
        return null;
    }
    
    Complex applyFormula(Complex z, Complex c){
        switch(Settings.type){
            case MANDELBROT:
                return z.times(z).plus(c);
            case JULIA: break; //return z.times(z).plus(new Complex(radius * Math.cos(theta), radius * Math.sin(theta))); 
            case NEWTON: break;
            case GEOM: 
                if(z.abs()<1.5){
                    return z.times(z).plus(c);
                }else{
                    return c.times(c).plus(z);
                }
        }
        return null;
    }
    
    boolean applyTerminationCondition(Complex z, Complex c){
        switch(Settings.terminationCondition){
            case NORMAL: return z.abs() < 4;
            case SPIKY: return Math.abs(z.im()) < 2 || Math.abs(z.re()) < 2;
        }
        return true;
    }
    
    int getColor(Complex z, int iterations){
        switch(Edit.colorSelection){
            case NORMAL: return Color.HSBtoRGB((float)(iterations / 256f), 1f, (float) (iterations / (iterations + 8.0)));
            case SMOOTH:
                double wert = iterations - Math.log(Math.log(z.abs())/Math.log(4.0))/Math.log(2.0);
                return Color.HSBtoRGB((float)(wert / 256f), 1f, (float) (wert / (wert + 8.0)));
            case DUAL: return iterations % 2 == 0 ? 0xffffff : 0xff0000;
        }
        return 0;
    }
    
    void setRGBForRegion(int x, int y, int color, int end) {
        for (int i = 0; i < (8-Edit.previewQuality); i++) {
            for (int o = 0; o < (8-Edit.previewQuality); o++) {
                if (x + i < end && y + o < PManager.height) {
                    image.setRGB(x + i, y + o, color);
                }
            }
        }
    }
    
    
}
