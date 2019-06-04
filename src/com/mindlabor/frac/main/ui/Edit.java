
package com.mindlabor.frac.main.ui;

import javax.swing.ImageIcon;

public class Edit extends javax.swing.JPanel 
{

    public static enum BLEND_MODE {MULTIPLY, ADD, MIX}
    public static enum COLOR_SELECTION {NORMAL, SMOOTH, DUAL}
    public static BLEND_MODE blendMode = BLEND_MODE.MULTIPLY;
    public static COLOR_SELECTION colorSelection = COLOR_SELECTION.NORMAL;
    public static float color1 = 0f, color2 = 1f, color3 = 1f, strength = 0, radius = 0;
    public static int previewQuality = 6, miniWidth, miniHeight;
    public static boolean updated = true, onlyColorUpdated = false;
    
    
    public Edit() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabe1 = new javax.swing.JLabel();
        colorModePanel = new javax.swing.JPanel();
        colorModeLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        colorLabel1 = new javax.swing.JLabel();
        c1Slider = new javax.swing.JSlider();
        colorLabel3 = new javax.swing.JLabel();
        c2Slider = new javax.swing.JSlider();
        colorLabel2 = new javax.swing.JLabel();
        c3Slider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        colorSelectionCombo = new javax.swing.JComboBox<>();
        colorLabel4 = new javax.swing.JLabel();
        colorLabel5 = new javax.swing.JLabel();
        bl1Slider = new javax.swing.JSlider();
        bl2Slider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        previewQualitySlider = new javax.swing.JSlider();
        miniPreview = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabe1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabe1.setText("Colors");

        colorModePanel.setBackground(new java.awt.Color(102, 0, 102));

        colorModeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        colorModeLabel.setForeground(new java.awt.Color(255, 255, 255));
        colorModeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        colorModeLabel.setText("H S V");
        colorModeLabel.setToolTipText("");
        colorModeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorModeLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                colorModeLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                colorModeLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout colorModePanelLayout = new javax.swing.GroupLayout(colorModePanel);
        colorModePanel.setLayout(colorModePanelLayout);
        colorModePanelLayout.setHorizontalGroup(
            colorModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colorModeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        colorModePanelLayout.setVerticalGroup(
            colorModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colorModeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        colorLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        colorLabel1.setText("Hue");
        colorLabel1.setPreferredSize(new java.awt.Dimension(82, 35));
        jPanel1.add(colorLabel1);

        c1Slider.setBackground(new java.awt.Color(255, 255, 255));
        c1Slider.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        c1Slider.setMajorTickSpacing(40);
        c1Slider.setMinimum(-100);
        c1Slider.setMinorTickSpacing(10);
        c1Slider.setPaintLabels(true);
        c1Slider.setPaintTicks(true);
        c1Slider.setValue(0);
        c1Slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c1SliderMouseReleased(evt);
            }
        });
        jPanel1.add(c1Slider);

        colorLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        colorLabel3.setText("Saturation");
        colorLabel3.setPreferredSize(new java.awt.Dimension(82, 35));
        jPanel1.add(colorLabel3);

        c2Slider.setBackground(new java.awt.Color(255, 255, 255));
        c2Slider.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        c2Slider.setMajorTickSpacing(40);
        c2Slider.setMinimum(-100);
        c2Slider.setMinorTickSpacing(10);
        c2Slider.setPaintLabels(true);
        c2Slider.setPaintTicks(true);
        c2Slider.setValue(100);
        c2Slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c2SliderMouseReleased(evt);
            }
        });
        jPanel1.add(c2Slider);

        colorLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        colorLabel2.setText("Value");
        colorLabel2.setPreferredSize(new java.awt.Dimension(82, 35));
        jPanel1.add(colorLabel2);

        c3Slider.setBackground(new java.awt.Color(255, 255, 255));
        c3Slider.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        c3Slider.setMajorTickSpacing(40);
        c3Slider.setMinimum(-100);
        c3Slider.setMinorTickSpacing(10);
        c3Slider.setPaintLabels(true);
        c3Slider.setPaintTicks(true);
        c3Slider.setValue(100);
        c3Slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                c3SliderMouseReleased(evt);
            }
        });
        jPanel1.add(c3Slider);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Blur");

        colorSelectionCombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        colorSelectionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Smooth", "Dual" }));
        colorSelectionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorSelectionComboActionPerformed(evt);
            }
        });

        colorLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        colorLabel4.setText("Strength");
        colorLabel4.setPreferredSize(new java.awt.Dimension(82, 35));

        colorLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        colorLabel5.setText("Radius");
        colorLabel5.setPreferredSize(new java.awt.Dimension(82, 40));

        bl1Slider.setBackground(new java.awt.Color(255, 255, 255));
        bl1Slider.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        bl1Slider.setMajorTickSpacing(20);
        bl1Slider.setMinorTickSpacing(5);
        bl1Slider.setPaintLabels(true);
        bl1Slider.setPaintTicks(true);
        bl1Slider.setValue(0);
        bl1Slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bl1SliderMouseReleased(evt);
            }
        });

        bl2Slider.setBackground(new java.awt.Color(255, 255, 255));
        bl2Slider.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        bl2Slider.setMajorTickSpacing(5);
        bl2Slider.setMaximum(20);
        bl2Slider.setMinorTickSpacing(1);
        bl2Slider.setPaintLabels(true);
        bl2Slider.setPaintTicks(true);
        bl2Slider.setSnapToTicks(true);
        bl2Slider.setValue(3);
        bl2Slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bl2SliderMouseReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Mode");

        jLabel7.setFont(new java.awt.Font("Roboto Light", 0, 11)); // NOI18N
        jLabel7.setText("<html>The mode can modify the color selection rule.</html>");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel5.setText("Preview Quality");

        previewQualitySlider.setBackground(new java.awt.Color(255, 255, 255));
        previewQualitySlider.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        previewQualitySlider.setMajorTickSpacing(2);
        previewQualitySlider.setMaximum(7);
        previewQualitySlider.setMinimum(1);
        previewQualitySlider.setMinorTickSpacing(1);
        previewQualitySlider.setPaintLabels(true);
        previewQualitySlider.setPaintTicks(true);
        previewQualitySlider.setSnapToTicks(true);
        previewQualitySlider.setValue(6);
        previewQualitySlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                previewQualitySliderMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bl1Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bl2Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabe1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(colorModePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addComponent(miniPreview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(colorLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(colorLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(colorSelectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(previewQualitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabe1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addComponent(colorModePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bl1Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(colorLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(colorLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bl2Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(colorSelectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(miniPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(previewQualitySlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161))))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void updateFrac(ImageIcon iicon){
        miniPreview.setIcon(iicon);
    }
    
    private void colorModeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorModeLabelMouseClicked
        
    }//GEN-LAST:event_colorModeLabelMouseClicked

    private void colorModeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorModeLabelMouseEntered
        
    }//GEN-LAST:event_colorModeLabelMouseEntered

    private void colorModeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorModeLabelMouseExited
        
    }//GEN-LAST:event_colorModeLabelMouseExited

    private void c1SliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1SliderMouseReleased
        color1 = (c1Slider.getValue()+100)/200f;
        onlyColorUpdated = true;
    }//GEN-LAST:event_c1SliderMouseReleased

    private void c2SliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c2SliderMouseReleased
        color2 = (c2Slider.getValue()+100)/200f;
        onlyColorUpdated = true;
    }//GEN-LAST:event_c2SliderMouseReleased

    private void c3SliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c3SliderMouseReleased
        color3 = (c3Slider.getValue()+100)/200f;
        onlyColorUpdated = true;
    }//GEN-LAST:event_c3SliderMouseReleased

    private void bl1SliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl1SliderMouseReleased
        strength = bl1Slider.getValue();
        onlyColorUpdated = true;
    }//GEN-LAST:event_bl1SliderMouseReleased
    
    private void bl2SliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bl2SliderMouseReleased
        radius = bl2Slider.getValue();
        onlyColorUpdated = true;
    }//GEN-LAST:event_bl2SliderMouseReleased

    private void colorSelectionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorSelectionComboActionPerformed
        colorSelection = COLOR_SELECTION.values()[colorSelectionCombo.getSelectedIndex()];
        updated = true;
    }//GEN-LAST:event_colorSelectionComboActionPerformed

    private void previewQualitySliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewQualitySliderMouseReleased
        previewQuality = previewQualitySlider.getValue();
        updated = true;
    }//GEN-LAST:event_previewQualitySliderMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider bl1Slider;
    private javax.swing.JSlider bl2Slider;
    private javax.swing.JSlider c1Slider;
    private javax.swing.JSlider c2Slider;
    private javax.swing.JSlider c3Slider;
    private javax.swing.JLabel colorLabel1;
    private javax.swing.JLabel colorLabel2;
    private javax.swing.JLabel colorLabel3;
    private javax.swing.JLabel colorLabel4;
    private javax.swing.JLabel colorLabel5;
    private javax.swing.JLabel colorModeLabel;
    private javax.swing.JPanel colorModePanel;
    private javax.swing.JComboBox<String> colorSelectionCombo;
    private javax.swing.JLabel jLabe1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel miniPreview;
    private javax.swing.JSlider previewQualitySlider;
    // End of variables declaration//GEN-END:variables
}
