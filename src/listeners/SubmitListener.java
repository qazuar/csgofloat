package listeners;

import model.DataMapper;
import model.ItemObj;
import ui.Enricher;
import ui.SearchPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitListener implements ActionListener {

    private SearchPanel panel;
    private Enricher enricher;

    public SubmitListener(SearchPanel panel) {
        this.panel = panel;
        this.enricher = new Enricher(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String link = panel.getInsertLink().getText();

        if (validateLink(link)) {
            ItemObj item = DataMapper.getItem(link);
            enricher.build(item);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid link");
        }
    }

    private boolean validateLink(String link) {
        if (!link.contains("steam://rungame/730") || link.contains("%")) {
            return false;
        }

        return true;
    }
}
