package org.uva.student.calinwouter.qlqls.application.gui.qls.widgets;

import org.uva.student.calinwouter.qlqls.qls.model.IModel;

import java.awt.*;

public interface IWidget<T extends IModel> {

    public Component getWidget();

}
