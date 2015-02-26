package org.fugazi.gui.widgets;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemListener;

public interface IWidget <T> {

    /**
     * Get the Java Swing implementation.
     */
    public JComponent getJComponent();
    
    public T getValue();
    
    // Todo: think of that. (Smells)
    public void addItemListener(ItemListener _listener); // Use it on bool
    public void addDocumentListener(DocumentListener _listener); // Use it on text
}
