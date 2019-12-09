package listeners;

import enums.ApiEnum;
import model.DataMapper;
import model.ItemObj;
import model.MarketItemObj;
import ui.Enricher;
import ui.SearchPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
        int linkType = getLinkType(link);

        if (linkType > 0) {
            switch (linkType) {
                case 1:
                    ItemObj item = DataMapper.getItem(link);
                    enricher.build(item);
                    break;
                case 2:
                    List<MarketItemObj> marketItems = DataMapper.getMarketItems(link.replace(ApiEnum.STEAM_COMMUNITY_ADDRESS.getPath(), ""));
                    enricher.build(marketItems);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid link");
        }
    }

    private int getLinkType(String link) {
        if (link.contains("steam://rungame/730")) {
            return 1;
        } else if (link.contains("market")) {
            return 2;
        }

        return 0;
    }
}
