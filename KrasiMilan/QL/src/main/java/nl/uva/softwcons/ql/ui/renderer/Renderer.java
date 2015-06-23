package nl.uva.softwcons.ql.ui.renderer;

import nl.uva.softwcons.ql.ui.layout.Layout;
import nl.uva.softwcons.ql.ui.layout.QuestionLayout;

public interface Renderer {
    void add(QuestionLayout questionLayout);

    Layout getLayout();
}
