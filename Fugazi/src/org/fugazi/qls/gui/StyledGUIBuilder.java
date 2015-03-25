package org.fugazi.qls.gui;

import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class StyledGUIBuilder {
    QLSStyleSheetDataStorage data;

    private JFrame formFrame;
    private JTabbedPane mainPanel;

    public StyledGUIBuilder(QLSStyleSheetDataStorage _data) {
        this.data = _data;

        this.formFrame = new JFrame("QLS");
        this.formFrame.setSize(600, 580);
        this.formFrame.setLocationRelativeTo(null);
        this.formFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.formFrame.setResizable(false);

        this.mainPanel = new JTabbedPane();

        this.prepareForm();
        this.render();
    }

    private void prepareForm() {
        for (Page page : this.data.getPages()) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(0, 1));


            java.util.List<Section> sections = page.getSections();
            for (Section section : sections) {
                panel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);
                panel.add(new JLabel(section.getName()));
                panel.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);
            }

            mainPanel.addTab(page.getName(), panel);
        }
    }

    public void render() {
        this.formFrame.add(mainPanel);
        this.formFrame.setVisible(true);
    }
}