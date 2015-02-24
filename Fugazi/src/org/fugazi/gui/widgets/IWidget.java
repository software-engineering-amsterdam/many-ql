package org.fugazi.gui.widgets;

import javax.swing.*;
import java.util.EventListener;

public interface IWidget {

    /**
     * Get the Java Swing implementation.
     */
    public JComponent getJComponent();

    public void addEventListener(EventListener listener);
}
