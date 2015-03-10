package edu.gui;

import edu.gui.components.CheckBox;
import edu.gui.components.TextBox;

/**
 * Created by Steven Kok on 09/03/2015.
 */
public interface Observer {

    public void update(TextBox textBox);

    void update(CheckBox checkBox);
}
