package nl.uva.softwcons.ql.ui.layout;

import javafx.scene.Node;

public interface Renderer {

    void add(QuestionLayout node);

    Node getNode();
}
