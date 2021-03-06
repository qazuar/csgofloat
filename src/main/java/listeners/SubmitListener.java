package main.java.listeners;

import main.java.enums.ApiEnum;
import main.java.model.MarketObj;
import main.java.model.Receiver;
import main.java.model.ItemObj;
import main.java.ui.Enricher;
import main.java.ui.SearchPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitListener implements ActionListener {

    private SearchPanel panel;
    private Enricher enricher;
    private Receiver receiver;

    public SubmitListener(SearchPanel panel) {
        this.panel = panel;
        this.receiver = new Receiver();
        this.enricher = new Enricher(panel, this.receiver);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String link = panel.getInsertLink().getText();
        int linkType = getLinkType(link);

        if (linkType > 0) {
            switch (linkType) {
                case 1:
                    ItemObj item = receiver.getItem(link);
                    enricher.build(item);
                    break;
                case 2:
                    MarketObj marketObj = receiver.getMarketObject(link.replace(ApiEnum.STEAM_COMMUNITY_ADDRESS.getPath(), ""), 30);
                    enricher.build(marketObj.getItems());
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid link");
        }
    }

    private int getLinkType(String link) {
        if (link.contains("steam://rungame/730")) {
            return 1;
        } else if (link.contains("market/listings/730")) {
            return 2;
        }

        return 0;
    }
}
