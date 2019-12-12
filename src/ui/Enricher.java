package ui;

import model.DataMapper;
import model.ItemObj;
import model.MarketItemObj;
import utils.ImageUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Enricher {

    private SearchPanel panel;
    private ItemObj item;
    private java.util.List<MarketItemObj> items;

    private java.util.List<Component> components = new ArrayList<>();

    public Enricher(SearchPanel panel) {
        this.panel = panel;
    }

    public void build(ItemObj item) {
        this.item = item;
        clearComponents();

        String paintSeed = String.valueOf(item.getPaintSeed());
        String patternName = item.getPatternName();
        paintSeed = patternName == null ? paintSeed : paintSeed + "(" + patternName + ")";

        addImageLabel();
        addDataLabel("Name:", item.getFullItemNameClean());
        addDataLabel("Exterior:", item.getExterior());
        addDataLabel("Rarity:", item.getRarityName());
        addDataLabel("Float value:", item.getFloatValue());
        addDataLabel("Paint index:", String.valueOf(item.getPaintIndex()));
        addDataLabel("Paint seed:", paintSeed);
        addDataLabel("Origin:", item.getOriginName());

        panel.getPanel().revalidate();
        panel.getPanel().repaint();
    }

    public void build(java.util.List<MarketItemObj> items) {
        panel.getSubmit().setEnabled(false);

        this.items = items;
        clearComponents();

        Thread thread = new Thread(new ThreadedEnricher(this));
        thread.start();
    }

    protected void build() {
        int id = 1;
        DecimalFormat df = new DecimalFormat("###.#####");

        for (MarketItemObj mItem : items) {
            ItemObj i = DataMapper.getItem(mItem.getInspectLink());

            String fv = df.format(Double.parseDouble(i.getFloatValue()));

            String paintSeed = i.getPatternName();
            paintSeed = paintSeed == null ? String.valueOf(i.getPaintSeed()) : paintSeed;

            addDataArgsLabel("#" + id + " " + i.getFullItemNameClean(), fv, paintSeed, String.valueOf(i.getPaintIndex()), mItem.getPrice());

            id ++;
        }

        panel.getPanel().revalidate();
        panel.getPanel().repaint();

        panel.getSubmit().setEnabled(true);
    }

    private void addImageLabel() {
        JLabel imageLabel = null;

        try {
            URL url = new URL(item.getImageUrl());
            BufferedImage image = ImageIO.read(url.openStream());
            image = ImageUtil.resize(image, 384, 288);
            imageLabel = new JLabel(new ImageIcon(image));
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        panel.getPanel().add(imageLabel);
        components.add(imageLabel);
    }

    private void addDataLabel(String text, String value) {
        Font textFont = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        Font valueFont = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
        JLabel jtext = new JLabel(text);
        JLabel jvalue = new JLabel(value);

        jtext.setPreferredSize(new Dimension(110, 25));
        jtext.setFont(textFont);
        jvalue.setPreferredSize(new Dimension(210, 25));
        jvalue.setFont(valueFont);

        panel.getPanel().add(jtext);
        panel.getPanel().add(jvalue);

        components.add(jtext);
        components.add(jvalue);
    }

    private void addDataArgsLabel(String...args) {
        Font textFont = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
        JLabel jtext = new JLabel();
        jtext.setFont(textFont);

        jtext.setPreferredSize(new Dimension(350, 20));
        jtext.setHorizontalAlignment(SwingConstants.LEFT);

        String text = "";

        for (String s : args) {
            text += s + "    ";
        }

        jtext.setText(text);

        panel.getPanel().add(jtext);
        components.add(jtext);
    }

    private void clearComponents() {
        for (Component c : components) {
            panel.getPanel().remove(c);
        }
    }
}

class ThreadedEnricher implements Runnable {

    private Enricher enricher;

    ThreadedEnricher(Enricher enricher) {
        this.enricher = enricher;
    }

    @Override
    public void run() {
        enricher.build();
    }
}
