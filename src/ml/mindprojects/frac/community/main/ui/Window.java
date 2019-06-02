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
package ml.mindprojects.frac.community.main.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import ml.mindprojects.frac.community.pmanager.PManager;

/**
 *
 * @author Samuel Braun <MindProjects at www.mindprojects.ml>
 */
public class Window extends javax.swing.JFrame {

    public static boolean previewOptionIsActive = true;
    public static boolean settingsOptionIsActive = false;
    public static boolean editOptionIsActive = false;
    public static boolean wikiOptionIsActive = false;
    public static boolean infoOptionIsActive = false;

    public static boolean previewOptionIsHover = false;
    public static boolean wikiOptionIsHover = false;
    public static boolean settingsOptionIsHover = false;
    public static boolean editOptionIsHover = false, firstminiRender = true;
    public static int width, height;
    public final ImageIcon LOGO = new ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/logo2.png"));

    final Color optionActiveColor = new Color(85, 65, 118);
    final Color optionHoverColor = new Color(74, 54, 109);
    final Color optionDefaultColor = new Color(64, 43, 100);
    final Settings settingsPanel = new Settings();
    final Edit editPanel = new Edit();
    public RenderPane renderPanePanel = new RenderPane();
    final Wiki wikiPanel = new Wiki();
    final Info infoPanel = new Info();

