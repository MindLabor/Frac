package com.mindlabor.frac.pmanager;

import com.mindlabor.frac.main.Main;
import com.mindlabor.frac.pmanager.FracPlugin.InputComponent.*;
import java.util.ArrayList;

public abstract class FracPlugin 
{
    public static FracPlugin self; 
    private ArrayList<Object[]> settingsTableData = new ArrayList<Object[]>();
    public javax.swing.JTable table;
    
    public FracPlugin() {
        Main.pluginMode = true;
        init();
        table = loadTable();
        self = this;
        new Main();
    }
    
    public abstract void init();
    
    private javax.swing.JTable loadTable() {
        Object[][] data = new Object[settingsTableData.size()][settingsTableData.get(0).length];
        for (int i=0; i<settingsTableData.size(); i++) {
            data[i] = settingsTableData.get(i);
        }
        return new javax.swing.JTable(data, new String[]{"Setting", "Description", "Value"});
    }
    
    public void use(Setting setting){
        settingsTableData.add(new Object[] {setting.name, setting.desc, setting.input});
    }
    
    public void use(Setting[] settings){
        for (Setting setting : settings)
            use(setting);
    }
    
    public Slider Slider(double min, double max, double step){
        return new InputComponent().new Slider(min, max, step);
    }
    
    public DoubleNumber DoubleNumber(double num){
        return new InputComponent().new DoubleNumber(num);
    }
    
    public IntNumber IntNumber(int num){
        return new InputComponent().new IntNumber(num);
    }
    
    public class Setting {
        public Setting(String name, String desc, InputComponent ic) {this.name = name; this.desc = desc; input = ic;}
        protected String name;
        protected String desc;
        protected InputComponent input;
    }
    
    
    public class InputComponent {
        public class Slider extends InputComponent {
            public Slider(double min, double max, double step){this.min = min; this.max = max; this.step = step;}
            protected double min, max, step;
        }
        public class DoubleNumber extends InputComponent {
            public DoubleNumber(double num){this.num = num;}
            protected double num;
        }
        public class IntNumber extends InputComponent {
            public IntNumber(int num){this.num = num;}
            protected int num;
        }
    }
}
