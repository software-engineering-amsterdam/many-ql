package org.fugazi.qls.gui;

import org.fugazi.ql.gui.ui_elements.UIForm;
import org.fugazi.qls.gui.ui_segment.JPage;

public class QlsUIForm extends UIForm {
    private QlsUIPanel qlsUIPanel;

    public QlsUIForm(String _formTitle, QlsUIPanel _panel) {
        super(_formTitle, _panel);
        this.qlsUIPanel = _panel;
    }


//    public void addWidget(JComponent _component) {
//        this.panel.add(_component);
//        this.formFrame.revalidate();
//    }
//
//    public void removeWidget(JComponent _component) {
//        this.panel.remove(_component);
//        this.formFrame.revalidate();
//    }

    public void addPage(JPage _page) {
        this.qlsUIPanel.addPage(_page.getPanel(), _page.getTitle());
    }
}
