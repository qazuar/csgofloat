package ui;

import javax.swing.*;
import java.awt.*;

public class UI {

    private final static String TITLE = "CSGO FLOAT";
    private final String VERSION = "1.0.0";

    private JFrame frame;

    private JMenuBar menuBar;
    private JMenu file, help;

    public static void main(String[] args) {
        new UI(TITLE, null);
    }

    private UI(String title, Object any) {
        setDefaultUI(new javax.swing.plaf.FontUIResource(Font.SANS_SERIF, Font.PLAIN, 11));

        this.frame = new JFrame(title);
        this.frame.setPreferredSize(new Dimension(500, 500));

        init();
    }

    private void init() {
        buildMenu();

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    private void buildMenu() {
        this.menuBar = new JMenuBar();

        this.file = new JMenu("File");

        JMenuItem exit = new JMenuItem("Exit");

        this.file.add(exit);

        this.menuBar.add(file);

        this.frame.setJMenuBar(menuBar);
    }

    private void setDefaultUI(javax.swing.plaf.FontUIResource f) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            try {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e2) {
                System.out.println("Could not set look and feel");
            }
        }

        java.util.Enumeration keys = UIManager.getDefaults().keys();

        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                //System.out.println(value);
                UIManager.put(key, f);
        }
    }
}
