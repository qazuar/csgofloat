package ui;

import listeners.SubmitListener;

import javax.swing.*;
import java.awt.*;

public class SearchPanel {

    private UI ui;

    private JPanel panel;

    private HintTextField insertLink;

    private JButton submit;

    public SearchPanel(UI ui) {
        this.ui = ui;
        this.insertLink = new HintTextField("insert link");
        this.insertLink.setPreferredSize(new Dimension(300, 25));
        this.submit = new JButton("Submit");
        this.submit.addActionListener(new SubmitListener(this));
    }

    public JPanel build() {
        this.panel = new JPanel();
        //this.panel.setPreferredSize(ui.getFrame().getPreferredSize());
        //this.panel.setBackground(Color.decode("#acacac"));

        this.panel.add(insertLink);
        this.panel.add(submit);


        FlowLayout layout = new FlowLayout();
        layout.setVgap(2);

        this.panel.setLayout(layout);

        return this.panel;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public JButton getSubmit() {
        return this.submit;
    }

    public HintTextField getInsertLink() {
        return this.insertLink;
    }
}
