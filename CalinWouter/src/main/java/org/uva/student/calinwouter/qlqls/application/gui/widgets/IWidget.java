package org.uva.student.calinwouter.qlqls.application.gui.widgets;

import java.awt.*;

public interface IWidget {

    /**
     * Get the widget's Swing/AWT component.
     */
    public Component getWidgetComponent();

    public void resetValue();
}
