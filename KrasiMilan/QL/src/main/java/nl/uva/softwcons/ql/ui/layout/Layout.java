package nl.uva.softwcons.ql.ui.layout;

import javafx.scene.Node;

public interface Layout {
    void add(Layout layout);

    Node getNode();
}
