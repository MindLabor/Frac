package com.mindlabor.frac.main;

import com.mindlabor.frac.main.ui.Window;

public class Main 
{
    public static Window window;
    public static final int AVAILABLE_CORES = Runtime.getRuntime().availableProcessors();
    public static boolean pluginMode = false;
            
    public static void main(String args[]) {
        new Main();
    }
    
    public Main() {
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
