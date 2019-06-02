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
package ml.mindprojects.frac.community.main;

import ml.mindprojects.frac.community.main.ui.Window;

/**
 *
 * @author Samuel Braun <MindProjects at www.mindprojects.ml>
 */
public class Main 
{
    public static Window window;
    public static final int AVAILABLE_CORES = Runtime.getRuntime().availableProcessors();
            
    public static void main(String args[]){
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(() -> {
            window = new Window();
            window.setVisible(true);
        });
        
    }
    
}
