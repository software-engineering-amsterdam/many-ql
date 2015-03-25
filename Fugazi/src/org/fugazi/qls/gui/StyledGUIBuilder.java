package org.fugazi.qls.gui;

import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;

import javax.swing.*;
import java.awt.*;

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

        GridLayout layout = new GridLayout(0, 1);
        for (Page page : this.data.getPages()) {
            System.out.println(page);
            JPanel panel = new JPanel();
            mainPanel.addTab(page.getName(), panel);
        }
    }

    public void render() {
        this.formFrame.add(mainPanel);
        this.formFrame.setVisible(true);
    }
}