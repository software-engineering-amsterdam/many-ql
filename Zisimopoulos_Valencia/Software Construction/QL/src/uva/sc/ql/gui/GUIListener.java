package uva.sc.ql.gui;

import java.awt.Component;
import java.util.List;

public abstract class GUIListener {

    public Component getComponentByName(String name, List<Component> componentList ) {
	Component result = null;
	for (Component component : componentList) {
	    if (name.equals(component.getName())) {
		result = component;
	    }
	}
	return result;
    }
}
