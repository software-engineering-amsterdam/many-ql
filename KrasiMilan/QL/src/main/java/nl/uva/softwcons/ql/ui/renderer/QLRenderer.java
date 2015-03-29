package nl.uva.softwcons.ql.ui.renderer;

import nl.uva.softwcons.ql.ui.layout.FormLayout;
import nl.uva.softwcons.ql.ui.layout.Layout;
import nl.uva.softwcons.ql.ui.layout.QuestionLayout;

public class QLRenderer implements Renderer {
    private final FormLayout formLayout;

    public QLRenderer() {
        this.formLayout = new FormLayout();
    }

    @Override
    public void add(QuestionLayout questionLayout) {
        formLayout.add(questionLayout);
    }

    @Override
    public Layout getLayout() {
        return this.formLayout;
    }

}
