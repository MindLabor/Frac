package com.mindlabor.frac.pmanager;

import com.mindlabor.frac.renderer.Renderer;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import com.mindlabor.frac.main.ui.Edit;
import com.mindlabor.frac.main.ui.RenderPane;
import com.mindlabor.frac.main.ui.Settings;
import com.mindlabor.frac.main.ui.Window;
import com.mindlabor.frac.renderer.ImageManipulator;

public class PManager implements Runnable {

    public static BufferedImage fractal, miniFractal;
    public static boolean running = true;
    public static int width, height, iterations;

    public PManager() {
    }

    @Override
    public void run() {
        while (running) {
            if (Window.editOptionIsActive || Window.firstminiRender) {
                width = Edit.miniPreview.getWidth();
                height = Edit.miniPreview.getHeight();
                int cache = calcMaxIter();
                iterations = Settings.iterations>cache? cache : Settings.iterations;
            } else {
                width = Window.width;
                height = Window.height;
                iterations = Settings.iterations;
            }
            
            if (Edit.onlyColorUpdated) {
                updateColor();
                Edit.onlyColorUpdated = false;
            } else if (Window.updated()) {
                Window.setUpdated(false);
                render();
            } else sleep(200);
            
            if(Window.firstminiRender){
                Window.firstminiRender = false;
                Window.setUpdated(true);
            }
            
            System.gc();
        }
    }

    public void render() {
        if (Window.editOptionIsActive || Window.firstminiRender) {
            miniFractal = new Renderer(true).render();
        } else {
            fractal = new Renderer(false).render();
        }
        
        updateColor();
    }

    public void updateColor() {
        if (Window.editOptionIsActive || Window.firstminiRender) {
            if (miniFractal != null) {
                updatePreview(ImageManipulator.blur(ImageManipulator.mix(Edit.color1, Edit.color2, Edit.color3, miniFractal)));
            }
        } else {
            if (fractal != null) {
                updatePreview(ImageManipulator.blur(ImageManipulator.mix(Edit.color1, Edit.color2, Edit.color3, fractal)));
            }
        }

        
    }

    public static boolean sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
            return false;
        }
        return true;
    }

    public static void updatePreview(BufferedImage frac) {
        if (Window.editOptionIsActive || Window.firstminiRender) {
            if(frac.getHeight()<400){
                Edit.updateFrac(new ImageIcon(frac));
            }
        } else {
            if(frac.getHeight()>400){
                RenderPane.updateFrac(new ImageIcon(frac));
            }
        }
        
    }

    public static void terminate() {
        running = false;
    }

    int calcMaxIter() {
        return (int) (Math.sqrt(2 * Math.sqrt(Math.abs(1 - Math.sqrt(5 * Settings.zoom)))) * 66.5);
    }

}