    public Window() {
        initComponents();

        mainPane.add(settingsPanel, "settings");
        mainPane.add(editPanel, "edit");
        mainPane.add(renderPanePanel, "renderPane");
        mainPane.add(wikiPanel, "wiki");
        mainPane.add(infoPanel, "info");
        mainPane.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(54, 33, 89)));

        setOptionPanel("renderPane");
        setIconImage(LOGO.getImage());

        width = mainPane.getWidth();
        height = mainPane.getHeight();

        renderPanePanel.updateSize();
        
        new Thread(new PManager()).start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        masterPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        previewOption = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        settingsOption = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        editOption = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        wikiOption = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        close = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        minimize = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        help = new javax.swing.JLabel();
        mainPane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Frac Community 2019");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon("/ml/mindprojects/frac/community/main/ui/assets/32.png").getImage());
        setLocationByPlatform(true);
        setName("window"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        masterPanel.setBackground(new java.awt.Color(255, 255, 255));

        sidePanel.setBackground(new java.awt.Color(54, 33, 89));

        previewOption.setBackground(new java.awt.Color(85, 65, 118));
        previewOption.setPreferredSize(new java.awt.Dimension(312, 60));
        previewOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previewOptionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                previewOptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                previewOptionMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/preview_icon.png"))); // NOI18N
        jLabel1.setText("Preview");
        jLabel1.setIconTextGap(73);

        javax.swing.GroupLayout previewOptionLayout = new javax.swing.GroupLayout(previewOption);
        previewOption.setLayout(previewOptionLayout);
        previewOptionLayout.setHorizontalGroup(
            previewOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, previewOptionLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        previewOptionLayout.setVerticalGroup(
            previewOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, previewOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        settingsOption.setBackground(new java.awt.Color(64, 43, 100));
        settingsOption.setPreferredSize(new java.awt.Dimension(362, 60));
        settingsOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsOptionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsOptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsOptionMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/settings_icon.png"))); // NOI18N
        jLabel2.setText("Settings");
        jLabel2.setIconTextGap(73);

        javax.swing.GroupLayout settingsOptionLayout = new javax.swing.GroupLayout(settingsOption);
        settingsOption.setLayout(settingsOptionLayout);
        settingsOptionLayout.setHorizontalGroup(
            settingsOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsOptionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        settingsOptionLayout.setVerticalGroup(
            settingsOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        editOption.setBackground(new java.awt.Color(64, 43, 100));
        editOption.setPreferredSize(new java.awt.Dimension(362, 60));
        editOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editOptionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editOptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editOptionMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/edit_icon.png"))); // NOI18N
        jLabel3.setText("Edit");
        jLabel3.setIconTextGap(73);

        javax.swing.GroupLayout editOptionLayout = new javax.swing.GroupLayout(editOption);
        editOption.setLayout(editOptionLayout);
        editOptionLayout.setHorizontalGroup(
            editOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editOptionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        editOptionLayout.setVerticalGroup(
            editOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/128.png"))); // NOI18N
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel7MouseDragged(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        wikiOption.setBackground(new java.awt.Color(64, 43, 100));
        wikiOption.setPreferredSize(new java.awt.Dimension(362, 60));
        wikiOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wikiOptionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                wikiOptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                wikiOptionMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/Wikipedia-icon.png"))); // NOI18N
        jLabel8.setText("Wiki");
        jLabel8.setIconTextGap(73);

        javax.swing.GroupLayout wikiOptionLayout = new javax.swing.GroupLayout(wikiOption);
        wikiOption.setLayout(wikiOptionLayout);
        wikiOptionLayout.setHorizontalGroup(
            wikiOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wikiOptionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        wikiOptionLayout.setVerticalGroup(
            wikiOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wikiOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(previewOption, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
            .addComponent(settingsOption, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
            .addComponent(editOption, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wikiOption, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewOption, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(settingsOption, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(editOption, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(wikiOption, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );

        topPanel.setBackground(new java.awt.Color(122, 72, 221));
        topPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topPanelMouseDragged(evt);
            }
        });
        topPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topPanelMousePressed(evt);
            }
        });

        close.setBackground(new java.awt.Color(122, 72, 221));
        close.setPreferredSize(new java.awt.Dimension(100, 35));
        close.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                closeMouseDragged(evt);
            }
        });
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                closeMouseReleased(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/close_icon2.png"))); // NOI18N

        javax.swing.GroupLayout closeLayout = new javax.swing.GroupLayout(close);
        close.setLayout(closeLayout);
        closeLayout.setHorizontalGroup(
            closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        closeLayout.setVerticalGroup(
            closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        minimize.setBackground(new java.awt.Color(122, 72, 221));
        minimize.setPreferredSize(new java.awt.Dimension(100, 35));
        minimize.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                minimizeMouseDragged(evt);
            }
        });
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minimizeMouseReleased(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/minimize_icon.png"))); // NOI18N

        javax.swing.GroupLayout minimizeLayout = new javax.swing.GroupLayout(minimize);
        minimize.setLayout(minimizeLayout);
        minimizeLayout.setHorizontalGroup(
            minimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );
        minimizeLayout.setVerticalGroup(
            minimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Untitled - Frac Community 2019");

        help.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/information-icon4.png"))); // NOI18N
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

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(help, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(minimize, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(help)
                .addContainerGap())
        );

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        mainPane.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout masterPanelLayout = new javax.swing.GroupLayout(masterPanel);
        masterPanel.setLayout(masterPanelLayout);
        masterPanelLayout.setHorizontalGroup(
            masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masterPanelLayout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        masterPanelLayout.setVerticalGroup(
            masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(masterPanelLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(masterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(masterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        close.setBackground(new Color(204, 0, 0));
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        close.setBackground(new Color(122, 72, 221));
    }//GEN-LAST:event_closeMouseExited

    private void closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseReleased
        if (!dragged) {
            //Save all Data
            System.exit(0);
        }
        dragged = false;
    }//GEN-LAST:event_closeMouseReleased

    private boolean dragged = false;
    private void closeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseDragged
        dragged = true;
    }//GEN-LAST:event_closeMouseDragged

    private void minimizeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseDragged
        dragged = true;
    }//GEN-LAST:event_minimizeMouseDragged

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
        minimize.setBackground(new Color(255, 204, 0));
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        minimize.setBackground(new Color(122, 72, 221));
    }//GEN-LAST:event_minimizeMouseExited

    private void minimizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseReleased
        if (!dragged) {
            setState(Frame.ICONIFIED);
        }
        dragged = false;
    }//GEN-LAST:event_minimizeMouseReleased


    private void previewOptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewOptionMouseEntered
        previewOptionIsHover = true;
        updateOptionUI();
    }//GEN-LAST:event_previewOptionMouseEntered

    private void previewOptionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewOptionMouseExited
        previewOptionIsHover = false;
        updateOptionUI();
    }//GEN-LAST:event_previewOptionMouseExited

    private void previewOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previewOptionMouseClicked
        previewOptionIsActive = true;
        settingsOptionIsActive = editOptionIsActive = wikiOptionIsActive = false;
        updateOptionUI();
        
        setOptionPanel("renderPane");
        
        setUpdated(true);
    }//GEN-LAST:event_previewOptionMouseClicked

    private void settingsOptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsOptionMouseEntered
        settingsOptionIsHover = true;
        updateOptionUI();
    }//GEN-LAST:event_settingsOptionMouseEntered

    private void settingsOptionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsOptionMouseExited
        settingsOptionIsHover = false;
        updateOptionUI();
    }//GEN-LAST:event_settingsOptionMouseExited

    private void settingsOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsOptionMouseClicked
        settingsOptionIsActive = true;
        previewOptionIsActive = editOptionIsActive = wikiOptionIsActive = false;
        updateOptionUI();

        setOptionPanel("settings");
    }//GEN-LAST:event_settingsOptionMouseClicked

    private void editOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editOptionMouseClicked
        editOptionIsActive = true;
        previewOptionIsActive = settingsOptionIsActive = wikiOptionIsActive = false;
        updateOptionUI();

        setOptionPanel("edit");
        
        setUpdated(true);
    }//GEN-LAST:event_editOptionMouseClicked

    private void editOptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editOptionMouseEntered
        editOptionIsHover = true;
        updateOptionUI();
    }//GEN-LAST:event_editOptionMouseEntered

    private void editOptionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editOptionMouseExited
        editOptionIsHover = false;
        updateOptionUI();
    }//GEN-LAST:event_editOptionMouseExited

    private Point initialClick;
    private void topPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMouseDragged
        int thisX = getLocation().x;
        int thisY = getLocation().y;

        int xMoved = evt.getX() - initialClick.x;
        int yMoved = evt.getY() - initialClick.y;

        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        setLocation(X, Y);
    }//GEN-LAST:event_topPanelMouseDragged

    private void topPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMousePressed
        initialClick = evt.getPoint();
        getComponentAt(initialClick);
    }//GEN-LAST:event_topPanelMousePressed

    private void wikiOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wikiOptionMouseClicked
        wikiOptionIsActive = true;
        previewOptionIsActive = settingsOptionIsActive = editOptionIsActive = false;
        updateOptionUI();

        setOptionPanel("wiki");
    }//GEN-LAST:event_wikiOptionMouseClicked

    private void wikiOptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wikiOptionMouseEntered
        wikiOptionIsHover = true;
        updateOptionUI();
    }//GEN-LAST:event_wikiOptionMouseEntered

    private void wikiOptionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wikiOptionMouseExited
        wikiOptionIsHover = false;
        updateOptionUI();
    }//GEN-LAST:event_wikiOptionMouseExited

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        initialClick = evt.getPoint();
        getComponentAt(initialClick);
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseDragged
        int thisX = getLocation().x;
        int thisY = getLocation().y;

        int xMoved = evt.getX() - initialClick.x;
        int yMoved = evt.getY() - initialClick.y;

        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        setLocation(X, Y);
    }//GEN-LAST:event_jLabel7MouseDragged

    private void helpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseClicked
        Window.previewOptionIsActive = false;
        Window.settingsOptionIsActive = false;
        Window.editOptionIsActive = false;
        Window.wikiOptionIsActive = false;
        updateOptionUI();

        Window.setOptionPanel("info");
    }//GEN-LAST:event_helpMouseClicked

    private void helpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseEntered
        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/information-icon3.png")));
    }//GEN-LAST:event_helpMouseEntered

    private void helpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMouseExited
        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ml/mindprojects/frac/community/main/ui/assets/information-icon4.png")));
    }//GEN-LAST:event_helpMouseExited

    public static void setOptionPanel(String panel) {
        CardLayout layout = (CardLayout) mainPane.getLayout();
        layout.show(mainPane, panel);
    }

    public void updateOptionUI() {
        if (previewOptionIsActive) {
            previewOption.setBackground(optionActiveColor);
        } else if (previewOptionIsHover) {
            previewOption.setBackground(optionHoverColor);
        } else {
            previewOption.setBackground(optionDefaultColor);
        }

        if (settingsOptionIsActive) {
            settingsOption.setBackground(optionActiveColor);
        } else if (settingsOptionIsHover) {
            settingsOption.setBackground(optionHoverColor);
        } else {
            settingsOption.setBackground(optionDefaultColor);
        }

        if (editOptionIsActive) {
            editOption.setBackground(optionActiveColor);
        } else if (editOptionIsHover) {
            editOption.setBackground(optionHoverColor);
        } else {
            editOption.setBackground(optionDefaultColor);
        }

        if (wikiOptionIsActive) {
            wikiOption.setBackground(optionActiveColor);
        } else if (wikiOptionIsHover) {
            wikiOption.setBackground(optionHoverColor);
        } else {
            wikiOption.setBackground(optionDefaultColor);
        }
    }

    public static boolean updated() {
        return Settings.updated || Edit.updated || RenderPane.updated;
    }

    public static void setUpdated(boolean set) {
        Settings.updated = set;
        Edit.updated = set;
        RenderPane.updated = set;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel close;
    private javax.swing.JPanel editOption;
    private javax.swing.JLabel help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JPanel mainPane;
    private javax.swing.JPanel masterPanel;
    private javax.swing.JPanel minimize;
    private javax.swing.JPanel previewOption;
    private javax.swing.JPanel settingsOption;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel wikiOption;
    // End of variables declaration//GEN-END:variables
}
