package nl.uva.sc.encoders.qlruntime.ui.control;

import java.beans.PropertyChangeListener;

import javafx.scene.control.Control;

public interface ControlPropertyChangeWrapper extends PropertyChangeListener {
	abstract Control getControl();
}
