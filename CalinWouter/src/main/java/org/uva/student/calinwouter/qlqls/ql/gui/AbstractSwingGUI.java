package org.uva.student.calinwouter.qlqls.ql.gui;

import javax.swing.*;
import java.awt.*;

/**
 * This abstract GUI renderer makes no assumption about the behaviour of the implemented GUI,
 * except that the rendering takes place on a JFrame and uses Swing.
 */
public abstract class AbstractSwingGUI{
    private static final Integer
            DEFAULT_WINDOW_WIDTH  = 800,
            DEFAULT_WINDOW_HEIGHT = 600;

    protected JFrame frame;

    protected Integer getDefaultWidth() {
        return DEFAULT_WINDOW_WIDTH;
    }

    protected Integer getDefaultHeight() {
        return DEFAULT_WINDOW_HEIGHT;
    }

    /**
     * Render a form embedded with the provided component.
     */
    public void render() {
        frame = new JFrame(getFrameTitle());
        final Dimension windowDimension = new Dimension(getDefaultWidth(), getDefaultHeight());
        final Container contentPane = frame.getContentPane();
        frame.setPreferredSize(windowDimension);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane.add(renderFrameContent());
        frame.pack();
        frame.setVisible(true);
    }

    protected abstract String getFrameTitle();

    protected abstract Component renderFrameContent();
}
