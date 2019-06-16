package com.mindlabor.frac.renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import com.mindlabor.frac.main.Main;
import com.mindlabor.frac.main.ui.Edit;
import com.mindlabor.frac.main.ui.Settings;
import com.mindlabor.frac.math.Complex;
import static com.mindlabor.frac.main.Main.*;
import static com.mindlabor.frac.main.ui.Settings.TYPE.NEWTON;
import com.mindlabor.frac.main.ui.Window;
import com.mindlabor.frac.math.Tools;
import com.mindlabor.frac.pmanager.PManager;

public class Renderer implements Runnable {
    
    public static double maxY = 0, minY = 0, maxX = 0, minX = 0, theta = 0;
    public static double[] progressInThreads = new double[Main.AVAILABLE_CORES];
    public static Thread[] threads = new Thread[Main.AVAILABLE_CORES];
    public static BufferedImage image;
    int threadIndex = 0;

    public Renderer() { }
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
            try {thread.join();} catch (InterruptedException ex) { ex.printStackTrace(System.out); }
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
                
                c = calcInitialConstant(x, y);
                z = calcInitialValue(x, y);
                
                int currentIteration = -1;
                boolean abort = true;
                while (abort && ++currentIteration < PManager.iterations) {
                    if(Settings.type == NEWTON){
                        Complex z_cache = applyNewtonMethod(z);
                        abort = applyTerminationCondition(z, z_cache);
                        z = z_cache;
                    }else{
                        z = applyFormula(z, c);
                        abort = applyTerminationCondition(z, c);
                    }
                }
                if (currentIteration < PManager.iterations)
                    setRGBForRegion(x, y, getColor(z, currentIteration), (threadIndex+1)*(PManager.width/AVAILABLE_CORES));
            }
            if (x%10==0) {
                progressInThreads[threadIndex] = (x-threadIndex*(PManager.width/AVAILABLE_CORES));
                Window.setProgress(getProgress());
            }
        }
        progressInThreads[threadIndex] = PManager.width/AVAILABLE_CORES;
        Window.setProgress(getProgress());
    }
    
    double getProgress() {
        double ges = 0;
        for (double n : progressInThreads){
            ges+=n;
        }
        return ges/(double)PManager.width;
    }
    
    Complex calcInitialConstant(int x, int y) {
        switch(Settings.type){
            case GEOM: case MANDELBROT: return new Complex(Tools.map(x, 0, PManager.width, minX, maxX), -Tools.map(y, 0, PManager.height, maxY, minY));
            case JULIA: return new Complex(Math.cos(Renderer.theta), Math.sin(Renderer.theta));
            case NEWTON: return new Complex(0.000001, 0.000001);
        }
        return null;
    }
    
    Complex calcInitialValue(int x, int y){
        switch(Settings.type){
            case GEOM: case MANDELBROT: return new Complex(0, 0);
            case JULIA: return new Complex(1.5 * (x - PManager.width / 2) / (0.5 * PManager.width), (y - PManager.height / 2) / (0.5 * PManager.height));
            case NEWTON: return new Complex(x * (maxX - minX) / (PManager.width - 1) + minX, y * (maxY - minY) / (PManager.height - 1) + minY);
        }
        return null;
    }
    
    Complex applyFormula(Complex z, Complex c){
        switch(Settings.type){
            case MANDELBROT:
            case JULIA:
                return z.times(z).plus(c); 
            case NEWTON: 
                return z.times(z).times(z).minus(new Complex(1, 0));
                        //z.times(z).times(z).times(z).times(z).minus(z); 
                        //z.times(z).times(z).minus(z.times(new Complex(2, 0))).plus(new Complex(2, 0));
                        //z.times(z).times(z).minus(new Complex(1, 0));
            case GEOM: 
                if (z.abs()<1.5) return z.times(z).plus(c);
                else return c.times(c).plus(z);
        }
        return null;
    }
    
    Complex applyNewtonMethod(Complex z) {
        Complex dz = (applyFormula(z.plus(new Complex(0.000001, 0.000001)), null).minus(applyFormula(z, null))).divides(new Complex(0.000001, 0.000001));
        return z.minus(applyFormula(z, null).divides(dz));
    }
    
    boolean applyTerminationCondition(Complex z, Complex c){
        switch(Settings.terminationCondition){
            case NORMAL: 
                if (Settings.type == NEWTON){
                    return c.minus(z).abs() >= 0.001;
                }else {
                    return z.abs() < 4;
                }
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
