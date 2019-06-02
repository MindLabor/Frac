/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mindprojects.frac.main;

import java.awt.Color;
import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

/**
 *
 * @author Samuel Braun <MindProjects at www.mindprojects.ml>
 */
public class Texture {

    public double coorX = -0.7967117394032791, coorY = 0.17874711341723692, maxY = 0, minY = 0, maxX = 0, minX = 0;
    public static int width = Main.WIDTH, height = Main.HEIGHT, id, precision = 100;

    public static ByteBuffer pixels = BufferUtils.createByteBuffer(width * height * 4);

    public Texture() {
        maxY = coorY + 3.0 / (2 * Main.zoom);
        minY = coorY - 3.0 / (2 * Main.zoom);
        maxX = coorX + ((maxY - minY) * width / (2 * height));
        minX = coorX - ((maxY - minY) * width / (2 * height));
    }

    public void render() {
        iterate(minX, maxX, minY, maxY, precision, 0, 0, 0, 1);
    }

    public static Complex z = null;

    public void iterate(double minX, double maxX, double minY, double maxY, int precision, double a, double b, int color, int thread) {
        master:

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                a = map(x, 0, width, minX, maxX);
                b = map(y, 0, height, maxY, minY);

                Complex z = new Complex(0, 0);

                int currentIteration = 0;
                boolean abort = true;
                while (abort && currentIteration < precision) {
                    z = z.times(z).plus(new Complex(a, -b));
                    abort = z.abs() < 4;
                    currentIteration++;
                }
                color = 0;
                if (currentIteration < precision) {
                    color = Color.HSBtoRGB((float) (currentIteration / 256f), 1f, (float) (currentIteration / (currentIteration + 8.0)));
                }
                pixels.put((byte) ((color >> 16) & 0xFF));
                pixels.put((byte) ((color >> 8) & 0xFF));
                pixels.put((byte) (color & 0xFF));
                pixels.put((byte) ((color >> 24) & 0xFF));
            }
        }

        pixels.flip();

        id = glGenTextures();

        glBindTexture(GL_TEXTURE_2D, id);
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels);

    }

    public void bind(int sampler) {
        if (sampler >= 0 && sampler <= 31) {
            glActiveTexture(GL_TEXTURE0 + sampler);
            glBindTexture(GL_TEXTURE_2D, id);
        }
    }

    public static double map(double value, double start1, double stop1, double start2, double stop2) {
        return ((value - start1) / (stop1 - start1)) * (stop2 - start2) + start2;
    }
}
