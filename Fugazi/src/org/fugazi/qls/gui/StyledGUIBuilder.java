package org.fugazi.qls.gui;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.gui.ui_segment.JPage;

import javax.swing.*;
import java.awt.*;

public class StyledGUIBuilder {
    QLSStyleSheetDataStorage data;

    private final QlsUIFormManager uiFormManager;

    public StyledGUIBuilder(Form _form, QLSStyleSheetDataStorage _data) {
        this.data = _data;
        this.uiFormManager = new QlsUIFormManager(_form.getName(), new QlsUIPanel());

        this.prepareForm();
    }

    private void prepareForm() {
        for (Page page : this.data.getPages()) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(0, 1));

            this.uiFormManager.addPage(
                    new JPage(panel, page.getName())
            );
//
//            java.util.List<Section> sections = page.getSections();
//            for (Section section : sections) {
//                System.out.println(page.getName() + " " + section.getName());
//            }
        }
    }

    public void render() {
        this.uiFormManager.render();
    }
}