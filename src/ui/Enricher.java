package ui;

import model.ItemObj;
import utils.ImageUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Enricher {

    private SearchPanel panel;
    private ItemObj item;

    private java.util.List<Component> components = new ArrayList<>();

    public Enricher(SearchPanel panel) {
        this.panel = panel;
    }

    public void build(ItemObj item) {
        this.item = item;
        clearComponents();

        addImageLabel();
        addDataLabel("Name:", item.getFullItemNameClean());
        addDataLabel("Exterior:", item.getExterior());
        addDataLabel("Rarity:", item.getRarityName());
        addDataLabel("Float value:", item.getFloatValue());
        addDataLabel("Paint index:", item.getPaintIndex());
        addDataLabel("Paint seed:", item.getPaintSeed());
        addDataLabel("Origin:", item.getOriginName());

        panel.getPanel().revalidate();
        panel.getPanel().repaint();
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

    private void clearComponents() {
        for (Component c : components) {
            panel.getPanel().remove(c);
        }
    }
}