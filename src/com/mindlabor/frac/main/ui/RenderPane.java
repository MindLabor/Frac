/* 
 * Frac Community Edition 2019 by MindProjects
 * 
 * Copyright (C) MindProjects - All Rights Reserved
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 
 * Written by Samuel Braun <office.samigo.a@gmail.com>, January 2019
 */
package com.mindlabor.frac.main.ui;

import javax.swing.ImageIcon;
import com.mindlabor.frac.math.Complex;
import com.mindlabor.frac.math.Tools;
import com.mindlabor.frac.renderer.Renderer;

/**
 *
 * @author Samuel Braun <MindProjects at www.mindprojects.ml>
 */
public class RenderPane extends javax.swing.JPanel {
    
    public static boolean updated = true;
    double startX = 0, startY = 0;
    boolean startDrag = false, dragged = false;

    public RenderPane() {
        initComponents();
        
    }
    
    public static void updateFrac(ImageIcon frac){
        
        renderPane.setIcon(frac);
    }
    
    public void updateSize(){
        setSize(Window.width, Window.height);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        renderPane = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        renderPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                renderPaneMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                renderPaneMouseMoved(evt);
            }
        });
        renderPane.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                renderPaneMouseWheelMoved(evt);
            }
        });
        renderPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                renderPaneMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                renderPaneMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(renderPane, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(renderPane, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void renderPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_renderPaneMousePressed
        startDrag = true;
    }//GEN-LAST:event_renderPaneMousePressed

    private void renderPaneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_renderPaneMouseReleased
        if (dragged) {
            try {
                switch (Settings.type) {
                    case MANDELBROT: case GEOM:
                        double mouseX = evt.getX(),
                         mouseY = evt.getY();
                        double dx = -(mouseX - startX),
                         dy = (mouseY - startY);

                        //#################  TRANFORM (dx, dy) TO FRACTAL COORDINATE SYSTEM   ######################//
                        double maxY = mouseY + 3.0 / (2 * Settings.zoom);
                        double minY = mouseY - 3.0 / (2 * Settings.zoom);
                        double maxX = mouseX + ((maxY - minY) * Window.width / (2 * Window.height));
                        double minX = mouseX - ((maxY - minY) * Window.width / (2 * Window.height));
                        dx = (dx * (maxX - minX)) * 1.0 / Window.width;
                        dy = (dy * (maxY - minY)) * 1.0 / Window.height;
                        
                        //#################  SET NEW VALUES   ######################//
                        Settings.coordinate = new Complex (Settings.coordinate.re()+dx, Settings.coordinate.im()+dy);
                        Settings.coordinatesInput.setText(Settings.coordinate.toString());
                        break;
                }

            } catch (NumberFormatException e) { }
            dragged = false;
            render();
        }
    }//GEN-LAST:event_renderPaneMouseReleased

    private void renderPaneMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_renderPaneMouseDragged
        if (startDrag) {
            startX = evt.getX();
            startY = evt.getY();
            startDrag = false;
        }
        dragged = true;
    }//GEN-LAST:event_renderPaneMouseDragged

    private void renderPaneMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_renderPaneMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_renderPaneMouseMoved

    private void renderPaneMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_renderPaneMouseWheelMoved
        try {
            double newZoom;
            switch (Settings.type) {
                case MANDELBROT: case GEOM:
                    newZoom = (-(evt.getWheelRotation() * Settings.zoom / 2.0) * Settings.scrollVelo / 5f + Settings.zoom);
                    double mouseX = evt.getX(), mouseY = evt.getY();

                    //#################  TRANFORM (mouseX, mouseY) TO FRACTAL COORDINATE SYSTEM   ######################//
                    double maxY = Settings.coordinate.im() + 3.0 / (2 * Settings.zoom);
                    double minY = Settings.coordinate.im() - 3.0 / (2 * Settings.zoom);
                    double maxX = Settings.coordinate.re() + ((maxY - minY) *  Window.width / (2 * Window.height));
                    double minX = Settings.coordinate.re() - ((maxY - minY) *  Window.width / (2 * Window.height));
                    mouseX = Tools.map(mouseX, 0,  Window.width, minX, maxX);
                    mouseY = Tools.map(mouseY, 0,  Window.height, maxY, minY);

                    //#################  SET NEW VALUES   ######################//
                    Settings.zoom = Math.abs(newZoom);
                    Settings.coordinate = new Complex((mouseX + 2 * Settings.coordinate.re()) / 3.0, (mouseY + 2 * Settings.coordinate.im()) / 3.0);
                    Settings.zoomInput.setText(Settings.zoom + "");
                    Settings.coordinatesInput.setText(Settings.coordinate.toString());

                    break;
                case JULIA:
                    Renderer.theta = (-evt.getWheelRotation() * (2f / 5f) * Math.PI / 20.0 + Renderer.theta);
                    //zoomInput.setText("" + juliaZoom);
                    //xInput.setText("" + theta);
                    break;
            }
            render();
        } catch (NumberFormatException e) { }
    }//GEN-LAST:event_renderPaneMouseWheelMoved

    
    private void render(){
        Window.setUpdated(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel renderPane;
    // End of variables declaration//GEN-END:variables
}
