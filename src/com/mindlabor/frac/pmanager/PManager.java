package com.mindlabor.frac.pmanager;

import com.mindlabor.frac.renderer.Renderer;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import com.mindlabor.frac.main.ui.Edit;
import com.mindlabor.frac.main.ui.RenderPane;
import com.mindlabor.frac.main.ui.Settings;
import com.mindlabor.frac.main.ui.Window;
import com.mindlabor.frac.renderer.ImageManipulator;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PManager implements Runnable {

    public static BufferedImage fractal, miniFractal, saveFractal;
    public static boolean running = true, exportMode = false;
    public static int width, height, iterations;

    public PManager() {
    }

    @Override
    public void run() {
        while (running) {
            if ((Window.editOptionIsActive || Window.firstminiRender) && !exportMode) {
                width = Edit.miniPreview.getWidth();
                height = Edit.miniPreview.getHeight();
                int cache = calcMaxIter();
                iterations = Settings.iterations>cache? cache : Settings.iterations;
            } else if (!exportMode) {
                width = Window.width;
                height = Window.height;
                iterations = Settings.iterations;
            } else {
                width = Window.widthh;
                height = Window.heightt;
                Edit.previewQuality = 7;
                render();
                exportMode = false;
                System.gc();
                continue;
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
        if ((Window.editOptionIsActive || Window.firstminiRender) && !exportMode) {
            miniFractal = new Renderer().render();
        } else if (!exportMode) {
            fractal = new Renderer().render();
        } else {
            saveFractal = new Renderer().render();
        } 
        
        updateColor();
    }

    public void updateColor() {
        if ((Window.editOptionIsActive || Window.firstminiRender) && !exportMode) {
            if (miniFractal != null) {
                updatePreview(ImageManipulator.blur(ImageManipulator.mix(Edit.color1, Edit.color2, Edit.color3, miniFractal)));
            }
        } else if (!exportMode) {
            if (fractal != null) {
                updatePreview(ImageManipulator.blur(ImageManipulator.mix(Edit.color1, Edit.color2, Edit.color3, fractal)));
            }
        } else {
            if (saveFractal != null) {
                saveFractal = ImageManipulator.blur(ImageManipulator.mix(Edit.color1, Edit.color2, Edit.color3, saveFractal));
                try {
                    ImageIO.write(PManager.saveFractal, "png", new File(Window.namee + ".png"));
                } catch (IOException ex) {
                    System.out.println("ERRRRRRRRRRRRRREEEEEEOEOEOEOEO!!!!!!!");
                    ex.printStackTrace();
                }
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
