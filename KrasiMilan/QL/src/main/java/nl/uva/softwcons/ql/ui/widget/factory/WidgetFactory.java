package nl.uva.softwcons.ql.ui.widget.factory;

import nl.uva.softwcons.ql.ast.statement.Question;
import nl.uva.softwcons.ql.ui.widget.Widget;

public interface WidgetFactory {
    Widget getWidget(Question question);
}
