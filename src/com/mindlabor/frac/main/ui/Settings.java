package com.mindlabor.frac.main.ui;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.Border;
import com.mindlabor.frac.main.Main;
import com.mindlabor.frac.math.Complex;
import org.apache.commons.math3.exception.MathParseException;

public class Settings extends javax.swing.JPanel {
    
    public static TYPE type = TYPE.MANDELBROT;
    public static TERMINATION terminationCondition = TERMINATION.NORMAL;
    public static double zoom = 1;
    public static int iterations = 150, threads, scrollVelo = 5;
    public static Complex coordinate = new Complex(0, 0);
    public static boolean updated = true;

    public static enum TYPE {
        MANDELBROT, JULIA, NEWTON, GEOM
    };

    public static enum TERMINATION {
        NORMAL, SPIKY
    };
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    private Border defaultBorder;

    public Settings() {
        initComponents();
        
        threadSlider.setMaximum(Main.AVAILABLE_CORES);
        threadSlider.setValue(Main.AVAILABLE_CORES/2);
        threads = Main.AVAILABLE_CORES/2;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        coordinatesInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        iterationsInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        help = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        modeCombo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        zoomInput = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        threadSlider = new javax.swing.JSlider();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(988, 634));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Coordinates");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Zoom");

        coordinatesInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        coordinatesInput.setText("0");
        coordinatesInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coordinatesInputKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Iterations");

        iterationsInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        iterationsInput.setText("150");
        iterationsInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                iterationsInputKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel4.setText("<html>The coordinate of the fractal is a complex number,  <br> whose real part is represented by the x and it's <br> imaginary by the y-axis. <b>It has to be a complex number!</b></html>");

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel5.setText("<html>The normal fractal zoom is 1.<b> It cannot be 0!</b></html>");

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel6.setText("<html>The maximum iterations, in addition to the main <br> termination criterion, act as a second one. The standard value <br> at a zoom of 1 is 150. <b>It has to be an Integer!</b></html>");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Type");

        jLabel8.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel8.setText("<html>There are several types of fractals. In this context, <br> the type indicates the iteration formula.</html>");

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mindlabor/frac/main/ui/assets/information-icon.png"))); // NOI18N
        help.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpMouseExited(evt);
            }
        });

        typeCombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mandelbrot", "Julia", "Newton", "Geom" }));
        typeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Mode");

        modeCombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Spiky" }));
        modeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeComboActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel10.setText("<html>The mode can modify the termination <br> condition.</html>");

        zoomInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        zoomInput.setText("1");
        zoomInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                zoomInputKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Threads");

        threadSlider.setBackground(new java.awt.Color(255, 255, 255));
        threadSlider.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        threadSlider.setMajorTickSpacing(2);
        threadSlider.setMaximum(2);
        threadSlider.setMinimum(1);
        threadSlider.setMinorTickSpacing(1);
        threadSlider.setPaintLabels(true);
        threadSlider.setPaintTicks(true);
        threadSlider.setSnapToTicks(true);
        threadSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                threadSliderMouseReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel12.setText("<html>The number of cores (threads) that are used to render the fractal.</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(iterationsInput, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(help))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(coordinatesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(zoomInput, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(threadSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zoomInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(help))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(iterationsInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coordinatesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(threadSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseClicked
        Window.previewOptionIsActive = false;
        Window.settingsOptionIsActive = false;
        Window.editOptionIsActive = false;
        Window.wikiOptionIsActive = true;
        Main.window.updateOptionUI();

        defaultBorder = zoomInput.getBorder();
        
        Window.setOptionPanel("wiki");
    }//GEN-LAST:event_helpMouseClicked

    private void helpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseEntered
        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mindlabor/frac/main/ui/assets/information-icon2.png")));
    }//GEN-LAST:event_helpMouseEntered

    private void helpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseExited
        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mindlabor/frac/main/ui/assets/information-icon.png")));
    }//GEN-LAST:event_helpMouseExited

    private void typeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboActionPerformed
        TYPE cache = TYPE.values()[typeCombo.getSelectedIndex()];
        if(cache != type){
            type = cache;
            updated = true;
        }
    }//GEN-LAST:event_typeComboActionPerformed

    private void modeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeComboActionPerformed
        TERMINATION cache = TERMINATION.values()[modeCombo.getSelectedIndex()];
        if(cache != terminationCondition){
            terminationCondition = cache;
            updated = true;
        }
    }//GEN-LAST:event_modeComboActionPerformed

    private void zoomInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zoomInputKeyReleased
        String input = zoomInput.getText().replaceAll("\\,", "\\.");
        if(isADouble(input)){
            double number = Double.parseDouble(input);
            if(number!=0){
                zoom = number;
                updated = true;
                attachError(zoomInput, false, "");
            } else attachError(zoomInput, true, "Zoom is zero");
        } else attachError(zoomInput, true, "Not a double");
    }//GEN-LAST:event_zoomInputKeyReleased

    private void iterationsInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iterationsInputKeyReleased
        String input = iterationsInput.getText().replaceAll("\\,", "\\.");
        if(isAnInteger(input)){
            int number = Integer.parseInt(input);
            if(number>0){
                iterations = number;
                updated = true;
                attachError(iterationsInput, false, "");
            } else attachError(iterationsInput, true, "Iterations is negative or zero");
        } else attachError(iterationsInput, true, "Not an Integer");
    }//GEN-LAST:event_iterationsInputKeyReleased

    private void coordinatesInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coordinatesInputKeyReleased
        try {
            String input = coordinatesInput.getText().replaceAll("\\.", "\\,");
            Complex cache = Complex.parseComplex(input);
            if(cache!=null){
                coordinate = cache;
                updated = true;
                attachError(coordinatesInput, false, "");
                return;
            }
            attachError(coordinatesInput, true, "Complex: cache is null");
        } catch (MathParseException | NullPointerException e) {
            attachError(coordinatesInput, true, "Is not complex");
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_coordinatesInputKeyReleased

    private void threadSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threadSliderMouseReleased
        threads = threadSlider.getValue();
    }//GEN-LAST:event_threadSliderMouseReleased

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    public static boolean setZoom(double zoom){
        if(zoom != 0){
            zoomInput.setText(zoom + "");
            return true;
        }
        return false;
    }
    
    private boolean isADouble(String input){
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
    
    private boolean isAnInteger(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
    
    private void attachError(JTextField field, boolean error, String msg){
        if (error){
            //System.out.println(msg);
            field.setForeground(new Color(210, 0, 0));
        } else field.setForeground(Color.BLACK);
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField coordinatesInput;
    private javax.swing.JLabel help;
    private javax.swing.JTextField iterationsInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> modeCombo;
    private javax.swing.JSlider threadSlider;
    private javax.swing.JComboBox<String> typeCombo;
    public static javax.swing.JTextField zoomInput;
    // End of variables declaration//GEN-END:variables
}
