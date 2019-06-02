package com.mindprojects.frac.main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

/**
 *
 * @author Samuel Braun <MindProjects at www.mindprojects.ml>
 */
public class Main implements Runnable {

    public static final int WIDTH = 830, HEIGHT = 634;
    private long window;

    private Thread thread;
    private boolean running = false;
    private float fps = 0;
    public static double zoom = 1;
    
    
    public static float[] vertices = new float[] {
            -1, 1,
            1, 1,
            1, -1,
            
            1, -1,
            -1, -1,
            -1, 1
            
        };
        
    public static float[] texture = new float[]{
            0, 0,
            1, 0,
            1, 1,
            
            1, 1,
            0, 1,
            0, 0
        };

    public void start() {
        thread = new Thread(this, "MainLoop Thread");
        thread.start();
    }

    private void init() {
        if (!glfwInit()) {
            throw new IllegalStateException("Failed to initialize GLFW!");
        }

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        window = glfwCreateWindow(WIDTH, HEIGHT, "The Window", 0, 0);
        if (window == 0) {
            throw new IllegalStateException("Failed to create Window!");
        }

        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, (vidmode.width() - WIDTH) / 2, (vidmode.height() - HEIGHT) / 2);

        glfwShowWindow(window);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        glEnable(GL_TEXTURE_2D);
        
        
        
    }

    private Model model;

    @Override
    public void run() {
        init();

        Texture tex = new Texture();
        Shader shader = new Shader("shader");

        int frames = 0;
        long time = 0;
        while (!glfwWindowShouldClose(window)) {
            
            if (frames % 10 == 0) {
                time = System.currentTimeMillis();
            }

            tex = new Texture();
            update();
            
            glfwPollEvents();
            glClear(GL_COLOR_BUFFER_BIT);
            
            shader.bind();
            model.render();
            render(tex);
            frames++;

            if (frames % 10 == 0) {
                fps = 10000f/(System.currentTimeMillis()-time);
                System.out.println(fps);
            }
            zoom+=0.04*zoom/2;

        }

        glfwTerminate();
    }

    private void update() {
        if (glfwGetKey(window, GLFW_KEY_A) == GL_TRUE) {
            System.out.println("A");
        }
        
        
        
        model = new Model(vertices, texture);
    }

    private void render(Texture tex) {
        tex.render();
        tex.bind(0);

        
        glfwSwapBuffers(window);
    }

    public static void main(String[] args) {
        new Main().start();
    }

}
