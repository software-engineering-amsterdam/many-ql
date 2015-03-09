package org.uva.sea.ql.encoders.ui;

import java.beans.PropertyChangeListener;

import javafx.scene.control.Control;

public interface ControlWrapper extends PropertyChangeListener {
	abstract Control getControl();
}
