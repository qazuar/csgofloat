package ui;

import listeners.MExitListener;

import javax.swing.*;
import java.awt.*;

public class UI {

    /*
            String data = null;

        try {
            data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
        } catch (IOException e) {
        }

        System.out.println(data);
        //ItemObj item = DataMapper.getItem("steam://rungame/730/76561202255233023/+csgo_econ_action_preview%20M2646353517640087992A16878067099D14739836218185522367");
        //ItemObj item = DataMapper.getItem("steam://rungame/730/76561202255233023/+csgo_econ_action_preview%20S76561198018551044A16150356934D6957723464052024574");
        //steam://rungame/730/76561202255233023/+csgo_econ_action_preview%20M1933656880277202286A14818571315D7235154318050096329

        steam://rungame/730/76561202255233023/+csgo_econ_action_preview%20M1917896822095534739A 16970919548  D7962401646706473043
        steam://rungame/730/76561202255233023/+csgo_econ_action_preview%20M1917896822095534739A %assetid%    D7962401646706473043

        steam://rungame/730/76561202255233023/+csgo_econ_action_preview%20M1930280363025033830A16970919548D17044451657020905683

        System.out.println(item.getFullItemName());
        System.out.println(String.format("%s -> Range: %s, %s", item.getFloatValue(), item.getMinFloat(), item.getMaxFloat()));
    }
     */

    private final static String TITLE = "CS:GO Float (API) UI";
    private final String VERSION = "1.1.0";

    private JFrame frame;

    private JMenuBar menuBar;
    private JMenu file, help;

    public static void main(String[] args) {
        new UI(TITLE, null);
    }

    private UI(String title, Object any) {
        setDefaultUI(new javax.swing.plaf.FontUIResource(Font.SANS_SERIF, Font.PLAIN, 11));

        this.frame = new JFrame(title);
        this.frame.setPreferredSize(new Dimension(400, 600));

        init();
    }

    private void init() {
        buildMenu();

        SearchPanel main = new SearchPanel(this);

        this.frame.add(main.build());

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    private void buildMenu() {
        this.menuBar = new JMenuBar();


        // File
        this.file = new JMenu("File");

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new MExitListener());

        this.file.add(exit);

        // Help
        this.help = new JMenu("Help");

        JMenuItem about = new JMenuItem("About");

        this.help.add(about);

        this.menuBar.add(file);
        this.menuBar.add(help);

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

    public JFrame getFrame() {
        return this.frame;
    }
}
